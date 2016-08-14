mapZoomLevel = 16;
map = null;
markerInit=null;
address = []; // the address will contain all the address data in array. bigger place will be at higher index of address
currentlyEmittedAddressIndex = -1;
addressString = "";// address in form of string when found from address array
infoWindow="";
bounds=null;
markers = [];

// directions
directionsService = null;
directionsDisplay = null;

// Location for Pratian
locationPratian = [
					{
						locInitLat : 12.91773731882499,
						locInitLng : 77.62195877730846,
						locInitTitle : "PRATIAN Technologies </br> #186/2, Tapaswiji Arcade, Hosur Main Road, BTM 1st Stage, Near Central Silk Board, Bengaluru, Karnataka 560076, India"
					},
					{
						locInitLat : 28.615656, 
						locInitLng : -82.390514,
						locInitTitle : "Global Edify Florida."
					},
					{
						locInitLat : 21.215024, 
						locInitLng : 81.317404,
						locInitTitle : "Global Edify Chhattishgadh"
					}
				];

// function to initialize map (single map on a page) on profile pages of different actors
function initMapData() {

	// pratian - bangalore location
	var location = new google.maps.LatLng(locationPratian[0].locInitLat, locationPratian[0].locInitLng);

	map = new google.maps.Map(document.getElementById('map'), {
		center: location,
		zoom: mapZoomLevel,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	
	// Tool Tip window
	infoWindow = new google.maps.InfoWindow();

	if(document.getElementById("pac-input") != null)
		document.getElementById("pac-input").style.display = "none";
	/*
	 * Remove this comment if you want to put search box and comment the above line
		// Create the search box and link it to the UI element.
		var input = document.getElementById('pac-input');
		var searchBox = new google.maps.places.SearchBox(input);
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
	
		// Bias the SearchBox results towards current map's viewport.
		map.addListener('bounds_changed', function() {
			searchBox.setBounds(map.getBounds());
		});
	*/
	
	createInitialMarker(0, map);
	
	/*
	 * Remove this block comment if search box is required
		// [START region_getplaces]
		// Listen for the event fired when the user selects a prediction and retrieve more details for that place.
		searchBox.addListener('places_changed', function() {
			var places = searchBox.getPlaces();
	
			if (places.length == 0) {
				return;
			}
	
			deleteMarkers();
	
			// For each place, get the icon, name and location.
			places.forEach(function(place) {
				var icon = {
						url: place.icon,
						size: new google.maps.Size(71, 71),
						origin: new google.maps.Point(0, 0),
						anchor: new google.maps.Point(17, 34),
						scaledSize: new google.maps.Size(25, 25)
				};
	
				// Create a marker for each place.
				markers.push(new google.maps.Marker({
					map: map,
					title: place.name,
					position: place.geometry.location,
					animation:google.maps.Animation.DROP
				}));
	
				if (place.geometry.viewport) {
					// Only geocodes have viewport.
					bounds.union(place.geometry.viewport);
				} else {
					bounds.extend(place.geometry.location);
				}
			});
			
			map.fitBounds(bounds);
			
		});
		// [END region_getplaces]
	*/
}

//function to initialize multiple maps on home page
function initMultipleMapData(){

	for(var index = 0; index < locationPratian.length; index++){
		var location = new google.maps.LatLng(locationPratian[index].locInitLat, locationPratian[index].locInitLng);
		var map = new google.maps.Map(document.getElementById('map' + index), {
			center: location,
			zoom: mapZoomLevel,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		});
		createInitialMarker(index, map);
	}
}

// Search a location using text address in map (applicable only for single map)
// Example:   searchLocationOnMap("Bangalore");
function searchLocationOnMap(locationString){

	if(map){
		var request = {
			query: locationString
		};
		
		service = new google.maps.places.PlacesService(map);
		service.textSearch(request, callBackForSearchLocation);		
	}
}

// Call back function for search location 
function callBackForSearchLocation(results, status){
	if (status === google.maps.places.PlacesServiceStatus.OK){
		if(results.length > 0){
			deleteMarkers();
		}
		for (var i = 0; i < results.length; i++){
			createMarker(results[i]);
		}
		bounds.extend(markerInit.position);
		map.fitBounds(bounds);
	}
}

// call search location function when address is passed as array
function callSearchLocation(){
	if("undefined" != address && null != address && 0 < address.length && currentlyEmittedAddressIndex < address.length-1){
		addressString = address.slice(currentlyEmittedAddressIndex + 1,address.length).join(" ");
		currentlyEmittedAddressIndex ++;
		searchLocationOnMapAddressArray(addressString);
	}
}

//Search a location using text address, to identify the searchable address
function searchLocationOnMapAddressArray(locationString){
	var request = {
		query: locationString
	};
	service = new google.maps.places.PlacesService(document.getElementById('map-button'));
	service.textSearch(request, callBackForSearchLocationAddressArray);		
}

// call  back function for search location, to identify the searchable address
function callBackForSearchLocationAddressArray(results, status){
	if (status === google.maps.places.PlacesServiceStatus.OK){
		if(results.length > 0){
			$("#map-button").attr("src", generateMapImageLink(results[0].geometry.location.lat(), results[0].geometry.location.lng(), 160, 48, 13));
		}else{
			callSearchLocation();
		}
	}else{
		callSearchLocation();
	}
}

// function to create a marker for input location (applicable only for single map)
function createMarker(place){
	var placeLoc = place.geometry.location;	
	var marker = new google.maps.Marker({
		map: map,
		position: place.geometry.location,
		animation:google.maps.Animation.DROP
	});
	markers.push(marker);
	
	// To show all the markers in the viewport
	bounds.extend(placeLoc);

	google.maps.event.addListener(marker, 'mouseover', function() {
		infoWindow.setContent(place.name + "<br />" + place.formatted_address);
		infoWindow.open(map, this);
	 });
	google.maps.event.addListener(marker, 'mouseout', function() {
		infoWindow.setContent(place.name + "<br />" + place.formatted_address);
		infoWindow.close();
	 });
	
	google.maps.event.addListener(marker, 'click', function() {
		if(null != markerInit && marker != markerInit){
			// get route
			if(null == directionsService){
				directionsService = new google.maps.DirectionsService;
				directionsDisplay = new google.maps.DirectionsRenderer({suppressMarkers: true});
			}
			directionsDisplay.setMap(null);
			directionsDisplay.setMap(map);
			calculateAndDisplayRoute(directionsService, directionsDisplay, marker.getPosition(), markerInit.getPosition());
		}
	 });
	
	//map.setCenter(placeLoc);
}

// function to get route between two points and render it on map
function calculateAndDisplayRoute(directionsService, directionsDisplay, startPoint, endPoint){
	directionsService.route({
	    origin: startPoint,
	    destination: endPoint,
	    travelMode: google.maps.TravelMode.WALKING,
	    optimizeWaypoints: true
	}, function(response, status) {
		if (status === google.maps.DirectionsStatus.OK) {
			directionsDisplay.setDirections(response);
	    } else {
	    	window.alert('Directions request failed due to ' + status);
	    }
	});
}


// Delete all markers except the initial one. [initial marker isn't stored in the marker array] (applicable only for single map)
function deleteMarkers() {
	// clear all markers from map
	for (var i = 0; i < markers.length; i++) {
	    markers[i].setMap(null);
	}
	markers = [];
	
	bounds = new google.maps.LatLngBounds();
}

// Create initial marker [ location of Pratian ]
function createInitialMarker(index, mapCurrent){
	
	if(index >= locationPratian.length || index < 0)
		return;

	// Create Marker for the initial position
	var marker=new google.maps.Marker({
		map: mapCurrent,
		icon: "img/map-marker-custom.png",
		position:new google.maps.LatLng(locationPratian[index].locInitLat, locationPratian[index].locInitLng),
		animation:google.maps.Animation.DROP
	});

	markerInit = marker;
	
	var infowindow = new google.maps.InfoWindow({
		content:locationPratian[index].locInitTitle
	});

	// infowindow.open(map,marker);
	// If the toolTip to be shwon after clicking marker, comment the above line and un-comment the below 3 lines
	google.maps.event.addListener(marker, 'mouseover', function() {
		infowindow.open(mapCurrent,marker);
	});	
	google.maps.event.addListener(marker, 'mouseout', function() {
		infowindow.close();
	});
	
}

// generate link for loading map image
function generateMapImageLink(locLat, locLng, imgWidth, imgHeight, zoom){
	var url = "https://maps.googleapis.com/maps/api/staticmap?";
	url += ("center=" + locLat + "," + locLng);
	url += ("&size=" + imgWidth + "x" + imgHeight);
	url += ("&zoom=" + zoom);
	url += ("&markers=" + locLat + "," + locLng);
	// url += ("&key=YOUR_API_KEY");
	return url;
}


function getUserAddress(data){
	address = data.split('^'); // ^ is separator for the address lines (this will not be allowed in the address fields)
	currentlyEmittedAddressIndex = -1;
	callSearchLocation();
}
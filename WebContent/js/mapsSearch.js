mapZoomLevel = 16;
map = null;
infoWindow = "";
bounds = null;
markers = [];

// directions
directionsService = null;
directionsDisplay = null;



// function to initialize map (single map on a page) on profile pages of different actors
function initMapData() {

    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: -34.397, lng: 150.644 },
        zoom: 1,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    // Tool Tip window
    infoWindow = new google.maps.InfoWindow();

    if (document.getElementById("pac-input") != null)
        document.getElementById("pac-input").style.display = "none";
    //  // Remove this comment if you want to put search box and comment the above line
    //      // Create the search box and link it to the UI element.
    //      var input = document.getElementById('pac-input');
    //      var mapSearch = new google.maps.places.mapSearch(input);
    //      map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
    //  
    //      // Bias the mapSearch results towards current map's viewport.
    //      map.addListener('bounds_changed', function() {
    //          mapSearch.setBounds(map.getBounds());
    //      });



    // Remove this block comment if search box is required
    // [START region_getplaces]
    // Listen for the event fired when the user selects a prediction and retrieve more details for that place.
    //      mapSearch.addListener('places_changed', function() {
    //          var places = mapSearch.getPlaces();
    //  
    //          if (places.length == 0) {
    //              return;
    //          }
    //  
    //          deleteMarkers();
    //  
    //          // For each place, get the icon, name and location.
    //          places.forEach(function(place) {
    //              var icon = {
    //                      url: place.icon,
    //                      size: new google.maps.Size(71, 71),
    //                      origin: new google.maps.Point(0, 0),
    //                      anchor: new google.maps.Point(17, 34),
    //                      scaledSize: new google.maps.Size(25, 25)
    //              };
    //  
    //              // Create a marker for each place.
    //              markers.push(new google.maps.Marker({
    //                  map: map,
    //                  title: place.name,
    //                  position: place.geometry.location,
    //                  animation:google.maps.Animation.DROP
    //              }));
    //  
    //              if (place.geometry.viewport) {
    //                  // Only geocodes have viewport.
    //                  bounds.union(place.geometry.viewport);
    //              } else {
    //                  bounds.extend(place.geometry.location);
    //              }
    //          });
    //          
    //          map.fitBounds(bounds);
    //          
    //      });
    //      // [END region_getplaces]
}

// call search location function when address is passed as array
function callSearchLocation() {
    var address = data[currentlySearchingIndex].mapSearchableAddress;
    var currentlyEmittedAddressIndex = data[currentlySearchingIndex].mapSearchableAddressEmittedAddress
    if ("undefined" != typeof address && null != address && 0 < address.length && currentlyEmittedAddressIndex < address.length - 1) {
        data[currentlySearchingIndex].addressString = address.slice(currentlyEmittedAddressIndex + 1, address.length).join(" ");
        data[currentlySearchingIndex].mapSearchableAddressEmittedAddress++;
        searchLocationOnMapAddressArray(data[currentlySearchingIndex].addressString);
    } else {
        currentlySearchingIndex++;
        if (currentlySearchingIndex < data.length) {
            callSearchLocation();
        }
    }
}

//Search a location using text address, to identify the searchable address
function searchLocationOnMapAddressArray(locationString) {
    var request = {
        query: locationString
    };
    service = new google.maps.places.PlacesService(document.getElementById('map-button'));
    service.textSearch(request, callBackForSearchLocationAddressArray);
}

// call  back function for search location, to identify the searchable address
function callBackForSearchLocationAddressArray(results, status) {
    if (status === google.maps.places.PlacesServiceStatus.OK) {
        if (results.length > 0) {
            data[currentlySearchingIndex].mapResults = results;
            currentlySearchingIndex++;
            if (currentlySearchingIndex < data.length) {
                setTimeout(function() { callSearchLocation(); }, 500);


            }
        } else {
            callSearchLocation();
        }
    } else {
        callSearchLocation();
    }
}

// function to create a marker for input location (applicable only for single map)
function createMarker(place, data) {
    var placeLoc = place.geometry.location;
    var marker = new google.maps.Marker({
        map: map,
        position: place.geometry.location,
        animation: google.maps.Animation.DROP
    });
    markers.push(marker);

    // To show all the markers in the viewport
    bounds.extend(placeLoc);

    google.maps.event.addListener(marker, 'mouseover', function() {
        var infoMessage = "<h5><b>" + data.name + "</b>&nbsp;&nbsp;&nbsp;";
        if (data.gender == "male") {
            infoMessage += ('<img src="../img/male.png"/></h5>');
        } else if (data.gender == "female") {
            infoMessage += ('<img src="../img/female.png"/></h5>');
        } else {
            infoMessage += ('</h5>');
        }
        infoMessage += ("<h6>" + data.skills + "</h6>");
        infoMessage += ("<h6>" + data.contact_no + "</h6>");
        infoMessage += ("<h6>" + data.email + "</h6>");

        try {
            infoMessage += ("<h6>" + data.addressString + "</h6>");
        } catch (err) {
            infoMessage += ("<h6>" + place.formatted_address + "</h6>");
        }
        infoMessage += ("<h6>Ready To Relocate&nbsp;&nbsp;");
        if (data.ready_to_relocate) {
            infoMessage += ('<img src="../img/yes.png"/></h6>');
        } else {
            infoMessage += ('<img src="../img/no.png"/></h6>');
        }
        infoWindow.setContent(infoMessage);
        infoWindow.open(map, this);
    });
    google.maps.event.addListener(marker, 'mouseout', function() {
        infoWindow.close();
    });

    google.maps.event.addListener(marker, 'click', function() {
        window.location.href = "profile.jsp";
    });

    //map.setCenter(placeLoc);
}

// function to get route between two points and render it on map
function calculateAndDisplayRoute(directionsService, directionsDisplay, startPoint, endPoint) {
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


mapDataArray = [];
mapPreviousQueryString = "";
mapSpaceBarPressed = 0;
getMapLocationsCalled = false;
currentlySearchingIndex = -1;

if (typeof data != "undefined" && data !=null)
    getMapLocations();

function getMapLocations() {
    getMapLocationsCalled = true;
    $.each(data, function(key, val) {
        if ("undefined" != val.mapLocation) {
            var addressTmp = val.mapLocation.split('^'); // ^ is separator for the address lines (this will not be allowed in the address fields)
            var currentlyEmittedAddressIndexTmp = -1;
            val.mapSearchableAddress = addressTmp;
            val.mapSearchableAddressEmittedAddress = currentlyEmittedAddressIndexTmp;
        }
    });
    currentlySearchingIndex++;
    callSearchLocation();
}

function executeMapSearch() {
    var userQuery = $("#mapSearch").val().toLowerCase().trim();
    userQuery = userQuery.substring(userQuery.lastIndexOf(" ") + 1, userQuery.length);
    var regex = new RegExp(userQuery, "i");
    var exam = data;
    if (mapSpaceBarPressed > 0 && mapDataArray.length > 0) {
        exam = mapDataArray[mapDataArray.length - 1];
        while (exam.length <= 0 && mapDataArray.length > 0) {
            mapDataArray.pop();
            exam = mapDataArray[mapDataArray.length - 1];
        }
        if (exam.length <= 0)
            exam = data;
    }
    deleteMarkers();
    var tempArray = [];
    var resultsFound = false;
    $.each(exam, function(key, val) {
        if ("undefined" != typeof val.mapLocation && val.mapLocation.search(regex) != -1 && "undefined" != typeof val.mapResults) {
            for (var i = 0; i < val.mapResults.length; i++) {
                createMarker(val.mapResults[i], val);
                resultsFound = true;
                break;
            }
        }
    });
    map.fitBounds(bounds);
    if (!resultsFound) {
        map.setZoom(1);
        $('#mapSearch').blur();
        $('#mapSearch').css("border", "1px solid #ff0000");
    } else {
        $('#mapSearch').css("border", "none");
    }
}
$(document).on("focus", '#mapSearch', function(evt) {
    $('#mapSearch').css("border", "none");
});

$(document).on("keyup", '#mapSearch', function(evt) {
    $('#mapSearch').css("border", "none");
    if (evt.keyCode == 13) {
        executeMapSearch();
    } else if (evt.keyCode == 32) {
        var userQuery = $("#mapSearch").val().toLowerCase().trim();
        userQuery = userQuery.substring(userQuery.lastIndexOf(" ") + 1, userQuery.length);
        var regex = new RegExp(userQuery, "i");
        var exam = data;
        if (mapSpaceBarPressed > 0 && mapDataArray.length > 0) {
            exam = mapDataArray[mapDataArray.length - 1];
        }
        var tempArray = [];
        $.each(exam, function(key, val) {
            if ("undefined" != typeof val.mapLocation && val.mapLocation.search(regex) != -1) {
                tempArray.push(val);
            }
        });
        mapSpaceBarPressed++;
        mapDataArray.push(tempArray);

    } else if (evt.keyCode == 8) {
        if (mapPreviousQueryString.toLowerCase().trim() == userQuery && mapPreviousQueryString.trim().length == mapPreviousQueryString.length - 1) {
            mapSpaceBarPressed--;
            mapDataArray.pop();
            if (mapSpaceBarPressed < 0)
                mapSpaceBarPressed = 0;
        }
    }
    mapPreviousQueryString = $("#mapSearch").val();
});

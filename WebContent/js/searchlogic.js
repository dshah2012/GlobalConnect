var dataArray = [];
var previousQueryString = "";
data = null;
spaceBarPressed = 0;
checkedValues = null;
var skillCount = 0;
o = "";
e = "";

function getFormattedSearchData(data1) {
    var data2 = [];
    $.each(data1, function(key, val) {
        var data3 ={};
        data3.name = val.firstName + " " + val.lastName;
        data3.trainerProfileId = val.trainerProfileId;
        data3.gender = val.gender.toLowerCase();
        data3.email = val.primaryEmailId;
        data3.ready_to_relocate = val.readyToRelocate;
        data3.location = val.city;
        data3.contact_no = "" + val.primaryMobileNo + "";
        data3.employers = val.organizationName;
        data3.mapLocation = val.propertyNo + "^" + val.streetName + "^" + val.areaName + "^" + val.landmark + "^" + val.city + "^" + val.state + "^" + val.country +"^" + val.pincode;
        data3.skillsArrayCopied = val.skillName;
        data3.skills = "";
        $.each(val.skillName, function(key, val){
            if(data3.skills != "")
                data3.skills += ", ";
            data3.skills += val;
        });
        data3.dictionary = "";
        data2.push(data3);
        
    });
    return data2;
}
 
function getStatisticsFormattedData(data){
	setTimeout(function() {
		try{
			if("undefined" != typeof trainerProfileId){
				for(var i1 = 0; i1 < data.length ; i1++){
					if(trainerProfileId == data[i1].trainerProfileId ){
						trainerSkillDataStats= data[i1].skillName; 
						return;
					}
				}
				trainerSkillDataStats= null;
				return;
			}else{
				getStatisticsFormattedData(data);
			}
		}catch(err){
			getStatisticsFormattedData(data);
		}
    }, 100);
	
}

function getDictionarySearchData(){
	$.getJSON('../json/dictionarySearchData.json', function(dataSearch) {
		 $.each(data, function(key, val) {
             for (var i2 =0; i2<val.skillsArrayCopied.length; i2++) {
            	 for(var j2=0; j2<dataSearch.length; j2++){
            		 if (val.skillsArrayCopied[i2].trim().toLowerCase()==dataSearch[j2].key.trim().toLowerCase()) {
                    	 val.dictionary += ("," + dataSearch[j2].val);
                     }  
            	 }
             }
         });
    });
}

$(window).load(function() {

    $.getJSON('../getSearchData', function(data1) {
        data = getFormattedSearchData(data1);
        // Set data for the statistics
        getStatisticsFormattedData(data1);
        getDictionarySearchData();
        try {
            getMapLocations();
        } catch (e) {}
    });
    $('#searchBox').keyup(function(evt) {
        $("#search-results").css("display", "block");
        var userQuery = $("#searchBox").val().toLowerCase().trim();
        var userQueryNotTrimmed = $("#searchBox").val();
        if (userQuery == "do a barrel roll") {
            barrel();
        }
        if (evt.keyCode == 32) {
            if (true) { //previousQueryString.toLowerCase().trim() != userQuery){
                userQuery = userQuery.substring(userQuery.lastIndexOf(" ") + 1, userQuery.length);
                // con += '<div class="con-content" style="border:1px solid #000">' + userQuery + '</div>';
                // alert($("#searchBox").position().left);
                var regex = new RegExp(userQuery, "i");
                var exam = data;
                if (spaceBarPressed > 0 && dataArray.length > 0) {
                    exam = dataArray[dataArray.length - 1];
                }
                var tempArray = [];
                $.each(exam, function(key, val) {
                    var tempFound = false;
                    for (i in checkedValues) {
                        if ("undefined" != val[checkedValues[i]] && val[checkedValues[i]].search(regex) != -1) {
                            tempFound = true;
                            break;

                        }
                    }
                    if (tempFound) {
                        tempArray.push(val);
                    }
                });
                spaceBarPressed++;
                dataArray.push(tempArray);
                if (userQueryNotTrimmed.length == userQueryNotTrimmed.trim().length + 1) {
                    generateRoots(exam, userQuery, $("#searchBox").position().left, $("#searchBox").position().top, "add");
                }
            }
        } else {
            var exam = data;
            if (spaceBarPressed > 0 && dataArray.length > 0) {
                exam = dataArray[dataArray.length - 1];
            }
            if (evt.keyCode == 8) {
                if (userQuery == "do a barrel roll") {
                    barrel();
                }
                if (previousQueryString.toLowerCase().trim() == userQuery && previousQueryString.trim().length == previousQueryString.length - 1) {
                    spaceBarPressed--;
                    dataArray.pop();
                    var userQuery1 = userQuery.substring(userQuery.lastIndexOf(" ") + 1, userQuery.length);
                    $("#experience-container").html("");
                    $("#experience-container").css("display","none");
                    $("#search-results").css("top","-2px");
                    //generateRoots(exam, userQuery1, $("#searchBox").position().left, $("#searchBox").position().top, "delete");
                }
            }
            var userQuery = $("#searchBox").val().toLowerCase();
            userQuery = userQuery.substring(userQuery.lastIndexOf(" ") + 1, userQuery.length);
            var regex = new RegExp(userQuery, "i");
            var output = '<div class="row custom">';
            var count = 1;

            $.each(exam, function(key, val) {
                var tempFound = false;
                for (i in checkedValues) {
                    if ("undefined" != val[checkedValues[i]] && val[checkedValues[i]].search(regex) != -1) {
                        tempFound = true;
                        break;
                    }
                }
                if (tempFound) {
                    // $("<li />").html(val.name).appendTo(".search-result-list");
                    output += '<div style="">';

                    // output += '<div class="col-md-7">';
                    output += '<h5 style="float:left; margin-left:25px;font-weight:bold;">' + val.name + '</h5>';
                    output += '<h5 style="display:inline-block;float:right;margin-right: 25px;font-style: italic;width:60%;">' + val.skills + '</h5>';
                    // output += '<h5 style="display:inline-block;float:right;margin-right: 25px;font-style: italic;width:60%;">' + val[checkedValues[i]] + '</h5>';
                    // output += '<h5>' + val.technology + '</h5>';
                    // output += '<p>' + val.tools + '</p>'
                    // output += '<p>' + val.versions + '</p>'
                    // output += '</div>';
                    output += '</div>';
                    output += '</div><div class="row custom">'
                    count++;
                }
            });
            if (output == '<div class="row custom">') {
                output += '<h5 style="text-align: center;">No Results Found</h5>';
            }
            output += '</div>';
            var exp = $('#experience-container');
            // <h5 style="margin-left: 80%;margin-top: 4%;"><i class="fa fa-arrow-circle-left" style="margin-right: 5px;"></i>Experience</h5>
            $("#search-results").html(output);
            // appendExp();
            if ($("#searchBox").val().length == 0) {
                $("#search-results").css("display", "none");
                $("#search-results").html("");
                $("#experience-container").html("");
                $("#experience-container").css("display", "none");
            }
        }
        previousQueryString = $("#searchBox").val();
        $("#search-result-container").css("display", "block");
    });
});

$(document).ready(function() {
    jQuery('#hideshow').on('click', function(event) {
        if (window.location.pathname.search("Pages/profile.jsp") < 0) { // Do only when on dashboard
            // $('#search-filters').toggle();
        }
    });
    jQuery('input.messageCheckbox').on('click', function(event) {
        checkedValues = $('#search-filters input:checkbox:checked').map(function() {
            return this.value;
        }).get();
        checkedValues.push("dictionary");
    });
    checkedValues = $('#search-filters input:checkbox:checked').map(function() {
        return this.value;
    }).get();
});
$(document).on("click", '.custom', function() {
    window.location.href = "profile.jsp";
});

offset = [];
f = false;

function generateRoots(literal, query, left, top, addOrRemove) {
    $.each(literal, function(key, val) {
        var temp = val.skills.split(",");
        var foundIt = false;
        for (i in temp) {
            if (temp[i].trim().toLowerCase() == query.toLowerCase()) {
                foundIt = true; 
                f = true;
                appendExp(query);
                // $('.experience-container').html('<div class="exp-filter" style="position:absolute;left:' + left + 'px;top:' + top + 'px;">' + query + '</div>');
                break;
            }
        }
    });
    if (f) {
        if (addOrRemove == "add") {
            offset.push(document.getElementById('searchBox').selectionStart + 5);
            skillCount++;
        } else if (addOrRemove == "delete" && skillCount > 0) {
            offset.pop();
            skillCount--;
        }
    }
}

function appendExp(q) {
    if (f) {
        $("#experience-container").css("display", "block");
        $("#search-results").css("top", "50px");
        $('#experience-container').html('<div class="exp-filter-container"><form class="min-exp"><div class="group"><input class="material-input" type="text" required><span class="highlight"></span><span class="bar"></span><label class="min-label">Minimum ' + q.toUpperCase() + ' Experience</label></div></form><form class="max-exp"><div class="group"><input class="material-input" type="text" required><span class="highlight"></span><span class="bar"></span><label class="max-label">Maximum ' + q.toUpperCase() + ' Experience</label></div></form></div>');
        //<h5 style="margin-top: 17px;margin-left: 10px;">'+ q +'</h5>
    } else {
        $("#experience-container").css("display", "none");
        $("#search-results").css("top", "-2px");
    }
}

previousOpenChart = null;
trainerSkillDataStats = null;

var trainerProfileId = 1; /* hardcoded */
var userid = 1; /* hardcoded */

getProfileCompletion();
 
function barrel() {

    $('body').css("-moz-animation-name", "roll");
    $('body').css("-moz-animation-duration", "4s");
    $('body').css("-moz-animation-iteration-count", "1");
    $('body').css("-o-animation-name", "roll");
    $('body').css("-o-animation-duration", "4s");
    $('body').css("-o-animation-iteration-count", "1");
    $('body').css("-webkit-animation-name", "roll");
    $('body').css("-webkit-animation-duration", "4s");
    $('body').css("-webkit-animation-iteration-count", "1");

}

// Profanity Filter will not work on textbox and this must be called after value is changed
// $("#searchBox").profanityFilter({
//     customSwears: ['shit'],
//      externalSwears: 'swearWords.json',
//     profaneText: function(data) {
//         alert('That is vulgar!');
//         console.log(data);
//     }
// });


setRightBarOnPosition();

function setRightBarOnPosition() {
    var rightbar = "right-sidebar";
    var winWidth = window.innerWidth;
    var boundingRect = document.getElementById(rightbar).getBoundingClientRect();
    if (boundingRect.right < winWidth) {
        while (boundingRect.right <= winWidth) {
            $("#" + rightbar).css("left", "" + (parseInt($("#" + rightbar).css("left")) + 1) + "px");
            boundingRect = document.getElementById(rightbar).getBoundingClientRect();
        }
    } else {
        while (boundingRect.right > winWidth) {
            $("#" + rightbar).css("left", "" + (parseInt($("#" + rightbar).css("left")) - 1) + "px");
            boundingRect = document.getElementById(rightbar).getBoundingClientRect();
        }
    }
}
$(window).resize(function() {
    setRightBarOnPosition();
});

$(document).on("keyup", "#shareProfile input", function(evt) {
    if (evt.keyCode == 13) {
        var userName = $("#shareProfile input.share-profile-desktop").val();
        if (window.innerWidth < 480) {
            userName = $("#shareProfile input.share-profile-mobile").val();
        }
        var messageBody = "------------------------------------" +
            "Trainer--1 shared his/her profile with you" +
            " !! <br> To go to profile of " + userName + ' &nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/0B_71SbHF0lbndXlLWndXZ2s2UTA/view?usp=drivesdk">click here</a>' +
            '</br><br/> You can find the profile in the attachmenmts also.';

        $("#shareProfile span").css("display", "inline").text("Sharing profile");
        $("#shareProfile input").css("display", "none").val("");
        $.ajax({
            url: "../sendMail",
            method: "POST",
            data: {
                "emailTo": userName,
                "emailSubject": "GlobalEdify | Profile shared by " + userName,
                "emailBody": messageBody,
                "emailAttachment": null,
                //"emailAttachment": "Files/Chandra-profile.pdf",
                "redirectPage": "false"
            },
            dataType: "text",
            success: function(data, status, jqXHR) {
                if (data == "true") {
                    $("#shareProfile span").css("display", "inline").text("Profile shared successfully");
                    $("#shareProfile input").css("display", "none").val("");
                    setTimeout(function() {
                        $("#shareProfile span").css("display", "none");
                        $("#shareProfile input").css("display", "inline");
                    }, 3000);
                } else {
                    $("#shareProfile span").css("display", "inline").text("Profile could not be shared");
                    $("#shareProfile input").css("display", "none").val("")
                    setTimeout(function() {
                        $("#shareProfile span").css("display", "none");
                        $("#shareProfile input").css("display", "inline");
                    }, 3000);
                }
            },
            error: function(jqXHR, status, error) {
                $("#shareProfile span").css("display", "inline").text("Profile could not be shared");
                $("#shareProfile input").css("display", "none").val("")
                setTimeout(function() {
                    $("#shareProfile span").css("display", "none");
                    $("#shareProfile input").css("display", "inline");
                }, 3000);
            }
        });
    }
});
var currentPage = window.location.pathname.split("/");
currentPage = currentPage[currentPage.length - 1]
if (currentPage == "Account.jsp") {
    displayStat();
}

function setNotActiveRightBarExcept(tab) {
    $("#right-sidebar .sidebar-menu li.treeview").removeClass("active");
    try {
        tab.addClass("active");
    } catch (err) {}
}

function reCheckSkillsLoading(){
	setTimeout(function() {
		if ("undefined" == typeof trainerSkillDataStats) {
        	$("#right-sidebar .sidebar-menu li.right-stats .rightNavigation").text("Loading stats");
            try{
            	reCheckSkillsLoading();
            }catch(err){}
		}else{
			$("#right-sidebar .sidebar-menu li.right-stats .rightNavigation").fadeOut(function() {
	            $(this).text("Statistics").fadeIn();
	            displayStat();
	        });
		}
    }, 1000);
}

function displayStat() {
	try {
        if ("undefined" == typeof trainerSkillDataStats || null ==trainerSkillDataStats) { 
        	$("#right-sidebar .sidebar-menu li.right-stats .rightNavigation").text("Loading stats");
        	reCheckSkillsLoading();
            return;
        }
    } catch (err) {
        return;
    }
	
    if ($('#chart').is(':visible')) {
        $('#chart').toggle('hide');
        setNotActiveRightBarExcept(null);
    }
    if (previousOpenChart != "stats") {
        //$.getScript("../js/script.js");
        if ($(window).width() < 480) {
            $('#chart').html(getTrends(true));
        } else {
            $('#chart').html('<hr class="hr-rule-profile"/><span class="stat-greeting-profile">What\'s Trending?</span></br>' + getTrends(false));
        }
        // $('#chart').html("");
        $('#chart').show('slow');
        previousOpenChart = "stats";
        setNotActiveRightBarExcept($("#right-sidebar .sidebar-menu li.right-stats"));
    } else {
        previousOpenChart = null;
        setNotActiveRightBarExcept(null);
    }
}

function displayPrezi() {
    if (previousOpenChart != "prezi") {
        if ($(window).width() < 480) {
        } else {
            $('#quotes').html('<hr class="hr-rule-profile"/><span class="stat-greeting-profile">globalConnect</span></br><iframe src="https://prezi.com/embed/dckfrwlearox/?bgcolor=ffffff&amp;lock_to_path=0&amp;autoplay=0&amp;autohide_ctrls=0&amp;landing_data=bHVZZmNaNDBIWnNjdEVENDRhZDFNZGNIUE43MHdLNWpsdFJLb2ZHanI0c2w0Z09MWm5KRnZSb3ZwK2VCazlUdG9BPT0&amp;landing_sign=nY8_P0TP77P2KtBX-h-UUFwnmFyhSlRUqu5K0qTxDE4" allowfullscreen="" mozallowfullscreen="" webkitallowfullscreen="" id="iframe_container" frameborder="0" height="400" width="550"></iframe>');
        }
        // $('#chart').html("");
        $('#chart').show('slow');
        previousOpenChart = "prezi";
        setNotActiveRightBarExcept($("#right-sidebar .sidebar-menu li.right-stats"));
    } else {
        previousOpenChart = null;
        setNotActiveRightBarExcept(null);
    }
}

function getTrends(isMobile) {
    var trendsWidth = 800;
    var trendsHeight = 350;
    var trendsClass = "trend-desktop";
    if (isMobile) {
        trendsWidth = 350;
        trendsHeight = 300;
        trendsClass = "trend-mobile";
        if (currentPage == "profile.jsp") {
            trendsClass = "trend-mobile-profile";
        }
    }

    var trendsSrc = "//www.google.co.in/trends/fetchComponent?hl=en-US&amp;q=";
    // Add query terms here seprated by comma. Each term having more than one word must be separated by +
    trendsSrc += getTrendsQuery();
    trendsSrc += "&amp;tz=Etc/GMT-5:30&amp;content=1&amp;cid=TIMESERIES_GRAPH_0&amp;export=5&amp;";
    trendsSrc += "w=" + trendsWidth + "&amp;h=" + trendsHeight;
    var trends = '<iframe class="' + trendsClass + '" width="' + trendsWidth + '" height="' + trendsHeight + '" src="' + trendsSrc + '"style="border: none;"></iframe>';
    return trends;
}

function getTrendsQuery() {
	var query = "";
	var ln = trainerSkillDataStats.length;
	if(ln>5)
		ln = 5;
    for (var i = 0; i < ln; i++) {
        if (query.length > 0)
            query += ',';
        var tmpQ = trainerSkillDataStats[i].split(" ");
        for (var j = 0; j < tmpQ.length; j++)
            query += "+" + tmpQ[j];
    }
    return query;
}

function liveVideo() {
    if ($('#chart').is(':visible')) {
        $('#chart').toggle('hide');
        setNotActiveRightBarExcept(null);
    }
    if (previousOpenChart != "video") {
        var label = '<hr class="hr-rule"/><span class="live-greeting">Live Streaming Channel.</span></br>';
        var inputTemp = '<input type="text" id="url" class="form-control live-url" placeholder="Enter the Hangout On Air URL"></input>';
        if (currentPage == "profile.jsp") {
            label = '<hr class="hr-rule-profile"/><span class="live-greeting-profile">Live Streaming Channel.</span></br>';
            inputTemp = '<input type="text" id="url" class="form-control live-url-profile" placeholder="Enter the Hangout On Air URL"></input>';

        }
        var buttonTemp = '<button class="btn btn-success live-btn" onclick="execute(\'#url\')"><i class="fa fa-youtube-play"></i>  Stream</button>';
        var buttonTempCreate = '<button class="btn btn-primary live-create-btn-mobile" href="#chart" onclick="window.open(\'https://plus.google.com/hangouts/onair?hl=en\',\'_blank\')"><i class="fa fa-plus"></i></button><button class="btn btn-primary live-create-btn live-create-btn" href="#chart" onclick="window.open(\'https://plus.google.com/hangouts/onair?hl=en\',\'_blank\')"><i class="fa fa-plus"></i>  Create Live Session</button>';
        $('#chart').html(label + inputTemp + buttonTemp + buttonTempCreate);
        $('#chart').toggle('hide');
        previousOpenChart = "video";
        setNotActiveRightBarExcept($("#right-sidebar .sidebar-menu li.right-video"));
    } else {
        previousOpenChart = null;
        setNotActiveRightBarExcept(null);
    }
}

function execute(temp) {
    temp = $(temp);
    if ("undefined" !== temp && temp) {
        temp = temp.val();
        appendVideoIFrame(temp);
//        var count = 0;
//        var comments = '<div class="panel-group panel-custom">';
//        if ($(window).width() < 480) {
//            if (currentPage == "profile.html") {
//                comments = '<div class="panel-group panel-custom-profile">';
//            } else {
//                comments = '<div class="panel-group panel-custom-account">';
//            }
//        }
//        comments += '<div class="panel panel-info" style="margin-bottom: -35px;"><div class="panel-heading"><img src="../img/user2-160x160.jpg" class="img-circle img-comment" alt="User Image"></img>Comment</div><textarea class="form-control" rows="4" cols="129"></textarea><button class="btn btn-primary post-btn">Post</button></div>';
//        var commentsArray;
//        $.getJSON('../json/comments.json', function(data) {
//            $.each(data, function(key, val) {
//                if (temp == val.url) {
//                    count++;
//                    videoTitle = val.videoCaption;
//                    commentsArray = val.comments;
//                    $.each(commentsArray, function(commentKey, commentValue) {
//                        comments += '<div class="panel panel-info">';
//                        comments += '<div class="panel-heading">';
//                        comments += '<i class="fa fa-comment" style="margin-right:5px"></i>';
//                        comments += commentValue.user + '<span id="time-stamp" class="time-stamp-refresh" style="float: right;" data-timestamp="' + commentValue.stamp + '">' + timeSince(new Date(commentValue.stamp)) + '</span>' + '</div>';
//                        comments += '<div class="panel-body">';
//                        comments += commentValue.comment;
//                        comments += '</div></div>';
//                    });
//                }
//            });
//            if (count != 0) {
//                comments += '</div>';
//                $('#chart').html("");
//                var appendData = '<hr class="hr-rule"/><h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3><div> <iframe width="560" height="315" class="iframe" src="' + temp + '" frasmeborder="0" allowfullscreen></iframe> </div>' + '<span class="like-span"><button class="btn btn-primary"><i class="fa fa-thumbs-up" style="padding-right: 8px;font-size: 17px;"></i>Like</button></span>' + comments
//                if ($(window).width() < 480) {
//                    if (currentPage == "profile.html") {
//                        appendData = '<hr class="hr-rule hr-profile"/><h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3><div> <iframe class="iframe-profile" src="' + temp + '" frasmeborder="0" allowfullscreen></iframe> </div>' + '<span class="like-span-profile"><button class="btn btn-primary"><i class="fa fa-thumbs-up" style="padding-right: 8px;font-size: 17px;"></i>Like</button></span>' + comments
//                    } else {
//                        appendData = '<hr class="hr-rule"/><h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3><div> <iframe class="iframe-account" src="' + temp + '" frasmeborder="0" allowfullscreen></iframe> </div>' + '<span class="like-span-account"><button class="btn btn-primary"><i class="fa fa-thumbs-up" style="padding-right: 8px;font-size: 17px;"></i>Like</button></span>' + comments
//                    }
//                }
//                $('#chart').html(appendData);
//            } else {
//                $('#chart').html('<div class="alert alert-danger url-unavailable-mobile"><strong><h3 style="text-align:center;">URL Unavailable</h3></strong></div><div class="alert alert-danger url-unavailable-desktop" style="width: 79%;""><strong><h3 style="text-align:center;">URL Unavailable</h3></strong></div>');
//            }
//        });
    }
}

function findTrainers() {
    try {
        if (currentlySearchingIndex < data.length) {
            $("#findTrainerText").text("Loading map data");
            setTimeout(function() {
                $("#findTrainerText").fadeOut(function() {
                    $(this).text("Find Trainers").fadeIn();
                });
            }, 1000);
            return;
        }
    } catch (err) {
        $("#findTrainerText").text("Loading map data");
        setTimeout(function() {
            $("#findTrainerText").fadeOut(function() {
                $(this).text("Find Trainers").fadeIn();
            });
        }, 1000);
        return;
    }

    if ($('#chart').is(':visible')) {
        $('#chart').toggle('hide');
        setNotActiveRightBarExcept(null);
    }
    if (previousOpenChart != "find") {
        $('#chart').html('<hr class="hr-rule"/><label class="find-trainer-label">Find Trainers </label><input type="text" class="searchbar map-search" id="mapSearch" placeholder="Enter Location (Press enter to search)"><button class="btn btn-primary find-button" style="margin-left: 6px;margin-bottom: 4px;" onclick="executeMapSearch()">Find</button>');
        $('#chart').append('<div id="map" class="map-here">').toggle('hide');
        if (currentPage == "profile.jsp") {
            $('#chart').append('<div id="map" style="width:340px" class="map-here-profile">').toggle('hide');
        }
        initMapData();
        previousOpenChart = "find";
        setNotActiveRightBarExcept($("#right-sidebar .sidebar-menu li.right-findtrainers"));
    } else {
        previousOpenChart = null;
        setNotActiveRightBarExcept(null);
    }
}

function showAddressLocation() {
    if ($('#chart').is(':visible')) {
        $('#chart').toggle('hide');
        setNotActiveRightBarExcept(null);
    }
    if (previousOpenChart != "map") {
        if (currentPage == "profile.jsp") {
            $('#chart').html('<hr class="hr-rule-profile"/><span class="map-greeting-profile">You\'re Here!</span></br><div id="map" class="you-are-here-profile">').toggle('hide');
        } else {
            $('#chart').html('<hr class="hr-rule-profile"/><span class="map-greeting-profile">You\'re Here!</span></br><div id="map">').toggle('hide');
        }
        initMapData();
        searchLocationOnMap(addressString);
        previousOpenChart = "map";
        setNotActiveRightBarExcept($("#right-sidebar .sidebar-menu li.right-location"));
    } else {
        previousOpenChart = null;
        setNotActiveRightBarExcept(null);
    }
}

//editaboutmemodel = document.getElementById('edit-model-aboutme');
//
//$('.cancel-model').click(function() {
//    editaboutmemodel.style.display = "none";
//});


//Search Modal
var searchmod = document.getElementById('searchModal');
$("#hideshow").on("click", function() {
  searchmod.style.display = "block";
  $("#search-filters").css("display", "block");
});
$(document).on("click", ".close", function() {
  $('#searchModal').css("display", "none");
});

//Get the modal
var connect = document.getElementById('myModal');
var target2 = document.getElementsByClassName("connect-me")[0];
var target3 = document.getElementsByClassName("connect-me")[1];
var span2 = document.getElementsByClassName("close")[1];
if ("undefined" != span2 && null != span2) {
  target2.onclick = function() {
      connect.style.display = "block";
  }
}
if ("undefined" != span2 && null != span2) {
  try {
      target3.onclick = function() {
          connect.style.display = "block";
      }
  } catch (err) {

  }
}
if ("undefined" != span2 && null != span2) {
  span2.onclick = function() {
      connect.style.display = "none";
  }
}

var notifications = document.getElementById('notifModal');
var target1 = document.getElementById("notif");
var span1 = document.getElementsByClassName("close")[2];
if ("undefined" != target1 && null != target1) {
  target1.onclick = function() {
      notifications.style.display = "block";
  }
}
if ("undefined" != span1 && null != span1) {
  span1.onclick = function() {
      notifications.style.display = "none";
  }
}

function yesnoCheck() {
  if (document.getElementById('yesCheck').checked) {
      document.getElementById('ifYes').style.display = 'block';
  } else document.getElementById('ifYes').style.display = 'none';

}

function printProfile() {
  Popup("Chandra - profile ", $("section.profile-content").html());
}

function Popup(trainerName, data) {
  var mywindow = window.open('', 'my div', 'height=' + $(window).height() + ',width=' + $(window).width() + ',' +
      'left=' + window.screenX + ',top=' + window.screenY +
      ',menubar=no,resizable=no,status=no,titlebar=no');
  mywindow.document.write('<html><head><title>' + trainerName + '</title>');
  var styleSheets = $("link");
  for (var index = 0; index < styleSheets.length; index++) {
      mywindow.document.write(styleSheets[index].outerHTML);
  }
  mywindow.document.write('</head><body >');
  mywindow.document.write(data);
  var scripts = $("script");
  for (var index = 0; index < scripts.length; index++) {
      mywindow.document.write(scripts[index].outerHTML);
  }
  mywindow.document.write('<script type="text/javascript" src="../js/printProfile.js"></script>');
  mywindow.document.write('</body></html>');
  mywindow.document.close(); // necessary for IE >= 10
  mywindow.focus(); // necessary for IE >= 10
  mywindow.onbeforeunload = function() {
      $("#right-sidebar .sidebar-menu li.right-print").removeClass("active");
  }

  return true;
}

function setProfileCompletionValue(percentage) {
  var circle = $("#profileCompletion");
  var text = $("#profileCompletion span");
  var circle1 = $("#profileCompletionPage");
  var text1 = $("#profileCompletionPage span");
  for (var i = 1; i <= percentage; i++) {
      (function(i) {
          setTimeout(function() {
              circle.removeClass("p" + (i - 1)).delay(500).addClass("p" + i);
              if ("undefined" != circle1 && null != circle1) {
                  circle1.removeClass("p" + (i - 1)).delay(500).addClass("p" + i);
                  text1.text(i + "%");
              }
              text.text(i + "%");
          }, 10 * i);
      }(i));

  }
}

function getProfileCompletion() {
  $.ajax({
      url: "../json/profile.json",
      method: "POST",
      data: { "request": "profileCompletionPercentage" },
      dataType: "json",
      success: function(data, status, jqXHR) {
          setProfileCompletionValue(data.profileCompletion);
      },
      error: function(jqXHR, status, error) {
          // Do something if required
      }
  });
}

function timeSince(date) {
  var seconds = Math.floor((new Date() - date) / 1000);
  var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
  if (seconds < 5) {
      return "just now";
  } else if (seconds < 60) {
      return seconds + " seconds ago";
  } else if (seconds < 3600) {
      minutes = Math.floor(seconds / 60)
      if (minutes > 1)
          return minutes + " minutes ago";
      else
          return "1 minute ago";
  } else if (seconds < 86400) {
      hours = Math.floor(seconds / 3600)
      if (hours > 1)
          return hours + " hours ago";
      else
          return "1 hour ago";
  }
  //2 days and no more
  else if (seconds < 172800) {
      days = Math.floor(seconds / 86400)
      if (days > 1)
          return days + " days ago";
      else
          return "1 day ago";
  } else {

      //return new Date(time).toLocaleDateString();
      return date.getDate().toString() + " " + months[date.getMonth()] + ", " + date.getFullYear();
  }
}

var auto_refresh = setInterval(function() {
  $('.time-stamp-refresh').each(function() {
      $(this).html(timeSince(new Date(parseInt($(this).attr("data-timestamp")))));
  });
  try {
      auto_refresh();
  } catch (err) {}
}, 1000);

//Showing the div input div when the edit button is clicked and adding the data of the divs to the fields
$('.edit-about-me').click(function(){
	$('#about-me').show();
	$("#about-me").css("width","73%");
	var aboutMe=$(this).parent().find('.about-me').text();
	$('#about-me').find('#about-me-text').val(aboutMe); 
})

//This is the contact-info editing and saving
$('.edit-contact-info').click(function (){
	$('#contact-info').show();
	$("#contact-info").css("width","73%");
	var primaryMobile=$(this).parent().find('.primary-mobile').text();
	$('#contact-info').find('#primary-mobile').val(primaryMobile); 
	
	var secondaryMobile=$(this).parent().find('.secondary-mobile').text();
	$('#contact-info').find('#secondary-mobile').val(secondaryMobile);
	
	var secondaryEmail=$(this).parent().find('.secondary-email').text();
	$('#contact-info').find('#secondary-email').val(secondaryEmail);
	
	var fax=$(this).parent().find('.fax').text();
	$('#contact-info').find('#fax').val(fax);
	
	var residenceNo=$(this).parent().find('.residence-no').text();
	$('#contact-info').find('#residence-no').val(residenceNo);
	
	var officeNo=$(this).parent().find('.office-contact').text();
	$('#contact-info').find('#office-contact').val(officeNo);
});


//This is the personal-info editing 
$('.edit-personal-info').click(function (){
	$('#personal-info').show();
	$("#personal-info").css("width","73%");
	var firstName=$(this).parent().find('.profile-topic-first-name').text();
	$('#personal-info').find('#first-name').val(firstName);
	
	var middleName=$(this).parent().find('.profile-topic-middle-name').text();
	$('#personal-info').find('#middle-name').val(middleName);
	
	var lastName=$(this).parent().find('.profile-topic-last-name').text();
	$('#personal-info').find('#last-name').val(lastName);
	
	var gender=$(this).parent().find('.profile-topic-gender').text();
	if(gender=="MALE"){
		$("#male").attr('checked', 'checked');
	}else
		{
		$("#female").attr('checked', 'checked');
		}
	
	var status=$(this).parent().find('.profile-topic-status').text();
	if(status==""){
		
	}else if(status=="SINGLE")
		{
		$("#single").attr('checked', 'checked');
		}
	else if(status=="MARRIED"){
		$("#married").attr('checked', 'checked');
	}
	
	var spouseName=$(this).parent().find('.profile-topic-spouse-name').text();
	$('#personal-info').find('#spouse-name').val(spouseName);
	
	var dob=$(this).parent().find('.profile-topic-dob').text();
	$('#personal-info').find('#date-of-birth').val(dob);
	
	var relocation=$(this).parent().find('.profile-topic-relocation').text();
	if(relocation==""){
		
	}else if(relocation=="Yes")
		{
		$("#yesRelocate").attr('checked', 'checked');
		}
	else if(relocation=="No"){
		$("#no").attr('checked', 'checked');
	}
});


//This is the banking editing and saving
$('.edit-banking').click(function (){
	$('#banking').show();
	$("#banking").css("width","73%");
	var accountNumber=$(this).parent().find('.profile-topic-account-number').text();
	$('#banking').find('#account-number').val(accountNumber);
	
	var ifsc=$(this).parent().find('.profile-topic-ifsc').text();
	$('#banking').find('#ifsc').val(ifsc);
	
	var transfer=$(this).parent().find('.profile-topic-transfer').text();
	$('#banking').find('#mode-of-transfer').val(transfer);
});


//this is the education editing and saving
$('body').on('click','.edit-education',function (){
	$('#education').show();
	$('#education').insertAfter($(this).parent());
	$("#education").css("width","100%");
	var editEduId=$(this).parent().find('.always-hide').text();
	
	$.each(trainer.educations, function(index, education) {
		if(education.educationId==editEduId){
			$('#education').find('#institute-name').val(education.instituteName);
			$('#education').find('#degree').val(education.courseName);
			$('#education').find('#specialization').val(education.fieldOfStudy);
			$('#education').find('#start-date').val(education.startYear);
			$('#education').find('#end-date').val(education.yearOfPassing);
			$('#education').find('#board').val(education.boardName);
			$('#education').find('#percentage').val(education.percentage);
			$('#education').find('#city').val(education.location.city);
			$('#education').find('#state').val(education.location.state);
			$('#education').find('#country').val(education.location.country);
			$('#education').find('#course-duration').val(education.courseDuration);
			
		}
		
	});
	

	
	$('#add-education').show();
	
	
	//Appending id to form
	$('#education').find('.always-hide').text(editEduId);
});

//this is the end of education editing
//This is the certification adding and deleting
$('#add-certification').on("click",function() {
	$(this).hide();
	$('#certificationtest').insertAfter($(this));
	$('#certificationtest').show();
	$("#certificationtest").css("width","73%");
	$('#certificationtest').find('#institute-name').val("");
	$('#certificationtest').find('#grade').val("");
	$('#certificationtest').find('#certified-date').val("");
	$('#certificationtest').find('#certified-date').val("");
	$('#certificationtest').find('#certified-url').val("");

});
$('body').on('click','.edit-certification',function (){
	
	$('#certificationtest').show();
	$('#certificationtest').insertAfter($(this).parent());
	$("#certificationtest").css("width","100%");
	var editCertificationId=$(this).parent().find('.always-hide').text();

	$.each(trainer.certificates, function(index, certificate) {
		if(certificate.certificateId==editCertificationId){
			$('#certificationtest').find('#institute-name').val(certificate.institutionName);
				$('#certificationtest').find('#certified-date').val(getFormattedDate(certificate.certifiedDate));
			$('#certificationtest').find('#grade').val(certificate.grade);
			$('#certificationtest').find('#certificate-name').val(certificate.certificationName);
			$('#certificationtest').find('#certificate-url').val(certificate.certificateUrl);	
		}
		
	});
	$('#certificationtest').find('.always-hide').text(editCertificationId)
	$('#add-certification').show();
	
	
});




	

//This is to add the langages
$('#add-languages').on("click",function() {
	$(this).hide();
	$('#languages').insertAfter($(this));
	$('#languages').show();
	$("#languages").css("width","73%");
	$('#languages').find('#knownLanguages').val("");
	$('#languages').find('#degree').val("");

});


$('body').on('click','.edit-languages',function (){
	$('#languages').show();
	$("#languages").css("width","73%");
	var division=$(this).parent().find('.profile-topic-inner-discription').text().split(',');
	var editlangId=$(this).parent().find('.always-hide').text();
	$.each(trainer.personalInfo.languagesknown, function(index, language) {
		if(language.langKnownId==editlangId){
			for ( var i = 0; i < division.length; i++) {
				cat=division[i];
				$("#languages").find('#'+cat.toLowerCase()).attr("checked",true);
			}
			$('#languages').find('#known-languagestext').val(language.spokenLanguage.languageName);
		}
	$('#add-languages').show();
	$('#languages').find('.always-hide').text(editlangId);
});
});


//This is the end of editing


$('#add-address').on("click", function() {
	$(this).hide();
	$('#address').insertAfter($(this));
	$('#address').show();
	$("#address").css("width", "73%");
	$('#property-no').val('');
	$('#street').val('');
	$('#area').val('');
	$('#pincode').val('');
	$('#landmark').val('');
	$('#city').val('');
	$('#state').val('');
	$('#country').val('');
});

$('body').on('click','.edit-address',function (){
		

			$('#address').show();
			$('#address').insertAfter($(this).parent().parent().parent());
			$("#address").css("width", "73%");
			$('#add-address').hide();
			
		
			$('#property-no').val(
					$(this).parent().parent().find('.profile-topic-propertyno')
							.text());
			$('#street').val(
					$(this).parent().parent().find('.profile-topic-street')
							.text());
			$('#area').val(
					$(this).parent().parent().find('.profile-topic-area')
							.text());
			$('#landmark').val(
					$(this).parent().parent().find('.profile-topic-landmark')
							.text());
			$('#location').val(
					$(this).parent().parent().find('.profile-topic-location')
							.text());

			var pincode = $(this).parent().parent().find(
					'.profile-topic-pincode').text().split('-');
			$('#pincode').val(pincode[1]);
			var location = $(this).parent().parent().find(
					'.profile-topic-location').text().split(',');
			$('#city').val(location[0]);
			$('#state').val(location[1]);
			$('#country').val(location[2]);
			
});

//Date Format
function getDateInMonthAndYear(d) {
    var month = new Array();
    month[0] = "January";
    month[1] = "February";
    month[2] = "March";
    month[3] = "April";
    month[4] = "May";
    month[5] = "June";
    month[6] = "July";
    month[7] = "August";
    month[8] = "September";
    month[9] = "October";
    month[10] = "November";
    month[11] = "December";
    var dateMonth = month[new Date(d).getMonth()];
    var dateYear = new Date(d).getFullYear();
    return dateMonth + "  " + dateYear;  
}

/*$("a.btn-logout").on("click", function() {
	$("a.btn-logout").text("Signing Out");
	$.ajax({
        url: "/logout",
        method: "POST",
        data: "",
        dataType: "text",
        success: function(data, status, jqXHR) {
            if (data == "true") {
            	$("a.btn-logout").text("Signed Out");
            	window.location.href = "../index.html";
            } else {
            	$("a.btn-logout").text("Not Signed Out");
                setTimeout(function() {
                	$("a.btn-logout").text("Sign Out");
                }, 1000);
            }
        },
        error: function(jqXHR, status, error) {
        	$("a.btn-logout").text("Not Signed Out");
            setTimeout(function() {
            	$("a.btn-logout").text("Sign Out");
            }, 1000);
        }
    });
});*/

$("#right-sidebar li.treeview").not("#right-sidebar li.treeview.right-print").on("click", function() {
    $("body").scrollTop(0);
});

if (currentPage == "Account.jsp") {
    $(".left-profile-nav.treeview li a").each(function() {
        $(this).attr("href", "profile.jsp" + $(this).attr("href"));
    });
    $(".treeview.left-profile-nav a[href='profile.jsp'] span").on("click", function() {
        window.location.href = "profile.jsp";
    });
}



window.onclick = function(event) {
    if (event.target == connect || event.target == notifications || event.target == searchmod) {
        connect.style.display = "none";
        notifications.style.display = "none";
        searchmod.style.display = "none";
    }
    if (!$.contains(document.getElementById("search-result-container"), event.target)) {
        if (document.getElementById("searchBox") == event.target) {
            document.getElementById('search-result-container').style.display = "block";
        } else {
            document.getElementById('search-result-container').style.display = "none";
        }
    }
    // if (event.target != editedumodel) {
    //     editedumodel.style.display = "none";
    // }
    if (!$.contains(document.getElementsByClassName('search-modal-content')[0], event.target) && document.getElementsByClassName('search-modal-content')[0] != event.target){
        if(event.target == document.getElementById("hideshow")){
            document.getElementById('searchModal').style.display = "block";
        }else{
            document.getElementById('searchModal').style.display = "none";
        }
    }

}


function connectFeedback() {
	var d1 = new Date();
	var d2 = new Date($("#yes").val());

	if (($("#yesCheck").is(':checked')) && (d2 < d1)) {
		alert("sorry we can't go back in past");
	} else {
		userName = "saransh";
		connectName = "darshan";
		reason = $('#reason-to-connect').val();

		if ($("#yesCheck").is(":checked")) {
			check = "yes";
		} else if ($("#noCheck").is(':checked')) {
			check = "no";
		}
	
		date = $("#yes").val();
		description = $("#description").val();
		/* alert(check);
		alert(reason);
		alert(description);
		alert(date);
		 */
		$.ajax({
			type : "POST",
			url : "../connectMe",
			data : "userName=" + userName + "&connectName=" + connectName
					+ "&reason=" + reason + "&check=" + check + "&date="
					+ date + "&description=" + description,
			success : function(response) {
				alert("Your connect request has been sent");
				console.log(response)
				return false;
			},
			error : function(e) {
				alert('Error: ' + e);
				return false;
			}
		});
	}
}
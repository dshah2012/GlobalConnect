function appendVideoIFrame(temp) {  
	  var url = temp;
      var appendData ='<hr class="hr-rule"/>' + '<div><iframe class="iframe" id="videoIFrameId"class="iframe-account" height="315" width="560" src="' + url + '" frameborder="0" allowfullscreen></iframe></div>';
      var likeDiv = '<div><input type="button" value="Like" onclick="addSessionLike()"><br/></div>';
      $('#chart').html(appendData);
      $('#url').val('');
      getUrlComments(url);
	}
function getUrlComments(url) { 
	console.log("In getComments")
	  $.ajax({  
	    type: "POST",  
	    url: "../GetComments",  
	    data: {url : url},
	    success: function(response){  
	      comments="";
	      videoTitle = "";
          commentsArray = "";
          noOfLikes="";
          comments += '<div class="panel panel-info" style="width: 75.3%;margin-bottom: -35px;"><div class="panel-heading"><img src="../img/user2-160x160.jpg" class="img-circle img-comment" alt="User Image"></img>Comment</div><textarea class="form-control" rows="4" cols="129" id="new-LiveSession-comment"></textarea><button class="btn btn-primary post-btn" onClick="addComment()">Post</button></div>';
 	            $.each(JSON.parse(response), function(key, val) {
	                    videoTitle = val.description;
	                    noOfLikes = val.noOfLikes;
	                    commentsArray = val.commentDTOs;
	                    $.each(commentsArray, function(commentKey, commentValue) {
	                        comments += '<div class="panel panel-info" style="width: 75.3%;margin-top: 5%;">';
	                        comments += '<div class="panel-heading">';
	                        comments += '<i class="fa fa-comment" style="margin-right:5px"></i>';
	                        comments += commentValue.user + '<span id="time-stamp" class="time-stamp-refresh" style="float: right;" data-timestamp="' + commentValue.timeStamp + '">' + timeSince(new Date(commentValue.timeStamp)) + '</span> ' + '</div>';
	                        comments += '<div class="panel-body">';
	                        comments += commentValue.comment;
	                        comments += '</div></div>';
	                    });
//	                    $('#chart').html("");
	                    var appendData = '<div id="comment-wrapper"><h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3>' + comments + '</div>';
	                    if ($(window).width() < 480) {
	                        if (currentPage == "profile.jsp") {
	                            appendData = '<div id="comment-wrapper"><hr class="hr-rule hr-profile"/><h3 style="margin-left: 21%;">Live Streaming :' + videoTitle + ' </h3>' + '' + comments + '</div>';
	                        } else {
	                            appendData = '<div id="comment-wrapper"><hr class="hr-rule"/><h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3>' + '' + comments + '</div>';
	                        }
	                    }
	                    $('#chart').append(appendData);
	                    
	            });
  	      $('#videoTitle').html(videoTitle);
	      $('#noOfLikes').html(noOfLikes + "Likes");
	      $('#comments').html(comments);
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}
function addComment() { 
	console.log("In addComment")
	  var url = $('#videoIFrameId').attr('src');
	  comment= $('#new-LiveSession-comment').val();
	  userId=1;
 	  $.ajax({  
 	    type: "POST",  
 	    url: "../AddComment",
	    data: {url : url, comment : comment, userId : userId},
	    success: function(response){
		      comments="";
		      videoTitle = "";
	          commentsArray = "";
	          noOfLikes="";
	          comments += '<div class="panel panel-info" style="width: 75.3%;margin-bottom: -35px;"><div class="panel-heading"><img src="../img/user2-160x160.jpg" class="img-circle img-comment" alt="User Image"></img>Comment</div><textarea class="form-control" rows="4" cols="129" id="new-LiveSession-comment"></textarea><button class="btn btn-primary post-btn" onClick="addComment()">Post</button></div>';
	 	            $.each(JSON.parse(response), function(key, val) {
		                    videoTitle = val.description;
		                    noOfLikes = val.noOfLikes;
		                    commentsArray = val.commentDTOs;
		                    $.each(commentsArray, function(commentKey, commentValue) {
		                        comments += '<div class="panel panel-info" style="width: 75.3%;margin-top: 5%;">';
		                        comments += '<div class="panel-heading">';
		                        comments += '<i class="fa fa-comment" style="margin-right:5px"></i>';
		                        comments += commentValue.user + '<span id="time-stamp" class="time-stamp-refresh" style="float: right;" data-timestamp="' + commentValue.timeStamp + '">' + timeSince(new Date(commentValue.timeStamp)) + '</span> ' + '</div>';
		                        comments += '<div class="panel-body">';
		                        comments += commentValue.comment;
		                        comments += '</div></div>';
		                    });
//		                    $('#chart').html("");
		                    var appendData = '<h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3>' + comments
		                    if ($(window).width() < 480) {
		                        if (currentPage == "profile.jsp") {
		                            appendData = '<hr class="hr-rule hr-profile"/><h3 style="margin-left: 21%;">Live Streaming :' + videoTitle + ' </h3>' + '' + comments
		                        } else {
		                            appendData = '<hr class="hr-rule"/><h3 style="margin-left: 21%;">Live Streaming ' + videoTitle + ' </h3>' + '' + comments
		                        }
		                    }
		                    $('#comment-wrapper').html(appendData);
//		                    $('#chart').append(appendData);
		                    
		            });
	  	      $('#videoTitle').html(videoTitle);
		      $('#noOfLikes').html(noOfLikes + "Likes");
		      $('#comments').html(comments);
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}
function addSessionLike() {  
	  var url = $('#videoIFrameId').attr('src');
	  userId=1;
	  $.ajax({  
	    type: "POST",  
	    url: "addLike.htm",
	    data: "url=" + url + "&userId=" + userId,
	    success: function(response){
	      $('#noOfLikes').html(response + "Likes");
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}

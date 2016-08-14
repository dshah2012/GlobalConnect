$("body").prepend('<table style="width:100%;"><tr><td align="center"><img src="../img/logo.png" alt="Global Edify Logo" style="width:100px;"></td></tr></table>');
	
$(document).ready(function() {
  setTimeout(function() {
		$(".profile-progress").css("display", "none");
		$(".company-logos").css("display", "none");

		$(".profile-body-content-noprintable").css("display", "none");
		$(".row.preferred-table tr .col-md-1").css("display", "none");
		
		$(".profile-topic-add").css("visibility", "hidden");
		$(".editable i, i.edit-languages").css("visibility", "hidden");
		$(".edit-personal-info").css("visibility", "hidden");
		$(".model-content.profile-body-content-nonadd, .model-content.profile-body-content").css("width", "100%");
	
		$('.model-content.profile-header-content').css("width", "50%");
		$("#personal-info").next().css("width", "50%");
		$("#personal-info").next().find(".profile-topic-heading").css("visibility", "hidden");
		$(".editable .edit-education").css("visibility", "hidden");
		$(".edit-real-time-experience, .edit-languages, .edit-awardsAndHonors, .edit-patents, .edit-training-experience").css("visibility", "hidden");
	
		$("#personal, #banking").css("display", "none");
		$("#about-me").next().css("display", "none");
	
		$("#personal-info").next().find(".row div").removeClass("col-md-6").removeClass("col-md-5").removeClass("col-md-4").css({ "display": "inline" });
		$("#personal-info").next().find(".row div").css("font-size", "15px");
		$("#personal-info").next().find(".row").css({ "padding-bottom": "15px" });
		

		$('.model-content.profile-header-content').after($("#personal-info").next());
		
        window.print();
        window.close();

  	}, 2000);
});

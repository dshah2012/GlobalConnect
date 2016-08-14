var trainer;
var userid = 1; /* hardcoded */
// When the document loads
$(document).ready(function() {
	$(".add-hide").hide();
	$('#realtime-experience').hide();
	// changeSelectTab();
	$.ajax({
		url : "../GetProfile",
		data : {
			user_id : userid
		},
		success : function(result) {
			trainer = $.parseJSON(result);
			displayProfileHeader();
			displayAboutMe();
			displayPersonalInfo();
			displayContactInfo();
			displayPreferredContact();
			displayJobEmployments();
			displayCertification();
			displayPatents();
			displayHonorsAndAwards();
			displayEducation();
			displayAddress();
			displayLanguage();
			displayExperience();
			displaySkills();
			profileTop();
			
			
			

		}
	});
	
});
function displayProfileHeader(){
	$('#trainer-profile-pic').html('');
	if(!trainer.hasOwnProperty('profilePicUrl')){
		$('#trainer-profile-pic').append(
				'<img src="../profilePics/dummyProfile.png" class="img-rounded" alt="Cinque Terre"'+
					'width="150" height="150" id="profilePicURL" />'+
			'<form method="post" action="Javascript:UploadProfilePic()" enctype="multipart/form-data">'+
				'<input class="always-hide" type="text" id="tpid">'+
				' <input class="update" type="file" value="Update" id="profilePicId" '+
				 'accept="image/gif, image/jpeg, image/jpg, image/png, image/bmp" value=""/>'+
				' <input type="submit" value="Upload" />'+
			'</form>'
				
		);
		$('#tpid').val(trainer.trainerProfileId);
	}
	else{
		$('#trainer-profile-pic').append(
				'<img src="'+
				trainer.profilePicUrl+'"'+
				' class="img-rounded" alt="Cinque Terre"'+
					'width="150" height="150" id="profilePicURL" />'+
			'<form method="post" action="Javascript:UploadProfilePic()" enctype="multipart/form-data">'+
				'<input class="always-hide" type="text" id="tpid">'+
				' <input class="update" type="file" value="Update" id="profilePicId" '+
				 'accept="image/gif, image/jpeg, image/jpg, image/png, image/bmp" value=""/>'+
				' <input type="submit" value="Upload" />'+
			'</form>'
				
		);
		$('#tpid').val(trainer.trainerProfileId);
	}
}


function UploadProfilePic() {

    var tpid = document.getElementById("tpid").value;

    var profilePicId = document.getElementById("profilePicId").files[0];

    var formdata = new FormData();

    formdata.append("tpid", tpid);

    formdata.append("profilePicId", profilePicId);

    var xhr = new XMLHttpRequest();       

    xhr.open("POST","../FileUploader", true);

    xhr.send(formdata);

    xhr.onload = function(e) {

        if (this.status == 200) {
          // document.getElementById("profilePicURL").src=this.responseText;
        	trainer.profilePicUrl=this.responseText;
        	displayProfileHeader();
           
        }

    };                    

}   

function profileTop(){
	$('.profile-header-content h1>b').text(trainer.personalInfo.firstName+ ' ' + 
			trainer.personalInfo.lastName);
	$.each(trainer.workExperiences,function(index,workExperience){
		if(workExperience.experienceType=="REAL_TIME" && workExperience.current==true){
			
			$('.profile-header-content p:nth-child(2)').text(workExperience.roleName +' ' + 
					workExperience.companyName);
			return false;
		}else{
			if(workExperience.throughvendor==true){
			$('.profile-header-content p:nth-child(2)').text("Trainer at" +' ' + 
					workExperience.vendorName);}
			else{
				$('.profile-header-content p:nth-child(2)').text("Trainer");
			}
		}
	});
	var city = trainer.user.contact.currentAddress.location.city;
	$('.profile-header-content p:nth-child(3)').text(city.charAt(0).toUpperCase() + city.slice(1));
	var email = trainer.user.primaryMailId;
	$('.profile-header-content p:nth-child(4)').text(email);
}
function displayAboutMe() {
	$(".profile-topic-abody").html(trainer.aboutMe);
}
function displayPersonalInfo() {

	$('#firstName').html(trainer.personalInfo.firstName);
	$('#middleName').html(trainer.personalInfo.middleName);
	$('#lastName').html(trainer.personalInfo.lastName);
	$('#gender').html(trainer.personalInfo.gender);
	if (trainer.readyToRelocate == true) {
		$('#readyToRelocate').html("Yes");
	} else {
		$('#readyToRelocate').html("No");
	}
	$('#dateOfBirth').html(trainer.personalInfo.dateOfBirth);
	$('#spouseName').html(trainer.personalInfo.spouseName);
	$('#maritalstatus').html(trainer.personalInfo.maritalstatus);
}

function displayContactInfo() {
	$('#primaryMobileNo').html(trainer.user.contact.primaryMobileNo);
	$('#secondaryMobileNo').html(trainer.user.contact.secondaryMobileNo);
	$('#secondaryMailId').html(trainer.user.contact.secondaryMailId);
	$('#faxNo').html(trainer.user.contact.faxNo);
	$('#residenceNo').html(trainer.user.contact.residenceNo);
	$('#officeContactNo').html(trainer.user.contact.officeContactNo);
}
function displayPreferredContact() {

	$('.dynamic-table tr:gt(0)').remove();
	$
			.each(
					trainer.user.contact.preferredContacts,
					function(index, preferredContact) {
						$('.dynamic-table')
								.append(
										'<tr>'
												+ '<td class="col-md-2">'
												+ preferredContact.priority
												+ '</td>'
												+ '<td class="col-md-4">'
												+ preferredContact.methodOfContact
												+ '</td>'
												+ '<td class="col-md-1">'
												+	'<div class="always-hide">'
												+ preferredContact.preferredContactId
												+'</div>'
												+ '<i class="fa  fa-fw fa-save fa-lg  save-preferred-contact "  >'
												+ " "
												+ ' </i>'
												+ '<i class="fa  fa-fw fa-edit fa-lg  edit-preferred-contact"  >'
												+ " "
												+ ' </i>'
												+ '</td>'
												+ '</tr>');
					});
}
function getFormattedAddressForMap(address){
	var returnResult = "";
	returnResult = returnResult + address.propertyNo +"^" + address.streetName+"^"+address.areaName+"^"+address.landmark+"^"+address.location.city +"^";
	returnResult = returnResult + address.location.state + "^" + address.location.country +"^" + address.pincode;
	return returnResult;
}

function displayAddress() {
	var addresses = [];
	var isAddressFoundForMap = false;
	var addressFoundForMap = "";
	if (trainer.user.contact.hasOwnProperty('currentAddress')) {
		addresses.push('currentAddress');
		addressFoundForMap = getFormattedAddressForMap(trainer.user.contact.currentAddress);
		isAddressFoundForMap = true;
	}
	if (trainer.user.contact.hasOwnProperty('officeAddress')) {
		addresses.push('officeAddress');
		if(!isAddressFoundForMap){
			addressFoundForMap = getFormattedAddressForMap(trainer.user.contact.currentAddress);
			isAddressFoundForMap = true;
		}
	}
	if (trainer.user.contact.hasOwnProperty('permanentAddress')) {
		addresses.push('permanentAddress');
		if(!isAddressFoundForMap){
			addressFoundForMap = getFormattedAddressForMap(trainer.user.contact.currentAddress);
			isAddressFoundForMap = true;
		}
	}
	$('#address-div-update').html("");
	if(isAddressFoundForMap){
		// Load map Image if loaded on the profile page
		var mapImgButton = $("#map-button");
		if(mapImgButton.length){
			getUserAddress(addressFoundForMap);
		}
	}
	if (addresses.length == 3) {
		$
				.each(
						addresses,
						function(index, address) {

							$('#address-div-update')
									.append(
											'<div class="profile-topic-contact-'
													+ address
													+ ' col-md-4" id="'
													+ address
													+ '">'
													+ '<div class="profile-topic-address-heading">'
													+ address
												    +'</div>'
													+ '<div class="'
													+ address
													+ 'division"></div>'
													+ '<span class="profile-topic-propertyno">'
													+ trainer.user.contact[address].propertyNo
													+ ','+' '
													+ '</span>'
													+ '<span class="profile-topic-street">'
													+ trainer.user.contact[address].streetName
													+ ','
													+ '</span>'
													+ '<span class="profile-topic-area">'
													+ trainer.user.contact[address].areaName
													+ ','+' '
													+ '</span>'
													+ '<span class="profile-topic-landmark">'
													+ trainer.user.contact[address].landmark
													+ ','+' '
													+ '</span>'
													+ '<span class="profile-topic-location">'
													+ trainer.user.contact[address].location.city
													+ ','+' '
													+ trainer.user.contact[address].location.state
													+ ','+' '
													+ trainer.user.contact[address].location.country
													+ '</span>'
													+ '<span class="profile-topic-pincode">Pincode-'
													+ trainer.user.contact[address].pincode
													+ '</span>' + '</div>'
													+ '</div>'

									);

						});
	} else {
		$
				.each(
						addresses,
						function(index, address) {
							$('#address-div-update')
									.append(
											'<div class="profile-topic-contact-'
													+ address
													+ ' col-md-6" id="'
													+ address
													+ '">'
													+ '<div class="profile-topic-address-heading">'
													+ address
													+'</div>'
													+ '<div class="'
													+ address
													+ 'division"></div>'
													+ '<span class="profile-topic-propertyno">'
													+ trainer.user.contact[address].propertyNo
													+ ','+' '
													+ '</span>'
													+ '<span class="profile-topic-street">'
													+ trainer.user.contact[address].streetName
													+ ','+' '
													+ '</span>'
													+ '<span class="profile-topic-area">'
													+ trainer.user.contact[address].areaName
													+ ','+' '
													+ '</span>'
													+ '<span class="profile-topic-landmark">'
													+ ','+' '
													+ trainer.user.contact[address].landmark
													+ '</span>'
													+ '<span class="profile-topic-location">'
													+ trainer.user.contact[address].location.city
													+ ','+' '
													+ trainer.user.contact[address].location.state
													+ ','+' '
													+ trainer.user.contact[address].location.country
													+ '</span>'
													+ '<span class="profile-topic-pincode">Pincode-'
													+ trainer.user.contact[address].pincode
													+ '</span>' + '</div>'
													+ '</div>'
									);

						});
	}
}

function displayLanguage() {
$('#language-update').html("");
	$
			.each(
					trainer.personalInfo.languagesknown,
					function(index, language) {
						displayLanguageInProfile(index, language)
					});
}

function displayLanguageInProfile(index, language){
	var lang = [];
	var langDescription = "";
	if (language.canRead == true) {
		lang.push("Read");
	}
	if (language.canWrite == true) {
		lang.push("Write");
	}
	if (language.canSpeak == true) {
		lang.push("Speak");
	}
	for (var i = 0; i < lang.length - 1; i++) {
		langDescription = langDescription + lang[i] + ',';
	}
	langDescription = langDescription
			+ lang[lang.length - 1];

	$('#language-update')
			.append(
					'<div class="profile-topic-body  languages col-md-6">'
							+ '<div class="col-md-12 profile-topic-inner-heading"></div>'
							+ language.spokenLanguage.languageName+
							'<div class="always-hide">'+language.langKnownId+'</div>'
							+ 
							'<i class="fa  fa-fw fa-edit fa-lg pull-right edit-languages"></i>'
							+ '<div class="col-md-12  profile-topic-inner-discription">'
							+ langDescription + '</div>'
							+ '</div>');
	
}

function displayExperience() {
	$('#industry-update').html("");
	$('#training-update').html("");
	
	$.each(trainer.workExperiences, function(index, workExperience) {

		if (workExperience.experienceType == "REAL_TIME") {
			
			displayRealTimeExperienceInProfile(index, workExperience);
		
		} else {
			displayTrainingExperienceInProfile(index, workExperience);
		}
	});

}

function displayTrainingExperienceInProfile(index, workExperience){
	$("#training-update").append('<div>'+
			'<div id="inner-experience">' + workExperience.client.clientName
					+ '</div>'+'<div class="always-hide">'+
					workExperience.workExperienceId+'</div>'+
					'<i class="fa  fa-fw fa-edit fa-lg pull-right edit-training-experience"></i>'
					+ '<div class="profile-topic-experience-company">'
					+ workExperience.client.clientName + '</div>'
					+ '<div class="profile-topic-experience-duration">'
					+ getDateInMonthAndYear(workExperience.startDate)
					+ '-'
					+ getDateInMonthAndYear(workExperience.endDate)
					+ '</div>'
					+ '<div class="profile-topic-experience-content">'
					+ workExperience.description + '</div></div>');
}


function displayRealTimeExperienceInProfile(index, workExperience){
	$("#industry-update").append('<div>'+
			'<div id="inner-experience">' + workExperience.roleName
					+ '</div>'+'<div class="always-hide">'+
					workExperience.workExperienceId+'</div>'+
					'<i class="fa  fa-fw fa-edit fa-lg pull-right edit-real-time-experience"></i>'
					+ '<div class="profile-topic-experience-company">'
					+ workExperience.companyName + '</div>'
					+ '<div class="profile-topic-experience-duration">'
					+ getDateInMonthAndYear(workExperience.startDate)
					+ '-'
					+ getDateInMonthAndYear(workExperience.endDate)
					+ '</div>'
					+ '<div class="profile-topic-experience-content">'
					+ workExperience.description + ' </div></div>');
}

function displayEducation() {
	$.each(trainer.educations,function(index, education) {
		addEducationInProfile(index, education);
	});
}

function addEducationInProfile(index, education){
	$('#education-div')
	.append(
			'<div class="editable">'+
					'<div class="always-hide">'+
					education.educationId+'</div>'
					+ '<i class="fa  fa-fw fa-edit fa-lg pull-right edit-education"  ></i>'
					+ '<div class="profile-topic-education-instituteName">'
					+ education.instituteName
					+ '</div>'
					+ '<div class="profile-topic-education-degree">'
					+ education.fieldOfStudy
					+ ','
					+ education.location.city
					+ '</div>'
					+ '<div class="profile-topic-education-duration">'
					+ education.startYear + '-'
					+ education.yearOfPassing
					+ '</div>' + '</div>');
}

function displaySkills() {
	$.each(trainer.skillset, function(index, skillObj) {
		displaySkillsInProfile(index, skillObj);
	});
}
function displaySkillsInProfile(index, skillObj){
	$('#skill-set-div').append('<li>' + skillObj.skill.skillName + '</li>');
}
function displayCertification() {
	$
			.each(
					trainer.certificates,
					function(index, certification) {
						displayCertificates(index, certification)
						
					});
}

function displayCertificates(index, certification){
	$("#certification-update")
	.append(
			'<div class="editable">'+
			'<div class="always-hide">'+
			certification.certificateId+'</div>'
					+ '<i class="fa  fa-fw fa-edit fa-lg pull-right edit-certification"  ></i>'
					+ '	<div class=" profile-topic-inner-heading"> '
					+ certification.certificationName
					+ ' </div>'
					+ '	<div class=" profile-topic-certification-company"> '
					+ certification.institutionName
					+ '</div>'
					+ '	<div class=" profile-topic-certification-month"> '
					+ getDateInMonthAndYear(certification.certifiedDate)
					+ '</div>' + '</div>');
	
}

function displayHonorsAndAwards(){
	$.each(trainer.honorAndAwards,function(index, awards){
		
				addAwardsInProfile(index, awards);
		
	});
}

function addAwardsInProfile(index, honorsAndAwards){

	$("#awardsAndHonorsdiv").append(
			
			'<div class="editable">'+
			'<div class="always-hide">'+honorsAndAwards.honorAndAwardId+'</div>'+
			'<i class="fa  fa-fw fa-edit fa-lg pull-right edit-awardsAndHonors"  ></i>'+
			'<div class="profile-topic-inner-heading">'+honorsAndAwards.honorAndAwardTitle+'</div>'+
			'<div class="inline">'+'<span class="profile-topic-awardAndHonor-issuer">'+
			honorsAndAwards.issuer + '</span><span> | </span>'+'<span class="profile-topic-awardAndHonor-dateOfIssue">'
			+getDateInMonthAndYear(honorsAndAwards.dateOfIssue)+'</span><span> | </span> '+
			'<span class="profile-topic-awardAndHonor-Occupation">'+honorsAndAwards.occupation+'</span></div></div>'
	);
}
function displayPatents(){
	var patentStatus;
	$.each(trainer.patents,function(index,patents){
		
		addPatentInProfile(index,patents);
	});
}
function addPatentInProfile(index,patents){
	if(patents.patentStatus_IsIssued==true){
		 patentStatus = "Issued";
	}
	else{
		patentStatus = "Not Issued";
	}
	$('#patentsdiv').append(
			
			'<div class="editable">' +
			'<div class="always-hide">'+patents.patentId+
			'</div>'+
			'<i class="fa  fa-fw fa-edit fa-lg pull-right edit-patents"  ></i>'+
			'<div class="profile-topic-inner-heading">'+patents.title+'</div>'+
			'<div class="inline">'+
			'<span class="profile-topic-patent-office">'+patents.patentOffice+'</span><span> | </span>'+
			'<span class="profile-topic-patent-dateOfIssue">'+getDateInMonthAndYear(patents.dateOfIssue)+
			'</span><span> | </span>'+
			'<span class="profile-topic-patent-status">'+patentStatus+'</span>'+
			'<div class="profile-topic-patent-url">'+'<a href='+patents.patentUrl+'>'+patents.patentUrl+'</a></div>'+
			'<div class="profile-topic-patent-description">'+patents.description+'</div></div>'
	);
}
		

function displayJobEmployments(){
	var endDate
	$.each(trainer.jobEmployments,function(index,employment){
		addJobInProfile(index,employment);
	});

}

function addJobInProfile(index, employment){
	if(employment.endDate=="NA"){
		endDate = "Present";
	}else{
		endDate = getDateInMonthAndYear(employment.endDate);
	}
	$('#employment').append(
			'<div class="editable">'+
			'<div class="always-hide">'+employment.jobEmploymentId+'</div>'+
			'<i class="fa  fa-fw fa-edit fa-lg pull-right edit-employment"></i>'+
			'<div class="profile-topic-inner-heading">'+employment.designation+'</div>'+
			'<div class="profile-topic-employment-company">'+employment.organizationName+'</div>'+
			'<div class="profile-topic-date">'+
			'<span class="profile-topic-employment-start-date">'+getDateInMonthAndYear(employment.startDate)+'</span>'+
			' - <span class="profile-topic-employment-end-date">'+endDate+'</span>'+
			'</div></div>'
	);
}

function editAboutMe() {

	trainer.aboutMe = "about me changed";
	displayAboutMe();
}
// This is to edit patents and awards and honours

$('body').on("click",'.edit-patents',function (){
					$('#add-patents').show();
					$('#patents').show();
					$('#patents').insertAfter($(this).parent());
					$("#patents").css("width", "100%");
					var editPatentsId=$(this).parent().find('.always-hide').text();
					$.each(trainer.patents, function(index, patent) {
						if(patent.patentId==editPatentsId){
							$('#patent-title').val(patent.title);
							$('#date-of-issue').val(getFormattedDate(patent.dateOfIssue));
							$('#patent-application-number').val(patent.patentApplicationNumber);
							$('#patent-office').val(patent.patentOffice);
							if(patent.patentStatus_IsIssued==true){
								$("#Issued").attr('checked', 'checked');
							}else if(patent.patentStatus_IsIssued==false)
								{
									$("#Not-Issued").attr('checked', 'checked');
								}
							$('#patent-url').val(patent.patentUrl);
							$('#patent-description').val(patent.description);
						}
						
					});
					$('#patents').show();
					
					//Appending id to form
					$('#patents').find('.always-hide').text(editPatentsId);
				
					
});

$('body').on('click','.edit-awardsAndHonors',function (){
			$('#add-awardsAndHonors').show();
			$('#awardsAndHonors').show();
			$('#awardsAndHonors').insertAfter($(this).parent());
			$("#awardsAndHonors").css("width", "100%");

			var editAwardId=$(this).parent().find('.always-hide').text();
			$.each(trainer.honorAndAwards, function(index, honorsAndAward) {
				if(honorsAndAward.honorAndAwardId==editAwardId){
					$('#awardAndHonor-title').val(honorsAndAward.honorAndAwardTitle);
					$('#awardsAndHonors #date-of-issue').val(getFormattedDate(honorsAndAward.dateOfIssue));
					$('#awardAndHonor-occupation').val(honorsAndAward.occupation);
					$('#awardAndHonor-issuer').val(honorsAndAward.issuer);
					
				}
			});
			
			
			$('#awardsAndHonors').show();
			
			//Appending id to form
			$('#awardsAndHonors').find('.always-hide').text(editAwardId);
			
			

		});

// This is the code for adding and editing the patents and honors
// This is to add the patents
$('#add-patents').on("click", function() {
	$(this).hide();
	$('#patents').insertAfter($(this));
	$('#patents').show();
	$("#patents").css("width", "73%");
	$('#patents').find('#patent-title').val("");
	$('#patents').find('#date-of-issue').val("");
	$('#patents').find('#patent-application-number').val("");
	$('#patents').find('#patent-office').val("");
	$('#patents').find('#patent-status').val("");
	$('#patents').find('#patent-url').val("");
	$('#patents').find('#patent-inventors').val("");
	$('#patents').find('#patent-description').val("");
});

$("#patentsdiv").on("click", '.save-add', function() {

});

// This is to add the awardsandHOoors
$('#add-awardsAndHonors').on("click", function() {
	$(this).hide();
	$('#awardsAndHonors').insertAfter($(this));
	$('#awardsAndHonors').show();
	$("#awardsAndHonors").css("width", "73%");
	$('#awardsAndHonors').find('#awardsAndHonor-title').val("");
	$('#awardsAndHonors').find('#date-of-issue').val("");
	$('#awardsAndHonors').find('#awardAndHonor-occupation').val("");
	$('#awardsAndHonors').find('#awardAndHonor-issuer').val("");
});

// This is the code for adding and editing the employment
$('#add-employment').on("click", function() {
	$(this).hide();
	$('#job').insertAfter($(this));
	$('#job').show();
	$("#job").css("width", "73%");
	$("#job").find('#designation').val("");
	$("#job").find('#company').val("");
	$("#job").find('#start-date').val("");
	$("#job").find('#end-date').val("");
	$("#job").find('#package').val("");

});


$(".model-content-employment").on(
		"click",
		'.save-add',
		function() {
			var designation = $(this).closest('#job').find('#designation')
					.val();

			$(this).closest('#job').prev().find(
					'.profile-topic-employment-designation').text(designation);

			var company = $(this).closest('#job').find('#company').val();

			$(this).closest('#job').prev().find(
					'.profile-topic-employment-company').text(company);

			var startDate = $(this).closest('#job').find('#start-date').val();

			$(this).closest('#job').prev().find(
					'.profile-topic-employment-start-date').text(getDateInMonthAndYear(startDate));

			var endDate = $(this).closest('#job').find('#end-date').val();

			$(this).closest('#job').prev().find(
					'.profile-topic-employment-end-date').text(getDateInMonthAndYear(endDate));

			var package1 = $(this).closest('#job').find('#package').val();

			$(this).closest('#job').prev().find(
					'.profile-topic-employment-package').text(package1);

			$('#job').hide();
		});

$('#add-experience').on("click",function() {
	
	$(this).hide();
	$('#experience').show();
	$('#experience').insertAfter($(this));
	$("#experience").css("width","73%");
	$('#training-experience')
	$('#training-experience').find('#start-date').val("");
	$('#training-experience').find('.always-find').val("");
	$('#training-experience').find('#end-date').val("");
	$('#training-experience').find('#pocName').val("");
	$('#training-experience').find('#pocContactNo').val("");
	$('#training-experience').find('#description').val("");
	$('#training-experience').find('#clientName').val("");
	$('#training-experience').find('#start-time').val("");
	$('#training-experience').find('#end-time').val("");
	$('#training-experience').find('#workedLocation').val("");
	$('#training-experience').find('#vendor-name').val("");
	$('#training-experience').find('#add-skill-training').val("");
	$('#training-experience').find('#duration-training').val("");
	$('#training-experience').find('#skill-category-training').val("");
	
	

	
	$('#training-skilltable').find('tr:gt(0)').remove();
	var elements = document.forms['training-form'].elements;
	//$('#experience').find('#institute-name').val("");
	
	//$('#experience').find('#degree').val("");
	//$('#experience').find('#specialization').val("");
	
	//$('#experience').find('#city').val("");

});
	
$('#training-experience input[name=is-vendor]').on('change', function() {
	
	if($('input[name=is-vendor]:checked', '#training-experience').val()=="yes"){
		$("#vendor-name").show();
	}
	else{
		$("#vendor-name").hide();
	}
		
});
$('.experience-type').on('change', function() {

if($(this).val() == "training-experience"){
$('#training-experience').show();
$('#realtime-experience').hide();
}
else if($(this).val() == "realtime-experience"){
$('#training-experience').hide();
$('#realtime-experience').show();
}

});

$('.add-new-skill div:first-child').on('click','i',function(){
$('.add-new-skill div:first-child').append(
		'<label>Add New Skill</label><br>'+
						'<input type="text" class="add-skill  form-control " placeholder="Add Skill" > '+ ' '+
						'<input type="text" class="duration  form-control " placeholder="Duration" > '+
						'<i class="fa  fa-fw fa-plus fa-lg pull-right "></i>'
);
});
$('.cancel-skill').on('click',function(){
var appenndedSkill = $( this ).parent().prev();
appenndedSkill.find('i:first').nextAll().remove();
});

$(function() {
	$('.cancel-add').click(function() {
		$(this).parent().parent().hide();
		$(this).parent().parent().prev().show();
	});
	$('.cancel-address').click(function() {
		$('#address').hide();
		$('#add-address').show();
	});
	$('#cancel-aboutme').click(function() {
		$('#about-me').hide();
	})
	$('#cancel-personalInfo').click(function() {
		$('#personal-info').hide();
	})
	$('#cancel-certificateInfo').click(function() {
		$('#certificationtest').hide();
		$("#add-certification").show();
		
	})
	$('#cancel-patent').click(function() {
		$('#patents').hide();
		$('#add-patents').show();
		
	})
	$('#cancel-award').click(function() {
		$('#awardsAndHonors').hide();
		$('#add-awardsAndHonors').show();
		
	})
	$('#cancel-educationInfo').click(function() {
		$('#education').hide();
		$('#add-education').show();
	})
	$('#cancel-job').click(function() {
		$('#job').hide();
		$('#add-employment').show();
	})
	
	$('#cancel-lanugage').click(function() {
		$('#languages').hide();
		$('#add-languages').show();
	})
	$('#cancel-skillSet').click(function() {
		$('#skillSet').hide();
		$('#add-skillSet').show();
	})
	$('#cancel-realTimeForm').click(function() {
		$('#experience').hide();
		$('#add-experience').show();
			  
	})
	$('#cancel-trainingForm').click(function() {
		$('#experience').hide();
		$('#add-experience').show();
		 $("#training-skilltable").find("tr:gt(0)").remove();
	})
	$('#cancel-preferredContact').click(function() {
		$('#preferred-contact').hide();
		$('#add-preferred-contact').show();
			  
	})
	
	
	
	
});

function editAboutMe() {
	trainer.aboutMe = document.getElementById("about-me-text").value;
	$.ajax({
		url : "../EditAboutMe",
		data : {
			user_id : userid,
			aboutMe : trainer.aboutMe
		},
		success : function(result) {
			displayAboutMe();
			$('#about-me').hide();
		}
	});
}
function editPersonalInfo() {
	var elements = document.forms['personalInfoForm'].elements;
	trainer.personalInfo.firstName = elements[0].value;
	trainer.personalInfo.middleName = elements[1].value
	trainer.personalInfo.lastName = elements[2].value
	if($(elements[3]).is(':checked')){
		trainer.personalInfo.gender="MALE";
	}
	else{
		trainer.personalInfo.gender="FEMALE";
	}
	if($(elements[5]).is(':checked')){
		trainer.personalInfo.maritalstatus="SINGLE";
	}
	else{
		trainer.personalInfo.maritalstatus="MARRIED";
	}
	
	if($(elements[9]).is(':checked')){
		trainer.readyToRelocate=true;
	}
	else{
		trainer.readyToRelocate=false;
	}
	
	trainer.personalInfo.spouseName = elements[7].value
	trainer.personalInfo.dateOfBirth = elements[8].value
	
	var personalInfo = {
		personalInfoId : trainer.personalInfo.personalInfoId,
		firstName : elements[0].value,
		middleName : elements[1].value,
		lastName : elements[2].value,
		gender : trainer.personalInfo.gender,
		maritalstatus : trainer.personalInfo.maritalstatus,
		spouseName : elements[7].value,
		dateOfBirth : elements[8].value,
		readyToRelocate : trainer.readyToRelocate
	};
	var personalInfoJson = JSON.stringify(personalInfo);
	$.ajax({
		url : "../EditPersonalInfo",
		data : {
			user_id : userid,
			personalInfo : personalInfoJson
		},
		success : function(result) {
			displayPersonalInfo();
			$('#personal-info').hide();
		}
	});

}
// Cancel button function


function editEducation(){
	var educationInfo;
	var elements = document.forms['educationForm'].elements;
	var editEduId=$(document.forms['educationForm']).find('.always-hide').text();
	$.each(trainer.educations, function(index, education) {
		if(education.educationId==editEduId){
			education.instituteName=elements[0].value;
			education.courseName=elements[1].value;
			education.fieldOfStudy=elements[2].value;
			education.startYear=elements[3].value;
			education.yearOfPassing=elements[4].value;
			education.courseDuration=elements[5].value;
			education.boardName=elements[6].value;
			education.percentage=elements[7].value;
			education.location.city=elements[8].value;
			education.location.state=elements[9].value;
			education.location.country=elements[10].value;
		
		educationInfo= {
				educationId: editEduId,
				courseName: education.courseName,
				instituteName:education.instituteName ,
				fieldOfStudy: education.fieldOfStudy,
				percentage: education.percentage,
				startYear: education.startYear,
				courseDuration: education.courseDuration,
				boardName: education.boardName,
				yearOfPassing: education.yearOfPassing,
				location: {
					city: education.location.city,
					state: education.location.state,
					country: education.location.country
				}
		}
		}
	});
	
	var educationJson=JSON.stringify(educationInfo);

	// set status of the editable div for which ajax call is being made
	$("#education").prev(".editable").attr("data-ajax-status", "saving");
	$.ajax({
		url : "../EditEducation",
		data : {
			user_id : userid,
			educationJson : educationJson
		},
		success : function(result) {
//			$('#education-div div:first-child').nextAll().html('');
			displayEditedEducation();
			$('#education').hide();
		}
	});

}

function displayEditedEducation(){

	// Target div which data to be replaced
	var tmpEditable = $("#education").siblings(".editable[data-ajax-status='saving']");
	tmpEditable.removeAttr("data-ajax-status");
	
	// Edit form from the data is to be taken
	var tmpEditForm = $("#education form");

	var tmpIndex = $("#education").siblings(".editable").index(tmpEditable);
	
	// Change value in the div
	tmpEditable.find(".profile-topic-education-instituteName").html(tmpEditForm.find("#institute-name").val());
	tmpEditable.find(".profile-topic-education-degree").html(tmpEditForm.find("#specialization").val() + "," + tmpEditForm.find("#city").val());
	tmpEditable.find(".profile-topic-education-duration").html(tmpEditForm.find("#start-date").val() + "-" + tmpEditForm.find("#end-date").val());
	
}


function editContactInfo() {
	var elements = document.forms['contactInfoForm'].elements;
	trainer.user.contact.primaryMobileNo = elements[0].value;
	trainer.user.contact.secondaryMobileNo = elements[1].value;
	trainer.user.contact.secondaryMailId = elements[2].value;
	trainer.user.contact.faxNo = elements[3].value;
	trainer.user.contact.residenceNo = elements[4].value;
	trainer.user.contact.officeContactNo = elements[5].value;
	
	
	var contactInfo = {
		contactId : trainer.user.contact.contactId,
		primaryMobileNo : elements[0].value,
		secondaryMobileNo : elements[1].value,
		secondaryMailId : elements[2].value,
		faxNo : elements[3].value,
		residenceNo : elements[4].value,
		officeContactNo : elements[5].value,
	};
	var contactInfoJson = JSON.stringify(contactInfo);
	$.ajax({
		url : "../EditContactInfo",
		data : {
			user_id : userid,
			contactInfo : contactInfoJson
		},
		success : function(result) {
			displayContactInfo();
			$('#contact-info').hide();
		}
	});

}


function editCertificationInfo(){
	var editCertification;
	var elements = document.forms['certificationInfoForm'].elements;
	var editCerId=$(document.forms['certificationInfoForm']).find('.always-hide').text();
	$.each(trainer.certificates, function(index, certificate) {
		if(certificate.certificateId==editCerId){
			certificate.institutionName = elements[0].value;
			certificate.certifiedDate = elements[1].value;
			certificate.grade = elements[2].value;
			certificate.certificationName = elements[3].value;
			certificate.certificateUrl = elements[4].value;
			
			
		editCertification= {
				certificateId: editCerId,
				institutionName: certificate.institutionName,
				certifiedDate:certificate.certifiedDate ,
				grade: certificate.grade,
				certificationName: certificate.certificationName,
				certificateUrl: certificate.certificateUrl,
		}
		}
	});
	var certificationJson=JSON.stringify(editCertification);
//	alert(certificationJson)
	
	// set status of the editable div for which ajax call is being made
	$("#certificationtest").prev(".editable").attr("data-ajax-status", "saving");
	$.ajax({
		url : "../EditCertificationInfo",
		data : {
			user_id : userid,
			certificationJsonInfo : certificationJson
		},
		success : function(result) {
			// $('#certificationdiv div:first-child').nextAll().html('');
			// Function which edits certification
			displayEditedCertification();
			$('#certificationtest').hide();
		}
	});
}

function displayEditedCertification(){
	
	// Target div which data to be replaced
	var tmpEditable = $("#certificationtest").siblings(".editable[data-ajax-status='saving']");
	tmpEditable.removeAttr("data-ajax-status");
	
	// Edit form from the data is to be taken
	var tmpEditForm = $("#certificationtest form");

	var tmpIndex = $("#certificationtest").siblings(".editable").index(tmpEditable);
	
	// Change value in the div
	tmpEditable.find(".profile-topic-inner-heading").html(tmpEditForm.find("#certificate-name").val());
	tmpEditable.find(".profile-topic-certification-company").html(tmpEditForm.find("#institute-name").val());
	tmpEditable.find(".profile-topic-certification-month").html(getDateInMonthAndYear(tmpEditForm.find("#certified-date").val()));
	
	// Change value in the trainer.certificates
//	trainer.certificates[tmpIndex].certificateUrl = tmpEditForm.find("#grade").val();
//	trainer.certificates[tmpIndex].certificationName = tmpEditForm.find("#certificate-name").val();
//	trainer.certificates[tmpIndex].certifiedDate = tmpEditForm.find("#certified-date").val();
//	trainer.certificates[tmpIndex].grade = tmpEditForm.find("#grade").val();
//	trainer.certificates[tmpIndex].institutionName = tmpEditForm.find("#institute-name").val();
}

function editPatent(){
	var patentInfo;
	var elements = document.forms['patentForm'].elements;
	var editpatentId=$(document.forms['patentForm']).find('.always-hide').text();
	$.each(trainer.patents, function(index, patent) {
		if(patent.patentID==editpatentId){
			patent.title=elements[0].value;
			patent.dateOfIssue=elements[1].value;
			patent.patentApplicationNumber=elements[2].value;
			patent.patentOffice=elements[3].value;
			if($(elements[4]).is(':checked')){
				patent.patentStatus_IsIssued=true;
			}
			else if($(elements[5]).is(':checked')){
				patent.patentStatus_IsIssued=false;
			}
			patent.patentUrl=elements[6].value;
			patent.inventors=elements[7].value;
			patent.description=elements[8].value;
			
			var patentarr=patent.inventors.split(',');
			
			patentInfo={
					patentID:editpatentId,
					title: patent.title,
					dateOfIssue:patent.dateOfIssue,
					patentApplicationNumber:patent.patentApplicationNumber,
					patentOffice : patent.patentOffice,
					patentStatus_IsIssued : patent.patentStatus_IsIssued,
					patentUrl:patent.patentUrl,
					inventors:patentarr,
					description:patent.description
			}
			
		}
	
	});
	var patentInfoJson=JSON.stringify(patentInfo);
	
	// set status of the editable div for which ajax call is being made
	$("#patents").prev(".editable").attr("data-ajax-status", "saving");
	$.ajax({
		url : "../EditPatentInfo",
		data : {
			user_id : userid,
			patentInfoJson : patentInfoJson
		},
		success : function(result) {
			displayEditedPatents();
			$('#patents').hide();
		}
	});

}

function displayEditedPatents(){

	// Target div which data to be replaced
	var tmpEditable = $("#patents").siblings(".editable[data-ajax-status='saving']");
	tmpEditable.removeAttr("data-ajax-status");
	
	// Edit form from the data is to be taken
	var tmpEditForm = $("#patents form");

	var tmpIndex = $("#patents").siblings(".editable").index(tmpEditable);
	
	// Change value in the div
	tmpEditable.find(".profile-topic-inner-heading").html(tmpEditForm.find("#patent-title").val());
	tmpEditable.find(".inline .profile-topic-patent-office").html(tmpEditForm.find("#patent-office").val());
	tmpEditable.find(".inline .profile-topic-patent-dateOfIssue").html(getDateInMonthAndYear(tmpEditForm.find("#date-of-issue").val()));
	tmpEditable.find(".inline .profile-topic-patent-status").html(tmpEditForm.find("input[name='is-issued']:checked").val());
	tmpEditable.find(".inline .profile-topic-patent-url").html(tmpEditForm.find("#patent-url").val());
	tmpEditable.find(".inline .profile-topic-patent-inventors-data").html(tmpEditForm.find("#patent-inventors").val());
	tmpEditable.find(".inline .profile-topic-patent-description").html(tmpEditForm.find("#patent-description").val());
	
}

//Code to save edited Award dynamically
function editAward(){
	var awardInfo;
	var elements = document.forms['awardForm'].elements;
	var awardId=$(document.forms['awardForm']).find('.always-hide').text();
	$.each(trainer.honorAndAwards, function(index, honorsAndAward) {
		if(honorsAndAward.honorAndAwardId==awardId){
			honorsAndAward.honorAndAwardTitle= elements[0].value;
			honorsAndAward.dateOfIssue= elements[1].value;
			honorsAndAward.occupation = elements[2].value;
			honorsAndAward.issuer = elements[3].value;
			awardInfo={
					honorAndAwardId:honorsAndAward.honorAndAwardId,
					honorAndAwardTitle:	honorsAndAward.honorAndAwardTitle,
					dateOfIssue:honorsAndAward.dateOfIssue,
					occupation:honorsAndAward.occupation,
					issuer:honorsAndAward.issuer
			}
			
		}
	});
	var awardInfoJson=JSON.stringify(awardInfo);
	// set status of the editable div for which ajax call is being made
	$("#awardsAndHonors").prev(".editable").attr("data-ajax-status", "saving");
	$.ajax({
		url : "../EditAwardInfo",
		data : {
			user_id : userid,
			awardInfoJson : awardInfoJson
		},
		success : function(result) {
			displayEditedHonorsAndAwards();
			$('#awardsAndHonors').hide();
		}
	});
}

function displayEditedHonorsAndAwards(){
	
	// Target div which data to be replaced
	var tmpEditable = $("#awardsAndHonors").siblings(".editable[data-ajax-status='saving']");
	tmpEditable.removeAttr("data-ajax-status");
	
	// Edit form from the data is to be taken
	var tmpEditForm = $("#awardsAndHonors form");

	var tmpIndex = $("#awardsAndHonors").siblings(".editable").index(tmpEditable);
	
	// Change value in the div
	tmpEditable.find(".profile-topic-inner-heading").html(tmpEditForm.find("#awardAndHonor-title").val());
	tmpEditable.find(".inline .profile-topic-awardAndHonor-issuer").html(tmpEditForm.find("#awardAndHonor-occupation").val());
	tmpEditable.find(".inline .profile-topic-awardAndHonor-dateOfIssue").html(getDateInMonthAndYear(tmpEditForm.find("#date-of-issue").val()));
	tmpEditable.find(".inline .profile-topic-awardAndHonor-Occupation").html(tmpEditForm.find("#awardAndHonor-issuer").val());
	
}

$('#add-preferred-contact').on("click", function() {
	$(this).hide();
	$('#preferred-contact').insertAfter($(this));
	$('#preferred-contact').show();
	$("#preferred-contact").css("width", "73%");
});



$('.dynamic-table').on("click", '.remove-preferred-contact', function() {
	$(this).parent().parent().remove();
});





$('.dynamic-table').on(
		"click",
		'.edit-preferred-contact',
		function() {
			var par = $(this).parent().parent();
			var priority = par.children("td.col-md-2");
			var methodOfContact = par.children("td.col-md-4");
			var methodOfContactVal=methodOfContact.html();
			var preferredId=par.children("td.col-md-1").children("div.always-hide").html();
			priority.html("<input type='text' id='txtName' value='"
					+ priority.html() + "' size='8'/>");
			methodOfContact.html('<select  name="methods" id="edit-preferred-method-of-contact" >'+
    								'<option value="MOBILE">MOBILE</option>'+
    								'<option value="EMAIL">EMAIL</option>'+
    								'<option value="SMS">SMS</option>'+
    								'<option value="HOME_PHONE">HOME_PHONE</option>'+
   									'<option value="OFFICE_PHONE">OFFICE_PHONE</option>'+
   									'<option value="FACE_TO_FACE">FACE_TO_FACE</option>'+
   									'<option value="ANY">ANY</option>'+
  							'</select>');
			$("#edit-preferred-method-of-contact").val(methodOfContactVal).attr("selected", "selected");
			$(this).css("display", "none");
			$(this).prev().css("display", "inline-block");
		});


$('.dynamic-table').on("click", '.save-preferred-contact', function() {
	var par = $(this).parent().parent();
	var priority = par.children("td:nth-child(1)");
	var priorityId=par.children("td:nth-child(3)").children("div .always-hide").html();
	var methodOfContact = par.children("td:nth-child(2)");
	var priorityValue=priority.children("input[type='text']").val();
	var methodOfContactValue=methodOfContact.children("select").val();
	priority.html(priorityValue);
	methodOfContact.html(methodOfContactValue);
	var preferredInfo;
	$.each(trainer.user.contact.preferredContacts, function(index, preferredContact) {
		if(preferredContact.preferredContactId==priorityId){
			preferredContact.methodOfContact=methodOfContactValue;
			preferredContact.priority=priorityValue;
			preferredInfo={
					preferredContactId:	preferredContact.preferredContactId,
					methodOfContact:preferredContact.methodOfContact,
					priority:preferredContact.priority
			};			
			
		}
		
	
	});
	var preferredInfoJson=JSON.stringify(preferredInfo);
	$.ajax({
		url : "../EditPreferredContact",
		data : {
			user_id : userid,
			preferredInfoJson : preferredInfoJson
		},
		success : function(result) {
			displayPreferredContact();
		}
	});
	
	$(this).css("display", "none");
	$(this).next().css("display", "inline-block");

});



function addEducation(){
	var educationInfo;
	var elements = document.forms['educationForm'].elements;
	
	$.ajax({
		url : "../AddEducation",
		mehtod:"POST",
		data : {
			instituteName : elements[0].value,
			courseName : elements[1].value,
			fieldOfStudy : elements[2].value,
			startYear : elements[3].value,
			yearOfPassing : elements[4].value,
			courseDuration : elements[5].value,
			boardName : elements[6].value,
			percentage : elements[7].value,
			city : elements[8].value,
			state : elements[9].value,
			country : elements[10].value,
			trainerInfoId: trainer.trainerProfileId
	
			
		},
		success : function(result) {
			var eduList=$.parseJSON(result);
			trainer.educations=eduList;
			
			addEducationInProfile(eduList.length-1, eduList[eduList.length-1]);
			
			$('#education').hide();
			$('#add-education').show();
		}
	});
}


function checkEditAdd(){
	if ($('#education').parents('.model-content-education').length) {
		editEducation();
	}else{
		addEducation();
	}
}


$('body').on("click",'#add-education',function() {
	$(this).hide();
	$('#education').insertAfter($(this));
	$('#education').show();
	$("#education").css("width","73%");
	$('#education').find('#institute-name').val("");
	
	$('#education').find('#degree').val("");
	$('#education').find('#specialization').val("");
	
	$('#education').find('#city').val("");

});
function getFormattedDate(date){
	var formattedDate = new Date(date);
    var dd = formattedDate.getDate();
    var mm = formattedDate.getMonth()+1; 

    var yyyy = formattedDate.getFullYear();
    if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 
    var formattedDate = ""+yyyy+'-'+mm+'-'+dd;
    return formattedDate;
}

function editLanguageInfo(){
	var langIn;
	var editlangId=$(document.forms['editLang']).find('.always-hide').text();trainer:trainer
	var elements = document.forms['editLang'].elements;
	
	$.each(trainer.personalInfo.languagesknown, function(index, langId) {
		if(langId.langKnownId==editlangId)
		{
			//alert("In IF"+elements[0].value+"Read"+elements[1].value)
			langId.spokenLanguage.languageName = elements[0].value;
			//alert("Lang Id "+elements[1].value)
			langId.canRead = $('input[name="read"]:checked').is(':checked');
			langId.canWrite = $('input[name="write"]:checked').is(':checked');
			langId.canSpeak = $('input[name="speak"]:checked').is(':checked');
			 langIn = {
					 langKnownId : editlangId,
					 canRead : langId.canRead,
					 canWrite : langId.canWrite,
					 canSpeak : langId.canSpeak,
					 spokenLanguage:{
						 	languageId:langId.spokenLanguage.languageId,
						 	languageName : elements[0].value,		
					 				}
			 			};
		}
	});
	
var langInfoJson=JSON.stringify(langIn);

	$.ajax({
		url : "../EditLanguages",
		data : {
			personalInfoId : trainer.personalInfo.personalInfoId,
			languageInformation : langInfoJson
		},
		success : function(result) {
			var langList=$.parseJSON(result);
			trainer.personalInfo.languagesknown=langList;
			displayLanguage();
			$('#languages').hide();
			$('#add-languages').show();
			
		}
	});
};


function editEmployment(){
	var jobInfo;
	var elements = document.forms['employmentForm'].elements;
	var editJobId=$(document.forms['employmentForm']).find('.always-hide').text();
	$.each(trainer.jobEmployments, function(index, jobEmployment) {
		if(jobEmployment.jobEmploymentId==editJobId){
			
			jobEmployment.designation=elements[0].value;
			jobEmployment.organizationName=elements[1].value;
			jobEmployment.salaryPackage=elements[2].value;
			jobEmployment.startDate=elements[3].value;
			jobEmployment.endDate=elements[4].value;
			if($(elements[5]).is(':checked')){
				jobEmployment.current="true";
			}
			else if($(elements[6]).is(':checked')){
				jobEmployment.current="false";
			}
			
			jobInfo={
					jobEmploymentId: editJobId,
					organizationName: jobEmployment.organizationName,
					startDate: (jobEmployment.startDate),
					endDate: (jobEmployment.endDate),
					salaryPackage: jobEmployment.salaryPackage,
					designation: jobEmployment.designation,
					current: jobEmployment.current
			};
			
			
	}
	});
	var jobInfoJson=JSON.stringify(jobInfo);
	// set status of the editable div for which ajax call is being made
	$("#job").prev(".editable").attr("data-ajax-status", "saving");
	if(elements[3].value>=elements[4].value){
		alert("End Date is before Start Date");
	}else{
	$.ajax({
		url : "../EditEmployementServlet",
		data : {
			user_id : userid,
			jobInfoJson : jobInfoJson
		},
		success : function(result) {
			displayEditedJobEmployments();
			$('#job').hide();
		}
	});}
}

function displayEditedJobEmployments(){

	// Target div which data to be replaced
	var tmpEditable = $("#job").siblings(".editable[data-ajax-status='saving']");
	tmpEditable.removeAttr("data-ajax-status");
	
	// Edit form from the data is to be taken
	var tmpEditForm = $("#job form");

	var tmpIndex = $("#job").siblings(".editable").index(tmpEditable);
	
	// Change value in the div
	tmpEditable.find(".profile-topic-inner-heading").html(tmpEditForm.find("#designation").val());
	tmpEditable.find(".profile-topic-employment-company").html(tmpEditForm.find("#company").val() );
	tmpEditable.find(".profile-topic-employment-start-date").html(getDateInMonthAndYear(tmpEditForm.find("#start-date").val()));
	tmpEditable.find(".profile-topic-employment-end-date").html((tmpEditForm.find("#end-date").val()=="NA")?"Present":getDateInMonthAndYear(tmpEditForm.find("#end-date").val()));
}


$('body').on('click','.edit-employment',function (){
	var editJobId=$(this).parent().find('.always-hide').text();
			$('#job').show();
			$('#job').insertAfter($(this).parent());
			$("#job").css("width", "100%");

			
			
			var editJobId=$(this).parent().find('.always-hide').text();
			$('#job').find('.always-hide').text(editJobId);
			$.each(trainer.jobEmployments, function(index, jobEmployment) {
				if(jobEmployment.jobEmploymentId==editJobId){
					$('#job').find('#designation').val(jobEmployment.designation);
					$('#job').find('#company').val(jobEmployment.organizationName);
					$('#job').find('#package').val(jobEmployment.salaryPackage);
					$('#job').find('#start-date').val(getFormattedDate(jobEmployment.startDate));
					$('#job').find('#end-date').val(getFormattedDate(jobEmployment.endDate));
				
					if(jobEmployment.current==true){
						$('#is-current').attr('checked','checked');
					}
					else{
						$('#is-not-current').attr('checked','checked');
					}
					
				}
			});
});

function addEmployment(){
	var elements = document.forms['employmentForm'].elements;
	var selected;
	if($(elements[5]).is(':checked')){
		 selected=true;
	}else if($(elements[6]).is(':checked')){
		 selected=false;
	}
	if(elements[3].value>=elements[4].value){
		alert("End Date is before Start Date");
	}else{
	$.ajax({
		url : "../AddEmployment",
		mehtod:"POST",
		data : {
			designation : elements[0].value,
			organizationName : elements[1].value,
			salaryPackage : elements[2].value,
			startDate : elements[3].value,
			endDate : elements[4].value,
			current : selected,			
			trainerInfoId: trainer.trainerProfileId
			
		},
		success : function(result) {
			var jobList=$.parseJSON(result);
			trainer.jobEmployments=jobList;
			
			addJobInProfile(jobList.length-1,jobList[jobList.length-1]);
			$('#job').hide();
			$('#add-employment').show();
		}
	});
	}
}

function checkEditAddEmployment(){
	if ($('#job').parents('.model-content-employment').length) {
		editEmployment();
	}else{
		addEmployment();
	}
}


function checkEditAddPatent(){
	if ($('#patents').parents('.model-content-employment').length) {
		editPatent();
	}else{
		addPatent();
	}
}
function addPatent(){
	var elements = document.forms['patentForm'].elements;
	var selected;
	
	if($(elements[4]).is(':checked')){
		 selected=true;
	}else if($(elements[5]).is(':checked')){
		 selected=false;
	}
	$.ajax({
		url : "../AddPatent",
		mehtod:"POST",
		data : {
			title : elements[0].value,
			dateOfIssue : elements[1].value,
			patentApplicationNumber : elements[2].value,
			patentOffice : elements[3].value,
			patentStatus_IsIssued : selected,
			patentUrl : elements[6].value,		
			description:elements[7].value,
			trainerInfoId: trainer.trainerProfileId
			
		},
		success : function(result) {
			var patentList=$.parseJSON(result);
			trainer.patents=patentList;
			addPatentInProfile(patentList.length-1,patentList[patentList.length-1]);
			$('#patents').hide();
			$('#add-patents').show();
		}
	});
}
function addAward(){
	
	var elements = document.forms['awardForm'].elements;
	
		
	$.ajax({
		url : "../AddAward",
		mehtod:"POST",
		data : {
			trainerId:trainer.trainerProfileId,
			awardTitle : elements[0].value,
			issuer : elements[3].value,
			occupation : elements[2].value,
			dateOfIssue : elements[1].value,
		},
		success : function(result) {
			var awardList=$.parseJSON(result);
			trainer.honorAndAwards=awardList;
			
			addAwardsInProfile(awardList.length-1,awardList[awardList.length-1]);
			$('#awardsAndHonors').hide();
			$('#add-awardsAndHonors').show();
		}
	});
	
}

function checkEditAddHonorsAndAwards(){
	if ($('#awardsAndHonors').parents('.model-content-awardsAndHonors').length) {
		editAward();
	}else{
		addAward();
	}
}

function checkEditAddLanguage(){
	if(($('#languages').find('.always-hide').text())!="") {
		editLanguageInfo();
	}else{
		addLanguage();
	}
	
}


function addLanguage(){
	var elements = document.forms['editLang'].elements;
	var checked=[];
	if($('#read').is(':checked')){
		 checked[0]=true;
	}else{
		checked[0]=false;
	}
	if($('#write').is(':checked')){
		 checked[1]=true;
	}else{
		checked[1]=false;
	}
	if($('#speak').is(':checked')){
		checked[2]=true;
	}else{
		checked[2]=false;
	}
	
	$.ajax({
		url : "../AddLanguage",
		method:"POST",
		data : {
			spokenLanguageName : elements[0].value,
			canRead : checked[0],
			canWrite : checked[1],
			canSpeak : checked[2],
			trainerInfoId: trainer.trainerProfileId,
			personalInfoId: trainer.personalInfo.personalInfoId,
			languageId: trainer.personalInfo.languagesknown.langKnownId
		},
		success : function(result) {
			var langList=$.parseJSON(result);
			trainer.personalInfo.languagesknown=langList;
			displayLanguageInProfile(langList.length-1, langList[langList.length-1]);		
			$('#languages').hide();
			$('#add-languages').show();
		}
	});
}

$('#add-skillSet').on("click", function() {
	$(this).hide();
	$('#skillSet').insertAfter($(this));
	$('#skillSet').show();
	$("#skillSet").css("width", "73%");
});


function AddSkillSet(){
	var skillSetInfo;
	var elements = document.forms['skillSetForm'].elements;
	
	$.ajax({
		url : "../AddSkillSet",
		mehtod:"POST",
		data : {
			skillSetName : elements[0].value,
			categoryName : elements[1].value,
			trainerId:trainer.trainerProfileId
		},
		success : function(result) {
			var skillSetList=$.parseJSON(result);
			trainer.skillset=skillSetList;
			
			displaySkillsInProfile(skillSetList.length-1,skillSetList[skillSetList.length-1]);
			$('#skillSet').hide();
			$('#add-skillSet').show();
		}
	});
}
function getMonthsFromDate(start,end){
	var dropdt = new Date(end);
    var pickdt = new Date(start);
    return parseInt((dropdt - pickdt) / (24 * 3600 * 1000 * 30));
}


function chechEditAddRealExperience(){
	if(($('#realtime-form').find('.always-hide').text())!=""){
		editRealTimeExperience();
	}
	else{
		addRealtimeExperience();
	}
}


function editRealTimeExperience(){
	var realTimeExpId=$('#realtime-form').find('.always-hide').text();
var elements = document.forms['realtime-form'].elements;
	
	
	if($(elements[6]).is(':checked')){
		current = true;
	}else if($(elements[7]).is(':checked')){
		current=false;
	}

	workExperienceSkill=[];
	$("#realtime-skilltable tr").each(function(i,row){
		if(i!=0){
			 obj={
					skillDurationInMonths:$(row).find("td:nth-child(2)").text(),
					skillName:$(row).find("td:nth-child(1)").text(),
					categoryName:$(row).find("td:nth-child(3)").text()
			};
				workExperienceSkill.push(obj);
		}
	
		});
	totalmon=getMonthsFromDate(elements[0].value,elements[1].value);
	
//	alert(workExperienceSkill[0])
		var realtime={
		realTimeExpId:realTimeExpId,
		projectTitle:elements[8].value,
		projectOVerview:elements[9].value,
		projectUrl:elements[10].value,
		companyName:elements[11].value,
		startDate:elements[0].value,
		endDate:elements[1].value,
		totalMonths:totalmon,
		pocName:elements[2].value,
		pocContactNo:elements[3].value,
		description:elements[4].value,
		isCurrent:current,
		experienceType:"REAL_TIME",
		roleName:elements[5].value,
		workExperienceSkillsdto:workExperienceSkill
		
	};
	var realtimeJson=JSON.stringify(realtime);
	
	$.ajax({
		url : "../EditRealTimeExperience",
		method:"POST",
		data : {
			trainerId:trainer.trainerProfileId,
			realTimeExperience:realtimeJson
		},
		success : function(result) {
			var workExpList=$.parseJSON(result);
			trainer.workExperiences=workExpList;
			displayExperience();
			$('#experience').hide();
			$('#add-experience').show();
		}
	});
}


function addRealtimeExperience(){
	var elements = document.forms['realtime-form'].elements;
	
	
	if($(elements[6]).is(':checked')){
		current = true;
	}else if($(elements[7]).is(':checked')){
		current=false;
	}

	workExperienceSkill=[];
	$("#realtime-skilltable tr").each(function(i,row){
		if(i!=0){
			 obj={
					skillDurationInMonths:$(row).find("td:nth-child(2)").text(),
					skillName:$(row).find("td:nth-child(1)").text(),
					categoryName:$(row).find("td:nth-child(3)").text()
			};
				workExperienceSkill.push(obj);
		}
	
		});
	totalmon=getMonthsFromDate(elements[0].value,elements[1].value);
	
//	alert(workExperienceSkill[0])
		var realtime={
		
		projectTitle:elements[8].value,
		projectOVerview:elements[9].value,
		projectUrl:elements[10].value,
		companyName:elements[11].value,
		startDate:elements[0].value,
		endDate:elements[1].value,
		totalMonths:totalmon,
		pocName:elements[2].value,
		pocContactNo:elements[3].value,
		description:elements[4].value,
		isCurrent:current,
		experienceType:"REAL_TIME",
		roleName:elements[5].value,
		workExperienceSkillsdto:workExperienceSkill
		
	};
	var realtimeJson=JSON.stringify(realtime);
	$.ajax({
		url : "../AddRealTimeExperience",
		method:"POST",
		data : {
			trainerId:trainer.trainerProfileId,
			realTimeExperience:realtimeJson
		},
		success : function(result) {
			var workExpList=$.parseJSON(result);
			trainer.workExperiences=workExpList;
			var max=0;
			$.each(trainer.workExperiences,function(index, workExperience) {
				if(workExperience.workExperienceId>max){
					max=workExperience.workExperienceId;
				}
			});
			$.each(trainer.workExperiences,function(index, workExperience) {
				if(workExperience.workExperienceId==max){
					displayRealTimeExperienceInProfile(0,workExperience);
				}
			});
			$('#experience').hide();
			$('#add-experience').show();
		}
	});

}
$('.realtime .save-skill')
.on(
		"click",
		function() {
			$('#realtime-skilltable')
					.append(
							'<tr class="item">'
									+ '<td class="col-md-2">'+
									'<span class="coll-skill">'
									+ $('#add-skill-realtime').val()+'</span>'
									+ '</td>'
									+ '<td class="col-md-3">'+'<span class="coll-duration">'
									+ $('#duration-realtime')
											.val()+'</span>'
									+'</td>'+
									'<td class="col-md-2">'+'<span class="coll-category">'
									+ $('#skill-category-realtime').val()+'</span>'								
									+ '</td>'
									+ '<td class="col-md-1">'
									+ '<i class="fa  fa-fw fa-remove fa-lg  remove-skill "  >'
									+ " " + ' </i>' + '</td>' + '</tr>');
			$('#preferred-contact').hide();
			$('#add-preferred-contact').show();
		});

$('.save-skill')
.on(
		"click",
		function() {
			$('#training-skilltable')
					.append(
							'<tr class="item">'
									+ '<td class="col-md-2">'+
									'<span class="coll-skill">'
									+ $('#add-skill-training').val()+'</span>'
									+ '</td>'
									+ '<td class="col-md-3">'+'<span class="coll-duration">'
									+ $('#duration-training')
											.val()+'</span>'
									+'</td>'+
									'<td class="col-md-2">'+'<span class="coll-category">'
									+ $('#skill-category-training').val()+'</span>'								
									+ '</td>'
									+ '<td class="col-md-1">'
									+ '<i class="fa  fa-fw fa-remove fa-lg  remove-skill "  >'
									+ " " + ' </i>' + '</td>' + '</tr>');
			$('#preferred-contact').hide();
			$('#add-preferred-contact').show();
		});
function chechEditAddTrainingExperience(){
	if(($('#training-form').find('.always-hide').text())!=""){
		editTrainingExperience();
	}
	else{
		addTrainingExperience();
	}
}



function addTrainingExperience(){
	var elements = document.forms['training-form'].elements;

	
	if($(elements[6]).is(':checked')){
	//	$( "#end-time" ).prop( "disabled", true );
	
	}else if($(elements[7]).is(':checked')){
		//$( "#end-time" ).prop( "disabled", false );
		
	}
	startTime = elements[8].value;
	endTime = elements[9].value;
	locationOfTrainer = elements[10].value;
	if($(elements[11]).is(':checked')){
		//$( "#vendor-name" ).prop( "disabled", true );
	}else if($(elements[12]).is(':checked')){
	//	$( "#vendor-name" ).prop( "disabled", false );
		vendorName = elements[13].value;
	}
	if($(elements[14]).is(':checked')){
		trainingType = "FRESHER";
	}else if($(elements[15]).is(':checked')){
		trainingType = "LATERAL";
	}
	if($(elements[16]).is(':checked')){
		trainingMode = "FACE_TO_FACE";
	}else if($(elements[17]).is(':checked')){
		trainingMode = "VIRTUAL_TRAINING";
	}
	workExperienceSkill=[];
	$("#training-skilltable tr").each(function(i,row){
		if(i!=0){
			 obj={
					skillDurationInMonths:$(row).find("td:nth-child(2)").text(),
					skillName:$(row).find("td:nth-child(1)").text(),
					categoryName:$(row).find("td:nth-child(3)").text()
						
					
			};
				workExperienceSkill.push(obj);
		}
	
		});
	totalmon=getMonthsFromDate(elements[0].value,elements[1].value);
	startTi=startTime.split(':');
	endTi=endTime.split(':');
	
//	alert(workExperienceSkill[0])
var training={
		
		startTimeHour:startTi[0],
		startTimeMinute:startTi[1],
		endTimeHour:endTi[0],
		endTimeMinute:endTi[1],
		locationOfTrainer:locationOfTrainer,
		throughvendor:$(elements[11]).is(':checked'),
		vendorName:elements[13].value,
		trainingMode:trainingMode,
		trainingType:trainingType,
		startDate:elements[0].value,
		endDate:elements[1].value,
		totalMonths:totalmon,
		pocName:elements[2].value,
		pocContactNo:elements[3].value,
		description:elements[4].value,
		isCurrent:$(elements[6]).is(':checked'),
		experienceType:"TRAINING",
		clientName:elements[5].value,
		clientLogoUrl:"",
		workExperienceSkillsdto:workExperienceSkill
		
	};
var trainingJson=JSON.stringify(training);
$.ajax({
	url : "../AddTrainingExperience",
	method:"POST",
	data : {
		trainerId:trainer.trainerProfileId,
		trainerExperience:trainingJson
	},
	success : function(result) {
		
		var workExpList=$.parseJSON(result);
		trainer.workExperiences=workExpList;
		var max=0;
		$.each(trainer.workExperiences,function(index, workExperience) {
			if(workExperience.workExperienceId>max){
				max=workExperience.workExperienceId;
			}
		});
		$.each(trainer.workExperiences,function(index, workExperience) {
			if(workExperience.workExperienceId==max){
				displayTrainingExperienceInProfile(0,workExperience);
			}
		});
		
		$('#experience').hide();
		$('#add-experience').show();
		
	}
});

}


function editTrainingExperience(){
	
	var trainingExpId=$('#training-form').find('.always-hide').text();
	var elements = document.forms['training-form'].elements;

	
	if($(elements[6]).is(':checked')){
	//	$( "#end-time" ).prop( "disabled", true );
	
	}else if($(elements[7]).is(':checked')){
		//$( "#end-time" ).prop( "disabled", false );
		
	}
	startTime = elements[8].value;
	endTime = elements[9].value;
	locationOfTrainer = elements[10].value;
	if($(elements[11]).is(':checked')){
		//$( "#vendor-name" ).prop( "disabled", true );
	}else if($(elements[12]).is(':checked')){
	//	$( "#vendor-name" ).prop( "disabled", false );
		vendorName = elements[13].value;
	}
	if($(elements[14]).is(':checked')){
		trainingType = "FRESHER";
	}else if($(elements[15]).is(':checked')){
		trainingType = "LATERAL";
	}
	if($(elements[16]).is(':checked')){
		trainingMode = "FACE_TO_FACE";
	}else if($(elements[17]).is(':checked')){
		trainingMode = "VIRTUAL_TRAINING";
	}
	workExperienceSkill=[];
	$("#training-skilltable tr").each(function(i,row){
		if(i!=0){
			 obj={
					skillDurationInMonths:$(row).find("td:nth-child(2)").text(),
					skillName:$(row).find("td:nth-child(1)").text(),
					categoryName:$(row).find("td:nth-child(3)").text()
						
					
			};
				workExperienceSkill.push(obj);
		}
	
		});
	totalmon=getMonthsFromDate(elements[0].value,elements[1].value);
	startTi=startTime.split(':');
	endTi=endTime.split(':');
	
//	alert(workExperienceSkill[0])
var training={
		
		trainingExpId:trainingExpId,
		startTimeHour:startTi[0],
		startTimeMinute:startTi[1],
		endTimeHour:endTi[0],
		endTimeMinute:endTi[1],
		locationOfTrainer:locationOfTrainer,
		throughvendor:$(elements[11]).is(':checked'),
		vendorName:elements[13].value,
		trainingMode:trainingMode,
		trainingType:trainingType,
		startDate:elements[0].value,
		endDate:elements[1].value,
		totalMonths:totalmon,
		pocName:elements[2].value,
		pocContactNo:elements[3].value,
		description:elements[4].value,
		isCurrent:$(elements[6]).is(':checked'),
		experienceType:"TRAINING",
		clientName:elements[5].value,
		clientLogoUrl:"",
		workExperienceSkillsdto:workExperienceSkill
		
	};
var trainingJson=JSON.stringify(training);
$.ajax({
	url : "../EditTrainingExperience",
	method:"POST",
	data : {
		trainerId:trainer.trainerProfileId,
		trainerExperience:trainingJson
	},
	success : function(result) {
		
		var workExpList=$.parseJSON(result);
		trainer.workExperiences=workExpList;
		displayExperience();
		
		$('#experience').hide();
		$('#add-experience').show();
		
	}
});

}

$('body').on("click", '#training-skilltable .remove-skill', function() {
	$(this).parent().parent().remove();
});
$('body').on("click", '#realtime-skilltable .remove-skill', function() {
	$(this).parent().parent().remove();
});

$('body').on("click",'.edit-training-experience',function(){
	

	 var editTrainingExpID=$(this).parent().find('.always-hide').text();
	 $('#experience').show();
		$('#experience').css('width','73%');
		 $('html, body').animate({
		        scrollTop: $("#experience").offset().top
		    }, 1000);
		 $('.experience-type').val('training-experience');
			$('#training-experience').show();
			$('#realtime-experience').hide();
		$('#training-experience').find('.always-hide').text(editTrainingExpID);
		$('#training-experience').find('#add-skill-training').val("");
		$('#training-experience').find('#duration-training').val("");
		$('#training-experience').find('#skill-category-training').val("");
		$("#training-skilltable").find("tr:gt(0)").remove();
		$.each(trainer.workExperiences, function(index, workExperience) {
			if(workExperience.workExperienceId==editTrainingExpID){
				$('#training-experience').find('#start-date').val(getFormattedDate(workExperience.startDate));
				$('#training-experience').find('#end-date').val(getFormattedDate(workExperience.endDate));
				$('#training-experience').find('#pocName').val(workExperience.pocName);
				$('#training-experience').find('#pocContactNo').val(workExperience.pocContactNo);
				$('#training-experience').find('#description').val(workExperience.description);
				$('#training-experience').find('#clientName').val(workExperience.client.clientName);
				$('#training-experience').find('#start-time').val(workExperience.startTime.hourOfDay+':'+workExperience.startTime.minute);
				$('#training-experience').find('#end-time').val(workExperience.endTime.hourOfDay+':'+workExperience.endTime.minute);
				$('#training-experience').find('#workedLocation').val(workExperience.location);
				$('#training-experience').find('#vendor-name').val(workExperience.vendorName);
				var elements = document.forms['training-form'].elements;
				if(workExperience.current==true){
					$(elements[6]).is(':checked');
				}else{
					$(elements[7]).is(':checked');
				}
				if(workExperience.throughvendor==true){
					$(elements[11]).is(':checked');
				}else{
					$(elements[12]).is(':checked');
				}
				if(workExperience.trainingType=="FRESHER"){
					$(elements[14]).is(':checked');
				}else{
					$(elements[15]).is(':checked');
				}
				if(workExperience.trainingMode="FACE_TO_FACE"){
					$(elements[16]).is(':checked');
				}else{
					$(elements[17]).is(':checked');
				}
				$.each(workExperience.workExperienceSkills,function(index2,trainingSkillSet){
					$('#training-skilltable')
					.append(
							'<tr class="item">'
									+ '<td class="col-md-2">'+
									'<span class="coll-skill">'
									+ trainingSkillSet.skill.skillName+'</span>'
									+ '</td>'
									+ '<td class="col-md-3">'+'<span class="coll-duration">'
									+ trainingSkillSet.skillDurationInMonths+'</span>'
									+'</td>'+
									'<td class="col-md-2">'+'<span class="coll-category">'
									+ trainingSkillSet.skill.category.categoryName+'</span>'								
									+ '</td>'
									+ '<td class="col-md-1">'
									
									+ '<i class="fa  fa-fw fa-remove fa-lg remove-skill" >'
									+ " " + ' </i>' + '</td>' + '</tr>');
				});
			}
		});
	 
	
});


$('body').on("click",'.edit-real-time-experience',function(){
	

	 var editRealExperienceExpID=$(this).parent().find('.always-hide').text();
	 $('#experience').show();
		$('#experience').css('width','73%');
		 $('html, body').animate({
		        scrollTop: $("#experience").offset().top
		    }, 1000);
		$('.experience-type').val('realtime-experience');
		$('#training-experience').hide();
		$('#realtime-experience').show();
		$('#realtime-experience').find('.always-hide').text(editRealExperienceExpID);
		$('#realtime-experience').find('#add-skill-training').val("");
		$('#realtime-experience').find('#duration-training').val("");
		$('#realtime-experience').find('#skill-category-training').val("");
		$("#realtime-experience").find("tr:gt(0)").remove();
		$.each(trainer.workExperiences, function(index, workExperience) {
			if(workExperience.workExperienceId==editRealExperienceExpID){
				$('#realtime-experience').find('#start-date').val(getFormattedDate(workExperience.startDate));
				$('#realtime-experience').find('#end-date').val(getFormattedDate(workExperience.endDate));
				$('#realtime-experience').find('#pocName').val(workExperience.pocName);
				$('#realtime-experience').find('#pocContactNo').val(workExperience.pocContactNo);
				$('#realtime-experience').find('#description').val(workExperience.description);
				$('#realtime-experience').find('#roleName').val(workExperience.roleName);
				$('#realtime-experience').find('#project-title').val(workExperience.projectTitle);
				$('#realtime-experience').find('#project-overview').val(workExperience.projectOverview);
				$('#realtime-experience').find('#project-url').val(workExperience.projectUrl);
				$('#realtime-experience').find('#company-name').val(workExperience.companyName);
				var elements = document.forms['training-form'].elements;
				if(workExperience.current==true){
					$(elements[6]).is(':checked');
				}else{
					$(elements[7]).is(':checked');
				}
				$.each(workExperience.workExperienceSkills,function(index2,trainingSkillSet){
					$('#realtime-skilltable')
					.append(
							'<tr class="item">'
									+ '<td class="col-md-2">'+
									'<span class="coll-skill">'
									+ trainingSkillSet.skill.skillName+'</span>'
									+ '</td>'
									+ '<td class="col-md-3">'+'<span class="coll-duration">'
									+ trainingSkillSet.skillDurationInMonths+'</span>'
									+'</td>'+
									'<td class="col-md-2">'+'<span class="coll-category">'
									+ trainingSkillSet.skill.category.categoryName+'</span>'								
									+ '</td>'
									+ '<td class="col-md-1">'
									
									+ '<i class="fa  fa-fw fa-remove fa-lg remove-skill">'
									+ " " + ' </i>' + '</td>' + '</tr>');
				});
			}
		});
	 
	
});

function addPreferredContact(){
	var elements = document.forms['preferredContactForm'].elements;
	
	var preferredContacts = {
		methodOfContact : $( "#preferred-method-of-contact option:selected" ).text(),
		priority : elements[0].value,
		
	};
	var preferredContactJson = JSON.stringify(preferredContacts);
	$.ajax({
		url:"../AddPreferredContact",
		method:"POST",
		data : {
			userId : trainer.user.userId,
			preferredContact : preferredContactJson		 
		},
		success:function(result){
			addPreferredContactInTable();
			$('#preferred-contact').hide();
			$('#add-preferred-contact').show();
		}
	});
}

function addPreferredContactInTable(){
	$('.dynamic-table')
	.append(
			'<tr>'
					+ '<td class="col-md-2">'
					+ $('#contact-priority').val()
					+ '</td>'
					+ '<td class="col-md-4">'
					+ $('#preferred-method-of-contact')
							.val()
					+ '</td>'
					+ '<td class="col-md-1">'
					+ '<i class="fa  fa-fw fa-save fa-lg  save-preferred-contact "  >'
					+ " "
					+ ' </i>'
					+ '<i class="fa  fa-fw fa-edit fa-lg  edit-preferred-contact"  >'
					+ " "
					+ ' </i>'
					+ '<i class="fa  fa-fw fa-remove fa-lg  remove-preferred-contact "  >'
					+ " " + ' </i>' + '</td>' + '</tr>');
}
function addAddress(){
	//var addressinfo;
	var elements = document.forms['addressForm'].elements;
	
	//var selectedAddress= $( "#address-type-edit" ).val();
	
		addresType=trainer.user.contact.currentAddress;
	//	var addressId=$(document.forms['addressForm']).find('.always-hide').text();
		$.ajax({
			url : "../AddAddress",
			method:"POST",
			data : {
			addressType: $( "#address-type-edit" ).val(),
			propertyNo : elements[1].value,
			streetName : elements[2].value,
			areaName : elements[3].value,
			pincode : elements[4].value,
			landmark : elements[5].value,
			city : elements[6].value,
			state : elements[7].value,
			country : elements[8].value,
			trainerInfoId: trainer.trainerProfileId,
			contactId: trainer.user.contact.contactId
	},
	success : function(result) {
		var contactList=$.parseJSON(result);
		trainer.user.contact=contactList;
		
		displayAddress();	
		$('#address').hide();
		$('#add-address').show();
		}
	});
	
}

function checkAddEditCertificationInfo(){
	if(($('#certificationtest').find('.always-hide').text())!=""){
		editCertificationInfo();
	}else{
		addCertificationInfo();
	}
}
function addCertificationInfo(){
	var certificationInfo;
	var elements = document.forms['certificationInfoForm'].elements;
	certificationInfo={
			institutionName: elements[0].value,
			certifiedDate: elements[1].value,
			grade:elements[2].value,
			certificationName: elements[3].value,
			certificateUrl:elements[4].value
	};
	var certificationInfo=JSON.stringify(certificationInfo);
	$.ajax({
		url : "../AddCertificates",
		method:"POST",
		data : {
		certificationInfo:certificationInfo,
		trainerProfileId : trainer.trainerProfileId,
		},
		success : function(result) {
			alert("Success")
			var certificationList=$.parseJSON(result);
			trainer.certificates=certificationList;
			displayCertificates(certificationList.length-1,certificationList[certificationList.length-1]);
			$('#certificationtest').hide();
			$('#add-certification').show();
			}
		});
}

		
		
		
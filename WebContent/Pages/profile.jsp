<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<%String user=(String)session.getAttribute("name");
if(user==null)
{
	response.sendRedirect("index.html");
}
%>

<script>
history.forward();
</script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>GlobalConnect | Profile</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="../css/base.css">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../css/tmpAdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="../css/AdminLTE.min.css">
<link rel="stylesheet" href="../css/skins/_all-skins.min.css">
<!--Stylesheet for dashboard content-->
<link rel="stylesheet" href="../css/Dashboard.css">
<link rel="stylesheet" href="../css/tmpDashboard.css">
<!--Stylesheet for datepicker-->
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet" href="../css/animate.css">
<link rel="stylesheet" type="text/css" href="../css/maps.css">
<!-- Stylesheet for profile completion -->
<link rel="stylesheet" type="text/css" href="../css/circle.css">
<link rel="stylesheet" type="text/css" href="../css/mobile.css">
<link rel="stylesheet" href="../css/material.css">
<!-- jQuery 2.1.4 -->
<script src="../plugins/jQuery/jQuery-2.1.4.min.js">
	
</script>
<script src="../js/smoothScroll.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
	function myFunctionUpload() {
		window
				.open(
						"https://script.google.com/macros/s/AKfycbwjYN26VaOpRwMT7sorNmIvBLvbdNaO8oSLnBHHvdOkV1VbSRY/exec",
						"_blank",
						"toolbar=yes, scrollbars=no, resizable=no, top=300, left=500, width=400, height=300");
	}

	function myFunctionDownload(viewLink) {
		var res = viewLink.split("/");
		return ("https://docs.google.com/uc?authuser=0&export=download&id=" + res[res.length - 2]);
	}
</script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<!-- Logo -->
			<a href="Account.jsp" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>G</b>C</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Global</b> Connect</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>
				<form>
					<input type="text" class="searchbar" autocomplete="off"
						id="searchBox"
						placeholder="Enter Your Queries Separated by Spaces"> </span>
				</form>
				<button id="hideshow" class="btn btn-info">
					<i class="fa fa-filter"></i> Filters
				</button>
				<div id="searchModal" class="modal1">
					<div class="search-modal-content">
						<span class="close wow fadeInUp">×</span>
						<div id="search-filter-container">
							<div id="search-filters">
								<form action="" style="width: 60%;">
									<input class="messageCheckbox" type="checkbox"
										name="search-filter" value="name" checked><span
										class="filter-span">Name</span></input> </br> <input
										class="messageCheckbox" type="checkbox" name="search-filter"
										value="skills" checked><span class="filter-span">Skills</span></input>
									</br> <input class="messageCheckbox" type="checkbox"
										name="search-filter" value="location" checked><span
										class="filter-span">Location</span></input> </br> <input
										class="messageCheckbox" type="checkbox" name="search-filter"
										value="contact_no" checked><span class="filter-span">Contact
										No</span></input> </br> <input class="messageCheckbox" type="checkbox"
										name="search-filter" value="employers" checked><span
										class="filter-span">Employers</span></input> </br>
									<!-- <div id="experience-fields">
                                        <label>Experence</label>
                                        <input type="text" name="estudante[card_number]">
                                        <label>mail</label>
                                        <input type="text" name="estudante[mail]">
                                    </div> -->
								</form>
							</div>
						</div>
					</div>
				</div>
				<span class="">
					<button class="connect-me btn btn-primary">
						<i class="fa fa-link"></i> Connect Me!
					</button>
					<button class="connect-me connect-me-mobile btn btn-primary">
						<i class="fa fa-link"></i>
					</button>
					<div id="myModal" class="modal">
						<div class="modal-content1">
							<span class="close wow fadeInUp">×</span>
							<div class="connect-me-content">
								<h2 style="text-align: center">Connect Me</h2>
								<span class="text-info"><h4 style="text-align: center">Connect
										with Admin Krishna Kumar.</h4></span>
								<form class="connect-me-form">
									<div>
										<span class="connect-label">Reason to Connect</span> <select
											id="reason-to-connect" class="form-control connect-field">
											<option value="Special Requirements">Special
												Requirements</option>
											<option value="Suggestions">Suggestions</option>
											<option value="Report Bug">Report Bug</option>
											<option value="Report Abuse">Report Abuse</option>
											<option value="Other">Other</option>
										</select>
									</div>
									<br />
									<div class="in-person" style="display: block;">
										<span class="connect-label">In-Person Connect?</span>
										<div class="connect-field">
											<label class="radio-inline"> <input type="radio"
												name="yesno" id="yesCheck"
												onclick="javascript:yesnoCheck();">YES
											</label> <label class="radio-inline"> <input type="radio"
												name="yesno" onclick="javascript:yesnoCheck();" id="noCheck"
												checked='checked'>NO
											</label>
										</div>
										<br />
										<div id="ifYes" style="display: none;">
											<br /> <span class="connect-label">When</span> <input
												type='date' class="connect-field" id='yes' name='yes'>
										</div>
									</div>
									<br />
									<div>
										<span class="connect-label">Description</span>
										<textarea class="form-control connect-field">
                            </textarea>
									</div>
									<footer>
										<button class="btn btn-primary connect-btn wow fadeInUp"
											onclick="connectFeedback(); return false;">Connect!
										</button>
									</footer>
								</form>
							</div>
						</div>
					</div>
				</span> <span class="notification"> <i
					class="fa fa-globe fa-lg fa-spin" id="notif"></i>
					<div id="notifModal" class="modal">
						<div class="notification-wrapper">
							<span class="close wow fadeInUp">×</span>
							<div class="notification-content">
								Notifications</br>
								<p style="word-wrap: break-word;">
									<b>Link 1: </b>http://www.youtube.com/embed/CnTdJ5tG5Hk
								</p>
								<p style="word-wrap: break-word;">
									<b>Link 2: </b>http://www.youtube.com/embed/Y7C0oXks-qM
								</p>
							</div>
						</div>
					</div>
				</span>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<!-- Notifications: style can be found in dropdown.less -->
						<!-- Tasks: style can be found in dropdown.less -->
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">Chandra
									Shekhar</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img src="../img/user2-160x160.jpg"
									class="img-circle" alt="User Image">
									<p>
										Chandra Shekhar - Trainer <small>Member since Nov.
											2012</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="text-center">
									<form action="logout" method="post">
										<input type="submit" class="btn btn-default btn-flat btn-logout" value="Signout"/>
									</form>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar" id="left-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<ul class="sidebar-menu">
					<li class="treeview"><a href="Account.jsp"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span> <i
							class="pull-right"></i>
					</a></li>
					<li class="treeview active"><a href="Pages/profile.jsp"> <i
							class="fa fa-user"></i> <span>Profile</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu menu-open">
							<li><a href="#about"><i class="fa fa-circle-o"></i>About
									ME</a></li>
							<li><a href="#personal"><i class="fa fa-circle-o"></i>Personal
									Info</a></li>
							<li><a href="#contact"><i class="fa fa-circle-o"></i>Contact
									Info</a></li>
							<li><a href="#education-div"><i class="fa fa-circle-o"></i>Educational
									Info</a></li>
							<li><a href="#skills"><i class="fa fa-circle-o"></i>Skill
									Set</a></li>
							<li><a href="#experience-div"><i class="fa fa-circle-o"></i>Experience
							</a></li>
							<li><a href="#certificationdiv"><i
									class="fa fa-circle-o"></i>Certification</a></li>
							<li><a href="#employment"><i class="fa fa-circle-o"></i>Job
									Employment</a></li>
							<li><a href="#pre-contact"><i class="fa fa-circle-o"></i>Preferred
									Contact</a></li>
							<li><a href="#address-div"><i class="fa fa-circle-o"></i>Address</a></li>
							<li><a href="#patentsdiv"><i class="fa fa-circle-o"></i>Patents</a></li>
							<li><a href="#awardsAndHonorsdiv"><i
									class="fa fa-circle-o"></i>Awards and Honors</a></li>
							<li><a href="#language-div"><i class="fa fa-circle-o"></i>Languages</a></li>

						</ul></li>
					
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
		<aside class="main-sidebar" id="right-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<ul class="sidebar-menu">
					<!-- <li class="treeview">
                    <a href="#">
                        <i class="pull-left"></i>
                        <i class="fa fa-rocket"></i>
                        <div class="rightNavigation">Upgrade</div>
                        <div class="rightNavigation-mobile"></div>
                    </a>
                </li> -->
					<li class="treeview right-stats"><a href="#"
						onclick="displayStat(); return false;"> <i
							class="pull-left right-sidebar-desktop"></i> <i
							class="pull-left right-sidebar-mobile"></i> <i
							class="fa fa-line-chart"></i>
							<div class="rightNavigation">Statistics</div>
							<div class="rightNavigation-mobile"></div>
					</a></li>
					<li class="treeview right-video"><a href="#"
						onclick="liveVideo()"> <i
							class="pull-left right-sidebar-desktop"></i> <i
							class="pull-left right-sidebar-mobile"></i> <i
							class="fa fa-signal"></i>
							<div class="rightNavigation">Live Streaming</div>
							<div class="rightNavigation-mobile"></div>
					</a></li>
					<li class="treeview right-location"><a href="#"
						onclick="showAddressLocation(); return false;"> <i
							class="pull-left right-sidebar-desktop"></i> <i
							class="pull-left right-sidebar-mobile"></i> <i
							class="fa fa-location-arrow"></i>
							<div class="rightNavigation">You are here!</div>
							<div class="rightNavigation-mobile"></div>
							<div>
								<img id="map-button" />
							</div> </span> <i class="pull-left"></i>
					</a></li>
					<li class="treeview right-print"><a href="#"
						onclick="printProfile(); return false;"> <i
							class="fa fa-print"></i>
							<div class="rightNavigation">Print your profile</div> </span> <i
							class="pull-left"></i>
					</a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<section class="content-header">
				<div id="search-result-container">
					<div id="experience-container" width="300" height="150"
						style="height: 60px; overflow: hidden; width: 52.2%;">
						<h5 style="margin-left: 80%; margin-top: 16px;">
							<i class="fa fa-code code-exp"></i><b style="margin-left: 5px;">Experience</b>
						</h5>
					</div>
					<div id="search-results"></div>
				</div>
			</section>
			<div class="container">
				<div id="chart"></div>
			</div>
			<section class="profile-content">

				<div class="model-content profile-header-content">
					<div>
						<div class="col-md-4 show-image" id="trainer-profile-pic">
							<img src="" class="img-rounded" alt="Cinque Terre" width="150"
								height="150" id="profilePicURL" />
							<form method="post" action="Javascript:UploadProfilePic()"
								enctype="multipart/form-data">
								<input class="always-hide" type="text" id="tpid"
									style="display: none !important;" /> <input class="update"
									type="file" value="Update" id="profilePicId"
									accept="image/gif, image/jpeg, image/jpg, image/png, image/bmp"
									value="" /> <input type="submit" value="Upload" />
							</form>
						</div>
						<div class="col-md-6">
							<h1 style="font-size: 26px;">
								<b>XYZ</b>
							</h1>
							<p>Software Enginner At ABC</p>
							<p>Bengaluru,Karnataka</p>
							<p>EmailId</p>
						</div>
					</div>
				</div>

				<div class='profile-progress'>
					<div class="profileCompletion">
						<div class="c100 p0 green" id="profileCompletionPage">
							<span>0%</span>
							<div class="slice">
								<div class="bar"></div>
								<div class="fill"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="company-logos">
					<div class="logo-heading">Worked With</div>
					<div class="logos">
						<img alt="" src="../img/client/microsoft.png"> <img alt=""
							src="../img/client/crossroads.jpg"> <img alt=""
							src="../img/client/datamatics.png"> <img alt=""
							src="../img/client/freelancer.png">
					</div>
				</div>
				<!-- ABOUT ME BEGINNING -->


				<div class="model-content profile-body-content-nonadd" id="about">
					<div class="profile-topic-heading">About Me</div>
					<div class="editable">
						<i class="fa  fa-fw fa-edit fa-lg pull-right edit-about-me"></i>
						<div class="profile-topic-abody about-me"></div>
					</div>

				</div>

				<div id="about-me" class="add-hide">
					<form action="Javascript:editAboutMe()" method="POST">
						<div>
							<label for="about-me-text">First Name</label>
							<textarea id="about-me-text" name="about-me-text"
								class="form-control"></textarea>
						</div>
						<div id="save">
							<input type="submit" class="btn btn-primary save-add"
								id="save-aboutme" value="Save"> <input type="button"
								class="btn btn-default" id="cancel-aboutme" value="Cancel">
						</div>
					</form>
				</div>
				<!-- ABOUT ME ENDING -->
				<!-- PERSONAL INFO BEGINNING -->


				<div class="model-content profile-body-content-nonadd" id="personal">
					<div class="profile-topic-heading">Personal Info</div>
					<i class="fa  fa-fw fa-edit fa-lg pull-right edit-personal-info"></i>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">First Name* :
						</div>
						<div id="firstName" class="profile-topic-first-name col-md-5"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Middle Name :
						</div>
						<div id="middleName" class="profile-topic-middle-name col-md-6"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Last Name :</div>
						<div id="lastName" class="profile-topic-last-name col-md-6"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Gender* :</div>
						<div id="gender" class="profile-topic-gender col-md-6"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Marital Status
							:</div>
						<div id="maritalstatus" class="profile-topic-status col-md-6"></div>
					</div>

					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Spouse Name :
						</div>
						<div id="spouseName" class="profile-topic-spouse-name col-md-6"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">DOB* :</div>
						<div id="dateOfBirth" class="profile-topic-dob col-md-6"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Ready To
							Relocate :</div>
						<div id="readyToRelocate"
							class="profile-topic-relocation col-md-6"></div>
					</div>
					<div class="row">
						<div class="profile-topic-basicInfo col-md-6">Upload Resume
							:</div>
						<input type="file" class="profile-topic-basicInfo col-md-6"
							id="file">

					</div>

				</div>
				<div id="personal-info" class="add-hide">
					<form action="Javascript:editPersonalInfo()" method="POST"
						id="personalInfoForm" name="personalInfoForm">
						<div>
							<label for="first-name">First Name*</label> <input type="text"
								id="first-name" name="first-name" class="form-control" required>
						</div>
						<div>
							<label for="middle-name">Middle Name</label> <input type="text"
								id="middle-name" name="middle-name" class="form-control">
						</div>
						<div>
							<label for="last-name">Last Name</label> <input type="text"
								id="last-name" name="last-name " class="form-control">
						</div>
						<div>
							<label for="gender">Gender*</label><br> Male<input
								type="radio" id="male" name="gender" value="MALE">
							Female<input type="radio" id="female" name="gender"
								value="FEMALE">
						</div>
						<div>
							<label for="marital-status">Marital Status</label><br>
							Single<input type="radio" id="single" name="maritalStatus"
								value="SINGLE"> Married<input type="radio" id="married"
								name="maritalStatus" value="MARRIED">
						</div>
						<div>
							<label for="spouse-name">Spouse Name</label> <input type="text"
								id="spouse-name" name="spouse-name " class="form-control">
						</div>
						<div>
							<label for="date-of-birth">Date Of Birth</label> <input
								type="date" id="date-of-birth" name="date-of-birth "
								class="form-control">
						</div>
						<div>
							<label for="relocation">Ready To relocate</label><br> Yes<input
								type="radio" id="yesRelocate" name="readyToRelocate"
								value="True"> No<input type="radio" id="no"
								name="readyToRelocate" value="False">
						</div>
						<div id="save">
							<input type="submit" id="save-personal-info"
								class="btn btn-primary save-add" value="Save"> <input
								type="button" class="btn btn-default" id="cancel-personalInfo"
								value="Cancel">
						</div>
					</form>
				</div>
				<!-- PERSONAL INFO ENDING -->
				<!-- CONTACT INFO BEGINNING -->


				<div class="model-content profile-body-content-nonadd" id='contact'>
					<div class="profile-topic-heading">Contact Info</div>
					<div class="editable">
						<i class="fa  fa-fw fa-edit fa-lg pull-right edit-contact-info"></i>
						<div class="row">
							<div class="profile-topic basicInfo col-md-6">Primary
								Mobile No.* :</div>
							<div class="profile-topic primary-mobile col-md-5"
								id='primaryMobileNo'>9153021980</div>
						</div>
						<div class="row">
							<div class="profile-topic-basicInfo col-md-6">Secondary
								Mobile No. :</div>
							<div class="profile-topic secondary-mobile col-md-6"
								id="secondaryMobileNo">7018226393</div>
						</div>
						<div class="row">
							<div class="profile-topic-basicInfo col-md-6">Secondary
								Email Id:</div>
							<div class="profile-topic secondary-email col-md-6"
								id="secondaryMailId">abc@gmail.com</div>
						</div>
						<div class="row">
							<div class="profile-topic-basicInfo col-md-6">Fax No :</div>
							<div class="profile-topic fax col-md-6" id="faxNo">05123</div>
						</div>
						<div class="row">
							<div class="profile-topic-basicInfo col-md-6">Residence No.
								:</div>
							<div class="profile-topic residence-no col-md-6" id="residenceNo">080234462</div>
						</div>

						<div class="row">
							<div class="profile-topic-basicInfo col-md-6">Office
								Contact No. :</div>
							<div class="profile-topic office-contact col-md-6"
								id="officeContactNo">080212345</div>
						</div>
					</div>
				</div>
				<div id="contact-info" class="add-hide">
					<form action="Javascript:editContactInfo()" method="POST"
						id="contactInfoForm" name="contactInfoForm">
						<div>
							<label for="primary-mobile">Primary Mobile No.*</label> <input
								type="text" id="primary-mobile" name="primary-mobile"
								class="form-control" required>
						</div>
						<div>
							<label for="secondary-mobile">Secondary Mobile No-</label> <input
								type="text" id="secondary-mobile" name="secondary-mobile"
								class="form-control" required="required">
						</div>
						<div>
							<label for="secondary-email">Secondary Email ID</label> <input
								type="text" id="secondary-email" name="secondary-email "
								class="form-control">
						</div>
						<div>
							<label for="fax">Fax No.</label> <input type="text" id="fax"
								name="fax " class="form-control">
						</div>
						<div>
							<label for="residence-no">Residence No</label> <input type="text"
								id="residence-no" name="residence-no " class="form-control"
								required="required">
						</div>
						<div>
							<label for="office-contact">Office Contact No.-</label> <input
								type="text" id="office-contact" name="office-contact "
								class="form-control" required="required">
						</div>
						<div id="save">
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default cancel-add " value="Cancel">
						</div>
					</form>
				</div>

				<!-- CONTACT INFO ENDING -->
				<!-- Preferred Contact BEGINNING -->

				<div class="model-content profile-body-content" id="pre-contact">
					<div class="profile-topic-heading">Preferred Contact</div>
					<div class="row preferred-table">
						<div class="profile-topic-contactInfo  test1">
							<div class="box">
								<div class="box-body table-responsive no-padding">
									<table
										class="table table-bordered table-striped  dynamic-table">
										<tbody>
											<tr>
												<th class="col-md-2">Priority</th>
												<th class="col-md-4">Method Of Contact</th>
												<th class="col-md-1"></th>
											</tr>
										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>
				</div>
				<div class="profile-topic-add" id="add-preferred-contact">Add
					Preferred Contact</div>
				<div id="preferred-contact" class="add-hide">
					<form action="Javascript:addPreferredContact()" method="POST"
						id="preferredContactForm" name="preferredContactForm">
						<div>
							<label for="contact-priority">Priority</label> <input
								type="number" id="contact-priority" name="contact-priority"
								class="form-control" required="required">
						</div>

						<div>
							<label for="contact-method">Method of Contact</label> <select
								name="methods" id="preferred-method-of-contact"
								class="form-control">

								<option value="MOBILE">MOBILE</option>
								<option value="EMAIL">EMAIL</option>
								<option value="SMS">SMS</option>
								<option value="HOME_PHONE">HOME_PHONE</option>
								<option value="OFFICE_PHONE">OFFICE_PHONE</option>
								<option value="FACE_TO_FACE">FACE_TO_FACE</option>
								<option value="ANY">ANY</option>
							</select>
						</div>
						<div id="save">
							<input type="submit"
								class="btn btn-primary savenew-preferred-contact" value="Save">
							<input type="button" class="btn btn-default cancel-add "
								value="Cancel" id="cancel-preferredContact">
						</div>
					</form>
				</div>



				<!-- Preferred Contact ENDING -->
				<!-- ADDRESS BEGINNING -->
				<div class="model-content profile-body-content" id="address-div">
					<div class="profile-topic-heading">Address</div>
					<div id="address-div-update"></div>
				</div>


				<div class="profile-topic-add" id="add-address">Add Address</div>
				<div id="address" class="add-hide">
					<form action="Javascript:addAddress()" method="POST"
						id="addressForm" name="addressForm">
						<div class="always-hide"></div>
						<div>
							<label for="address-type">Address Type</label> <select
								class="form-control address-type-select" id="address-type-edit">
								<option value="Current" selected="selected">Current</option>
								<option value="Permanent">Permanent</option>
								<option value="Office">Office</option>
							</select>
						</div>
						<div>
							<label for="property-no">Property No*</label> <input type="text"
								id="property-no" name="property-no" class="form-control"
								required="required">
						</div>
						<div>
							<label for="street">Street Name*</label> <input type="text"
								id="street" name="street" class="form-control"
								required="required">
						</div>
						<div>
							<label for="area">Area*</label> <input type="text" id="area"
								name="area" class="form-control" required="required">
						</div>
						<div>
							<label for="pincode">Pincode*</label> <input type="number"
								id="pincode" name="pincode" class="form-control"
								required="required">
						</div>
						<div>
							<label for="landmark">Landmark*</label> <input type="text"
								id="landmark" name="landmark" class="form-control"
								required="required">
						</div>
						<div>
							<label for="city">City*</label> <input type="text" id="city"
								name="city" class="form-control" required="required">
						</div>
						<div>
							<label for="state">State*</label> <input type="text" id="state"
								name="state" class="form-control" required="required">
						</div>
						<div>
							<label for="country">Country*</label> <input type="text"
								id="country" name="country" class="form-control"
								required="required">
						</div>
						<div id="save">
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default cancel-address " value="Cancel">
						</div>
					</form>
				</div>

				<!-- ADDRESS ENDING -->
				<!-- EDUCATION BEGINNING -->
				<div class=" profile-body-content model-content-education"
					id="education-div">
					<div class="profile-topic-heading">Educational Info</div>


				</div>

				<div class="profile-topic-add" id="add-education">Add
					Education</div>
				<div id="education" class="add-hide">

					<form action="Javascript:checkEditAdd()" method="POST"
						id="educationForm" name="educationForm">
						<div class="always-hide"></div>
						<div>
							<label for="institute-name">Institute Name*</label> <input
								type="text" id="institute-name" name="institute-name"
								class="form-control" required="required">
						</div>
						<div>
							<label for="degree">Degree*</label> <input type="text"
								id="degree" name="degree" class="form-control"
								required="required">
						</div>
						<div>
							<label for="specialization">Specialization*</label> <input
								type="text" id="specialization" name="specialization"
								class="form-control" required="required">
						</div>
						<div>
							<label for="start-date">Start Year</label> <input type="number"
								id="start-date" name="start-date" class="form-control">
						</div>
						<div>
							<label for="end-date">End Year</label> <input type="number"
								id="end-date" name="end-date" class="form-control">
						</div>
						<div>
							<label for="course-duration">Course Duration*</label> <input
								type="number" id="course-duration" name="course-duration"
								class="form-control" required="required">
						</div>
						<div>
							<label for="board">Board/University</label> <input type="text"
								id="board" name="board" class="form-control">
						</div>
						<div>
							<label for="percentage">Percentage*</label> <input type="number"
								id="percentage" name="percentage" class="form-control"
								required="required">
						</div>
						<div>
							<label for="city">City*</label> <input type="text" id="city"
								name="city" class="form-control" required="required">
						</div>
						<div>
							<label for="state">State</label> <input type="text" id="state"
								name="state" class="form-control">
						</div>
						<div>
							<label for="country">Country</label> <input type="text"
								id="country" name="country" class="form-control">
						</div>
						<div id="save">
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default " id="cancel-educationInfo"
								value="Cancel">
						</div>
					</form>
				</div>

				<!-- EDUCATION BEGINNING -->
				<!-- SKILLSET BEGINNING -->



				<div class="model-content profile-body-content" id='skills'>
					<div class="profile-topic-heading">Skill Set</div>
					<div class="profile-topic-body">
						<div class="profile-topic-skills">
							<ul id="skill-set-div">

							</ul>
						</div>
					</div>

				</div>
				<div class="profile-topic-add" id="add-skillSet">Add Skill Set</div>

				<div id="skillSet" class="add-hide" style="width: 73%">
					<form action="Javascript:AddSkillSet()" method="POST"
						id="editSkillSet" name="skillSetForm">

						<div>
							<label for="skillName">Skill Name</label> <input type="text"
								id="skillName" name="skillName" class="form-control"
								required="required">
						</div>
						<div>

							<label for="category">Category Name</label> <input type="text"
								id="category" name="category" class="form-control">
						</div>

						<div id="save">
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default " id="cancel-skillSet" value="Cancel">
						</div>
					</form>
				</div>
				<!-- SKILLSET ENDING -->
				<!-- EXPERIENCE BEGINNING -->


				<div class="model-content profile-body-content" id='experience-div'>
					<div class="profile-topic-heading">Experience</div>
					<div id="industry">
						<div class="profile-topic-experience-heading">Industry
							Experience</div>
						<div id="industry-update"></div>
					</div>
					<div id="training">
						<div class="profile-topic-experience-heading">Training
							Experience</div>
						<div id="training-update"></div>
					</div>


				</div>
				<div class="profile-topic-add" id="add-experience">Add
					Experience</div>
				<div id="experience" class="add-hide">
					<div>
						<label for="experience-type">Experience Type</label> <select
							class="experience-type" class="form-control">
							<option value="training-experience">Training Experience</option>
							<option value="realtime-experience">RealTIme Experience</option>
						</select>
					</div>
					<div id="training-experience">
						<form action="Javascript:chechEditAddTrainingExperience()"
							method="post" id="training-form" name="training-form">
							<div class='always-hide'></div>
							<div>
								<label for="start-date">Start Date*</label> <input type="date"
									id="start-date" class="form-control" required="required">
							</div>
							<div>
								<label for="end-date">End Date*</label> <input type="date"
									id="end-date" class="form-control" required="required">
							</div>
							<div>
								<label for="pocName">POC Name</label> <input type="text"
									id="pocName" placeholder="POC Name" class="form-control">
							</div>
							<div>
								<label for="pocContactNo">POC Contact No</label> <input
									type="text" id="pocContactNo" placeholder="POC Contact No"
									class="form-control">
							</div>
							<div>
								<label for="description">Description</label> <input type="text"
									id="description" placeholder="Description" class="form-control">
							</div>
							<div>
								<label for="clientName">client name</label> <input type="text"
									id="clientName" placeholder="Client Name" class="form-control">
							</div>
							<div id="is_current">
								<label>Is Current?</label><br> <input type="radio"
									name="is-current" value="yes" checked> Yes <input
									type="radio" name="is-current" value="no"> No
							</div>

							<div>
								<label for="start-time">Start Time*</label> <input type="time"
									id="start-time" class="form-control" required="required">
							</div>
							<div>
								<label for="end-time">End Time*</label> <input type="time"
									id="end-time" class="form-control" required="required">
							</div>
							<div>
								<label for="workedLocation">Location</label> <input type="text"
									id="workedLocation" placeholder="location" class="form-control">
							</div>
							<div id="is_vendor">
								<label>Is Through Vendor</label><br> <input type="radio"
									name="is-vendor" value="yes" checked> Yes <input
									type="radio" name="is-vendor" value="no"> No
							</div>
							<div>
								<label for="vendor-name">Vendor Name</label> <input
									id="vendor-name" type="text" placeholder="vendor-name"
									class="form-control">
							</div>
							<div id="training_type">
								<label>Training Type</label><br> <input type="radio"
									name="training-type" value="FRESHER" checked> FRESHER <input
									type="radio" name="training-type" value="LATERAL">
								LATERAL
							</div>
							<div id="training_mode">
								<label>Training Mode</label><br> <input type="radio"
									name="training-mode" value="FACE_TO_FACE" checked>
								FACE_TO_FACE <input type="radio" name="training-mode"
									value="VIRTUAL_TRAINING"> VIRTUAL_TRAINING
							</div>
							<div class="row preferred-table">
								<div class="profile-topic-contactInfo  test1">
									<div class="box">
										<div class="box-body table-responsive no-padding">
											<table class="table table-bordered table-striped "
												id="training-skilltable">
												<tbody>
													<tr>
														<th class="col-md-2">SKill</th>
														<th class="col-md-3">Duration</th>
														<th class="col-md-2">Category</th>
														<th class="col-md-1"></th>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="add-new-skill">
								<div>
									<label>Add Skill</label><br> <input type="text"
										class=" col-md-4 form-control " id="add-skill-training"
										placeholder="Add Skill"> <input type="number"
										class=" col-md-4 form-control " id="duration-training"
										placeholder="Duration"> <input type="text"
										class=" col-md-3 form-control " id="skill-category-training"
										placeholder="Category">
								</div>
								<div class="">
									<input type="button" class="btn btn-default save-skill"
										value="Add Skill">
								</div>
							</div>
							<div id="save">
								<input type="submit" class="btn btn-primary" value="Save">
								<input type="button" class="btn btn-default " value="Cancel"
									id="cancel-trainingForm">
							</div>
						</form>
					</div>
					<div id="realtime-experience">
						<form action="Javascript:chechEditAddRealExperience()"
							id="realtime-form" name="realtime-form">
							<div class='always-hide'></div>
							<div>
								<label for="start-date">Start Date*</label> <input type="date"
									id="start-date" class="form-control" required="required">
							</div>
							<div>
								<label for="end-date">End Date*</label> <input type="date"
									id="end-date" class="form-control" required="required">
							</div>
							<div>
								<label for="pocName">POC Name</label> <input type="text"
									id="pocName" placeholder="POC Name" class="form-control">
							</div>
							<div>
								<label for="pocContactNo">POC Contact No</label> <input
									type="text" id="pocContactNo" placeholder="POC Contact No"
									class="form-control">
							</div>
							<div>
								<label for="description">Description</label> <input type="text"
									id="description" placeholder="Description" class="form-control">
							</div>
							<div>
								<label for="roleName">Role name</label> <input type="text"
									id="roleName" placeholder="Role name" class="form-control">
							</div>
							<div id="is_current">
								<label>Is Current?</label><br> <input type="radio"
									name="is-current" value="yes" checked> Yes <input
									type="radio" name="is-current" value="no"> No
							</div>

							<div>
								<label for="project-title">Project Title</label> <input
									class="form-control" type="text" placeholder="project-title"
									id="project-title" />
							</div>
							<div>
								<label for="project-overview">Project Overview</label>
								<textarea class="form-control" id="project-overview"
									class="col-md-5"></textarea>
							</div>
							<div>
								<label for="project-url">Project Url</label> <input type="text"
									placeholder="Project Url" id="project-url" class="form-control" />
							</div>
							<div>
								<label for="company-name">Company Name</label> <input
									type="text" placeholder="Company Name" id="company-name"
									class="form-control" />
							</div>
							<div class="row preferred-table">
								<div class="profile-topic-contactInfo  test1">
									<div class="box">
										<div class="box-body table-responsive no-padding">
											<table
												class="table table-bordered table-striped  skill-table"
												id='realtime-skilltable'>
												<tbody>
													<tr>
														<th class="col-md-2">SKill</th>
														<th class="col-md-3">Duration</th>
														<th class="col-md-2">Category</th>
														<th class="col-md-1"></th>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="add-new-skill">
								<div>
									<label>Add Skill</label><br> <input type="text"
										class=" col-md-4 form-control " id="add-skill-realtime"
										placeholder="Add Skill"> <input type="number"
										class=" col-md-4 form-control " id="duration-realtime"
										placeholder="Duration"> <input type="text"
										class=" col-md-3 form-control " id="skill-category-realtime"
										placeholder="Category">
								</div>
								<div class="realtime">
									<input type="button" class="btn btn-default save-skill"
										value="Add Skill">
								</div>
							</div>
							<div id="save">
								<input type="submit" class="btn btn-primary save-add"
									value="Save"> <input type="button"
									class="btn btn-default  " value="Cancel"
									id="cancel-realTimeForm">
							</div>
						</form>
					</div>
				</div>
				<!-- EXPERIENCE ENDING -->
				<!-- EMPLOYMENT BEGINNING -->



				<div class="model-content-employment profile-body-content"
					id="employment">
					<div class="profile-topic-heading">Job Employment</div>


				</div>



				<div class="profile-topic-add" id="add-employment">Add
					Employment</div>

				<div id="job" class="add-hide" style="width: 73%">
					<form action="Javascript:checkEditAddEmployment()" method="POST"
						id="editEmployment" name="employmentForm">
						<div class="always-hide"></div>
						<div>
							<label for="designation">Designation*</label> <input type="text"
								id="designation" name="designation" class="form-control"
								required="required">
						</div>
						<div>

							<label for="company">Company Name*</label> <input type="text"
								id="company" name="company" class="form-control"
								required="required">
						</div>
						<div>
							<label for="package">Package[LPA]</label> <input type="number"
								id="package" name="package" class="form-control">
						</div>
						<div>
							<label for="start-date">Start Date*</label> <input type="date"
								id="start-date" name="start-date" class="form-control"
								required="required">
						</div>
						<div>
							<label for="end-date">End Date*</label> <input type="date"
								id="end-date" name="end-date" class="form-control"
								required="required">
						</div>
						<div>
							<label for="is-current">Is Current</label> <br> Yes<input
								type="radio" id="is-current" name="is-current" value="Yes">
							No<input type="radio" id="is-not-current" name="is-current"
								value="No" checked="checked">
						</div>

						<div id="save">
							<input type="submit" class="btn btn-primary" value="Save">
							<input type="button" class="btn btn-default " id="cancel-job"
								value="Cancel">
						</div>
					</form>
				</div>


				<!-- EMPLOYMENT ENDING -->
				<!-- CERTIFICATION BEGINNING -->


				<div class="model-content profile-body-content"
					id="certificationdiv">
					<div class="profile-topic-heading">Certification</div>
					<div id="certification-update"></div>
				</div>
				<div class="profile-topic-add" id="add-certification">Add
					Certification</div>
				<div id="certificationtest" class="add-hide" style="width: 73%">
					<form action="Javascript:checkAddEditCertificationInfo()"
						method="POST" id="certificationInfoForm"
						name="certificationInfoForm">
						<div class="always-hide"></div>
						<div>
							<label for="institute-name">Institute Name*</label> <input
								type="text" id="institute-name" name="institute-name"
								class="form-control" required="required">
						</div>
						<div>
							<label for="certified-date">Certified Date*</label> <input
								type="date" id="certified-date" name="certified-date"
								class="form-control" required>
						</div>
						<div>
							<label for="grade">Grade</label> <input type="text" id="grade"
								name="grade" class="form-control">
						</div>
						<div>
							<label for="certificate-name">Certificate Name</label> <input
								type="text" id="certificate-name" name="certificate-name"
								class="form-control" required="required">
						</div>
						<div>
							<label for="certificate-url">Certificate URL</label> <input
								type="text" id="certificate-url" name="certificate-url"
								class="form-control">
						</div>
						<div>
							<input type="submit" class="btn btn-primary" value="Save">
							<input type="button" class="btn btn-default "
								id="cancel-certificateInfo" value="Cancel">
						</div>
					</form>
				</div>


				<!-- CERTIFICATION ENDING -->


				<!-- Patents -->
				<div class="model-content profile-body-content" id="patentsdiv">

					<div class="profile-topic-heading">Patents</div>


				</div>
				<div class="profile-topic-add" id="add-patents">Add Patents</div>

				<div id="patents" class="add-hide" style="width: 73%">
					<form action="Javascript:checkEditAddPatent()" method="POST"
						id="patentForm" name="patentForm">
						<div class="always-hide"></div>
						<div>
							<label for="patent-title">Title*</label> <input type="text"
								id="patent-title" name="patent-title" class="form-control"
								required="required">
						</div>
						<div>
							<label for="date-of-issue">Date of Issue*</label> <input
								type="date" id="date-of-issue" name="date-of-issue"
								class="form-control" required>
						</div>
						<div>
							<label for="patent-application-number">Application Number</label>
							<input type="number" id="patent-application-number"
								name="patent-application-number" class="form-control">
						</div>
						<div>
							<label for="patent-office">Patent Office</label> <input
								type="text" id="patent-office" name="patent-office"
								class="form-control">
						</div>
						<div>
							<label for="patent-status">Patent Status</label><br> Issued<input
								type="radio" name="is-issued" id="Issued" value="Issued">
							Not-Issued<input type="radio" name="is-issued" id="Not-Issued"
								value="Not-Issued" checked="checked">
						</div>
						<div>
							<label for="patent-url">Patent URL</label> <input type="text"
								id="patent-url" name="patent-url" class="form-control">
						</div>
						<div>
							<label for="patent-description">Patent Description</label>
							<textarea id="patent-description" name="patent-description"
								class="form-control"></textarea>
						</div>
						<div>
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default " id="cancel-patent" value="Cancel">
						</div>
					</form>
				</div>

				<!-- End of Patents div -->

				<!-- Starting of Honors and Awards Div -->

				<div class="model-content-awardsAndHonors profile-body-content"
					id="awardsAndHonorsdiv">
					<div class="profile-topic-heading">Awards and Honors</div>



				</div>
				<div class="profile-topic-add" id="add-awardsAndHonors">Add
					Awards and Honors</div>
				<div id="awardsAndHonors" class="add-hide" style="width: 73%">
					<form action="Javascript:checkEditAddHonorsAndAwards()"
						method="POST" id="awardForm" name="awardForm">
						<div class="always-hide"></div>
						<div>
							<label for="awardAndHonor-title">Title*</label> <input
								type="text" id="awardAndHonor-title" name="awardAndHonor-title"
								class="form-control" required="required">
						</div>
						<div>
							<label for="date-of-issue">Date of Issue*</label> <input
								type="date" id="date-of-issue" name="date-of-issue"
								class="form-control" required>
						</div>
						<div>
							<label for="awardAndHonor-occupation">Occupation</label> <input
								type="text" id="awardAndHonor-occupation"
								name="awardAndHonor-occupation" class="form-control">
						</div>

						<div>
							<label for="awardAndHonor-issuer">Issuer</label> <input
								type="text" id="awardAndHonor-issuer"
								name="awardAndHonor-issuer" class="form-control">
						</div>

						<div>
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default " id="cancel-award" value="Cancel">
						</div>
					</form>
				</div>


				<!-- Awards and Honours ENDING  -->
				<!-- LANGUAGES BEGINNING  -->


				<div class="model-content profile-body-content" id="language-div">
					<div class="profile-topic-heading">Languages</div>
					<div id="language-update"></div>
				</div>
				<div class="profile-topic-add" id="add-languages">Add Language</div>

				<div id="languages" class="add-hide">
					<form action="Javascript:checkEditAddLanguage()" method="POST"
						id="editLang" name="editLang">
						<div class="always-hide"></div>
						<div>
							<label for="sel1">Select list: </label> <input
								list="known-languages" name="browser" id="known-languagestext">
							<datalist id="known-languages">
								<option value="English">
								<option value="Hindi">
								<option value="Marathi">
								<option value="Spanish">
								<option value="French">
							</datalist>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" id="read" name="read"
								value="">Read</label>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" id="write" name="write"
								value="">Write</label>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" id="speak" name="speak"
								value="">Speak</label>
						</div>
						<div id="save">
							<input type="submit" class="btn btn-primary save-add"
								value="Save"> <input type="button"
								class="btn btn-default  " id='cancel-lanugage' value="Cancel">
						</div>
					</form>
				</div>

				<!-- LANGUAGES ENDING  -->



			</section>
		</div>
		<!-- /.content-wrapper -->
	</div>
	<!-- ./wrapper -->
	<!--Jquery UI -->
	<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
	<!--Profanity jQuery -->
	<script src="../js/jquery.profanityfilter.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/jquery.caret/0.1/jquery.caret.min.js"></script>
	<!-- Map scripts -->
	<script src="../js/maps.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?libraries=places"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../js/demo.js"></script>
	<script src="../js/liveSession.js"></script>
	<!-- wow animate -->
	<!--main -->
	<script>
		$(document).ready(function() {
			$(".add-hide").hide();
		});
		$(function() {
			$('.cancel-add').click(function() {
				$(this).parent().parent().hide();
				$(this).parent().parent().prev().show();
			});
			$("a").click(function() {
				$(".treeview-menu").find('li').removeClass("active");
				$("a.active").removeClass("active");
				$(this).parent().addClass("active");
			});

		});
	</script>
	<script type="text/javascript">
		$(document).on('change', "#reason-to-connect", function() {
			if (this.value == "Special Requirements" || this.value == "Other") {
				$('.in-person').css("display", "block");
				$('#ifYes').css("display", "none");
				$("#yesCheck").prop('checked', false);
				$("#noCheck").prop('checked', true);
			} else {
				$('.in-person').css("display", "none");
			}
		});
	</script>
	<script type="text/javascript">
		if ($('#reason-to-connect :selected').text() == "Special Requirements"
				|| $('#reason-to-connect :selected').text() == "Other") {
			$('.in-person').css("display", "block");
		}
	</script>
	<script src="../js/wow.min.js"></script>
	<script src="../js/custom.js"></script>
	<script src="../js/profile.js"></script>
	<script src="../js/d3.min.js"></script>
	<script src="../js/searchlogic.js"></script>
	<script src="../js/searchaccessibility.js"></script>
</body>

</html>

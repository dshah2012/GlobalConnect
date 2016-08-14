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
    <title>TPS | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../css/base.css">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../css/skins/_all-skins.min.css">
    <!--Stylesheet for dashboard content-->
    <link rel="stylesheet" href="../css/Dashboard.css">
    <!--Stylesheet for datepicker-->
    <link rel="stylesheet" href="../css/jquery-ui.min.css">
    <link rel="stylesheet" href="../css/custom.css">
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" type="text/css" href="../css/maps.css">
    <!-- Stylesheet for profile completion -->
    <link rel="stylesheet" type="text/css" href="../css/circle.css">
    <link rel="stylesheet" href="../css/mobile.css">
    <link rel="stylesheet" href="../css/material.css">
    <!-- jQuery 2.1.4 -->
    <script src="../plugins/jQuery/jQuery-2.1.4.min.js">
    </script>
    <script src="../js/searchlogic.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <header class="main-header">
            <!-- Logo -->
            <a href="Account.html" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>G</b>C</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>Global</b> Connect</span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <form>
                    <input type="text" class="searchbar" autocomplete="off" id="searchBox" placeholder="Enter Your Queries Separated by Spaces">
                    </span>
                </form>
                <button id="hideshow" class="btn btn-info"><i class="fa fa-filter"></i> Filters</button>
                <div id="searchModal" class="modal1">
                    <div class="search-modal-content">
                        <span class="close wow fadeInUp">×</span>
                        <div id="search-filter-container">
                            <div id="search-filters">
                                <form action="" style="width: 60%;">
                                    <input class="messageCheckbox" type="checkbox" name="search-filter" value="name" checked><span class="filter-span">Name</span></input>
                                    </br>
                                    <input class="messageCheckbox" type="checkbox" name="search-filter" value="skills" checked><span class="filter-span">Skills</span></input>
                                    </br>
                                    <input class="messageCheckbox" type="checkbox" name="search-filter" value="location" checked><span class="filter-span">Location</span></input>
                                    </br>
                                    <input class="messageCheckbox" type="checkbox" name="search-filter" value="contact_no" checked><span class="filter-span">Contact No</span></input>
                                    </br>
                                    <input class="messageCheckbox" type="checkbox" name="search-filter" value="employers" checked><span class="filter-span">Employers</span></input>
                                    </br>
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
                    <button class="connect-me btn btn-primary"><i class="fa fa-link"></i>  Connect Me!</button>
                    <button class="connect-me connect-me-mobile btn btn-primary"><i class="fa fa-link"></i></button>
                    <div id="myModal" class="modal">
                        <div class="modal-content1">
                            <span class="close wow fadeInUp">×</span>
                <div class="connect-me-content">
                    <h2 style="text-align:center">Connect Me</h2>
                    <span class="text-info"><h4 style="text-align:center">Connect with Admin Krishna Kumar.</h4></span>
                    <form class="connect-me-form">
                        <div>
                            <span class="connect-label">Reason to Connect</span>
                            <select id="reason-to-connect" class="form-control connect-field">
                                <option value="Special Requirements">Special Requirements</option>
                                <option value="Suggestions">Suggestions</option>
                                <option value="Report Bug">Report Bug</option>
                                <option value="Report Abuse">Report Abuse</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                        <br/>
                        <div class="in-person" style="display: block;">
                            <span class="connect-label">In-Person Connect?</span>
                            <div class="connect-field">
                                <label class="radio-inline">
                                    <input type="radio" name="yesno" id="yesCheck" onclick="javascript:yesnoCheck();">YES
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="yesno" onclick="javascript:yesnoCheck();" id="noCheck" checked='checked'>NO
                                </label>
                            </div>
                            <br/>
                            <div id="ifYes" style="display:none;">
                                <br/>
                                <span class="connect-label">When</span>
                                <input type='date' class="connect-field" id='yes' name='yes'>
                            </div>
                        </div>
                        <br/>
                        <div>
                            <span class="connect-label">Description</span>
                            <textarea class="form-control connect-field">
                            </textarea>
                        </div>
                        <footer>
                            <button class="btn btn-primary connect-btn wow fadeInUp" onclick="connectFeedback(); return false;">
                                Connect!
                            </button>
                        </footer>
                    </form>
                </div>
    </div>
    </div>
    </span>
    <span class="notification">
                    <i class="fa fa-globe fa-lg fa-spin" id="notif"></i>
                    <div id="notifModal" class="modal">
                        <div class="notification-wrapper">
                            <span class="close wow fadeInUp">×</span>
    <div class="notification-content">
        Notifications</br>
        <p style="word-wrap: break-word;"><b>Link 1: </b>http://www.youtube.com/embed/CnTdJ5tG5Hk</p>
        <p style="word-wrap: break-word;"><b>Link 2: </b>http://www.youtube.com/embed/Y7C0oXks-qM</p>
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
            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="../img/user2-160x160.jpg" class="user-image" alt="User Image">
                    <span class="hidden-xs">Chandra Shekhar</span>
                </a>
                <ul class="dropdown-menu">
                    <!-- User image -->
                    <li class="user-header">
                        <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        <p>
                            Chandra Shekhar - Trainer
                            <small>Member since Nov. 2012</small>
                        </p>
                    </li>
                    <!-- Menu Footer-->
                    <li class="user-footer">
                        <div class="text-center">
                            <a href="logout" class="btn btn-default btn-flat btn-logout">Sign out</a>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar" id="left-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <ul class="sidebar-menu">
                <li class="treeview active">
                    <a href="Account.jsp" onclick="return false;">
                        <i class="fa fa-dashboard"></i> <span>Dashboard</span> <i class="pull-right"></i>
                    </a>
                </li>
                <li class="treeview left-profile-nav">
                    <a href="Pages/profile.jsp">
                        <i class="fa fa-user"></i> <span>Profile</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu menu-open">
                     <li><a href="#about"><i class="fa fa-circle-o"></i>About ME</a></li>
                        <li><a href="#personal"><i class="fa fa-circle-o"></i>Personal Info</a></li>
                        <li><a href="#contact"><i class="fa fa-circle-o"></i>Contact Info</a></li>
                        <li><a href="#education-div"><i class="fa fa-circle-o"></i>Educational Info</a></li>
                        <li><a href="#skills"><i class="fa fa-circle-o"></i>Skill Set</a></li>
                        <li><a href="#experience-div"><i class="fa fa-circle-o"></i>Experience </a></li>
                        <li><a href="#certificationdiv"><i class="fa fa-circle-o"></i>Certification</a></li>
                        <li><a href="#employment"><i class="fa fa-circle-o"></i>Job Employment</a></li>
                        <li><a href="#pre-contact"><i class="fa fa-circle-o"></i>Preferred Contact</a></li>
                        <li><a href="#address-div"><i class="fa fa-circle-o"></i>Address</a></li>
                        <li><a href="#patentsdiv"><i class="fa fa-circle-o"></i>Patents</a></li>
                        <li><a href="#awardsAndHonorsdiv"><i class="fa fa-circle-o"></i>Awards and Honors</a></li>
                        <li><a href="#language-div"><i class="fa fa-circle-o"></i>Languages</a></li>
                    </ul>
                </li>
                
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
                <li class="treeview right-stats">
                    <a href="#" onclick="displayStat(); return false;">
                        <i class="pull-left right-sidebar-desktop"></i>
                        <i class="pull-left right-sidebar-mobile"></i>
                        <i class="fa fa-line-chart"></i>
                        <div class="rightNavigation">Statistics</div>
                        <div class="rightNavigation-mobile"></div>
                    </a>
                </li>
                <li class="treeview right-video">
                    <a href="#" onclick="liveVideo()">
                        <i class="pull-left right-sidebar-desktop"></i>
                        <i class="pull-left right-sidebar-mobile"></i>
                        <i class="fa fa-signal"></i>
                        <div class="rightNavigation">Live Streaming</div>
                        <div class="rightNavigation-mobile"></div>
                    </a>
                </li>
                <li class="treeview right-findtrainers">
                    <a href="#" onclick="findTrainers(); return false;">
                        <i class="pull-left right-sidebar-desktop"></i>
                        <i class="pull-left right-sidebar-mobile"></i>
                        <i class="fa fa-binoculars"></i>
                        <div class="rightNavigation" id="findTrainerText">Find Trainers</div>
                        <div class="rightNavigation-mobile"></div>
                        <div><img id="map-button" style="display: none;" /></div>
                        </span> <i class="pull-left"></i>
                    </a>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div id="search-result-container">
                <div id="experience-container" width="300" height="150" style="height:60px;overflow: hidden;width:500px;">
                    <h5 style="margin-left: 80%;margin-top: 16px;"><i class="fa fa-code code-exp"></i><b style="margin-left: 5px;">Experience</b></h5></div>
                <div id="search-results">
                </div>
            </div>
        </section>
        <div id="spare">
            <div class="dashboard-showcase bg-green" onclick="redirectToProfile();">
                <div class="profileCompletion">
                    <div class="c100 p0 green small dark" id="profileCompletion">
                        <span>0%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>
                    <h4 class="profileComp-desktop">Profile Completeness</h4>
                    <h4 class="profileComp-mobile"></h4>
                </div>
                <!--                 <div class="icon"> -->
                <!--                     <i class="ion ion-ios-grid-view-outline ion-custom"></i> -->
                <!--                 </div> -->
            </div>
            <div class="dashboard-showcase bg-red">
                <div class="icon">
                    <i class="ion ion-ios-book-outline ion-custom"></i>
                    <div class="profileViews">
                        <h4 class="profileComp-desktop">Profile Views</h4>
                        <h4 class="profileComp-mobile"></h4>
                    </div>
                </div>
            </div>
            <div class="dashboard-showcase bg-yellow">
                <div class="icon">
                    <i class="ion ion-ios-redo-outline ion-custom"></i>
                    <div class="profileViews">
                        <h4 class="profileComp-desktop">Share Profile</h4>
                        <h4 class="profileComp-mobile"></h4>
                        <div id="shareProfile" style="font-size: 11px;">
                            <input type="text" class="share-profile-desktop" placeholder="Enter email and press enter" />
                            <input type="text" class="share-profile-mobile" placeholder="Enter email" />
                            <span style="display: none;"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div id="chart" class="chart-dash">
            </div>
        </div>
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.0
        </div>
        <strong>Copyright &copy; 2016-2017 <a href="http://www.amadeus.com"> Amadeus Software Labs</a><br/></strong> All rights reserved.
    </footer>
    </div>
    <!-- ./wrapper -->
    <!--Jquery UI -->
    <script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
    <!--Profanity jQuery -->
    <script src="../js/jquery.profanityfilter.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.caret/0.1/jquery.caret.min.js"></script>
    <!-- Map scripts -->
    <script src="../js/mapsSearch.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?libraries=places"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../js/demo.js"></script>
    <!-- wow animate -->
    <!--main -->
    <script src="../js/wow.min.js"></script>
    <script src="../js/custom.js"></script>
    <script src="../js/liveSession.js"></script>
    
    <script>
    $(function() {
        $("#datepicker10").datepicker();
    });

    function redirectToProfile() {
        window.location.href = 'profile.jsp';
    }
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
    <script src="../js/searchaccessibility.js"></script>
    <script src="../js/d3.min.js"></script>
</body>

</html>

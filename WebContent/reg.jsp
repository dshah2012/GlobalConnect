<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
<script>
function terms() {
	var myWindow =window.open("", "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=200, left=500, width=400, height=400");
	  myWindow.document.write("<h1>Terms and Conditions</h1>")
}

function myFunction() {

    var x = document.getElementById("DOB");
    var y = x.value;
    var k = new Date(y);
    var bday = k.getYear();
    var todayDate = new Date();
    var today = todayDate.getYear();
    var diff = today - bday;
    // alert(diff);
    if (diff > 100)
        document.getElementById("dobspan").innerHTML = "*The age should not be greater than 100 years";
    else if (diff < 15)
        document.getElementById("dobspan").innerHTML = "*The age should not be less than 15 years";
}

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

function isAlphabet(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode > 31 )&& (charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
     
        return false;
    }
    return true;
}

function resetForm() {
   // window.location.reload();
   document.getElementById("spanfname").innerHTML = "";
     document.getElementById("angspanfname").className = "ng-hide";
      document.getElementById("spanuname").innerHTML = "";
       document.getElementById("angspanuname").className = "ng-hide";
        document.getElementById("spanemail").innerHTML = "";
         document.getElementById("angspanemail").className = "ng-hide";
          document.getElementById("spanphone").innerHTML = "";
           document.getElementById("angspanphone").className = "ng-hide";
}
function sa()
{   
  
  if(document.forms["regform"]["salutation"].value == "MR")
	{ 
document.getElementById("female").checked=false;
document.getElementById("male").checked=true;
document.getElementById("male").disabled=false;
	document.getElementById("female").disabled=true;
	}
if(document.forms["regform"]["salutation"].value == "MRS" || document.forms["regform"]["salutation"].value == "MS")
	{
  document.getElementById("male").checked=false;
  document.getElementById("female").checked=true;
	document.getElementById("male").disabled=true;
	document.getElementById("female").disabled=false;
	}
if(document.forms["regform"]["salutation"].value == "DR")
{
document.getElementById("male").disabled=false;
document.getElementById("female").disabled=false;
}
}

function validateEmail(){

    var email = document.forms["regform"]["email"].value;
    var patt = /^[A-Z][a-z]*$/;
    var patt2 = /[0-9]{10}/;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.getElementById("spanemail").innerHTML = "Not a valid e-mail address";
        setTimeout(function(){ 
        	document.getElementById("spanemail").innerHTML="";
        }, 5000);
        return false;
    }else{
    	return true;
    }
}

function validateMobileNo(){
    var phone = document.forms["regform"]["phone"].value;
    var patt = /^[A-Z][a-z]*$/;
    var patt2 = /[0-9]{10}/;
    if (!(phone.match(patt2))) {
        document.getElementById("spanphone").innerHTML = "* Should contain exactly 10 digits";
        setTimeout(function(){ 
        	document.getElementById("spanphone").innerHTML="";
        }, 5000);
        return false;
    }else{
    	return true;
    }
}

function sendMailRegistrationSuccessful(){
    var email = document.forms["regform"]["email"].value;
    var firstname = document.forms["regform"]["firstname"].value;
    var lastname = document.forms["regform"]["lastname"].value;
    var phone = document.forms["regform"]["phone"].value;
    
    var messageBody = "Welcome " + firstname + " </br> Your password for the Global Connect portal is <b>" + generateRandomString(10) + "</b>";
    var input = $("<input>").attr("type", "hidden").attr("name", "emailTo").val(email);
    $('#regform').append($(input));
    var input = $("<input>").attr("type", "hidden").attr("name", "emailSubject").val("Welcome to GlobalEdify");
    $('#regform').append($(input));
    var input = $("<input>").attr("type", "hidden").attr("name", "emailBody").val(messageBody);
    $('#regform').append($(input));
    var input = $("<input>").attr("type", "hidden").attr("name", "redirectPage").val("Pages/registrationSuccessful.html");
    $('#regform').append($(input));
}


function validateForm() {
	if(	validateEmail() && validateMobileNo()){
		return true;
	}else{
		return false;		
	}
}

function generateRandomString(stringLen)
{
	if(stringLen<5)
		stringLen = 5;
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < stringLen; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
}
function addRegdetails() {  
	if(validateForm()){
	   var firstname=$('#firstname').val();
	   var lastname=$('#lastname').val();
	   var salutation=$('#salutation').val();
	   var username=$('#usernameReg').val();
	   var dateOfBirth=$('#DOB').val();
	   var primaryMailId=$('#email').val();
	   var primaryMobileNo=$('#phone').val();
	   var gender=$('[name="gender"]').val();
	  $.ajax({  
	    type: "POST",  
	    url: "addRegDetails.htm",
	    data: "salutation=" + salutation + "&firstname=" + firstname + "&lastname=" + lastname + "&username=" + username 
	    + "&dateOfBirth=" + dateOfBirth + "&primaryMailId=" + primaryMailId + "&primaryMobileNo=" + primaryMobileNo + "&gender=" + gender,
	    success: function(response){
	    	if(response == "success"){
	    		sendMailRegistrationSuccessful();
		     //   alert("Registered successfully")  ;
	    	}else{
	    		//alert("" + response);
	    		if(response=="userName Not available")
	    			$(spanuname).html("This username is not available!!");
	    		else
	    			$(spanemail).html("This emailid is already registered!!");
	    	}   	  	    
	    },  
	    error: function(e){  
	     alert("In Error");  
	   
	    }  
	  });  
	}else{
		// validation failed
		console.log("validation failed");
	}
}
function checkAvailability(){  
	username = $('#usernameReg').val();
	  $.ajax({  
	    type: "POST",  
	    url: "checkAvailability.htm",  
	    data: "username=" + username,
	    success: function(response){  
	   			console.log(response);
	   			if(response=="true")
	   				{
	   			 $('#spanuname').css("padding-left","200px").html("available");
	   			
				 document.getElementById("reg-submit-button").disabled = false;
					}
	   			else
	   				{
	   			 $('#spanuname').css("padding-left","200px").html("unavailable");
		   			
				 document.getElementById("reg-submit-button").disabled = true;
	   				}
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}

	
</script>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
<body ng-app="">
	<form id="regform" method="post" action="http://www.ndtv.com" onsubmit="return false;"
		name="regform" autocomplete="off">
		<div class="row reg-container">
			<label class=" col-md-4 reg-data-label" for="salutation"
				style="width: 24.5%;">Salutation*: </label> <select autofocus
				class=" col-md-5 form-control" style="width: 32.5%;" id="salutation"
				name="salutation" onchange="sa()" required>
				<option value="MR">MR</option>
				<option value="MRS">MRS</option>
				<option value="MS">MS</option>
				<option value="DR">DR</option>
			</select>
		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="firstname">First
				name *: </label> <input class="reg-data" name="firstname" id="firstname"
				ng-model="firstname" placeholder="Enter first name"
				onkeypress="return isAlphabet(event)" required> 
				<span id="angspanfname" ng-show="regform.firstname.$touched && regform.firstname.$invalid"
				style="color: red">*First name is required. </span> <span
				style="color: red" id="spanfname"></span>
		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="lastname">Last
				name: </label> <input class="reg-data" name="lastname" id="lastname"
				placeholder="Enter last name" type="text"
				onkeypress="return isAlphabet(event)">
		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="username">Desired
				Username *:</label> <input class="reg-data" style="margin-right: 5px"
				style="margin-bottom: 4px;" name="username" id="usernameReg" 	ng-model="username"
				placeholder="Enter desired username" type="text" pattern=".{4,}"
				required><input type="button"
				class="btn btn-success wow fadeInRight animated"
				id="checkavailability" name="checkavailability" value="Check"
				onclick="checkAvailability()"><span id="angspanuname"
				ng-show="regform.username.$touched && regform.username.$invalid"
				style="color: red" >*Minimum 4 characters</span> <span
				id="spanuname"
				style="position: absolute; left: 77%; bottom: 57%; color: red;"></span>
		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="DOB">Date of
				Birth : </label> <input class="reg-data" name="DOB" id="DOB" type="date"
				min="1916-01-01" max="2000-12-31" onchange="myFunction()"><span
				id="dobspan" style="color: red"></span>
		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="email">Email *: </label>
			<input class="reg-data" name="email" id="email" ng-model="email"
				placeholder="Enter email id" type="text" required><span
				id="angspanemail"
				ng-show="regform.email.$touched && regform.email.$invalid"
				style="color: red">*Email is required.</span><span
				style="color: red" id="spanemail"></span>

		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="phone">Mobile
				No.&nbsp;*: </label> <input class="reg-data" name="phone" id="phone"
				ng-model="phone" maxlength="10" placeholder="Enter phone number"
				type="text" onkeypress="return isNumber(event)" required><span
				id="angspanphone"
				ng-show="regform.phone.$touched && regform.phone.$invalid"
				style="color: red">*Mobile No. is required.</span> <span
				style="color: red" id="spanphone"></span>
		</div>
		<br>
		<div class="reg-container">
			<label class="col-md-4 reg-data-label" for="gender">Gender:&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<label class="gender-label"> <input name="gender"
				value="MALE" id="male" type="radio" checked="checked">Male
				&nbsp;&nbsp;&nbsp;&nbsp;
			</label> <label class="gender-label"> <input name="gender"
				value="FEMALE" id="female" type="radio" disabled>Female
			</label>
		</div>
		<br>
		<div class="reg-container" style="margin-left: 18%;">
			<input type="checkbox"
				style="margin-left: 17.5%; margin-top: 0; width: 20px;"
				class="col-md-4 reg-data-label" name="terms" id="terms" required>&nbsp;I
			agree to the <a href="#"  onclick="terms()">Terms and Conditions</a>
		</div>
		<div>
			<br> <input
				style="visibility: visible; animation-name: fadeInLeft;"
				id="reg-submit-button"
				class="btn btn-danger wow fadeInLeft animated" data-toggle="modal"
				data-target="#success" value="Submit" type="submit"
				onclick="addRegdetails()"> <input
				style="visibility: visible; animation-name: fadeInRight;"
				id="reg-reset-button" value="Reset" type="reset"
				class="btn btn-primary wow fadeInRight animated"
				onclick="resetForm()">
		</div>
	</form>
</body>
</html>
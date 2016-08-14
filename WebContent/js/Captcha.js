function Captcha(){
	var alpha = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
			'R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l',
			'm','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6',
			'7','8','9');
	var i;
	for (i=0;i<6;i++){
		var a = alpha[Math.floor(Math.random() * alpha.length)];
		var b = alpha[Math.floor(Math.random() * alpha.length)];
		var c = alpha[Math.floor(Math.random() * alpha.length)];
		var d = alpha[Math.floor(Math.random() * alpha.length)];
		var e = alpha[Math.floor(Math.random() * alpha.length)];
		var f = alpha[Math.floor(Math.random() * alpha.length)];
		var g = alpha[Math.floor(Math.random() * alpha.length)];
	}
	var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
	document.getElementById("mainCaptcha").value = code
}
function ValidCaptcha(){
	var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
	var string2 = removeSpaces(document.getElementById('txtInput').value);
	if (string1 == string2){
		return true;
	}
	else{        
		return false;
	}
}
function removeSpaces(string){
	return string.split(' ').join('');
}
function checkUserNameAndCaptcha()
{
	var userName = $("#fp_email").val();
	check3 = false;
	if(ValidCaptcha())
	{
		$.getJSON('json/userPswd.json', function(data){
			$.each(data, function(key,val){
				//alert("All emails found are : " + val.username);
				if (val.username == userName)
				{
					check3 = true;
					//alert("email that is true : " + val.username);
				}
			});

			//alert("check outside json block : "+check3);
			if(check3 == true)
			{
		        var messageBody = '<div>        <h2>Greetings from GlobalEdify !!</h2><p>Please find your new password :</p><p>Password: 2c39hacv</p><a href="www.google.com">Click Here to Login to your account</a><br><br><img src="http://globaledify.com/img/logo.png"></div>';

				$.ajax({
			        url: "sendMail",
			        method: "POST",
			        data: { "emailTo": userName,  "emailSubject": "GlobalEdify | New password", "emailBody": messageBody, "redirectPage": "false"},
			        dataType: "text",
			        success: function(data, status, jqXHR) {
			        	if(data == "true"){
			        		$('#ForgetPassword').html("An E-mail has been successfully sent.");
			        		$('#ForgetPassword').addClass('mail-success');
			        	}else{
			        		$('#ForgetPassword').html("Could not send the E-mail. Try Again.");
			        		$('#ForgetPassword').addClass('mail-failure');
			        	}
			        },
			        error: function(jqXHR, status, error) {
			        	$('#ForgetPassword').html("Could not send the E-mail. Try Again.");
		        		$('#ForgetPassword').addClass('mail-failure');
			        }
			    });
				
				
				Captcha();
				document.getElementById("fp_email").value = "";
				document.getElementById("txtInput").value = "";
			}
			else
			{
				alert('Username not found');
				Captcha();
				document.getElementById("fp_email").value = "";
				document.getElementById("txtInput").value = "";
			}
		});
	}
	else
	{
		alert("Captcha Mismatch!");
		Captcha();
		document.getElementById("fp_email").value = "";
		document.getElementById("txtInput").value = "";
	}
}
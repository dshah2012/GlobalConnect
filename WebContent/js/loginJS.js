$(window).load(function(){
	
	
	$('#btnSubmit').click(function(){
		var userName = $("#username").val();
		var password = $("#password").val();
		var output = '';
		check2 =true;
		$.ajax({
		    type: "POST",  
		    url: "login",
		    data: "login="+ userName +"&password="+ password, 
		    success: function(result){  
		        if(result=="true"){
					output += 'Authentication Success &#10003;';
					
					$('#valid').html(output);
					$("#valid").css("color", "green");
					$("#login-form").submit();
		        }else{
		        	check2 = false;
					$('#valid').html('Authentication Failure &#10007;');
					$("#valid").css("color","#a94442");
					return false;
		        	
		        }
		    },
		    error: function(XMLHttpRequest, textStatus, errorThrown) { 
				$('#valid').html('Error! Try again later &#10007;');
				$("#valid").css("color","#a94442");
				return false;
		    }       
		});
		
	});
	
	$("#fp_email").keyup(function(){
		var userName = $("#fp_email").val();
		var output = '<p style="color:green;">';
		check3 = false;
		$.getJSON('json/userPswd.json', function(data){
			$.each(data, function(key, val){
				if ((val.username)==userName)
				{
					output += '&#10003;';
					check3 = true;
				}
			});
			if(check3 == true)
			{
				output += '</p>';
				$('#valid1').html(output);
				document.getElementById("Submit").disabled = false;
				$("#Submit").css({"background-color":"green"});
			}
			else
			{
				$('#valid1').html('<p style="color:red;">&#10007;</p>');
				document.getElementById("Submit").disabled = true;
				$("#Submit").css({"background-color": "red"});
			}
		});
	});
});
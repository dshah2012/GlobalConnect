
function checkAvailability(){
    var userQuery = $("#usernameReg").val().toLowerCase();
    if (userQuery.length >= 4) {
        var regex = new RegExp(userQuery, "i");
        var output = '<span class="row">';
        //   var count = 1;
        $.getJSON('json/test_Registration.json', function(data) {
            $.each(data, function(key, val) {
                if ((val.username == userQuery)  )
                {
                    $('#spanuname').css("padding-left","200px");
                    document.getElementById("reg-submit-button").disabled = true;
                    output += '<img src="img/cross.png">';
                    return false;
                }
                else if((val.username != userQuery))
                {
                    $('#spanuname').css("padding-left","200px");
                    document.getElementById("reg-submit-button").disabled = false;
                    output += '<img style="margin-bottom: 13px;" src="img/check.png">';
                    return false;
                }
            });
            output += '</span>';
            $('#spanuname').html(output);
        });
    }
    else{

        $('#spanuname').html("");
    }
}

$('#checkavailability').click(checkAvailability());
$(window).load(function() {
    $('#reg-submit-button').mouseover(function(){

        //  alert("hurrah")
        var userQuery = $("#usernameReg").val().toLowerCase();
        if (userQuery.length >= 4) {
            var regex = new RegExp(userQuery, "i");
            var output = '<span class="row">';
            //   var count = 1;
            $.getJSON('json/test_Registration.json', function(data) {
                $.each(data, function(key, val) {

                    if ((val.username == userQuery))
                    {
                        output += 'Sorry the username is already taken';
                        //output +='<img src="img/cross.png">';
                        document.getElementById("reg-submit-button").disabled = true;

                        return false;
                    }
                    else if((val.username != userQuery))
                        document.getElementById("reg-submit-button").disabled = false;
                    else
                        document.getElementById("reg-submit-button").disabled = false;

                });
                output += '</span>';
                $('#spanuname').html(output);
            });
        }
        else{

            $('#spanuname').html("");
        }
    });

});

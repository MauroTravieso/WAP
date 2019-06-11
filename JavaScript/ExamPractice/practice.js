"use strict";

window.unload = function(){
    document.getElementById('btn').onclick = validateForm;
}

    function validateForm() {
        var name = document.getElementById("uname").value;
        var email = document.getElementById("uemail").value;
        var problem = document.getElementById("uproblem").value;
        
        console.log(name);
        console.log(email);

        if (name == "" && email == "") {
            alert("Name and email required!");
            return;
        }

        if(name == "") {
            alert("Name required!");
            return;
        }
        
        if (email == "") {
            alert("email required");
            return;
        }

        //var pattern = /[A-Za-z]{1,20}/;
        //var pattern = /[A - Z][a - zA - Z][^#&<>\"~;$^%{}?]{1,20}$/;
        var pattern = /([A-Z]{1}[a-z]{2,8})?\s?[A-Z]{1}[a-z]{0,11}/; 

        if (!name.match(pattern)) {
            alert("Invalid name");
            return;
        }
    }

    //document.getElementById("btn").onclick = validateForm;

    /*function validateForm() {
        var x = document.forms["myForm"]["uname"].value;
        console.log(x);
        if (x==""){
            alert("Empty fields");
            return false;
        }
    }*/
//}

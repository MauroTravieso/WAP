"use strict";
function calcTip() {
    var subtotalElem = document.getElementById('subtotal');
    var tipElem = document.getElementById('tip');
    var totalElem = document.getElementById('total');
    
    var subtotal = parseFloat(subtotalElem.value);
    var tip = parseFloat(tipElem.value);

    //Validate if the value is a number
    if (validateNumber(subtotal)) {
        if (validateNumber(tip) === false)
            return;
    } else
        return;

    var total = subtotal + subtotal*tip/100;
    
    //Print values in the console to check
    console.log(subtotalElem.value);
    console.log(tipElem.value);
    console.log(total);

    totalElem.innerHTML = '$' + total;
}

//Validate if the value is a number
function validateNumber(number) {

    if (isNaN(number)) {
        alert("A number is required!");
        return false;
    }
    return true;

}
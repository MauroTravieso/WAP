"use strict";
function displayAlert() {
    //alert("Hello, world!");
    //document.getElementById("textarea").style.fontSize = "24px";
    var elem = document.getElementById("textarea");
    var theCSSprop = window.getComputedStyle(elem).getPropertyValue("font-size");
    console.log(theCSSprop);
    theCSSprop = parseInt(theCSSprop)+2;
    console.log(theCSSprop);
    document.getElementById("textarea").style.fontSize = theCSSprop +'px';

    //timer
    //setTimeout(displayAlert,500);
    setInterval(displayAlert,500);
}

document.getElementById('btn').onclick = function() {displayAlert()};


//check
function onChange() {
    //alert("Hello, world!");
    document.getElementById("textarea").style.fontWeight = "bold";
    document.getElementById("textarea").style.color = "green";
    document.getElementById("textarea").style.textDecorationLine = "underline";
}

document.getElementById('color').onclick = function() {onChange()};



"use strict";
var pause = 1;
var count = 0;

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
    //setInterval(displayAlert, 500);
    
}

//Timer
/*function startStop() {
    if(count%2==0) {
        pause=1;

    } else 
        pause = 0;    
}*/

function counterTime() {
    //alert("here");
    console.log(pause);
    console.log(count);
    
    if (pause == 0) {
    //if (count%2 == 0) {
        clearInterval(setInterval(displayAlert, 1500));
        pause = 1;
        return;
    } 

    if (pause == 1) {
    //if (count%2 != 0) {
        setInterval(displayAlert, 1500);
        pause = 0;
        return;
    }
    count = count + 1;
    //console.log(count);
}

//document.getElementById('btn').onclick = function() {displayAlert()};
document.getElementById('btn').onclick = function () { counterTime() };


//check
function onChange() {
    //alert("Hello, world!");
    document.getElementById("textarea").style.fontWeight = "bold";
    document.getElementById("textarea").style.color = "green";
    document.getElementById("textarea").style.textDecorationLine = "underline";
}

document.getElementById('color').onclick = function() {onChange()};



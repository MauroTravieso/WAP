"use strict;"
window.onload = onLoad;

let speed;
let frames;
let currFrame;
let maxFrame;
let interval;
let data;

function onLoad(){
    setButtonClickEvent("start-button", onclickStart);
    setButtonClickEvent("stop-button", onclickStop);

    setOnChangeEvent("animation", onChangeAnimation);
    setOnChangeEvent("size", onChangeSize);
    setOnChangeEvent("turbo", onChangeTurbo);

    setControlStatus(false);
    initVars();
}

function initVars() {
    speed = 250;
    currFrame = 0;
    maxFrame = -1;

    data = ANIMATIONS['Exercise'];
    console.log(data);
    frames = getFrames(data);

    /*frames = [];*/ /*null;*/
    interval = null;
    data = null;
}

function setText(str) {
    let animateText = getElementById("animateText");
    animateText.value = str;
}

function getAnimationFrames() {
    if (data!=null) {
        frames = getFrames(data);
        maxFrame = frames.length;
        console.log(frames);
        console.log(currFrame);
    }
}

function animations() {
    setText(frames[currFrame]);
    currFrame++;
    if(currFrame===maxFrame)
        currFrame=0;
}

function clearTimer() {
    if(interval!=null) {
        clearInterval(interval);
        interval=null;
    }
}

function setControlStatus(isInProgress) {
    disableControlById("stop-button", !isInProgress);
    disableControlById("start-button", isInProgress);
    disableControlById("animation",isInProgress);
    disableControlById("animateText",isInProgress);
}

function onclickStart() {
    let animateText = getElementById("animateText");
    let s = animateText.value;
    console.log(s);

    getAnimationFrames();
    clearTimer();
    currFrame = 0;
    interval = setInterval(animations,speed);
    setControlStatus(true);
}

function onclickStop() {
    clearTimer();
    setText(data);
    setControlStatus(false);
}

function onChangeAnimation() {
    let index = this.selectedIndex;
    let choice = this.options[index].value;
    data = ANIMATIONS[choice];
    setText(data);
}

function onChangeSize() {
    let index = this.selectedIndex;
    let choice = this.options[index].value;
    let animateText = getElementById("animateText");
    animateText.style.fontSize = choice + "pt";
}

function setSpeed(s) {
    speed = s;
    clearTimer();
    interval = setInterval(animations,speed);
}

function onChangeTurbo() {
    if (this.checked) {
        setSpeed(50);        
    } else {
        setSpeed(250);
    }
}

//Event handlers
function setButtonClickEvent(id, eventHandler) {
    var btn = getElementById(id);
    btn.onclick = eventHandler;
}

function setOnChangeEvent(id, eventHandler) {
    var element = getElementById(id);
    element.onchange = eventHandler;
}

function getElementById(elementId) {
    return document.getElementById(elementId);
}

function disableControlById(id, state) {
    document.getElementById(id).disabled = state;
    //document.getElementById(id).setAttribute = state;
}

function getFrames(str) {
    return str.split("=====\n");
}


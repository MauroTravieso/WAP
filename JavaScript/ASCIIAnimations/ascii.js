"use strict;"

let speed;
let frames;
let currFrame;
let maxFrame;
let interval;
let data;

window.onload = onLoad;

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
    frames = null;
    interval = null;
    data = null;
}


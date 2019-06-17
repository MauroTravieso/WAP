"use strict";

var maze = (function() {
    var wallHit = false;
    var gameStarted = false;
    var msgWin = "You win!";
    var msgLose = "You lose! To start, click on \"S\"";

    //window.oload = (function(){};);
    $(document).ready(function() {
        $("#maze .boundary").mouseover(wallMouseOver);
        $("#end").mouseover(hitEnd);
        $("#start").click(startGame);
        $("#maze").mouseleave(mazeMouseLeave);
    });

    let mazeMouseLeave = function() {
        console.log("mazeMouseLeave");

        if (gameStarted === false) 
            return;
        
        wallMouseOver();
    };

    let bodyMouseMove = function(ev) {
        var x = ev.pageX - this.offsetLeft;
        var y = ev.pageY - this.offsetTop;
        let msg = "X: " + x + " Y: " + y;
        setTextMessage(msg);
        console.log("body");
    };

    let wallMouseOver = function () {
        if (gameStarted === false) 
            return;
        wallHit = true;
        $("#maze .boundary").addClass("youlose");
        setTextMessage(msgLose);
        gameOver();
    };

    let hitEnd = function() {
        if (gameStarted === false) 
            return;
        
        if (wallHit === false) {
            setTextMessage(msgWin);
        } else {
            setTextMessage(msgLose);
        }

        gameOver();
    };

    let startGame = function() {
        $("#maze .boundary").removeClass("youLose");
        wallHit = false;
        gameStarted = true;
        setTextMessage("Game started, go ahead!");
        setMousePointer('progress');
    };

    let setMousePointer = function(mouseIcon) {
        $("body").css('cursor',mouseIcon);
        $("#maze").css('cursor',mouseIcon);
    };

    let gameOver = function(){
        gameStarted = false;
        setMousePointer('default');
        console.log(gameStarted);
    };

    let setTextMessage = function(msg) {
        $("#status").text(msg);
    };

})();
var puzze = (function () {

    var emptySquarePosition = 15;
    var nRow = 0;
    var nPieces = 0;
    var autoPlayStatus = false;
    var autoPlayTimer = null;

    const COLS = 4;
    const NUM_STEPS = 50;
    const TILE_SIZE = 100;
    const MAX = 1000000;
    const TIME_OUT = 1000;
    //0: Move down, 1: Move left, 2: Move up, 3: Move right
    const MOVE = [{ i: 0, j: 1 }, { i: -1, j: 0 }, { i: 0, j: -1 }, { i: 1, j: 0 }];

    let bgImage = 'url("images/background.jpg")';
    let arrMoveStatus = [];
    let msgWin = "Yeah! you win!";

    //MoveStatus
    let MoveStatus = function (piece, oldPosition, newPosition) {
        this.piece = piece;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    };
    
    //window.onload
    $(document).ready(function () {

        jInit();

    });

    //Initialization
    let jInit = function () {

        $("#puzzlearea div").each(function (index) {
            initPuzze(this, index);
            nPieces++;
        });
        $("#shufflebutton").click(shuffle);
        $("#btnRandomMove").click(randomMoveClick);
        $("#btnAutoPlay").click(autoPlayClick);
        $("#btnStopAutoPlay").click(stopAutoPlayClick);
    };
    //console.log(boxesPosition);

    //Box Index
    let getBoxIndex = function (piece) {

        let left = $(piece).css('left');
        let top = $(piece).css('top');
        let x = parseInt(left);
        let y = parseInt(top);
        let col = Math.floor(x / TILE_SIZE);
        let row = Math.floor(y / TILE_SIZE);
        return row * COLS + col;
        //console.log(left);
    };

    //get box position
    let getBoxPosition = function (i) {
        return { x: ((i % COLS) * TILE_SIZE), y: (Math.floor(i / COLS) * TILE_SIZE) };
    };

    //to Move
    let move = function (piece, newPosition) {

        //console.log(piece);
        //get current position of piece
        let currentPosition = getBoxIndex(piece);

        //console.log("position of pices=" + currentPosition);

        //check if this piece can move to empty square position
        if (checkMove(currentPosition, emptySquarePosition) === false) return false;
        
        //Track the piece movement
        if (autoPlayStatus === false) {
            let moveStatus = new MoveStatus(piece, currentPosition, newPosition);
            arrMoveStatus.push(moveStatus);
        }
        //store current position to emptySquarePosition
        emptySquarePosition = currentPosition;
        console.log(emptySquarePosition);
        //move to new position
        setPosition(piece, newPosition);
    };
    
    //show messages
    let showMessage = function (msg) {
        $("#status").text(msg).css('color', 'red');
    };

    let cellIndex = function (position) {
        let c = {};
        c.i = position % COLS;
        c.j = Math.floor(position / COLS);
        return c;
    };
    
    let checkMove = function (currentPosition, newPosition) {
        let c1 = cellIndex(currentPosition);
        let c2 = cellIndex(newPosition);
        let d = Math.abs(c1.i - c2.i) + Math.abs(c1.j - c2.j);

        return d === 1;
    };

    let setPosition = function (piece, i) {
        let box = getBoxPosition(i);
        let left = box.x + 'px';
        let top = box.y + 'px';
        $(piece).css({ 'left': left, 'top': top });
    };

    let initPuzze = function (piece, i) {
        let box = getBoxPosition(i);
        let position = -box.x + 'px ' + (-box.y) + 'px';
        //boxesPosition.push(box);
        $(piece).addClass("puzzlepiece");
        setPosition(piece, i);
        $(piece).css({ 'backgroundImage': bgImage, 'backgroundPosition': position });
        //event handler adding
        $(piece).click(tileClick);
    };

    let tileClick = function () {
        //console.log($(this));
        move(this, emptySquarePosition);
        if (checkWin() === true)
            showMessage(msgWin);
    };

    let shuffle = function () {
        reset();
        for (let i = 0; i < NUM_STEPS; i++)
            randomMoveClick();

        console.log(arrMoveStatus);
    };

    let reset = function () {
        emptySquarePosition = 15;
        arrMoveStatus = [];
        showMessage("");
        let arr = [];
        for (let i = 0; i < emptySquarePosition; i++)
            arr[i] = i;
        drawPuzzle(arr);
    };
    
    let drawPuzzle = function (arr) {
        $("#puzzlearea div").each(function (index) {
            setPosition(this, arr[index]);
        });

        console.log(arr);

    };
    
    let randomMove = function (max) {
        let my_num = Math.floor(Math.random() * max);
        return my_num % 4;
    };
    
    let randomMoveClick = function () {
        let canMove = false;
        showMessage("");
        let nRows = Math.floor(nPieces / COLS) + 1;
        let emmtyCell = cellIndex(emptySquarePosition);
        let cellWillMove = {};
        let my_num = null;
        do {
            my_num = randomMove(MAX);
            cellWillMove.i = emmtyCell.i + MOVE[my_num].i;
            cellWillMove.j = emmtyCell.j + MOVE[my_num].j;
            if (cellWillMove.i >= 0 && cellWillMove.i < COLS) {
                if (cellWillMove.j >= 0 && cellWillMove.j < nRows) {
                    canMove = true;
                }
            }
        } while (canMove === false);
        let position = cellWillMove.j * COLS + cellWillMove.i;
        let piece = getPieceByPosition(position);
        move(piece, emptySquarePosition);
    };

    let getPieceByPosition = function (position) {
        $("#puzzlearea div").each(function (index, value) {

            if (position === getBoxIndex(this)) {
                console.log("index=" + index);
                move(value, emptySquarePosition);
                console.log("new=" + emptySquarePosition);
                return this;
            }

        });
    };
   
    let checkWin = function () {
        let res = true;
        $("#puzzlearea div").each(function (index, value) {
            console.log("index = " + index);
            console.log("box index= " + getBoxIndex(this));
            if (index !== getBoxIndex(this)) {
                console.log("false");
                res = false;
            }
        });

        return res;
    };
   
    let autoPlayClick = function () {
        autoPlayStatus = true;
        setAutoPlayStatus(autoPlayStatus);
        console.log("test");
        autoPlayTimer = setInterval(autoPlay, TIME_OUT);

    };
   
    let autoPlay = function () {
        let msg = "Remaining steps: " + arrMoveStatus.length;
        showMessage(msg);
        if (arrMoveStatus.length > 0) {
            let step = arrMoveStatus.pop();
            console.log(step);
            move(step.piece, step.oldPosition);
            console.log(arrMoveStatus);
        } else {
            autoPlayStatus = false;
            showMessage(msgWin);
            clearInterval(autoPlayTimer);
            setAutoPlayStatus(autoPlayStatus);
        }
    };

    let stopAutoPlayClick = function () {
        autoPlayStatus = false;
        clearInterval(autoPlayTimer);
        setAutoPlayStatus(autoPlayStatus);
    };

    let setAutoPlayStatus = function (disabled) {
        $("#shufflebutton").attr('disabled', disabled);
        $("#btnRandomMove").attr('disabled', disabled);
        $("#btnAutoPlay").attr('disabled', disabled);
        $("#btnStopAutoPlay").attr('disabled', !disabled);

    };

})();
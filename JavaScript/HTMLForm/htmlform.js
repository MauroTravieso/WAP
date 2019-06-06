//const name = document.getElementById("someId");

function changeText() {
    const textbox = document.getElementById("output");
    textbox.value = "Hello, world!";
}

function swapText() {
    const span = document.getElementById("output2");
    const textBox = document.getElementById("textbox2");
    const temp = span.innerHTML;
    span.innerHTML = textBox.value;
    textBox.value = temp;

    textBox.style.fontSize = "28px";
    span.style.fontSize = 14;
    span.style.color = "red";

}
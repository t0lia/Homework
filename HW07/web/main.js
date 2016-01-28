var acc = 0;
var op = "";
var clearFlag = false;

function clearDsp() {
    var target = document.getElementById("display_input");
    target.value = '';
};

function addSmb(digit) {
    var target = document.getElementById("display_input");
    if (clearFlag) {
        target.value = "";
        clearFlag = false;
    }

    if(digit === "." && target.value.lastIndexOf(".") > 0) {
        return;
    }
    target.value = target.value + digit;
};

function addOp() {
    acc = parseFloat(document.getElementById("display_input").value);
    op = "add";
    clearFlag = true;
};
function subOp() {
    acc = parseFloat(document.getElementById("display_input").value);
    op = "sub";
    clearFlag = true;
};


function divOp() {
    acc = parseFloat(document.getElementById("display_input").value);
    op = "div";
    clearFlag = true;
};
function mulOp() {
    acc = parseFloat(document.getElementById("display_input").value);
    op = "mul";
    clearFlag = true;
};

function modOp() {
    acc = parseFloat(document.getElementById("display_input").value);
    op = "mod";
    clearFlag = true;
};

function sqrtOp() {

    var target = document.getElementById("display_input");
    $.get("ajax.jsp?number=" + parseFloat(target.value), function (data) {
        $("#my").html(data);
        target.value = data;
    });

    //
    //alert("");
    //acc = parseFloat(document.getElementById("display_input").value);
    //op = "sqrt";
};




function evaluateOp() {

    var target = document.getElementById("display_input");
    var current = parseFloat(target.value);
    switch (op) {
        case "add":
            target.value = (acc + current).toString();
            break;
        case "sub":
            target.value = (acc - current).toString();
            break;
        case "mul":
            target.value = (acc * current).toString();
            break;
        case "div":
            target.value = (acc / current).toString();
            break;
        case "mod":
            target.value = (acc % current).toString();
            break;
    }

};
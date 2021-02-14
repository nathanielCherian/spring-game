function calculate() {
    var form = document.getElementById("frm1");
    var text = "";
    var a;
    var b;
    var c;

    a = form.elements[0].value;
    b = form.elements[1].value;

    c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));

    text += c;

    document.getElementById("c").innerHTML = text;
}
function addCell(formater) {
    var content = prompt("Please enter a word", "Harry Potter");
    var div = document.createElement('span');
    div.innerHTML = content;
    div.border = 'black';
    if (formater && formater instanceof Function) {
        div = formater(div) || div;
    }
    document.getElementById("theDiv").appendChild(div);
}
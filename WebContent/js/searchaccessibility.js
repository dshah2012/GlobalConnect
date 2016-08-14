
// Some key and mouse events are disabled on search box
// Arrow left, arrow up, ctrl+X, ctrl+V
$(document).on("keydown", "#searchBox,#mapSearch", function(event) {
    if (event.which == 37 || event.which == 38 || (event.ctrlKey && (event.which == 86 || event.which == 88))) {
        event.preventDefault();
     }else if(event.which == 40 || event.which == 39){
     }
});

$(document).on("click", "#searchBox,#mapSearch", function(event) {
	setSelectionRange(this, this.value.length, this.value.length);
});

// Code to change cursor location in input
var is_gecko = /gecko/i.test(navigator.userAgent);
var is_ie = /MSIE/.test(navigator.userAgent);

function setSelectionRange(input, start, end) {
	if (is_gecko) {
		input.setSelectionRange(start, end);
	} else {
		// assumed IE
		var range = input.createTextRange();
		range.collapse(true);
		range.moveStart("character", start);
		range.moveEnd("character", end - start);
		range.select();
	}
};

function getSelectionStart(input) {
	if (is_gecko)
		return input.selectionStart;
	var range = document.selection.createRange();
	var isCollapsed = range.compareEndPoints("StartToEnd", range) == 0;
	if (!isCollapsed)
		range.collapse(true);
	var b = range.getBookmark();
	return b.charCodeAt(2) - 2;
};

function getSelectionEnd(input) {
	if (is_gecko)
		return input.selectionEnd;
	var range = document.selection.createRange();
	var isCollapsed = range.compareEndPoints("StartToEnd", range) == 0;
	if (!isCollapsed)
		range.collapse(false);
	var b = range.getBookmark();
	return b.charCodeAt(2) - 2;
};

function inputKey(input, ev) {
	setTimeout(function () {
		document.getElementById("selStart").value = getSelectionStart(input);
		document.getElementById("selEnd").value = getSelectionEnd(input);
	}, 20);
}

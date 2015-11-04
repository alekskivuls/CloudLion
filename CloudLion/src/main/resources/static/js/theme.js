$('#theme').load('html/themeOption.html');
$('#lang').load('html/langOption.html');
$('#font').load('html/fontOption.html');

var editor = ace.edit("editor"); // initializes text editor
editor.setTheme("ace/theme/katzenmilch"); // default theme
editor.session.setMode("ace/mode/javascript"); // default language

function setTheme() {
	var value = document.getElementById("theme").value;
	var dir = "ace/theme/";
	var newTheme = dir.concat(value);
	var editor = ace.edit("editor");
	editor.setTheme(newTheme);
	//alert(value);
}
function setLang() {
	var value = document.getElementById("lang").value;
	var dir = "ace/mode/";
	var newLang = dir.concat(value);
	var editor = ace.edit("editor");
	editor.session.setMode(newLang);
	//	alert(value);
}
function setFont() {
	var value = document.getElementById("font").value;
	var editor = ace.edit("editor");
	document.getElementById('editor').style.fontSize = value;
	//	alert(value);
}

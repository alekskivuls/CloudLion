$('#theme').load('html/themeOption.html');
$('#lang').load('html/langOption.html');
$('#font').load('html/fontOption.html');
$('#file').load('html/fileOption.html');
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

function showContent() {
	//var textContent = document.getElementById("editor").getElementsByClassName("ace_content")[0];
	//alert(textContent.value);
	var editor = ace.edit("editor");
	var textContent = editor.getSession().getValue();
	alert(textContent);
}
var editor = ace.edit("editor"); // initializes text editor
editor.setTheme("ace/theme/katzenmilch"); // default theme
editor.session.setMode("ace/mode/javascript"); // default language
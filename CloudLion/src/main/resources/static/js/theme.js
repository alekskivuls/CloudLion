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
var folders = [];
var counter = 1;
var fId = "folder-" + counter;

function addFolder() {
	var folder = prompt("Enter Folder Name:");
	if (folder === null) {
        return; //break out of the function early
    }
	//folder = [];
	folders.push(folder);
	var list = document.getElementById("folders");
	 var li = document.createElement('li');
	 li.innerHTML = "<div id="+fId+" onclick='addFile(fId)'><span class='glyphicon glyphicon-plus' ></span><span class='glyphicon glyphicon-folder-close' ></span>     " + folders[folders.length-1] + "</div>";
	 list.insertBefore(li, list.firstChild);
	 counter++;
}

function addFile(clicked_id) {

	var file = prompt("Enter File Name:");
	if (file === null) {
        return; //break out of the function early
    }
	var list = document.getElementById(clicked_id);
	 var li = document.createElement('li');
	 li.innerHTML = "<p onclick='loadFile()'><span class='glyphicon glyphicon-list-alt' ></span> "+file +"</p>";
	list.parentNode.insertBefore(li, list.nextSibling);
}
function saveFile() {
	var editor = ace.edit("editor");
	var textContent = editor.getSession().getValue();
}s

function loadFile() {
	var x = "Save Work in Progress..";
	var editor = ace.edit("editor");
	var textContent = editor.getSession().getValue();
	editor.getSession().setValue(x);
}


var editor = ace.edit("editor"); // initializes text editor
editor.setTheme("ace/theme/katzenmilch"); // default theme
editor.session.setMode("ace/mode/javascript"); // default language
$('#file').load('html/fileOption.html');

function init() {
	var bHaveFileAPI = (window.File && window.FileReader);

	if (!bHaveFileAPI) {
		alert("This browser doesn't support the File API");
		return;
	}

	document.getElementById("fileElem").addEventListener("change",
			onFileChanged);
}

function onFileChanged(theEvt) {
	var thefile = theEvt.target.files[0];
	var totalBytes = 0;

	if (thefile.type != "text/plain") {
		alert("Invaild file");
		//document.getElementById('filecontents').innerHTML = "No text file chosen";
		return;
	}
	var reader = new FileReader();
	reader.onload = function(evt) {
		editor = ace.edit("editor");
		editor.setValue(reader.result);

	}
	reader.readAsText(thefile);
}

window.addEventListener("load", init);

function setFile() {
	var editor = ace.edit("editor");
	var getFile = document.getElementById("file").value;
	var Code = editor.getSession().getValue();
	var fileName;

	if (getFile == "save") {
		fileName = prompt('What do you want to name this file?');
	} else if (getFile == "new") {
		var check = confirm("Did you remember to save your changes?");
		if (check == true) {
			editor
					.setValue("function foo(items){\n\tvar x = \"All this is syntax highlighted\"; \n\treturn x;\n}");
		} else {

		}
	}

	$(function() {
		$.ajax({
			type : 'GET',
			url : "editor.html",
			data : {
				'code' : Code,
				'file' : getFile,
				'name' : fileName
			}
		});
	});
}

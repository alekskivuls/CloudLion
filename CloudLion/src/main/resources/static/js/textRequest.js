$('#file').load('html/fileOption.html');


function setFile(){
	
	var editor = ace.edit("editor");
	var getFile = document.getElementById("file").value;
	var Code = edit.getValue();

	$(function(){
		$ajax({
			url: "editor.html",
			type: 'GET',
			data: {'code': Code, 'file': getFile}
		});
	});
}
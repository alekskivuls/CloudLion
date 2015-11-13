$('#compiler').load('html/compiler.html');

//jquery ajax information taken from 
//http://api.jquery.com/jquery.ajax/ (accessed 11/1/2015)
//and
//http://stackoverflow.com/questions/5049635/how-to-send-data-to-remote-server-using-javascript
//(accessed 11/1/2015
//and
//https://www.youtube.com/watch?v=5nL7X1UMWsc
//accessed 11/2/2015

function compileCode() 
{
	//var value = document.getElementById("compiler").value;
	var editor = ace.edit("editor");
	
	var langValue = document.getElementById("lang").value;
	
	var Code = editor.getValue();	
	//alert(Code);
	
	$(function(){
		$.ajax({
			url: "editor.html",
			type: 'GET',
			data: {'code': Code}//, 'langValue': langValue}
			});
	});
	
}
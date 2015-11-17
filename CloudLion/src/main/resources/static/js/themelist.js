var themeData = document.getElementById("myDiv");

//Create array of options to be added
var array = [
    ["Chrome"],
    ["Clouds"],
    ["Crimson Editor" ],
    ["Dawn"],
    ["Dreamweaver"],
    ["Eclipse"],
    ["GitHub"],
    ["IPlastic"],
    ["Solarized Light"],
    ["TextMate"],
    ["Tomorrow"],
    ["XCode"],
    ["Kuroir"],
    ["KatzenMilch"],
    ["sqlserver"],
    ["ambiance"],
    ["chaos"],
    ["clouds_midnight"],
    ["cobalt"],
    ["idle_fingers"],
    ["kr_theme"],
    ["merbivore"],
    ["merbivore_soft"],
    ["mono_industrial"],
    ["monokai"],
    ["pastel_on_dark"],
    ["solarized_dark"],
    ["terminal"],
    ["tomorrow_night"],
    ["tomorrow_night_blue"],
    ["tomorrow_night_bright"],
    ["tomorrow_night_eighties"],
    ["twilight"],
    ["vibrant_ink"]
];
//Create and append select list
var selectList = document.createElement("select");
selectList.setAttribute("id", "mySelect");
myDiv.appendChild(selectList);

//Create and append the options
for (var i = 0; i < array.length; i++) {
    var option = document.createElement("option");
    option.setAttribute("value", array[i]);
    option.text = array[i];
    selectList.appendChild(option);
}

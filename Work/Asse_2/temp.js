var readline = require('readline');
var fs = require('fs');

var rl = readline.createInterface({
    input: fs.createReadStream('asset/India2011.csv')
});
var i = 0;
var j = 0;
var key = new Array();
var value = new Array();
rl.on('line', function (data) {
    if (i == 0) {
        key = data.split(",");
        if (key[key.length - 1].indexOf(";") > -1) {
            key[key.length - 1] = key[key.length - 1].replace(";", "");
        }
        i++;
    } else {
        value[j] = data.split(",");
        if (value[j][value[j].length - 1].indexOf(";") > -1) {
            value[j][value[j].length - 1] = value[j][value[j].length - 1].replace(";", "");
        }
        j++;
    }
    //csvData(key, value, null);
}).on('close', function () {
    csvData(key, value, null);
});

var finalData = new Array([]);
function csvData(key, value, err) {
    for (var arr in value) {
        if ((value[arr].indexOf("All ages") > -1) && (value[arr].indexOf("Total") > -1)) {
            finalData[t] = new Array();
            for (var arrData in value[arr]) {
                //console.log(key[arrData] + " " + value[arr][arrData]);
                finalData[t][finalData[t].length] = key[arrData] + "," + value[arr][arrData];
            }
            t++;
        }
    }
    jsonParse(finalData);
}
var t = 0;
var json = [];

var data = [];
function jsonParse(finalData) {
    for (var count in finalData) {
        var arr = finalData[count];
        var tempjson = {};

        for (var incount in arr) {
            data = arr[incount].split(",");
            tempjson[data[0]] = data[1];
        }
        json.push(tempjson);
    }
    jsonWrite(json);
}

function jsonWrite(json) {
    var file = "json/India2011.json";
    var v1 = fs.writeFile(file, JSON.stringify(json));
}

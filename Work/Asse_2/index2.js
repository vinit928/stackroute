/**
 * Created by lenovo on 22-03-2016.
 * Author: Vinit Kumar Goel
 */
var csv = require("csv-stream");

var fs = require("fs");

var jsonObj = new Array();
var csvStream = csv.createStream();
var j = 0;
fs.createReadStream('asset/India2011.csv').pipe(csvStream).on('data', function (data) {

    if ((data["Age-group"] == "All ages") && data["Total/ Rural/ Urban"] == "Total") {
        jsonObj[j] = {
            "Area Name": data["Area Name"],
            "Total Persons": data["Total Persons"],
            "Total Males": data["Total Males"],
            "Total Females": data["Total Females"],
            "Illiterate - Persons": data["Illiterate - Persons"],
            "Illiterate - Males": data["Illiterate - Males"],
            "Illiterate - Females": data["Illiterate - Females"],
            "Literate - Persons": data["Literate - Persons"],
            "Literate - Males": data["Literate - Males"],
            "Literate - Females": data["Literate - Females"],
        }
        j++;

    }
}).on('end', function () {
    var file = "json/India2011.json";
    var v1 = fs.writeFile(file, JSON.stringify(jsonObj), jsonRead);
})


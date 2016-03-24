var async = require("async");
var fs = require("fs");
var Converter = require("csvtojson").Converter;


var converter = new Converter({});
fs.createReadStream("asset/India2011.csv").pipe(converter);
var jsonObj = new Array();
converter.on("end_parsed", function (jsonArray) {

    var j = 0;
    for (var i in jsonArray) {
        var json = jsonArray[i];
        if ((json["Age-group"] == "All ages") && (json["Total/ Rural/ Urban"] == "Total")) {
            jsonObj[j] = {
                "Area Name": json["Area Name"],
                "Total Persons": json["Total Persons"],
                "Total Males": json["Total Males"],
                "Total Females": json["Total Females"],
                "Illiterate - Persons": json["Illiterate - Persons"],
                "Illiterate - Males": json["Illiterate - Males"],
                "Illiterate - Females": json["Illiterate - Females"],
                "Literate - Persons": json["Literate - Persons"],
                "Literate - Males": json["Literate - Males"],
                "Literate - Females": json["Literate - Females"],
            }
            j++;
            continue;
        }
    }
    var file = "json/India2011.json";
    var v1 = fs.appendFile(file, JSON.stringify(jsonObj), jsonRead);
});
function jsonRead(err) {
    var India2011 = JSON.parse(fs.readFileSync("json/India2011.json"));
    var tp = 0;
    for (var i in India2011) {
        var json = India2011[i];
        tp = tp + json["Total Persons"];
    }
    console.log(tp);
}













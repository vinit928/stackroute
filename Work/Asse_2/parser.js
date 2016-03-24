var Converter = require("csvtojson").Converter;
var fs = require("fs");

var async = require("async");



function jsonCon() {
    var converter = new Converter({});
    fs.createReadStream("asset/India2011.csv").pipe(converter);

    converter.on("end_parsed", function (jsonArray) {
            var jsonObj = new Array();
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
            fs.appendFile('json/India2011.json', JSON.stringify(jsonObj));


        }
    );
}

function jsonShow() {
    var India2011 = JSON.parse(fs.readFileSync("json/India2011.json"));
    console.log(India2011[12]["Total Persons"]);
}
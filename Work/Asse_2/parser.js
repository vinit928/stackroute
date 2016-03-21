var Converter = require("csvtojson").Converter;
var fs = require("fs");
fs.appendFile('json/India2011.json', '[');
jsonCon();
console.log("1");
function jsonCon() {
    var converter = new Converter({});
    fs.createReadStream("asset/India2011.csv").pipe(converter);

    converter.on("record_parsed", function (jsonArray) {
            var jsonObj;
            for (var prop in jsonArray) {
                if ((jsonArray["Age-group"] == "All ages") && (jsonArray["Total/ Rural/ Urban"] == "Total")) {
                    jsonObj = {
                        "Area Name": jsonArray["Area Name"],
                        "Total Persons": jsonArray["Total Persons"],
                        "Total Males": jsonArray["Total Males"],
                        "Total Females": jsonArray["Total Females"],
                        "Illiterate - Persons": jsonArray["Illiterate - Persons"],
                        "Illiterate - Males": jsonArray["Illiterate - Males"],
                        "Illiterate - Females": jsonArray["Illiterate - Females"],
                        "Literate - Persons": jsonArray["Literate - Persons"],
                        "Literate - Males": jsonArray["Literate - Males"],
                        "Literate - Females": jsonArray["Literate - Females"],
                    }
                    jsonRead(jsonObj);
                    //fs.appendFile('json/India2011.json', JSON.stringify(jsonObj) + ",");
                    break;
                }
            }
        }
    );


}

function jsonRead(jsonObj) {

    console.log(jsonObj);

}
var Converter = require("csvtojson").Converter;


var fs = require("fs");


var async = require("async");
async.waterfall([
    function (callback) {
        jsonCon();
        console.log("1");
        callback(null, callback);

    },

    function (temp, callback) {
        var India2011 = JSON.parse(fs.readFileSync("json/India2011.json"));
        console.log(India2011[12]["Total Persons"]);

        callback(null, callback);
    },
], function (err, result) {
    console.log("err");
});


function jsonCon() {
    var Converter = require("csvtojson").Converter;
    var fs = require("fs");
    var converter = new Converter({});
    fs.createReadStream("asset/India2011.csv").pipe(converter);
    fs.appendFile('json/India2011.json', '[');
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
                        "Illiterate - Femaless": jsonArray["Illiterate - Females"],
                        "Literate - Persons": jsonArray["Literate - Persons"],
                        "Literate - Males": jsonArray["Literate - Males"],
                        "Literate - Females": jsonArray["Literate - Females"],
                    }
                    fs.appendFile('json/India2011.json', JSON.stringify(jsonObj) + ",");
                    break;
                }
            }
        }
    );
}




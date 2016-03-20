var Converter = require("csvtojson").Converter;
var converter = new Converter({});
var fs = require("fs");

var jsonData;

converter.on("record_parsed", function (jsonArray) {
    console.log(jsonArray);
});


fs.createReadStream("asset/temp.csv").pipe(converter);
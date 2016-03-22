/**
 * Created by lenovo on 22-03-2016.
 * author: Vinit Kumar Goel
 */
var csv = require("csv-stream");

var fs = require("fs");


var csvStream = csv.createStream();
fs.createReadStream('asset/India2011.csv').pipe(csvStream).on('column', function (key, value) {

    if ((key == "Age-group") && (value == "All ages")) {
        console.log()
    }

})
/**
 * Created by lenovo on 28-03-2016.
 */

var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-1.12.2.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

var script2 = document.createElement('script');
script2.src = 'http://d3js.org/d3.v3.min.js';
script2.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script2);

function visible(jsonFile, command) {

    $.getJSON("json/" + jsonFile, function (data) {
        jsonParse(data, command);
    });
}

function jsonParse(json, command) {
    var tm = 0;
    var tf = 0;
    var ilm = 0;
    var ilf = 0;
    var lm = 0;
    var lf = 0;
    var Ntm = 0;
    var Ntf = 0;
    var Nilm = 0;
    var Nilf = 0;
    var Nlm = 0;
    var Nlf = 0;
    for (var i in json) {
        var data = json[i];
        tm = +tm + +data["Total Males"];
        tf = +tf + +data["Total Females"];
        ilm = +ilm + +data["Illiterate - Males"];
        ilf = +ilf + +data["Illiterate - Females"];
        lm = +lm + +data["Literate - Males"];
        lf = +lf + +data["Literate - Females"];
        if ((data["Area Name"] == "State - ARUNACHAL PRADESH") || (data["Area Name"] == "State - ASSAM") ||
            (data["Area Name"] == "State - MANIPUR") || (data["Area Name"] == "State - MEGHALAYA") ||
            (data["Area Name"] == "State - MIZORAM") || (data["Area Name"] == "State - NAGALAND") ||
            (data["Area Name"] == "State - TRIPURA")) {
            Ntm = +Ntm + +data["Total Males"];
            Ntf = +Ntf + +data["Total Females"];
            Nilm = +Nilm + +data["Illiterate - Males"];
            Nilf = +Nilf + +data["Illiterate - Females"];
            Nlm = +Nlm + +data["Literate - Males"];
            Nlf = +Nlf + +data["Literate - Females"];
        }
    }
    if (command == "totalPopulation") {

        totalPopulation(tm, tf, ilm, ilf, lm, lf);

    } else if (command == "nePopulation") {
        nePopulation(Ntm, Ntf, Nilm, Nilf, Nlm, Nlf);

    } else if (command == "stateRatio") {
        stateRatio(json);
    }

}

function totalPopulation(tm, tf, ilm, ilf, lm, lf) {
    document.write("<div>");
    var data = [tm, tf];
    var r = 70;
    var color = d3.scale.ordinal().range(["red", "blue"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 290)
        .attr("height", 250);
    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "blue");
    var text = canvas.append('text').text('Total Female (' + tf.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black')
    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('Total Male (' + tm.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black')

    var data = [ilm, ilf];
    var r = 70;
    var color = d3.scale.ordinal().range(["blue", "red"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 290)
        .attr("height", 250);
    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "Blue");
    var text = canvas.append('text').text('Illiterate Females (' + ilf.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black')
    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('Illiterate Males (' + ilm.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black')

    var data = [lm, lf];
    var r = 70;
    var color = d3.scale.ordinal().range(["red", "blue"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 250)
        .attr("height", 250);
    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "blue");
    var text = canvas.append('text').text('literate Females (' + lf.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black');

    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('literate Males (' + lm.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black');
    document.write("</div>");
}
function nePopulation(tm, tf, ilm, ilf, lm, lf) {
    document.write("<div>");
    var data = [tm, tf];
    var r = 70;
    var color = d3.scale.ordinal().range(["blue", "red"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 290)
        .attr("height", 250);
    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "blue");
    var text = canvas.append('text').text('Total Female (' + tf.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black')
    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('Total Male (' + tm.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black')


    var data = [ilm, ilf];
    var r = 70;
    var color = d3.scale.ordinal().range(["red", "blue"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 290)
        .attr("height", 250);
    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "Blue");
    var text = canvas.append('text').text('Illiterate Females (' + ilf.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black')
    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('Illiterate Males (' + ilm.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black')

    var data = [lm, lf];
    var r = 70;
    var color = d3.scale.ordinal().range(["red", "blue"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 250)
        .attr("height", 250);
    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "blue");
    var text = canvas.append('text').text('literate Females (' + lf.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black');

    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('literate Males (' + lm.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black');
    document.write("</div>");
}
function stateRatio(data) {
    var optn = [];
    for (var json in data) {
        var a = data[json];
        optn[json] = a["Area Name"];
    }
    option(optn);
}
function option(optn) {
    document.write("<div>");
    document.write("<select onchange='onSelet(this)'>");
    for (var i in optn) {
        document.write("<option value='" + optn[i] + "' >" + optn[i] + "</option>");
    }
    document.write("</select>");
    document.write("</div>");
}
function onSelet(Area) {
    $.getJSON("json/India2011.json", function (data) {
        D3JSON(data, Area);
    });
}
function D3JSON(data, Area) {
    for (var a in data) {
        var json = data[a];
        if (json["Area Name"] == Area.value) {
            var ip = json["Illiterate - Persons"];
            var lp = json["Literate - Persons"];
            D3(ip, lp, Area.value);
        }
    }

}
function D3(ip, lp, Area) {

    var data = [ip, lp];
    var r = 70;
    var color = d3.scale.ordinal().range(["red", "blue"]);
    var canvas = d3.select("body").append("svg")
        .attr("width", 290)
        .attr("height", 280);


    var group = canvas.append("g")
        .attr("transform", "translate(100,100)");
    var arc = d3.svg.arc()
        .outerRadius(r);
    var pie = d3.layout.pie()
        .value(function (d) {
            return d;
        });
    var arcs = group.selectAll(".arc")
        .data(pie(data))
        .enter()
        .append("g")
        .attr("class", "arc");
    arcs.append("path")
        .attr("d", arc)
        .attr("fill", function (d) {
            return color(d.data);
        });
    var rect1 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 200)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "blue");

    var text = canvas.append('text').text('Total Literate (' + lp.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 215)
        .attr('fill', 'black')
    var rect2 = canvas.append("rect")
        .attr("x", 40)
        .attr("y", 230)
        .attr("width", 20)
        .attr("height", 20)
        .attr("fill", "red");
    var text2 = canvas.append('text').text('Total Illiterate (' + ip.toLocaleString() + ')')
        .attr('x', 80)
        .attr('y', 244)
        .attr('fill', 'black')
    var text = canvas.append('text').text(Area)
        .attr('x', 50)
        .attr('y', 20)
        .attr('fill', 'black')
}

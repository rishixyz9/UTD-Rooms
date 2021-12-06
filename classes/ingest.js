/*
    UTD Rooms
    Raghav Pillai
    raghavpillai101@gmail.com
*/

// Ingesting class data json files and starting classification process

const fs = require('fs');
const path = require('path');

require("./items.js")();

function ingest() {
    let ingested = 0;
    const jsonsInDir = fs.readdirSync('./ClassData').filter(file => path.extname(file) === '.json');
    jsonsInDir.forEach(file => {
        const fileData = fs.readFileSync(path.join('./ClassData', file));
        const json = JSON.parse(fileData.toString());
        //console.log(json);
        json.forEach(obj => {
            let prefix = obj.course_prefix;
            let course_number = obj.course_number;
            let section = obj.section;
            //console.log(prefix + "-" + course_number + "-" + section);

            let raw_location = obj.location;
            let raw_time = obj.times;
            let raw_days = obj.days;
        
            // building parts
            let building = raw_location.substring(0, raw_location.indexOf(" "));
            let room = raw_location.substring(raw_location.indexOf(" ")+1, raw_location.length);
            let floor = room.substring(0,1);
            //console.log(building + "-" + room + "-" + floor);
        
            // time parts
            raw_days = raw_days.replace(/ /g,'');
            raw_days = raw_days.replace(/&/g, ',');
            let days = raw_days.split(",");
            //console.log(days);


            raw_time = raw_time.replace(/ /g,'');
            let startTime = raw_time.substring(0, raw_time.indexOf("-"));
            let endTime = raw_time.substring(raw_time.indexOf("-")+1,raw_time.length);
            //console.log(startTime + "-" + endTime);
            let currClass = new Class(prefix, course_number, section, building, floor, room, days, startTime, endTime);
            masteraddClass(currClass);
        });
    });
}

module.exports = function() {
    this.ingest = ingest;
}
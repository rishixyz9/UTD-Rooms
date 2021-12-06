/*
    UTD Rooms
    Raghav Pillai
    raghavpillai101@gmail.com
*/

// Searching functions based on indexed rooms

require("./items.js")();

function checkIfDay(days, findDay) {
    for (let day of days) {
        if(day == findDay) {
            return false
        }
    }
    return true;
}

function checkClassTime(day, stringStart, stringEnd, ourClass) {
    let start = stringStart.replace(':','');
    let end = stringEnd.replace(':','');

    let class_start = ourClass.time_start.replace(':','');
    let class_end = ourClass.time_end.replace(':','');
    
    if(checkIfDay(ourClass.days, day)) {
        return true;
    } else if( start > class_start && end < class_end ) {
        return true;
    }

    return false;
}

function getFloor(building, floor) {
    let foundBuilding = findBuild(building);
    let foundFloor = foundBuilding.findFloor(floor);
    return foundFloor;
}

function formatDate (time) {
    // Check correct time format and split into components
    time = time.toString ().match (/^([01]\d|2[0-3])(:)([0-5]\d)(:[0-5]\d)?$/) || [time];
  
    if (time.length > 1) { // If time format correct
        time = time.slice (1);  // Remove full string match value
        time[5] = +time[0] < 12 ? 'AM' : 'PM'; // Set AM/PM
        time[0] = +time[0] % 12 || 12; // Adjust hours
    }
    return time.join (''); // return adjusted time or original string
}

function returnClassUse(ourClass) {
    let abbDays = "";
    for(let day of ourClass.days) {
        abbDays = abbDays + day.substring(0,3) + " ";
    }
    let string = ourClass.building + " " + ourClass.room + "(In use between " + formatDate(ourClass.time_start) + " and " + formatDate(ourClass.time_end) + " on " + abbDays;
    return string;
}


module.exports = function() {
    this.search = function(day, building, floor, startTime, endTime) {
        let foundBuilding = findBuild(building);
        let foundFloor = getFloor(building, floor);
    
        let resultClass = [];
        let thrownClass = [];
        
        foundFloor.classes.forEach(function (item, index) {
            if (checkClassTime(day, startTime, endTime, item) == true) {
                resultClass.push(item);
            } else {
                thrownClass.push(item);
            }
        });
    
        console.log("Found " + resultClass.length + " classes:");
        for(let ourClass of resultClass) {
            console.log(returnClassUse(ourClass))
        }
        console.log("----------");
    
        console.log("Threw " + thrownClass.length + " classes:");
        for(let ourClass of thrownClass) {
            console.log(returnClassUse(ourClass))
        }
        console.log("----------");
    }
}

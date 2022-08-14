/*
    UTD Rooms
    Raghav Pillai
    raghavpillai101@gmail.com
*/

// Master control of indexing and searching processes

require("./modules/exports.js")(); // Require all exported functions

ingest(); // Start ingest

// Debugging
checkBuildings();

// Test inputs
let day = "Friday";
let building = "ECSW";
let floor = "1";
let time_start = "14:30";
let time_end = "16:00";

// Build inputs
//let day, building, floor, time_start, time_end = input();

// Search based on inputs
//search(day, building, floor, time_start, time_end);
/*
    UTD Rooms
    Raghav Pillai
    raghavpillai101@gmail.com
*/

// Master control of indexing and searching processes

require("./classes/exports.js")(); // Require all exported functions

ingest(); // Start ingest

// Debugging
//checkBuildings();
//console.log(buildings[0].floors[0].classes);

// Input

// Test inputs
let day = "Tuesday";
let building = "SCI";
let floor = "1";
let time_start = "12:00";
let time_end = "12:30";

// Build inputs
//let day, building, floor, time_start, time_end = input();

// Search based on inputs
search(day, building, floor, time_start, time_end);
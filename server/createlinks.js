let day = "Monday";
let building = "ECSW";
let floor = "2";
let time_start = "14:30";
let time_end = "16:00";

let table = {day, building, floor, time_start, time_end}

console.log(`http://localhost:3000/?day=${day}&building=${building}&floor=${floor}&time_start=${time_start}&time_end=${time_end}`)

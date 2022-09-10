/*
    UTD Rooms
    Raghav Pillai
    raghavpillai101@gmail.com
*/

// Master control of indexing and searching processes

const express = require('express')
const bodyParser = require('body-parser')
const app = express()
app.use(bodyParser.json());
const port = 3000

require("./modules/exports.js")(); // Require all exported functions

ingest(); // Start ingest

// Debugging
//checkBuildings();

app.get('/', (req, res) => {
    let day = req.query.day;
    let building = req.query.building;
    let floor = req.query.floor;
    let time_start = req.query.time_start;
    let time_end = req.query.time_end;

    console.log(day, building, floor, time_start, time_end);      // your JSON    // echo the result back
    return res.json(
        search(day, building, floor, time_start, time_end)
    );
});

app.listen(port, () => {
    console.log(`Example app listening on localhost:${port}`)
})
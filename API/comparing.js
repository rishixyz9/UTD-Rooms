const fs = require('fs');
const path = require('path');

let ingested = 0;
const jsonsInDir = fs.readdirSync('./ClassData/22_Spring').filter(file => path.extname(file) === '.json');
jsonsInDir.forEach(file => {
    const fileData = fs.readFileSync(path.join('./ClassData/22_Spring', file));
    const json = JSON.parse(fileData.toString());
    json.report_data.forEach(obj => {
        ingested++
    });
});
console.log("Ingested a total of " + ingested + " classes")

ingested = 0;
const fileData = fs.readFileSync('./ClassData/spring22.json');
const json = JSON.parse(fileData.toString());
json.report_data.forEach(obj => {
    ingested++
});
console.log("Ingested a total of " + ingested + " classes")
const obj = {
    '1.130': {
        Friday: ['13:00 - 14:40', '15:00 - 16:40'],
        Thursday: ['10:00 - 11:40'],
        Tuesday: ['13:00 - 14:40', '10:00 - 11:40'],
        Wednesday: ['13:00 - 14:40'],
    }
}

for( const key in obj){
    for(const day in obj[key]){
        console.log(obj[key][day])
    }
}

console.log(obj)
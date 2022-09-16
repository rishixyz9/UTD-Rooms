import json
import os, glob
from collections import defaultdict

buildings = defaultdict(lambda: defaultdict(lambda: {}))

for file in glob.glob('./22_Spring/*.json'):
    f = open(file, mode='r')
    data = json.load(f)

    for i in data['report_data']:
        location = i['location'].split(' ') #location 0 represents the building location 1 represents the room


        if(location[0] != 'ONLINE' and location[0]): #does not add online classes
            for day in i['days'].replace(',', '').replace('& ', '').split(' '):
                if(day and 'tbd' not in i['times']):    #does not add classes whose times are unknown
                    try:
                        buildings[location[0]][location[1]][day].append(i['times'])
                    except:
                        time = defaultdict(lambda: [])
                        time[day].append(i['times'])
                        buildings[location[0]][location[1]] = time
                buildings[location[0]][location[1]][day].sort()
                

json_data = json.dumps(buildings, indent=2)

f = open('output.json', 'w')

f.write(json_data)
/*
    UTD Rooms
    Raghav Pillai
    raghavpillai101@gmail.com
*/

// Objects for storage and exported classmaster functions

let Class = class {
    constructor(prefix, course_number, section, building, floor, room, days, time_start, time_end) {
        this.prefix = prefix;
        this.course_number = course_number;
        this.section = section;

        this.building = building;
        this.floor = floor;
        this.room = room;

        this.days = days;
        this.time_start = time_start;
        this.time_end = time_end;
    }    
};

let Floor = class {
    constructor(name) {
        this.name = name;
        this.classes = [];
    }

    checkChildren() {
        console.log("Showing classes on floor " + this.name);
        this.classes.forEach(function (item, index) {
            console.log("Class " + item.prefix + "." + item.course_number + "." + item.section 
            + " (" + item.building + " " + item.room + ")");
        });
        console.log("----------");
    }
    addClass(toAdd) {
        this.classes.push(toAdd);
        //console.log("Assigned class to " + this.name);
    }
}

let Building = class {
    constructor(name) {
        this.name = name;
        this.floors = [];
    }
    seeIfFloorExists(findFloor) {
        for (let floor of this.floors) {
            if(floor.name == findFloor) {
                return true;
            }
        }
        return false;
    }
    findFloor(floorNumber) {
        for (let floor of this.floors) {
            if(floor.name == floorNumber) {
                return floor;
            }
        }
        return false;
    }
    checkChildren() {
        console.log("Showing results for building " + this.name);
        this.floors.forEach(function (item, index) {
            item.checkChildren();
        });
        console.log("----------");
    }

    sortChildren() {
        // sort floors
        this.floor.forEach(function (item, index) {
            // sort
        });
    }
    

    addClass(toAdd) {
        if(this.seeIfFloorExists(toAdd.floor) == false) {
            let newFloor = new Floor(toAdd.floor);
            this.floors.push(newFloor);
            newFloor.addClass(toAdd);
        } else {
            let newFloor = this.findFloor(toAdd.floor);
            newFloor.addClass(toAdd);
        }
        //this.floors.push(newObject);
    };

}

buildings = [];

module.exports = function() {
    this.buildings = buildings;
    this.Class = Class;
    this.Floor = Floor;
    this.Building = Building;

    this.seeIfBuildingExists = function(buildName) {
        for (let building of this.buildings) {
            if(building.name == buildName) {
                return true;
            }
        }
        
        return false;;
    }
    
    this.findBuild = function(buildName) {
        for (let building of this.buildings) {
            if(building.name == buildName) {
                return building;
            }
        }
        console.log("NONE FOUND " + buildName);
        return false;
    }
    
    this.checkBuildings = function() {
        console.log("Checking child tree [CLASS MASTER]")
        console.log("----------");
        this.buildings.forEach(function (item, index) {
            item.checkChildren();
        });
        console.log("----------");
    }
    
    this.masteraddClass = function(toAdd) {
        if (seeIfBuildingExists(toAdd.building) == false) {
            let newBuilding = new Building(toAdd.building);
            this.buildings.push(newBuilding);
            newBuilding.addClass(toAdd);
            
        } else {
            let ourBuilding = findBuild(toAdd.building);
            ourBuilding.addClass(toAdd);
        }
    }
    
    this.sortBuildings = function() {
        this.buildings.forEach(function (item, index) {
            item.sortChildren();
        });
    }
}


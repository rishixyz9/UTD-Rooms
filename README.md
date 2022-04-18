# UTD Rooms

UTD Rooms is a web-app designed for students at the University of Texas at Dallas to be able to find unused classrooms within the campus.
<br></br>
<img src="https://upload.wikimedia.org/wikipedia/commons/7/7c/UT_Dallas_2_Color_Emblem_-_SVG_Brand_Identity_File.svg" width=300>

## Why make UTD Rooms?
With my Fall 2021 semester, I had a pretty horrible schedule with long breaks between classes, but not quite long enough to walk back home. I'd find myself trying to look for free rooms around the engineering buildings without having much luck in finding rooms, and even more embarrassingly peek into rooms without windows, and look into a room full of faces staring at me. During the period of studying for midterms, I decided instead of studying in the library like a normal person, I built a prototype for UTD Rooms for the ECS buildings to find a room. I used this CLI based application for most of the semester, and I decided it was useful enough for me to port over to a real web app. 

## Building UTD Rooms
I initially built UTD Rooms to use Python and BeautifulSoup to scrape the UTD coursebook (like the original version used to do), but this ended up fruitless with the coursebook update that prevented me from getting data from the various course options. I ended up creating a quick script to download the json versions of each different course option (which still took ages due to how slow the site is when going through options).

At the start when using Python, then Java, I had the data from the various sourced JSON files process seperately into a new JSON file with only relevant info, but continually sourcing the JSON file and closing it proved slower for a large amount of demands. Instead of using storage, the later versions started classifying all the classes into classes on memory. 

Since our data is already classified, we can search for the right classes easily. Searches are done by searching through the building and then floors, which are already created on our heap. We can use this classified data to easily find what classes fit in our criteria. 

## Stack
The current stack uses Node.js and Express for the web server

Credit to Mithil Viradia for the original version a couple years ago, idea and name.  

# Bee_Inspection
My parents are bee keepers as a hobby. They wanted to start recording the state of the hives whenever they inspect the hive. I would like to create a web application that they can quickly and easily record the data using their phone. The purpose of recording the inspections is to try to find patterns and possibly use the data from last year to predict what will happen this year. 

## V 0.1
-I have created a mock-up of what the web interface might look like. I have added some Javascript to simulate how the buttons will react when pressed, but doesn't do anything besides change color currently.
<br>-My next step is to decide how the data will be stored / exported. I might try to store it all in a database and create a interface to view the inspections or maybe just have the application export the data to a csv that can be imported into a spreadsheet.

## V 0.2
-I have created Java classes for the inspection, boxes and frames with methods to set and get all parts of the inspection.
<br>-Currently the program does not store the data in any way, just takes in data then prints it out nicely formatted.
<br>-The next thing I'm working on is probably writing the data to a file.

## V 0.2.1
-I have started working on creating the Dao. the current code uploaded does not connect to the local database I set up, still trying to get this code to work.

## V 0.2.2
-I have successfully connected to the the database with my Dao code. I was missing a postgresql dependency. Some of the dao methods work, but almost every option in the CLI app crashes at some point because of a springframework exception. Currently working on fixing these bugs.

## V 0.3
-All dao methods currently implemented run properly. The CLI version of the app is now functional.
<br>-The CLI lets the user start a new inspection and add it to a local database, add notes to any of the inspections and update the database, or view all of the past inspections stored in the database.
<br>-I think my next step is to connect CLI to the database on my website instead of a local database. 

## V 0.3
-I have started to build an API that runs locally that can use my DAOs to talk to the local database. I believe I have all of the end points coded.
<br>-I have created a client app to test the API, and I am running into trouble with local date/time to and from the server. I think I am storing the date/time differently in the database than I am withing the java app.
<br>-I need to figure out how to the process of starting a new inspection by creating a frame before inspection, but I need to get the inspection ID first.
<br>-I still need to code the front end.
<br>-I think at this point I am going to get the entire app working locally before trying to run it on my website.

## V 0.3.1
-I believe I have created all of the API endpoints that I will need for the app. The current version is still all local, but I have a working API that can interact with a database and provide all of the functions the final app will have in a CLI
-Next steps are to look into using the DOM and event handling to create the pages, and attempt to move the app to my website's server.

## V 0.3.2
-The app now calls the current weather temperature and weather condition for my parents house from the Accuweather API. 



package chicagoMetroMac;

//make notes  imports

//make notes  imports

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.lang.reflect.Array;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//class

public class CTAMain {

//main

public static void main(String[] args) throws IOException {


//scanner and file for csv

Scanner s = new Scanner(System.in);

File file = new File("CTAStops (7).csv");

Scanner f = new Scanner(file);
;

//arraylist of stations, and ctaRoutes (new)

ArrayList<CTAStation> stops = new ArrayList<CTAStation>();
ArrayList<CTARoute> routes = new ArrayList<CTARoute>();



CTARoute red = new CTARoute();
red.setName("red");

CTARoute green = new CTARoute();
green.setName("green");

CTARoute all = new CTARoute();
all.setName("all");

CTARoute blue = new CTARoute();
blue.setName("blue");

CTARoute brown = new CTARoute();
brown.setName("brown");

CTARoute purple = new CTARoute();
purple.setName("purple");

CTARoute pink = new CTARoute();
pink.setName("pink");

CTARoute orange = new CTARoute();
orange.setName("orange");

CTARoute yellow = new CTARoute();
yellow.setName("yellow");

CTARoute transfer = new CTARoute();
transfer.setName("transfer");

routes.add(red);
routes.add(green);
routes.add(blue);
routes.add(yellow);
routes.add(brown);
routes.add(purple);
routes.add(orange);
routes.add(pink);

f.nextLine();

int i = 0;

f.nextLine();

CTAStation chicago = new CTAStation();
//loop to store
while(f.hasNextLine()) {

//store data into array, store each column into CTA station
//f.nextLine();
//String empty = f.nextLine();	
String[] data = f.nextLine().split(",");
	
chicago = new CTAStation();

chicago.setName(data[0]);

chicago.setLatitude(Double.parseDouble(data[1]));

chicago.setLongitude(Double.parseDouble(data[2]));

chicago.setLocation((data[3]));

chicago.setWheelchair(Boolean.parseBoolean(data[4]));

//chicago.setLineColorRed(Integer.parseInt(data[5]));
//
//chicago.setLineColorGreen(Integer.parseInt(data[6]));
//
//chicago.setLineColorBlue(Integer.parseInt(data[7]));
//
//chicago.setLineColorBrown(Integer.parseInt(data[8]));
//
//chicago.setLineColorPurple(Integer.parseInt(data[9]));
//
//chicago.setLineColorPink(Integer.parseInt(data[10]));
//
//chicago.setLineColorOrange(Integer.parseInt(data[11]));
//
//chicago.setLineColorYellow(Integer.parseInt(data[12]));

int[] linePositions = new int[8];
for(int y =0; y < linePositions.length; y++) {
	linePositions[y] = Integer.parseInt(data[y+5]);

}
chicago.setRoutes(routes, linePositions);

//chicago.setTransfer(Integer.parseInt(data[5]));

stops.add(chicago);

//store in ctaRoute
//if(chicago.getLineColorGreen()>=0) {
//	green.addStation(chicago);
//}
//if(chicago.getLineColorRed()>=0) {
//	red.addStation(chicago);
//	//transfer.addStation(chicago);
//
//}
//if(chicago.getLineColorBlue()>=0) {
//	blue.addStation(chicago);
//
//}
//if(chicago.getLineColorBrown()>=0) {
//	brown.addStation(chicago);
//
//}
//if(chicago.getLineColorPurple()>=0) {
//	purple.addStation(chicago);
//
//}
//if(chicago.getLineColorPink()>=0) {
//	pink.addStation(chicago);
//
//}
//if(chicago.getLineColorOrange()>=0) {
//	orange.addStation(chicago);
//
//}
//if(chicago.getLineColorYellow()>=0) {
//	yellow.addStation(chicago);
//
//}
//if(chicago.getisTransfer()>0) {
//	transfer.addStation(chicago);
//}

//list of all stations
all.addStation(chicago);

for(int z = 0; z <routes.size(); z++) {
	if(Integer.parseInt(data[z+5])>=0){
	 routes.get(z).addStation(chicago);
}
}

i++;

}
//do loop for user input 

System.out.println(routes);

	


int x;

do{

System.out.println("Please make a selection (enter just number)");

System.out.println("1. Display Station Names");

System.out.println("2. Show Stations with Wheelchair Access");

System.out.println("3. Display nearest station to a location:");

System.out.println("4. Display info for specific station:");

System.out.println("5. Display info for all stations:");

System.out.println("6. Add a new station:");

System.out.println("7. Delete an existing station:");

System.out.println("8. Exit");

//System.out.println(transfer);


x = s.nextInt();

//switch cases


switch(x) {
//Display the names of all stations
//Display the stations with wheelchair access
//Display the nearest station to a location
//Display information for a station with a specific name
//Display information for all stations
//Add a new station
//Delete an existing station
//Exit
case 1: 
		for(int g=0;g< all.getStops().size(); g++) {
			System.out.println(all.getStops().get(g).getName());
		for(int h=0;h<green.getStops().size();h++) {
			System.out.println(green.getStops().get(h).getName().toString());
			
		}
		
		}
	
		
break;
case 2: 


	for(int g=0;g< all.getStops().size(); g++) {
		if(all.getStops().get(g).isWheelchair()) {
	
		System.out.println(all.getStops().get(g).getName().toString());	
	}
	}
String yesOrNo;  //unused, was from lab 5



s.nextLine();

break;

case 3:

GeoLocation user = new GeoLocation();

System.out.println("Enter Latitude");

user.setLatitude(s.nextDouble());

System.out.println("Enter Longitude");

user.setLongitude(s.nextDouble());

System.out.println("How far do you want to travel?"); 

double maxDistance = s.nextDouble();
for(int m = 0; m < stops.size(); m ++ ) {

if(user.calcDistance(stops.get(m)) <= maxDistance) {

System.out.println(stops.get(m).getName().toString());
}

}

s.nextLine();

break;

case 4: //individual station
System.out.println("For which station do you need information? (please type station name only)");
s.nextLine();
String stationName = s.nextLine();
if(all.lookupStation(stationName)==null) {
	System.out.println("Not found");
}else {
System.out.println(all.lookupStation(stationName).toString());
}
break;

case 5:  //all information

System.out.print(all.toString());

break;

case 6: //to add a station.  adds to end of list, won't insert currently
s.nextLine();
CTAStation c = new CTAStation();

System.out.println("What is the station name?");

c.setName(s.nextLine().trim());

//s.nextLine();

System.out.println("What is the line Color?");

String lineColor = s.nextLine().trim();

System.out.println("What stop number on " + lineColor + "?");
//c.setStopNumber(Integer.parseInt(s.next()));
//if(lineColor.equalsIgnoreCase("Red")) {
//
//c.setLineColorRed(Integer.parseInt(s.nextLine()));
////s.nextLine();
//c.setStopNumber(c.getLineColorRed());
//}else if(lineColor.equalsIgnoreCase("Green")) {
//
//c.setLineColorGreen(Integer.parseInt(s.nextLine()));
////s.nextLine();
//c.setStopNumber(c.getLineColorGreen());
//}

//s.nextLine();

System.out.println("What is the latitude?");

c.setLatitude(Double.parseDouble(s.nextLine()));


System.out.println("What is the longitude?");

c.setLongitude(Double.parseDouble(s.nextLine()));


System.out.println("Is there wheelchair access? Enter y or n:");

if(s.nextLine().equals("y")) {

c.setWheelchair(true);

}

else {

c.setWheelchair(false);

}

//s.nextLine();
System.out.println("What station is this after?");

String after = s.nextLine();

System.out.println("What station is this before?");

String before = s.nextLine();
System.out.println(c);
all.addStation(c);
if(lineColor=="Red") {
	red.addStation(c);
}else {
	green.addStation(c);
}
if(all.getStops().contains(c)) {
System.out.println("You successfully added " + c.getName());
}else {
	System.out.println("Uh-oh, something didn't work.");
}
System.out.println(all.toString());

break;


case 7: // remove a station
	

	
	CTAStation cc = new CTAStation();
	//create a station to be be removed from list.
System.out.println("What is the station name?");
s.nextLine();
String stationToBeRemoved = s.nextLine().trim();

//all.removeStationByName(stationToBeRemoved);
//CTAStation removeMe = all.lookupStation(stationToBeRemoved);
//all.removeStation(removeMe);

if(all.getName().equalsIgnoreCase(stationToBeRemoved)) {
	all.removeStation(cc);
}
System.out.println("What line does the station appear on?");
String lineStationToBeRemoved = s.nextLine().trim();
cc.setName(stationToBeRemoved);
if(all.getName().equalsIgnoreCase(stationToBeRemoved)) {
	System.out.println(stationToBeRemoved);
	all.removeStation(cc);
}

for(int j=0; j< stops.size(); j ++) {

if(stops.get(j).getName().equalsIgnoreCase(stationToBeRemoved.trim())) {

stops.remove(j);
System.out.println("You have successfully removed " + stationToBeRemoved + " from " + lineStationToBeRemoved);
}else {

break;

}

}
//just exit no options
case 8:

break;



}


//end of do while
}while(!(x==8));
//close scanner files
f.close();

s.close();


}




}


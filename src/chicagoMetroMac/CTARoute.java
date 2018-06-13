package chicagoMetroMac;

//fetzer, final Project
//imports	
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

//Route class
public class CTARoute {

	//final arrayList was trial

	private static final ArrayList ArrayList = null;
	// instance variables
	private String name;
	private ArrayList<CTAStation> stops;

	// default
	public CTARoute() {

		name = "";

		stops = new ArrayList<CTAStation>();

	}

	// non default
	public CTARoute(String name, ArrayList<CTAStation> stops) {

		this.name = name;

		this.stops = stops;

	}

	// getters
	public String getName() {

		return name;

	}

	// setters
	public void setName(String name) {

		this.name = name;

	}
	//get stops
	public ArrayList<CTAStation> getStops() {

		return stops;

	}
//set stops to arrayList
	public void setStops(ArrayList<CTAStation> stops) {

		this.stops = stops;

	}

	// addStation method
	public void addStation(CTAStation c) {

		stops.add(c);
	}

	// remove stations
	public void removeStation(CTAStation c) {
		for (int i = 0; i < stops.size(); i++) {
			if (stops.get(i).getName().equals(c.getName())) {
				stops.remove(c);
			}
		}
	}
	//method to remove by name, able to throw error
	public boolean removeStationByName(String name) {
		CTAStation stationToRemove = lookupStation(name);
		if (stationToRemove == null) {
			return false;
		}
		removeStation(stationToRemove);
		return true;
	}

	// toString
	public String toString() {
		String returnable = new String();
		returnable = "CTARoute [name=" + name + ", stops="
				+ System.lineSeparator();
		// return "CTARoute [name=" + name + ", stops=" + stops + "] \n";
		for (int h = 0; h < stops.size(); h++) {
			returnable += "\t" + stops.get(h).toString()
					+ System.lineSeparator();

		}

		returnable += "]";
		return returnable;
	}
	//The separate toString was to try and add just route color in some displays, unused
	public String toStringY(boolean y) {
		String returnStatement = new String();
		returnStatement = "CTARouteColor " + name;
		return returnStatement;
	}

	// needed to insert station into position. 
	public void insertStation(CTAStation c, Double CTAStation) {

		for (int i = 0; i < stops.size(); i++) {
			stops.get(i).equals(CTAStation);
			stops.add(c);

		}
	}

	// lookup station information, null return
	public CTAStation lookupStation(String name) {

		for (int i = 0; i < stops.size(); i++) {
			if (stops.get(i).getName().equals(name)) {
				return stops.get(i);

			}
		}
		return null;

	}
//boolean to check if route contains station
	public boolean containsStation(String name){
		if (this.lookupStation(name) != null){
			return true;
		}
		return false;
	}
	
	
	// nearest station to geoLocation
	public CTAStation nearestStation(double x, double y) {

		return nearestStation(x, y);

	}

	// geolocation
	public CTAStation nearestStation(GeoLocation g) {

		return nearestStation(g.getLatitude(), g.getLongitude());

	}

	// equals method
	public boolean equals(CTARoute c) {

		if (name != c.getName()) {

			return false;

		} else if (stops != c.getStops()) {

			return false;

		} else {

			return true;

		}

	}

	public ArrayList<?> getPath(CTAStation start, CTAStation end) {
		Set<CTARoute> startRoutes = start.getRoutes();
		Set<CTARoute> endRoutes = end.getRoutes();
		ArrayList<String> stationStart = new ArrayList<>();;
		ArrayList<CTAStation> directions = new ArrayList<>();

		Set<CTARoute> sharedRoutes = new HashSet<>(startRoutes);
		sharedRoutes.retainAll(endRoutes);

		System.out.println("Start Routes (" + start.getName() + "):");
		for (CTARoute route : startRoutes) {
			System.out.println(route.getName());
			//System.out.println(route.getStops());
			stationStart.add(start.getName());
			//JOptionPane.showMessageDialog(null, route.getName());
			//System.out.println(route.getStops());
			//directions.addAll(route.stops);

		}
		//System.out.println(stationStart);
		System.out.println("End Routes (" + end.getName() + "):");
		for (CTARoute route : endRoutes) {
			System.out.println(route.getName());
			// System.out.println(route.getStops());
		}

		System.out.println("Shared Routes:");
		for (CTARoute route : sharedRoutes) {
			
			System.out.println(route.getName());
			//directions.addAll(route.stops);
		}//transfer logic
		
		//shared routes is Empty, find transfer
		if(sharedRoutes.isEmpty()) {
			ArrayList<CTAStation> transferStations = new ArrayList<>();
			ArrayList<ArrayList> bigRoutes = new ArrayList<>();
			for(CTARoute route: startRoutes) {
				
				for(CTAStation station: route.getStops()) {
					for(CTARoute enders: endRoutes) {
						for(CTARoute intersection: station.getRoutes()) {
							//System.out.println("hello");
							if(intersection==enders) {
								transferStations.add(station);
								
								System.out.println(station.getName());
							}
						}
					}
				}
			}
			for(CTAStation station: transferStations) {
				ArrayList<CTAStation> transferDirs = new ArrayList<>();
				for(CTARoute route: startRoutes){
					if(route.containsStation(station.getName())){
						ArrayList<CTAStation> stations = route.getStops();
						if(stations.indexOf(start)<stations.indexOf(station)) {
							for (int i = stations.indexOf(start); i <= stations.indexOf(station); i++) {
								transferDirs.add(stations.get(i));
							}
							}else if(stations.indexOf(start)>stations.indexOf(station)) {
								for(int i = stations.indexOf(start); i>=stations.indexOf(station); i--) {
									transferDirs.add(stations.get(i));
								}
							}
					}
				}
				
				for(CTARoute route: endRoutes){
					if(route.containsStation(station.getName())){
						ArrayList<CTAStation> stations = route.getStops();
						if(stations.indexOf(station)<stations.indexOf(end)) {
							for (int i = stations.indexOf(station)+1; i <= stations.indexOf(end); i++) {
								transferDirs.add(stations.get(i));
							}
							}else if(stations.indexOf(station)>stations.indexOf(end)) {
								for(int i = stations.indexOf(station)+1; i>=stations.indexOf(end); i--) {
									transferDirs.add(stations.get(i));
								}
							}
					}
				}
				
				bigRoutes.add(transferDirs);
			}
			int index_lowest = 0;
			int num_stations = 138;
			for(int j =0; j<bigRoutes.size();j++){
				if (bigRoutes.get(j).size()<num_stations){
					num_stations = bigRoutes.get(j).size();
					index_lowest = j;
				}
			}
			return bigRoutes.get(index_lowest);
			
		}
		for (CTARoute route : sharedRoutes) {

			//System.out.println(route.getStops().toString());
			// directions.addAll(route.getStops());
			ArrayList<CTAStation> stations = route.getStops();
			if(stations.indexOf(start)<stations.indexOf(end)) {
			for (int i = stations.indexOf(start); i <= stations.indexOf(end); i++) {

				directions.add(stations.get(i));
			}
			}else if(stations.indexOf(start)>stations.indexOf(end)) {
				for(int i = stations.indexOf(end); i<=stations.indexOf(start); i ++) {
					directions.add(stations.get(i));
				}
				
			}else if(route==null) {
				//transfer here, unused else if statement
			}

			//System.out.println(directions);
		}
			
		return directions;
	}
	
	/** left initial attempts as may be needed for other write to CSV options**/
	// public java.util.ArrayList<CTARoute> getPathForFile(CTAStation start,
	// CTAStation end) {
	// Set<CTARoute> startRoutes = start.getRoutes();
	// Set<CTARoute> endRoutes = end.getRoutes();
	// ArrayList<CTARoute> directions = new ArrayList<>();
	// ArrayList<CTARoute> starters = new ArrayList<>();
	// ArrayList<CTARoute> enders = new ArrayList<>();
	// ArrayList<CTARoute> allRoutes = new ArrayList<>();
	//
	// Set<CTARoute> sharedRoutes = new HashSet<>(startRoutes);
	// sharedRoutes.retainAll(endRoutes);
	//
	// //System.out.println("Start Routes (" + start.getName() + "):");
	// for(CTARoute route : startRoutes) {
	// starters.add(route);
	// allRoutes.add(route);
	// }
	//
	// //System.out.println("End Routes (" + end.getName() + "):");
	// for(CTARoute route : endRoutes) {
	// enders.add(route);
	// allRoutes.add(route);
	// }
	//
	// System.out.println("Shared Routes:");
	// for(CTARoute route : sharedRoutes) {
	// directions.add(route);
	// allRoutes.add(route);
	// }
	//
	// return allRoutes;
	//
	//
	// }

}

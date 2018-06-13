package chicagoMetroMac;


//fetzer, final project, 
//imports for class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//extends geolocation, inheritance req.
public class CTAStation extends GeoLocation {
	// instance variables
	private String name;
	private Map<CTARoute, Integer> routes;
//getter
	public Set<CTARoute> getRoutes() {
		return routes.keySet();
	}

	public void setRoutes(ArrayList<CTARoute> allRoutes, int[] routePositions) {
		routes = new HashMap<>();
		for (int i = 0; i < allRoutes.size(); i++) {
			if (routePositions[i] >= 0) {
				routes.put(allRoutes.get(i), routePositions[i]);
			}
		}
	}

	private String location;

	private boolean opened;

	private boolean wheelchair;

	// private int lineColorRed;
	//
	// private int lineColorGreen;
	//
	// private int lineColorBlue;
	// private int lineColorBrown;
	// private int lineColorPurple;
	// private int lineColorPink;
	// private int lineColorOrange;
	// private int lineColorYellow;
	private int isTransfer;
	private double latitude;
	private double longitude;

	public int getisTransfer() {

		return isTransfer;
	}

	// public void setTransfer(int isTranfer) {
	// if(lineColorRed >= 0 && lineColorGreen >= 0) {
	// this.isTransfer= 1;
	// }else if(lineColorRed >=0 && lineColorBlue >=0) {
	// this.isTransfer=1;
	// }else if(lineColorRed >=0 && lineColorBrown >=0) {
	// this.isTransfer=1;
	// }else if(lineColorRed >=0 && lineColorPurple >=0) {
	// this.isTransfer=1;
	// }else if(lineColorRed >=0 && lineColorPink >=0) {
	// this.isTransfer=1;
	// }else if(lineColorRed >=0 && lineColorOrange >=0) {
	// this.isTransfer=1;
	// }else if(lineColorRed >=0 && lineColorYellow >=0) {
	// this.isTransfer=1;
	// }else if(lineColorGreen >=0 && lineColorBlue >=0) {
	// this.isTransfer=1;
	// }else if(lineColorGreen >=0 && lineColorBrown >=0) {
	// this.isTransfer=1;
	// }else if(lineColorGreen >=0 && lineColorPurple >=0) {
	// this.isTransfer=1;
	// }else if(lineColorGreen >=0 && lineColorPink >=0) {
	// this.isTransfer=1;
	// }else if(lineColorGreen >=0 && lineColorOrange >=0) {
	// this.isTransfer=1;
	// }else if(lineColorGreen >=0 && lineColorYellow >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBlue >=0 && lineColorBrown >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBlue >=0 && lineColorPurple >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBlue >=0 && lineColorPink >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBlue >=0 && lineColorOrange >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBlue >=0 && lineColorYellow >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBrown >=0 && lineColorPurple >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBrown >=0 && lineColorPink >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBrown >=0 && lineColorOrange >=0) {
	// this.isTransfer=1;
	// }else if(lineColorBrown >=0 && lineColorYellow >=0) {
	// this.isTransfer=1;
	// }else if(lineColorPurple >=0 && lineColorPink >=0) {
	// this.isTransfer=1;
	// }else if(lineColorPurple >=0 && lineColorOrange >=0) {
	// this.isTransfer=1;
	// }else if(lineColorPurple >=0 && lineColorYellow >=0) {
	// this.isTransfer=1;
	// }else if(lineColorPink >=0 && lineColorOrange >=0) {
	// this.isTransfer=1;
	// }else if(lineColorPink >=0 && lineColorYellow >=0) {
	// this.isTransfer=1;
	// }else if(lineColorYellow >=0 && lineColorOrange >=0) {
	// this.isTransfer=0;
	// }else{
	// this.isTransfer = 0;
	// }
	// }

	// public int getLineColorBlue() {
	// return lineColorBlue;
	// }
	//
	// public void setLineColorBlue(int lineColorBlue) {
	// this.lineColorBlue = lineColorBlue;
	// }
	//
	// public int getLineColorBrown() {
	// return lineColorBrown;
	// }
	//
	// public void setLineColorBrown(int lineColorBrown) {
	// this.lineColorBrown = lineColorBrown;
	// }
	//
	// public int getLineColorPurple() {
	// return lineColorPurple;
	// }
	//
	// public void setLineColorPurple(int lineColorPurple) {
	// this.lineColorPurple = lineColorPurple;
	// }
	//
	// public int getLineColorPink() {
	// return lineColorPink;
	// }
	//
	// public void setLineColorPink(int lineColorPink) {
	// this.lineColorPink = lineColorPink;
	// }
	//
	// public int getLineColorOrange() {
	// return lineColorOrange;
	// }
	//
	// public void setLineColorOrange(int lineColorOrange) {
	// this.lineColorOrange = lineColorOrange;
	// }
	//
	// public int getLineColorYellow() {
	// return lineColorYellow;
	// }
	//
	// public void setLineColorYellow(int lineColorYellow) {
	// this.lineColorYellow = lineColorYellow;
	// }

	private int stopNumber;

	// default

	public CTAStation() {

		name = "";

		location = "";

		opened = true;

		wheelchair = false;

		// lineColorRed = 0;
		//
		// lineColorGreen = 0;
		// lineColorBlue =0;
		// lineColorBrown =0;
		// lineColorPurple=0;
		// lineColorPink=0;
		// lineColorOrange=0;
		// lineColorYellow=0;
		stopNumber = 0;
		isTransfer = 0;
		latitude = 0;
		longitude = 0;
		routes = new HashMap<>();

	}// non default

	public int getStopNumber() {

		return stopNumber;

	}

	@SuppressWarnings("null")

	// non default
	public CTAStation(String name, double latitude, double longitude,
			String location, boolean opened, boolean wheelchair,
			ArrayList<CTARoute> routes, int[] routePositions, int stopNumber,
			int isTransfer) {

		this.name = name;

		this.opened = opened;

		this.location = location;

		this.wheelchair = wheelchair;

		// this.lineColorRed = lineColorRed;
		//
		// this.lineColorGreen = lineColorGreen;
		//
		// this.lineColorBlue=lineColorBlue;
		// this.lineColorBrown=lineColorBrown;
		// this.lineColorPurple=lineColorPurple;
		// this.lineColorPink=lineColorPink;
		// this.lineColorOrange=lineColorOrange;
		// this.lineColorYellow=lineColorYellow;

		setRoutes(routes, routePositions);

		this.stopNumber = stopNumber;
		this.isTransfer = isTransfer;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getIsTransfer() {
		return isTransfer;
	}

	public void setIsTransfer(int isTransfer) {
		this.isTransfer = isTransfer;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	// boolean open
	public boolean isOpened() {

		return opened;

	}

	// setters and getters follow
	public void setOpened(boolean opened) {

		this.opened = opened;

	}

	// //get
	// public int getLineColorRed() {
	//
	// return lineColorRed;
	//
	// }
	//
	// public void setLineColorRed(int lineColorRed) {
	//
	// this.lineColorRed=lineColorRed;
	//
	// }
	//
	// public int getLineColorGreen() {
	//
	// return lineColorGreen;
	//
	// }
	//
	// public void setLineColorGreen(int lineColorGreen) {
	//
	// this.lineColorGreen=lineColorGreen;
	//
	// }

	// getter

	public String getName() {

		return name;

	}

	// setter

	public void setName(String name) {

		this.name = name;

	}

	// getter

	public String getLocation() {

		return location;

	}

	// setter

	public void setLocation(String location) {

		this.location = location;

	}

	// wheelchair access

	public boolean isWheelchair() {

		return wheelchair;

	}

	// setter boolean

	public void setWheelchair(boolean wheelchair) {

		this.wheelchair = wheelchair;

	}
	public boolean equals(CTAStation s) {

		if (name!= s.getName()) {
			return false;
		}else if(location!=s.getLocation()) {
				return false;
			}else if(latitude!=s.getLatitude()) {
				return false;
			}else if(longitude!=s.getLongitude()) {
				return false;
			}else if(location!=s.getLocation()) {
				return false;
			}else {
				return true;

		}
	}
	
	
	
	//toString() method
	public String toString() {
		return "CTAStation [name=" + name + ", location=" + location
				+ ", latitude " + latitude + ", longitude " + longitude
				+ ", opened=" + opened + ", wheelchair=" + wheelchair;
	}
//additional toString trial for certain displays
	public String toStringX(boolean x) {
		return routes.get(routes).toString();
	}

//	@Override see what output would come up
//	public String toString() {
//		return "CTAStation [name=" + name + ", routes=" + routes
//				+ ", location=" + location + ", opened=" + opened
//				+ ", wheelchair=" + wheelchair + ", isTransfer=" + isTransfer
//				+ ", latitude=" + latitude + ", longitude=" + longitude
//				+ ", stopNumber=" + stopNumber + "]";
//	}
}
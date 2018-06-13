package chicagoMetroMac;

public class GeoLocation {
	// follow UML instructions
	protected double latitude;
	protected double longitude;

	// defaults
	public GeoLocation() {
		latitude = 0;
		longitude = 0;

	}

	// non default with args
	public GeoLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// getter
	public double getLatitude() {
		return latitude;
	}

	// setter
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	// getter
	public double getLongitude() {
		return longitude;
	}

	// setter
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	// MAKE NOTES
	// to string for geo
	public String toString() {
		return "GeoLocation [latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

	// calc distance return
	public double calcDistance(GeoLocation g) {

		return calcDistance(g.getLatitude(), g.getLongitude());

	}// calc distance formula calculation, return double

	public double calcDistance(double lat, double longi) {

		double distance = Math.sqrt(Math.pow(latitude - lat, 2)
				+ Math.pow(longitude - longi, 2));
		return distance;

	}
	public boolean equals(GeoLocation g) {

		if (latitude != g.getLatitude()) {

			return false;

		} else if (longitude != g.getLongitude()) {

			return false;

		} else {

			return true;

		}
	}
}

package Pojo;

public class Flare {
    double longitude;
    double lat;
    int userId;

    public Flare(double longitude, double lat, int userId) {
        this.longitude = longitude;
        this.lat = lat;
        this.userId = userId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.getLat() + "," + this.getLongitude() + this.getUserId();
        return str;
    }
}

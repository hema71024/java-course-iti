
package assiment1;
class Pyramid {
    String pharaoh, modernName;
    double height_m;
    String site;
    public Pyramid(String pharaoh, String modernName, String site, double height_m) {
        super();
        this.pharaoh = pharaoh;
        this.modernName = modernName;
        this.site = site;
        this.height_m = height_m;
    }
    public String getPharaoh() {
        return pharaoh;
    }
    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }
    public String getModernName() {
        return modernName;
    }
    public void setModernName(String modernName) {
        this.modernName = modernName;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public double getHeight_m() {
        return height_m;
    }
    public void setHeight_m(double height_m) {
        this.height_m = height_m;
    }
    @Override
    public String toString() {
	return "Pyramids [modern_name=" + modernName + ", site=" + site + ", pharaoh=" + pharaoh + ", height=" + height_m
			+ "]";
}
}

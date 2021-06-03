
package lab1;

public class pyramids {

    String Pharaoh,modern_name,site;
     double height;
public pyramids( String pharaoh,String modern_name, String site, double height) {
	this.modern_name = modern_name;
	this.site = site;
	this.Pharaoh = pharaoh;
	this.height = height;
}

public String getModern_name() {
	return modern_name;
}
public void setModern_name(String modern_name) {
	this.modern_name = modern_name;
}
public String getSite() {
	return site;
}
public void setSite(String site) {
	this.site = site;
}
public String getPharaoh() {
	return Pharaoh;
}
public void setPharaoh(String pharaoh) {
	this.Pharaoh = pharaoh;
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}


    @Override
    public String toString() {
	return "Pyramids [modern_name=" + modern_name + ", site=" + site + ", pharaoh=" + Pharaoh + ", height=" + height
			+ "]";
}
    
}


public class Address
{
    private String address1;
    private String address2;
    private String  postcode;
    private String country;
    private String town;
    private String name;

    public Address(String address1,String address2,String postcode,String country,String town){
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.country = country;
        this.town = town;
        this.name = name;
        

    } 

    @Override   
    public String toString() 
    {
        return this.name + ", " + this.address1 + ", " + this.address2 + ", " +   this.postcode + ", " +   this.country + ", " +   this.town;
    }

    public String getname() {
    return name;}
    
    public String getAddress1() {
    return address1;}
    
    public String getAddress2() {
    return address2;}
    
    
    public String getpostcode() {
    return postcode;}
    
    public String getcountry() {
    return country;}
    
    public String gettown() {
    return town;}
    
    public void setAddress1(String address1) {this.address1 = address1;}

    public void setAddress2(String address2) {this.address2 = address2;}
    
    public void setpostcode(String postcode) {this.postcode = postcode;}
    
    public void setcountry(String country) {this.country = country;}
    
    public void setname(String name){this.name = name;}
    
    public void settown(String town) {this.town = town;}
}

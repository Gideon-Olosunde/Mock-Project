
public class Address
{
    private String address1;
    private String address2;
    private String  postcode;
    private String name;
    private String phone;
    private String email;
    public Address(String email,String name,String address1,String address2,String postcode,String phone){
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.phone = phone;
        this.name = name;
        this.email = email;

    } 

    @Override   
    public String toString() 
    {
        return this.name + ", " + this.address1 + ", " + this.address2 + ", " +   this.phone + ", " +   this.postcode + ", " +   this.email;
    }

    public String getname() {
        return name;}

    public String getAddress1() {
        return address1;}

    public String getAddress2() {
        return address2;}

    public String getpostcode() {
        return postcode;}

    public String getphone() {
        return phone;}

    public String getemail() {
        return email;}

    public void setAddress1(String address1) {this.address1 = address1;}

    public void setAddress2(String address2) {this.address2 = address2;}

    public void setpostcode(String postcode) {this.postcode = postcode;}

    public void setphone(String phone) {this.phone = phone;}

    public void setname(String name){this.name = name;}

    public void setemail(String email) {this.email = email;}
}

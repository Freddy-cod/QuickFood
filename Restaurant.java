public class Restaurant {
    private String name;
    private String location;
    private String contactNumber;

    public Restaurant(String name, String location, String contactNumber) {
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

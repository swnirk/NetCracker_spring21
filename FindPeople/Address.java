import java.util.Objects;

public class Address {

    private String adr;
    private String country;
    private String city;
    private String street;
    private String house;


    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Address(String adr) {

        String[] items = adr.split(", ");
        country = items[0];
        city = items[1];
        street = items[2];
        house = items[3];
        this.adr = adr;

    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getAdr().equals(address.getAdr()) && getCountry().equals(address.getCountry()) && getCity().equals(address.getCity()) && getStreet().equals(address.getStreet()) && getHouse().equals(address.getHouse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdr(), getCountry(), getCity(), getStreet(), getHouse());
    }
}
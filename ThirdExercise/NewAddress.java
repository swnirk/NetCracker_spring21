import java.util.Scanner;
import java.util.StringTokenizer;

public class NewAddress {

        private String adr;
        private String country;
        private String region;
        private String city;
        private String street;
        private String house;
        private  String corpus;


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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    //Craete string of address with comma

    public NewAddress(String adr) {

            String[] items = adr.split(", ");
            country = items[0];
            region = items[1];
            city = items[2];
            street = items[3];
            house = items[4];
            corpus = items[5];
            this.adr = adr;

            System.out.println("Country:" + country + "\n" + "Region:" + region + "\n" + "City:" + city + "\n" +
                    "Street:" + street + "\n" + "House:" + house + "\n" + "Corpus:" + corpus);
        }

        public NewAddress(){
            super();
        }

    //Craete string of address with different signs

    public void DifferentSigns(String str) {

        String[] atributs = new String[6];
        StringTokenizer tokenizer = new StringTokenizer(str, ",.;");
        while (tokenizer.hasMoreTokens()) {
            for(int i = 0; i < 6; i++) {
                atributs[i] = tokenizer.nextToken();
            }
        }
        System.out.println("Country:" + atributs[0] + "\n" + "Region:" + atributs[1] + "\n" + "City:" + atributs[2] + "\n" +
                "Street:" + atributs[3] + "\n" + "House:" + atributs[4] + "\n" + "Corpus:" + atributs[5]);
    }
    public static void main (String[] args) {

            System.out.println("Please, enter your address:");
            Scanner adr1 = new Scanner(System.in);
            String address1 = adr1.nextLine();
            NewAddress addss1 = new NewAddress(address1);

            System.out.println("Please, enter your address with different signs:");
            Scanner adr2 = new Scanner(System.in);
            String address2 = adr2.nextLine();

            NewAddress addss2 = new NewAddress();
            addss2.DifferentSigns(address2);
    }
}


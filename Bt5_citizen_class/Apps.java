public class Apps {
    public static void main(String[] args) {
        Citizen c1 = new Citizen();
        c1.setId("1");
        c1.setName("james");
        c1.setGender("male");
        c1.setNation("US");
        c1.setYear(Integer.parseInt("2000"));
        System.out.println(c1.toString());

        Citizen c2 = new Citizen();
        c2.setId("2");
        c2.setName("lejames");
        c2.setGender("male");
        c2.setNation("US");
        c2.setYear(Integer.parseInt("1990"));
        System.out.println(c2.toString());

        Citizen c3 = new Citizen();
        c3.setId("3");
        c3.setName("bond");
        c3.setGender("female");
        c3.setNation("Uk");
        c3.setYear(Integer.parseInt("1980"));
        System.out.println(c3.toString());
        
    }
}

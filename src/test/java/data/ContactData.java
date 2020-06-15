package data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class ContactData {

    public ContactData(String firstName, String lastName, Long phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    private String firstName;
    private String lastName;
    private Long phone;
    private String email;

    public ContactData() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getName(){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName();
    }

    public static String getSurname(){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().lastName();
    }

    public static Long getPhoneNumber(){
        long leftLimit = 1000000000L;
        long rightLimit = 9999999999L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return  generatedLong;
    }

    public static String getEmailAddress(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

}

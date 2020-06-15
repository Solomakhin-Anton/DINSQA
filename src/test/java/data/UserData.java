package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserData {

    public UserData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

    public UserData() {}

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

    public static String getName(){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName();
    }

    public static String getSurname(){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().lastName();
    }

}
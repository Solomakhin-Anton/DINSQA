package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.ContactData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rest.RestContact;

import static org.junit.Assert.*;

class ContactDataTest {

    String firstName = ContactData.getName();
    String lastName = ContactData.getSurname();
    Long phone = ContactData.getPhoneNumber();
    String email = ContactData.getEmailAddress();
    String firstName2 = ContactData.getName();
    String lastName2 = ContactData.getSurname();
    Long phone2 = ContactData.getPhoneNumber();
    String email2 = ContactData.getEmailAddress();
    String firstName3 = ContactData.getName();
    String lastName3 = ContactData.getSurname();
    Long phone3 = ContactData.getPhoneNumber();
    String email3 = ContactData.getEmailAddress();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("Постим первого пользователя в ../1/..")
    @Test
    void shouldPostFirst(){
        ContactData contactData = new ContactData(firstName, lastName, phone, email);
        String response = RestContact.usedPost(contactData);
        System.out.println(response);
        assertTrue(response.contains(firstName));
    }

    @DisplayName("Постим второго пользователя в ../2/..")
    @Test
    void shouldPostSecond(){
        ContactData contactData = new ContactData(firstName2, lastName2, phone2, email2);
        String response = RestContact.usedPost2(contactData);
        System.out.println(response);
        assertTrue(response.contains(firstName2));
    }

    @DisplayName("Меняем первого пользователя - ../1/..")
    @Test
    void shouldPut(){
        ContactData contactData = new ContactData(firstName3, lastName3, phone3, email3);
        String response = RestContact.usedPut(contactData);
        System.out.println(response);
        assertTrue(response.contains(firstName3));
    }

    @DisplayName("Удаляем второго пользователя - ../2/..")
    @Test
    void shouldDelete(){
        ContactData contactData = new ContactData();
        String response = RestContact.usedDelete(contactData);
        assertFalse(response.contains(firstName2));
    }

    @DisplayName("Запрашиваем все данные")
    @Test
    void shouldGet(){
        ContactData contactData = new ContactData();
        String response = RestContact.usedGet(contactData);
        String response2 = RestContact.usedGet2(contactData);
        System.out.println(response + response2);
        System.out.println(response + response2);
        assertTrue(response.contains("1" + "2"+ "3" + "4" + "5"));
    }

    @DisplayName("Поиск по номеру")
    @Test
    void shouldSearch(){
        ContactData contactData = new ContactData();
        String response = RestContact.usedGetForSearchByNumber(contactData);
        System.out.println(response);
        assertTrue(response.contains("5321456789"));
        assertFalse(response.contains("3123456789"));
    }

    @DisplayName("Поиск по id")
    @Test
    void shouldSearchById(){
        ContactData contactData = new ContactData();
        String response = RestContact.usedGetForSearchById(contactData);
        System.out.println(response);
        assertTrue(response.contains("Brandon"));
        assertFalse(response.contains("Cersei"));
    }

    @DisplayName("Негативный тест: запостим без данных")
    @Test
    void shouldPostNull(){
       ContactData contactData = new ContactData();
        String response = RestContact.usedPostNull(contactData);
        System.out.println(response);
        assertTrue(response.contains("не может быть пусто"));
    }

    @DisplayName("Негативный тест: удалим то, чего нет")
    @Test
    void shouldDeleteNothing(){
        ContactData contactData = new ContactData();
        String response = RestContact.usedDeleteNothing(contactData);
        System.out.println(response);
        assertTrue(response.contains("User with this: 45 not found"));
    }

}
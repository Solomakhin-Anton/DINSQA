package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.UserData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import rest.RestUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class UserDataTest {

    String firstName = UserData.getName();
    String lastName = UserData.getSurname();
    String firstName2 = UserData.getName();
    String lastName2 = UserData.getSurname();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("Постим третьего пользователя - id 3")
    @Test
    void shouldPostFirst(){
        UserData userData = new UserData(firstName, lastName);
        String response = RestUser.usedPost(userData);
        System.out.println(response);
        assertTrue(response.contains(firstName));
    }

    @DisplayName("Меняем первого пользователя - id 1")
    @Test
    void shouldPut(){
        UserData userData = new UserData(firstName2, lastName2);
        String response = RestUser.usedPut(userData);
        System.out.println(response);
        assertTrue(response.contains(firstName2));
    }

    @DisplayName("Удаляем третьего - id 2")
    @Test
    void shouldDelete(){
        UserData userData = new UserData();
        String response = RestUser.usedDelete(userData);
        assertFalse(response.contains(firstName2));
    }

    @DisplayName("Запрашиваем все данные")
    @Test
    void shouldGet(){
        UserData userData = new UserData();
        String response = RestUser.usedGet(userData);
        System.out.println(response);
        assertTrue(response.contains("1"));
        assertTrue(response.contains("2"));
    }

    @DisplayName("Негативный тест: запостим без данных")
    @Test
    void shouldPostNull(){
        UserData userData = new UserData();
        String response = RestUser.usedPostNull(userData);
        System.out.println(response);
        assertTrue(response.contains("должно быть задано"));
    }

    @DisplayName("Негативный тест: удалим то, чего нет")
    @Test
    void shouldDeleteNothing(){
        UserData userData = new UserData();
        String response = RestUser.usedDeleteNothing(userData);
        System.out.println(response);
        assertTrue(response.contains("User with this: 45 not found"));
    }
}
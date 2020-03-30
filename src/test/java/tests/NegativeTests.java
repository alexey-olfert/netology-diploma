package tests;

import org.junit.jupiter.api.Test;
import pages.BuyTripPage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeTests {

    @Test
    void shouldDeclinePaymentWithInvalidRandomCard() {
        open("http://localhost:8080");
        BuyTripPage.payWithRandomInvalidCard();
        $(withText("Ошибка")).waitUntil(visible, 10000);
    }

    @Test
    void shouldDeclineCreditWithInvalidRandomCard() {
        open("http://localhost:8080");
        BuyTripPage.takeCreditWithRandomInvalidCard();
        $(withText("Ошибка")).waitUntil(visible, 10000);
    }

    @Test
    void shouldNotAcceptInvalidMonth() {
        open("http://localhost:8080");
        BuyTripPage.insertWrongMonth();
        $(withText("Неверно указан срок действия карты")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptZeroMonth() {
        open("http://localhost:8080");
        BuyTripPage.insertZeroMonth();
        $(withText("Неверно указан срок действия карты")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptWrongFormatMonth() {
        open("http://localhost:8080");
        BuyTripPage.insertWrongFormatMonth();
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptPastMonth() {
        open("http://localhost:8080");
        BuyTripPage.insertPastMonth();
        $(withText("Неверно указан срок действия карты")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptOldYear() {
        open("http://localhost:8080");
        BuyTripPage.insertOldYear();
        $(withText("Истёк срок действия карты")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptWrongFormatYear() {
        open("http://localhost:8080");
        BuyTripPage.insertWrongFormatYear();
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptWrongFormatCVV() {
        open("http://localhost:8080");
        BuyTripPage.insertWrongFormatCVV();
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptRussianName() {
        open("http://localhost:8080");
        BuyTripPage.insertRussianName();
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotAcceptOnlyFirstName() {
        open("http://localhost:8080");
        BuyTripPage.insertFirstName();
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    @Test
    void shouldNotSendEmptyFields() {
        open("http://localhost:8080");
        BuyTripPage.sendEmptyFields();
        $(withText("Поле обязательно для заполнения")).waitUntil(visible, 5000);
    }

}

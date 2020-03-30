package tests;

import org.junit.jupiter.api.Test;
import pages.BuyTripPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveTests {

    @Test
    void shouldApprovePayment() throws SQLException {
        open("http://localhost:8080");
        BuyTripPage.payWithValidCard();
        $(withText("Успешно")).waitUntil(visible, 10000);
        assertTrue(BuyTripPage.isPaymentApproved());
    }

    @Test
    void shouldDeclinePayment() throws SQLException {
        open("http://localhost:8080");
        BuyTripPage.payWithInvalidCard();
        $(withText("Ошибка")).waitUntil(visible, 10000);
        assertFalse(BuyTripPage.isPaymentApproved());
    }

    @Test
    void shouldApproveCredit() throws SQLException {
        open("http://localhost:8080");
        BuyTripPage.takeCreditWithValidCard();
        $(withText("Успешно")).waitUntil(visible, 10000);
        assertTrue(BuyTripPage.isCreditApproved());
        assertTrue(BuyTripPage.isCreditIDNotNull());
    }

    @Test
    void shouldDeclineCredit() throws SQLException {
        open("http://localhost:8080");
        BuyTripPage.takeCreditWithInvalidCard();
        $(withText("Ошибка")).waitUntil(visible, 10000);
        assertFalse(BuyTripPage.isCreditApproved());
    }
}

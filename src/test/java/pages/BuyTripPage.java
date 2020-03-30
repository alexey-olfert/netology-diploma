package pages;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.sql.SQLException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BuyTripPage {
    static private SelenideElement payWithCardButton = $$("button").find(exactText("Купить"));;
    static private SelenideElement payWithCreditButton = $$("button").find(exactText("Купить в кредит"));
    static private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    public static void payWithValidCard() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void payWithInvalidCard() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getInvalidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void payWithRandomInvalidCard() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getRandomCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void takeCreditWithValidCard() {
        payWithCreditButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void takeCreditWithInvalidCard() {
        payWithCreditButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getInvalidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void takeCreditWithRandomInvalidCard() {
        payWithCreditButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getRandomCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertWrongMonth() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getWrongMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertWrongFormatMonth() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getWrongFormatMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertZeroMonth() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue("00");
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertPastMonth() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getPastMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYearOfPastDate());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertOldYear() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getOldYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertWrongFormatYear() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getWrongFormatYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertWrongFormatCVV() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getWrongFormatCVV());
        continueButton.click();
    }

    public static void insertRussianName() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getRUFullName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void insertFirstName() {
        payWithCardButton.click();
        $(byText("Номер карты")).parent().$("input").setValue(DataHelper.getValidCardNumber());
        $(byText("Месяц")).parent().$("input").setValue(DataHelper.getMonth());
        $(byText("Год")).parent().$("input").setValue(DataHelper.getYear());
        $(byText("Владелец")).parent().$("input").setValue(DataHelper.getFirstName());
        $(byText("CVC/CVV")).parent().$("input").setValue(DataHelper.getCVV());
        continueButton.click();
    }

    public static void sendEmptyFields() {
        payWithCardButton.click();
        continueButton.click();
    }

    public static boolean isPaymentApproved() throws SQLException {
        return DataHelper.getPaymentStatus().equals(DataHelper.APPROVED_STATUS);
    }

    public static boolean isCreditApproved() throws SQLException {
        return DataHelper.getCreditStatus().equals(DataHelper.APPROVED_STATUS);
    }

    public static boolean isCreditIDNotNull() throws SQLException {
        return DataHelper.getOrderInformation() != null;
    }
}

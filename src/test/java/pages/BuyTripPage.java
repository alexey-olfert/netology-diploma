package pages;

import com.codeborne.selenide.SelenideElement;
import data.DBUtils;
import data.DataHelper;
import data.FieldsData;

import java.sql.SQLException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BuyTripPage {
    public static SelenideElement payWithCardButton = $$("button").find(exactText("Купить"));;
    public static SelenideElement payWithCreditButton = $$("button").find(exactText("Купить в кредит"));
    static private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));
    static private SelenideElement cardNumberField =  $(byText("Номер карты")).parent().$("input");
    static private SelenideElement monthField = $(byText("Месяц")).parent().$("input");
    static private SelenideElement yearField = $(byText("Год")).parent().$("input");
    static private SelenideElement cardHolderField = $(byText("Владелец")).parent().$("input");
    static private SelenideElement CVVField = $(byText("CVC/CVV")).parent().$("input");

    public void FillTheFields(SelenideElement button, FieldsData data) {
        button.click();
        cardNumberField.setValue(data.getCardNumber());
        monthField.setValue(data.getMonth());
        yearField.setValue(data.getYear());
        cardHolderField.setValue(data.getCardHolder());
        CVVField.setValue(data.getCVV());
        continueButton.click();
    }

    public void sendEmptyFields() {
        payWithCardButton.click();
        continueButton.click();
    }
/*
    public void openSUT() {
        open("http://localhost:8080");
    }

 */

    public void openSUT() {
        open(System.getProperty("sut.url"));
    }

    public void checkErrorMessage() {
        $(withText("Ошибка")).waitUntil(visible, 10000);
    }

    public void checkWrongValidityErrorMessage() {
        $(withText("Неверно указан срок действия карты")).waitUntil(visible, 5000);
    }

    public void checkWrongFormatErrorMessage() {
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    public void checkExpiredCardErrorMessage() {
        $(withText("Истёк срок действия карты")).waitUntil(visible, 5000);
    }

    public void checkRequiredFieldErrorMessage() {
        $(withText("Поле обязательно для заполнения")).waitUntil(visible, 5000);
    }

    public void checkSuccessMessage() {
        $(withText("Успешно")).waitUntil(visible, 10000);
    }


}

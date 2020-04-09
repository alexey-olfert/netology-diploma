package tests;

import data.DBUtils;
import data.DataHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BuyTripPage;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveTests {
    BuyTripPage page = new BuyTripPage();

    @Test
    @DisplayName("Getting success message and approved status in DB after payment with valid card")
    void shouldApprovePaymentWithValidCard() throws SQLException {
        page.openSUT();
        page.FillTheFields(BuyTripPage.payWithCardButton, DataHelper.dataWithValidCard);
        page.checkSuccessMessage();
        assertEquals(DBUtils.getPaymentStatus(), DataHelper.APPROVED_STATUS);
    }

    @Test
    @DisplayName("Getting error message and declined status in DB after payment with invalid card")
    void shouldDeclinePaymentWithInvalidCard() throws SQLException {
        page.openSUT();
        page.FillTheFields(BuyTripPage.payWithCardButton, DataHelper.dataWithInvalidCard);
        page.checkErrorMessage();
        assertNotEquals(DBUtils.getPaymentStatus(), DataHelper.APPROVED_STATUS);
    }

    @Test
    @DisplayName("Getting success message and approved status with right payment info in DB after taking credit with valid card")
    void shouldApproveCreditWithValidCard() throws SQLException {
        page.openSUT();
        page.FillTheFields(BuyTripPage.payWithCreditButton, DataHelper.dataWithValidCard);
        page.checkSuccessMessage();
        assertEquals(DBUtils.getCreditStatus(), DataHelper.APPROVED_STATUS);
        assertNotEquals(DBUtils.getOrderInformation(), null);
    }

    @Test
    @DisplayName("Getting error message and declined status in DB after taking credit with invalid card")
    void shouldDeclineCreditWithInvalidCard() throws SQLException {
        page.openSUT();
        page.FillTheFields(BuyTripPage.payWithCreditButton, DataHelper.dataWithInvalidCard);
        page.checkErrorMessage();
        assertNotEquals(DBUtils.getPaymentStatus(), DataHelper.APPROVED_STATUS);
    }
}

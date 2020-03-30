package data;

import com.github.javafaker.Faker;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class DataHelper {
    static LocalDate now = LocalDate.now();
    static LocalDate earlier = now.minusMonths(1);


    static Faker RUFaker = new Faker(new Locale("ru"));
    static String RUFullName = RUFaker.name().firstName() + " " + RUFaker.name().lastName();
    static Faker faker = new Faker(new Locale("en"));
    static String fullName = faker.name().firstName() + " " + faker.name().lastName();
    static String firstName = faker.name().firstName();
    static Random r = new Random();
    static int month = r.nextInt(12) + 1;
    static int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
    static int pastMonth = earlier.getMonth().getValue();
    static int yearOfPastDate = earlier.getYear();
    static int wrongMonth = r.nextInt(88) + 12;
    static int wrongFormatMonth = r.nextInt(10);
    static int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
    static int year = r.nextInt(5) + currentYear + 1;
    static int oldYear = r.nextInt(currentYear);
    static int wrongFormatYear = r.nextInt(10);
    static int CVV = r.nextInt(1000);
    static int wrongFormatCVV = r.nextInt(100);
    static final String VALID_CARD_NUMBER = "4444 4444 4444 4441";
    static final String INVALID_CARD_NUMBER = "4444 4444 4444 4442";
    public static final String APPROVED_STATUS = "APPROVED";

    public static String getCurrentMonth() {
        return String.format("%02d", currentMonth);
    }

    public static String getWrongFormatMonth() {
        return Integer.toString(wrongFormatMonth);
    }

    public static String getWrongMonth() {
        return String.format("%02d", wrongMonth);
    }

    public static String getPastMonth() {
        return String.format("%02d", pastMonth);
    }

    public static String getOldYear() {
        return String.format("%02d", oldYear);
    }

    public static String getYearOfPastDate() {
        return String.format("%02d", yearOfPastDate);
    }

    public static String getWrongFormatYear() {
        return Integer.toString(wrongFormatYear);
    }

    public static String getWrongFormatCVV() {
        return Integer.toString(wrongFormatCVV);
    }

    public static String getRUFullName() {
        return RUFullName;
    }

    public static String getValidCardNumber() {
        return VALID_CARD_NUMBER;
    }

    public static String getInvalidCardNumber() {
        return INVALID_CARD_NUMBER;
    }

    public static String getFullName() {
        return fullName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getMonth() { return String.format("%02d", month); }

    public static String getCurrentYear() {
        return Integer.toString(currentYear);
    }

    public static String getYear() {
        return Integer.toString(year);
    }

    public static String getCVV() {
        return String.format("%03d", CVV);
    }

    public static String getRandomCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        int num;
        for (int i = 0; i < 16; i++) {
            num = r.nextInt(10);
            cardNumber.append(Integer.toString(num));
        }
        return cardNumber.toString();
    }

    public static String getPaymentStatus() throws SQLException {
        val codesSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }

    public static String getCreditStatus() throws SQLException {
        val codesSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }

    public static String getOrderInformation() throws SQLException {
        val codesSQL = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }



}

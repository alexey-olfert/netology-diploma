package data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static String getPaymentStatus() throws SQLException {
        val codesSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(System.getProperty("db.url"), System.getProperty("db.user"), System.getProperty("db.password"));){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }

    public static String getCreditStatus() throws SQLException {
        val codesSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(System.getProperty("db.url"), System.getProperty("db.user"), System.getProperty("db.password"));){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }

    public static String getOrderInformation() throws SQLException {
        val codesSQL = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(System.getProperty("db.url"), System.getProperty("db.user"), System.getProperty("db.password"));){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }
}

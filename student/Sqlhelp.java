package test4;
import java.sql.*;

/**
 * @Author: GunGun
 * @Description:
 * @Date: Greate in 2021/6/16 16:58
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class Sqlhelp {

        public static Connection getConnection() throws SQLException {
            Connection con=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&useSSL=false&severTimezone=GMT%2B8";
                String username="root";
                String password="280623";
                con=DriverManager.getConnection(URL,username,password);
                return con;
            }
            catch(ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }

        }
        //自定义释放资源
        public static void close(Connection c, Statement s) {
            close(c, s, null);

        }
        public static void close(Connection c, Statement s, ResultSet r) {

            try {
                if (r != null) {
                    r.close();
                }
                if (s != null) {
                    s.close();
                }
                if (c != null) {

                    c.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException");

            }
        }
}


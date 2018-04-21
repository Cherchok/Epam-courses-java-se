package javase08.t01;

import java.sql.*;

public class DBConnection {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mysql", "root", "12asshole");
                st = conn.createStatement();
                st.executeUpdate(
                        "INSERT INTO Module8DB.products (product_name, product_price, shop_id) " +
                                "VALUES ('Souvenirs', 21114,3)");
                st.executeUpdate(
                        "INSERT INTO Module8DB.products (product_name, product_price, shop_id) " +
                                "VALUES ('Potato', 123,2)");
                st.executeUpdate(
                        "INSERT INTO Module8DB.products (product_name, product_price, shop_id) " +
                                "VALUES ('Boots', 2342,1)");

                rs = st.executeQuery("SELECT * FROM Module8DB.products");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                            rs.getInt(3) + " " + rs.getInt(4));
                }

                System.out.println();
                System.out.println("//////////////");
                System.out.println();

                st.executeUpdate("UPDATE Module8DB.products SET product_name='Cucumber' WHERE product_id=2");
                st.executeUpdate("UPDATE Module8DB.products SET product_name='Egs' WHERE product_id=3");
                rs = st.executeQuery("SELECT * FROM Module8DB.products");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                            rs.getInt(3) + " " + rs.getInt(4));
                }

                System.out.println();
                System.out.println("//////////////");
                System.out.println();

                rs = st.executeQuery("SELECT * FROM Module8DB.products WHERE product_id=3");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                            rs.getInt(3) + " " + rs.getInt(4));
                }

             //   st.execute("DROP TABLE Module8DB.products"); // uncomment for deleting
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

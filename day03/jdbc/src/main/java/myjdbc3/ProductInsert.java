package myjdbc3;

import java.sql.*;

public class ProductInsert {
    public static void main(String[] args) {
        // 1. MySQL Driver Loading
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("OK...");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found....");
        }
        // 2. Connection
        String url = "jdbc:mysql://localhost:3306/smdb";
        String id = "smuser";
        String pwd = "111111";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, id, pwd);
            System.out.println("connection success!!!!");
        } catch (SQLException e) {
            System.out.println("connection fail!!!!");
            e.printStackTrace();
        }
        // 3. Make SQL Statement
        String insertSql = "INSERT INTO product VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        try {
            pstmt = con.prepareStatement(insertSql);
            pstmt.setInt(1,10);
            pstmt.setString(2,"조조조");
            pstmt.setInt(3,10000);
            pstmt.setString(4,"img");
            pstmt.setTimestamp(5,currentTimestamp);

            //4. 전송
            pstmt.executeUpdate();
            System.out.println("Inserted Data .....");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }finally {
            // 5. Close

            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

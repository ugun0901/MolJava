package myjdbc2;

import java.sql.*;

public class ItemSelectOne {

    public static void main(String[] args) {
        // 1. Driver Loading
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
        String selectSql = "SELECT * FROM item WHERE id = ?";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            pstmt = con.prepareStatement(selectSql);
            pstmt.setString(1,"01"); // 수정할 코드
            //4. 전송
            rset = pstmt.executeQuery();
            rset.next();
            String itemId = rset.getString("id");
            String itemName = rset.getString("name");
            String itemPrice = rset.getString("price");
            String itemImgname = rset.getString("imgname");
            System.out.printf("%s %s %s %s \n",itemId, itemName, itemPrice,itemImgname);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }finally {
            if(rset != null){
                try {
                    rset.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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

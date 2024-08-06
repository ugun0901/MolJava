package myjdbc3;

import java.sql.*;

public class ProductSelect {
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
        String selectSql = "SELECT * FROM product";
        PreparedStatement pstmt = null;
        ResultSet rset = null;


        try {
            pstmt = con.prepareStatement(selectSql);
            //4. 전송
            rset = pstmt.executeQuery();
            // 5. 결과 출력
            while(rset.next()){
                String productId = rset.getString("id");
                String productName = rset.getString("name");
                String productPrice = rset.getString("price");
                String productImgname = rset.getString("imgname");
                String Productregdate = rset.getString("regdate");
                System.out.printf("%s %s %s %s %s \n",productId, productName, productPrice,productImgname, Productregdate);
            }

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

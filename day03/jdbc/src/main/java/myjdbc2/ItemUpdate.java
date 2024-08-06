package myjdbc2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemUpdate {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("OK...");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found....");
        }

        //2. Connection
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

        //3.SQL 문장을 만든다.
        String updateSql = "UPDATE item SET name=?,price = ?,imgname=? WHERE id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(updateSql);
            pstmt.setString(1,"원윾건");
            pstmt.setString(2,"8888");
            pstmt.setString(3,"원");
            pstmt.setString(4,"01");//물음표 순서대로 세팅

            //4.SQL 문장 전송
            pstmt.executeUpdate();
            System.out.println("Update Data .....");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
package myjdbc;

import java.sql.*;

public class Test2 {
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
            System.out.println("접속 성공!!!!");
        } catch (SQLException e) {
            System.out.println("접속 실패!!!!");
            e.printStackTrace();
        }

        // 3. Make SQL Statement
        String selectSql = "SELECT * FROM cust";
        PreparedStatement pstmt = null;
        ResultSet rset = null;


        try {
            pstmt = con.prepareStatement(selectSql);
            //4. 전송
            rset = pstmt.executeQuery();
            // 5. 결과 출력
            while(rset.next()){
                String custId = rset.getString("id");
                String custPwd = rset.getString("pwd");
                String custName = rset.getString("name");
                String custAcc = rset.getString("acc");
                System.out.printf("%s %s %s %s \n",custId, custPwd, custName,custAcc);
            }

            System.out.println("데이터가 없습니다. ");
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


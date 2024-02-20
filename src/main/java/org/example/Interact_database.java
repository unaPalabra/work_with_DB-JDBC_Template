package org.example;

import java.math.BigDecimal;
import java.sql.*;

public class Interact_database {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "123456789";



        void getBalance (Long id_user){

            Connection conn = null;
            PreparedStatement preparedStmt = null;

            try{ Class.forName(JDBC_DRIVER);

                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                String sql;
                sql = "SELECT id, user_id, current_balance FROM balance WHERE user_id=?";
                preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setLong(1, id_user);
                ResultSet resultSet = preparedStmt.executeQuery();

                while(resultSet.next()){
                    Long id = resultSet.getLong("id");
                    Long user_id = resultSet.getLong("user_id");
                    BigDecimal current_balance = resultSet.getBigDecimal("current_balance");
                    System.out.println("Your current balance: ");
                    System.out.print("id: " + id);
                    System.out.print(", user_id: " + user_id);
                    System.out.println(", current balance: " + current_balance);
                }

                resultSet.close();
                preparedStmt.close();
                conn.close();
            } catch(Exception se){
                se.printStackTrace();
            } finally{

                try{
                    if(preparedStmt!=null)
                        preparedStmt.close();

                }catch(SQLException se2){
                    se2.printStackTrace();
                }
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
        }

    void putMoney(Long id_user, Long putMoney){

        Connection conn = null;
        PreparedStatement preparedStmt = null;

        try{ Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);;

            String sql;
            sql = "UPDATE balance SET current_balance = current_balance + abs(?)  WHERE user_id=?";
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setLong(1, putMoney);
            preparedStmt.setLong(2, id_user);
            preparedStmt.executeUpdate();

            System.out.println("Your payment was successful");

            preparedStmt.close();
            conn.close();

        } catch(Exception se){
            se.printStackTrace();
        } finally{
            try{
                if(preparedStmt!=null)
                    preparedStmt.close();

            }catch(SQLException se2){
                se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    void takeMoney(Long id_user, Long takeMoney){
        Connection conn = null;
        PreparedStatement preparedStmt = null;

        try{ Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String sql;
            sql = "UPDATE balance SET current_balance = current_balance - abs(?)  WHERE user_id=?";
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setLong(1, takeMoney);
            preparedStmt.setLong(2, id_user);
            preparedStmt.executeUpdate();

            System.out.println("The operation was successful");

            preparedStmt.close();
            conn.close();

        } catch(Exception se){
            se.printStackTrace();
        } finally{
            try{
                if(preparedStmt!=null)
                    preparedStmt.close();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

}

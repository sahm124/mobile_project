package com.example.myapplication;

import java.sql.*;
import java.util.List;


public class db {
    public  static int id_transaction = 0;
    public static void run() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE incomes " +
                    "(income_name VARCHAR(255) PRIMARY KEY, " +
                    " income_father VARCHAR(255))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE outcomes " +
                    "(outcome_name VARCHAR(255) PRIMARY KEY, " +
                    " outcome_father VARCHAR(255))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE transactions " +
                    "(name VARCHAR(255) , " +
                    " id INT , " +
                    " amount INT , " +
                    " date DATE)";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_table(){

                String url = "jdbc:mysql://localhost:3306/mydatabase";
                String user = "root";
                String password = "password";
                String tableName = "incomes";
                String inputFile = "/path/to/incomes.csv";

                try (Connection conn = DriverManager.getConnection(url, user, password);
                     Statement stmt = conn.createStatement()) {
                    String sql = "LOAD DATA INFILE '" + inputFile + "' INTO TABLE " + tableName + " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n' IGNORE 1 ROWS";
                    stmt.executeUpdate(sql);
                    System.out.println("Data inserted from file successfully");
                } catch (SQLException e) {
                    System.out.println("Error inserting data from file: " + e.getMessage());
                }

        tableName = "outcomes";
        inputFile = "/path/to/outcomes.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "LOAD DATA INFILE '" + inputFile + "' INTO TABLE " + tableName + " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n' IGNORE 1 ROWS";
            stmt.executeUpdate(sql);
            System.out.println("Data inserted from file successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting data from file: " + e.getMessage());
        }

        tableName = "transactions";
        inputFile = "/path/to/transactions.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "LOAD DATA INFILE '" + inputFile + "' INTO TABLE " + tableName + " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n' IGNORE 1 ROWS";
            stmt.executeUpdate(sql);
            System.out.println("Data inserted from file successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting data from file: " + e.getMessage());
        }



    }

    public static void save_table(){

    }

    public static void insert_transaction(String name, int amount, Date date ){
                String url = "jdbc:mysql://localhost:3306/mydatabase";
                String username = "user";
                String password = "password";
                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    String sql = "INSERT INTO transactions (name, id, amount, date) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, name);
                    pstmt.setString(2, String.valueOf(id_transaction+1));
                    pstmt.setString(1, String.valueOf(amount));
                    pstmt.setString(1, String.valueOf(date));
                    id_transaction ++;
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new row has been inserted.");
                    }
                } catch (SQLException ex) {
                    System.out.println("An error occurred: " + ex.getMessage());
                }
            }

    public static void insert_income(String name, String father){
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "user";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO incomes (name, father) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, father);
            id_transaction ++;
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row has been inserted.");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }


    public static void insert_outcome(String name, String father){
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "user";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO outcomes (name, father) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, father);
            id_transaction ++;
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row has been inserted.");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }

    public static void get_by_date(Date date){
        // pass list of transactions for a certain date
    }


}
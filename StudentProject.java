package com.mysql.jdbc;
import java.sql.*;
import java.util.Scanner;

public class StudentProject {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "admin";
        String insertQuery = "INSERT INTO student (student_id, name, age, grade, address) VALUES (?, ?, ?, ?, ?)";
        
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully\n");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database\n");

            Scanner scanner = new Scanner(System.in);

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            System.out.print("Enter the student ID: ");
            int studentId = scanner.nextInt();
            preparedStatement.setInt(1, studentId);

            System.out.print("Enter the student's name: ");
            String name = scanner.next();
            preparedStatement.setString(2, name);

            System.out.print("Enter the student's age: ");
            int age = scanner.nextInt();
            preparedStatement.setInt(3, age);

            System.out.print("Enter the student's grade: ");
            String grade = scanner.next();
            preparedStatement.setString(4, grade);

            System.out.print("Enter the student's address: ");
            String address = scanner.next();
            preparedStatement.setString(5, address);

            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully");
            System.out.println("check the database");


            // Close resources
            scanner.close();
            preparedStatement.close();
            connection.close();
        }
    
    }


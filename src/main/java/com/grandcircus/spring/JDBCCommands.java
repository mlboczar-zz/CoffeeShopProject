package com.grandcircus.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Megan on 5/13/2017.
 */
public class JDBCCommands {
    
    public static void formToDatabase (Customer customer) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
        String username = "grant";
        String password = "chirpus";
        String query = "INSERT INTO users (firstName, lastName, email, phoneNumber, password, loveCoffee, otherCoffee) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not find database driver", e);
        }

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getLastName());
            st.setString(3, customer.getEmail());
            st.setString(4, customer.getPhoneNumber());
            st.setString(5, customer.getPassword());
            st.setString(6, customer.getLoveCoffee());
            st.setString(7, customer.getOtherCoffee());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting into database", e);
        }
    }
}

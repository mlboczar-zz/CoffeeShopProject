package com.grandcircus.spring;

import org.springframework.ui.Model;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Megan on 5/13/2017.
 */
public class JDBCCommands {

    public static final String URL = "jdbc:mysql://localhost:3306/coffeeshopdb";
    public static final String USERNAME = "grant";
    public static final String PASSWORD = "chirpus";

    public static void formToDatabase (Customer customer) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO users (firstName, lastName, email, phoneNumber, password, loveCoffee, otherCoffee) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not find database driver", e);
        }

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

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

    public static void displayItems (Model model) {
        String url = "jdbc:mysql://localhost:3306/bcbc";
        String username = "grant";
        String password = "chirpus";
        String query = "SELECT * FROM items";
        DecimalFormat df = new DecimalFormat("#.00");

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not find database driver", e);
        }

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString(2);
                String description = rs.getString(3);
                String price = df.format(rs.getDouble(5));

                list.add(name + "\n" + description + "\n$" + price);
            }
            model.addAttribute("addStuff", list);

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting into database", e);
        }
    }
}

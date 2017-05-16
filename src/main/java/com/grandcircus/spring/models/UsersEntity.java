package com.grandcircus.spring.models;

import javax.persistence.*;

/**
 * Created by Megan on 5/16/2017.
 */
@Entity
@Table(name = "users", schema = "coffeeshopdb", catalog = "")
public class UsersEntity {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String loveCoffee;
    private String otherCoffee;

    @Id
    @Column(name = "UserID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = false, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "loveCoffee", nullable = true, length = 100)
    public String getLoveCoffee() {
        return loveCoffee;
    }

    public void setLoveCoffee(String loveCoffee) {
        this.loveCoffee = loveCoffee;
    }

    @Basic
    @Column(name = "otherCoffee", nullable = true, length = 100)
    public String getOtherCoffee() {
        return otherCoffee;
    }

    public void setOtherCoffee(String otherCoffee) {
        this.otherCoffee = otherCoffee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (loveCoffee != null ? !loveCoffee.equals(that.loveCoffee) : that.loveCoffee != null) return false;
        if (otherCoffee != null ? !otherCoffee.equals(that.otherCoffee) : that.otherCoffee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (loveCoffee != null ? loveCoffee.hashCode() : 0);
        result = 31 * result + (otherCoffee != null ? otherCoffee.hashCode() : 0);
        return result;
    }
}

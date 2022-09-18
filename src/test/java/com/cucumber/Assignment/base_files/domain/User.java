package com.cucumber.Assignment.base_files.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by inhab on 3/2/2020.
 */

public class User {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public User() {

    }

    public String getUserName() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public static class Builder {
        private Integer id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private Integer userStatus;

        public Builder() {

        }

        public User.Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public User.Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public User.Builder withfirstname(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public User.Builder withlastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User.Builder withemail(String email) {
            this.email = email;
            return this;
        }

        public User.Builder withpassword(String password) {
            this.password = password;
            return this;
        }

        public User.Builder withphone(String phone) {
            this.phone = phone;
            return this;
        }

        public User.Builder withuserStatus(Integer userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public User build() {
            User owner = new User();
            owner.id = this.id;
            owner.username = this.username;
            owner.firstName = this.firstName;
            owner.lastName = this.lastName;
            owner.email = this.email;
            owner.password = this.password;
            owner.phone = this.phone;
            owner.userStatus = this.userStatus;

            return owner;
        }


    }

}


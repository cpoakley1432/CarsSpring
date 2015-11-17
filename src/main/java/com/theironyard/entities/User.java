package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by cameronoakley on 11/15/15.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    Integer id;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String password;

}

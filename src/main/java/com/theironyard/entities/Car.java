package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by cameronoakley on 11/15/15.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    Integer id;

    @Column(nullable = false)
    public String make;

    @Column(nullable = false)
    public String model;

    @Column(nullable = false)
    public String mileage;

    @Column(nullable = false)
    public String drivetype;

    @ManyToOne
    public User user;

}

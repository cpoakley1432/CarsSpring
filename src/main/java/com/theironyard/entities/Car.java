package com.theironyard.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by cameronoakley on 11/15/15.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue
    Integer id;

    public String make;
    public String model;
    public String mileage;
    public String drivetype;
    @ManyToOne
    public User user;


}

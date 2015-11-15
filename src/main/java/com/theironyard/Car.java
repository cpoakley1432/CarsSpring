package com.theironyard;

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

    String make;
    String model;
    String mileage;
    String drivetype;
    @ManyToOne
    User user;


}

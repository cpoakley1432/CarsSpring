package com.theironyard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cameronoakley on 11/15/15.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    String password;
}

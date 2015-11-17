package com.theironyard;

import com.theironyard.services.CarsRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.util.CarsSpringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CarsSpringApplication.class)
@WebAppConfiguration
public class CarsSpringApplicationTests {
    @Autowired
    UserRepository users;

    @Autowired
    CarsRepository cars;

    MockMvc mockMvc;



}

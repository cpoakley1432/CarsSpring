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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CarsSpringApplication.class)
@WebAppConfiguration
public class CarsSpringApplicationTests {
    @Autowired
    UserRepository users;

    @Autowired
    CarsRepository cars;

    @Autowired
    WebApplicationContext wap;

    MockMvc mockMvc;

    @org.junit.Before
    public void before(){
        cars.deleteAll();
        users.deleteAll();
        mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/login")
                        .param("username", "testUsername")
                        .param("password", "testPass")
        );
        assertTrue(users.count() == 1);
    }

    @Test
    public void testAddCar() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/add-car")
                        .param("make" , "Test car make ")
                        .param("model", "Test car model")
                        .param("mileage" , "Test car mileage")
                        .param("drivetype" , "Test car drivetype")
                        .sessionAttr("username" , "testUser")
        );
        assertTrue(cars.count() == 1);
    }

}

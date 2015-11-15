package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by cameronoakley on 11/15/15.
 */
@Controller
public class CarsController {
    @Autowired
    UserRepository users;

    @Autowired
    CarsRepository cars;

    @RequestMapping("/")
    public String home (Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            return "login";
        }
        return "home";
    }

    @RequestMapping("/login")
    public String login (String username, String password, HttpSession session) throws Exception {
        session.setAttribute("username" , username);
        User user = users.findOneByName(username);
        if (user == null){
            user = new User();
            user.name = username;
            user.password = PasswordHash.createHash(password);
        }
        else if (!PasswordHash.validatePassword(password,user.password)){
            throw new Exception("Invalid password");
        }
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/add-car")
    public String addCar(String carmake, String carmodel, String carmileage,String drivetype, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (username == null){
        }
        User user = users.findOneByName(username);
        Car car = new Car();
        car.make = carmake;
        car.model = carmodel;
        car.mileage = carmileage;
        car.drivetype = drivetype;
        car.user = user;
        cars.save(car);

        return "redirect:/";
    }

    @RequestMapping("/update-car")
    public String updateCar(){

    }

    @RequestMapping("/delete-car")
    public String deleteCar(){

    }
}

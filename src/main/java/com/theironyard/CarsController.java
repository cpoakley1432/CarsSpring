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
        else{
            model.addAttribute("cars", cars.findAll());
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
    public String addCar(String make, String model, String mileage,String drivetype, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (username == null){
        }
        User user = users.findOneByName(username);
        Car car = new Car();
        car.make = make;
        car.model = model;
        car.mileage = mileage;
        car.drivetype = drivetype;
        car.user = user;
        cars.save(car);

        return "redirect:/";
    }

    @RequestMapping("/update")
    public String update (int id, HttpSession session, Model model) throws Exception {
        if (session.getAttribute("username") == null){
            throw new Exception("Not logged in");
        }
        model.addAttribute("id", id);
        return "update";
    }

    @RequestMapping("/update-car")
    public String updateCar(int id, String make, String model, String mileage, String drivetype, HttpSession session) throws Exception {
        if (session.getAttribute("username") == null){
            throw new Exception("Not logged in");
        }
        Car car = cars.findOne(id);
        car.make = make;
        car.model = model;
        car.mileage = mileage;
        car.drivetype = drivetype;
        cars.save(car);
        return "redirect:/";
    }

    @RequestMapping("/delete-car")
    public String deleteCar(Integer id){
        cars.delete(id);
        return "redirect:/";
    }
}

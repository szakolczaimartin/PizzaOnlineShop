package com.pizzashop.controller;

import java.security.Principal;

import com.pizzashop.dao.PizzaDao;
import com.pizzashop.dao.UserRolesDao;
import com.pizzashop.dao.UsersDao;
import com.pizzashop.dao.UsersDetailsDao;
import com.pizzashop.entity.Pizza;
import com.pizzashop.entity.UserRoles;
import com.pizzashop.entity.Users;
import com.pizzashop.entity.UsersDetails;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {



    @Autowired
    private UsersDao usersDao;

    @Autowired
    private UsersDetailsDao usersDetailsDao;

    @Autowired
    private UserRolesDao userRolesDao;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");

        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {

        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();



        System.out.println("User Name: "+ userName);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }


    @RequestMapping(value = "/signUpIn", method = RequestMethod.POST)
    public String saveOrder(@RequestParam("name") String name, @RequestParam("username") String username,
                            @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
                            @RequestParam("address") String address,@RequestParam("password") String password){

        Users users = new Users(username,password, true);
        usersDao.save(users);
        UsersDetails usersDetails = new UsersDetails(username,name,address,email,phoneNumber,users);
        usersDetailsDao.save(usersDetails);

         UserRoles userRoles = new UserRoles(users,"USER");
        userRolesDao.save(userRoles);


        return "loginPage";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage() {

        return "signUpPage";
    }
}
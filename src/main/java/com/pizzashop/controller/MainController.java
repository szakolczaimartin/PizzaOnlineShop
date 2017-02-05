package com.pizzashop.controller;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
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

        List<Users> usersList = usersDao.findAll();
        List<UserRoles> userRoleList = userRolesDao.findAll();
        List<UserRoles> userRoleAdminList = userRolesDao.findAdmin();
        model.addAttribute("usersList", usersList);
        model.addAttribute("userRoleList", userRoleList);
        model.addAttribute("userRoleAdminList", userRoleAdminList);



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

    @RequestMapping(value = "/modifyDetails", method = RequestMethod.GET)
    public String modifyDetailsPage(Model model, Principal principal) {
        String userName2 = principal.getName();

        UsersDetails userDetails = usersDetailsDao.listbyUsername(userName2).get(0);

        model.addAttribute("userDetails", userDetails);

        return "modifyDetailsPage";
    }


    @RequestMapping(value = "/modifyDetailsSubmit", method = RequestMethod.POST)
    public String modifyDetails(Model model, Principal principal, @RequestParam("name") String name,
                                @RequestParam("username") String username, @RequestParam("email") String email,
                                @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
                                @RequestParam("password") String password,
                                @RequestParam("conFirmpassword") String conFirmpassword) {

        if (!password.equals(conFirmpassword))
        {
            model.addAttribute("message", "Passwords don't equal!");
            return modifyDetailsPage(model,principal);
        }else {

            // After user login successfully.
            String userName2 = principal.getName();

            UsersDetails userDetails = usersDetailsDao.listbyUsername(userName2).get(0);

            UsersDetails modifyDetails = new UsersDetails(username, name, address, email, phoneNumber);
            Users user = new Users(userName2, password, true);
            this.usersDao.save(user);
            this.usersDetailsDao.save(modifyDetails);
            return "welcomePage";
        }
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();


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
    public String saveOrder(Model model,@RequestParam("name") String name, @RequestParam("username") String username,
                            @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
                            @RequestParam("address") String address,@RequestParam("password") String password,
                            @RequestParam("conFirmpassword") String conFirmpassword)
    {


        if (!password.equals(conFirmpassword))
        {
            model.addAttribute("message", "Passwords don't equal!");
            return signUpPage(model);
        }
        else if (usersDao.listItemsoOneOrder(username) != null)
        {
            model.addAttribute("message", "Username already exists!");
            return signUpPage(model);
        }else {
            Users users = new Users(username, password, true);
            usersDao.save(users);
            UsersDetails usersDetails = new UsersDetails(username, name, address, email, phoneNumber, users);
            usersDetailsDao.save(usersDetails);

            UserRoles userRoles = new UserRoles(users, "USER");
            userRolesDao.save(userRoles);


            return "loginPage";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage(Model model) {

        return "signUpPage";
    }

    @RequestMapping("/remove/{username}")
    public String removePerson(Model model,@PathVariable("username") String username){

        this.usersDetailsDao.removeUserDetails(username);
        this.userRolesDao.removeUserRole(username);
        this.usersDao.removeUser(username);
        return adminPage(model);
    }

    @RequestMapping("/addAdmin/{username}")
    public String addAdmin(Model model,@PathVariable("username") String username){

        Users user = usersDao.listItemsoOneOrder(username).get(0);
        UserRoles userRoles = new UserRoles(user, "ADMIN");
        this.userRolesDao.save(userRoles);
        return adminPage(model);
    }

    @RequestMapping("/depriveAdmin/{username}")
    public String depriveAdmin(Model model,@PathVariable("username") String username){

        this.userRolesDao.removeUserRole(username);
        Users user = usersDao.listItemsoOneOrder(username).get(0);
        UserRoles userRoles = new UserRoles(user, "USER");
        this.userRolesDao.save(userRoles);
        return adminPage(model);
    }

}
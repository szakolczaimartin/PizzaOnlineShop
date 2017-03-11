package com.pizzashop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pizzashop.dao.*;
import com.pizzashop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {



    @Autowired
    private UsersDao usersDao;

    @Autowired
    private UsersDetailsDao usersDetailsDao;

    @Autowired
    private UserRolesDao userRolesDao;

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemDao itemDao;


    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");

        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("foodForm") Food f) {
        this.foodDao.save(f);

        return adminPage(model);
    }


    @RequestMapping(value = "/adToChart")
    public String adToChart(Model model,Principal principal, @RequestParam("id") int id, @RequestParam("quantity") int quantity){

        Date date = new Date();
        Users user = usersDao.userByUsername(principal.getName());
        Food food = foodDao.getFoodById(id);
        int price = food.getPrice() * quantity;

        if (orderDao.orderByUsername(user.getUsername()) == null)
        {
            Order order = new Order(user,date,false,false);
            orderDao.save(order);

            Item item = new Item(order,food,quantity,price);
            itemDao.save(item);
        }
        else {

            List <Order> orderList = orderDao.orderByUsername(user.getUsername());
            Boolean flag = false;

            for (Order order: orderList) {

                if (order.getOrdered() == false)
                {
                    Item item = new Item(order,food,quantity,price);
                    itemDao.save(item);
                    flag = true;
                }
            }

            if (!flag)
            {
                Order order = new Order(user,date,false,false);
                orderDao.save(order);

                Item item = new Item(order,food,quantity,price);
                itemDao.save(item);
            }
        }


        return userInfo(model, principal);
    }

    @RequestMapping(value = "/removeFood/{id}")
    public String removeFood(Model model,@PathVariable("id") int id){
        this.itemDao.removeItemsFood(Integer.toHexString(id));
        this.foodDao.removeFood(id);
        return adminPage(model);
    }


    @RequestMapping(value = "/modifyFoodModal/{id}", method = RequestMethod.GET)
    public String modifyFoodModal(Model model,@PathVariable("id") int id){
        Food modifyFood = this.foodDao.getFoodById(id);
        model.addAttribute("modifyFood", modifyFood);
        return "modifyFood";
    }


    @RequestMapping(value = "/modifyFood", method = RequestMethod.POST)
    public String modifyFood(Model model,@RequestParam("name") String name,
                             @RequestParam("price") int price, @RequestParam("url") String url,
                             @RequestParam("ingredients") String ingredients, @RequestParam("type") String type,
                             @RequestParam("size") String size){

        Food modifyFood = this.foodDao.foodByName(name).get(0);
        modifyFood.setIngredients(ingredients);
        modifyFood.setPrice(price);
        modifyFood.setSize(size);
        modifyFood.setUrl(url);
        modifyFood.setType(type);
        this.foodDao.save(modifyFood);
        return adminPage(model);
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {

        List<Users> usersList = usersDao.findAll();
        List<UserRoles> userRoleList = userRolesDao.findAll();
        List<UserRoles> userRoleAdminList = userRolesDao.findAdmin();
        List<Food> foods = foodDao.findAll();
        model.addAttribute("usersList", usersList);
        model.addAttribute("userRoleList", userRoleList);
        model.addAttribute("userRoleAdminList", userRoleAdminList);
        model.addAttribute("foodForm", new Food());
        model.addAttribute("foods", foods);

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

        List<Food> allFood = this.foodDao.findAll();

        List<Food> smallPizza = new ArrayList<Food>();
        List<Food> bigPizza = new ArrayList<Food>();
        List<Food> otherFood = new ArrayList<Food>();
        List<Food> drink = new ArrayList<Food>();

        for (Food item:allFood) {
            if (item.getType().equals("pizza"))
            {
                if (item.getSize().equals("32"))
                {smallPizza.add(item);}
                else {bigPizza.add(item);}
            }
            else if(item.getType().equals("drink")){
                drink.add(item);}
            else {otherFood.add(item);}
        }

        model.addAttribute("smallPizza", smallPizza);
        model.addAttribute("bigPizza", bigPizza);
        model.addAttribute("otherFood", otherFood);
        model.addAttribute("drink", drink);

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
        else if (usersDao.userByUsername(username) != null)
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

    @RequestMapping("/removeItem/{itemId}")
    public String removePerson(Model model,Principal principal,@PathVariable("itemId") int id){

        this.itemDao.removeItem(id);
        return cartPage(model,principal);
    }

    @RequestMapping("/addAdmin/{username}")
    public String addAdmin(Model model,@PathVariable("username") String username){

        Users user = usersDao.userByUsername(username);
        UserRoles userRoles = new UserRoles(user, "ADMIN");
        this.userRolesDao.save(userRoles);
        return adminPage(model);
    }

    @RequestMapping("/depriveAdmin/{username}")
    public String depriveAdmin(Model model,@PathVariable("username") String username){

        this.userRolesDao.removeUserRole(username);
        Users user = usersDao.userByUsername(username);
        UserRoles userRoles = new UserRoles(user, "USER");
        this.userRolesDao.save(userRoles);
        return adminPage(model);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartPage(Model model, Principal principal) {

       List <Order> orderList = orderDao.orderByUsername(principal.getName());

        int allPrice = 0;
        String  price = "0";
        List<Item> itemList = new ArrayList<Item>();

        for (Order order:orderList) {

            if (order.getOrdered() == false)
            {

                itemList = order.getItems();

                for (Item item:itemList) {
                    allPrice = allPrice + item.getPrice();
                }

                price = Integer.toString(allPrice);

                if (price.length() == 4)
                {
                    price = price.substring(0,1) + " " + price.substring(1, price.length());
                }
                else if (price.length() > 4)
                {
                    price = price.substring(0,2) + " " + price.substring(2, price.length());
                }
            }
        }

        model.addAttribute("orders", itemList);
        model.addAttribute("inAll", price);

        return "cartPage";
    }


    @RequestMapping(value = "/orderIt", method = RequestMethod.POST)
    public String orderIt(Model model, Principal principal) {


        List<Order> orderList = orderDao.orderByUsername(principal.getName());

        if (!orderList.isEmpty()) {
            for (Order order : orderList) {

                if (order.getOrdered() == false) {
                    order.setOrdered(true);
                    orderDao.save(order);
                    return succesOrdered(model, principal);
                }
            }
        }
        model.addAttribute("message", "There is no item.");
        return cartPage(model, principal);
    }



    @RequestMapping(value = "/succesOrdered", method = RequestMethod.GET)
    public String succesOrdered(Model model, Principal principal) {

        return "successOrderedPage";
    }

    @RequestMapping(value = "/modifyItemModal/{id}", method = RequestMethod.GET)
    public String modifyItemModal(Model model,@PathVariable("id") int id){
        Item myItem = this.itemDao.getItemById(id);

        model.addAttribute("myItem", myItem);
        return "modifyItem";
    }




    @RequestMapping(value = "/modifyItemSub", method = RequestMethod.POST)
    public String modifyItem(Model model,Principal principal, @RequestParam("id") int id, @RequestParam("quantity") int quantity){

        Item item = this.itemDao.getItemById(id);
        item.setQuantity(quantity);
        item.setPrice(quantity*item.getFood().getPrice());
        this.itemDao.save(item);
        return cartPage(model,principal);
    }

}
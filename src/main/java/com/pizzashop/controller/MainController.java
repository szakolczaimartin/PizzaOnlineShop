package com.pizzashop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pizzashop.food.dao.FoodDao;
import com.pizzashop.item.dao.ItemDao;
import com.pizzashop.food.entity.Food;
import com.pizzashop.item.entity.Item;
import com.pizzashop.order.dao.OrderDao;
import com.pizzashop.order.entity.Order;
import com.pizzashop.userrole.dao.UserRoleDao;
import com.pizzashop.userrole.entity.UserRole;
import com.pizzashop.user.dao.UserDao;
import com.pizzashop.user.entity.User;
import com.pizzashop.usersdetail.dao.UserDetailDao;
import com.pizzashop.usersdetail.entity.UsersDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {


        List<Food> foodList = this.foodDao.findAll();
        List<Food> foodList1 = new ArrayList<Food>();
        List<Food> foodList2 = new ArrayList<Food>();

        foodList1.add(foodList.get(0));
        foodList1.add(foodList.get(1));
        foodList1.add(foodList.get(2));
        foodList1.add(foodList.get(3));

        foodList2.add(foodList.get(4));
        foodList2.add(foodList.get(5));
        foodList2.add(foodList.get(6));
        foodList2.add(foodList.get(7));
        model.addAttribute("foodList1", foodList1);
        model.addAttribute("foodList2", foodList2);
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public String save(Model model, Principal principal, @ModelAttribute("foodForm") Food f) {
        this.foodDao.save(f);

        return adminPage(model, principal);
    }

    @RequestMapping(value = "/adToChart")
    public String adToChart(Model model, Principal principal, @RequestParam("id") int id, @RequestParam("quantity") int quantity) {

        Date date = new Date();
        User user = userDao.userByUsername(principal.getName());
        Food food = foodDao.getFoodById(id);
        int price = food.getPrice() * quantity;

        if (orderDao.orderByUsername(user.getUsername()) == null) {
            Order order = new Order(user, date, false, false, 0);
            orderDao.save(order);

            Item item = new Item(order, food, quantity, price);
            itemDao.save(item);
        } else {

            List<Order> orderList = orderDao.orderByUsername(user.getUsername());
            Boolean flag = false;

            for (Order order : orderList) {

                if (order.getOrdered() == false) {
                    Item item = new Item(order, food, quantity, price);
                    itemDao.save(item);
                    flag = true;
                }
            }

            if (!flag) {
                Order order = new Order(user, date, false, false, 0);
                orderDao.save(order);

                Item item = new Item(order, food, quantity, price);
                itemDao.save(item);
            }
        }
        return selectOrder(model, principal);
    }

    @RequestMapping(value = "/removeFood/{id}")
    public String removeFood(Model model, Principal principal, @PathVariable("id") int id) {
        this.itemDao.removeItemsFood(Integer.toHexString(id));
        this.foodDao.removeFood(id);
        return adminPage(model, principal);
    }

    @RequestMapping(value = "/modifyFoodModal/{id}", method = RequestMethod.GET)
    public String modifyFoodModal(Model model, @PathVariable("id") int id) {
        Food modifyFood = this.foodDao.getFoodById(id);
        model.addAttribute("modifyFood", modifyFood);
        return "modifyFood";
    }


    @RequestMapping(value = "/modifyFood", method = RequestMethod.POST)
    public String modifyFood(Model model, Principal principal, @RequestParam("name") String name,
                             @RequestParam("price") int price, @RequestParam("url") String url,
                             @RequestParam("ingredients") String ingredients, @RequestParam("type") String type,
                             @RequestParam("size") String size) {

        Food modifyFood = this.foodDao.foodByName(name).get(0);
        modifyFood.setIngredients(ingredients);
        modifyFood.setPrice(price);
        modifyFood.setSize(size);
        modifyFood.setUrl(url);
        modifyFood.setType(type);
        this.foodDao.save(modifyFood);
        return adminPage(model, principal);
    }

    public List<Order> avaiableOrderList() {
        List<Order> allOrderList = orderDao.findAll();
        List<Order> orderList = new ArrayList<Order>();
        for (Order order : allOrderList) {

            if (order.getShipped() == false && order.getOrdered() == true) {
                order.getUser().getUsersDetail().getName();
                orderList.add(order);
            }
        }
        return orderList;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        int countItemNumber = countItemsInCart(principal.getName());
        List<User> userList = userDao.findAll();
        List<UserRole> userRoleList = userRoleDao.findAll();
        List<UserRole> userRoleAdminList = userRoleDao.findAdmin();
        List<Food> foods = foodDao.findAll();
        List<Order> orderList = avaiableOrderList();
        model.addAttribute("userList", userList);
        model.addAttribute("userRoleList", userRoleList);
        model.addAttribute("userRoleAdminList", userRoleAdminList);
        model.addAttribute("foodForm", new Food());
        model.addAttribute("foods", foods);
        model.addAttribute("orderList", orderList);
        model.addAttribute("countItemNumber", countItemNumber);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

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

        UsersDetail userDetails = userDetailDao.listbyUsername(userName2).get(0);

        model.addAttribute("userDetails", userDetails);

        return "modifyDetailsPage";
    }


    @RequestMapping(value = "/modifyDetailsSubmit", method = RequestMethod.POST)
    public String modifyDetails(Model model, Principal principal, @RequestParam("name") String name,
                                @RequestParam("username") String username, @RequestParam("email") String email,
                                @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
                                @RequestParam("password") String password,
                                @RequestParam("conFirmpassword") String conFirmpassword) {

        if (!password.equals(conFirmpassword)) {
            model.addAttribute("message", "Passwords don't equal!");
            return modifyDetailsPage(model, principal);
        } else {

            // After user login successfully.
            String userName2 = principal.getName();

            UsersDetail userDetails = userDetailDao.listbyUsername(userName2).get(0);

            UsersDetail modifyDetails = new UsersDetail(username, name, address, email, phoneNumber);
            User user = new User(userName2, password, true);
            this.userDao.save(user);
            this.userDetailDao.save(modifyDetails);
            return "welcomePage";
        }
    }

    @RequestMapping(value = "/selectOrder", method = RequestMethod.GET)
    public String selectOrder(Model model, Principal principal) {

        List<Food> allFood = this.foodDao.findAll();

        List<Food> smallPizza = new ArrayList<Food>();
        List<Food> bigPizza = new ArrayList<Food>();
        List<Food> otherFood = new ArrayList<Food>();
        List<Food> drink = new ArrayList<Food>();
        int countItemNumber = countItemsInCart(principal.getName());

        for (Food item : allFood) {
            if (item.getType().equals("pizza")) {
                if (item.getSize().equals("32")) {
                    smallPizza.add(item);
                } else {
                    bigPizza.add(item);
                }
            } else if (item.getType().equals("drink")) {
                drink.add(item);
            } else {
                otherFood.add(item);
            }
        }

        model.addAttribute("smallPizza", smallPizza);
        model.addAttribute("bigPizza", bigPizza);
        model.addAttribute("otherFood", otherFood);
        model.addAttribute("drink", drink);
        model.addAttribute("countItemNumber", countItemNumber);

        // After user login successfully.
        String userName = principal.getName();
        return "selectOrderPage";
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
    public String saveOrder(Model model, @RequestParam("name") String name, @RequestParam("username") String username,
                            @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
                            @RequestParam("address") String address, @RequestParam("password") String password,
                            @RequestParam("conFirmpassword") String conFirmpassword) {


        if (!password.equals(conFirmpassword)) {
            model.addAttribute("message", "Passwords don't equal!");
            return signUpPage(model);
        } else if (userDao.userByUsername(username) != null) {
            model.addAttribute("message", "Username already exists!");
            return signUpPage(model);
        } else {
            User user = new User(username, password, true);
            userDao.save(user);
            UsersDetail usersDetail = new UsersDetail(username, name, address, email, phoneNumber, user);
            userDetailDao.save(usersDetail);

            UserRole userRole = new UserRole(user, "USER");
            userRoleDao.save(userRole);


            return "loginPage";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage(Model model) {

        return "signUpPage";
    }

    @RequestMapping("/remove/{username}")
    public String removePerson(Model model, Principal principal, @PathVariable("username") String username) {

        this.userDetailDao.removeUserDetails(username);
        this.userRoleDao.removeUserRole(username);
        this.userDao.removeUser(username);
        return adminPage(model, principal);
    }

    @RequestMapping("/removeItem/{itemId}")
    public String removePerson(Model model, Principal principal, @PathVariable("itemId") int id) {

        this.itemDao.removeItem(id);
        return cartPage(model, principal);
    }

    @RequestMapping("/addAdmin/{username}")
    public String addAdmin(Model model, Principal principal, @PathVariable("username") String username) {

        User user = userDao.userByUsername(username);
        UserRole userRole = new UserRole(user, "ADMIN");
        this.userRoleDao.save(userRole);
        return adminPage(model, principal);
    }

    @RequestMapping("/depriveAdmin/{username}")
    public String depriveAdmin(Model model, Principal principal, @PathVariable("username") String username) {

        this.userRoleDao.removeUserRole(username);
        User user = userDao.userByUsername(username);
        UserRole userRole = new UserRole(user, "USER");
        this.userRoleDao.save(userRole);
        return adminPage(model, principal);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartPage(Model model, Principal principal) {

        List<Order> orderList = orderDao.orderByUsername(principal.getName());
        int countItemNumber = countItemsInCart(principal.getName());

        int allPrice = 0;
        String price = "0";
        List<Item> itemList = new ArrayList<Item>();

        for (Order order : orderList) {

            if (order.getOrdered() == false) {

                itemList = order.getItems();

                for (Item item : itemList) {
                    allPrice = allPrice + item.getPrice();
                }

                price = Integer.toString(allPrice);

                if (price.length() == 4) {
                    price = price.substring(0, 1) + " " + price.substring(1, price.length());
                } else if (price.length() > 4) {
                    price = price.substring(0, 2) + " " + price.substring(2, price.length());
                }
            }
        }

        model.addAttribute("countItemNumber", countItemNumber);
        model.addAttribute("orders", itemList);
        model.addAttribute("inAll", price);

        return "cartPage";
    }


    @RequestMapping(value = "/orderIt", method = RequestMethod.POST)
    public String orderIt(Model model, Principal principal) {


        List<Order> orderList = orderDao.orderByUsername(principal.getName());

        if (!orderList.isEmpty()) {
            for (Order order : orderList) {

                if (order.getOrdered() == false && !order.getItems().isEmpty()) {

                    int price = 0;
                    for (Item item : order.getItems()) {
                        price = price + item.getPrice();
                    }

                    order.setOrdered(true);
                    order.setDate(new Date());
                    order.setPrice(price);
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
    public String modifyItemModal(Model model, @PathVariable("id") int id) {
        Item myItem = this.itemDao.getItemById(id);

        model.addAttribute("myItem", myItem);
        return "modifyItem";
    }

    @RequestMapping(value = "/showItems/{id}", method = RequestMethod.GET)
    public String showItems(Model model, @PathVariable("id") int id) {

        List<Item> itemList = this.orderDao.getOrderById(id).getItems();

        model.addAttribute("itemList", itemList);
        return "showItemsList";
    }


    @RequestMapping(value = "/orderDelivered/{id}", method = RequestMethod.GET)
    public String orderDelivered(Model model, Principal principal, @PathVariable("id") int id) {
        Order order = this.orderDao.getOrderById(id);

        order.setShipped(true);
        this.orderDao.save(order);

        return adminPage(model, principal);
    }

    @RequestMapping(value = "/modifyItemSub", method = RequestMethod.POST)
    public String modifyItem(Model model, Principal principal, @RequestParam("id") int id, @RequestParam("quantity") int quantity) {

        Item item = this.itemDao.getItemById(id);
        item.setQuantity(quantity);
        item.setPrice(quantity * item.getFood().getPrice());
        this.itemDao.save(item);
        return cartPage(model, principal);
    }

    public int countItemsInCart(String username) {
        List<Order> orderList = this.orderDao.orderByUsername(username);
        for (Order order : orderList) {

            if (order.getOrdered() == false) {
                return order.getItems().size();
            }
        }
        return 0;
    }
}
package com.pizzashop.controller;

import com.pizzashop.food.entity.Food;
import com.pizzashop.food.service.FoodService;
import com.pizzashop.item.entity.Item;
import com.pizzashop.item.service.ItemService;
import com.pizzashop.order.entity.Order;
import com.pizzashop.order.entity.OrderStatus;
import com.pizzashop.order.service.OrderService;
import com.pizzashop.user.entity.User;
import com.pizzashop.user.service.UserService;
import com.pizzashop.userdetail.entity.UserDetail;
import com.pizzashop.userdetail.service.UserDetailService;
import com.pizzashop.userrole.entity.UserRole;
import com.pizzashop.userrole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService roleService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDetailService userDetailsService;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {

        List<Food> foodList = this.foodService.findAll();
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


    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String aboutPage(Model model) {
        return "aboutPage";
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public String save(Model model, Principal principal, @ModelAttribute("foodForm") Food f) {
        this.foodService.save(f);

        return adminPage(model, principal);
    }

    @RequestMapping(value = "/adToChart")
    public String adToChart(Model model, Principal principal, @RequestParam("id") int id, @RequestParam("quantity") int quantity) {

        Date date = new Date();
        User user = userService.userByUsername(principal.getName());
        Food food = foodService.getFoodById(id);
        int price = food.getPrice() * quantity;

        if (orderService.getOrdesByUsername(user.getUsername()) == null) {
            Order order = new Order(user, date, OrderStatus.IN_CART, 0);
            orderService.save(order);

            Item item = new Item(order, food, quantity, price);
            itemService.save(item);
        } else {

            List<Order> orderList = orderService.getOrdesByUsername(user.getUsername());
            Boolean flag = false;

            for (Order order : orderList) {

                if (order.getOrderStatus().equals(OrderStatus.IN_CART)) {

                    if (quantity > 1)
                    {
                        for(int i = 0; i < quantity; i++)
                        {
                            Item item = new Item(order, food, 1, price);
                            itemService.save(item);
                            flag = true;
                        }
                    }
                    else
                    {
                        Item item = new Item(order, food, quantity, price);
                        itemService.save(item);
                        flag = true;
                    }
                }
            }

            if (!flag) {
                Order order = new Order(user, date, OrderStatus.IN_CART, 0);
                orderService.save(order);


                if (quantity > 1)
                {
                    for(int i = 0; i < quantity; i++)
                    {
                        Item item = new Item(order, food, 1, price);
                        itemService.save(item);
                    }
                }
                else
                {
                    Item item = new Item(order, food, quantity, price);
                    itemService.save(item);
                }
            }
        }
        return selectOrder(model, principal);
    }

    @RequestMapping(value = "/removeFood/{id}")
    public String removeFood(Model model, Principal principal, @PathVariable("id") int id) {
        this.itemService.removeItemByFood(Integer.toHexString(id));
        this.foodService.removeFood(id);
        return adminPage(model, principal);
    }

    @RequestMapping(value = "/modifyFoodModal/{id}", method = RequestMethod.GET)
    public String modifyFoodModal(Model model, @PathVariable("id") int id) {
        Food modifyFood = this.foodService.getFoodById(id);
        model.addAttribute("modifyFood", modifyFood);
        return "modifyFood";
    }


    @RequestMapping(value = "/modifyFood", method = RequestMethod.POST)
    public String modifyFood(Model model, Principal principal, @RequestParam("name") String name,
                             @RequestParam("price") int price, @RequestParam("url") String url,
                             @RequestParam("ingredients") String ingredients, @RequestParam("type") String type,
                             @RequestParam("size") String size) {

        Food modifyFood = this.foodService.foodByName(name).get(0);
        modifyFood.setIngredients(ingredients);
        modifyFood.setPrice(price);
        modifyFood.setSize(size);
        modifyFood.setUrl(url);
        modifyFood.setType(type);
        this.foodService.save(modifyFood);
        return adminPage(model, principal);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        prepaerdItem();

        List<Order> allOrderList = orderService.findAll();
        List<Order> preparedList = preparedOrders(allOrderList);
        List<Order> orderedList = orderedOrders(allOrderList);
        List<Order> shippingList = shippingOrders(allOrderList);
        List<Order> deliveredList = deliveredOrders(allOrderList);

        int countItemNumber = countItemsInCart(principal.getName());
        List<User> userList = userService.findAll();
        List<UserRole> userRoleList = roleService.findAll();
        List<Food> foods = foodService.findAll();

        model.addAttribute("userList", userList);
        model.addAttribute("userRoleList", userRoleList);
        model.addAttribute("foodForm", new Food());
        model.addAttribute("foods", foods);

        model.addAttribute("preparedList", preparedList);
        model.addAttribute("orderedList", orderedList);
        model.addAttribute("shippingList", shippingList);
        model.addAttribute("deliveredList", deliveredList);

        model.addAttribute("countItemNumber", countItemNumber);

        return "adminPage";
    }

    private void prepaerdItem()
    {
        List<Order> orderList = this.orderService.findAll();


        for (Order order:orderList) {

            if (order.getOrderStatus().equals(OrderStatus.ORDERED)) {
                List<Item> itemList = order.getItems();
                int flag = 0;
                for (Item item : itemList) {
                    if (item.isCooked()) {
                        flag = flag + 1;
                    }
                }

                if (flag == itemList.size()) {
                    order.setOrderStatus(OrderStatus.PREPARED);
                    this.orderService.save(order);
                }
            }
        }
    }

    private List<Order> preparedOrders(List<Order> list)
    {
        List<Order> actList = new ArrayList<Order>();

        for (Order order:list) {

            if (order.getOrderStatus().equals(OrderStatus.PREPARED))
            {
                actList.add(order);
            }
        }
        return  actList;
    }

    private List<Order> orderedOrders(List<Order> list)
    {
        List<Order> actList = new ArrayList<Order>();

        for (Order order:list) {

            if (order.getOrderStatus().equals(OrderStatus.ORDERED))
            {
                actList.add(order);
            }
        }
        return  actList;
    }

    private List<Order> shippingOrders(List<Order> list)
    {
        List<Order> actList = new ArrayList<Order>();

        for (Order order:list) {

            if (order.getOrderStatus().equals(OrderStatus.SHIPPING))
            {
                actList.add(order);
            }
        }
        return  actList;
    }


    private List<Order> deliveredOrders(List<Order> list)
    {
        List<Order> actList = new ArrayList<Order>();

        for (Order order:list) {

            if (order.getOrderStatus().equals(OrderStatus.DELIVERED))
            {
                actList.add(order);
            }
        }
        return  actList;
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

        User user = userService.userByUsername(userName2);
        model.addAttribute("user", user);

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

            UserDetail userDetail = userService.userByUsername(userName2).getUserDet();

            userDetail.setAddress(address);
            userDetail.setEmail(email);
            userDetail.setName(name);
            userDetail.setPhoneNumber(phoneNumber);

            this.userDetailsService.save(userDetail);
            User user = new User(userName2, password, true, userDetail);
            this.userService.save(user);

            return "welcomePage";
        }
    }

    @RequestMapping(value = "/selectOrder", method = RequestMethod.GET)
    public String selectOrder(Model model, Principal principal) {

        List<Food> allFood = this.foodService.findAll();

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
        } else if (userService.userByUsername(username) != null) {
            model.addAttribute("message", "Username already exists!");
            return signUpPage(model);
        } else {
            UserDetail userDetail = new UserDetail(name, address, email, phoneNumber);
            userDetailsService.save(userDetail);
            User user = new User(username, password, true, userDetail);
            userService.save(user);


            UserRole userRole = new UserRole(user, "USER");
            roleService.save(userRole);


            return "loginPage";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage(Model model) {

        return "signUpPage";
    }

    @RequestMapping("/removeMySelf")
    public String removePersonMyself(Model model, Principal principal) {

        String username = principal.getName();

        int userDetails = userService.userByUsername(username).getUserDet().getId();
        this.roleService.removeUserRoleByUsername(username);
        this.userService.removeUser(username);
        this.userDetailsService.removeUserDetailById(userDetails);

        SecurityContextHolder.clearContext();
        return "loginPage";
    }

    @RequestMapping("/remove/{username}")
    public String removePerson(Model model, Principal principal, @PathVariable("username") String username) {


        int userDetails = userService.userByUsername(username).getUserDet().getId();
        this.roleService.removeUserRoleByUsername(username);
        this.userService.removeUser(username);
        this.userDetailsService.removeUserDetailById(userDetails);
        return adminPage(model, principal);
    }

    @RequestMapping("/removeItem/{itemId}")
    public String removePerson(Model model, Principal principal, @PathVariable("itemId") int id) {

        this.itemService.removeItem(id);
        return cartPage(model, principal);
    }


    @RequestMapping("/addAdmin/{username}")
    public String addAdmin(Model model, Principal principal, @PathVariable("username") String username) {

        User user = userService.userByUsername(username);
        UserRole userRole = new UserRole(user, "ADMIN");
        this.roleService.save(userRole);
        return adminPage(model, principal);
    }

    @RequestMapping("/addPermission")
    public  String addPermission(Model model, Principal principal, @RequestParam("permission") String permission, @RequestParam("username") String username)
    {
        User user = userService.userByUsername(username);

        List<UserRole> roles = roleService.findAll();
        List<UserRole> roleList = new ArrayList<UserRole>();
        int flag = 0;
        for (UserRole userRole: roles) {
            if(userRole.getUser().getUsername().equals(username))
            {
                roleList.add(userRole);
            }
        }


        for (UserRole role:roleList) {
            if(!role.getUserRole().equals(permission))
            {
                flag = flag + 1;
            }
        }

        if (flag == roleList.size())
        {
            UserRole userRole = new UserRole(user, permission);
            this.roleService.save(userRole);
        }

        return adminPage(model, principal);
    }

    @RequestMapping("/deprivePermission")
    public  String deprivePermission(Model model, Principal principal, @RequestParam("permission") String permission, @RequestParam("username") String username)
    {
        List<UserRole> roles = roleService.findAll();
        List<UserRole> roleList = new ArrayList<UserRole>();

        for (UserRole userRole: roles) {
            if(userRole.getUser().getUsername().equals(username))
            {
                roleList.add(userRole);
            }
        }

        for (UserRole role:roleList) {

            if(role.getUserRole().equals(permission))
            {
                this.roleService.removeUserRoleByID(role.getId());
            }
        }

        return adminPage(model, principal);
    }


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartPage(Model model, Principal principal) {

        List<Order> orderList = orderService.getOrdesByUsername(principal.getName());
        int countItemNumber = countItemsInCart(principal.getName());

        int allPrice = 0;
        String price = "0";
        List<Item> itemList = new ArrayList<Item>();

        for (Order order : orderList) {

            if (order.getOrderStatus().equals(OrderStatus.IN_CART)) {

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


        List<Order> orderList = orderService.getOrdesByUsername(principal.getName());

        if (!orderList.isEmpty()) {
            for (Order order : orderList) {

                if (order.getOrderStatus().equals(OrderStatus.IN_CART)&& !order.getItems().isEmpty()) {

                    int price = 0;
                    for (Item item : order.getItems()) {
                        price = price + item.getPrice();
                    }

                    order.setOrderStatus(OrderStatus.ORDERED);
                    order.setDate(new Date());
                    order.setPrice(price);
                    orderService.save(order);
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


    @RequestMapping(value = "/showItems/{id}", method = RequestMethod.GET)
    public String showItems(Model model, @PathVariable("id") int id) {

        List<Item> itemList = this.orderService.getOrderById(id).getItems();

        model.addAttribute("itemList", itemList);
        return "showItemsList";
    }

    @RequestMapping(value = "/modifyItemSub", method = RequestMethod.POST)
    public String modifyItem(Model model, Principal principal, @RequestParam("id") int id, @RequestParam("quantity") int quantity) {

        Item item = this.itemService.getItemById(id);
        item.setQuantity(quantity);
        item.setPrice(quantity * item.getFood().getPrice());
        this.itemService.save(item);
        return cartPage(model, principal);
    }

    public int countItemsInCart(String username) {
        List<Order> orderList = this.orderService.getOrdesByUsername(username);
        for (Order order : orderList) {

            if (order.getOrderStatus().equals(OrderStatus.IN_CART)) {
                return order.getItems().size();
            }
        }
        return 0;
    }

    @RequestMapping(value = "/cook", method = RequestMethod.GET)
    public String cookPage(Model model, Principal principal) {

        List<Order> orderList = orderService.findAll();
        List<Item> items = new ArrayList<Item>();

        for (Order order:orderList) {
            if (order.getOrderStatus().equals(OrderStatus.ORDERED))
            {
                for (Item item:order.getItems()) {
                    if (!(item.isCooked()))
                    {
                        items.add(item);
                    }
                }
            }
        }

        model.addAttribute("items", items);
        return "cookPage";
    }



    @RequestMapping(value = "/cooked")
    public String cooked(Model model, Principal principal, @RequestParam("id") int id) {

        Item item = itemService.getItemById(id);
        item.setCooked(true);

        this.itemService.save(item);

        return cookPage(model, principal);
    }


    @RequestMapping(value = "/shipper", method = RequestMethod.GET)
    public String shipperPage(Model model, Principal principal) {

        prepaerdItem();

        List<Order> orderList = orderService.findAll();
        List<Order> orderPreparedList = new ArrayList<Order>();
        List<Order> orderShippingList = new ArrayList<Order>();

        for (Order order:orderList) {
            if (order.getOrderStatus().equals(OrderStatus.PREPARED))
            {
              orderPreparedList.add(order);
            }
            else if (order.getOrderStatus().equals(OrderStatus.SHIPPING))
            {
                orderShippingList.add(order);
            }
        }

        model.addAttribute("orderPreparedList", orderPreparedList);
        model.addAttribute("orderShippingList", orderShippingList);
        return "shipperPage";
    }


    @RequestMapping(value = "/nextStatus")
    public String nextStatus(Model model, Principal principal, @RequestParam("id") int id) {

        Order order = orderService.getOrderById(id);

        User user = userService.userByUsername(principal.getName());

        if (order.getOrderStatus().equals(OrderStatus.PREPARED))
        {
            order.setOrderStatus(OrderStatus.SHIPPING);
            order.setShipper(user);
        }
        else
        {
            order.setOrderStatus(OrderStatus.DELIVERED);
        }

        this.orderService.save(order);

        return shipperPage(model, principal);
    }

}
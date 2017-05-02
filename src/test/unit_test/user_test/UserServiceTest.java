package user_test;

import com.pizzashop.food.dao.FoodDao;
import com.pizzashop.food.entity.Food;
import com.pizzashop.food.service.FoodServiceImp;
import com.pizzashop.order.entity.Order;
import com.pizzashop.order.entity.OrderStatus;
import com.pizzashop.user.dao.UserDao;
import com.pizzashop.user.entity.User;
import com.pizzashop.user.service.UserService;
import com.pizzashop.user.service.UserServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    public UserServiceImp userService;

    @Mock
    public UserDao userDao;

    @Before
    public void setUp() {

        List<User> users = new ArrayList<User>();
        users.add(createUser());

        when(userDao.findAll()).thenReturn(users);
        when(userDao.userByUsername("admin")).thenReturn(createUser());
    }

    @Test
    public void userServiceTest() {
        List<User> userList = userService.findAll();
        User user = userService.userByUsername("admin");

        Assert.assertNotNull(userList);
        Assert.assertEquals("admin", user.getUsername());
    }

    public User createUser()
    {
        return new User("admin","admin", true);
    }
}

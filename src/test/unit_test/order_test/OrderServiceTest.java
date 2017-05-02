package order_test;

import com.pizzashop.food.dao.FoodDao;
import com.pizzashop.food.entity.Food;
import com.pizzashop.food.service.FoodServiceImp;
import com.pizzashop.item.entity.Item;
import com.pizzashop.order.dao.OrderDao;
import com.pizzashop.order.entity.Order;
import com.pizzashop.order.entity.OrderStatus;
import com.pizzashop.order.service.OrderServiceImp;
import com.pizzashop.user.entity.User;
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
public class OrderServiceTest {

    @InjectMocks
    public OrderServiceImp orderService;

    @Mock
    public OrderDao orderDao;

    @Before
    public void setUp() {

        List<Order> orders = new ArrayList<Order>();
        orders.add(createOrder());

        when(orderDao.findAll()).thenReturn(orders);
        when(orderDao.getOrderById(5)).thenReturn(createOrder());
        when(orderDao.orderByUsername("admin")).thenReturn(orders);
    }

    @Test
    public void orderServiceTest() {
        List<Order> orderList = orderService.findAll();

        List<Order> orderListByUsername = orderService.findAll();

        Order order = orderService.getOrderById(5);
        Assert.assertNotNull(orderList);
        Assert.assertNotNull(orderListByUsername);
        Assert.assertEquals(order.getPrice(), 1500);

    }

    public Order createOrder()
    {
        User user = new User("admin","admin", true);
        return new Order(user, new Date(), OrderStatus.ORDERED,1500);
    }
}

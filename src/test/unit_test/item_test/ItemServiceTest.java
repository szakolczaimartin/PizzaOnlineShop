package item_test;

import com.pizzashop.food.dao.FoodDao;
import com.pizzashop.food.entity.Food;
import com.pizzashop.food.service.FoodServiceImp;
import com.pizzashop.item.dao.ItemDao;
import com.pizzashop.item.entity.Item;
import com.pizzashop.item.service.ItemServiceImp;
import com.pizzashop.order.entity.Order;
import com.pizzashop.order.entity.OrderStatus;
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
public class ItemServiceTest {

    @InjectMocks
    public ItemServiceImp itemService;

    @Mock
    public ItemDao itemDao;

    @Before
    public void setUp() {

        List<Item> items = new ArrayList<Item>();
        items.add(createItem());
        when(itemDao.findAll()).thenReturn(items);
        when(itemDao.getItemById(5)).thenReturn(createItem());
    }


    @Test
    public void itemServiceTest() {
        List<Item> items = itemService.findAll();
        Item item = createItem();
        Assert.assertNotNull(items);
        Assert.assertEquals(item.getPrice(), 1500);
    }


    public Item createItem()
    {
        Food food = new Food();
        food.setType("pizza");
        food.setId(5);
        food.setPrice(500);
        food.setIngredients("salami");
        food.setName("hawai");
        food.setSize("32");
        food.setUrl("url_test");

        User user = new User("admin","admin", true);
        Order order = new Order(user, new Date(), OrderStatus.ORDERED,1500);
        return new Item(order, food,15,1500);
    }
}

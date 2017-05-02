package food_test;

import com.pizzashop.food.dao.FoodDao;
import com.pizzashop.food.entity.Food;
import com.pizzashop.food.service.FoodService;
import com.pizzashop.food.service.FoodServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FoodServiceTest {

    @InjectMocks
    public FoodServiceImp foodService;

    @Mock
    public FoodDao foodDao;

    @Before
    public void setUp() {

        List<Food> foods = new ArrayList<Food>();
        Food food = new Food();
        foods.add(createFood());

        when(foodDao.findAll()).thenReturn(foods);
        when(foodDao.getFoodById(5)).thenReturn(food);
        when(foodDao.foodByName("hawai")).thenReturn(foods);

    }

    @Test
    public void foodServiceTest() {
        List<Food> foodList = foodService.findAll();
        Food food = foodService.getFoodById(5);
        List<Food> foodsByName = foodService.foodByName("hawai");

        Assert.assertNotNull(foodList);
        Assert.assertNotNull(foodsByName);
        Assert.assertNotNull(food);
    }


    public Food createFood()
    {
        Food food = new Food();
        food.setType("pizza");
        food.setId(5);
        food.setPrice(500);
        food.setIngredients("salami");
        food.setName("hawai");
        food.setSize("32");
        food.setUrl("url_test");

        return food;
    }

}

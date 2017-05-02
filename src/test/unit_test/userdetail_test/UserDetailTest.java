package userdetail_test;

import com.pizzashop.user.dao.UserDao;
import com.pizzashop.user.entity.User;
import com.pizzashop.user.service.UserServiceImp;
import com.pizzashop.userdetail.dao.UserDetailDao;
import com.pizzashop.userdetail.entity.UserDetail;
import com.pizzashop.userdetail.service.UserDetailServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailTest {

    @InjectMocks
    public UserDetailServiceImp userDetailService;

    @Mock
    public UserDetailDao userDetailDao;

    @Before
    public void setUp() {

        List<UserDetail> userDetails = new ArrayList<UserDetail>();
        userDetails.add(createUserDetail());

        when(userDetailDao.listbyUsername("admin")).thenReturn(userDetails);
        when(userDetailDao.getDetailById(5)).thenReturn(createUserDetail());
    }

    @Test
    public void userDetailServiceTest() {
        List<UserDetail> userDetailList = userDetailService.listbyUsername("admin");
        UserDetail userDetail = userDetailDao.getDetailById(5);

        Assert.assertNotNull(userDetailList);
        Assert.assertEquals("admin", userDetail.getName());
    }

    public UserDetail createUserDetail()
    {
        return new UserDetail("admin","test","test@email.com","test_number");
    }
}

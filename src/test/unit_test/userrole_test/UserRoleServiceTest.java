package userrole_test;

import com.pizzashop.user.entity.User;
import com.pizzashop.userrole.dao.UserRoleDao;
import com.pizzashop.userrole.entity.UserRole;
import com.pizzashop.userrole.service.UserRoleServiceImp;
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
public class UserRoleServiceTest {

    @InjectMocks
    public UserRoleServiceImp userRoleService;

    @Mock
    public UserRoleDao userRoleDao;

    @Before
    public void setUp() {

        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles.add(createUserRole());

        when(userRoleDao.findAll()).thenReturn(userRoles);
        when(userRoleDao.getUserRoleById(5)).thenReturn(createUserRole());
    }

    @Test
    public void userRoleServiceTest() {
        List<UserRole> userRoleList = userRoleService.findAll();
        UserRole userRole = userRoleService.getUserRoleById(5);

        Assert.assertNotNull(userRoleList);
        Assert.assertEquals("test", userRole.getUserRole());
    }

    public UserRole createUserRole() {
        return new UserRole(new User("admin", "admin", true), "test");
    }
}

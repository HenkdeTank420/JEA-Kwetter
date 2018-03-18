package services;

import dao.JPA.Interface.IRoleDao;
import domain.Role;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

    private Role role;
    private RoleService roleService;

    @Mock
    private IRoleDao roleDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        roleService = new RoleService(roleDao);
    }

}

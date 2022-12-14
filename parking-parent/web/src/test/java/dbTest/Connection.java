package dbTest;


import entity.Admin;
import mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.api.AdminService;
import service.impl.AdminServiceImpl;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class Connection {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;
    
    @Test
    public void testConnect() throws SQLException {
        java.sql.Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    @Test
    public void testMap() {
        System.out.println(adminMapper.selectByPrimaryKey(1));
    }

    @Test
    public void testTx() {

        adminService.saveAdmin("lhj", "123");
    }
}

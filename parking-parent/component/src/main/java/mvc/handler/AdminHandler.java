package mvc.handler;

import constants.ConstAttributes;
import constants.ConstPages;
import entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.api.AdminService;

import javax.servlet.http.HttpSession;

@Controller
public class AdminHandler {
    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping("admin/login/page.html")
    public String adminLogin() {

        return ConstPages.ADMIN_LOGIN_PAGE;
    }

    @RequestMapping("admin/do/login/page.html")
    public String adminDoLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        logger.info("username="+username+"\npassword=" + password);

        // return <admin> object on success, throw exception on failure
        Admin admin = adminService.getAdminOnLogin(username, password);

        session.setAttribute(ConstAttributes.ATTR_LOGIN_ADMIN, admin);
        return "temp";
    }
}

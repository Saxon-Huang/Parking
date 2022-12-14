package mvc.handler;

import com.github.pagehelper.PageInfo;
import constants.ConstAttributes;
import constants.ConstPages;
import entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/admin/main.html";
    }

    @RequestMapping("admin/get/page.html")
    public String getPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            ModelMap modelMap
    ) {
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        modelMap.addAttribute(ConstAttributes.ATTR_PAGE_INFO, pageInfo);
        return ConstPages.ADMIN_MANAGE_ADMIN;
    }

    @RequestMapping("admin/add/admin.do")
    public String addAdmin(@RequestParam("username") String admAcct, @RequestParam("password") String admPswd) {
        adminService.saveAdmin(admAcct, admPswd);

        return "redirect:/admin/get/page.html?pageNum=" + Integer.MAX_VALUE;
    }

    @RequestMapping("admin/remove/admin/{admId}/{pageNum}/{keyword}.do")
    public String removeAdmin(@PathVariable("admId") Integer admId, @PathVariable("pageNum") Integer pageNum, @PathVariable("keyword") String keyword) {
        adminService.removeAdmin(admId);
        return "redirect:/admin/get/page.html?keyword=" + keyword + "&pageNum=" + pageNum;
    }
}

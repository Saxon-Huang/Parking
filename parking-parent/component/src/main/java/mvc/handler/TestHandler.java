package mvc.handler;

import entity.Admin;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.AdminService;
import utility.ResultEntity;

import java.util.List;

@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap) {

        List<Admin> adminList = adminService.getAll();
        Object obj = null;
        obj.toString();

        modelMap.addAttribute("adminList", adminList);

        return "target";
    }

    @ResponseBody
    @RequestMapping("/send/array.html")
    public ResultEntity<List<Integer>> testReceiveArray(@RequestBody List<Integer> array) {
        logger.info("test receive array");
        for (Integer i : array) System.out.println(i);

        ResultEntity<List<Integer>> resultEntity = ResultEntity.successWithData(array);

        return resultEntity;
    }


    @RequestMapping("/error0.html")
    public String testError(String str) {
        String s = null;
        s.length();
        return "???";
    }
}

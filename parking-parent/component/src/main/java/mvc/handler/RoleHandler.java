package mvc.handler;

import com.github.pagehelper.PageInfo;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.RoleService;
import utility.ResultEntity;

@Controller
public class RoleHandler {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/admin/get/role/page.json")
    public ResultEntity<PageInfo<Role>> getRolePageInfo(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword
    ) {
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
        return ResultEntity.successWithData(pageInfo); // 异常映射系统负责在异常时返回ResultEntity.failed() json
    }

    @ResponseBody
    @RequestMapping("/admin/add/role.json")
    public ResultEntity<String> addRole(@RequestParam(value = "roleName", defaultValue = "") String roleName) {
        roleService.saveRole(new Role(null, roleName));

        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/admin/remove/role.json")
    public ResultEntity<String> removeRole(@RequestParam(value = "roleId") Integer roleId) {
        roleService.removeRole(roleId);

        return ResultEntity.successWithoutData();
    }

}

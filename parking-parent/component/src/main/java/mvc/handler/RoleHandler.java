package mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.api.RoleService;

@Controller
public class RoleHandler {

    @Autowired
    private RoleService roleService;


}

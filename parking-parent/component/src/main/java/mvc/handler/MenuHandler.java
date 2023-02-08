package mvc.handler;

import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.MenuService;
import utility.ResultEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuHandler {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/menu/get/nodes.json")
    ResultEntity<Menu> getNodes() {
        List<Menu> menuList = menuService.getAllMenu();
        Integer ROOT = 1;
        Map<Integer, Menu> menuMap = new HashMap<>();

        for (Menu node : menuList ) {
            menuMap.put(node.getmId(), node);
        }
        for (Menu node : menuList ) {
            if (node.getParentMId() == 0) continue;
            menuMap.get(node.getParentMId()).getChildren().add(menuMap.get(node.getmId()));
        }
        
        return ResultEntity.successWithData(menuMap.get(ROOT));
    }
}

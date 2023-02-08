package service.impl;

import entity.Menu;
import entity.MenuExample;
import mapper.MenuMapper;
import mvc.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.api.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> getAllMenu() {
        List<Menu> menuList = menuMapper.selectByExample(new MenuExample());
        return menuList;
    }
}

package service.impl;

import mapper.RoleMapper;
import mvc.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.api.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);
}

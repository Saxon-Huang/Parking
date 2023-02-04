package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import constants.ErrorMessages;
import entity.Role;
import exceptions.AddAdminException;
import mapper.RoleMapper;
import mvc.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import service.api.RoleService;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);


    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = roleMapper.selectRoleByKeyword(keyword);
        return new PageInfo<>(roleList);
    }

    @Override
    public Integer saveRole(Role role) {
        int affected = 0;
//        try {
//            affected = roleMapper.insert(role);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            logger.info(e.getClass().getName());
//            if (e instanceof DuplicateKeyException) {
//                throw new AddAdminException(ErrorMessages.ADD_DUPLICATE_ROLE);
//            }
//        }
        affected = roleMapper.insert(role);
        return affected;
    }

    @Override
    public Integer removeRole(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }
}

package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import constants.ErrorMessages;
import entity.Admin;
import entity.AdminExample;
import exceptions.AddAdminException;
import exceptions.LoginFailedException;
import mapper.AdminMapper;
import mvc.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import service.api.AdminService;
import utility.Security;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @Override
    public void saveAdmin(String admAcct, String admPswd) {
        // 1. valid inputs?
        // never used
        if (admAcct.length() == 0 || admPswd.length() == 0) {
            throw new AddAdminException(ErrorMessages.ADD_DUPLICATE_ADMIN_ACCOUNT); // TODO: create new exception
        }

        // 2. account exist?
        /*
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdmAcctEqualTo(admAcct);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size() > 1) {
            throw new LoginFailedException(ErrorMessages.INVALID_USERNAME); // TODO: create new exception
        }
        */
        try {
            String encodedPswd = Security.md5(admPswd);
            Admin admin = new Admin(null, admAcct, encodedPswd);
            adminMapper.insertAdmin(admin);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getClass().getName());
            if (e instanceof DuplicateKeyException) {
                throw new AddAdminException(ErrorMessages.ADD_DUPLICATE_ADMIN_ACCOUNT);
            }
        }




    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminOnLogin(String username, String password) {
        // 1. username exist ?
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdmAcctEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);

        if (admins == null || admins.isEmpty())
            throw new LoginFailedException(ErrorMessages.INVALID_USERNAME);
         if (admins.size() > 1)
            throw new RuntimeException(ErrorMessages.SYSTEM_REPLICATED_USER);

        // 2. password valid ?
        Admin admin = admins.get(0);
        String realPassword = admin.getAdmPswd();
        String inputPassword = Security.md5(password);

        if (!Objects.equals(realPassword, inputPassword)) {
            throw new LoginFailedException(ErrorMessages.WRONG_PASSWORD);
        }

        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectAdminByKeyword(keyword);
        return new PageInfo<>(admins);
    }

}

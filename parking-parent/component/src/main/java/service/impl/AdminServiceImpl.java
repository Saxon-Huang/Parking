package service.impl;

import constants.ErrorMessages;
import entity.Admin;
import entity.AdminExample;
import exceptions.LoginFailedException;
import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.api.AdminService;
import utility.Security;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
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

}

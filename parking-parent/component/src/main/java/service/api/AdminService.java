package service.api;

import com.github.pagehelper.PageInfo;
import entity.Admin;

import java.util.List;

public interface AdminService {
    void saveAdmin(String admAcct, String admPswd);

    List<Admin> getAll();

    Admin getAdminOnLogin(String username, String password);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void removeAdmin(Integer admId);
}

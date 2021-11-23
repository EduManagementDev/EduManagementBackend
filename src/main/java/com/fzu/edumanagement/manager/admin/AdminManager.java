package com.fzu.edumanagement.manager.admin;

import com.fzu.edumanagement.dao.AdminDAO;
import com.fzu.edumanagement.manager.BaseManager;
import com.fzu.edumanagement.model.entity.AdminEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminManager extends BaseManager {
    private final AdminDAO adminDAO;

    public AdminManager(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public AdminEntity get(Integer id) {
        return adminDAO.get(id);
    }

    public int create(AdminEntity entity) {
        return adminDAO.insert(entity);
    }

    public int update(AdminEntity entity) {
        return adminDAO.update(entity);
    }

    public int delete(Integer id) {
        return adminDAO.delete(id);
    }

    public List<AdminEntity> list() {
        return adminDAO.list();
    }
}

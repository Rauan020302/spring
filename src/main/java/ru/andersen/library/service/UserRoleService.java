package ru.andersen.library.service;

import ru.andersen.library.entity.UserRole;
import ru.andersen.library.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAllUserRoles();
    UserRole getRoleById(Long id);
    UserRole deleteRoleById(Long id);
    UserRole updateRoleById(UserRoleModel userRoleModel,Long id);
    UserRole saveRole(UserRole userRole);
    UserRole saveRole(UserRoleModel userRoleModel);
}

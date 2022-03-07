package ru.andersen.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andersen.library.entity.User;
import ru.andersen.library.entity.UserRole;
import ru.andersen.library.model.UserRoleModel;
import ru.andersen.library.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public UserRole saveUserRole(@RequestBody UserRoleModel userRoleModel) {
        return userRoleService.saveRole(userRoleModel);
    }
    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }
    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id){
        return userRoleService.getRoleById(id);
    }
    @DeleteMapping("/{id}")
    public UserRole deleteUserRoleById(@PathVariable Long id) {
        return userRoleService.deleteRoleById(id);
    }
    @PutMapping("/{id}")
    public UserRole updateUserRoleById(@RequestBody UserRoleModel userRoleModel,
                                       @PathVariable Long id){
        return userRoleService.updateRoleById(userRoleModel,id);
    }
}

package ru.andersen.library.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.andersen.library.entity.User;
import ru.andersen.library.entity.UserRole;
import ru.andersen.library.exceptions.ObjectsNotFoundException;
import ru.andersen.library.model.UserRoleModel;
import ru.andersen.library.repository.UserRoleRepository;
import ru.andersen.library.service.UserRoleService;
import ru.andersen.library.service.UserService;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getRoleById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new ObjectsNotFoundException("not found User Role by id - " + id));
    }

    @Override
    public UserRole deleteRoleById(Long id) {
        UserRole userRole = getRoleById(id);
        if (userRole != null){
            userRoleRepository.delete(userRole);
            return userRole;
        }
        return null;
    }

    @Override
    public UserRole updateRoleById(UserRoleModel userRoleModel, Long id) {
        User user = userService.getUserById(userRoleModel.getUserId());
        try {
            if (user == null) throw new ObjectsNotFoundException();
            UserRole userRole = getRoleById(id);
            userRole.setRoleName(userRoleModel.getRoleName());
            userRole.setUser(user);
            return saveRole(userRole);
        }catch (ObjectsNotFoundException e){
            throw new ObjectsNotFoundException("not found User Role by id - " + id);
        }
    }

    @Override
    public UserRole saveRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole saveRole(UserRoleModel userRoleModel) {
        User user = userService.getUserById(userRoleModel.getUserId());
        try {
            if (user == null) throw new ObjectsNotFoundException();
            UserRole userRole = UserRole.builder()
                    .roleName(userRoleModel.getRoleName())
                    .user(user).build();
            return saveRole(userRole);
        }catch (ObjectsNotFoundException e){
            throw new ObjectsNotFoundException("not found User by id - " + Objects.requireNonNull(user).getId());
        }
    }
}

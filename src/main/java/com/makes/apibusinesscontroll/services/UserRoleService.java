package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.UserRoleDto;
import com.makes.apibusinesscontroll.dto.response.RoleResponse;
import com.makes.apibusinesscontroll.dto.response.UserResponse;
import com.makes.apibusinesscontroll.dto.response.UserRoleResponse;
import com.makes.apibusinesscontroll.models.Role;
import com.makes.apibusinesscontroll.models.User;
import com.makes.apibusinesscontroll.models.UserRole;
import com.makes.apibusinesscontroll.repository.RoleRepository;
import com.makes.apibusinesscontroll.repository.UserRepository;
import com.makes.apibusinesscontroll.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository urRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<UserRoleResponse> findAllL() {

        List<UserRoleResponse> responses = new ArrayList<>();
        List<UserRole> userRoles = urRepository.findAll();

        if (Objects.nonNull(userRoles)) {
            userRoles.forEach(userRole -> {

                UserResponse user = new UserResponse();
                user.setId(userRole.getUser().getId());
                user.setUsername(userRole.getUser().getUsername());
                user.setFullName(userRole.getUser().getFullName());

                RoleResponse rol = new RoleResponse();
                rol.setId(userRole.getRole().getId());
                rol.setRoleName(userRole.getRole().getRoleName());

                UserRoleResponse urr = new UserRoleResponse();
                urr.setUserRoleId(userRole.getId());
                urr.setUser(user);
                urr.setRole(rol);
                responses.add(urr);
            });
        }
        return responses;
    }

    public Optional<UserRoleResponse> findByIdResponse(Integer id) {

        UserRoleResponse responses = new UserRoleResponse();
        Optional<UserRole> userRoles = urRepository.findById(id);

        if (Objects.nonNull(userRoles)) {

            UserResponse user = new UserResponse();
            user.setId(userRoles.get().getUser().getId());
            user.setUsername(userRoles.get().getUser().getUsername());
            user.setFullName(userRoles.get().getUser().getFullName());

            RoleResponse rol = new RoleResponse();
            rol.setId(userRoles.get().getRole().getId());
            rol.setRoleName(userRoles.get().getRole().getRoleName());

            responses.setUserRoleId(userRoles.get().getId());
            responses.setUser(user);
            responses.setRole(rol);
        }
        return Optional.of(responses);
    }

    @Transactional
    public UserRole save(UserRole userRole) {
        return urRepository.save(userRole);
    }

    @Transactional
    public UserRoleDto create(UserRoleDto dto) {
        UserRoleDto response = new UserRoleDto();
        UserRole roleModel = new UserRole();

        Optional<User> user = userRepository.findById(dto.getUserId());
        Optional<Role> role = roleRepository.findById(dto.getRoleId());

        if (!user.isPresent() && !role.isPresent()) {
            roleModel.setRole(role.get());
            roleModel.setUser(user.get());
            roleModel.setCreationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
            roleModel.setCreatedBy(dto.getCreatedBy());
            urRepository.save(roleModel);

        } else {
            response = null;
        }
        return response;
    }

    @Transactional
    public void delete(UserRole role) {
        urRepository.delete(role);
    }

    public Optional<UserRole> findById(Integer id){
        return  urRepository.findById(id);
    }
}

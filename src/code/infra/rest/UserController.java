package code.infra.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import code.application.dtos.user.InRequestUser;
import code.application.dtos.user.OutFindUser;
import code.application.dtos.user.OutFindUserByEmail;
import code.application.dtos.user.OutFindUserById;
import code.application.dtos.user.OutFindUserByUsername;
import code.application.dtos.user.OutResponseUser;
import code.application.use_cases.user.read.user.FindAllUser;
import code.application.use_cases.user.read.user.FindAllUsersByEmail;
import code.application.use_cases.user.read.user.FindAllUsersByUsername;
import code.application.use_cases.user.read.user.FindUserById;
import code.application.use_cases.user.update.ActivateUserById;
import code.application.use_cases.user.update.InactivateUserById;
import code.domain.repositories.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController implements IController<InRequestUser, OutResponseUser> {

    private ActivateUserById activateUserById;
    private InactivateUserById inactivateUserById;
    private FindUserById findUserById;
    private FindAllUsersByEmail findAllUsersByEmail;
    private FindAllUsersByUsername findAllUsersByUsername;
    private FindAllUser findAllUser;

    public UserController(IUserRepository userRepository) {
        this.activateUserById = new ActivateUserById(userRepository);
        this.inactivateUserById = new InactivateUserById(userRepository);
        this.findUserById = new FindUserById(userRepository);
        this.findAllUsersByEmail = new FindAllUsersByEmail(userRepository);
        this.findAllUsersByUsername = new FindAllUsersByUsername(userRepository);
        this.findAllUser = new FindAllUser(userRepository);
    }

    @GetMapping("/{id}")
    @Override
    public OutResponseUser findById(@PathVariable(name = "id") String id) {
        OutFindUserById userFound = findUserById.execute(id);
        return new OutResponseUser(userFound.id(), userFound.username(), userFound.email());
    }

    @GetMapping
    public Collection<OutResponseUser> findAll(
        @RequestParam(name = "email") String email,
        @RequestParam(name = "username") String username) {
        if(email != null) {
            Collection<OutFindUserByEmail> users = findAllUsersByEmail.execute(email);
            return users.stream()
                    .map(user -> new OutResponseUser(user.id(), user.username(), user.email()))
                    .toList();
        } else if(username != null) {
            Collection<OutFindUserByUsername> users = findAllUsersByUsername.execute(username);
            return users.stream()
                    .map(user -> new OutResponseUser(user.id(), user.username(), user.email()))
                    .toList();
        }

        Collection<OutFindUser> users = findAllUser.execute();
        return users.stream()
                .map(user -> new OutResponseUser(user.id(), user.username(), user.email()))
                .toList();
    }

    @Override
    public OutResponseUser save(InRequestUser entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OutResponseUser update(InRequestUser entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

}

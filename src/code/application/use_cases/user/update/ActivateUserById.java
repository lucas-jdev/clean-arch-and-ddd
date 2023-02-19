package code.application.use_cases.user.update;

import java.util.Optional;

import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public record ActivateUserById(IUserRepository userRepository) {
    
    public void execute(String id) {
        Optional<User> userFound = userRepository.findById(id);
        userFound.ifPresent(User::activate);
        userFound.ifPresent(userRepository::save);
    }

}

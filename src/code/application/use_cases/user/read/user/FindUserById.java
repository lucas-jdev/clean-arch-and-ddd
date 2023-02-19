package code.application.use_cases.user.read.user;

import java.util.Optional;

import code.application.dtos.user.OutFindUserById;
import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public record FindUserById (IUserRepository userRepository) {

    public OutFindUserById execute(String id) {
        Optional<User> userFound = userRepository.findById(id);
        return userFound.map(user -> new OutFindUserById(
                user.id().toString(),
                user.username(),
                user.email(),
                user.status().toString(),
                user.password()
        )).orElse(null);
    }

}

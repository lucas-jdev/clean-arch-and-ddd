package code.application.use_cases.user.create;

import code.application.dtos.user.InnerSaveUser;
import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public record SaveUser(IUserRepository userRepository) {

    public void execute(InnerSaveUser input) {
        User user = new User(
                input.username(),
                input.email(),
                input.password());

        userRepository.save(user);
    }

}

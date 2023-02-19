package code.application.use_cases.user.update;

import code.domain.repositories.IUserRepository;

public record InactivateUserById(IUserRepository userRepository) {

    public void execute(String id) {
        userRepository.findById(id);
    }

}

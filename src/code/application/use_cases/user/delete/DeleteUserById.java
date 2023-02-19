package code.application.use_cases.user.delete;

import code.domain.repositories.IUserRepository;

public record DeleteUserById(IUserRepository userRepository) {
    
    public void execute(String id) {
        userRepository.delete(id);
    }

}

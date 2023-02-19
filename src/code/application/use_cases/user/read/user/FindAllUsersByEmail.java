package code.application.use_cases.user.read.user;

import java.util.Collection;

import code.application.dtos.user.OutFindUserByEmail;
import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public record FindAllUsersByEmail (IUserRepository userRepository) {
    
    public Collection<OutFindUserByEmail> execute(String email) {
        Collection<User> usersFound = userRepository.findByEmail(email);
        return usersFound.stream()
                .map(user -> {
                    return new OutFindUserByEmail(
                        user.id().toString(), 
                        user.username(), 
                        user.email(),
                        user.status().toString(),
                        user.password()
                    );
                })
                .toList(); 
    }

}

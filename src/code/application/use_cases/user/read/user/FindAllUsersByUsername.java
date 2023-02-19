package code.application.use_cases.user.read.user;

import java.util.Collection;

import code.application.dtos.user.OutFindUserByUsername;
import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public record FindAllUsersByUsername (IUserRepository userRepository){
    
    public Collection<OutFindUserByUsername> execute(String username) {
        Collection<User> usersFound = userRepository.findByUsername(username);
        return usersFound.stream()
                .map(user -> {
                    return new OutFindUserByUsername(
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

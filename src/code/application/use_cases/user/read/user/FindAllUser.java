package code.application.use_cases.user.read.user;

import java.util.Collection;

import code.application.dtos.user.OutFindUser;
import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public record FindAllUser(IUserRepository userRepository) {
    
    public Collection<OutFindUser> execute(){
        Collection<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            return new OutFindUser(
                user.id().toString(), 
                user.username(), 
                user.email(),
                user.status().toString(), 
                user.password());
            }
        ).toList();
    }
}

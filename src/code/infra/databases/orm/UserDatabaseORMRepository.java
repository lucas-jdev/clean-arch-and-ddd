package code.infra.databases.orm;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public class UserDatabaseORMRepository implements IUserRepository {

    private UserJPARepository userJPARepository;

    public UserDatabaseORMRepository(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        userJPARepository.deleteById(uuid);
    }

    @Override
    public Collection<User> findAll() {
        Collection<UserSchema> users = userJPARepository.findAll();
        return users.stream()
                .map(user -> {
                    return new User(
                        user.getId(), 
                        user.getUsername(), 
                        user.getEmail(), 
                        user.getPassword()
                    );
                }).toList();
    }

    @Override
    public Collection<User> findByEmail(String email) {
        return userJPARepository.findByEmail(email)
                .stream()
                .map(user -> {
                    return new User(
                        user.getId(), 
                        user.getUsername(), 
                        user.getEmail(), 
                        user.getPassword()
                    );
                }).toList();
    }

    @Override
    public Optional<User> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return userJPARepository.findById(uuid)
                .map(user -> {
                    return new User(
                        user.getId(), 
                        user.getUsername(), 
                        user.getEmail(), 
                        user.getPassword()
                    );
                });
    }

    @Override
    public Collection<User> findByUsername(String username) {
        return userJPARepository.findByUsername(username)
                .stream()
                .map(user -> {
                    return new User(
                        user.getId(), 
                        user.getUsername(), 
                        user.getEmail(), 
                        user.getPassword()
                    );
                }).toList();
    }

    @Override
    public void save(User user) {
        UserSchema userSchema = new UserSchema(
            user.id(), 
            user.username(), 
            user.email(), 
            user.password()
        );
        userJPARepository.save(userSchema);
    }

    @Override
    public void update(User user) {
        Optional<UserSchema> userFound = userJPARepository.findById(user.id());

        if(userFound.isPresent()){
            UserSchema userSchema = userFound.get();
            userSchema.setUsername(user.username());
            userSchema.setEmail(user.email());
            userSchema.setPassword(user.password());
            userJPARepository.save(userSchema);
        }
    }
    
}

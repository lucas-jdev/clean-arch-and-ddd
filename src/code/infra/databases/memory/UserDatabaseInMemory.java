package code.infra.databases.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;

public class UserDatabaseInMemory implements IUserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.id().equals(user.id()))
                .findFirst();

        userOptional.ifPresent(users::remove);
        userOptional.ifPresent(users::add);
        userOptional.orElseThrow();
    }

    @Override
    public Collection<User> findAll() {
        return users;
    }

    @Override
    public Collection<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.email().contains(email))
                .toList();
    }

    @Override
    public Collection<User> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.username().contains(username))
                .toList();
    }

    @Override
    public Optional<User> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return users.stream()
                .filter(user -> user.id().equals(uuid))
                .findFirst();
    }

    @Override
    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<User> userOptional = users.stream()
                .filter(user -> user.id().equals(uuid))
                .findFirst();

        userOptional.ifPresent(users::remove);
        userOptional.orElseThrow();
    }

}

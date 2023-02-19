package code.infra.databases.jdbc.postgreSQL;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import code.domain.entities.user.User;
import code.domain.repositories.IUserRepository;
import code.infra.databases.IConnection;

public class UserDatabase implements IUserRepository {

    private final IConnection connection;

    public UserDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public void save(User user) {
        Object[] data = {
                user.username(),
                user.email(),
                user.password(),
                user.status()
        };

        connection.insert("""
                INSERT INTO users (username, email, password, user_status)
                VALUES (?, ?, ?, ?)
                """, data);

    }

    @Override
    public void update(User user) {
        Object[] data = {
                user.username(),
                user.email(),
                user.password(),
                user.status(),
                user.id()
        };

        connection.insert("""
                UPDATE users SET username = ?, email = ?, password = ?, user_status = ?
                WHERE id = ?
                """, data);
    }

    @Override
    public Collection<User> findAll() {
        ResultSet rs = connection.query("""
                SELECT * FROM users WHERE user_status = 'ACTIVE'
                """);
        return _mapToUsers(rs);
    }

    @Override
    public Collection<User> findByEmail(String email) {
        final var emailWithJokerCharacter = "%" + email + "%";

        ResultSet rs = connection.query("""
                SELECT * FROM users WHERE email LIKE ?
                """, emailWithJokerCharacter);

       return _mapToUsers(rs);
    }

    @Override
    public Collection<User> findByUsername(String username) {
        final var usernameWithJokerCharacter = "%" + username + "%";

        ResultSet rs = connection.query("""
                SELECT * FROM users WHERE username LIKE ?
                """, usernameWithJokerCharacter);

        return _mapToUsers(rs);
    }

    @Override
    public Optional<User> findById(String id) {
        ResultSet rs = connection.query("""
                SELECT * FROM users WHERE id::text = ?
                """, id);

        User user = null;
        try {
            user = _getUser(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public void delete(String id) {
        connection.query("""
                DELETE FROM users WHERE id::text = ?
                """, id);

    }

    private User _mapToUser(ResultSet rs) throws Exception {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String pass = rs.getString("password");
        UUID uuid = UUID.fromString(id);
        return new User(uuid, username, email, pass);
    }

    private Collection<User> _mapToUsers(ResultSet rs) {
        Collection<User> users = new ArrayList<>();
        try {
            while (rs.next()) {
                users.add(_mapToUser(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private User _getUser(ResultSet rs) throws Exception {
        while (rs.next()) {
            return _mapToUser(rs);
        }
        return null;
    }

}

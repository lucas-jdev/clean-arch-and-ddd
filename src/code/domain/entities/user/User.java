package code.domain.entities.user;

import java.util.UUID;

/**
 * User
 */
public class User {

    private UUID id;
    private String username;
    private String email;
    private Status status;
    private String password;

    public User() {
        this.id = UUID.randomUUID();
        this.status = Status.ACTIVE;
    }

    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(UUID id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    public UUID id() {
        return id;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public void activate() {
        this.status = Status.ACTIVE;
    }

    public void inactivate() {
        this.status = Status.INACTIVE;
    }

    public boolean isActive() {
        return this.status == Status.ACTIVE;
    }

    public boolean isInactive() {
        return this.status == Status.INACTIVE;
    }

    @Override
    public String toString() {
        return """
                User {
                    username: %s,
                    email: %s,
                    password: %s
                }
                """.formatted(
                    username,
                    email,
                    password
                );
    }

}
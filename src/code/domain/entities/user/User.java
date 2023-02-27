package code.domain.entities.user;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import code.domain.entities.IEntity;

import code.util.exceptions.domain.ParameterNotValidException;

public class User implements IEntity<UUID>{

    private UUID id;
    private String username;
    private String email;
    private Status status;
    private String password;
    private Set<Address> addresses;

    public User() {
        this.id = UUID.randomUUID();
        this.status = Status.ACTIVE;
        this.addresses = new HashSet<>();
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
        if (newPassword == null || newPassword.isBlank()) {
            throw new ParameterNotValidException("Password cannot be null or empty");
        }
        this.password = newPassword;
    }

    public void changeEmail(String newEmail) {
        if (newEmail == null || newEmail.isBlank()) {
            throw new ParameterNotValidException("Email cannot be null or empty");
        }
        this.email = newEmail;
    }

    @Override
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

    public Status status() {
        return status;
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

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"username\": \"").append(username).append("\", ");
        sb.append("\"email\": \"").append(email).append("\", ");
        sb.append("\"password\": \"").append(password).append("\"");
        sb.append("\"status\": \"").append(status).append("\"");
        sb.append("\"addresses\": \"").append(addresses).append("\"");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User))
            return false;
        if (this == obj)
            return true;
        User other = (User) obj;
        return id == other.id;
    }

}
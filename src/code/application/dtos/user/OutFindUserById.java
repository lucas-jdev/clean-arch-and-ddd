package code.application.dtos.user;

public record OutFindUserById(
        String id,
        String username,
        String email,
        String status,
        String password) {

}

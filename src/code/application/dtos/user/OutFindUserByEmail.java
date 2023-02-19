package code.application.dtos.user;

public record OutFindUserByEmail (
    String id,
    String username,
    String email,
    String status,
    String password
) {
    
}

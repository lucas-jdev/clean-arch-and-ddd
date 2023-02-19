package code.application.dtos.user;

public record OutFindUserByUsername(
    String id, 
    String username, 
    String email,
    String status,
    String password
) {
    
}

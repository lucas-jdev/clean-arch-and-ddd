package code.application.dtos.user;

public record OutFindUser(
    String id, 
    String username, 
    String email, 
    String status, 
    String password) {

}

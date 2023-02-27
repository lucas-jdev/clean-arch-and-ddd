package code.domain.entities.user;

public record Address(
    String street,
    String number,
    String complement,
    String neighborhood,
    String city,
    String state,
    String country,
    String zipCode
) {
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"street\": \"").append(street).append("\", ");
        sb.append("\"number\": \"").append(number).append("\", ");
        sb.append("\"complement\": \"").append(complement).append("\", ");
        sb.append("\"neighborhood\": \"").append(neighborhood).append("\", ");
        sb.append("\"city\": \"").append(city).append("\", ");
        sb.append("\"state\": \"").append(state).append("\", ");
        sb.append("\"country\": \"").append(country).append("\", ");
        sb.append("\"zipCode\": \"").append(zipCode).append("\"");
        sb.append("}");
        return sb.toString();
    }
}

package code.infra.databases.orm;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserSchema, UUID> {

    Collection<UserSchema> findByEmail(String email);
    Collection<UserSchema> findByUsername(String email);

}

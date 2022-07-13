package bj.finance.petapi.repositories;

import bj.finance.petapi.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByUsernameIgnoreCaseOrEmailIgnoreCase(String username, String email);
}

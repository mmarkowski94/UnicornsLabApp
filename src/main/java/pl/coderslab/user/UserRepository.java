package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById (Long id);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}

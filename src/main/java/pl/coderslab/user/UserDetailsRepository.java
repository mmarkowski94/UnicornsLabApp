package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.user.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

}

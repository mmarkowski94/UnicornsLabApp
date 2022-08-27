package pl.coderslab.message;

import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllByReadStatus( boolean read);
}

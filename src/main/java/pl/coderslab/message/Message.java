package pl.coderslab.message;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String sender;
    private LocalDateTime timeOfSending;
    private String contents;
    private boolean read = false;

    @PrePersist
    public void prePersist() {
        timeOfSending = LocalDateTime.now();
    }
}

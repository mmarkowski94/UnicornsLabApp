package pl.coderslab.message;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table( name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String sender;
    private LocalDateTime timeSending;
    @NotEmpty
    private String contents;
    private boolean readStatus = false;

    @PrePersist
    public void prePersist() {
        timeSending = LocalDateTime.now();
    }


}

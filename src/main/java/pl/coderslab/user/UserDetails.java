package pl.coderslab.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.projects.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "userDetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position = "";
    private String team = "";
    private String description = "";
    //lepszy widok np.brak informacji zmiar "" mozna zrobic z poziomu frontu
}


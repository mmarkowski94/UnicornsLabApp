package pl.coderslab.userDetails;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.projects.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "userDetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String team;
    private String description;
}


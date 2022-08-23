package pl.coderslab.projects;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String thePurposeOfTheProject;
    private int numberOfPeopleNeeded;
    private LocalDate startDate;
    @ManyToMany(mappedBy = "projects")
    private List<User> team = new ArrayList<>();
}

package pl.coderslab.projects;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty
    private String name;
    @NotEmpty
    @Column(length = 2000) // not work?
    private String description;
    @NotEmpty
    private String thePurposeOfTheProject;
    private int numberOfPeopleNeeded;
    private LocalDate startDate;
    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    private List<User> team = new ArrayList<>();
}

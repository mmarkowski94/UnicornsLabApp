package pl.coderslab.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.projects.Project;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty 
    private String position = "";
    @NotEmpty
    private String team = "";
    @NotEmpty
    private String description = "";
}


package pl.coderslab.skill;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();
}

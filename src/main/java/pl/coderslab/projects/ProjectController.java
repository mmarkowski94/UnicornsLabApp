package pl.coderslab.projects;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
@SessionAttributes("loggedUser")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @GetMapping("/list")
    public String findAll (Model model) {
        model.addAttribute("projects",projectRepository.findAll());
        return "project/list";
    }

//    @GetMapping("/list/{id}/join")
//    @Transactional
//    public String joinProject (@SessionAttribute("loggedUser") User user,@PathVariable Long id) {
//        Project project = projectRepository.getOne(id);
//        List<User> listToAddUser = project.getTeam();
//        listToAddUser.add(userRepository.findByEmail(user.getEmail()));
//        project.setTeam(listToAddUser);
//        projectRepository.save(project);
//        return "redirect:/user/panel";
//         nie wyskakuje 500 ale nie dodaje usera w DB
//    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle() {
        return "redirect:/user/login";
    }


    @GetMapping("/list/{id}/join")
    @Transactional
    public String joinProject(@SessionAttribute("loggedUser") User user,@PathVariable Long id) {
        User userToAddProject = userRepository.getOne(user.getId());
        Set<Project> projects = userToAddProject.getProjects();
        projects.add(projectRepository.getOne(id));
        userToAddProject.setProjects(projects);
        userRepository.save(userToAddProject);
        return "redirect:/user/panel";
    }
}

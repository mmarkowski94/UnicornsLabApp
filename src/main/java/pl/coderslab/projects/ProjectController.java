package pl.coderslab.projects;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
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
    public String findAll(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "project/list";
    }


    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle() {
        return "redirect:/user/login";
    }


    @GetMapping("/list/{id}/join")
    @Transactional
    public String joinProject(@SessionAttribute("loggedUser") User user, @PathVariable Long id) {
        User userToAddProject = userRepository.getOne(user.getId());
        Set<Project> projects = userToAddProject.getProjects();
        projects.add(projectRepository.getOne(id));
        userToAddProject.setProjects(projects);
        userRepository.save(userToAddProject);
        return "redirect:/project/list";
    }

    @GetMapping("/list/{id}/leave")
    @Transactional
    public String leaveProject(@SessionAttribute("loggedUser") User user, @PathVariable Long id) {
        User userToLeaveProject = userRepository.getOne(user.getId());
        Set<Project> projects = userToLeaveProject.getProjects();
        if (projects.contains(projectRepository.getOne(id))) {
            projects.remove(projectRepository.getOne(id));
        }
        userToLeaveProject.setProjects(projects);
        userRepository.save(userToLeaveProject);
        return "redirect:/project/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("project", new Project());
        return "project/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("project") @Valid Project project, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "project/add";
        }
        projectRepository.save(project);
        return "redirect:/project/list";
    }

    @GetMapping("/{id}/details")
    public String projectDetails(Model model, @PathVariable Long id) {
        model.addAttribute("project", projectRepository.findById(id).get());
        return "/project/details";
    }
}

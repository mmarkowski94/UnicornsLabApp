package pl.coderslab.projects;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @GetMapping("/list")
    public String findAll (Model model) {
        model.addAttribute("projects",projectRepository.findAll());
        return "project/list";
    }

/*

ogarnij optionala i tą sesje
    @PutMapping("/list/{id}/join")
    public String findAll (Model model, @PathVariable Long id) {
        Project project = projectRepository.findById(id);
        project.setTeam(project.getTeam().add(userRepository.)).;
        project.setTeam(project.getTeam().add(user));
        return "project/list";
    }
     */
}

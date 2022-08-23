package pl.coderslab.projects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository repository;

    @GetMapping("/list")
    public String findAll (Model model) {
        model.addAttribute("projects",repository.findAll());
        return "project/list";
    }


}

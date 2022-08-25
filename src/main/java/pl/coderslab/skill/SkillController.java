package pl.coderslab.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {

    private  final SkillRepository skillRepository;

    @GetMapping("/list")
    public String findAll (Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        return "skill/list";
    }

    @PostMapping("/list")
    public String login(@RequestParam("skill") String skill) {
        Skill newSkill = new Skill();
        newSkill.setName(skill);
        skillRepository.save(newSkill);
        return "redirect:/skill/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSkill(@PathVariable long id) {
        skillRepository.deleteById(id);
        return "redirect:/skill/list";
    }
}

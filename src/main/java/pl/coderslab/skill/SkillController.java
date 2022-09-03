package pl.coderslab.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Controller
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    @GetMapping("/admin/list")
    public String adminList(Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        return "skill/adminList";
    }

    @PostMapping("/admin/list")
    public String login(@RequestParam("skill") String skill) {
        Skill newSkill = new Skill();
        newSkill.setName(skill);
        skillRepository.save(newSkill);
        return "redirect:/skill/admin/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSkill(@PathVariable long id) {
        skillRepository.deleteById(id);
        return "redirect:/skill/admin/list";
        //do poprawy tam gdzie jest relacja z userem nie usuwa skilla
    }

    @GetMapping("/list")
    @Transactional
    public String findAll(@SessionAttribute("loggedUser") User user, Model model) {
        model.addAttribute("currentSkills", userRepository.getOne(user.getId()).getSkills());
        model.addAttribute("skills", skillRepository.findAll());
        return "skill/list";
    }

    @GetMapping("/list/{id}/add")
    @Transactional
    public String addSkillAtUser(@SessionAttribute("loggedUser") User user, @PathVariable Long id) {
        User userToAddSkill = userRepository.getOne(user.getId());
        Set<Skill> skills = userToAddSkill.getSkills();
        skills.add(skillRepository.getOne(id));
        userToAddSkill.setSkills(skills);
        userRepository.save(userToAddSkill);
        return "redirect:/skill/list";
    }

    @GetMapping("/list/{id}/delete")
    @Transactional
    public String deleteSkillAtUser(@SessionAttribute("loggedUser") User user, @PathVariable Long id) {
        User userToDeleteSkill = userRepository.getOne(user.getId());
        Set<Skill> skills = userToDeleteSkill.getSkills();
        if (skills.contains(skillRepository.getOne(id))) {
            skills.remove(skillRepository.getOne(id));
        }
        userToDeleteSkill.setSkills(skills);
        userRepository.save(userToDeleteSkill);
        return "redirect:/skill/list";
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle() {

        return "redirect:/user/login";

    }
}

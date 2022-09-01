package pl.coderslab.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;

import javax.transaction.Transactional;

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
        //do poprawy tam gdzie jest relacja z userem nie usuwa skilla
    }

    @GetMapping("/editSkills")
    @Transactional
    public String editSkills(Model model, @SessionAttribute("loggedUser") User user) {
        model.addAttribute("skills", skillRepository.findAll());
        return "user/addSkills";
    }

//    @PostMapping("/editDetails")
//    public String saveChangesDetails(@ModelAttribute("userDetails") @Valid UserDetails userDetails, BindingResult result) {
//        if (result.hasErrors()) {
//            return "user/editDetails";
//        }
//        userDetailsRepository.save(userDetails);
//        return "redirect:/user/panel";
//    }
}

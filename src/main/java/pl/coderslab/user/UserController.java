package pl.coderslab.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.skill.Skill;
import pl.coderslab.skill.SkillRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@SessionAttributes("loggedUser")
public class UserController {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @GetMapping("/register")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String save(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/register";
        }
        UserDetails userDetails = new UserDetails();
        userDetailsRepository.save(userDetails);
        user.setDetails(userDetails);
        userRepository.save(user);
        return "redirect:/user/login";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        if (userRepository.existsByEmail(email)) {
            if (userRepository.findByEmail(email).getPassword().equals(password)) {
                model.addAttribute("loggedUser", userRepository.findByEmail(email));
                return "redirect:/";
            }
        }
        return "user/login";
    }

    @GetMapping("/panel")
    @Transactional
    public String userPage(Model model, @SessionAttribute("loggedUser") User user) {
        User userData = userRepository.getOne(user.getId());
        model.addAttribute("user", userData);
        model.addAttribute("details", userData.getDetails());
        model.addAttribute("skills", userData.getSkills());
        model.addAttribute("projects", userData.getProjects());
        return "user/panel";
        //do sprawdzenia czy to mozna jedna linia zrobic
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle() {

        return "redirect:/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
        //dont work
    }

    @GetMapping("/edit")
    public String editProfile(@SessionAttribute("loggedUser") User user, Model model) {
       // User userToEdit = userRepository.getOne(user.getId());
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String saveChanges(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        userRepository.save(user);
        return "redirect:/user/panel";
    }

    @GetMapping("/{id}/details")
    @Transactional
    public String userDetails(Model model, @PathVariable Long id) {
        User userView = userRepository.getOne(id);
        model.addAttribute("user", userView);
        model.addAttribute("details", userView.getDetails());
        model.addAttribute("skills", userView.getSkills());
        model.addAttribute("projects", userView.getProjects());
        return "user/view";
    }
}
package pl.coderslab.user;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@SessionAttributes("user")
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

    @GetMapping("/panel")
    public String panel(Model model) {
        return "user/panel";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                session.setAttribute("user", user);
            }
        }
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        } else {
            return "redirect:/user/login";
        }
    }
}

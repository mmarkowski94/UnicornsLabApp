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
public class UserController {


    private final Repository repository;

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
        repository.save(user);
        return "redirect:user/login";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", repository.findAll());
        return "user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:user/list";
    }

    @GetMapping("/panel")
    public String panel() {
        return "user/panel";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    @Scope(value = WebApplicationContext.SCOPE_SESSION)
    public String login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        List<User> users = repository.findAll();

        for (User user : users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                session.setAttribute("user", user);
            }
        }
        if (session.getAttribute("user") != null) {
            return "start";
        } else {
            return "redirect:/login";
        }
    }
}

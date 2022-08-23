package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.user.User;


    @Controller
    public class StartController {
        @GetMapping("/")
        public String index(Model model) {
            model.addAttribute(new User());
            return "start";
        }
}

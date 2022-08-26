package pl.coderslab.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private MessageRepository messageRepository;

    @GetMapping("/send")
    public String add(Model model) {
        model.addAttribute("message", new Message());
        return "message/send";
    }

    @PostMapping("/send")
    public String save(@ModelAttribute("message") @Valid Message message, BindingResult result) {
        if (result.hasErrors()) {
            return "message/send";
        }
        messageRepository.save(message);
        return "message/typ";
    }

    @GetMapping("/panel")
    public String list(Model model) {
        model.addAttribute("messagesReaded", messageRepository.findAllByRead(true));
        model.addAttribute("messagesNoReaded", messageRepository.findAllByRead(false));
        return "message/panel";
    }
}

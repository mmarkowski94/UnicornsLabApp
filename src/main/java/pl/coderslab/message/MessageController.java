package pl.coderslab.message;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

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
        model.addAttribute("messagesReaded", messageRepository.findAllByReadStatus(true));
        model.addAttribute("messagesNoReaded", messageRepository.findAllByReadStatus(false));
        return "message/messagePanel";
    }

    @GetMapping(value = "/edit/{id}")
    public String read (@PathVariable long id) {

        return "redirect:/message/panel";
    }
}

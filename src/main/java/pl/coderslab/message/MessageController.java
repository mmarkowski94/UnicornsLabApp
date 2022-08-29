package pl.coderslab.message;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
@Transactional
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
        // do dodania sorotwanie wiad po dacie
       //  messageRepository.findAllByReadStatus(true).sort(Comparator.comparing(Message::getTimeSending));
        model.addAttribute("messagesReaded", messageRepository.findAllByReadStatus(true));
        model.addAttribute("messagesNoReaded", messageRepository.findAllByReadStatus(false));
        return "message/panel";
    }

    @GetMapping("/panel/change/{id}")
    public String change(@PathVariable long id) {
        Message messageToUpdate = messageRepository.getOne(id);
        if (messageToUpdate.isReadStatus()) {
            messageToUpdate.setReadStatus(false);
        } else {
            messageToUpdate.setReadStatus(true);
        }
        messageRepository.save(messageToUpdate);
        return "redirect:/message/panel";
    }

//    @GetMapping("/panel/read/{id}")
//    public String read(@PathVariable long id) {
//        Message messageToUpdate = messageRepository.getOne(id);
//        if (!messageToUpdate.isReadStatus()) {
//            messageToUpdate.setReadStatus(true);
//        }
//        messageRepository.save(messageToUpdate);
//        return "redirect:/message/panel";
//    }
//
//    @GetMapping("/panel/noRead/{id}")
//    public String noRead(@PathVariable long id) {
//        Message messageToUpdate = messageRepository.getOne(id);
//        if (messageToUpdate.isReadStatus()) {
//            messageToUpdate.setReadStatus(false);
//        }
//        messageRepository.save(messageToUpdate);
//        return "redirect:/message/panel";
//    }

    @GetMapping("/panel/delete/{id}")
    public String delete(@PathVariable long id) {
        messageRepository.deleteById(id);
        return "redirect:/message/panel";
    }
}

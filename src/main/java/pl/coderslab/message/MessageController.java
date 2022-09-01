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

    public String save(@ModelAttribute("message") @Valid Message message, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "message/send";
        }
        messageRepository.save(message);
        model.addAttribute("messageUser",message.getSender());
        return "message/typ";
    }
    //do dodania walidacje na ilosc znakow

    @GetMapping("/panel")
    public String list(Model model) {
        List<Message> read = messageRepository.findAllByReadStatus(true);
        read.sort(Comparator.comparing(Message::getTimeSending).reversed());
        List<Message> noRead = messageRepository.findAllByReadStatus(false);
        noRead.sort(Comparator.comparing(Message::getTimeSending).reversed());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        read.forEach(message -> message.setTimeSending(LocalDateTime.parse(message.getTimeSending().format(formatter))));
//        wyswietlanei daty do zrobienia - nie parsuje
        model.addAttribute("messagesRead", read);
        model.addAttribute("messagesNoRead", noRead);
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

    @GetMapping("/panel/delete/{id}")
    public String delete(@PathVariable long id) {
        messageRepository.deleteById(id);
        return "redirect:/message/panel";
    }
}

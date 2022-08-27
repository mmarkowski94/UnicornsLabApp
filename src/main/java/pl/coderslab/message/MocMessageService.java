package pl.coderslab.message;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Component
public class MocMessageService implements MessageService {

    private List<Message> list = new ArrayList<>();

    @Autowired
    public MocMessageService() {
    }

    ;

    @Override
    public List<Message> getMessages() {
        return this.getList();
    }

    @Override
    public Message getMessageById(Long id) {
        List<Message> messages = this.getList();

        return messages.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst().get();
    }

    @Override
    public void addMessage(Message message) {
        list.add(message);
    }

    @Override
    public void updateMessage(Long id, Message message) {
        List<Message> messages = this.getList();

        List<Message> collect = messages.stream()
                .filter(s -> !(s.getId().equals(id)))
                .collect(Collectors.toList());
        message.setId(id);
        collect.add(message);
        this.setList(collect);
    }


    @Override
    public void deleteMessage(Long id) {
        List<Message> messages = this.getList();

        List<Message> collect = messages.stream()
                .filter(s -> !(s.getId().equals(id)))
                .collect(Collectors.toList());

        this.setList(collect);
    }
}

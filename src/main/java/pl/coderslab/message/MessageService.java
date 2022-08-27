package pl.coderslab.message;

import java.util.List;

public interface MessageService {

    List<Message> getMessages();

    Message getMessageById(Long id);

    void addMessage(Message message);

    void updateMessage(Long id, Message message);

    void deleteMessage(Long id);
}


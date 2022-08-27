package pl.coderslab.message;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Primary
@Transactional
public class JpaMessageService implements MessageService{

    public JpaMessageService(MessageRepository messageRepository) {
    }



    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public Message getMessageById(Long id) {
        return null;
    }

    @Override
    public void addMessage(Message message) {

    }

    @Override
    public void updateMessage(Long id, Message message) {

    }

    @Override
    public void deleteMessage(Long id) {

    }
}

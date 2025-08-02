package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.MessageRepository;
import com.example.entity.Message;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Optional<Message> findById(Integer id) {
        return messageRepository.findById(id);
    }

    @Transactional
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        messageRepository.deleteById(id);
    }

    @Transactional
    public Message updateById(Integer id, Message message) {
        Optional<Message> retrievedMessage = messageRepository.findById(id);
        if (retrievedMessage.isPresent()) {
            String messageText = message.getMessageText();
            if (messageText != null && !messageText.isEmpty() && messageText.length() <= 255) {
                Message updatedMessage = retrievedMessage.get();
                updatedMessage.setMessageText(messageText);
                return messageRepository.save(updatedMessage);
            }
        }
        return null;
    }

    public List<Message> findByPostedBy(Integer postedBy) {
        return messageRepository.findByPostedBy(postedBy);
    }
}

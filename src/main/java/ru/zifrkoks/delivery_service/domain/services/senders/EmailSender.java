package ru.zifrkoks.delivery_service.domain.services.senders;

import java.util.HashSet;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;
import ru.zifrkoks.delivery_service.domain.services.exceptions.SendException;
import ru.zifrkoks.delivery_service.domain.services.models.Message;
@Component
public class EmailSender implements ISender {

    

    @Override
    public boolean sendMessage(HashSet<UserAccount> users, Message message) throws SendException {
        throw new SendException("lol");
    }
    
}

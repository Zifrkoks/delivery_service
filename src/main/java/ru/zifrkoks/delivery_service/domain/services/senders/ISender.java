package ru.zifrkoks.delivery_service.domain.services.senders;

import java.util.HashSet;

import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;
import ru.zifrkoks.delivery_service.domain.services.exceptions.SendException;
import ru.zifrkoks.delivery_service.domain.services.models.Message;

public interface ISender {
    boolean sendMessage(HashSet<UserAccount> users,Message message) throws SendException;
}

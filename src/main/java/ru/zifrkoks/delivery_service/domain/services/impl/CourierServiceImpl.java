package ru.zifrkoks.delivery_service.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.domain.exceptions.SignUpException;
import ru.zifrkoks.delivery_service.domain.exceptions.SignUpException.SignUpStatus;
import ru.zifrkoks.delivery_service.domain.models.courier.Courier;
import ru.zifrkoks.delivery_service.domain.models.courier.CourierData;
import ru.zifrkoks.delivery_service.domain.repositories.CourierRepository;
import ru.zifrkoks.delivery_service.domain.services.interfaces.CourierService;
import ru.zifrkoks.delivery_service.domain.services.models.SignUpModel;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepository courierRepository;
    @Override
    public boolean signUp(SignUpModel request) throws SignUpException {
        Courier userAccount = new Courier();
        if(courierRepository.findByUsername(request.username).isPresent())
        {
            throw new SignUpException(SignUpStatus.NAME_TAKEN);
        }
        try
        {
            userAccount.setUsername(request.username);
            userAccount.setPassword(request.password);
            userAccount.setEmail(request.email);
            userAccount.setPhone(request.phone);
            userAccount.setCourierData(new CourierData());
            userAccount = courierRepository.save(userAccount);
        }
        catch(Exception ex){
            throw new SignUpException(SignUpException.SignUpStatus.SERVER_ERROR);
        }
        return true;
    }
}

package ru.zifrkoks.delivery_service.domain.services.interfaces;

import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.domain.services.exceptions.SendException;
import ru.zifrkoks.delivery_service.domain.services.models.Message;


@Service
public interface StoreService extends AccountService {

    // public CreateProductResponse createProduct(CreateProductRequest request);

    // public SetStoreDataResponse setStoreData(SetStoreDataRequest request);

    public boolean sendMessageForAllUsersWhoMarksProducts(String storeUsername,Message message) throws SendException;
}

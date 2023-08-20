package ru.zifrkoks.delivery_service.services.interfaces;

import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.dtos.request.*;

import ru.zifrkoks.delivery_service.dtos.response.*;

@Service
public interface StoreService extends AccountService {

    public CreateProductResponse createProduct(CreateProductRequest request);

    public SetStoreDataResponse setStoreData(SetStoreDataRequest request);


}

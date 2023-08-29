package ru.zifrkoks.delivery_service.services.interfaces;

import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.dtos.request.*;

import ru.zifrkoks.delivery_service.dtos.response.*;

@Service
public interface CourierService extends AccountService {

    public FindNearestOrdersResponse findNearestOrder(FindNearestOrdersRequest request);

    public TakeOrderResponse takeOrder(TakeOrderRequest request);

}

package ru.zifrkoks.delivery_service.services.impl;

import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.dtos.request.*;
import ru.zifrkoks.delivery_service.dtos.response.*;
import ru.zifrkoks.delivery_service.services.interfaces.CourierService;

@Service
public class CourierServiceImpl implements CourierService {

    @Override
    public SignUpResponse signUp(SignUpRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signUp'");
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }

    @Override
    public SignOutResponse signOut(SignOutRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signOut'");
    }

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrder'");
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

    @Override
    public GetActiveOrdersResponse getActiveOrders(GetActiveOrdersRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveOrders'");
    }

    @Override
    public ForwardOrderResponse forwardOrder(ForwordOrderRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forwardOrder'");
    }

    @Override
    public FindNearestOrdersResponse findNearestOrder(FindNearestOrdersRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findNearestOrder'");
    }

    @Override
    public TakeOrderResponse takeOrder(TakeOrderRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'takeOrder'");
    }
     
}

package ru.zifrkoks.delivery_service.services.impl;

import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.dtos.request.*;
import ru.zifrkoks.delivery_service.dtos.response.*;
import ru.zifrkoks.delivery_service.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public SignUpResponse signUp(SignUpRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'signUp'");
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }

    @Override
    public SignOutResponse signOut(SignOutRequest request) {
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
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public CencelOrderResponse cencelOrder(CencelOrderRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cencelOrder'");
    }

    @Override
    public ProductsResponse getProductsInCity(ProductsRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsInCity'");
    }

    @Override
    public StoresResponse getStoresInCity(StoresRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoresInCity'");
    }

    @Override
    public CreateProductReviewResponse createProductReview(CreateProductReviewRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProductReview'");
    }

    @Override
    public CreateStoreReviewResponse createStoreReview(CreateStoreReviewRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createStoreReview'");
    }
    
}

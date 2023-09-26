package ru.zifrkoks.delivery_service.domain.services.interfaces;

import ru.zifrkoks.delivery_service.domain.services.models.SignUpModel;

public interface AccountService {

    public boolean signUp(SignUpModel model) throws Exception;

    //public SignInResponse signIn(SignInModel request);

    // public SignOutResponse signOut(SignOut request);
    
    // public GetOrderResponse getOrder(GetOrderRequest request);

    // public GetOrdersResponse getOrders(GetOrdersRequest request);

    // public GetActiveOrdersResponse getActiveOrders(GetActiveOrdersRequest request);

    // public ForwardOrderResponse forwardOrder(ForwordOrderRequest request);
}

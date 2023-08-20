package ru.zifrkoks.delivery_service.services.interfaces;

import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.dtos.request.*;

import ru.zifrkoks.delivery_service.dtos.response.*;





@Service
public interface UserService extends AccountService {
    
    public CreateOrderResponse createOrder(CreateOrderRequest request);

    public CencelOrderResponse cencelOrder(CencelOrderRequest request);

    public ProductsResponse getProductsInCity(ProductsRequest request);

    public StoresResponse getStoresInCity(StoresRequest request);

    public CreateProductReviewResponse createProductReview(CreateProductReviewRequest request);

    public CreateStoreReviewResponse createStoreReview(CreateStoreReviewRequest request);

}

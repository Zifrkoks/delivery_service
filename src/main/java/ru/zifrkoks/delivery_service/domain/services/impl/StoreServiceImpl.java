package ru.zifrkoks.delivery_service.domain.services.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zifrkoks.delivery_service.domain.exceptions.SignUpException;
import ru.zifrkoks.delivery_service.domain.exceptions.SignUpException.SignUpStatus;
import ru.zifrkoks.delivery_service.domain.models.store.Product;
import ru.zifrkoks.delivery_service.domain.models.store.Store;
import ru.zifrkoks.delivery_service.domain.models.store.StoreData;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;
import ru.zifrkoks.delivery_service.domain.repositories.ProductRepository;
import ru.zifrkoks.delivery_service.domain.repositories.StoreRepository;
import ru.zifrkoks.delivery_service.domain.services.exceptions.SendException;
import ru.zifrkoks.delivery_service.domain.services.interfaces.StoreService;
import ru.zifrkoks.delivery_service.domain.services.models.Message;
import ru.zifrkoks.delivery_service.domain.services.models.ProductModel;
import ru.zifrkoks.delivery_service.domain.services.models.SignUpModel;
import ru.zifrkoks.delivery_service.domain.services.senders.ISender;

@Service
public class StoreServiceImpl implements StoreService  {
    
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ISender sender;
    @Override
    public boolean signUp(SignUpModel request) throws SignUpException {
        Store userAccount = new Store();
        if(storeRepository.findByUsername(request.username).isPresent())
        {
            throw new SignUpException(SignUpStatus.NAME_TAKEN);
        }
        try
        {
            userAccount.setUsername(request.username);
            userAccount.setPassword(request.password);
            userAccount.setEmail(request.email);
            userAccount.setPhone(request.phone);
            userAccount.setStoreData(new StoreData());

            userAccount = storeRepository.save(userAccount);
        }
        catch(Exception ex){
            throw new SignUpException(SignUpException.SignUpStatus.SERVER_ERROR);
        }
        return true;
    }

    public boolean createProduct(ProductModel model,String storeUsername)
    {
        try {
            Optional<Store> store = storeRepository.findByUsername(storeUsername);
        if(store.isPresent()){
            Product product = new Product();
            product.setName(model.getName());
            product.setCost(model.getCost());
            product.setDescription(model.getDescription());
            product.setRating(0);
            product.setStore(store.get());
            productRepository.save(product);
            return true;
        }
        else
            return false;
        } catch (Exception e) {
            throw e;
        }
        

    }
    public boolean sendMessageForAllUsersWhoMarksProducts(String storeUsername,Message message){
        try {
            HashSet<UserAccount> list = storeRepository.usersMarksProductsByStore(storeUsername);
            list.addAll(storeRepository.usersMarksStores(storeUsername));
            return sender.sendMessage(list, message);
        } catch (Exception e) {
            return false;
        }

    }


}

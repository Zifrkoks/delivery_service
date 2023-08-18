package ru.zifrkoks.delivery_service.services.interfaces;

import ru.zifrkoks.delivery_service.dtos.request.*;

import ru.zifrkoks.delivery_service.dtos.response.*;

public interface AccountService {

    public SignUpResponse signUp(SignUpRequest request);

    public SignInResponse signIn(SignInRequest request);

    public SignOutResponse signOut(SignOutRequest request);
}

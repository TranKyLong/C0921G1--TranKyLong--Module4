package app.service;

import app.model.LoginAccount;
import app.reponsitory.IAccountReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountReponsitory iAccountReponsitory;

    @Override
    public LoginAccount validateAccount(LoginAccount account) {
        return iAccountReponsitory.validateAccount(account);
    }
}

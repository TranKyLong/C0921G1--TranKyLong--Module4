package app.service;

import app.model.LoginAccount;

import java.util.List;
import java.util.Map;

public interface IAccountService {
    LoginAccount validateAccount(LoginAccount account);
}

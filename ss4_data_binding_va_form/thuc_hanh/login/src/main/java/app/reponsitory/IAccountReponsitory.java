package app.reponsitory;

import app.model.LoginAccount;

import java.util.List;
import java.util.Map;

public interface IAccountReponsitory {
    LoginAccount validateAccount(LoginAccount account);
}

package app.reponsitory;

import app.model.LoginAccount;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountReponsitoryImpl implements IAccountReponsitory {

    private static List<LoginAccount> loginAccountList;

    static {
        loginAccountList = new ArrayList<>();
        loginAccountList.add(new LoginAccount("tklong", "123", "0369897856", "Trần Kỳ Long", 22, 1, "long@gmail.com"));
        loginAccountList.add(new LoginAccount("admin", "admin001", "0987561245", "THE ADMINISTRATOR", 0, 1, "fullcontrol@gmail.com"));
    }

    @Override
    public LoginAccount validateAccount(LoginAccount account) {

        for (LoginAccount loginAccount : loginAccountList) {
            if (account.getId().equals(loginAccount.getId())
                    && account.getPassword().equals(loginAccount.getPassword())) {

                return loginAccount;
            }
        }
        return null;
    }
}

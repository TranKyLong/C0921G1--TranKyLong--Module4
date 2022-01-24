package app.validate_form.service;

import app.validate_form.model.ValidateAccount;
import app.validate_form.reponsitory.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public void save(ValidateAccount validateAccount) {
        iAccountRepository.save(validateAccount);
    }
}

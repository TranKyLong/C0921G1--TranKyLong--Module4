package app.validate_form.reponsitory;

import app.validate_form.model.ValidateAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<ValidateAccount,Integer> {
}

package az.unibank.unibanktech.acount;

import az.unibank.unibanktech.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserAndActiveIsTrue(Account account);

}
package az.unibank.unibanktech.repository;

import az.unibank.unibanktech.domain.Account;
import az.unibank.unibanktech.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByUserAndActiveIsTrue(User user);

    Optional<Account> findByAccountNumber(String accountNumber);

}
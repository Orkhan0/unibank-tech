package az.unibank.unibanktech.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String accountNumber;
    private BigDecimal amount;
    private String description;
    private boolean active;

    @ManyToOne
    private User user;

    @PrePersist
    private void setUp() {
        amount = BigDecimal.TEN;
        active = Boolean.TRUE;
        accountNumber = UUID.randomUUID().toString().toUpperCase();
    }

}
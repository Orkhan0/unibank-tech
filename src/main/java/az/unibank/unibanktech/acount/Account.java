package az.unibank.unibanktech.acount;

import az.unibank.unibanktech.user.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigInteger amount;

    private String description;

    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

}
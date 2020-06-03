package model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USER")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="login")
    private String login;

    @OneToMany(mappedBy = "user")
    private List<Character> characters = new ArrayList<>();

    public User(String email, String login) {
        this.email = email;
        this.login = login;
    }
}

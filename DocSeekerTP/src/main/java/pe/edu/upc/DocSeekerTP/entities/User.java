package pe.edu.upc.DocSeekerTP.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="users")
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private boolean enable;

    public User() {}

    public User(String userName, String password, boolean enable) {
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }
}

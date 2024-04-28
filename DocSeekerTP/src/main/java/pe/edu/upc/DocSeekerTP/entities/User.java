package pe.edu.upc.DocSeekerTP.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.DocSeekerTP.Entities.Authority;
import java.util.List;

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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authorities",
            joinColumns = {
                    @JoinColumn (
                            name="user_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn (
                            name = "authority_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            }
    )
    private List<Authority> authorities;

    public User() {}

    public User(String userName, String password, boolean enable) {
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }


    public boolean isEnabled() {
        return true;
    }
}



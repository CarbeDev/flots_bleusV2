package flots_bleusa.v2.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    private String login;
    private String password;
}

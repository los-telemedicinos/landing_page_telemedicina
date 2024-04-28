package pe.edu.upc.DocSeekerTP.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import pe.edu.upc.DocSeekerTP.Entities.Authority;

@Data
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }



}

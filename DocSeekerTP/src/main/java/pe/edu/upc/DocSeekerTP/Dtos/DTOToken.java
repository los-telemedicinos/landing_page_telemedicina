package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOToken {
    String jwtToken;
    Long id;
    String authorities;
}

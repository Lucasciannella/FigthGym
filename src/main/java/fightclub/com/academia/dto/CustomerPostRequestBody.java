package fightclub.com.academia.dto;

import fightclub.com.academia.entity.Address;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPostRequestBody {
    private String firstName;
    private String lastName;
    private String cpf;
    private String birthDate;
    private String cellphone;
    private Address address;
}
package fightclub.com.academia.builders;

import fightclub.com.academia.entity.Address;

public class AddressBuilder {

    public static Address createAddressToBeSaved(){
        return Address.builder()
                .uf("RJ")
                .bairro("Ricardo de albuquerque")
                .cidade("Rio de janeiro")
                .endereco("Rua são venãncio")
                .complemento("Fundos")
                .build();
    }
}

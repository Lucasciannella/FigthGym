package fightclub.com.academia.builders;

import fightclub.com.academia.entity.Customer;

public  class CustomerBuilder {

    public static  Customer createCustomerToBeSaved() {
        return Customer.builder()
                .id(1L)
                .firstName("lucas")
                .lastName("ciannella")
                .cpf("21123145425")
                .age(22)
                .cellphone("5521978474950")
                .build();
    }
}
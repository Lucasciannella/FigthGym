package fightclub.com.academia.reposittory;

import fightclub.com.academia.entity.Customer;
import lombok.var;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@DisplayName("Test for Customer repository")
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("save create customer when sucessful")
    void save_PersistCustomer_WhenSucessful() {
        Customer customerToBeSaved = createCustomer();

        var customerSaved = customerRepository.save(customerToBeSaved);

        Assertions.assertThat(customerSaved).isNotNull();
        Assertions.assertThat(customerSaved.getFirstName()).isEqualTo(customerToBeSaved.getFirstName());
        Assertions.assertThat(customerSaved.getLastName()).isEqualTo(customerToBeSaved.getLastName());
        Assertions.assertThat(customerSaved.getCpf()).isEqualTo(customerToBeSaved.getCpf());
        Assertions.assertThat(customerSaved.getCellphone()).isEqualTo(customerToBeSaved.getCellphone());
        Assertions.assertThat(customerSaved.getBirthDate()).isEqualTo(customerToBeSaved.getBirthDate());
    }

    private Customer createCustomer() {

        return Customer.builder()
                .id(1L)
                .firstName("lucas")
                .lastName("ciannella")
                .cpf("21123145425")
                .birthDate(LocalDate.now())
                .cellphone("5521978474950")
                .build();
    }
}
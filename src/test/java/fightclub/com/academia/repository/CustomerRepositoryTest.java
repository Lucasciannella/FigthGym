package fightclub.com.academia.reposittory;

import fightclub.com.academia.builders.CustomerBuilder;
import lombok.var;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Test for Customer repository")
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("save persist customer when sucessful")
    void save_PersistCustomer_WhenSucessful() {

        var customerToBeSaved = CustomerBuilder.createCustomerToBeSaved();

        var customerSaved = customerRepository.save(customerToBeSaved);

        Assertions.assertThat(customerSaved).isNotNull();
        Assertions.assertThat(customerSaved.getFirstName()).isEqualTo(customerToBeSaved.getFirstName());
        Assertions.assertThat(customerSaved.getLastName()).isEqualTo(customerToBeSaved.getLastName());
        Assertions.assertThat(customerSaved.getCpf()).isEqualTo(customerToBeSaved.getCpf());
        Assertions.assertThat(customerSaved.getCellphone()).isEqualTo(customerToBeSaved.getCellphone());
        Assertions.assertThat(customerSaved.getAge()).isEqualTo(customerToBeSaved.getAge());
    }
}
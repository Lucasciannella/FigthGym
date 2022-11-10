package fightclub.com.academia.reposittory;

import fightclub.com.academia.builders.CustomerBuilder;
import fightclub.com.academia.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Save persist customer when sucessful")
    void save_PersistCustomer_WhenSuccessful() {

        var customerToBeSaved = CustomerBuilder.createCustomerToBeSaved();

        var customerSaved = customerRepository.save(customerToBeSaved);

        Assertions.assertThat(customerSaved).isNotNull();
        Assertions.assertThat(customerSaved.getFirstName()).isEqualTo(customerToBeSaved.getFirstName());
        Assertions.assertThat(customerSaved.getLastName()).isEqualTo(customerToBeSaved.getLastName());
        Assertions.assertThat(customerSaved.getCpf()).isEqualTo(customerToBeSaved.getCpf());
        Assertions.assertThat(customerSaved.getCellphone()).isEqualTo(customerToBeSaved.getCellphone());
        Assertions.assertThat(customerSaved.getAge()).isEqualTo(customerToBeSaved.getAge());
        Assertions.assertThat(customerSaved.getAddress().getBairro()).isEqualTo(customerToBeSaved.getAddress().getBairro());
        Assertions.assertThat(customerSaved.getAddress().getUf()).isEqualTo(customerToBeSaved.getAddress().getUf());
        Assertions.assertThat(customerSaved.getAddress().getCidade()).isEqualTo(customerToBeSaved.getAddress().getCidade());
        Assertions.assertThat(customerSaved.getAddress().getComplemento()).isEqualTo(customerToBeSaved.getAddress().getComplemento());
        Assertions.assertThat(customerSaved.getAddress().getEndereco()).isEqualTo(customerToBeSaved.getAddress().getEndereco());
    }

    @Test
    @DisplayName("Delete/remove aluno when successful")
    void delete_remove_aluno_whenSuccessful() {
        var customerToBeSaved = CustomerBuilder.createValidCustomer();

        this.customerRepository.delete(customerToBeSaved);

        Optional<Customer> customerOptional = this.customerRepository.findById(customerToBeSaved.getId());

        Assertions.assertThat(customerOptional).isEmpty();
    }
}
package fightclub.com.academia.services;

import fightclub.com.academia.dto.CustomerPostRequestBody;
import fightclub.com.academia.entity.Customer;
import fightclub.com.academia.reposittory.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Page<Customer> findAllPageable(Pageable pageable){
        return customerRepository.findAll(pageable);
    }

    public Customer buscarPorIdOuRetornarExcecao(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("fudeu caralho"));
    }

    public Customer cadastrar(CustomerPostRequestBody customerPostRequestBody) {
        Customer customer = Customer.builder()
                .firstName(customerPostRequestBody.getFirstName())
                .lastName(customerPostRequestBody.getLastName())
                .cpf(customerPostRequestBody.getCpf())
                .birthDate(customerPostRequestBody.getBirthDate())
                .cellphone(customerPostRequestBody.getCellphone())
                .address(customerPostRequestBody.getAddress())
                .build();
        return customerRepository.save(customer);
    }
}
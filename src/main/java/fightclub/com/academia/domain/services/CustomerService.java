package fightclub.com.academia.domain.services;

import fightclub.com.academia.dto.CustomerPostRequestBody;
import fightclub.com.academia.domain.entity.Customer;
import fightclub.com.academia.exceptions.BadRequestException;
import fightclub.com.academia.domain.reposittory.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final PaymentService paymentService;

    public Page<Customer> findAllPageable(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Customer findByIdOrThrowBadRequestException(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Aluno não existe ou não foi registrado no banco de dados"));
    }

    public Customer store(CustomerPostRequestBody customerPostRequestBody) {

        Customer customer = Customer.builder()
                .firstName(customerPostRequestBody.getFirstName())
                .lastName(customerPostRequestBody.getLastName())
                .cpf(customerPostRequestBody.getCpf())
                .age(customerPostRequestBody.getAge())
                .cellphone(customerPostRequestBody.getCellphone())
                .address(customerPostRequestBody.getAddress())
                .payments(paymentService.generatePaymentForCadastredCustomer())
                .build();
        return customerRepository.save(customer);
    }

    public Customer FindByCpf(String cpf){
        return customerRepository.findByCpf(cpf);
    }

    public void delete(Long id) {
        customerRepository.delete(findByIdOrThrowBadRequestException(id));
    }
}
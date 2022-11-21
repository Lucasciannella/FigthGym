package fightclub.com.academia.domain.reposittory;

import fightclub.com.academia.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCpf(String cpf);
}
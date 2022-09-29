package fightclub.com.academia.resources;

import fightclub.com.academia.dto.CustomerPostRequestBody;
import fightclub.com.academia.entity.Customer;
import fightclub.com.academia.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/aluno")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<Page<Customer>> getAllPageable(Pageable pageable) {
        return ResponseEntity.ok(customerService.findAllPageable(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> save(@RequestBody CustomerPostRequestBody customerPostRequestBody) {
        return new ResponseEntity<>(customerService.store(customerPostRequestBody), HttpStatus.CREATED);
    }
}
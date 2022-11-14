package fightclub.com.academia.resources;

import fightclub.com.academia.dto.CustomerPostRequestBody;
import fightclub.com.academia.entity.Customer;
import fightclub.com.academia.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/aluno")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    @Operation(summary = "List all customer paginated", description = "The default size is 20, use the parameter size to change the default size", tags = {"Customer"})
    public ResponseEntity<Page<Customer>> getAllPageable(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(customerService.findAllPageable(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Customer> getByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(customerService.FindByCpf(cpf));
    }

    @PostMapping()
    public ResponseEntity<Customer> save(@Valid @RequestBody CustomerPostRequestBody customerPostRequestBody) {
        return new ResponseEntity<>(customerService.store(customerPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "When customer Does Not exist in database")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
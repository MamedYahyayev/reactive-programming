package az.maqa.spring.reactive.controller;

import az.maqa.spring.reactive.entity.Employee;
import az.maqa.spring.reactive.request.RequestEmployee;
import az.maqa.spring.reactive.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public Flux<Employee> getAllEmployees() {
        Flux<Employee> employee = employeeService.getAllEmployees();
        return ResponseEntity.ok(employee).getBody();
    }

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody RequestEmployee requestEmployee) {
        Mono<Employee> employee = employeeService.createEmployee(requestEmployee);
        return ResponseEntity.ok(employee).getBody();
    }

    @GetMapping("/findEmployee/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Mono<Employee> employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee).getBody();
    }


    @PutMapping("/{id}")
    public Mono<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody RequestEmployee requestEmployee) {
        Mono<Employee> employee = employeeService.updateEmployee(requestEmployee, id);
        return ResponseEntity.ok(employee).getBody();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployee(@PathVariable("id") Long id) {
        Mono<Void> voidMono = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(voidMono).getBody();
    }

}

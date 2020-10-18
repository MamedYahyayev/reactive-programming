package az.maqa.spring.reactive.service;

import az.maqa.spring.reactive.entity.Employee;
import az.maqa.spring.reactive.request.RequestEmployee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<Employee> getAllEmployees();

    Mono<Employee> createEmployee(RequestEmployee requestEmployee);

    Mono<Employee> updateEmployee(RequestEmployee requestEmployee, Long id);

    Mono<Void> deleteEmployee(Long id);

    Mono<Employee> getEmployeeById(Long id);

}

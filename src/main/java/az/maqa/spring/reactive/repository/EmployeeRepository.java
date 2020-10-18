package az.maqa.spring.reactive.repository;

import az.maqa.spring.reactive.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

    Mono<Employee> findEmployeeById(Long id);

    Mono<Void> deleteEmployeeById(Long id);
}

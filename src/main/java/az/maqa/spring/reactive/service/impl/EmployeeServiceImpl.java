package az.maqa.spring.reactive.service.impl;

import az.maqa.spring.reactive.entity.Employee;
import az.maqa.spring.reactive.repository.EmployeeRepository;
import az.maqa.spring.reactive.request.RequestEmployee;
import az.maqa.spring.reactive.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> createEmployee(RequestEmployee requestEmployee) {
        Employee employee = modelMapper.map(requestEmployee, Employee.class);
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Employee> updateEmployee(RequestEmployee requestEmployee, Long id) {
        Employee employee = modelMapper.map(requestEmployee, Employee.class);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Void> deleteEmployee(Long id) {
        return employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }
}

package az.maqa.spring.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "department")
public class Department {

    private Long id;

    private String departmentName;

    private String departmentCode;

    private List<Employee> employees;
}

package az.maqa.spring.reactive.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "employee")
public class Employee {

    @Id
    private Long id;

    private String name;

    private String surname;

    private Integer age;

    private Double salary;

    private String city;

    private String country;

    @Column("zipcode")
    private String zipCode;

}

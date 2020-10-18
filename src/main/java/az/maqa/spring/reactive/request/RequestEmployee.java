package az.maqa.spring.reactive.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployee {
    private String name;

    private String surname;

    private Integer age;

    private Double salary;

    private String city;

    private String country;

    private String zipCode;
}

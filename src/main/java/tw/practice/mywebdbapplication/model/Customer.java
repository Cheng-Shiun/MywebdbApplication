package tw.practice.mywebdbapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    private int customerNumber;
    private String customerName;
    private String phone;
    private String city;
    private String country;
    private Double creditLimit;

}

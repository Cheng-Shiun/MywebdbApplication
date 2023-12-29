package tw.practice.mywebdbapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders_demo {
    int orderNumber;
    Date orderDate;
    Date requiredDate;
    String comments;
    String companyName;
}

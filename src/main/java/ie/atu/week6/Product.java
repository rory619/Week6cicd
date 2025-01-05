package ie.atu.week6;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull(message = "ID cannot be null")
    private int id;

    @NotBlank(message = "Name cant be blank")
    private String name;

    @Min(value = 0, message = "Price has to be greater than or equal to 0")
    private double price;
}
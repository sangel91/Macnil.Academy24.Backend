package macnil.academy.controller.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    

    @Getter
    @Setter
    @NotEmpty
    String titolo;

    @Getter
    @Setter
    @NotEmpty
    String body;
}

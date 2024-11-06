package macnil.academy.controller.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class BroadcastDto {

    @Getter
    @Setter
    @NotEmpty
    String title;

    @Getter
    @Setter
    @NotEmpty
    String body;
}

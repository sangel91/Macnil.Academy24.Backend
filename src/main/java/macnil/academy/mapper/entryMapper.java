package macnil.academy.mapper;

import macnil.academy.controller.dto.entryDto;
import macnil.academy.model.entryModel;
import org.springframework.stereotype.Component;

@Component
public class entryMapper {

    // Metodo per convertire da entryModel a entryDto
    public entryDto toDto(entryModel model) {
        if (model == null) {
            return null;
        }
        return entryDto.fromModel(model);
    }

    // Metodo per convertire da entryDto a entryModel
    public entryModel toModel(entryDto dto) {
        if (dto == null) {
            return null;
        }
        return dto.toModel();
    }
}

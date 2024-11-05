package macnil.academy.mapper;

import java.util.Date;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import macnil.academy.controller.dto.BroadcastDto;
import macnil.academy.model.Broadcast;

@Mapper(componentModel = "spring", imports = { Date.class })
public interface BroadcastMapper {
    
    /**
     * Mapping from DTO model to Entity model. 
     * @param broadcastDTO
     * @return broadcast
     */
    @Mapping(target = "creationDate", expression = "java(new Date())")
    Broadcast broadcastDtoToBroadcast(BroadcastDto broadcastDTO);

    /**
     * Mapping from Entity model to DTO. 
     * @param broadcast
     * @return broadcastDTO
     */
    BroadcastDto broadcastToBroadcastDto(Broadcast broadcast);

    /**
     * Map from Entity model to Entity model 
     * @param broadcast
     * @return updatedBroadcast
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "creationDate", ignore = true)
    })
    public abstract Broadcast updateOldBroadcastWithNewOne(@MappingTarget Broadcast oldBroadcast, Broadcast broadcast);
}

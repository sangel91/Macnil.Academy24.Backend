package macnil.academy.mapper;

import java.util.Date;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import macnil.academy.controller.dto.NewsDto;

import macnil.academy.model.News;

@Mapper(componentModel = "spring", imports =  {Date.class})
public interface NewsMapper {
    
//passare/mappare  oggetto a un altro oggetto da news a newsdto 
    @Mapping(target = "publish_date", expression = "java(new Date())")
    News newsDtoToNews (NewsDto newsDto);

    NewsDto newsToDtoNews( News news);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "publish_date", ignore = true)
    })
    public abstract News updateOldNewsWithNewOne(@MappingTarget News oldNews, News news);
}

package cs.vapo.bringit.core.dao.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUtils {

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        final ModelMapper modelMapper = new ModelMapper();
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

}

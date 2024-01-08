package com.ali.modulith.core.utils.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperManager implements ModelMapperService {
    private final ModelMapper mapper;

    public ModelMapperManager(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <D, E> E toEntity(Class<E> entities,D dClass) {
        return this.forRequest().map(dClass,entities);
    }

    @Override
    public <D,E> List<D> toEntity(List<E> entities,Class<D> dClass) {
        return entities.stream().map(e -> this.forResponse()
                .map(e,dClass))
                .collect(Collectors.toList());
    }

    @Override
    public ModelMapper forResponse() {
        this.mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper;
    }
    @Override
    public ModelMapper forRequest() {
        this.mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper;
    }
}

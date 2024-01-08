package com.ali.modulith.core.utils.modelMapper;


import org.modelmapper.ModelMapper;

import java.util.List;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    <D,E> List<D> toEntity(List<E> entities,Class<D> dClass);
    <D,E> E toEntity(Class<E> entities,D dClass);

}

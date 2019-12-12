package com.swiftcode.service.mapper;

import com.swiftcode.domain.FunPosition;
import com.swiftcode.service.dto.FunPositionDTO;
import org.mapstruct.Mapper;

/**
 * @author chen
 **/
@Mapper(componentModel = "spring")
public interface FunPositionMapper {
    FunPosition toEntity(FunPositionDTO dto);

    FunPositionDTO toDto(FunPosition position);
}

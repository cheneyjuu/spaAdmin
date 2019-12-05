package com.swiftcode.service.mapper;

import com.swiftcode.domain.Device;
import com.swiftcode.service.dto.DeviceDTO;
import org.mapstruct.Mapper;

/**
 * @author chen
 **/
@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toEntity(DeviceDTO deviceDTO);

    DeviceDTO toDto(Device device);
}

package com.swiftcode.service;

import com.google.common.collect.Lists;
import com.swiftcode.domain.FunPosition;
import com.swiftcode.repository.DeviceRepository;
import com.swiftcode.repository.FunPositionRepository;
import com.swiftcode.service.dto.DeviceDTO;
import com.swiftcode.service.dto.FunPositionDTO;
import com.swiftcode.service.mapper.DeviceMapper;
import com.swiftcode.service.mapper.FunPositionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能位置
 *
 * @author chen
 **/
@Service
public class FunPositionService {
    private FunPositionRepository repository;
    private FunPositionMapper mapper;
    private DeviceRepository deviceRepository;
    private DeviceMapper deviceMapper;

    public FunPositionService(FunPositionRepository repository, FunPositionMapper mapper, DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public FunPositionDTO addPosition(FunPositionDTO dto) {
        FunPosition position = repository.save(mapper.toEntity(dto));
        return mapper.toDto(position);
    }

    /**
     * 查找功能位置列表，返回树形结构
     *
     * @return 功能位置列表
     */
    public List<FunPositionDTO> findPositions() {
        List<FunPosition> allPositions = repository.findAll();
        List<FunPositionDTO> allDtos = allPositions
            .stream()
            .map(position -> mapper.toDto(position))
            .collect(Collectors.toList());
        List<FunPositionDTO> root = Lists.newArrayList();

        for (FunPosition position : allPositions) {
            if (position.getParentId() == 0) {
                FunPositionDTO dto = mapper.toDto(position);
                List<DeviceDTO> deviceList = deviceRepository.findByPositionId(dto.getId())
                    .stream()
                    .map(device -> deviceMapper.toDto(device))
                    .collect(Collectors.toList());
                // 默认展示第一层设备
                dto.setDeviceChildren(deviceList);
                root.add(dto);
            }
        }

        for (FunPositionDTO dto : root) {
            List<FunPositionDTO> childList = getChild(dto.getId(), allDtos);
            dto.setChildren(childList);
        }

        return root;
    }

    private List<FunPositionDTO> getChild(Long id, List<FunPositionDTO> allDtos) {
        List<FunPositionDTO> childList = Lists.newArrayList();
        for (FunPositionDTO dto : allDtos) {
            if (dto.getParentId().equals(id)) {
                List<DeviceDTO> deviceList = deviceRepository.findByPositionId(dto.getId())
                    .stream()
                    .map(device -> deviceMapper.toDto(device))
                    .collect(Collectors.toList());
                // 默认展示第一层设备
                dto.setDeviceChildren(deviceList);
                childList.add(dto);
            }
        }

        for (FunPositionDTO dto : childList) {
            dto.setChildren(getChild(dto.getId(), allDtos));
        }

        if (childList.size() == 0) {
            return Lists.newArrayList();
        }
        return childList;
    }
}

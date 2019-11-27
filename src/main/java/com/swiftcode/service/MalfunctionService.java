package com.swiftcode.service;

import com.swiftcode.domain.Malfunction;
import com.swiftcode.repository.MalfunctionRepository;
import com.swiftcode.service.dto.MalfunctionDTO;
import com.swiftcode.service.mapper.MalfunctionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chen
 **/
@Service
public class MalfunctionService {
    private MalfunctionRepository repository;
    private MalfunctionMapper mapper;

    public MalfunctionService(MalfunctionRepository repository, MalfunctionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MalfunctionDTO add(MalfunctionDTO dto) {
        Malfunction malfunction = new Malfunction();
        malfunction.newMalfunction(dto.getUserCode(), dto.getLocation(), dto.getDevice(), dto.getPictures(), dto.getVideo(), dto.getTarget(), dto.getDesc(), dto.getAddDesc(), dto.getRemark(), dto.getIsStop());
        Malfunction entity = repository.save(malfunction);
        return mapper.toDto(entity);
    }

    public MalfunctionDTO link(MalfunctionDTO dto) {
        Malfunction malfunction = repository.findById(dto.getId()).orElseThrow(IllegalArgumentException::new);
        malfunction.linkMalfunction(dto.getTitle(), dto.getSapNo());
        repository.save(malfunction);
        return mapper.toDto(malfunction);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<MalfunctionDTO> findByTradeNo(String tradeNo) {
        return Optional.of(repository.findByTradeNo(tradeNo))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(entity -> mapper.toDto(entity));
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<MalfunctionDTO> findById(Long id) {
        return repository.findById(id)
            .map(entity -> mapper.toDto(entity));
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<MalfunctionDTO> findByUser(String userCode) {
        return repository.findAllByUserCode(userCode)
            .stream()
            .map(entity -> mapper.toDto(entity))
            .collect(Collectors.toList());
    }
}

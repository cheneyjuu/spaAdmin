package com.swiftcode.service;

import com.swiftcode.config.Constants;
import com.swiftcode.domain.SapUser;
import com.swiftcode.repository.SapUserRepository;
import com.swiftcode.service.dto.SapUserDTO;
import com.swiftcode.service.mapper.SapUserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen
 **/
@Service
public class SapUserService {
    private SapUserRepository repository;
    private SapUserMapper mapper;
    private PasswordEncoder passwordEncoder;

    public SapUserService(SapUserRepository repository, SapUserMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(rollbackFor = Exception.class)
    public SapUserDTO addSapUser(SapUserDTO dto) {
        SapUser aUser = mapper.toEntity(dto);
        aUser.setPassword(passwordEncoder.encode(Constants.DEFAULT_PWD));
        SapUser sapUser = repository.save(aUser);
        return mapper.toDto(sapUser);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<SapUser> findAll() {
        return repository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void resetPassword(String userCode) {
        repository.findByUserCode(userCode).ifPresent(sapUser -> {
            sapUser.setPassword(passwordEncoder.encode(Constants.DEFAULT_PWD));
            repository.save(sapUser);
        });
    }
}

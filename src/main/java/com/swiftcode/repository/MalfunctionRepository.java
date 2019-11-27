package com.swiftcode.repository;

import com.swiftcode.domain.Malfunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author chen
 **/
public interface MalfunctionRepository extends JpaRepository<Malfunction, Long> {
    Optional<Malfunction> findByTradeNo(String tradeNo);

    List<Malfunction> findAllByUserCode(String userCode);
}

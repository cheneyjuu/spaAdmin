package com.swiftcode.repository;

import com.swiftcode.domain.Malfunction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chen
 **/
public interface MalfunctionRepository extends JpaRepository<Malfunction, Long> {
}

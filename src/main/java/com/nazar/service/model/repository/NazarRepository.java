package com.nazar.service.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.service.model.enums.NazarType;
import com.nazar.service.model.entity.NazarEntity;


public interface NazarRepository extends JpaRepository<NazarEntity, Long>{
    
    List<NazarEntity> findByType(NazarType type);
}

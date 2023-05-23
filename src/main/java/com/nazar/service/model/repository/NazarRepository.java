package com.nazar.service.model.repository;

import com.nazar.service.model.entity.NazarEntity;
import com.nazar.service.model.enums.NazarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NazarRepository extends JpaRepository<NazarEntity, Long>{
    
    List<NazarEntity> findByType(NazarType type);
}

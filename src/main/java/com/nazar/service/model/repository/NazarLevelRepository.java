package com.nazar.service.model.repository;

import com.nazar.service.model.entity.NazarLevelEntity;
import com.nazar.service.model.enums.NazarLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NazarLevelRepository extends JpaRepository<NazarLevelEntity, Long> {

    List<NazarLevelEntity> findAllByLevelOrderByRank(NazarLevel nazarLevel);
}

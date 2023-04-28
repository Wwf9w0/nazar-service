package com.nazar.service.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.service.model.entity.UserNazarEntity;

public interface UserNazarRepository extends JpaRepository<UserNazarEntity, Long> {
    
}

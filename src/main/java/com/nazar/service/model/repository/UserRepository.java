package com.nazar.service.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.service.model.enums.NazarType;
import com.nazar.service.model.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByUserName(String userName);

    List<UserEntity> findDistinctByMyNazars_type(NazarType type);

}

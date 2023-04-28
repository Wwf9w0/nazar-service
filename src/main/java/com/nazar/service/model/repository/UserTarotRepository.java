package com.nazar.service.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.service.model.entity.UserTarotEntity;

public interface UserTarotRepository extends JpaRepository<UserTarotEntity, Long> {

}

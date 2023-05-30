package com.nazar.service.model.repository;

import com.nazar.service.model.entity.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowingRepository extends JpaRepository<FollowingEntity, Long> {
}

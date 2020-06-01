package com.blitzware.brazukacarclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blitzware.brazukacarclean.model.ServiceItemModel;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItemModel, Long> {
}

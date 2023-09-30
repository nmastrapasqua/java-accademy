package com.sideagroup.accademy.repository;

import com.sideagroup.accademy.model.NameBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameBasicsRepository extends JpaRepository<NameBasics, String> {
}

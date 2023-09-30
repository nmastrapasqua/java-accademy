package com.sideagroup.accademy.repository;

import com.sideagroup.accademy.model.TitleBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleBasicsRepository extends JpaRepository<TitleBasics, String> {
}

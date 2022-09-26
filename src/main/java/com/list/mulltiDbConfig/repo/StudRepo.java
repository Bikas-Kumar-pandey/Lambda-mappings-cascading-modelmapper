package com.list.mulltiDbConfig.repo;

import com.list.mulltiDbConfig.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudRepo extends JpaRepository<Students, String> {
}

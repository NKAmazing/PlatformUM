package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
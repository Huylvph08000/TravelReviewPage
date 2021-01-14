package com.acazia.travelreview.repository;


import com.acazia.travelreview.models.ERole;
import com.acazia.travelreview.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}

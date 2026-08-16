package com.ecommerce.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.UserRegistration;

@Repository
public interface UserRegistraionRepository extends JpaRepository<UserRegistration, Long>{

	
	boolean existsByEmail(String email);

    boolean existsByMobileNo(String mobileNo);
	
    Optional<UserRegistration> findByEmail(String email);
    
}

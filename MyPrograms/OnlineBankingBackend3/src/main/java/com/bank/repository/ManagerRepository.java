package com.bank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer>
{
	Optional<Manager> findById(Long id);
}

package com.bank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	Optional<Employee> findById(Long id);

}

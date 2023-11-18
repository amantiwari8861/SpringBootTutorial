package com.bank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.entity.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer,Integer>
{
	Optional<Customer> findByAccountNumber(Long aadharNumber);
	Optional<Customer> findById(Long id);

}

package com.training.voting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.voting.entity.GoVoters;

@Repository
public interface GoVotersRepository extends JpaRepository<GoVoters, Long> {
	Optional<GoVoters> findByAadharNumber(Long aadharNumber);
}

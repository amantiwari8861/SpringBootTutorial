package com.training.voting.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.voting.entity.GoVoters;
import com.training.voting.exception.AadharNumberDoesNotExistsException;
import com.training.voting.exception.GoVoterDoesNotExistsException;
import com.training.voting.repository.GoVotersRepository;
import com.training.voting.service.GoVotersService;

@Service
public class GoVotersServiceImpl implements GoVotersService {

	@Autowired
	GoVotersRepository repository;

	@Override
	public GoVoters saveVoter(GoVoters voters) {
		return repository.save(voters);
	}

	@Override
	public GoVoters updateVoter(GoVoters voters) {
		return repository.save(voters);
	}

	@Override
	public Boolean deleteVoter(Long id) {
		GoVoters goVoters = getVoterById(id);
		repository.delete(goVoters);
		return true;
	}

	@Override
	public GoVoters getVoterById(Long id) {
		Optional<GoVoters> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new GoVoterDoesNotExistsException("The Voter with id " + id + " does not exists");
	}

	@Override
	public GoVoters getVoterByAadharNumber(Long aadharNumber) {
		Optional<GoVoters> byAadharNumber = repository.findByAadharNumber(aadharNumber);
		if(byAadharNumber.isPresent()) {
			return byAadharNumber.get();
		}
		throw new AadharNumberDoesNotExistsException("Aadhar Number "+aadharNumber+" does not exists");
	}

	@Override
	public List<GoVoters> getAllVoters() {
		return repository.findAll();
	}

}

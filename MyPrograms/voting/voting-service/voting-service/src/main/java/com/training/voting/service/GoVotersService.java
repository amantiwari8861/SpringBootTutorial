package com.training.voting.service;

import java.util.List;

import com.training.voting.entity.GoVoters;

public interface GoVotersService {

	public GoVoters saveVoter(GoVoters voters);
	public GoVoters updateVoter(GoVoters voters);
	public Boolean deleteVoter(Long id);
	public GoVoters getVoterById(Long id);
	public GoVoters getVoterByAadharNumber(Long aadharNumber);
	public List<GoVoters> getAllVoters();
}

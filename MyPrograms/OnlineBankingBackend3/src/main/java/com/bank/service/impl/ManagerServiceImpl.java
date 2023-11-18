package com.bank.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.entity.Manager;
import com.bank.repository.ManagerRepository;
import com.bank.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	ManagerRepository repository;

	@Override
	public Manager saveManager(Manager manager) {
		return repository.save(manager);
	}

	@Override
	public Manager updateManager(Manager manager) {
		return repository.save(manager);
	}

	@Override
	public Boolean deleteManager(Long id) {
		Manager goManagers = getManagerById(id);
		repository.delete(goManagers);
		return true;
	}

	@Override
	public Manager getManagerById(Long id) {
		Optional<Manager> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	@Override
	public List<Manager> getAllManagers() {
		return repository.findAll();
	}

}

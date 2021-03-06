package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User addUser(User u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public void deleteUser (long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public User retrieveUser(long id) {
		return userRepository.findById(id).get();
		
	}


}

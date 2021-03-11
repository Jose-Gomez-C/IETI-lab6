package edu.escuelaing.ieti.services.ipml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users;
	
	public UserServiceImpl() {
		users = new ArrayList<User>();
		users.add(new User("0", "jose", "jose@gmail.com", "Hola123"));
		
	}
	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getById(String userId) {
		User usuario = null;
		for (User u: users) {
			if(u.getId().equals(userId)) {
				usuario = u;
			}
		}
		return usuario;
	}

	@Override
	public User create(User user) {
		users.add(user);
		return user;
	}

	@Override
	public User update(User user) {
		for (int i =0; i< users.size(); i++) {
			if(users.get(i).getId().equals(user.getId())) {
				users.set(i, user);
			}
		}
		return user;
	}

	@Override
	public void remove(String userId) {
		for (int i =0; i< users.size(); i++) {
			if(users.get(i).getId().equals(userId)) {
				System.out.println("hola");
				users.remove(i);
			}
		}
	}
}

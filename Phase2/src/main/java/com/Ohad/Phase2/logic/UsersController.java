package com.Ohad.Phase2.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Ohad.Phase2.beans.User;
import com.Ohad.Phase2.dao.UsersDao;
import com.Ohad.Phase2.enums.ClientType;
import com.Ohad.Phase2.enums.ErrorType;
import com.Ohad.Phase2.exceptions.ApplicationException;

@Controller
public class UsersController {

	@Autowired
	private UsersDao usersDao;

	public UsersController() {
		super();
	}

	public long createUser(User user) throws ApplicationException {
		if (usersDao.isUserExistsByName(user.getUserName())) {
			throw new ApplicationException(ErrorType.NAME_ALREADY_EXISTS,
					"Cannot create new user UserName already exists");
		}
		return usersDao.createUser(user);
	}

	public void updateUser(User user) throws ApplicationException {
		if (usersDao.isUserExistsByName(user.getUserName())) {
			throw new ApplicationException(ErrorType.NAME_ALREADY_EXISTS, "Cannot update user UserName already exists");
		}
		usersDao.updateUser(user);
		return;
	}

	public void deleteUserbyID(long userId) throws ApplicationException {
		usersDao.deleteUserById(userId);
		return;
	}

	public User getUserbyID(long userId) throws ApplicationException {
		return usersDao.getUserbyID(userId);
	}

	public ClientType login(User user) throws ApplicationException {
		if (usersDao.login(user.getUserName(), user.getPassword())) {
			return user.getType();
		}
		return ClientType.UnknownUser;
	}

	public User getUserByUserName(String userName) throws ApplicationException {
		return usersDao.getUserByUserName(userName);
	}

}

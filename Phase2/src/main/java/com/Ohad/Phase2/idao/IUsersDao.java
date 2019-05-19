package com.Ohad.Phase2.idao;

import com.Ohad.Phase2.beans.User;
import com.Ohad.Phase2.exceptions.ApplicationException;

public interface IUsersDao {
	
	public long createUser(User user) throws ApplicationException;
	public void updateUser(User user) throws ApplicationException;
	public void deleteUserById(long User_ID) throws ApplicationException;
	public User getUserByID (long User_ID) throws ApplicationException;
	public boolean login(String user, String password) throws ApplicationException;

}

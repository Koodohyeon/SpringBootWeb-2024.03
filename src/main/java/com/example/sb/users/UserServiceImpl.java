package com.example.sb.users;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {		// impl은 interface 가 아니라 class
	
	@Autowired
	private UserDao uDao;

	@Override
	public User getUserByUid(String uid) {
		User user = uDao.getUser(uid);
		return user;
	}

	@Override
	public List<User> getUserList(int page) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		return uDao.getUserList(COUNT_PER_PAGE, offset);
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerUser(User user) {
		uDao.insertUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		uDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(String uid) {
		uDao.deleteUser(uid);
		
	}

	@Override
	public int login(String uid, String pwd) {
		User user = uDao.getUser(uid);
		if (user == null)
			return USER_NOT_EXIST;
		if (BCrypt.checkpw(pwd, user.getPwd()))
			return CORRECT_LOGIN;
		return WRONG_PASSWORD;
	}

}

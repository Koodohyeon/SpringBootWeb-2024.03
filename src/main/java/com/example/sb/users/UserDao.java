package com.example.sb.users;

import java.util.List;	

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper // 이거 하나면 select 만 이용하고 예전처럼 sql =? 이런식으로 사용 안해도 댐
public interface UserDao {

	@Select("select * from users where uid=#{uid}")	// sql 문법
	User getUser(String uid); 
	
	@Select("select * from users where isDeleted=0 order by regDate desc"
			+ " limit #{count} offset #{offset}")	// desc 내림차순
	List<User> getUserList(int count, int offset);
	
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}, #{email}, default, default)")
	void insertUser( User user);
	
	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email} where uid=#{uid}")
	void updateUser(User user);
	
	@Update("update users set isDeleted=1 where uid=#{uid}")
	void deleteUser(String uid);
	
	@Select("select count(uid) from users where isDeleted=0")		//	왜 이것만 그냥 uid일까?
	int getUserCount();
	
}

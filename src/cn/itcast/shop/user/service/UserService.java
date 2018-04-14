package cn.itcast.shop.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.regexp.internal.recompile;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.vo.User;
import cn.itcast.shop.utils.MailUitls;
import cn.itcast.shop.utils.UUIDUtils;

/**
 * 用户模块业务层代码
 *
 */
@Transactional
public class UserService {
	//注入UserDao;
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	//按用户名查询用户的方法；
	public User findByUsername(String username) {
		return userDao.findByUserName(username);
	}
	 
	//业务层完成用户注册代码
	public void save(User user) {
		//将数据存入数据库
		user.setState(0);//0:代表用户未激活，1：代表用户激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		MailUitls.sendMail(user.getEmail(), code);
	}
	
	//业务层根据激活码查询用户
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
		
	}
	
	//修改用户的状态的方法
	public void update(User existUser) {
		userDao.update(existUser);
	}
	
	//用户登录的方法
	public User login(User user) {
		return userDao.login(user);
		
	}

}

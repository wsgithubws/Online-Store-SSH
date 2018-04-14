package cn.itcast.shop.user.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import cn.itcast.shop.user.vo.User;

/**
 * 用户模块持久层代码
 *
 */
public class UserDao extends HibernateDaoSupport{
	//按照名称查询是否有该用户；
	public User findByUserName(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql,username);
	    
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	//注册用户存入数据库代码实现
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	
	//根据激活码查询用户
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql,code);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	//修改用状态
	public void update(User existUser) {
			this.getHibernateTemplate().update(existUser);
	}
		
		
    //
	public User login(User user) {
	    	 String hql = "from User where username = ? and password = ?";
	 		 List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
	 		 
	 		if(list!=null&&list.size()>0) {
				return list.get(0);
			}
	 		 return null;

    }
}

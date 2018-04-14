package cn.itcast.shop.category.dao;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import cn.itcast.shop.category.vo.Category;

/**
 * 一级分类的持久层对象
 *
 */
public class CategoryDao extends HibernateDaoSupport{
	
	public List<Category> findAll() {
		String hql ="from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
	    
		return list;
	}

	// Dao中的保存一级分类的方法
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	// Dao中根据一级分类id查询一级分类
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	// DAO中删除一级分类
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	// Dao中修改一级分类
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

	
	
}

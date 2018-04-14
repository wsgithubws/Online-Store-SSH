package cn.itcast.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 权限拦截器:
 *
 */
 
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 判断是否登录,如果登录,放行,没有登录,跳转到登录页面.
		AdminUser adminExistUser = (AdminUser) ServletActionContext.getRequest()
				.getSession().getAttribute("existAdminUser");
		if(adminExistUser == null){
			// 没有登录:
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("您还没有登录!请先去登录!");
			return support.LOGIN;
		}else{
			// 已经登录
			return actionInvocation.invoke();
		}
	}

}

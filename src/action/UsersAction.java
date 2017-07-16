package action;


import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOimpl;

public class UsersAction extends superAction implements ModelDriven<Users>{

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Users user =new Users();
    
    
    //�û���¼����
    public String login()
    {
    	
    	UsersDAO usersDAO=new UsersDAOimpl();
    	System.out.println(user.getUsername()+","+user.getPassword());
    	if(usersDAO.usersLogin(user))
    	{
    		session.setAttribute("loginUserName", user.getUsername());
    		return "login_success";
    	}else
    	{
    		return "login_failure";
    	}
    }
    
    //ע����
    @SkipValidation
    public String loginout()
    {
    	if(session.getAttribute("loginUserName")!=null)
    	{
    		session.removeAttribute("loginUserName");
    	}
    	return "loginout_success";
    }
    
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim()))
		{
			this.addFieldError("usernameError","�û�����Ϊ��");
		}
		
		if(user.getPassword().length()<6)
		{
			this.addFieldError("passwordError","���벻��С��6λ");
		}
	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}

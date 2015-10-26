package com.pzy.action.index;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.HistoryScore;
import com.pzy.entity.Plan;
import com.pzy.entity.User;
import com.pzy.service.HistoryScoreService;
import com.pzy.service.PlanService;
import com.pzy.service.UserService;

@SuppressWarnings("serial")
@ParentPackage("struts-default")
@Namespace("/")
public class IndexAction extends ActionSupport {

	private User user;
	
	private Plan plan;
	
	private List<Plan> plans;
	private String tip;
	private List<HistoryScore> historyScores;
	private Integer  type;
	@Autowired
	private UserService userService;
	@Autowired
	private PlanService planService;
	@Autowired
	private HistoryScoreService historyScoreService;
	public String execute() throws Exception {
		return SUCCESS;
	}
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/index.jsp") })
	public String index() throws Exception {
		return SUCCESS;
	}
	@Action(value = "plan", results = { @Result(name = "success", location = "/WEB-INF/views/plan.jsp") })
	public String plan() throws Exception {
		User user=(User)ActionContext.getContext().getSession().get("user");
		 plans=planService.findByUser(user);
		return SUCCESS;
	}
	@Action(value = "school", results = { @Result(name = "success", location = "/WEB-INF/views/school.jsp") })
	public String school() throws Exception {
		return SUCCESS;
	}
	@Action(value = "major",  results = { @Result(name = "success", location = "/WEB-INF/views/major.jsp") })
	public String major() throws Exception {
		return SUCCESS;
	}
	/**推荐学校*/
	@Action(value = "planschool", results = { @Result(name = "success", location = "/WEB-INF/views/plansugest.jsp") })
	public String planschool() throws Exception {
		Plan newplan=planService.find(plan.getId());
		Integer orderBegain=newplan.getNum()-1000;
		Integer orderEnd=newplan.getNum()+1000;
		historyScores=historyScoreService.findAll(type, orderBegain, orderEnd);
		return SUCCESS;
	}
	/**报考建议*/
	@Action(value = "plansugest", results = { @Result(name = "success", location = "/WEB-INF/views/plansugest.jsp") })
	public String plansugest() throws Exception {
		return SUCCESS;
	}
	/**创建方案*/
	@Action(value = "createplan", results = { @Result(name = "success", location = "/WEB-INF/views/createplan.jsp") })
	public String createPlan() throws Exception {
		return SUCCESS;
	}
	/**注册*/
	@Action(value = "doregister", results = { @Result(name = "success", location = "/WEB-INF/views/login.jsp") })
	public String doregister() throws Exception {
		userService.save(user);
		this.tip="注册成功请登录！";
		return SUCCESS;
	}
	/***
	 * 登录逻辑 查找数据库比较用户名密码
	 * @return
	 * @throws Exception
	 */
	 @Action(value = "dologin", 
	    		results = { @Result(name = "success" ,type="redirect", location = "index") ,
	    					@Result(name = "login", location = "/WEB-INF/views/login.jsp") })  
	 public String dologin() throws Exception { 
	    	User loginuser=userService.login(user.getName(), user.getPassword());
	    	if(loginuser!=null){
	    		ActionContext.getContext().getSession().put("user",loginuser );
	            return SUCCESS; 
	    	}
	    	else{
	    		ActionContext.getContext().getSession().clear();
	    		this.tip="登陆失败 不存在此用户名或密码!";
	    		return LOGIN;
	    	}
	    	
	}
	 
	 @Action(value = "docreateplan", results = { @Result(name = "success", location = "/WEB-INF/views/plan.jsp") })
	public String docreateplan() throws Exception {
		 User user=(User)ActionContext.getContext().getSession().get("user");
		 plan.setUser(user);
		 planService.save(plan);
		 plans=planService.findByUser(user);
		 this.tip="方案创建成功！";
		 return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
	
		this.user = user;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	public List<HistoryScore> getHistoryScores() {
		return historyScores;
	}
	public void setHistoryScores(List<HistoryScore> historyScores) {
		this.historyScores = historyScores;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}

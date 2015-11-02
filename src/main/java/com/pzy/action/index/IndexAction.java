package com.pzy.action.index;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.Category;
import com.pzy.entity.HistoryMajor;
import com.pzy.entity.HistoryScore;
import com.pzy.entity.News;
import com.pzy.entity.Plan;
import com.pzy.entity.School;
import com.pzy.entity.User;
import com.pzy.service.CategoryService;
import com.pzy.service.HistoryMajorService;
import com.pzy.service.HistoryScoreService;
import com.pzy.service.NewsService;
import com.pzy.service.PlanService;
import com.pzy.service.SchoolService;
import com.pzy.service.UserService;

@SuppressWarnings("serial")
@ParentPackage("struts-default")
@Namespace("/")
public class IndexAction extends ActionSupport {

	private User user;
	
	private Plan plan;
	
	private List<Plan> plans;
	private String tip;
	private String key;
	private List<HistoryScore> historyScores;
	private School school;
	private List<School> schools;
	
	private List<Category> categorys;
	
	private List<HistoryMajor> historMajors;
	private News news;
	private List<News> newss;
	private Category category;
	private Integer  type;
	@Autowired
	private UserService userService;
	@Autowired
	private PlanService planService;
	@Autowired
	private HistoryScoreService historyScoreService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private HistoryMajorService historyMajorService;
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
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
		schools=this.schoolService.findByName(key);
		return SUCCESS;
	}
	@Action(value = "viewschool", results = { @Result(name = "success", location = "/WEB-INF/views/viewschool.jsp") })
	public String viewschool() throws Exception {
		school=schoolService.find(school.getId());
		return SUCCESS;
	}
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	@Action(value = "news",  results = { @Result(name = "success", location = "/WEB-INF/views/news.jsp") })
	public String news() throws Exception {
		this.newss=this.newsService.findAll();
		return SUCCESS;
	}
	@Action(value = "viewnews", results = { @Result(name = "success", location = "/WEB-INF/views/viewnews.jsp") })
	public String viewnews() throws Exception {
		news=newsService.find(news.getId());
		return SUCCESS;
	}
	@Action(value = "category",  results = { @Result(name = "success", location = "/WEB-INF/views/category.jsp") })
	public String category() throws Exception {
		this.categorys=this.categoryService.findAll(key);
		return SUCCESS;
	}
	@Action(value = "viewcategory", results = { @Result(name = "success", location = "/WEB-INF/views/viewcategory.jsp") })
	public String viewcategory() throws Exception {
		category=categoryService.find(category.getId());
		return SUCCESS;
	}
	/**推荐学校*/
	@Action(value = "planschool", results = { @Result(name = "success", location = "/WEB-INF/views/planschool.jsp") })
	public String planschool() throws Exception {
		Plan newplan=planService.find(plan.getId());
		Integer orderBegain=newplan.getNum()-1000;
		Integer orderEnd=newplan.getNum()+1000;
		historyScores=historyScoreService.findAll(type, orderBegain, orderEnd);
		return SUCCESS;
	}
	/**推荐专业*/
	@Action(value = "plancategory", results = { @Result(name = "success", location = "/WEB-INF/views/plancategory.jsp") })
	public String plancategory() throws Exception {
		historMajors=historyMajorService.findAll();
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public List<News> getNewss() {
		return newss;
	}
	public void setNewss(List<News> newss) {
		this.newss = newss;
	}
	public List<HistoryMajor> getHistorMajors() {
		return historMajors;
	}
	public void setHistorMajors(List<HistoryMajor> historMajors) {
		this.historMajors = historMajors;
	}
}

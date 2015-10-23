package com.pzy.action.index;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
/***
 * 处理前台的各种跳转
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@ParentPackage("struts-default")
@Namespace("/")
public class IndexAction extends ActionSupport {

	
	/***首页
	 * 对应http://127.0.0.1:8080/tuangou/
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/index.jsp") })
	public String index() throws Exception {
		return SUCCESS;
	}
	/***
	 * 点击商品显示详细信息页面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "detail", results = { @Result(name = "success", location = "/WEB-INF/views/detail.jsp") })
	public String detail() throws Exception {
		return SUCCESS;
	}
	
}

<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ch">
<%@ include file="../common/meta.jsp"%>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/ace/admin.guest.js"></script>

 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		 var ue = UE.getEditor('context');
		 var ue1 = UE.getEditor('zszc');
		 var ue2 = UE.getEditor('zsjh');
		 var ue33 = UE.getEditor('sfbz');
		if("${tip}" != null && "${tip}" != ""){
			noty({"text":"${tip}","layout":"top","type":"success","timeout":"2000"});
		}
		$(".date").datetimepicker({
			language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
	        format:'yyyy-mm-dd',
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
	});
</script>
</head>
<body>
	<div class="layout">
		<!-- top -->
		<%@ include file="../top.jsp"%>
		<!-- 导航 -->
		<%@ include file="../menu.jsp"%>
		
		<input type="hidden" id="hf_id" />

		<div class="main-wrapper">
			<div class="container-fluid">
				<div class="row-fluid ">
					<div class="span12">
						<div class="content-widgets light-gray">
							<div class="widget-head  bondi-blue" >
								<h3>添加学校信息</h3>
							</div>
							
							<div class="widget-container">
								
							<form action="${pageContext.request.contextPath}/admin/school/save" method="post" id=''>
							<div class="control-group">
								<label for="title" class="control-label">学校名称：</label>
								<div class="controls">
									<input type="text" name="school.name" placeholder="" class="span6">
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">学校地址：</label>
								<div class="controls">
									<input type="text" name="school.addr" placeholder="" class="span6">
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">学校招生电话：</label>
								<div class="controls">
									<input type="text" name="school.tel" placeholder="" class="span6">
								</div>
							</div>
							
							<div class="control-group">
								<label for="title" class="control-label">招生邮箱：</label>
								<div class="controls">
									<input type="text" name="school.email" placeholder="" class="span6">
								</div>
							</div>
							
							<div class="control-group">
								<label for="title" class="control-label">学校网站：</label>
								<div class="controls">
									<input type="text" name="school.site" placeholder="" class="span6">
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">学校类型：</label>
								<div class="controls">
									<select name="school.type" class="span6">
									<option value="综合类">综合类</option>
									<option value="985高校">985高校</option>
									<option value="211高校">211高校</option>
									<option value="教育部直属">教育部直属</option>
									</select>
								</div>
							</div>
							
							<div class="control-group">
								<label for="title" class="control-label">学校信息：</label>
								<div class="controls">
									<textarea  id='context' name='school.context' style="width: 100%;height: 400px"></textarea>
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">招生计划：</label>
								<div class="controls">
									<textarea  id='zsjh' name='school.zsjh' style="width: 100%;height: 400px"></textarea>
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">招生章程：</label>
								<div class="controls">
									<textarea  id='zszc' name='school.zszc' style="width: 100%;height: 400px"></textarea>
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">收费标准：</label>
								<div class="controls">
									<textarea  id='sfbz' name='school.sfbz' style="width: 100%;height: 400px"></textarea>
								</div>
							</div>
								<div class="modal-footer center" id="div_footer">
									<button type="submit" class='btn btn-primary'>提交</button>
								</div>
						</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../foot.jsp"%>
	</div>
</body>
</html>
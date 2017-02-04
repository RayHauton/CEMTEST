<%--
Created by IntelliJ IDEA.
User: RayHauton
Date: 2016/12/6
Time: 21:22
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>校友基本信息登记</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/view_set/base.css">
	<link rel="stylesheet" href="../css/view_set/base-information.css">
</head>
<body>
	<div class="box">
		<div class="subnav">
			<ul id="select" class="select">
				<li style="cursor:pointer;">基础信息</li>
				<li style="cursor:pointer;">职业信息</li>
				<li style="cursor:pointer;">工作满意程度与待遇成就</li>
			</ul>
		</div>
		<div id="content" style="border-left: 2px solid mediumseagreen;">
			<!-- 基础信息模块 -->
			<div style="display:block; margin-left: 20px;font-size: 16px;">
				<form action="" id="base">			
					<h2>基础信息模块</h2>
					<p>您的姓名：<input type="text"placeholder="请输入真实姓名"></p>
					<p>您的性别：</p>
					<p>
						<label><input type="radio" name="sex" value="男" checked="checked">男</label>
						<label><input type="radio" name="sex" value="女">女</label>
					</p>
					<p>您的出生日期：
						<input type="date">
					</p>
					<p>您的电子邮箱：<input type="text" placeholder="请输入常用邮箱"></p>
					<p>您的手机联系方式：<input type="text" placeholder="请输入手机号码"></p>
					<p>您在南航经管院的求学经历：</p>
					<p id="major">
						<label><input type="radio" name="education">专科</label>
						<label><input type="radio" name="education">本科</label>
						<label><input type="radio" name="education">硕士</label>
						<label><input type="radio" name="education">博士</label>
						<label><input type="radio" name="education">博士后</label>		
					</p>
					<p id="majorP">您所学习的专业：</p>
					<div id="majorName">
						<p>
							<label><input type="radio" name="major" >工业外贸</label>
							<label><input type="radio" name="major" >会计学</label>			
							<label><input type="radio" name="major" >市场营销</label>
						</p>
						<p>
							<label><input type="radio" name="major" >管理工程</label>
							<label><input type="radio" name="major" >工业工程</label>		
							<label><input type="radio" name="major" >信息管理与信息系统</label>
							<label><input type="radio" name="major" >工商管理</label>
							<label><input type="radio" name="major" >市场营销</label>
							<label><input type="radio" name="major" >会计学</label>
							<label><input type="radio" name="major" >国际经济与贸易</label>
							<label><input type="radio" name="major" >电子商务</label>
							<label><input type="radio" name="major" >金融学</label>
						</p>
						<p>
							<label><input type="radio" name="major" >区域经济学</label>
							<label><input type="radio" name="major" >金融学</label>		
							<label><input type="radio" name="major" >产业经济学</label>
							<label><input type="radio" name="major" >国际贸易学</label>
							<label><input type="radio" name="major" >数量经济学</label>
							<label><input type="radio" name="major" >国防经济</label>
							<label><input type="radio" name="major" >统计学</label>
							<label><input type="radio" name="major" >系统工程</label>
							<label><input type="radio" name="major" >管理科学与工程</label>
							<label><input type="radio" name="major" >金融工程</label>
							<label><input type="radio" name="major" >工业工程</label>
							<label><input type="radio" name="major" >工程与项目管理</label>
							<label><input type="radio" name="major" >会计学</label>
							<label><input type="radio" name="major" >企业管理</label>
							<label><input type="radio" name="major" >技术经济及管理</label>
							<label><input type="radio" name="major" >行政管理</label>
							<label><input type="radio" name="major" >教育经济与管理</label>
						</p>
						<p>
							<label><input type="radio" name="major" >系统工程</label>
							<label><input type="radio" name="major" >工程项目与管理</label>
							<label><input type="radio" name="major" >经济与产业管理</label>
						</p>
					</div>
					<p>您工作或居住地址：</p>
					<p>
						<label><input type="radio" name="address">国内</label>
						<label><input type="radio" name="address">国外</label>	
					</p>
					<p>您的详细地址：
						<input type="text" placeholder="请输入详细地址">	
					</p>
					<div class="btncus">
						<input type="submit" value="提交" class="btn-success"">
						<input type="reset" value="重置" class="btn-warning">
					</div>
				</form>
			</div>	
			<!-- 职业信息模块 -->
			<div>
				<form action="" id="occupation">	
					<h2>职业信息模块</h2>
					<p>您的工作单位性质：</p>
					<p>				
						<label><input type="radio" name="nature">企事业单位工作</label>
						<label><input type="radio" name="nature">自主创业</label>
						<label><input type="radio" name="nature">其他</label>	
					</p>
					<p>您的工作单位名称：<input type="text"></p>
					<p>您的工作职务：<input type="text"></p>
					<p>您的工作职称：<input type="text"></p>
					<div class="btn">
						<input type="submit" value="提交">
						<input type="reset" value="重置">
					</div>
				</form>
			</div>
			<!-- 工作满意程度与待遇成就 -->
			<div>
				<form action="" id="job">
					<h2>工作待遇成就与满意程度</h2>
					<p>您目前的税前年收入（有工作带来的包含工资、奖金、补贴、分红等）：</p>
					<p class="income">
						<label><input type="radio" name="income" checked="checked">五万以下</label>
						<label><input type="radio" name="income">五到十万</label>
						<label><input type="radio" name="income">十到二十万</label>
						<label><input type="radio" name="income">二十到三十万</label>
						<label><input type="radio" name="income">三十万到五十万</label>
						<label><input type="radio" name="income">五十万到一百万</label>
						<label><input type="radio" name="income">一百万以上</label>
					</p>					
					<p>您工作几年以后职位得到第一次晋升：
						<input type="text" placeholder="请输入数字"><span>年</span>
					</p>
					<p>您获得的最高荣誉级别是：
					</p>
					<p>
						<label><input type="radio" name="honor" value="">无</label>
						<label><input type="radio" name="honor" value="">单位内</label>
						<label><input type="radio" name="honor" value="">市级</label>
						<label><input type="radio" name="honor" value="">省部级</label>
						<label><input type="radio" name="honor" value="">国家级</label>
						<label><input type="radio" name="honor" value="">国际级</label>
					</p>
					<p>您共有几次转换工作单位的经历：</p>
					<p>
						<label><input type="radio" name="change">0次</label>
						<label><input type="radio" name="change">1次</label>
						<label><input type="radio" name="change">两次</label>
						<label><input type="radio" name="change">三到五次</label>
						<label><input type="radio" name="change">五次以上</label>
					</p>
					<p>您对目前工作的满意程度：
						<select name="satisfied" id="">
							<option value="非常满意">非常满意</option>
							<option value="比较满意">比较满意</option>
							<option value="不是很满意">不是很满意</option>
							<option value="非常不满意">非常不满意</option>
						</select>
						<!--不满意的原因(具体选项待确定)-->
					</p>	
					<p>您不满意的原因是：</p>
					<p class="reason">
						<p>
							<span>工作内容：</span>
							<label><input type="checkbox">工作对象</label>
							<label><input type="checkbox">工作任务</label>							
							<label><input type="checkbox">工作职责</label>
						</p>
						<p>
							<span>工作强度：</span>
							<label><input type="checkbox">工作时间</label>
							<label><input type="checkbox">工作方式</label>							
							<label><input type="checkbox">工作量</label>
						</p>
						<p>
							<span>工作环境：</span>
							<label><input type="checkbox">物理环境</label>
							<label><input type="checkbox">人文环境</label>
						</p>
						<p>
							<span>工作控制：</span>
							<label><input type="checkbox">直接上司</label>
							<label><input type="checkbox">监督管理</label>							
							<label><input type="checkbox">绩效考核</label>
						</p>
						<p>
							<span>薪酬福利：</span>
							<label><input type="checkbox">工资奖金</label>
							<label><input type="checkbox">津贴福利</label>
						</p>
						<p>
							<span>个人发展：</span>
							<label><input type="checkbox">锦绣机会</label>
							<label><input type="checkbox">晋升空间</label>							
							<label><input type="checkbox">职业变通</label>
						</p>
						<p>
							<span>社会资源：</span>
							<label><input type="checkbox">人际关系</label>
							<label><input type="checkbox">社会地位</label>
						</p>
						<p>
							<span>工作满意度：</span>
							<label><input type="checkbox">公平感</label>
							<label><input type="checkbox">成就感</label>							
							<label><input type="checkbox">自我实现</label>
						</p>							
					</p>						
					<div class="btncus">
						<input type="submit" value="提交">
						<input type="reset" value="重置">
					</div>	
				</form>
			</div>
		</div>
	</div>
	<script src="../js/change.js"></script>
	<script>
		var major = getId("major");
		var major_p = getId("majorP");
		var majorName = getId("majorName");
		var liDom = major.getElementsByTagName("input");
		for (var i = 0; i < liDom.length; i++) {
			liDom[i].index = i;//记录索引
			liDom[i].onclick = function(){//绑定点击事件
				var majorP = majorName.getElementsByTagName("p")[this.index];//根据索引找到对应的divDom，
				if (majorP) {
					majorName.style.display = "block";
					majorP.style.display = "block";//使divDom的display状态为block
					sibling(majorP,function(){//divDom的兄弟节点的display状态为none
						this.style.display = "none";
						major_p.style.display = "block";
						});
					
				}else{
					majorName.style.display = "none";
					major_p.style.display = "none";
				};
		};
	};
	</script>
</body>
</html>
<%--
Created by IntelliJ IDEA.
User: RayHauton
Date: 2016/12/6
Time: 21:22
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li style="cursor: pointer;">基础信息</li>
				<li style="cursor: pointer;">职业信息</li>
				<li style="cursor: pointer;">工作满意程度与待遇成就</li>
			</ul>
		</div>
		<div id="content" style="border-left: 2px solid mediumseagreen;">
			<!-- 基础信息模块 -->
			<div style="display: block; margin-left: 20px; font-size: 16px;">
				<form action="" id="base">
					<h2>基础信息模块</h2>
					<p>
						您的姓名：<input type="text" placeholder="请输入真实姓名" name="truename">
					</p>
					<p>您的性别：</p>
					<p>
						<label><input type="radio" name="sex" value="男"
							checked="checked">男</label> <label><input type="radio"
							name="sex" value="女">女</label>
					</p>
					<p>
						您的出生日期： <input type="date" name="birth">
					</p>
					<p>您工作或居住地址：</p>
					<p>
						<label><input type="radio" name="country" value="中国">国内</label> <label><input
							type="radio" name="country">国外</label>
					</p>
					<p>
						您的详细地址： <input type="text" placeholder="请输入详细地址" name="address">
					</p>
					<div class="btncus">
						<input type="button" value="提交" class="btn-success"
							onclick="baseSkip();"> <input type="reset" value="重置"
							class="btn-warning">
					</div>
				</form>
			</div>
			<!-- 职业信息模块 -->
			<div>
				<form action="" id="occupation">
					<h2>职业信息模块</h2>
					<p>您的工作单位性质：</p>
					<p>
						<label><input type="radio" name="companyNature" value="0">企事业单位工作</label>
						<label><input type="radio" name="companyNature" value="1">自主创业</label>
						<label><input type="radio" name="companyNature" value="2">其他</label>
					</p>
					<p>
						您的工作单位名称：<input type="text" name="companyName">
					</p>
					<p>
						您的工作职务：<input type="text" name="positionName">
					</p>
					<p>
						您的工作职称：<input type="text" name="jobRank">
					</p>
					<div class="btn">
						<input type="button" value="提交" onclick="occupationSkip()">
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
						<label><input type="radio" name="income" checked="checked"
							value="1">五万以下</label> <label><input type="radio"
							name="income" value="2">五到十万</label> <label><input
							type="radio" name="income" value="3">十到二十万</label> <label><input
							type="radio" name="income" value="4">二十到三十万</label> <label><input
							type="radio" name="income" value="5">三十万到五十万</label> <label><input
							type="radio" name="income" value="6">五十万到一百万</label> <label><input
							type="radio" name="income" value="7">一百万以上</label>
					</p>
					<p>
						您工作几年以后职位得到第一次晋升： <input type="text" placeholder="请输入数字"
							name="firstPromote"><span>年</span>
					</p>
					<p>您获得的最高荣誉级别是：</p>
					<p>
						<label><input type="radio" name="honorLevel" value="0">无</label>
						<label><input type="radio" name="honorLevel" value="1">单位内</label>
						<label><input type="radio" name="honorLevel" value="2">市级</label>
						<label><input type="radio" name="honorLevel" value="3">省部级</label>
						<label><input type="radio" name="honorLevel" value="4">国家级</label>
						<label><input type="radio" name="honorLevel" value="5">国际级</label>
					</p>
					<p>
						具体荣誉名称： <input type="text" name="honorName">
					</p>
					<p>您共有几次转换工作单位的经历：</p>
					<p>
						<label><input type="radio" name="transferJobCount"
							value="1">0次</label> <label><input type="radio"
							name="transferJobCount" value="2">1次</label> <label><input
							type="radio" name="transferJobCount" value="3">两次</label> <label><input
							type="radio" name="transferJobCount" value="4">三到五次</label> <label><input
							type="radio" name="transferJobCount" value="5">五次以上</label>
					</p>
					<p>
						您对目前工作的满意程度： <select name="satisLevelOfCurrJob" id="">
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
						<span>工作内容：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="工作对象">工作对象</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="工作任务">工作任务</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="工作职责">工作职责</label>
					</p>
					<p>
						<span>工作强度：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="工作时间">工作时间</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="工作方式">工作方式</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="工作量">工作量</label>
					</p>
					<p>
						<span>工作环境：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="物理环境">物理环境</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="人文环境">人文环境</label>
					</p>
					<p>
						<span>工作控制：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="直接上司">直接上司</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="监督管理">监督管理</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="绩效考核">绩效考核</label>
					</p>
					<p>
						<span>薪酬福利：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="工资奖金">工资奖金</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="津贴福利">津贴福利</label>
					</p>
					<p>
						<span>个人发展：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="锦绣机会">锦绣机会</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="晋升空间">晋升空间</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="职业变通">职业变通</label>
					</p>
					<p>
						<span>社会资源：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="人际关系">人际关系</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="社会地位">社会地位</label>
					</p>
					<p>
						<span>工作满意度：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="公平感">公平感</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="成就感">成就感</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="自我实现">自我实现</label>
					</p>
					</p> 
					<p>
						在单位考核中，您最长评定为<select name="companyExamine" id="">
							<option value="1">优秀</option>
							<option value="2">良好</option>
							<option value="3">合格</option>
							<option value="4">不合格</option>
							<option value="5">不清楚</option>
						</select>
					</p>
					<p>
						您毕业多少年后开始自主创业(仅创业校友填写) <select name="yearsToBusinessSelf" id="">
							<option value="0">无创业</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">>9</option>
						</select>
					</p>
					<p>
						您对目前创业成效的满意程度：<select name="satisLevelOfBusinessSelf" id="">
							<option value="无创业">无创业</option>
							<option value="非常满意">非常满意</option>
							<option value="比较满意">比较满意</option>
							<option value="不是很满意">不是很满意</option>
							<option value="非常不满意">非常不满意</option>
						</select>
					</p>
					<div class="btncus">
						<input type="button" value="提交" onclick="jobSkip()"> <input
							type="reset" value="重置">
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="../js/change.js"></script>
	<script src="../js/jquery-1.9.min.js"></script>
</body>
</html>
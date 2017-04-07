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
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
</head>
<body>
<div>
	<jsp:include page="../baseView/header.jsp"></jsp:include>
	<div class="box" style="height:;width: " id="box">
		<div id="content" style="border-left: 2px solid mediumseagreen;">
			<!-- 基础信息模块 -->
			<div style="display: block; margin-left: 20px; font-size: 16px;">
				<form action="" id="base">
					<h2>基础信息模块(<label style="color: red;font-size: 15px;">*</label>为必填项)</h2>
					<p>
						<label style="color: red;font-size: 15px;">*</label>您的姓名：<input type="text" placeholder="请输入真实姓名" name="truename" id="truename">
					</p>
					<p>您的性别：</p>
					<p>
						<label><input type="radio" name="sex" value="男"
							checked="checked" id="sex">男</label> <label><input type="radio"
							name="sex" value="女" id="sex">女</label>
					</p>
					<p>
						您的出生日期： <input type="date" name="birth" id="birth">
					</p>
					<p><label style="color: red;font-size: 15px;">*</label>您工作或居住地址：</p>
					<p>
						<label><input type="radio" name="country" value="inChina" onclick="inChinaF();" id="country">国内</label>
						<label><input type="radio" name="country" value="outChina" onclick="outChinaF();" id="country">国外</label>
					</p>
					<p>
					<div id="outChinaD" style="display: none">
					请输入您的详细地址<input type="text" name="address" id="address">
					</div>
					<div id="inChinaD" style="display: none;height: 30px;">
						<div data-toggle="distpicker">
							<div class="form-group" style="width: 100px;float: left;">
								<label class="sr-only" for="province1">Province</label> <select
									class="form-control" id="province1" name="provincel"><option
										value="" data-code="">—— 省 ——</option>
									<option value="北京市" data-code="110000" >北京市</option>
									<option value="天津市" data-code="120000">天津市</option>
									<option value="河北省" data-code="130000">河北省</option>
									<option value="山西省" data-code="140000">山西省</option>
									<option value="内蒙古自治区" data-code="150000">内蒙古自治区</option>
									<option value="辽宁省" data-code="210000">辽宁省</option>
									<option value="吉林省" data-code="220000">吉林省</option>
									<option value="黑龙江省" data-code="230000">黑龙江省</option>
									<option value="上海市" data-code="310000">上海市</option>
									<option value="江苏省" data-code="320000">江苏省</option>
									<option value="浙江省" data-code="330000">浙江省</option>
									<option value="安徽省" data-code="340000">安徽省</option>
									<option value="福建省" data-code="350000">福建省</option>
									<option value="江西省" data-code="360000">江西省</option>
									<option value="山东省" data-code="370000">山东省</option>
									<option value="河南省" data-code="410000">河南省</option>
									<option value="湖北省" data-code="420000">湖北省</option>
									<option value="湖南省" data-code="430000">湖南省</option>
									<option value="广东省" data-code="440000">广东省</option>
									<option value="广西壮族自治区" data-code="450000">广西壮族自治区</option>
									<option value="海南省" data-code="460000">海南省</option>
									<option value="重庆市" data-code="500000">重庆市</option>
									<option value="四川省" data-code="510000">四川省</option>
									<option value="贵州省" data-code="520000">贵州省</option>
									<option value="云南省" data-code="530000">云南省</option>
									<option value="西藏自治区" data-code="540000">西藏自治区</option>
									<option value="陕西省" data-code="610000">陕西省</option>
									<option value="甘肃省" data-code="620000">甘肃省</option>
									<option value="青海省" data-code="630000">青海省</option>
									<option value="宁夏回族自治区" data-code="640000">宁夏回族自治区</option>
									<option value="新疆维吾尔自治区" data-code="650000">新疆维吾尔自治区</option>
									<option value="台湾省" data-code="710000">台湾省</option>
									<option value="香港特别行政区" data-code="810000">香港特别行政区</option>
									<option value="澳门特别行政区" data-code="820000">澳门特别行政区</option></select>
							</div>
							<div class="form-group" style="width: 150px;float: left;">
								<label class="sr-only" for="city1">City</label> <select
									class="form-control" id="city1" name="city1"><option
										value="" data-code="">—— 市 ——</option></select>
							</div>
							<div class="form-group" style="width: 110px;float: left;">
								<label class="sr-only" for="district1">District</label> <select
									class="form-control" id="district1" name="district1"><option
										value="" data-code="">—— 区 ——</option></select>
							</div>
						</div>
					</div>
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
					<h2>职业信息模块(<label style="color: red;font-size: 15px;">*</label>标记为必填项)</h2>
					<p><label style="color: red;font-size: 15px;">*</label>您的工作单位性质：</p>
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
					<h2>工作待遇成就与满意程度(<label style="color: red;font-size: 15px;">*</label>标记为必填项)</h2>
					<p><label style="color: red;font-size: 15px;">*</label>您目前的税前年收入（有工作带来的包含工资、奖金、补贴、分红等）：</p>
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
						<label style="color: red;font-size: 15px;">*</label>您工作几年以后职位得到第一次晋升： <input type="text" placeholder="请输入数字"
							name="firstPromote"><span>年</span>
					</p>
					<p><label style="color: red;font-size: 15px;">*</label>您获得的最高荣誉级别是：</p>
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
					<p><label style="color: red;font-size: 15px;">*</label>您共有几次转换工作单位的经历：</p>
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
							type="checkbox" name="reasonOfNotStatis" value="工作任务">工作任务</label>
						<label><input type="checkbox" name="reasonOfNotStatis"
							value="工作职责">工作职责</label>
					</p>
					<p>
						<span>工作强度：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="工作时间">工作时间</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="工作方式">工作方式</label>
						<label><input type="checkbox" name="reasonOfNotStatis"
							value="工作量">工作量</label>
					</p>
					<p>
						<span>工作环境：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="物理环境">物理环境</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="人文环境">人文环境</label>
					</p>
					<p>
						<span>工作控制：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="直接上司">直接上司</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="监督管理">监督管理</label>
						<label><input type="checkbox" name="reasonOfNotStatis"
							value="绩效考核">绩效考核</label>
					</p>
					<p>
						<span>薪酬福利：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="工资奖金">工资奖金</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="津贴福利">津贴福利</label>
					</p>
					<p>
						<span>个人发展：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="锦绣机会">锦绣机会</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="晋升空间">晋升空间</label>
						<label><input type="checkbox" name="reasonOfNotStatis"
							value="职业变通">职业变通</label>
					</p>
					<p>
						<span>社会资源：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="人际关系">人际关系</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="社会地位">社会地位</label>
					</p>
					<p>
						<span>工作满意度：</span> <label><input type="checkbox"
							name="reasonOfNotStatis" value="公平感">公平感</label> <label><input
							type="checkbox" name="reasonOfNotStatis" value="成就感">成就感</label>
						<label><input type="checkbox" name="reasonOfNotStatis"
							value="自我实现">自我实现</label>
					</p>
					</p>
					<p>
						<label style="color: red;font-size: 15px;">*</label>在单位考核中，您最长评定为<select name="companyExamine" id="">
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
	<jsp:include page="../baseView/footer.jsp"></jsp:include>
	<script src="../js/jquery-1.9.min.js"></script>
	<script src="../js/change.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/main.js"></script>
	<script src="../js/distpicker.js"></script>
	<script src="../js/distpicker.data.js"></script>
	<script src="../js/distpicker.data.min.js"></script>
	<script src="../js/distpicker.min.js"></script>
	</div>
</body>
</html>
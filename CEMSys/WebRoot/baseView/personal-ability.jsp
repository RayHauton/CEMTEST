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
<title>个人能力品质调研</title>
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/base.css">
<link rel="stylesheet" href="../css/view_set/personal-ability.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/person_detail.css">
</head>
<body style="text-align: center;">
		<jsp:include page="../baseView/header.jsp" ></jsp:include>
			<div id="content">
				<!-- 个人能力品质调研 -->
				<div id="Selfabilityquality">
					<p style="width: 998px; font-size: 18px; margin:0 auto;" align="middle"
						id="SelfabilityqualityP" >
						人才培养质量一直是学院办学的关注点，现邀请您对学院毕业生个人能力品质整体水平进行评价。以下问题主要是要了解南航经管毕业生和其他高校毕业生相对比，个人能力品质方面的事迹表现，请您选择符合框格。<br />1分表示完全非常弱（南航弱），5分表示非常强（南航强）。
					</p>
					<form action="" id="SelfabilityqualityForm">
						<table id="SelfabilityqualityTable" class="table table-striped" style="width:1000px">
							<h2 id="SelfabilityqualityH2" style="margin-top:0px" align="center">个人能力品质调研</h2>
							<tbody>
								<tr class="border-top">
									<td class="border-left">序号</td>
									<td>项目</td>
									<td>1分</td>
									<td>2分</td>
									<td>3分</td>
									<td>4分</td>
									<td>5分</td>
								</tr>
								<tr>
									<td class="border-left">1</td>
									<td class="w120">任课教师敬业水平</td>
									<td><input type="radio" id="1"
										name="gumptionAndAchvConscious" value="1"></td>
									<td><input type="radio" id="1"
										name="gumptionAndAchvConscious" value="2"></td>
									<td><input type="radio" id="1"
										name="gumptionAndAchvConscious" value="3"></td>
									<td><input type="radio" id="1"
										name="gumptionAndAchvConscious" value="4"></td>
									<td><input type="radio" id="1"
										name="gumptionAndAchvConscious" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">2</td>
									<td class="w120">团队协作精神</td>
									<td><input type="radio" id="2" name="companyCooperation"
										value="1"></td>
									<td><input type="radio" id="2" name="companyCooperation"
										value="2"></td>
									<td><input type="radio" id="2" name="companyCooperation"
										value="3"></td>
									<td><input type="radio" id="2" name="companyCooperation"
										value="4"></td>
									<td><input type="radio" id="2" name="companyCooperation"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">3</td>
									<td class="w120">敬业意识</td>
									<td><input type="radio" id="3" name="professionalism"
										value="1"></td>
									<td><input type="radio" id="3" name="professionalism"
										value="2"></td>
									<td><input type="radio" id="3" name="professionalism"
										value="3"></td>
									<td><input type="radio" id="3" name="professionalism"
										value="4"></td>
									<td><input type="radio" id="3" name="professionalism"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">4</td>
									<td class="w120">专业基础知识</td>
									<td><input type="radio" id="4" name="majorBaseKnowledge"
										value="1"></td>
									<td><input type="radio" id="4" name="majorBaseKnowledge"
										value="2"></td>
									<td><input type="radio" id="4" name="majorBaseKnowledge"
										value="3"></td>
									<td><input type="radio" id="4" name="majorBaseKnowledge"
										value="4"></td>
									<td><input type="radio" id="4" name="majorBaseKnowledge"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">5</td>
									<td class="w120">知识面</td>
									<td><input type="radio" id="5" name="knowledgeWidth"
										value="1"></td>
									<td><input type="radio" id="5" name="knowledgeWidth"
										value="2"></td>
									<td><input type="radio" id="5" name="knowledgeWidth"
										value="3"></td>
									<td><input type="radio" id="5" name="knowledgeWidth"
										value="4"></td>
									<td><input type="radio" id="5" name="knowledgeWidth"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">6</td>
									<td class="w120">外语水平</td>
									<td><input type="radio" id="6" name="foreignLanguage"
										value="1"></td>
									<td><input type="radio" id="6" name="foreignLanguage"
										value="2"></td>
									<td><input type="radio" id="6" name="foreignLanguage"
										value="3"></td>
									<td><input type="radio" id="6" name="foreignLanguage"
										value="4"></td>
									<td><input type="radio" id="6" name="foreignLanguage"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">7</td>
									<td class="w120">获取和应用新知识的能力</td>
									<td><input type="radio" id="7"
										name="acquireAndApplyKnowledge" value="1"></td>
									<td><input type="radio" id="7"
										name="acquireAndApplyKnowledge" value="2"></td>
									<td><input type="radio" id="7"
										name="acquireAndApplyKnowledge" value="3"></td>
									<td><input type="radio" id="7"
										name="acquireAndApplyKnowledge" value="4"></td>
									<td><input type="radio" id="7"
										name="acquireAndApplyKnowledge" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">8</td>
									<td class="w120">独立分析解决问题的能力</td>
									<td><input type="radio" id="8" name="selfDealProblem"
										value="1"></td>
									<td><input type="radio" id="8" name="selfDealProblem"
										value="2"></td>
									<td><input type="radio" id="8" name="selfDealProblem"
										value="3"></td>
									<td><input type="radio" id="8" name="selfDealProblem"
										value="4"></td>
									<td><input type="radio" id="8" name="selfDealProblem"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">9</td>
									<td class="w120">实践动手的能力</td>
									<td><input type="radio" id="9" name="practiceAndHandsOn"
										value="1"></td>
									<td><input type="radio" id="9" name="practiceAndHandsOn"
										value="2"></td>
									<td><input type="radio" id="9" name="practiceAndHandsOn"
										value="3"></td>
									<td><input type="radio" id="9" name="practiceAndHandsOn"
										value="4"></td>
									<td><input type="radio" id="9" name="practiceAndHandsOn"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">10</td>
									<td class="w120">创新能力</td>
									<td><input type="radio" id="10" name="motivationAbility"
										value="1"></td>
									<td><input type="radio" id="10" name="motivationAbility"
										value="2"></td>
									<td><input type="radio" id="10" name="motivationAbility"
										value="3"></td>
									<td><input type="radio" id="10" name="motivationAbility"
										value="4"></td>
									<td><input type="radio" id="10" name="motivationAbility"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">11</td>
									<td class="w120">人际沟通和组织协调能力</td>
									<td><input type="radio" id="11"
										name="communicationAndOrganizeAbility" value="1"></td>
									<td><input type="radio" id="11"
										name="communicationAndOrganizeAbility" value="2"></td>
									<td><input type="radio" id="11"
										name="communicationAndOrganizeAbility" value="3"></td>
									<td><input type="radio" id="11"
										name="communicationAndOrganizeAbility" value="4"></td>
									<td><input type="radio" id="11"
										name="communicationAndOrganizeAbility" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">12</td>
									<td class="w120">语言文字表达能力</td>
									<td><input type="radio" id="12" name="wordsExpression"
										value="1"></td>
									<td><input type="radio" id="12" name="wordsExpression"
										value="2"></td>
									<td><input type="radio" id="12" name="wordsExpression"
										value="3"></td>
									<td><input type="radio" id="12" name="wordsExpression"
										value="4"></td>
									<td><input type="radio" id="12" name="wordsExpression"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">13</td>
									<td class="w120">心理承受能力和抗挫折能力</td>
									<td><input type="radio" id="13"
										name="psychologyBearAndAntiFrustration" value="1"></td>
									<td><input type="radio" id="13"
										name="psychologyBearAndAntiFrustration" value="2"></td>
									<td><input type="radio" id="13"
										name="psychologyBearAndAntiFrustration" value="3"></td>
									<td><input type="radio" id="13"
										name="psychologyBearAndAntiFrustration" value="4"></td>
									<td><input type="radio" id="13"
										name="psychologyBearAndAntiFrustration" value="5"></td>
								</tr>
							</tbody>
						</table>
						<div class="btn" id="SelfabilityqualityBtn"  style="margin:0px;padding:0px">
							<input type="button" value="提交" id="SelfabilityqualitySubmit"><input
								type="reset" value="重置">
						</div>
					</form>
				</div>
				<!-- 专业能力培养调研 -->
				<div id="Majorabilitycultivationquality">
					<p style="width: 998px; font-size: 18px; margin:0 auto;" align="middle">
						教育教学过程是实现高质量人才培养的前提和基础，现邀请您对学院专业能力培养质量进行评价。以下问题主要了解毕业生对专业人才培养工作的评价，答案没有对与错，最重要的是真实客观。请选择您认为最符合的框格。<br />1分表示非常弱，5分表示非常强。
					</p>
					<form action="" id="MajorabilitycultivationqualityForm">
						<table  class="table table-striped" style="width:1000px">
							<h2 align="middle">专业能力培养质量调研</h2>
							<tbody>
								<tr class="border-top">
									<td class="border-left">序号</td>
									<td>项目</td>
									<td>1分</td>
									<td>2分</td>
									<td>3分</td>
									<td>4分</td>
									<td>5分</td>
								</tr>
								<tr>
									<td class="border-left">14</td>
									<td class="w120">任课教师敬业水平</td>
									<td><input type="radio" id="14"
										name="teacherProfessionalismLevel" value="1"></td>
									<td><input type="radio" id="14"
										name="teacherProfessionalismLevel" value="2"></td>
									<td><input type="radio" id="14"
										name="teacherProfessionalismLevel" value="3"></td>
									<td><input type="radio" id="14"
										name="teacherProfessionalismLevel" value="4"></td>
									<td><input type="radio" id="14"
										name="teacherProfessionalismLevel" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">15</td>
									<td class="w120">任课教师教学水平</td>
									<td><input type="radio" id="15"
										name="teacherTeachingLevel" value="1"></td>
									<td><input type="radio" id="15"
										name="teacherTeachingLevel" value="2"></td>
									<td><input type="radio" id="15"
										name="teacherTeachingLevel" value="3"></td>
									<td><input type="radio" id="15"
										name="teacherTeachingLevel" value="4"></td>
									<td><input type="radio" id="15"
										name="teacherTeachingLevel" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">16</td>
									<td class="w120">师生关系</td>
									<td><input type="radio" id="16"
										name="relationshipOfTcherAndStud" value="1"></td>
									<td><input type="radio" id="16"
										name="relationshipOfTcherAndStud" value="2"></td>
									<td><input type="radio" id="16"
										name="relationshipOfTcherAndStud" value="3"></td>
									<td><input type="radio" id="16"
										name="relationshipOfTcherAndStud" value="4"></td>
									<td><input type="radio" id="16"
										name="relationshipOfTcherAndStud" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">17</td>
									<td class="w120">专业培养和社会契合度</td>
									<td><input type="radio" id="17"
										name="majorCultivationTargetAndSocialFit" value="1"></td>
									<td><input type="radio" id="17"
										name="majorCultivationTargetAndSocialFit" value="2"></td>
									<td><input type="radio" id="17"
										name="majorCultivationTargetAndSocialFit" value="3"></td>
									<td><input type="radio" id="17"
										name="majorCultivationTargetAndSocialFit" value="4"></td>
									<td><input type="radio" id="17"
										name="majorCultivationTargetAndSocialFit" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">18</td>
									<td class="w120">国际交流学习</td>
									<td><input type="radio" id="18"
										name="internationalCommunicationLearning" value="1"></td>
									<td><input type="radio" id="18"
										name="internationalCommunicationLearning" value="2"></td>
									<td><input type="radio" id="18"
										name="internationalCommunicationLearning" value="3"></td>
									<td><input type="radio" id="18"
										name="internationalCommunicationLearning" value="4"></td>
									<td><input type="radio" id="18"
										name="internationalCommunicationLearning" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">19</td>
									<td class="w120">基础课程学习</td>
									<td><input type="radio" id="19" name="baseCourseLearning"
										value="1"></td>
									<td><input type="radio" id="19" name="baseCourseLearning"
										value="2"></td>
									<td><input type="radio" id="19" name="baseCourseLearning"
										value="3"></td>
									<td><input type="radio" id="19" name="baseCourseLearning"
										value="4"></td>
									<td><input type="radio" id="19" name="baseCourseLearning"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">20</td>
									<td class="w120">专业课程学习</td>
									<td><input type="radio" id="20" name="majorCourseLearning"
										value="1"></td>
									<td><input type="radio" id="20" name="majorCourseLearning"
										value="2"></td>
									<td><input type="radio" id="20" name="majorCourseLearning"
										value="3"></td>
									<td><input type="radio" id="20" name="majorCourseLearning"
										value="4"></td>
									<td><input type="radio" id="20" name="majorCourseLearning"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">21</td>
									<td class="w120">专业实验</td>
									<td><input type="radio" id="21" name="majorExperiment"
										value="1"></td>
									<td><input type="radio" id="21" name="majorExperiment"
										value="2"></td>
									<td><input type="radio" id="21" name="majorExperiment"
										value="3"></td>
									<td><input type="radio" id="21" name="majorExperiment"
										value="4"></td>
									<td><input type="radio" id="21" name="majorExperiment"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">22</td>
									<td class="w120">专业实习</td>
									<td><input type="radio" id="22" name="majorInternship"
										value="1"></td>
									<td><input type="radio" id="22" name="majorInternship"
										value="2"></td>
									<td><input type="radio" id="22" name="majorInternship"
										value="3"></td>
									<td><input type="radio" id="22" name="majorInternship"
										value="4"></td>
									<td><input type="radio" id="22" name="majorInternship"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">23</td>
									<td class="w120">毕业（设计）论文</td>
									<td><input type="radio" id="23" name="graduationDesign"
										value="1"></td>
									<td><input type="radio" id="23" name="graduationDesign"
										value="2"></td>
									<td><input type="radio" id="23" name="graduationDesign"
										value="3"></td>
									<td><input type="radio" id="23" name="graduationDesign"
										value="4"></td>
									<td><input type="radio" id="23" name="graduationDesign"
										value="5"></td>
								</tr>
								<tr>
									<td class="border-left">24</td>
									<td class="w120">教材选用</td>
									<td><input type="radio" id="24" name="textbookUsed" value="1"></td>
									<td><input type="radio" id="24" name="textbookUsed" value="2"></td>
									<td><input type="radio" id="24" name="textbookUsed" value="3"></td>
									<td><input type="radio" id="24" name="textbookUsed" value="4"></td>
									<td><input type="radio" id="24" name="textbookUsed" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">25</td>
									<td class="w120">专业竞赛活动</td>
									<td><input type="radio" id="25"
										name="majorCompetitionActivity" value="1"></td>
									<td><input type="radio" id="25"
										name="majorCompetitionActivity" value="2"></td>
									<td><input type="radio" id="25"
										name="majorCompetitionActivity" value="3"></td>
									<td><input type="radio" id="25"
										name="majorCompetitionActivity" value="4"></td>
									<td><input type="radio" id="25"
										name="majorCompetitionActivity" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">26</td>
									<td class="w120">校园学术讲座</td>
									<td><input type="radio" id="26"
										name="schoolAcademicLecture" value="1"></td>
									<td><input type="radio" id="26"
										name="schoolAcademicLecture" value="2"></td>
									<td><input type="radio" id="26"
										name="schoolAcademicLecture" value="3"></td>
									<td><input type="radio" id="26"
										name="schoolAcademicLecture" value="4"></td>
									<td><input type="radio" id="26"
										name="schoolAcademicLecture" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">27</td>
									<td class="w120">文娱活动</td>
									<td><input type="radio" id="27"
										name="recreationalActivities" value="1"></td>
									<td><input type="radio" id="27"
										name="recreationalActivities" value="2"></td>
									<td><input type="radio" id="27"
										name="recreationalActivities" value="3"></td>
									<td><input type="radio" id="27"
										name="recreationalActivities" value="4"></td>
									<td><input type="radio" id="27"
										name="recreationalActivities" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">28</td>
									<td class="w120">体育健身类活动</td>
									<td><input type="radio" id="28" name="physicalFitness" value="1"></td>
									<td><input type="radio" id="28" name="physicalFitness" value="2"></td>
									<td><input type="radio" id="28" name="physicalFitness" value="3"></td>
									<td><input type="radio" id="28" name="physicalFitness" value="4"></td>
									<td><input type="radio" id="28" name="physicalFitness" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">29</td>
									<td class="w120">学风建设</td>
									<td><input type="radio" id="29"
										name="learningAtmosphereConstruction" value="1"></td>
									<td><input type="radio" id="29"
										name="learningAtmosphereConstruction" value="2"></td>
									<td><input type="radio" id="29"
										name="learningAtmosphereConstruction" value="3"></td>
									<td><input type="radio" id="29"
										name="learningAtmosphereConstruction" value="4"></td>
									<td><input type="radio" id="29"
										name="learningAtmosphereConstruction" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">30</td>
									<td class="w120">图书馆作用发挥</td>
									<td><input type="radio" id="30" name="libraryEffect" value="1"></td>
									<td><input type="radio" id="30" name="libraryEffect" value="2"></td>
									<td><input type="radio" id="30" name="libraryEffect" value="3"></td>
									<td><input type="radio" id="30" name="libraryEffect" value="4"></td>
									<td><input type="radio" id="30" name="libraryEffect" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">31</td>
									<td class="w120">辅导员工作</td>
									<td><input type="radio" id="31" name="instructorWorking" value="1"></td>
									<td><input type="radio" id="31" name="instructorWorking" value="2"></td>
									<td><input type="radio" id="31" name="instructorWorking" value="3"></td>
									<td><input type="radio" id="31" name="instructorWorking" value="4"></td>
									<td><input type="radio" id="31" name="instructorWorking" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">32</td>
									<td class="w120">后勤保障工作</td>
									<td><input type="radio" id="32"
										name="logisticServiceWorking" value="1"></td>
									<td><input type="radio" id="32"
										name="logisticServiceWorking" value="2"></td>
									<td><input type="radio" id="32"
										name="logisticServiceWorking" value="3"></td>
									<td><input type="radio" id="32"
										name="logisticServiceWorking" value="4"></td>
									<td><input type="radio" id="32"
										name="logisticServiceWorking" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">33</td>
									<td class="w120">校友联络沟通工作</td>
									<td><input type="radio" id="33"
										name="fellowConnectionWorking" value="1"></td>
									<td><input type="radio" id="33"
										name="fellowConnectionWorking" value="2"></td>
									<td><input type="radio" id="33"
										name="fellowConnectionWorking" value="3"></td>
									<td><input type="radio" id="33"
										name="fellowConnectionWorking" value="4"></td>
									<td><input type="radio" id="33"
										name="fellowConnectionWorking" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">34</td>
									<td class="w120">生涯规划、就业指导</td>
									<td><input type="radio" id="34"
										name="careerPlanningAndEmploymentGuidance" value="1"></td>
									<td><input type="radio" id="34"
										name="careerPlanningAndEmploymentGuidance" value="2"></td>
									<td><input type="radio" id="34"
										name="careerPlanningAndEmploymentGuidance" value="3"></td>
									<td><input type="radio" id="34"
										name="careerPlanningAndEmploymentGuidance" value="4"></td>
									<td><input type="radio" id="34"
										name="careerPlanningAndEmploymentGuidance" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">35</td>
									<td class="w120">心理疏导</td>
									<td><input type="radio" id="35" name="psychologyGrooming" value="1"></td>
									<td><input type="radio" id="35" name="psychologyGrooming" value="2"></td>
									<td><input type="radio" id="35" name="psychologyGrooming" value="3"></td>
									<td><input type="radio" id="35" name="psychologyGrooming" value="4"></td>
									<td><input type="radio" id="35" name="psychologyGrooming" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">36</td>
									<td class="w120">导师指导</td>
									<td><input type="radio" id="36" name="tutorGuidance" value="1"></td>
									<td><input type="radio" id="36" name="tutorGuidance" value="2"></td>
									<td><input type="radio" id="36" name="tutorGuidance" value="3"></td>
									<td><input type="radio" id="36" name="tutorGuidance" value="4"></td>
									<td><input type="radio" id="36" name="tutorGuidance" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">37</td>
									<td class="w120">项目经验</td>
									<td><input type="radio" id="37" name="projectExperience" value="1"></td>
									<td><input type="radio" id="37" name="projectExperience" value="2"></td>
									<td><input type="radio" id="37" name="projectExperience" value="3"></td>
									<td><input type="radio" id="37" name="projectExperience" value="4"></td>
									<td><input type="radio" id="37" name="projectExperience" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">38</td>
									<td class="w120">科研机会</td>
									<td><input type="radio" id="38"
										name="scientificResearchOpportunity" value="1"></

>
									<td><input type="radio" id="38"
										name="scientificResearchOpportunity" value="2"></td>
									<td><input type="radio" id="38"
										name="scientificResearchOpportunity" value="3"></td>
									<td><input type="radio" id="38"
										name="scientificResearchOpportunity" value="4"></td>
									<td><input type="radio" id="38"
										name="scientificResearchOpportunity" value="5"></td>
								</tr>
								<tr>
									<td class="border-left">39</td>
									<td class="w120">科研精神与学术道德</td>
									<td><input type="radio" id="39"
										name="scienReschSpiritAndAcademicMoral" value="1"></td>
									<td><input type="radio" id="39"
										name="scienReschSpiritAndAcademicMoral" value="2"></td>
									<td><input type="radio" id="39"
										name="scienReschSpiritAndAcademicMoral" value="3"></td>
									<td><input type="radio" id="39"
										name="scienReschSpiritAndAcademicMoral" value="4"></td>
									<td><input type="radio" id="39"
										name="scienReschSpiritAndAcademicMoral" value="5"></td>
								</tr>
							</tbody>
						</table>
						<div class="btn" style="margin:0 auto;" >
							<input type="button" value="提交" style=" margin:0 auto;"
								id="MajorabilitycultivationqualitySubmit"><input
								type="reset" value="重置">
						</div>
					</form>
				</div>
			</div>
		<jsp:include page="footer.jsp"></jsp:include>
	<script src="../js/jquery-1.9.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/loginController/loginAndLogout.js"></script>
	<script src="../js/personalabilityControl/personalability.js"></script>
	<script type="text/javascript">
	$(function() {
		var selfabilityquality = "${sessionScope.data}";
		var strs = new Array();
		if (selfabilityquality != null) {
			strs = selfabilityquality.split(",");
			var num = strs.length;
			if (num == 26)
				num = 14;
			else
				num = 1;
			for (i = 0; i < strs.length; i++)
				$("input:radio[id=" + (i + num) + "][value="+ strs[i] + "]").attr("checked",true);
		}
	});
	</script>
	
</body>
</html>
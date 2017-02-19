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
	<title>个人能力品质调研</title>
	<link rel="stylesheet" href="../css/view_set/base.css">
	<link rel="stylesheet" href="../css/view_set/personal-ability.css">
</head>
<body>
	<div class="box">
		<div class="subnav">
			<ul id="select" class="select">
				<li>个人能力品质调研</li>
				<li>专业能力培养调研</li>
<!-- 				<li>研究生毕业生专项</li> -->
			</ul>
		</div>
		<div id="content">
			<!-- 个人能力品质调研 -->
			<div style="display:block;" id="Selfabilityquality">
				<p>人才培养质量一直是学院办学的关注点，现邀请您对学院毕业生个人能力品质整体水平进行评价。以下问题主要是要了解南航经管毕业生和其他高校毕业生相对比，个人能力品质方面的事迹表现，请您选择符合框格。1分表示完全非常弱（南航弱），5分表示非常强（南航强）。</p>
				<form action="" id="SelfabilityqualityForm">			
					<table>
						<h2>个人能力品质调研</h2>
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
								<td class="border-left">26</td>
								<td class="w120">任课教师敬业水平</td>
								<td><input type="radio" id="26" name="gumptionAndAchvConscious" value="1"></td>
								<td><input type="radio" id="26" name="gumptionAndAchvConscious" value="2"></td>
								<td><input type="radio" id="26" name="gumptionAndAchvConscious" value="3"></td>
								<td><input type="radio" id="26" name="gumptionAndAchvConscious" value="4"></td>
								<td><input type="radio" id="26" name="gumptionAndAchvConscious" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">27</td>
								<td class="w120">团队协作精神</td>
								<td><input type="radio" id="27" name="companyCooperation" value="1"></td>
								<td><input type="radio" id="27" name="companyCooperation" value="2"></td>
								<td><input type="radio" id="27" name="companyCooperation" value="3"></td>
								<td><input type="radio" id="27" name="companyCooperation" value="4"></td>
								<td><input type="radio" id="27" name="companyCooperation" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">28</td>
								<td class="w120">敬业意识</td>
								<td><input type="radio" id="28" name="professionalism" value="1"></td>
								<td><input type="radio" id="28" name="professionalism" value="2"></td>
								<td><input type="radio" id="28" name="professionalism" value="3"></td>
								<td><input type="radio" id="28" name="professionalism" value="4"></td>
								<td><input type="radio" id="28" name="professionalism" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">29</td>
								<td class="w120">专业基础知识</td>
								<td><input type="radio" id="29" name="majorBaseKnowledge" value="1"></td>
								<td><input type="radio" id="29" name="majorBaseKnowledge" value="2"></td>
								<td><input type="radio" id="29" name="majorBaseKnowledge" value="3"></td>
								<td><input type="radio" id="29" name="majorBaseKnowledge" value="4"></td>
								<td><input type="radio" id="29" name="majorBaseKnowledge" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">30</td>
								<td class="w120">知识面</td>
								<td><input type="radio" id="30" name="knowledgeWidth" value="1"></td>
								<td><input type="radio" id="30" name="knowledgeWidth" value="2"></td>
								<td><input type="radio" id="30" name="knowledgeWidth" value="3"></td>
								<td><input type="radio" id="30" name="knowledgeWidth" value="4"></td>
								<td><input type="radio" id="30" name="knowledgeWidth" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">31</td>
								<td class="w120">外语水平</td>
								<td><input type="radio" id="31" name="foreignLanguage" value="1"></td>
								<td><input type="radio" id="31" name="foreignLanguage" value="2"></td>
								<td><input type="radio" id="31" name="foreignLanguage" value="3"></td>
								<td><input type="radio" id="31" name="foreignLanguage" value="4"></td>
								<td><input type="radio" id="31" name="foreignLanguage" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">32</td>
								<td class="w120">获取和应用新知识的能力</td>
								<td><input type="radio" id="32" name="acquireAndApplyKnowledge" value="1"></td>
								<td><input type="radio" id="32" name="acquireAndApplyKnowledge" value="2"></td>
								<td><input type="radio" id="32" name="acquireAndApplyKnowledge" value="3"></td>
								<td><input type="radio" id="32" name="acquireAndApplyKnowledge" value="4"></td>
								<td><input type="radio" id="32" name="acquireAndApplyKnowledge" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">33</td>
								<td class="w120">独立分析解决问题的能力</td>
								<td><input type="radio" id="33" name="selfDealProblem" value="1"></td>
								<td><input type="radio" id="33" name="selfDealProblem" value="2"></td>
								<td><input type="radio" id="33" name="selfDealProblem" value="3"></td>
								<td><input type="radio" id="33" name="selfDealProblem" value="4"></td>
								<td><input type="radio" id="33" name="selfDealProblem" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">34</td>
								<td class="w120">实践动手的能力</td>
								<td><input type="radio" id="34" name="practiceAndHandsOn" value="1"></td>
								<td><input type="radio" id="34" name="practiceAndHandsOn" value="2"></td>
								<td><input type="radio" id="34" name="practiceAndHandsOn" value="3"></td>
								<td><input type="radio" id="34" name="practiceAndHandsOn" value="4"></td>
								<td><input type="radio" id="34" name="practiceAndHandsOn" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">35</td>
								<td class="w120">创新能力</td>
								<td><input type="radio" id="35" name="motivationAbility" value="1"></td>
								<td><input type="radio" id="35" name="motivationAbility" value="2"></td>
								<td><input type="radio" id="35" name="motivationAbility" value="3"></td>
								<td><input type="radio" id="35" name="motivationAbility" value="4"></td>
								<td><input type="radio" id="35" name="motivationAbility" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">36</td>
								<td class="w120">人际沟通和组织协调能力</td>
								<td><input type="radio" id="36" name="communicationAndOrganizeAbility" value="1"></td>
								<td><input type="radio" id="36" name="communicationAndOrganizeAbility" value="2"></td>
								<td><input type="radio" id="36" name="communicationAndOrganizeAbility" value="3"></td>
								<td><input type="radio" id="36" name="communicationAndOrganizeAbility" value="4"></td>
								<td><input type="radio" id="36" name="communicationAndOrganizeAbility" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">37</td>
								<td class="w120">语言文字表达能力</td>
								<td><input type="radio" id="37" name="wordsExpression" value="1"></td>
								<td><input type="radio" id="37" name="wordsExpression" value="2"></td>
								<td><input type="radio" id="37" name="wordsExpression" value="3"></td>
								<td><input type="radio" id="37" name="wordsExpression" value="4"></td>
								<td><input type="radio" id="37" name="wordsExpression" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">38</td>
								<td class="w120">心理承受能力和抗挫折能力</td>
								<td><input type="radio" id="38" name="psychologyBearAndAntiFrustration" value="1"></td>
								<td><input type="radio" id="38" name="psychologyBearAndAntiFrustration" value="2"></td>
								<td><input type="radio" id="38" name="psychologyBearAndAntiFrustration" value="3"></td>
								<td><input type="radio" id="38" name="psychologyBearAndAntiFrustration" value="4"></td>
								<td><input type="radio" id="38" name="psychologyBearAndAntiFrustration" value="5"></td>
							</tr>
						</tbody>
					</table>
					<div class="btn">
						<input type="button" value="提交" id="SelfabilityqualitySubmit"><input type="reset" value="重置">
					</div>
				</form>
			</div>
			<!-- 专业能力培养调研 -->
			<div id="Majorabilitycultivationquality">
				<p>教育教学过程是实现高质量人才培养的前提和基础，现邀请您对学院专业能力培养质量进行评价。以下问题主要了解毕业生对专业人才培养工作的评价，答案没有对与错，最重要的是真实客观。请选择您认为最符合的框格。1分表示非常弱，5分表示非常强。</p>
				<form action="" id="MajorabilitycultivationqualityForm">			
					<table>
						<h2>专业能力培养质量调研</h2>
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
								<td class="border-left">39</td>
								<td class="w120">任课教师敬业水平</td>
								<td><input type="radio" id="39" name="teacherProfessionalismLevel" value="1"></td>
								<td><input type="radio" id="39" name="teacherProfessionalismLevel" value="2"></td>
								<td><input type="radio" id="39" name="teacherProfessionalismLevel" value="3"></td>
								<td><input type="radio" id="39" name="teacherProfessionalismLevel" value="4"></td>
								<td><input type="radio" id="39" name="teacherProfessionalismLevel" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">40</td>
								<td class="w120">任课教师教学水平</td>
								<td><input type="radio" id="42" name="teacherTeachingLevel" value="1"></td>
								<td><input type="radio" id="40" name="teacherTeachingLevel" value="2"></td>
								<td><input type="radio" id="40" name="teacherTeachingLevel" value="3"></td>
								<td><input type="radio" id="40" name="teacherTeachingLevel" value="4"></td>
								<td><input type="radio" id="40" name="teacherTeachingLevel" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">41</td>
								<td class="w120">师生关系</td>
								<td><input type="radio" id="41" name="relationshipOfTcherAndStud" value="1"></td>
								<td><input type="radio" id="41" name="relationshipOfTcherAndStud" value="2"></td>
								<td><input type="radio" id="41" name="relationshipOfTcherAndStud" value="3"></td>
								<td><input type="radio" id="41" name="relationshipOfTcherAndStud" value="4"></td>
								<td><input type="radio" id="41" name="relationshipOfTcherAndStud" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">42</td>
								<td class="w120">专业培养和社会契合度</td>
								<td><input type="radio" id="42" name="majorCultivationTargetAndSocialFit" value="1"></td>
								<td><input type="radio" id="42" name="majorCultivationTargetAndSocialFit" value="2"></td>
								<td><input type="radio" id="42" name="majorCultivationTargetAndSocialFit" value="3"></td>
								<td><input type="radio" id="42" name="majorCultivationTargetAndSocialFit" value="4"></td>
								<td><input type="radio" id="42" name="majorCultivationTargetAndSocialFit" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">43</td>
								<td class="w120">国际交流学习</td>
								<td><input type="radio" id="43" name="internationalCommunicationLearning" value="1"></td>
								<td><input type="radio" id="43" name="internationalCommunicationLearning" value="2"></td>
								<td><input type="radio" id="43" name="internationalCommunicationLearning" value="3"></td>
								<td><input type="radio" id="43" name="internationalCommunicationLearning" value="4"></td>
								<td><input type="radio" id="43" name="internationalCommunicationLearning" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">44</td>
								<td class="w120">基础课程学习</td>
								<td><input type="radio" id="44" name="baseCourseLearning" value="1"></td>
								<td><input type="radio" id="44" name="baseCourseLearning" value="2"></td>
								<td><input type="radio" id="44" name="baseCourseLearning" value="3"></td>
								<td><input type="radio" id="44" name="baseCourseLearning" value="4"></td>
								<td><input type="radio" id="44" name="baseCourseLearning" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">45</td>
								<td class="w120">专业课程学习</td>
								<td><input type="radio" id="45" name="majorCourseLearning" value="1"></td>
								<td><input type="radio" id="45" name="majorCourseLearning" value="2"></td>
								<td><input type="radio" id="45" name="majorCourseLearning" value="3"></td>
								<td><input type="radio" id="45" name="majorCourseLearning" value="4"></td>
								<td><input type="radio" id="45" name="majorCourseLearning" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">46</td>
								<td class="w120">专业实验</td>
								<td><input type="radio" id="46" name="majorExperiment" value="1"></td>
								<td><input type="radio" id="46" name="majorExperiment" value="2"></td>
								<td><input type="radio" id="46" name="majorExperiment" value="3"></td>
								<td><input type="radio" id="46" name="majorExperiment" value="4"></td>
								<td><input type="radio" id="46" name="majorExperiment" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">47</td>
								<td class="w120">专业实习</td>
								<td><input type="radio" id="47" name="majorInternship" value="1"></td>
								<td><input type="radio" id="47" name="majorInternship" value="2"></td>
								<td><input type="radio" id="47" name="majorInternship" value="3"></td>
								<td><input type="radio" id="47" name="majorInternship" value="4"></td>
								<td><input type="radio" id="47" name="majorInternship" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">48</td>
								<td class="w120">毕业（设计）论文</td>
								<td><input type="radio" id="48" name="graduationDesign" value="1"></td>
								<td><input type="radio" id="48" name="graduationDesign" value="2"></td>
								<td><input type="radio" id="48" name="graduationDesign" value="3"></td>
								<td><input type="radio" id="48" name="graduationDesign" value="4"></td>
								<td><input type="radio" id="48" name="graduationDesign" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">49</td>
								<td class="w120">教材选用</td>
								<td><input type="radio" id="49" name="textbookUsed" value="1"></td>
								<td><input type="radio" id="49" name="textbookUsed" value="2"></td>
								<td><input type="radio" id="49" name="textbookUsed" value="3"></td>
								<td><input type="radio" id="49" name="textbookUsed" value="4"></td>
								<td><input type="radio" id="49" name="textbookUsed" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">50</td>
								<td class="w120">专业竞赛活动</td>
								<td><input type="radio" id="50" name="majorCompetitionActivity" value="1"></td>
								<td><input type="radio" id="50" name="majorCompetitionActivity" value="2"></td>
								<td><input type="radio" id="50" name="majorCompetitionActivity" value="3"></td>
								<td><input type="radio" id="50" name="majorCompetitionActivity" value="4"></td>
								<td><input type="radio" id="50" name="majorCompetitionActivity" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">51</td>
								<td class="w120">校园学术讲座</td>
								<td><input type="radio" id="51" name="schoolAcademicLecture" value="1"></td>
								<td><input type="radio" id="51" name="schoolAcademicLecture" value="2"></td>
								<td><input type="radio" id="51" name="schoolAcademicLecture" value="3"></td>
								<td><input type="radio" id="51" name="schoolAcademicLecture" value="4"></td>
								<td><input type="radio" id="51" name="schoolAcademicLecture" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">52</td>
								<td class="w120">文娱活动</td>
								<td><input type="radio" id="52" name="recreationalActivities" value="1"></td>
								<td><input type="radio" id="52" name="recreationalActivities" value="2"></td>
								<td><input type="radio" id="52" name="recreationalActivities" value="3"></td>
								<td><input type="radio" id="52" name="recreationalActivities" value="4"></td>
								<td><input type="radio" id="52" name="recreationalActivities" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">53</td>
								<td class="w120">体育健身类活动</td>
								<td><input type="radio" id="53" name="physicalFitness" value="1"></td>
								<td><input type="radio" id="53" name="physicalFitness" value="2"></td>
								<td><input type="radio" id="53" name="physicalFitness" value="3"></td>
								<td><input type="radio" id="53" name="physicalFitness" value="4"></td>
								<td><input type="radio" id="53" name="physicalFitness" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">54</td>
								<td class="w120">学风建设</td>
								<td><input type="radio" id="54" name="learningAtmosphereConstruction" value="1"></td>
								<td><input type="radio" id="54" name="learningAtmosphereConstruction" value="2"></td>
								<td><input type="radio" id="54" name="learningAtmosphereConstruction" value="3"></td>
								<td><input type="radio" id="54" name="learningAtmosphereConstruction" value="4"></td>
								<td><input type="radio" id="54" name="learningAtmosphereConstruction" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">55</td>
								<td class="w120">图书馆作用发挥</td>
								<td><input type="radio" id="55" name="libraryEffect" value="1"></td>
								<td><input type="radio" id="55" name="libraryEffect" value="2"></td>
								<td><input type="radio" id="55" name="libraryEffect" value="3"></td>
								<td><input type="radio" id="55" name="libraryEffect" value="4"></td>
								<td><input type="radio" id="55" name="libraryEffect" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">56</td>
								<td class="w120">辅导员工作</td>
								<td><input type="radio" id="56" name="instructorWorking" value="1"></td>
								<td><input type="radio" id="56" name="instructorWorking" value="2"></td>
								<td><input type="radio" id="56" name="instructorWorking" value="3"></td>
								<td><input type="radio" id="56" name="instructorWorking" value="4"></td>
								<td><input type="radio" id="56" name="instructorWorking" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">57</td>
								<td class="w120">后勤保障工作</td>
								<td><input type="radio" id="57" name="logisticServiceWorking" value="1"></td>
								<td><input type="radio" id="57" name="logisticServiceWorking" value="2"></td>
								<td><input type="radio" id="57" name="logisticServiceWorking" value="3"></td>
								<td><input type="radio" id="57" name="logisticServiceWorking" value="4"></td>
								<td><input type="radio" id="57" name="logisticServiceWorking" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">58</td>
								<td class="w120">校友联络沟通工作</td>
								<td><input type="radio" id="58" name="fellowConnectionWorking" value="1"></td>
								<td><input type="radio" id="58" name="fellowConnectionWorking" value="2"></td>
								<td><input type="radio" id="58" name="fellowConnectionWorking" value="3"></td>
								<td><input type="radio" id="58" name="fellowConnectionWorking" value="4"></td>
								<td><input type="radio" id="58" name="fellowConnectionWorking" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">59</td>
								<td class="w120">生涯规划、就业指导</td>
								<td><input type="radio" id="59" name="careerPlanningAndEmploymentGuidance" value="1"></td>
								<td><input type="radio" id="59" name="careerPlanningAndEmploymentGuidance" value="2"></td>
								<td><input type="radio" id="59" name="careerPlanningAndEmploymentGuidance" value="3"></td>
								<td><input type="radio" id="59" name="careerPlanningAndEmploymentGuidance" value="4"></td>
								<td><input type="radio" id="59" name="careerPlanningAndEmploymentGuidance" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">60</td>
								<td class="w120">心理疏导</td>
								<td><input type="radio" id="60" name="psychologyGrooming" value="1"></td>
								<td><input type="radio" id="60" name="psychologyGrooming" value="2"></td>
								<td><input type="radio" id="60" name="psychologyGrooming" value="3"></td>
								<td><input type="radio" id="60" name="psychologyGrooming" value="4"></td>
								<td><input type="radio" id="60" name="psychologyGrooming" value="5"></td>
							</tr>
<!-- 						</tbody> -->
<!-- 					</table> -->
<!-- 					<div class="btn"> -->
<!-- 						<input type="submit" value="提交"><input type="reset" value="重置"> -->
<!-- 					</div> -->
<!-- 				</form> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<p>该项仅限研究生毕业生作答。以下所有题目的陈述，答案没有对与错，最重要的是真实客观。请选择您认为最符合的框格。1分表示非常不满意，5分表示非常满意。</p> -->
<!-- 				<form action="">			 -->
<!-- 					<table> -->
<!-- 						<h2>专业能力培养质量调研</h2> -->
<!-- 						<tbody> -->
<!-- 							<tr class="border-top"> -->
<!-- 								<td class="border-left">序号</td> -->
<!-- 								<td>项目</td> -->
<!-- 								<td>1分</td> -->
<!-- 								<td>2分</td> -->
<!-- 								<td>3分</td> -->
<!-- 								<td>4分</td> -->
<!-- 								<td>5分</td> -->
<!-- 							</tr> -->
							<tr>
								<td class="border-left">61</td>
								<td class="w120">导师指导</td>
								<td><input type="radio" id="61" name="tutorGuidance" value="1"></td>
								<td><input type="radio" id="61" name="tutorGuidance" value="2"></td>
								<td><input type="radio" id="61" name="tutorGuidance" value="3"></td>
								<td><input type="radio" id="61" name="tutorGuidance" value="4"></td>
								<td><input type="radio" id="61" name="tutorGuidance" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">62</td>
								<td class="w120">项目经验</td>
								<td><input type="radio" id="62" name="projectExperience" value="1"></td>
								<td><input type="radio" id="62" name="projectExperience" value="2"></td>
								<td><input type="radio" id="62" name="projectExperience" value="3"></td>
								<td><input type="radio" id="62" name="projectExperience" value="4"></td>
								<td><input type="radio" id="62" name="projectExperience" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">63</td>
								<td class="w120">科研机会</td>
								<td><input type="radio" id="63" name="scientificResearchOpportunity" value="1"></td>
								<td><input type="radio" id="63" name="scientificResearchOpportunity" value="2"></td>
								<td><input type="radio" id="63" name="scientificResearchOpportunity" value="3"></td>
								<td><input type="radio" id="63" name="scientificResearchOpportunity" value="4"></td>
								<td><input type="radio" id="63" name="scientificResearchOpportunity" value="5"></td>
							</tr>
							<tr>
								<td class="border-left">64</td>
								<td class="w120">科研精神与学术道德</td>
								<td><input type="radio" id="64" name="scienReschSpiritAndAcademicMoral" value="1"></td>
								<td><input type="radio" id="64" name="scienReschSpiritAndAcademicMoral" value="2"></td>
								<td><input type="radio" id="64" name="scienReschSpiritAndAcademicMoral" value="3"></td>
								<td><input type="radio" id="64" name="scienReschSpiritAndAcademicMoral" value="4"></td>
								<td><input type="radio" id="64" name="scienReschSpiritAndAcademicMoral" value="5"></td>
							</tr>
						</tbody>
					</table>
					<div class="btn">
						<input type="button" value="提交" id="MajorabilitycultivationqualitySubmit"><input type="reset" value="重置">
					</div>
				</form>
		<form action="${pageContext.request.contextPath}/surveySys/deleteByUserID">
			<input type="submit" value="删除">
		</form>
			</div>
		</div>	
	</div>
	<script src="../js/change.js"></script>
	<script src="../js/jquery-1.9.min.js"></script>
	<script type="text/javascript" language="javascript">
		$(function(){
	        $("#SelfabilityqualitySubmit").click(function(){
	        	var flag=0;
	        	for(var i=26;i<39;i++){
		           	var val=$('#Selfabilityquality input:radio[id='+i+']:checked').val();
		           	if(val==null){
		               	alert("第"+i+"题未选择")
		               	flag=1;
		               	break;
		           	}
	        	}
	        	if(flag==1)
	        		return false;
	        	else if(flag==0){
	        		var data=$("#SelfabilityqualityForm").serializeArray();
	        		$.ajax({
	                    url:"${pageContext.request.contextPath}/surveySys/saveSelfabilityquality",
	                    type:'post',
	                    data:data,
	                    dataType:'html',
	                    success:function(data,status){
	                        if(status == "success"){
	                            var objs = jQuery.parseJSON(data);
	                            alert(objs[0].activityName);
	                            $('#Selfabilityquality').css('display','none');
	                            $('#Majorabilitycultivationquality').css('display','block');
	                        }
	                    },
	                    error:function(xhr,textStatus,errorThrown){
	                    	alert("error");
	                    }
	                });
	        	}
	        });
	    });
	
		$(function(){
	        $("#MajorabilitycultivationqualitySubmit").click(function(){
	        	var flag=0;
	        	for(var i=39;i<64;i++){
		           	var val=$('#Majorabilitycultivationquality input:radio[id='+i+']:checked').val();
		           	if(val==null){
		               	alert("第"+i+"题未选择")
		               	flag=1;
		               	break;
		           	}
	        	}
	        	if(flag==1)
	        		return false;
	        	else if(flag==0){
	        		var data=$("#MajorabilitycultivationqualityForm").serializeArray();
	        		$.ajax({
	                    url:"${pageContext.request.contextPath}/surveySys/saveMajorabilitycultivationquality",
	                    type:'post',
	                    data:data,
	                    dataType:'html',
	                    success:function(data,status){
	                        if(status == "success"){
	                            var objs = jQuery.parseJSON(data);
	                            alert(objs[0].activityName);
	                        }
	                    },
	                    error:function(xhr,textStatus,errorThrown){
	                    	alert("error");
	                    }
	                });
	        	}
	        });
	    });
		$(document).ready(function(){ 
			var selfabilityquality = "${sessionScope.data}";
			var strs= new Array(); 
			if(selfabilityquality!=null){
				strs=selfabilityquality.split(",");
				var num = strs.length;
				if(num==26) num=39;
				else num=26;
				for (i=0;i<strs.length ;i++ ) 
					$("input:radio[id="+(i+num)+"][value="+strs[i]+"]").attr("checked",true); 
			}
		});
	</script>
</body>
</html>
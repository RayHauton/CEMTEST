package com.cem.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.AdminSurveySysDao;
import com.cem.pojo.User;
import com.cem.queryVO.AdminSurveyQueryVo;

@Repository
public class AdminSurveySysDaoImpl implements AdminSurveySysDao {

	List<String> list = new ArrayList<>();

	public AdminSurveySysDaoImpl() {
		// 在构造函数中将题号与对应的选项对应起来
		list.add("");
		list.add("gumptionAndAchvConscious");
		list.add("companyCooperation");
		list.add("professionalism");
		list.add("majorBaseKnowledge");
		list.add("knowledgeWidth");
		list.add("foreignLanguage");
		list.add("acquireAndApplyKnowledge");
		list.add("selfDealProblem");
		list.add("practiceAndHandsOn");
		list.add("motivationAbility");
		list.add("communicationAndOrganizeAbility");
		list.add("wordsExpression");
		list.add("psychologyBearAndAntiFrustration");
		list.add("teacherProfessionalismLevel");
		list.add("teacherTeachingLevel");
		list.add("relationshipOfTcherAndStud");
		list.add("majorCultivationTargetAndSocialFit");
		list.add("internationalCommunicationLearning");
		list.add("baseCourseLearning");
		list.add("majorCourseLearning");
		list.add("majorExperiment");
		list.add("majorInternship");
		list.add("graduationDesign");
		list.add("textbookUsed");
		list.add("majorCompetitionActivity");
		list.add("schoolAcademicLecture");
		list.add("recreationalActivities");
		list.add("physicalFitness");
		list.add("learningAtmosphereConstruction");
		list.add("libraryEffect");
		list.add("instructorWorking");
		list.add("logisticServiceWorking");
		list.add("fellowConnectionWorking");
		list.add("careerPlanningAndEmploymentGuidance");
		list.add("psychologyGrooming");
		list.add("tutorGuidance");
		list.add("projectExperience");
		list.add("scientificResearchOpportunity");
		list.add("scienReschSpiritAndAcademicMoral");
	}

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> searchSMCondition(AdminSurveyQueryVo adminSurveyQueryVo) {
		String titleNum = adminSurveyQueryVo.getTitleNum();
		String scoreNum = adminSurveyQueryVo.getScoreNum();

		Session session = getSession();
		// 原始SQL语句
		String sql = "";
		// 根据题号拼接字符串
		if (titleNum != "") {
			int temp = Integer.valueOf(titleNum);
			if (temp < 13)
				sql = "select s.userId from Selfabilityquality s  where s.isDeleted = '0' and s." + list.get(temp)
						+ " = '" + scoreNum + "'";
			else
				sql = "select m.userId from Majorabilitycultivationquality m where m.isDeleted = '0' and m."
						+ list.get(temp) + " = '" + scoreNum + "'";
		} else
			sql = "select u.userId from User u where u.isDeleted = '0'";
		Query query = session.createSQLQuery(sql);
		List<Integer> queryList = query.list();

		return queryList;
	}

	@Override
	public User searchUserByUserId(int userId) {
		Session session = getSession();
		User user = (User) session.get(User.class, userId);
		if (user != null)
			return user;
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] searchAllUser() throws Exception {
		Session session = getSession();
		String hql = "select u.userId from User u";
		Query query = session.createSQLQuery(hql);
		List<Object> queryList = query.list();
		String[] userIds = new String[queryList.size()];
		for (int i = 0; i < queryList.size(); i++)
			userIds[i] = String.valueOf(queryList.get(i));
		return userIds;
	}

}

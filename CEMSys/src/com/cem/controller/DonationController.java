package com.cem.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cem.customPojo.UserCustom;
import com.cem.pojo.Donation;
import com.cem.pojo.User;
import com.cem.queryVO.DonationQueryVo;
import com.cem.service.DonationService;
import com.cem.service.UserService;

@Controller
@RequestMapping(value = "/donation")
public class DonationController {
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;
	@Autowired
	private DonationService donationService;

	@Autowired
	private UserService userService;
	
	/**
	 * 更新记录
	 * @param donationId 记录ID
	 * @param response HttpServletResponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	public String update(Donation donation) throws Exception{
		donationService.update(donation);
		return "redirect:show_admin";
	}
	/*
	 * 删除记录
	 */
	@RequestMapping(value = "/delete_adm")
	public void delete(@RequestParam int donationId,HttpServletResponse response) throws Exception{
		donationService.delete(donationId);
		response.getWriter().write("succ");
	}

	/*
	 * 根据学号查找相应的用户的姓名，以校验前端信息添加是否有误
	 */
	@RequestMapping(value = "/checkUserInfo")
	public void checkUserInfo(String studNumber, String truename, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = userService.findUserByStudNum(studNumber, true);
		PrintWriter out = response.getWriter();
		if (user != null) {// 说明该学号对应的用户存在
			if(user.getTruename().equals(truename)){//判断查出的真实姓名与前端输入的姓名是否一致
				out.write("right");//一致
			}else{
				out.write("fault");//不一致
			}
		} else {// 该学号对应的用户不存在，拒绝添加记录
			out.write("notExist");
		}
	}
	
	/*
	 * 管理员界面的查询捐赠记录
	 */
	@RequestMapping(value = "/show_admin")
	public ModelAndView show_admin(DonationQueryVo queryVo) throws Exception {
		ModelAndView modelAndView = this.show(queryVo);
		modelAndView.setViewName("admin/donation_adm");
		return modelAndView;
	}

	/*
	 * 新增记录
	 */
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute Donation donation) throws Exception {
		donationService.insert(donation);
		return "redirect:show_admin";
	}

	/*
	 * 获取用户信息
	 */
	@RequestMapping(value = "/getDonorInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserCustom getDonorInfo(UserCustom userCustom) throws Exception {
		BeanUtils.copyProperties(userCustom, donationService.findDonorInfo(userCustom));
		return userCustom;
	}

	/*
	 * 打开donation界面（管理员）
	 */
	@RequestMapping(value = "/open_adm")
	public void open_adm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/admin/donation_adm.jsp").forward(request, response);
		;
	}

	/*
	 * 打开donation界面(普通用户)
	 */
	@RequestMapping(value = "/open")
	public void open(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/baseView/donation.jsp").forward(request, response);
	}

	/*
	 * 获取捐赠信息
	 */
	@RequestMapping(value = "/show")
	public ModelAndView show(DonationQueryVo queryVo) throws Exception {
		/*
		 * 判断queryVo是否含有pageIndex和pageSize值，没有提供默认值 默认值的设置在配置文件中设置
		 */
		if (queryVo.getPageIndex() == null) {
			queryVo.setPageIndex(1);
		}
		if (queryVo.getPageSize() == null) {
			queryVo.setPageSize(pageSizeDefault);
		}
		ModelAndView modelAndView = new ModelAndView();
		/*
		 * 调用service获取查询结果
		 */
		Map<String, Object> queryResult = donationService.findAll(queryVo);
		modelAndView.addObject("donationList", queryResult.get("resultList"));
		/*
		 * 设置总记录数 不用list.size()查询记录数是因为耗内存；
		 */
		int recordCount = (int) queryResult.get("recordCount");
		queryVo.setRecordCount(recordCount);
		/*
		 * 设置总页数
		 */
		int pageSize = queryVo.getPageSize();
		/*
		 * 确定总页数用于前台展现
		 */
		queryVo.setPageCount(recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1);
		/*
		 * 向modelAndView填充数据
		 */
		modelAndView.addObject("queryVo", queryVo);
		modelAndView.setViewName("baseView/donation");
		return modelAndView;
	}

}

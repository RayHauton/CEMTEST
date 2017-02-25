package com.cem.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.Donation;
import com.cem.pojo.Recruitment;
import com.cem.queryVO.DonationQueryVo;
import com.cem.service.DonationService;

@Controller
@RequestMapping(value="/donation")
public class DonationController {
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;
	@Autowired
	private DonationService donationService;
	/*
	 * 打开donation界面
	 */
	@RequestMapping(value="/open")
	public void open(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.getRequestDispatcher("/baseView/donation.jsp").forward(request, response);;
	}
	/*
	 * 获取捐赠信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show")
	public ModelAndView show(DonationQueryVo queryVo) throws Exception{
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
		modelAndView.addObject("donationList", (List<Donation>) queryResult.get("resultList"));
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

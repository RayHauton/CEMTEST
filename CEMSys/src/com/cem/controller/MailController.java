package com.cem.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cem.service.MailService;

import com.cem.service.MailService;

@Controller
@RequestMapping(value = "/mail")
public class MailController {
	@Autowired
	private MailService mailService;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/audit")
	public String sentMailAfterAudit() {
		mailService.testMail();
		return "test";
	}

	@RequestMapping(value = "/birthdayBlessing")
	public void sentBirthdayblessing() {

	}

	@RequestMapping(value = "/htmlMail")
	public void sentHTMLMail(HttpServletRequest request) {
		String allToers = request.getParameter("toers");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String[] toList = allToers.split(";");

		// mailService.sendHyperTextMail(subject, content, toList, pictures,
		// attachments);
	}
	/**
	 * String subject,String content,String[] toList,Map<String, String> pictures,Map<String, String> attachments
	 */
	@RequestMapping(value = "/uploadMail")
	public String uploadMail(@RequestParam("1") MultipartFile file1, @RequestParam("2") MultipartFile file2,
			@RequestParam("subject") String subject, @RequestParam("content") String content,
			@RequestParam("toUsers") String toUsers) {
		String[] toList = toUsers.split(";");
		String finalContent = translateImgSrcToCid1(content);
		Map<String, String> pictures = translateImgSrcToCid2(content);
		MultipartFile[] files = new MultipartFile[2];
		files[0] = file1;
		files[1] = file2;
		Map<String, String> attachments = translateAttachmentToMap(files);
		try {
			mailService.sendHyperTextMail(subject, finalContent, toList, pictures, attachments);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/mailTest";
	}

	private boolean saveFile(MultipartFile file, String filePath) {
		if (!file.isEmpty()) {
			try {
				// String filePath =
				// request.getSession().getServletContext().getRealPath("/")+"upload/"+file.getOriginalFilename();
//				String filePath = "e:/uploadTest/" + file.getOriginalFilename();
				// 转存文件
				file.transferTo(new File(filePath));
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 得到picturesMap 并将img src改成 cid
	 * 得到attachmentMap
	 * @param content
	 */
	private String  translateImgSrcToCid1(String content){
		String[] temp = content.split("src=\"");
		int j = 1;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains("\" title")) {
				String s1 = temp[i].split("\" title")[0];
				content = content.replace(s1, "cid:c"+j);
				++j;
			}
		}
		return content;
	}
	private Map<String, String> translateImgSrcToCid2(String content){
		String[] temp = content.split("src=\"");
		int j = 1;
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains("\" title")) {
				String s1 = temp[i].split("\" title")[0];
				map.put("c"+j, s1);
				content = content.replace(s1, "cid:c"+j);
				++j;
			}
		}
		return map;
	}
	private Map<String, String> translateAttachmentToMap(MultipartFile[] files){
		Map<String, String> map = new HashMap<>();
		for (MultipartFile multipartFile : files) {
			if (multipartFile.getSize() > 0) {
				String filePath = "e:/uploadTest/" + multipartFile.getOriginalFilename();
				saveFile(multipartFile,filePath);
				map.put(multipartFile.getOriginalFilename(), filePath);
			}
		}
		return map;
	}
	//将服务器的图片保存到
	private Map<String, String> savetofile(Map<String, String> m){
		Map<String, String> map = new HashMap<>();
		
		return map;
	}
}

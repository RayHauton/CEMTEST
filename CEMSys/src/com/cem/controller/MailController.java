package com.cem.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.HTMLMail;
import com.cem.service.MailService;

import com.cem.service.MailService;

@Controller
@RequestMapping(value = "/mail")
public class MailController {
	@Autowired
	private MailService mailService;

	@Autowired
	private HttpServletRequest request;

	@Value("${summernoteUploadPath}")
	private String uploadPath;

	/**
	 * String subject,String content,String[] toList,Map<String, String>
	 * pictures,Map<String, String> attachments
	 */
	@RequestMapping(value = "/mailToAll")
	public ModelAndView mailtoall(@RequestParam("1") MultipartFile file1, @RequestParam("2") MultipartFile file2,
			@RequestParam("subject") String subject, @RequestParam("content") String content) {
		ModelAndView modelAndView = new ModelAndView();
		MultipartFile[] files = new MultipartFile[2];
		files[0] = file1;
		files[1] = file2;
		Map<String, String> attachments = translateAttachmentToMap(files);
		HTMLMail htmlMail = null;
		try {
			List<String> sList = mailService.findUserEmailList(mailService.generateQueryCondition("全体成员", "allUsers"));
			String[] toList = (String[]) sList.toArray(new String[sList.size()]);
			htmlMail = new HTMLMail(subject, content, toList, null, attachments);
			mailService.sendHyperTextMail(htmlMail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		modelAndView.setViewName("/mail/mailToAll");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mailToClass")
	public ModelAndView mailtoclass(@RequestParam("1") MultipartFile file1, @RequestParam("2") MultipartFile file2,
			@RequestParam("subject") String subject, @RequestParam("content") String content,@RequestParam("toList") String toList) {
		ModelAndView modelAndView = new ModelAndView();
		MultipartFile[] files = new MultipartFile[2];
		files[0] = file1;
		files[1] = file2;
		Map<String, String> attachments = translateAttachmentToMap(files);
		try {
			List<String> sList = mailService.findUserEmailList(mailService.generateQueryCondition(toList, "class"));
			String[] temp = (String[]) sList.toArray(new String[sList.size()]);
			
			mailService.sendHyperTextMail(subject, content, temp, null, attachments);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		modelAndView.setViewName("/mail/mailToClass");
		return modelAndView;
	}
	
	@RequestMapping(value="/mailToGrade")
	public ModelAndView mailToGrade(@RequestParam("1") MultipartFile file1, @RequestParam("2") MultipartFile file2,
			@RequestParam("subject") String subject, @RequestParam("content") String content,@RequestParam("toList") String toList){
		ModelAndView modelAndView = new ModelAndView();
		MultipartFile[] files = new MultipartFile[2];
		files[0] = file1;
		files[1] = file2;
		Map<String, String> attachments = translateAttachmentToMap(files);
		try {
			List<String> sList = mailService.findUserEmailList(mailService.generateQueryCondition(toList, "grade"));
			String[] temp = (String[]) sList.toArray(new String[sList.size()]);
			mailService.sendHyperTextMail(subject, content, temp, null, attachments);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		modelAndView.setViewName("/mail/mailToGrade");
		return modelAndView;
	}
	
	@RequestMapping(value="/mailToDept")
	public ModelAndView mailToDept(@RequestParam("1") MultipartFile file1, @RequestParam("2") MultipartFile file2,
			@RequestParam("subject") String subject, @RequestParam("content") String content,@RequestParam("toList") String toList){
		ModelAndView modelAndView = new ModelAndView();
		MultipartFile[] files = new MultipartFile[2];
		files[0] = file1;
		files[1] = file2;
		Map<String, String> attachments = translateAttachmentToMap(files);
		try {
			List<String> sList = mailService.findUserEmailList(mailService.generateQueryCondition(toList, "dept"));
			String[] temp = (String[]) sList.toArray(new String[sList.size()]);
			mailService.sendHyperTextMail(subject, content, temp, null, attachments);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		modelAndView.setViewName("/mail/mailToDept");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", produces = "application/json;charset=utf-8")
	public void upload(HttpServletResponse response) {
		// 转换为文件类型的request
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		// 获取对应file对象
		Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
		Iterator<String> fileIterator = multipartHttpServletRequest.getFileNames();
		// 获取项目的相对路径
		String requestURL = request.getRequestURL().toString();
		String prePath = requestURL.substring(0, requestURL.indexOf(""));
		String path = request.getSession().getServletContext().getRealPath("");
		System.out.println(path);
		while (fileIterator.hasNext()) {
			String fileKey = fileIterator.next();
			// 获取对应文件
			MultipartFile multipartFile = fileMap.get(fileKey);
			if (multipartFile.getSize() != 0L) {
				String imgName = UUID.randomUUID() + multipartFile.getOriginalFilename();
				try {
					multipartFile.transferTo(new File(path, imgName));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	public String uploadImage(String serverPath, MultipartFile file) {
		try {
			String uploadPath = serverPath + getImageRelativePath();
			String images = "{}";
			// 如果不存在 则创建一个目录
			if (!new File(uploadPath).exists()) {
				new File(uploadPath).mkdirs();
			}
			if (file != null && !file.isEmpty()) {
				String savePath = getImageRelativePath() + file.getOriginalFilename();
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "{}";
		}
	}

	private String getImageRelativePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/nonePhotoMail")
	public String nonePhotoMail(@RequestParam("1") MultipartFile file1, @RequestParam("2") MultipartFile file2,
			@RequestParam("subject") String subject, @RequestParam("content") String content,
			@RequestParam("toUsers") String toUsers){
		String[] toList = toUsers.split(";");
		Map<String, String> pictures = null;
		MultipartFile[] files = new MultipartFile[2];
		files[0] = file1;
		files[1] = file2;
		Map<String, String> attachments = translateAttachmentToMap(files);
		try {
			mailService.sendHyperTextMail(subject, content, toList, pictures, attachments);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "succ";
	}
	private boolean saveFile(MultipartFile file, String filePath) {
		if (!file.isEmpty()) {
			try {
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
	 * 得到picturesMap 并将img src改成 cid 得到attachmentMap
	 * 
	 * @param content
	 */
	private String translateImgSrcToCid1(String content) {
		String[] temp = content.split("src=\"");
		int j = 1;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains("\" title")) {
				String s1 = temp[i].split("\" title")[0];
				content = content.replace(s1, "cid:c" + j);
				++j;
			}
		}
		return content;
	}

	private Map<String, String> translateImgSrcToCid2(String content) {
		String[] temp = content.split("src=\"");
		int j = 1;
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains("\" title")) {
				String s1 = temp[i].split("\" title")[0];
				map.put("c" + j, s1);
				content = content.replace(s1, "cid:c" + j);
				++j;
			}
		}
		return map;
	}

	private Map<String, String> translateAttachmentToMap(MultipartFile[] files) {
		Map<String, String> map = new HashMap<>();
		for (MultipartFile multipartFile : files) {
			if (multipartFile.getSize() > 0) {
				String filePath = "e:/uploadTest/" + multipartFile.getOriginalFilename();
				saveFile(multipartFile, filePath);
				map.put(multipartFile.getOriginalFilename(), filePath);
			}
		}
		return map;
	}
}

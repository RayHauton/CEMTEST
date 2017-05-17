<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/view_set/head.css">
<link rel="stylesheet" href="css/view_set/footer.css">
<style>
	.welcome{
		width:800px;
		height:400px;
		margin-left:auto;
		margin-right:auto;
		font-family: "宋体";
		margin-top:50px;	
		font-size:18px;
			
	}
	.bg-cover{/*遮罩层style*/
		width: 100%;
		height: 100%;
		padding: 50px 0;/*撑高遮罩层*/
		background-color: rgba(0,0,0,0.3);/*遮罩层颜色，主要靠透明度*/
	}
	.welcome p{
		text-indent: 2em;	 
		color:#fff;
	}
	.bg{
		background-image: url("img/bgIndex.jpg");
		background-size: cover;
		background-repeat: no-repeat;
		background-position: center;
		min-height: 300px;
		border-radius: 4px;
		border:1px solid #DDDDDD;
		width: 1000px;
		min-height:500px;
		margin-left: auto;
		margin-right: auto;
	}
</style>
<title>校友系统主页</title></head>
<body>
	<jsp:include page="baseView/header.jsp"></jsp:include>
	<div class="bg" style="">
	<div class="bg-cover">
		<div class = "welcome">
			<p>明廓翠屏，钟山俊秀，六朝古都，天下文枢。80年代初，明文化之遗韵与现代社会间的交融，
			孕育而生了一所熠熠生辉的明星学院——南京航空航天大学经济与管理学院。30余年的发展，
			一代代经管人栉风沐雨，砥砺奋进，造就了如今学科专业全面、师资力量雄厚、学术成果丰硕、
			优秀人才辈出的现代化研究型学院。时至今日，南航经济与管理学院在中国管理教育领域正发挥着愈来愈重要的作用。
			最令学院感到自豪和骄傲的是，学院已培养的一万余名毕业生,他们学以致用，
			凭借着勤奋、智慧与执着在各行各业取得了骄人的成绩，为国家的繁荣富强做出了巨大贡献。</p>
   			<p>校友是学院宝贵的财富，学院是校友终身的精神家园。浩瀚苍穹离不开群星璀璨，
   			 学院的未来发展离不开广大校友的关心与支持。假文字笔墨以传情，
   			 经济与管理学院诚挚邀请广大校友参与到学院未来的建设与发展中来，
   			 分享喜悦，收获幸福，共同见证学院多彩的明天。</p>
		</div>
	</div>
	</div>
	<jsp:include page="baseView/footer.jsp"></jsp:include>
</body>
<script src="js/jquery-1.9.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/loginController/loginAndLogout.js" ></script>
</html>
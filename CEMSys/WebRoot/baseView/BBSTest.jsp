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
<title>校友论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/view_set/head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/view_set/footer.css">
</head>
<body>

	<input type="hidden" value="${pageContext.request.contextPath }"
		id="basePath" />
	<input type="hidden" value="${thisForum.forumId }" id="forumId" />
	<input type="hidden" value="${thisForum.forumTitle }" id="forumTitle" />
	<jsp:include page="/baseView/header.jsp"></jsp:include>
	<div class="box" style="margin-left:auto;margin-right:auto;width:1000px" >
		<div class="container" style="width:1000px;">
			<a href="#" style="margin-left:auto;margin-right:auto;">消息</a>
			
			<div>
			<p>消息通知测试</p>
			<!--以下是消息通知测试  -->
			<span id="tongzhi" style="display:none;">有<a href="${pageContext.request.contextPath }/forum/myMessage"><strong id="tongzhi-content">0</strong></a>条新消息</span>
			</div>		
			
			<h1>${thisForum.forumTitle }</h1>
			<h2>共${thisForum.replyCount }回复</h2>
			<c:forEach var="test" items="${replyList }">
				<div class="message">
					<div class="messageBox">
						<div class="head">
							<img alt="个人头像" src="" />
							<div class="nameBox">
								<span class="name">${test.publishUser }</span> <span
									class="time">${test.replyTime }</span> 
									<input type="hidden"
									id="userId${test.floor }" value="${test.publishUserId }" />
							</div>
							<span>${test.floor }楼</span>
						</div>
						<div class="text">
							<p>${test.replyText }</p>
						</div>
						<div class="content">
							<input type="text" placeholder="说点什么吧"
								id="replyToHost${test.floor }"> <span class="c-epsion"></span>
							<button class="content-btn" name="${test.floor }" id="test"
								onclick="javascript:reply(this)">评论</button>
							<c:if
								test="${user.role =='3' || user.userId == test.publishUserId }">
								<button class="btn btn-danger" name="${test.replyId }"
									onclick="deleteReply(this)">删除</button>
							</c:if>

						</div>
					</div>
				</div>
			</c:forEach>
			<div class="container" style="text-align: center;">
				<ul class="pagination">
					<li><a href="#">共${totalReplyPage }页</a></li>
					<li><a
						href="${pageContext.request.contextPath }/forum/p/${thisForum.forumId}?pageNum=1">首页</a></li>

					<c:if test="${currentReplyPage>1 }">
						<li><a
							href="${pageContext.request.contextPath }/forum/p/${thisForum.forumId}?pageNum=${currentReplyPage-1 }">上一页</a></li>
					</c:if>
					<c:choose>
						<c:when test="${totalReplyPage<=10 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${totalReplyPage }"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begin" value="${currentReplyPage-5 }"></c:set>
							<c:set var="end" value="${currentReplyPage+4 }"></c:set>
							<c:if test="${begin<1 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="10"></c:set>
							</c:if>
							<c:if test="${end>totalReplyPage }">
								<c:set var="begin" value="${totalReplyPage-9 }"></c:set>
								<c:set var="end" value="${totalReplyPage }"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:forEach var="i" begin="${begin }" end="${end }">
						<c:choose>
							<c:when test="${i==currentReplyPage }">
								<li class="disabled"><a href="#">${1 }</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a
									href="${pageContext.request.contextPath }/forum/p/${thisForum.forumId}?pageNum=${i }">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${currentReplyPage<totalReplyPage }">
						<li><a
							href="${pageContext.request.contextPath }/forum/p/${thisForum.forumId}?pageNum=${currentReplyPage+1 }">下一页</a></li>
					</c:if>
					<li><a
						href="${pageContext.request.contextPath }/forum/p/${thisForum.forumId}?pageNum=${totalReplyPage }">尾页</a></li>
				</ul>
			</div>

			<div class="inputBox">
				<textarea name="replytext" id="textArea" placeholder="说点什么吧" cols=""
					rows=""></textarea>
				<a href="javascript:void(0);" class="file"></a>
				<p>
					<a href="javascript:void(0);" class="expression" onclick="file();"></a>
					<a href="javascript:void(0);">艾特</a> <input type="button"
						value="发送" onclick="javascript:replyHost()">
				</p>
			</div>

		</div>
	</div>
	<jsp:include page="/baseView/footer.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath }/js/jquery-1.9.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath }/js/forumController/forum.js"
		type="text/javascript"></script>
</body>
</html>
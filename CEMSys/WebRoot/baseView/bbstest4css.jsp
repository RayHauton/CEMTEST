<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>校友论坛</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/head.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/forum.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/ihome.css">
<style type="text/css">
img {
	max-width: 100%;
}
</style>


<!-- 	ueditor编辑器 -->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/ueditor.all.min.js">
	
</script>
</head>
<body>

	<input type="hidden" value="${pageContext.request.contextPath }"
		id="basePath" />
	<input type="hidden" value="${thisForum.forumId }" id="forumId" />
	<input type="hidden" value="${thisForum.forumTitle }" id="forumTitle" />
	<input type="hidden" value="${thisForum.userId }" id="hostId">
	<jsp:include page="/baseView/header.jsp"></jsp:include>

	<div class="wholepage">
		<div class="reply">
			<div class="forum">
				<h1 name="title">${thisForum.forumTitle }</h1>
			</div>
			<div class="simple_block_container">
				<ul>
					<c:forEach var="test" items="${replyList }" varStatus="status">
						<li id="${test.replyId }">
							<div class="block">
								<div class="left_up">
									<span><img src="" alt="">头像</span>
								</div>
								<div class="right_up">
									<h4>
										<input type="hidden" id="userId${test.floor }"
											value="${test.publishUserId }" /> <cite>${test.replyTime }&nbsp;${test.floor }</cite>
										<a
											href="${pageContext.request.contextPath }/forum/ihome_tie?uid=${test.publishUserId }">${test.publishUser }</a>
										回复
									</h4>
									<c:if test="${test.replyObject != null }">
										<div class="table_main">引用${test.replyObject }L：${test.parentReplyId }</div>
									</c:if>
									<div class="every_reply">
										<div id="id${test.floor }">${test.replyText }</div>
									</div>
									<div class="replyinfo-reply">
										<c:if
											test="${user.role =='3' || user.userId == test.publishUserId }">
											<ins class="element" style="text-decoration: none;">
												<span style="color: #333; cursor: pointer; width: 50px;"
													name="${test.replyId }" onclick="deleteReply(this)"><img
													src="${pageContext.request.contextPath }/img/forum/gantanhao.png"
													alt="" style="width: 15px; height: 20px;">删除</span>
											</ins>
										</c:if>
										<span name="${test.floor }"
											style="color: #333; cursor: pointer;"
											onclick="messagebox(this)"><img
											src="${pageContext.request.contextPath }/img/forum/reply.png"
											alt="" style="width: 15px; height: 15px;">评论</span>
									</div>
									<div id="pp${test.floor }" class="commentText">
										<textarea placeholder="请输入内容" id="replyToHost${test.floor }"
											style="width: 610px; height: 102px;"></textarea>
										<input type="button" name="${test.floor }" value="发表评论"
											onclick="javascript:reply(this)" class="btn btn-default">
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
	
			
			<div class="container" style="text-align: center;">
				<c:if test="${totalReplyPage>1 }">
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
									<li class=active><a href="#">${i }</a></li>
								</c:when>
								<c:otherwise>
									<li><a
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
				</c:if>
			</div>
			<div>
				<textarea rows="5" cols="5" id="editor" style="height: 300px"></textarea>
				<input type="button" value="回复" onclick="replyHost()">
			</div>
		</div>

		<div class="aside">
			<div class="my_info">
				<div class="my_info_title">
					<!-- 					<span class="my_info_title_setting">[设置]</span>  -->
					<span class="my_info_title_title">个人信息</span>
				</div>
				<div class="my_info_content">
					<div class="my_info_content_img">头像</div>
					<div class="my_info_content_info">
						<p class="info_name">dadan</p>
						<p class="info_sex">男</p>
						<a href="${pageContext.request.contextPath }/forum/myMessage">
							<img alt=""
							src="${pageContext.request.contextPath }/img/forum/lingdang.png">
						</a> <span id="tongzhi" style="display: none;"><a
							href="${pageContext.request.contextPath }/forum/myMessage"><strong
								id="tongzhi-content">0</strong></a> </span>
					</div>
				</div>
			</div>
			<div class="somethingelse">
				<ul>
					<li class="somethingelse_home"><a
						href="${pageContext.request.contextPath }/forum/f/1">首页</a></li>
					<li class="somethingelse_mytie"><a
						href="${pageContext.request.contextPath }/forum/ihome_tie?uid=${sessionScope.user.userId }">个人中心</a></li>
				</ul>
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
	<script type="text/javascript">
		function messagebox(test) {
			var floor = $(test).attr('name');
			$('#pp' + floor).toggle();
		}
	</script>

</body>
</html>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/head.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/footer.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/forum.css">
<style type="text/css">
	img{
		max-width:100%;
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
	<jsp:include page="/baseView/header.jsp"></jsp:include>
<!-- 			<p>友好时间测试</p> -->
<!-- 			<div> -->
<!-- 				<p>消息通知测试</p> -->
<!-- 				以下是消息通知测试  -->
<!-- 				<span id="tongzhi" style="display: none;">有<a -->
<%-- 					href="${pageContext.request.contextPath }/forum/myMessage"><strong --%>
<!-- 						id="tongzhi-content">0</strong></a>条新消息 -->
<!-- 				</span> -->
<!-- 			</div> -->

			<div class="wholepage">
				<div class="reply">
					<div class="forum">
						<h1 name="title">${thisForum.forumTitle }</h1>
					</div>
					<div class="replylist">
						<ul class="list-group">
							<c:forEach var="test" items="${replyList }" varStatus="status">
								<li class="list-group-item forum">
									<div class="every-reply">
										<div class="replytext">${test.replyText }</div>
										<div class="replyinfo">
											<div class="replyinfo-info">
												<span><img src="${pageContext.request.contextPath }/img/forum/user.png" alt="${test.publishUser }" style="width: 9px;height: 8px;">${test.publishUser }</span> <span>${test.replyTime }</span>
												<input type="hidden" id="userId${test.floor }"
													value="${test.publishUserId }" />
											</div>
											<div class="replyinfo-reply">
												<c:if
													test="${user.role =='3' || user.userId == test.publishUserId }">
													<ins class="element" style="text-decoration: none;">
														<span style="color: #333; cursor: pointer; width: 50px;"
															name="${test.replyId }" onclick="deleteReply(this)"><img src="${pageContext.request.contextPath }/img/forum/gantanhao.png" alt="" style="width: 15px;height: 20px;">删除</span>
													</ins>
												</c:if>
												<span style="color: #333; cursor: pointer;"
													onclick="messagebox()"><img src="${pageContext.request.contextPath }/img/forum/reply.png" alt="" style="width: 15px;height: 15px;">评论</span>
											</div>
											<div id="pp"
												style="width: 800px; height: 150px; display: none;background-color: #f4fef6">
												<textarea  placeholder="请输入内容"
													id="replyToHost${test.floor }" style="width: 660px; height: 102px;"></textarea>
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
				</c:if>
			</div>
					<textarea rows="5" cols="5" id="editor" style="height: 300px" ></textarea>
				</div>

				<div class="aside">我是侧边栏</div>
			</div>



			
			
			
<!-- 			<div class="inputBox"> -->
<!-- 				<textarea name="replytext" id="textArea" placeholder="说点什么吧" cols="" -->
<!-- 					rows=""></textarea> -->
<!-- 				<a href="javascript:void(0);" class="file"></a> -->
<!-- 				<p> -->
<!-- 					<a href="javascript:void(0);" class="expression" onclick="file();"></a> -->
<!-- 					<a href="javascript:void(0);">艾特</a> <input type="button" -->
<!-- 						value="发送" onclick="javascript:replyHost()"> -->
<!-- 				</p> -->
<!-- 			</div> -->
	<jsp:include page="/baseView/footer.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath }/js/jquery-1.9.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath }/js/forumController/forum.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		function messagebox(){
			$('#pp').toggle();
		}
	</script>
	
</body>
</html>
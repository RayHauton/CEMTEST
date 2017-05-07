<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!--include libraried -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!--include summernote -->
    <link rel="stylesheet" href="summernote/dist2/summernote.css">
    <link rel="stylesheet" href="css/view_set/head.css">
    <link rel="stylesheet" href="css/view_set/footer.css">
    <style type="text/css">
        .wholepage {
            margin-left: auto;
            margin-right: auto;
            width: 1000px;
        }
        .input_span {
            width: 918px;
        }
    </style>
</head>

<body>
    <jsp:include page="/baseView/header.jsp"></jsp:include>
    <div class="wholepage">
        <hr>
        <p class="active-tab">
            <strong>当前选择的目标：</strong><span>全体师生</span>
        </p>
        <hr>
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#all" data-toggle="tab"> 全体校友</a></li>
            <li><a href="#class" data-toggle="tab">特定班级<b class="caret"></b></a></li>
            <li><a href="#grade" data-toggle="tab">特定年级<b class="caret"></b></a></li>
            <li><a href="#dept" data-toggle="tab">特定系<b class="caret"></b></a></li>
        </ul>
        <form id="form1" enctype="multipart/form-data">
            <div id="myTabContent" class="tab-content">
                <br>
                <div class="tab-pane fade in active" id="all">
                    <div class="input-group input_span" style="float:left;">
                        <span class="input-group-addon">收件人</span> <input type="text" class="form-control" value="全体校友" readonly="readonly">
                    </div>
                    <button id="mail123" class="btn btn-success" onclick="test11()">发送</button>
                    <br>
                </div>
                <div class="tab-pane fade" id="class">
                    <div class="input-group input_span" style="float:left;">
                        <span class="input-group-addon">班号</span> <input id="classNo" type="text" class="form-control" placeholder="请输入班号，如14级101班输入0914101">
                    </div>
                    <button type="button" class="btn btn-success" onclick="mailtoclass()">发送</button>
                    <br>
                </div>
                <div class="tab-pane fade" id="grade">
                    <div class="input-group input_span" style="float:left;">
                        <span class="input-group-addon">年级</span> <input id="gradeNo" type="text" class="form-control" placeholder="请输入年级，如10级输入10">
                    </div>
                    <button id="" type="button" class="btn btn-success" onclick="mailtograde()">发送</button>
                    <br>
                </div>
                <div class="tab-pane fade" id="dept">
                    <p>系</p>
                </div>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">主题</span> <input id="subject" name="subject" type="text" class="form-control">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">正文</span>
                <div id="summernote"></div>
            </div>
            <input type="button" id="button1" name="1" onclick="javascript:upload(this)" value="添加附件"> <input type="button"
                id="button2" name="2" onclick="javascript:upload(this)" value="继续添加" style="display: none;"> 
            <input type="file" id="file1" name="1" value="文件" style="display: none;" onchange="showOther(this)">
            <input type="file" id="file2" name="2" value="文件" style="display: none;" onchange="showOther(this)">
        </form>
    </div>
    <input type="hidden" value="${pageContext.request.contextPath }" id="basePath" />
    <jsp:include page="/baseView/footer.jsp"></jsp:include>

    <script src="js/mailController/mail.js" type="text/javascript"></script>
    <script type="text/javascript" src="summernote/dist2/summernote.min.js"></script>
    <script type="text/javascript" src="js/mailController/jquery-form.js"></script>
    
    <script type="text/javascript">
        $(document).ready(function () {
            $('#summernote').summernote({
                height: 400,
                minHeight: 300,
                maxHeight: 500,
                focus: false,
                lang: 'zh-CN',
                toolbar: [
                    ['style', ['bold', 'italic', 'underline', 'clear']],
                    ['fontsize', ['fontsize']],
                    ['color', ['color']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['height', ['height']],
                ]
            });
        });
        $(function () {
            $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                // 获取已激活的标签页的名称
                var activeTab = $(e.target).text();
                // 获取前一个激活的标签页的名称
                var previousTab = $(e.relatedTarget).text();
                $(".active-tab span").html(activeTab);
                $(".previous-tab span").html(previousTab);
            });
        });
        function test11(){
        	var form = new FormData(document.getElementById("form1"));
        	$.ajax({
        		type: "post",
        		async: false,
        		cache:false,
                url: $('#basePath').val()+"/mail/uploadMail",
                data: form,
                processData: false,
                contentType: false,
                success:function(data){
                	alert(88888);
                }
        	});
        }
    </script>
</body>

</html>
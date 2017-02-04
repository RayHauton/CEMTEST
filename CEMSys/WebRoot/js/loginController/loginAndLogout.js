function login(prefix,action,target){
    //alert($('#loginInfo').serialize());
    $.ajax({
        cache:false,
        type:"POST",
        url:prefix + action,
        data:$('#loginInfo').serialize(),
        async:true,
        error:function(){
            window.alert("服务器错误！");
        },
        success:function(data){
            if(data=="succ"){
                window.open(prefix + target,"_self");
                //window.location.href = prefix+target;
            }else if (data=="notExist") {
                window.alert("用户不存在，请尝试其他登录方式！");
            }else if(data=="notCheck"){
            	window.alert("抱歉，账号尚未审核！");
            }else if(data=="notPass"){
            	window.alert("账号未通过审核！请重新注册，并保证注册信息的正确！");
            }else{
                window.alert("密码错误！");
            }
        }
    });
    return false;
}
/*function login1(prefix,action,target){
    $.post(prefix+action,{
        loginMethod:$('#loginMethod').val(),
        password:$('#password').val()
    },function(data,status){
        if(status=='success'){
            if(data=="error"){
                window.alert("密码错误！");
                window.open(prefix + target, '_self');
            }else if (data=="notExist") {
                window.alert("用户不存在，请尝试其他登录方式！");
                window.open(prefix + target, '_self');
            }
        }else {
            window.alert("服务器错误！");
        }
    });
}*/
/**
 *
 * @param prefix localhost:8080
 * @param action 请求的action
 * @param target 注销成功跳转的请求路径
 */
function logout(prefix,action,target){
    $.post(prefix+action,{},function(data,status){
        if(status=='success'){
            if(data=='succ') {
                window.alert("注销成功！");
                //window.open(prefix + target, "_blank");
                window.location.href = prefix + target;
            }
            else{
                window.alert("尚未登录或者出现未知错误！")
            }
        }else {
            window.alert("服务器错误！");
        }

    });
}

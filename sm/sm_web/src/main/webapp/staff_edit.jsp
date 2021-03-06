<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" >
<title>添加</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/thems.css">
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
	//自适应屏幕宽度
	window.onresize=function(){ location=location }; 
	
	var main_h = $(window).height();
	$('.hy_list').css('height',main_h-45+'px');
	
	var main_w = $(window).width();
	$('.xjhy').css('width',main_w-40+'px');
	
});
</script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
	<div class="right_m">
        <div class="hy_list">
        	<div class="box_t">
            	<span class="name">编辑员工</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="edit.do " method="post" name="addForm">
            <div class="xjhy">
            <input style="display: none;" name="id" value="${staff.id }">
            <!--高级配置-->
                <ul class="hypz gjpz clearfix">
                
                    <li class="clearfix">
                        <span class="title">员工姓名：</span>
                        <div class="li_r">
                            <input class="chang" name="name" type="text" value="${staff.name }">
                            <i>*</i>
                        </div>
                    </li>
                     <li class="clearfix">
                        <span class="title">所属部门：</span>
                        <div class="li_r">
							<select name="did">
							<c:forEach items="${DLIST}" var="dep">
							<c:if test="${dep.id==staff.did }">
							 <option value="${dep.id}" } selected="selected">${dep.name}</option>
							</c:if>
							<c:if test="${dep.id!=staff.id }">
							 <option value="${dep.id}" }>${dep.name}</option>
							 </c:if>
							 </c:forEach>
							   
							</select>
                            <i>*</i>
                        </div>
                    </li>
                     <li class="clearfix">
                        <span class="title">员工性别：</span>
                        <div class="li_r">
                        	<c:if test="${staff.sex=='男' }">
                        	<span class="radio">
                                <input checked="checked" name="sex" type="radio" value="男">
                                <em>男</em>
                            </span>
                             <span class="radio">
                                <input name="sex" type="radio" value="女">
                                <em>女</em>
                            </span>
                        	</c:if>
                            <c:if test="${staff.sex!='男' }">
                        	<span class="radio">
                                <input name="sex" type="radio" value="男">
                                <em>男</em>
                            </span>
                             <span class="radio">
                                <input name="sex" checked="checked"  type="radio" value="女">
                                <em>女</em>
                            </span>
                        	</c:if>
                           
                        </div>
                    </li>
                     <li class="clearfix">
                        <span class="title">出生时间：</span>
                        <div class="li_r">
                        	
                            <input class="chang" name="bornDate" type="text" value="<fmt:formatDate value="${staff.bornDate }" pattern="yyyy-MM-dd"/>" >
                            	
                            </input>
                            <i>*</i>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">身份证号：</span>
                        <div class="li_r">
                            <input class="chang" name="idNumber" type="text" value="${staff.idNumber }">
                            <i>*</i>
                        </div>
                    </li>
                     <li class="clearfix">
                        <span class="title">备注：</span>
                        <div class="li_r">
                            <input class="chang" name="info" type="text"  value="${staff.info }">
                            <i>*</i>
                        </div>
                    </li>
                    
                    <li class="tj_btn">
                    	<a href="javascript:history.go(-1);" class="back">返回</a>
                        <a href="javascript:addForm.submit();">保存</a>
                    </li>
                </ul>
            <!--高级配置-->
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

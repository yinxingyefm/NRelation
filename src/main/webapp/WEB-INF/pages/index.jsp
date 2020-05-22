<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>出租单管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="/resources/css/public.css" media="all" />
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body class="childrenBody">
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	<legend>查询条件</legend>
</fieldset>
<form class="layui-form" method="post" id="searchFrm">
	<div class="layui-form-item">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">学工号:</label>
				<div class="layui-input-inline">
					<input type="text" name="num"     autocomplete="off"
						   class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">查询代数:</label>
				<div class="layui-input-inline">
					<input type="text" name="n"     autocomplete="off"
						   class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">开始时间:</label>
				<div class="layui-input-inline">
					<input type="text" name="startTime" id="startTime" readonly="readonly"   autocomplete="off"
						   class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">结束时间:</label>
				<div class="layui-input-inline">
					<input type="text" name="endTime" id="endTime"  readonly="readonly"  autocomplete="off"
						   class="layui-input">
				</div>
			</div>
		</div>
	</div>
	<div  class="layui-form-item" style="text-align: center;">
		<div class="layui-input-block" >
			<button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
			<button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
		</div>
	</div>
</form>

<!-- 搜索条件结束 -->


<!-- 数据表格结束 -->

<!-- 添加和修改的弹出层开始 -->


<script src="/resources/layui/layui.js"></script>
<script type="text/javascript">
    var tableIns;
    layui.use([ 'jquery', 'layer', 'form', 'table','laydate'  ], function() {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var laydate = layui.laydate;
        laydate.render({
            elem:'#startTime',
            type:'datetime'
        });
        laydate.render({
            elem:'#endTime',
            type:'datetime'
        });


        laydate.render({
            elem:'#begindate',
            type:'datetime'
        });
        laydate.render({
            elem:'#returndate',
            type:'datetime'
        });
        //渲染数据表格
        //模糊查询
        $("#doSearch").click(function(){
            var params=$("#searchFrm").serialize();
            alert(params);
            var  url="findRelation";
            $.post(url,params,function () {


            });


        });


    });
</script>
</body>
</html>
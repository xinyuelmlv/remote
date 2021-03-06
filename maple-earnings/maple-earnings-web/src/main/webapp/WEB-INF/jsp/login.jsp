<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript">
    var index_layout;
    var index_tabs;
    var index_tabsMenu;		
    var layout_west_tree_saleCost;
    var layout_west_tree_baobiao;
    var layout_west_tree_daozhang;
    var layout_west_tree_dingdan;
    var layout_west_tree_xitongsetting;
    var layout_west_tree_cuikuan;
    var layout_west_tree_userinfo;
    var layout_west_tree_connectorUs;
    $(function() {
        index_layout = $('#index_layout').layout({
            fit : true
        });

        index_tabs = $('#index_tabs').tabs({
            fit : true,
            border : false,
            tools : [{
                iconCls : 'icon-home',
                handler : function() {
                    index_tabs.tabs('select', 0);
                }
            }, {
                iconCls : 'icon-refresh',
                handler : function() {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    index_tabs.tabs('getTab', index).panel('open').panel('refresh');
                }
            }, {
                iconCls : 'icon-del',
                handler : function() {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    var tab = index_tabs.tabs('getTab', index);
                    if (tab.panel('options').closable) {
                        index_tabs.tabs('close', index);
                    }
                }
            } ]
        });
        layout_west_tree_baobiao = $('#layout_west_tree_baobiao').tree({
        	data: [
        	       {id:'4',text: '对账单',attributes:'/difference-report-list'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_daozhang = $('#layout_west_tree_daozhang').tree({
        	data: [
        	       {id:'5',text: '到账记录',attributes:'/incomeHistory'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_dingdan = $('#layout_west_tree_dingdan').tree({
        	data: [
        	        {id:'3',text: '订单详情',attributes:'/trade-list2'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_cuikuan = $('#layout_west_tree_cuikuan').tree({
        	data: [
        	        {id:'1',text: '等待催款',attributes:'/cuikuan'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_userinfo = $('#layout_west_tree_userinfo').tree({
        	data: [
        	        {id:'1',text: '信息维护',attributes:'/information'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_connectorUs = $('#layout_west_tree_connectorUs').tree({
        	data: [
        	        {id:'3',text: '联系我们',attributes:'/connectorUs'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_xitongsetting = $('#layout_west_tree_xitongsetting').tree({
        	data: [
        	        {id:'2',text: '用户中心',attributes:'/timeTongbu'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
            
    });

    function addTab(params) {
        var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
        var t = $('#index_tabs');
        var opts = {
            title : params.title,
            closable : true,
            iconCls : params.iconCls,
            content : iframe,
            border : false,
            fit : true
        };
        if (t.tabs('exists', opts.title)) {
            t.tabs('select', opts.title);
        } else {
            t.tabs('add', opts);
        }
    }

    function logout(){
        $.messager.confirm('提示','确定要退出?',function(r){
            if (r){
                progressLoad();
               // $.post('${path }/logout', function(result) {
                   // if(result.success){
                        window.location.href='http://www.fengling-tech.com.cn';
                        progressClose();
                   // }
               // }, 'json');
            }
        });
    }
</script>
</head>
<body>
	<div id="loading"
		style="position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 100; overflow: hidden;">
		<img src="${staticPath }/static/style/images/ajax-loader.gif"
			style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;" />
	</div>
	<div id="index_layout">
		<div data-options="region:'north',border:false"
			style="overflow: hidden;">
			<div>
				<span
					style="float: right; padding-right: 20px; margin-top: 15px; color: #333">欢迎
					<b> ${sessionScope.userId}</b>&nbsp;&nbsp; 		
				<a
					href="javascript:void(0)" onclick="logout()"
					class="easyui-linkbutton" plain="true" icon="icon-clear">安全退出</a>
				</span> <span class="header"></span>
			</div>
		</div>
		<div data-options="region:'west',split:true" title="导航栏"
			style="width: 200px; overflow: hidden; overflow-y: auto; padding: 0px">
			<div id="menu" class="easyui-accordion" fit="true" border="false">
<!-- 				<div title="商品成本" data-options="iconCls:'icon-search'" -->
<!-- 					style="overflow: auto; padding: 10px;"> -->
<!-- 					<ul id="layout_west_tree_saleCost"></ul> -->
<!-- 				</div> -->
               <div title="到账记录" data-options="iconCls:'icon-search'"
					style="padding: 10px;">
					<ul id="layout_west_tree_daozhang"></ul>
				</div>
				<div title="对账单" data-options="iconCls:'icon-search'"
					style="padding: 10px;">
					<ul id="layout_west_tree_baobiao"></ul>
				</div>
				<div title="交易信息" data-options="iconCls:'icon-search'"
					style="overflow: auto; padding: 10px;">
					<ul id="layout_west_tree_dingdan"></ul>
				</div>
				<div title="等待催款" data-options="iconCls:'icon-search'"
					style="overflow: auto; padding: 10px;">
					<ul id="layout_west_tree_cuikuan"></ul>
				</div>
				<div title="用户中心" data-options="iconCls:'icon-search',selected:true"
					style="overflow: auto; padding: 10px;">
					<ul id="layout_west_tree_xitongsetting"></ul>
					<ul id="layout_west_tree_userinfo"></ul>
					<ul id="layout_west_tree_connectorUs"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center'" style="overflow: hidden;">
			<div id="index_tabs" style="overflow: hidden;">
				<div title="首页" data-options="border:false"
					style="overflow: hidden;">
					<img src="${staticPath }/static/style/images/welcome.png"
						style="margin: auto;" />
				</div>
			</div>
		</div>
		<div data-options="region:'south',border:false"
			style="height: 30px; line-height: 30px; overflow: hidden; text-align: center; background-color: #eee">
			Copyright © 2017 power by <a href="#" target="_blank">北京枫灵科技有限公司</a>
		</div>
	</div>

	<!--[if lte IE 7]>
    <div id="ie6-warning"><p>您正在使用 低版本浏览器，在本页面可能会导致部分功能无法使用。建议您升级到 <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">Internet Explorer 8</a> 或以下浏览器：
    <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> / <a href="http://www.google.com/chrome/?hl=zh-CN" target="_blank">Chrome</a> / <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> / <a href="http://www.operachina.com/" target="_blank">Opera</a></p></div>
    <![endif]-->

	<style>
/*ie6提示*/
#ie6-warning {
	width: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background: #fae692;
	padding: 5px 0;
	font-size: 12px
}

#ie6-warning p {
	width: 960px;
	margin: 0 auto;
}
</style>
</body>
</html>
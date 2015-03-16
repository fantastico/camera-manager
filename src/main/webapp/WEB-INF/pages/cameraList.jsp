<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="cameraList.title"/></title>
    <meta name="menu" content="cameraMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='cameraList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/camera/addCamera'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/camera/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="cameraList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="row" export="false" pagesize="25">
        <display:column href="./connectCamera" paramId="apkId" paramProperty="apkId" titleKey="camera.connect">
        	<img src="../images/camera.png"/>
        </display:column>
        <display:column property="apkId" sortable="true" titleKey="camera.apk_id"/>
        <display:column property="status" sortable="true" titleKey="camera.status"/>
        <display:column property="ip" sortable="true" titleKey="camera.ip"/>
        <display:column property="maxUsers" sortable="true" titleKey="camera.maxUsers"/>
        <display:column property="currentUsers" sortable="true" titleKey="camera.currentUsers"/>
        <display:column href="./deleteCamera" paramId="apkId" paramProperty="apkId" titleKey="button.delete">
        	<img src="../images/action_delete.png"/>
        </display:column>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="cameraList.cameras"/></display:setProperty>
    </display:table>
</div>
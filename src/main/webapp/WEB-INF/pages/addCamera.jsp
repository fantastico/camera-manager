<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="cameraRegister.title" /></title>
<meta name="menu" content="UserMenu" />
</head>

<c:set var="delObject" scope="request">
	<fmt:message key="cameraList.camera" />
</c:set>
<script type="text/javascript">
	var msgDelConfirm = "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
	<h2>
		<fmt:message key="cameraRegister.heading" />
	</h2>
	<p>
		<fmt:message key="cameraRegister.message" />
	</p>
</div>

<div class="col-sm-7">
	<spring:bind path="bindCamera.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

	<form:form id="bindCamera" commandName="bindCamera" method="get" action="bindCamera" autocomplete="off" class="well"
		onsubmit="return validateBindCamera(this)">

		<div class="row">
			<div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
				<appfuse:label styleClass="control-label" key="bindCamera.apkId" />
				<form:input path="apkId" cssClass="form-control" maxlength="32" />
			</div>
		</div>

		<div class="form-group">
			<button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
				<i class="icon-ok icon-white"></i>
				<fmt:message key="button.save" />
			</button>

			<a href="./showCamera" class="btn btn-default">
				<i class="icon-remove"></i>
				<fmt:message key="button.cancel" />
			</a>
		</div>
	</form:form>
</div>

<c:set var="scripts" scope="request">
	<script type="text/javascript">
		// This is here so we can exclude the selectAll call when roles is hidden
		function onFormSubmit(theForm) {
			return validateBindCamera(theForm);
		}
	</script>
</c:set>

<v:javascript formName="bindCamera" staticJavascript="false" />
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>


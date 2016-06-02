
<%@ page import="com.memsource.Configuration" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-configuration" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-configuration" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'project.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'project.status.label', default: 'Status')}" />
						
						<g:sortableColumn property="status" title="${message(code: 'project.sourceLanguage.label', default: 'Source Language')}" />
						
						<g:sortableColumn property="status" title="${message(code: 'project.targetLanguages.label', default: 'Target Language(s)')}" />
					
					</tr>
				</thead>
				<tbody>
				
				
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${configurationInstanceCount ?: 0}" />
			</div>
			<g:hiddenField name="token" value="${token }" />
		</div>
		
		<script type="text/javascript">
			var projectListURL = "${createLink(controller : 'project', action:'getProjectList')}";
			console.log("projectListURL :: "+projectListURL )
			$(function() {
				$.ajax({
					url: projectListURL + "?token=" + $("#token").val(), 
					success: function(data){
						$("tbody").html("")
						$.each(data, function(index, element) {
				            //console.log(element.name + ":" + element.status + ":" + element.sourceLang + ":" + element.targetLangs)
				            var trClass = ((index % 2) == 0) ? "even" : "odd"
				            $("tbody").append("<tr class='"+trClass+"'>")
				            	$("tbody").append("<td> " +element.name + "</td>");
					            $("tbody").append("<td> " +element.status + "</td>");
					            $("tbody").append("<td> " +element.sourceLang + "</td>");
					            $("tbody").append("<td> " +element.targetLangs + "</td>");
				            $("tbody").append("</tr>");
				        });
			    	}
		    	});
			})
		</script>
	</body>
</html>

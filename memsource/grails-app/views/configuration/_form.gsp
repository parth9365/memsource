<%@ page import="com.memsource.Configuration" %>



<div class="fieldcontain ${hasErrors(bean: configurationInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="configuration.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${configurationInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configurationInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="configuration.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" required="" value="${configurationInstance?.password}"/>

</div>


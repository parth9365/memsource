package com.memsource

import grails.converters.JSON;

import org.codehaus.groovy.grails.web.json.JSONObject;

import com.google.gson.JsonArray;

class ProjectController {
	def projectService
	
    def index() { 
		redirect(action: "list")
	}
	
	/**
	 * @return
	 */
	def list() {
		//get the saved token from session
		def token = session.getAttribute("token")

		//pass it to jsp
		model: [token: token]
	} 
	
	/**
	 * makes an web service call to memsource API and retrieves the projects created by user
	 * @return jsonArray of projects
	 */
	def getProjectList() {
		
		//get token from ajax request
		def token = params?.token
		
		//get list of project as json array 
		def projectListJson = projectService.getProjectListJson(token)
		
		render projectListJson.json as JSON
	}
	
}

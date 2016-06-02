package com.memsource

import com.google.gson.JsonArray;

import grails.transaction.Transactional

@Transactional
class ProjectService {
	
	/**
	 * retrieves list of project with use of login token 
	 * @param token : consumes token to get access to project list
	 * @return jsonArray of project list
	 */
	def getProjectListJson(def token) {
		//initialize a rest builder
		def rest = new grails.plugins.rest.client.RestBuilder()
		
		//request json from mentioned url
		def resp = rest.get("https://cloud.memsource.com/web/api/v3/project/list?token=" + token) {
			accept JsonArray, 'application/json'
		}
		
		return resp
	}
}

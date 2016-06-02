package com.memsource

import com.google.gson.JsonObject;

import grails.transaction.Transactional

@Transactional
class ConfigurationService {

    def save(def configurationInstance) {
		configurationInstance.save flush:true
    }
	
	def update(def configurationInstance) {
		configurationInstance.save flush:true
	}
	
	def getAuthorizationJson(def username, def password) {
		def rest = new grails.plugins.rest.client.RestBuilder()
		def resp = rest.get("https://cloud.memsource.com/web/api/v3/auth/login?userName=" + username + "&password=" + password) {
				accept JsonObject, 'application/json'
		}
		
		return resp
	}
	
	def isLoginUnAuthorized(def resp) {
		return resp.json.errorCode == "AuthInvalidCredentials"
	}
}

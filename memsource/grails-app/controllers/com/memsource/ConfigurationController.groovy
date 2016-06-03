package com.memsource

import static org.springframework.http.HttpStatus.*

import org.codehaus.groovy.grails.web.json.JSONObject;

import com.google.gson.JsonObject;

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional(readOnly = true)
class ConfigurationController {
	
	def configurationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	/**
	 * redirects user to login page
	 * @return
	 */
	def login() {
		if(params?.invalidCrentials) {
			flash.message = "Invalid Credentials"
		}
		
		render(view: "login")
	}
	
	/**
	 * validates user credentials from web service call
	 * @return
	 */
	def loginSubmit() {
		def username = params?.username
		def password = params?.password
		
		def resp = configurationService.getAuthorizationJson(username, password)
		
		def isUnAuthorized = configurationService.isLoginUnAuthorized(resp)
		
		if(isUnAuthorized){			
			redirect(action: "login", params:[invalidCrentials: true])
		} else {
			session.removeAttribute("token");
			session.setAttribute("token", resp.json.token)
			redirect(controller: "project", action: "list")
		}
	}

    def index() {
        redirect(action:"login")
    }

    def create() {
        respond new Configuration(params)
    }

    @Transactional
    def save() {
		
		Configuration configurationInstance = new Configuration(params)
		
        if (configurationInstance == null) {
            notFound()
            return
        }

        if (configurationInstance.hasErrors()) {
            respond configurationInstance.errors, view:'create'
            return
        }

        configurationService.save(configurationInstance)

        redirect(action: "login")
    }

    def edit(Configuration configurationInstance) {
        respond configurationInstance
    }

    @Transactional
    def update(Configuration configurationInstance) {
        if (configurationInstance == null) {
            notFound()
            return
        }

        if (configurationInstance.hasErrors()) {
            respond configurationInstance.errors, view:'edit'
            return
        }

        configurationService.update(configurationInstance)

		redirect(action: "login")
    }
	
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'configuration.label', default: 'Configuration'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

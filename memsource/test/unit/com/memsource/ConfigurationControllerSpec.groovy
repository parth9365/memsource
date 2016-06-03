package com.memsource

import com.google.gson.JsonArray;
import com.memsource.Configuration;
import com.memsource.ConfigurationController;
import com.memsource.ConfigurationService;

import grails.plugins.rest.client.RestResponse;
import grails.test.mixin.Mock;
import grails.test.mixin.TestFor;
import spock.lang.Specification

@TestFor(ConfigurationController)
@Mock(ConfigurationService)
class ConfigurationControllerSpec extends Specification {

    def setup() {
		
    }

    def cleanup() {
    }

    void 'test index'() {
        when:
        controller.index()

        then:
        response.redirectedUrl == '/configuration/login'
    }
	
	void 'test create'() {
		when:
		controller.create()

		then:
		model.configurationInstance != null
	}
	
	void 'test login'() {
		when:
		controller.login()
		
		then:
		view == "/configuration/login"
	}
	
	 
	/*void 'test login submit'() {
		when:
		params.username = "parth9365"
		params.password = "parthsoni"
		controller.configurationService = new ConfigurationService()
//		controller.configurationService.metaClass.getAuthorizationJson = { -> return new RestResponse() }
//		controller.configurationService.metaClass.isLoginUnAuthorized = { -> return true }
		controller.loginSubmit()
		
		then:
		response.redirectedUrl == "/configuration/login"
	}*/
	
}

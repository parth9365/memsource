package com.memsource

import grails.test.mixin.*
import spock.lang.Specification

import com.memsource.ProjectController


@TestFor(ProjectController)
class ProjectControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	void 'test index'() {
		when:
		controller.index()

		then:
		response.redirectedUrl == '/project/list'
	}
}

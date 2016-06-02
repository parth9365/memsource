package com.memsource

class Configuration {
	
	String username
	
	String password

    static constraints = {
		username nullable:false, blank: false
		password  nullable:false, blank: false
    }
}

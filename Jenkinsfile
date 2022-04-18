pipeline{
    agent any
	tools {
        maven 'Maven 3.8.5'
        jdk 'jdk11'
    	}
	stages{
		stage('verify'){
        		steps{
            		sh "mvn -f pom.xml -Parquillian-payara clean verify"
        		}
    		}
	}  
}
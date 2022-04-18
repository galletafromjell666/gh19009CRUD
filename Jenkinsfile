pipeline{
    agent any

	stages{
		stage('verify'){
        		steps{
            		sh "mvn -f pom.xml -Parquillian-payara clean verify"
        		}
    		}
	}  
}
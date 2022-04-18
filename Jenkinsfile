pipeline{
    agent any
	stages{
		stage('verify'){
        		steps{
            		bat "mvn -f pom.xml -Parquillian-payara clean verify"
        		}
    		}
	}  
}
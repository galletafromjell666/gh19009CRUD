pipeline{
    agent any
	stages{
		stage('verify'){
        		steps{
            		bat "mvn clean verify sonar:sonar"
        		}
    		}
		stage('test'){
        		steps{
            		bat "mvn clean test"
        		}
    		}
		stage('package'){
        		steps{
            		bat "mvn clean package"
        		}
    		}
	}  
}
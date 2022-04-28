pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven 3.8.4 local"
    }

    stages {
        stage('verify'){
        		steps{
                    git 'https://github.com/IsaGher/gh19009CRUD.git'
            		sh "mvn -f pom.xml -Parquillian-payara clean verify"
        		}
    		}
    		stage('test'){
        		steps{
            		sh "mvn clean test"
        		}
                post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }  
    		}
    		stage('package'){
        		steps{
            		sh "mvn clean package"
        		}
    		}
            	stage('clone-front'){
        		steps{
            		     git 'https://github.com/IsaGher/bachesFront.git'
        		}
                post {
                success {
                    echo "front-end repo cloned sucessfully"
                }
            }  
    		}
    }
}

pipeline{
    agent any

    stage('verify'){
        steps{
            sh "mvn -f pom.xml -Parquillian-payara clean verify"
        }
    }

    
}
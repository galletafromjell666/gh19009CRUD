pipeline{
    agent any

    stage('test'){
        steps{
            sh "mvn -f pom.xml -Parquillian-payara clean verify"
        }
    }

    stage('Build application'){
        steps{
            echo "Construccion"
        }
    }
}
pipeline {
    agent any


    environment {
        registryCredential = 'docker_hub'

    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven 3.8.4 local"
    }

    stages {
        stage('Git') {
            steps {
                git 'https://github.com/galletafromjell666/gh19009CRUD.git'
            }
        }


        stage('Compile') {
            steps {
                sh "mvn -f pom.xml compile"
            }
        }



        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "mvn clean verify sonar:sonar"
                }
            }
        }


        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }



        stage('Test') {
            steps {
                sh "mvn clean test"
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }


        stage('Package') {
            steps {
                sh "mvn clean package"
            }
        }


        stage('Verify') {
            steps {
                sh "mvn -f pom.xml -Parquillian-payara clean verify"
            }
        }

        stage('Docker Build ') {
            steps {
                sh 'echo '
                sh 'docker build -t baches:1.0 --build-arg DB_USER=${DB_USER} --build-arg DB_PASSWORD=${DB_PASSWORD} --build-arg DB_NAME=${DB_NAME} ./'
                //sh 'docker tag samplewebapp nikhilnidhi/samplewebapp:$BUILD_NUMBER'

            }
        }

        stage('Publish image to Docker Hub') {

            steps {
                withDockerRegistry([credentialsId: registryCredential, url: ""]) {
                    sh 'docker push galletafromjell666/baches:1.0'
                }

            }
        }

        stage('Run Docker container on remote hosts') {

            steps {
                sh "docker -H ssh://gio02@${IP_HOST} run -d --add-host db:${IP_HOST} -p 8080:8080 galletafromjell666/baches:1.0"

            }
        }

    }
}

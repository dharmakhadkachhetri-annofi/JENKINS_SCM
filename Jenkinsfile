pipeline{
    agent any

    tools {
        jdk 'java-jdk'
        maven 'Maven'
    }
    environment{
        SCANNER_HOME=tool 'sonar-scanner'
    }
    stages{
        stage('Git Checkout'){
            steps{
                git branch: 'main', url:"https://github.com/dharmakhadkachhetri/Deployment.git"
            }
        }
        stage('Compile'){
            steps{
                sh "mvn clean package"
            }
        }
        stage('Test'){
            steps{
                sh "mvn test"
            }
        }
        stage('Sonar scanning'){
            steps{
                withSonarQubeEnv('sonar-server') {
                        sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Deployment \
                        -Dsonar.java.binaries=. \
                        -Dsonar.projectKey=Deployment '''
                    }
             }
        }
        stage('Build'){
            steps{
                sh "mvn clean package"
            }
        }
    }
}
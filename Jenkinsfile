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
                sh "mvn clean compile"
            }
        }
        stage('Sonar scanning'){
            steps{
                withSonarQubeEnv('Sonar_Token') {
                        sh ''' $Scanner_HOME/bin/sonar-scanner -Dsonar.projectName=Deployment \
                        -Dsonar.java.binaries=. \
                        -Dsoner.projectKey=Deployment '''
                    }
             }
        }
        stage('Package'){
            steps{
                sh "mvn clean package -DskipTests=true"
            }
        }
    }
}
pipeline{
    agent any

    tools {
        jdk 'java-jdk'
        maven 'Maven'
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
        stage('Package'){
            steps{
                sh "mvn clean package"
            }
        }
    }
}
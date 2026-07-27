pipeline{
    agent any

    tools{
        jdk 'jdk8'
        maven 'maven3'
    }
    stages{
        stage('Git Checkout'){
            steps{
                git branch: 'main', url:"https://github.com/dharmakhadkachhetri/Deployment.git"
            }
        }
        stage('Compile'){
            steps{
                sh "mvn clean complile"
            }
        }
        stage('Package'){
            steps{
                sh "mvn clean package"
            }
        }
    }
}
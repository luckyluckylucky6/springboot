pipeline {
    agent any

    stages {
        stage('Checkout From Git') {
            steps {
                checkout scmGit(branches: [[name: '${tag}']], extensions: [], userRemoteConfigs: [[url: 'git@github.com:luckyluckylucky6/springboot.git']])
            }
        }
        stage('Build By Maven') {
            steps {
                sh '''mvn clean package -Dmaven.test.skip
                mkdir docker/java
                mv target/springboot.jar docker/java
                mvn clean'''
            }
        }
        stage('Build By Docker') {
            steps {
                sh '''cd docker
                docker build crpi-12tq7ejp5irxwm77.cn-hangzhou.personal.cr.aliyuncs.com/m1-test/springboot:${tag}
                rm -rf java'''
            }
        }
    }
}

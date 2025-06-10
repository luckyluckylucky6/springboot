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
                docker build -t crpi-12tq7ejp5irxwm77.cn-hangzhou.personal.cr.aliyuncs.com/m1-test/springboot:${tag} .
                rm -rf java'''
            }
        }
        stage('Push Docker Image To Repository') {
            steps {
                sh '''cd docker
                docker push crpi-12tq7ejp5irxwm77.cn-hangzhou.personal.cr.aliyuncs.com/m1-test/springboot:${tag}
                docker rmi -f crpi-12tq7ejp5irxwm77.cn-hangzhou.personal.cr.aliyuncs.com/m1-test/springboot:${tag}'''
            }
        }
        stage('Exec On Kubernetes') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'k8s-master', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''kubectl set image deployment springboot springboot=crpi-12tq7ejp5irxwm77.cn-hangzhou.personal.cr.aliyuncs.com/m1-test/springboot:${tag} --record
                ''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}

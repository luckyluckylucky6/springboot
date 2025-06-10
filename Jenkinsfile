pipeline {
    agent any

    stages {
        stage('Checkout From Git') {
            steps {
                checkout scmGit(branches: [[name: '${tag}']], extensions: [], userRemoteConfigs: [[url: 'git@github.com:luckyluckylucky6/springboot.git']])
            }
        }
    stages {
            stage('Build By Maven') {
                steps {
                    sh '''mvn clean package -Dmaven.test.skip
                    mkdir docker/java
                    mv target/springboot.jar docker/java
                    mvn clean
                    '''
                }
            }
    }
}

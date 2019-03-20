node {
  stage('Configure') {
        env.PATH = "${tool 'maven'}/bin:${env.PATH}"
        version = '1.0.' + env.BUILD_NUMBER
        currentBuild.displayName = version

        properties([
                buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
                [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/medmedchiheb/jenkins-cicd-sample'],
                pipelineTriggers([[$class: 'GitHubPushTrigger']])
            ])
 }

 stage('SCM checkout') {
   git 'https://github.com/medmedchiheb/devops-ci-simple'
 }

 stage('Compile ') {
  sh "mvn clean install"
  junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
 }

 stage('Build Docker image ') {
  sh "docker build -t medchiheb/sample-java-app ."

 }

 stage('Push to DockerHub') {
   withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerPWD')]) {
     sh "docker login -u medchiheb -p ${dockerPWD}"
   }
   sh "docker push medchiheb/sample-java-app"
 }

 stage('Deploy') {
      sshagent(['dev-aws']) {
        def runCMD = 'docker run -d --name sample_app -p 8080:8088 medchiheb/sample-java-app'
        sh "ssh -o StrictHostKeyChecking=no ec2-user@ec2-54-191-122-228.us-west-2.compute.amazonaws.com ${runCMD}"
      }

  }

}

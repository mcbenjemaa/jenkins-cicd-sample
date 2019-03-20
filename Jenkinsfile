node {
  stage('Configure') {
        env.PATH = "${tool 'maven'}/bin:${env.PATH}"
        version = '1.0.' + env.BUILD_NUMBER
        currentBuild.displayName = version

        properties([
                buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
                [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/medmedchiheb/devops-ci-simple'],
                pipelineTriggers([[$class: 'GitHubPushTrigger']])
            ])
 }
 
 stage('SCM checkout') {
   git 'https://github.com/medmedchiheb/devops-ci-simple'
 }
 
 stage('Build') {
  // get Maven home path
  def mvnHome = tool name: 'maven', type: 'maven'
  sh "mvn clean install"
 }
 
 stage('Archive') {
        junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
 }
  
  stage('Deploy') {
    sshagent(['dev-aws']) {
       sh 'ssh -o StrictHostKeyChecking=no ec2-user@172.31.26.213'

    }

    /*sshagent (credentials: ['aws-vm']) {
      sh 'ssh -o StrictHostKeyChecking=no ec2-user@ec2-54-187-220-60.us-west-2.compute.amazonaws.com -a'
      //sh '' 
    }*/
    
  }

}

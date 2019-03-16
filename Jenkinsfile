node {

 stage('SCM checkout') {
   git 'https://github.com/medmedchiheb/devops-ci-simple'
 }
 stage('Compile-package') {
  sh 'mvn package'
 }

}

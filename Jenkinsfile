pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Hello Jenkins !'
            sh '''echo "Pipeline is starting ..!"
echo "This is build stage !"'''
          }
        }
        stage('Test') {
          steps {
            sh 'echo "This is Test Stage !"'
            build 'DubizzleTest'
          }
        }
        stage('Deploy') {
          steps {
            echo 'This is Deployment Stage !'
            echo 'Finished !'
          }
        }
      }
    }
  }
}
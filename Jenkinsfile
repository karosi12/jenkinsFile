def gv

pipeline {
  agent any
  stages{
    stage("init"){
      steps{
        script {
          gv = load "ec2-deploy.groovy"
        }
      }
    }
    stage("test"){
      steps{
        script{
          gv.test()
        }
      }
    }
    stage("build"){
      steps{
        script{
          gv.build()
        }
      }
    }
    stage('deploy') {
      steps {
        script {
          gv.deploy()
        }
      }
    }
  }
}
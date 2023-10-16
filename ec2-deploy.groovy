def build() {
  echo "Building the application"
}

def test() {
  echo "Testing the application"
}

def deploy() {
  script {
    echo "Deploying the application"
    def dockerCmd = 'docker run -d -p 3080:3080 karosi12/demo-app:v1'
    sshagent(['ec2-server-key']) {
      sh "ssh -o StrictHostKeyChecking=no ec2-user@34.231.139.165 ${dockerCmd}"
    }
  }
}

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
    sshagent(['70a5c83e-ed01-4df2-8a8f-8ef420f0f1e0']) {
      sh "ssh -o StrictHostKeyChecking=no ec2-user@44.206.140.40 ${dockerCmd}"
    }
  }
}

return this
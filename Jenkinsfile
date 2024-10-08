pipeline {
  agent {
    docker {
      image 'abhishekf5/maven-abhishek-docker-agent:v1'
      args '--user root -v /var/run/docker.sock:/var/run/docker.sock' // mount Docker socket to access the host's Docker daemon
    }
  }

  stages {
    stage('Checkout') {
      steps {
        sh 'echo passed'
        //git branch: 'main', url: 'https://github.com/araheemcis/calculationApp.git'
      }
    }
    stage('Build and Test') {
      steps {
        sh 'ls -ltr'
        // build the project and create a JAR file
        sh 'mvn clean package'
      }
    }
    stage('Static Code Analysis') {
      environment {
        SONAR_URL = "http://50.17.63.140:9000/"
      }
      steps {
        withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
          sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
        }
      }
    }
    stage('Build and Push Docker Image') {
      environment {
        DOCKER_IMAGE = "araheemcis/calculationapp:${BUILD_NUMBER}"
        // DOCKERFILE_LOCATION = "Dockerfile"
        REGISTRY_CREDENTIALS = credentials('docker-cred')
      }
      steps {
        script {
            sh 'docker build -t ${DOCKER_IMAGE} .'
            def dockerImage = docker.image("${DOCKER_IMAGE}")
            docker.withRegistry('https://index.docker.io/v1/', "docker-cred") {
                dockerImage.push()
            }
        }
      }
    }
    stage('Update the tag in helm'){
      environment {
            GIT_REPO_NAME = "calculationApp"
            GIT_USER_NAME = "araheemcis"
        }
        steps {
            withCredentials([string(credentialsId: 'github', variable: 'GITHUB_TOKEN')]){
                   
             sh '''
                    echo passed
                    git config user.email "araheemcis@gmail.com"
                    git config user.name "Abdul Raheem"
                    BUILD_NUMBER=${BUILD_NUMBER}
                    sed -i 's/tag: .*/tag: '${BUILD_NUMBER}'/'  'helm/calculationapp_chart/values.yaml'                    
                    git add helm/calculationapp_chart/values.yaml
                    git commit -m "Update helm chart_tag ${BUILD_NUMBER}"
                    git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main
                '''
              }
            }
         }
    }
}

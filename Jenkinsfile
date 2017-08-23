pipeline {
  agent any
  stages {
    stage('Stage 1') {
      steps {
        sh '''#!/bin/bash
echo "stage 1"'''
      }
    }
  }
  environment {
    http_proxy = ''
    HTTP_PROXY = ''
    https_proxy = ''
    HTTPS_PROXY = ''
  }
}
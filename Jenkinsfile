pipeline {
  agent { label "${JENKINS_NODE}"}
  
  stages {
    stage('Initialize') {
      steps{
        
        echo "PATH = ${PATH}"
        echo "MAVEN_HOME = ${MAVEN_HOME}"
        echo "M2_HOME =  ${M2_HOME}"
        
      }
    }
    
       stage('Git Deployment') {
      steps{
        
        echo "Git Deployment Started"
        
        echo "Git Deployment Completed"
        
      }
    }
    
      stage('Build') {
      steps{
        
        bat ''' cmd
          mvn -Dmaven.test.failure.ignore=true install
          mvn clean test -Dinclude=${RUNNER_JAVA_FILE}
          mvn clean install -DskipTests
        '''
          }
                  }
}
}

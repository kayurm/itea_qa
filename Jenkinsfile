pipeline {
    agent any

    stages {
        stage('Preparations') {
            steps {
                echo 'Pulling github project'
                git 'https://github.com/kayurm/itea_qa.git/'
            }
        }

        stage('Ui tests') {
            steps {
                echo 'ui tests'
                //bat(/mvn -DsuiteXmlFile=testngHW12.xml test/)  <-this style for pipeline file in jenkins directly
                bat 'mvn -DsuiteXmlFile=testngHW12.xml test'
            }
        }
    }
}
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "3.9.2"
        jdk "jdk"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'master', url: 'https://github.com/MikhailMorozov/QaseIn.git'

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true -Dlogin=${login} -Dpassword=${password} -Dsurefire.suiteXmlFiles=src/test/resources/fullSuite.xml clean test"

                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Reporting') {
            steps {
             script {
                 allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'allure-results']]
                ])
            }
            }
        }
    }
}
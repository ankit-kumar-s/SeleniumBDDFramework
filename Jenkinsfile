pipeline {

    agent any

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Browser for test execution'
        )

        choice(
            name: 'EXECUTION',
            choices: ['local', 'grid'],
            description: 'Execution mode'
        )
    }

    triggers {
        cron('0 23 * * *')
        pollSCM('H/5 * * * *')
    }

    stages {

        stage('Test Execution') {
            steps {
                bat ".\\mvnw.cmd clean test -Pqa -Dbrowser=%BROWSER% -Dexecution=%EXECUTION%"
            }
        }
    }

    post {

        always {
            archiveArtifacts(
                artifacts: 'reports/cucumber/cucumber.html',
                allowEmptyArchive: true
            )
        }

        success {
            echo 'Automation execution completed successfully.'
        }

        failure {
            echo 'Automation execution failed. Check console logs and archived artifacts.'
        }
    }
}
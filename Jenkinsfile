pipeline {
    agent any
    

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_8_2') {
                    cmd_exec('mvn clean compile')
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_8_2') {
                     cmd_exec('mvn test')
                }
            }
        }


        stage ('print timestamp and docker run') {
            steps {
                echo "TimeStamp: ${currentBuild.startTimeInMillis}"
                script {
                    def now = new Date()
                    println now.format("yyMMdd.HHmm", TimeZone.getTimeZone('UTC'))
                    echo "TimeStamp: ${now}"
                }
                cmd_exec('docker build -t covid-app .')
                cmd_exec('docker run -p 8000:8080 covid-app')                
            }
        }
    }
}

def cmd_exec(command) {
    return bat(returnStdout: true, script: "${command}").trim()
}

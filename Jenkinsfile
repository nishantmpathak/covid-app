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


        stage ('print timestamp') {
            steps {
                echo "TimeStamp: ${currentBuild.startTimeInMillis}"
                echo "TimeStamp: ${Util.getTimeSpanString(System.currentTimeMillis())}"
            }
        }
    }
}

def cmd_exec(command) {
    return bat(returnStdout: true, script: "${command}").trim()
}

def call(body) {
    MPLInit()

    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    MPLModule()
                }
            }
            stage('Build') {
                steps {
                    MPLModule()
                }
            }
            stage('Deploy') {
                steps {
                    MPLModule()
                }
            }
        }
    }
}

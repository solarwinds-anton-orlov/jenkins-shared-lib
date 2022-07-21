def call(body) {
    MPLInit()

    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    MPLModule()
                    MPLModule('Vulnerable')
                }
            }
            stage('Build') {
                steps {
                    MPLModule()
                }
            }
            stage('Publish') {
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

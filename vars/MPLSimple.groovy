def call(body) {
    MPLInit()

    def MPL = MPLPipelineConfig(body, [
        agent_label: 'any',
        modules: [
            Test: [:],
            Build: [:],
            Publish: [:],
            Deploy: [:]
        ]
    ])

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

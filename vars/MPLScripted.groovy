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

    stage('Test') {
        MPLModule()
    }
    stage('Build') {
        MPLModule()
    }
    stage('Publish') {
        MPLModule()
    }
    stage('Deploy') {
        MPLModule()
    }
}

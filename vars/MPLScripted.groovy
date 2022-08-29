def call(body) {
    MPLInit()

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

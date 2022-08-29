def call(body) {
    MPLInit()

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

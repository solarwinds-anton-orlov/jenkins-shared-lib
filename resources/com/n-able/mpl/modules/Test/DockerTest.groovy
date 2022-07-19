def imageName = CFG.'image_name.test' ? CGF.'image_name.test' : "test/${env.JOB_NAME}:${env.BUILD_NUMBER}"
def imageStage = CFG.'image_stage.test' ? CFG.'image_stage.test' : 'test'
def testResults = CFG.'test_results' ? CFG.'test_results' : "${env.WORKSPACE}/.results"

sh "rm -Rf ${testResults} && mkdir -p ${testResults}"
def testImage = docker.build(imageName, "--target ${imageStage} .")
testImage.withRun("-v ${testResults}:/opt/results") { c ->
    echo "Running tests..."
}

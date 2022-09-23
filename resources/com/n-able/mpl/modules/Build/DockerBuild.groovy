echo "Building steady docker container..."
def imageName = CFG.'image_name.steady' ? CFG.'image_name.steady' : "steady/${env.JOB_NAME}:${env.BUILD_NUMBER}"
def imageStage = CFG.'image_stage.steady' ? CFG.'image_stage.steady' : 'steady'
def dockerfile = CFG.'dockerfile' ? CFG.'dockerfile' : '.'
def steadyImage = docker.build(imageName, "--target ${imageStage} ${dockerfile}")
OUT.'docker_image' = steadyImage

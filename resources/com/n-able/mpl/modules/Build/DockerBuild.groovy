echo "Building steady docker container..."
def imageName = CFG.'image_name.steady' ? CGF.'image_name.steady' : "steady/${env.JOB_NAME}:${env.BUILD_NUMBER}"
def imageStage = CFG.'image_stage.steady' ? CFG.'image_stage.steady' : 'steady'
def steadyImage = docker.build(imageName, "--target ${imageStage} .")
OUT.'docker_image' = steadyImage

echo "N-Able build"
def image = MPLModule('Docker Build', CFG).'docker_image'
OUT.'docker_image' = image

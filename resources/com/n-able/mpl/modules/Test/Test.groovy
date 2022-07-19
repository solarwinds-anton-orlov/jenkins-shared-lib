echo "N-Able test"
def image = MPLModule('Docker Test', CFG).'dcker_image'
OUT.'docker_image' = image

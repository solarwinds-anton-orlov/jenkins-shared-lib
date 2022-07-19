def call() {
  // Using the latest release MPL and adding the custom path to find modules
  echo "Individual init!"
  library('mpl')
  MPLModulesPath('com/n-able/mpl')
}

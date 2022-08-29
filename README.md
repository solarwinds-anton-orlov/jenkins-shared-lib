MPL-Based Jenkins Test Pipeline
===============================

Introduction
------------

This pipeline is based on the shared library and approach explained in the following article. It relies on Jenkins shared library [MPL](https://www.jenkins.io/blog/2019/01/08/mpl-modular-pipeline-library/) 22.02 and implements a sample pipeline with the following stages:
* _Test_ - the stage when static code analyzer and unit-tests could be launched in the environment inside the container.
* _Build_ - the stage when the final artifact (i.e. Docker container) will be created.
* _Publish_ - the stage where the artifact will be published on the artifactory.
* _Deploy_ - the stage where the artifact will be delivered into the corresponding environment.

How it works?
-------------

This test pipeline is represented by the shared library on the top of MPL - [nested library](https://github.com/griddynamics/mpl#nested-libraries). So, according to the main concept of the MPL shared library, the pipeline should be compiled from small pieces of logic - modules. In our case, one single module represents a stage of the pipeline (in the real-life pipeline, it does not necessarily be so). Each module is expressed by an individual folder in the `modules` folder: it consists of the main module file (the same as the folder name + `.groovy`) and one or multiple options of logic implementation (which could be optional).

Also, there are two interfaces declared in the `vars` folder: init and the pipeline itself. Init interface includes the function that initializes the MPL library and sets up the nested library. The pipeline interface describes the pipeline the same way as in the regular `Jenkinsfile` with one difference: for different stages, it calls different modules of the MPL, instead of the inline code of the pipeline.

On the project side, it's necessary to include this library and call the interface of the pipeline.

Jenkins Set Up
--------------

To exploit this example, it's necessary to set up Jenkins properly. First of all, it's necessary to set up MPL shared library. So, go to **Manage Jenkins > Configure System** and add a new shared library with the following attributes:
* Name: `mpl`
* Default version: `22.02`
* Retrieval method: `Modern SCM`
* Source Code Management: `GitHub`
* Repository HTTPS URL: `https://github.com/griddynamics/mpl`
* The rest attributes might be set considering individual specific of Jenkins installation

When the MPL library is connected, it's time to set up this nested library. The process is pretty similar and includes adding a new shared library with the following attributes:
* Name: `mpl-nested`
* Default version: `v1.1`
* Retrieval method: `Modern SCM`
* Source code management: `GitHub`
* Repository HTTPS URL: `https://github.com/solarwinds-anton-orlov/jenkins-shared-lib`
* The rest attributes might be set considering individual specific of Jenkins installation

The Project
-----------

It's expected that the project source code repo includes a multi-stage `Dockerfile`, that consists of two stages:
* `test` - the stage that produces the image with the test environment and tools that could be used to execute unit tests and code quality analyzers.
* `steady` - the stage that produces the potential production-ready image with the application inside.

**NOTE.** It's possible to re-define default names of stages in the config of the pipeline using `image_stage.test` and `image_stage.steady` variables.

On the project level (`Jenkinsfile`) it's enough to use the following code to enable the pipeline:

```Groovy
@Library('mpl-nested') _
MPLSimple()
```
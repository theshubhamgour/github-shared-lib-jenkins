def call(String appDir = '4-python-jenkins-docker-app', 
         String credentialsId = 'theshubhamgour') {

    dir(appDir) {
        withCredentials([usernamePassword(
            credentialsId: credentialsId,
            passwordVariable: 'DockerhubPassword',
            usernameVariable: 'DockerhubUserName'
        )]) {
            sh """
                echo "$DockerhubPassword" | docker login -u "$DockerhubUserName" --password-stdin
            """
        }
    }
}

def call() {
    dir('4-python-jenkins-docker-app') {
        withCredentials([
            usernamePassword(
                credentialsId: 'theshubhamgour',
                passwordVariable: 'DockerhubPassword',
                usernameVariable: 'DockerhubUserName'
            )
        ]) {
            sh '''
                echo "$DockerhubPassword" | docker login -u "$DockerhubUserName" --password-stdin
                docker tag python-app:latest theshubhamgour/python-app:latest
                docker push theshubhamgour/python-app:latest
            '''
        }
    }
}

pluginManagement {
    val repositoryUrl = "https://developer.huawei.com/repo/"
    println("Use plugin repository $repositoryUrl")
    repositories {
        maven {
            url = uri(repositoryUrl)

        }
        maven {
            url = uri("https://jfrog.betalpha.com/artifactory/plugins-release/")
            credentials {
                username = "betalpha"
                password = "beifa888"
            }
        }

        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "RegistrationSystem"

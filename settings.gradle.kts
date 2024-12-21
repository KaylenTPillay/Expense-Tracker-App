pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    /**
     * **Warning Suppressed**:
     *
     * This is in incubating feature. This means the the API is subject to change and the warning
     * here illustrates that.
     *
     * The repositoriesMode allows us to set how subproject dependencies are defined. In this case,
     * This repositoriesMode is used to enforce that only repositories declared in settings.gradle(.kts)
     * are used, you can configure Gradle to fail the build when a project plugin is declared.
     *
     * There are three repositoriesMode:
     * - PREFER_PROJECT (default)
     * - PREFER_SETTINGS
     * - FAIL_ON_PROJECT_REPOS
     *
     * See documentation for more information:
     * - https://docs.gradle.org/current/userguide/centralizing_repositories.html#sec:repositories-mode
     */
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    /**
     * **Warning Suppressed**:
     *
     * This is in incubating feature. This means the the API is subject to change and the warning
     * here illustrates that.
     *
     * The repositories block is used to define the download location for dependencies. In this case
     * the google and mavenCentral download locations are defined.
     *
     * See documentation for more information:
     * - https://docs.gradle.org/current/userguide/declaring_repositories.html
     */
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Expense Tracker"
include(":app")

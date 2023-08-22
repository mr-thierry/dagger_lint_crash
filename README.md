# dagger_lint_crash

This is a project to reproduce https://github.com/google/dagger/issues/3980

To reproduce the crash:
1. Clone this project locally
2. Execute "./gradlew :app:lintDebug"


You can also use the branch `lint_in_project` to run a check that reproduce the issue. But instead of running the Dagger check, it runs a check from the project.

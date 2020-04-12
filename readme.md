./gradlew clean test --tests WikiTest -Penv=qa
./gradlew clean test -Penv=dev
./gradlew clean uiTests -Penv=qa

./gradlew allureReport
./gradlew allureServe

./gradlew --stacktrace --debug build

owner - properties management
rest assured - api
selenide - ui
lombok - annotation helper
./gradlew build

native-image -H:EnableURLProtocols=https --verbose -jar build/libs/graal-github-repos-kt-1.0-SNAPSHOT-all.jar github --no-server --no-fallback

/usr/bin/time -v ./github
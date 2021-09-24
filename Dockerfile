FROM open-liberty:beta-java11

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
    org.opencontainers.image.authors="Your Name" \
    org.opencontainers.image.vendor="Fachhochschule Südwestfalen" \
    org.opencontainers.image.url="local" \
    org.opencontainers.image.source="https://github.com/fhswf/OpenLibertyTemplate" \
    org.opencontainers.image.version="$VERSION" \
    org.opencontainers.image.revision="$REVISION" \
    vendor="Fachhochschule Südwestfalen" \
    name="system" \
    version="$VERSION-$REVISION" \
    summary="The system microservice from the Getting Started guide" \
    description="This image contains the system microservice running with the Open Liberty runtime."

COPY --chown=1001:0 src/main/liberty/config/ /config/
COPY --chown=1001:0 target/*.war /config/apps/

EXPOSE 9080

RUN configure.sh
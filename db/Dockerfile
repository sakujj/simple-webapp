FROM postgres:latest

ENV POSTGRES_USER test
ENV POSTGRES_PASSWORD 123
ENV POSTGRES_DB sw

COPY init.sql /docker-entrypoint-initdb.d

#!/usr/bin/env sh

PROJECT_DIRECTORY=$(dirname $(cd "$(dirname "$0")" && pwd))
PROJECT_SCRIPT_DIRECTORY=$PROJECT_DIRECTORY/script

function start_app() {
  docker-compose -f $PROJECT_SCRIPT_DIRECTORY/docker-compose.yml up -d $1
}

function show_status() {
    docker-compose -f $PROJECT_SCRIPT_DIRECTORY/docker-compose.yml ps
}

start_app db
start_app eureka
sleep 10
start_app config
start_app gateway
sleep 10
start_app email
sleep 10
start_app user
sleep 30
show_status


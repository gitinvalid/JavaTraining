#!/usr/bin/env sh

PROJECT_DIRECTORY=$(dirname $(cd "$(dirname "$0")" && pwd))
PROJECT_SCRIPT_DIRECTORY=$PROJECT_DIRECTORY/script

function build_eureka_image() {
  echo 'build eureka image'
  cd $PROJECT_DIRECTORY && docker build -t eureka -f $PROJECT_SCRIPT_DIRECTORY/Dockerfile eureka
}

function build_config_image() {
  echo 'build config image'
  cd $PROJECT_DIRECTORY && docker build -t config -f $PROJECT_SCRIPT_DIRECTORY/Dockerfile config
}

function build_gateway_image() {
  echo 'build gateway image'
  cd $PROJECT_DIRECTORY && docker build -t gateway -f $PROJECT_SCRIPT_DIRECTORY/Dockerfile gateway
}

function build_user_image() {
  echo 'build user image'
  cd $PROJECT_DIRECTORY && docker build -t user -f $PROJECT_SCRIPT_DIRECTORY/Dockerfile user
}

function build_email_image() {
  echo 'build email image'
  cd $PROJECT_DIRECTORY && docker build -t email -f $PROJECT_SCRIPT_DIRECTORY/Dockerfile email
}

build_eureka_image
build_config_image
build_gateway_image
build_user_image
build_email_image
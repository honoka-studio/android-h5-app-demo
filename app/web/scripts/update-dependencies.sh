#!/bin/bash

set -e

cd "$(dirname $0)/.."
project_path="$(pwd)"

if [ ! -d node_modules ]; then
  exit 0
fi

remove-package() {
  rm -rf "$project_path/node_modules/@honoka/$1"
}

remove-package js-utils

if [ "$1" = local ]; then
  npm install --@honoka:registry=http://localhost:4873/
else
  npm install
fi

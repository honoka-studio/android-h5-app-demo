#!/bin/bash

set -e

cd "$(dirname $0)/.."
project_path="$(pwd)"

if [ ! -d node_modules ]; then
  echo 'No node_modules found.'
  exit 0
fi

reinstall() {
  rm -rf "$project_path/node_modules/@honoka/$1"
  if [ "$1" = local ]; then
    pnpm install --@honoka:registry=http://localhost:4873/ --force "@honoka/$1"
  else
    pnpm install --force "@honoka/$1"
  fi
}

reinstall js-utils

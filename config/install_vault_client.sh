#!/usr/bin/env bash

download(){
    local url=$1
    local output_file=$2
    wget --show-progress  $url 2>&1 -O $output_file
}

extract(){
    local file=$1
    local dir=$2
    unzip $file -d $dir
}

echo "Download vault"
download https://releases.hashicorp.com/vault/0.10.3/vault_0.10.3_darwin_amd64.zip  vault.zip

echo "Unzip vault"
extract vault.zip .

rm vault.zip

chmod 777 vault
#!/bin/bash
path=$1


while [ true ]
do
    result=$(curl -s http://10.70.200.97/$path | jq '.version')
    data=$(date)
    echo "$data -> $result"
    sleep 1s
done
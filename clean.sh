#!/bin/bash
rm -rf Jenkins*.jar
app_name=$1

# get the pid
pid=`ps -ef | grep $1 | grep 'java -jar' | awk '{printf $2}'`
echo $pid

if [ -z $pid ];
  then
    echo "$app_name not started"
  else
    kill -9 $pid
fi
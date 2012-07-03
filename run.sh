#! /bin/sh

classpath=./target/main

for i in lib/*.jar
do
    classpath=$classpath:$i
done

exec java -classpath $classpath Main

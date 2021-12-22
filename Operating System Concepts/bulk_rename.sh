#!/bin/bash

alpha="abcdefghijklmnopqrstuvwxyz"
count=0
for i in $(ls data); do
	src="$i"
	newname=${alpha:$count:1}
	dest="$newname$i"
	mv data/$src data/$dest
	echo "data/$src data/$dest"
	((count++))
done

#!/bin/bash

alpha="abcdefghijklmnopqrstuvwxyz"
count=0
for i in $(ls data); do
	src="$i"
	firstname=$((count + 1))${alpha:$count:1}
	lastname=$(echo $i | cut -d"." -f2)
	dest="$firstname.$lastname"
	mv data/$src data/$dest
	echo "data/$src data/$dest"
	((count++))
done

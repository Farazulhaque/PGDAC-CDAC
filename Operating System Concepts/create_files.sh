#!/bin/bash

read -p "How many files you want to create? " range

i=1
for ((i; i < range + 1; i++)); do
	touch "data/$i.txt"
	echo "data/$i.txt"
done

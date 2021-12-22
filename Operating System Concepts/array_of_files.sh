#!/bin/bash

# create empty array
files=()

# loop in list files ls
for i in $(ls); do
	# add file to files array
	files+=($i)
done

# Getting length of an array
echo ${#files[@]}

# printing array
for i in ${files[@]}; do
	echo $i
done

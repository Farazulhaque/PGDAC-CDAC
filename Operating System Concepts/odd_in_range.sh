#!/bin/bash

read -p "Enter lower range: " lower
read -p "Enter upper range: " upper

echo "Odd numbers between $lower and $upper are: "
for ((lower; lower < upper; lower++)); do
	if [[ $((lower % 2)) -eq 1 ]]; then
		echo $lower
	fi
done

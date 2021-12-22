#!/bin/bash

# 4. Write a script to find the greatest number in three number.

read -p "Enter First Number: " num1
read -p "Enter Second Number: " num2
read -p "Enter Third Number: " num3
if [ $num1 -gt $num2 ] && [ $num1 -gt $num3 ]; then
	echo "$num1 is Biggest number"
elif [ $num2 -gt $num1 ] && [ $num2 -gt $num3 ]; then
	echo "$num2 is Biggest number"
elif [ $num3 -gt $num1 ] && [ $num3 -gt $num2 ]; then
	echo "$num3 is Biggest number"
elif [ $num1 -eq $num2 ] && [ $num1 -eq $num3 ] && [ $num2 -eq $num3 ]; then
	echo "All three numbers are equal"
else
	echo "I can not figure out which number is bigger"
fi

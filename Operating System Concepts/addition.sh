#!/bin/bash

# 1. Write a script which take input from user and calculate the addition.

read -p "Enter First Number: " num1
read -p "Enter Second Number: " num2
sum=$((num1 + num2))
echo "Sum = $sum"

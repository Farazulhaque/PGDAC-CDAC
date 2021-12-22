#!/bin/bash

# 3. Write a script which take input from user and calculate the multiplication.

read -p "Enter First Number: " num1
read -p "Enter Second Number: " num2
product=$((num1 * num2))
echo "Product = $product"

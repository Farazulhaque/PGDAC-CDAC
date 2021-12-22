#!/bin/bash

# 7. Write a script for menu driven calculator (Use if-else-if).

echo "1. Addition"
echo "2. Subtraction"
echo "3. Multiplication"
echo "4. Division"
read -p "Enter your choice: " choice
if [ $choice -eq 1 ]; then
	read -p "Enter First Number: " num1
	read -p "Enter Second Number: " num2
	sum=$((num1 + num2))
	echo "Sum: $sum"
elif [ $choice -eq 2 ]; then
	read -p "Enter First Number: " num1
	read -p "Enter Second Number: " num2
	diff=$((num1 - num2))
	echo "Difference: $diff"
elif [ $choice -eq 3 ]; then
	read -p "Enter First Number: " num1
	read -p "Enter Second Number: " num2
	product=$((num1 * num2))
	echo "Product: $product"
elif [ $choice -eq 4 ]; then
	read -p "Enter First Number: " num1
	read -p "Enter Second Number: " num2
	div=$((num1 / num2))
	echo "Divsion: $div"
else
	echo "Invalid Choice"
fi

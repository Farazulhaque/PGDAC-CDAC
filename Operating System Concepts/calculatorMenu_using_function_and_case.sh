#!/bin/bash

# Function definitions
Addition() {
	num1=$1
	num2=$2
	sum=$((num1 + num2))
	echo "Sum: $sum"
}
Subtraction() {
	num1=$1
	num2=$2
	diff=$((num1 - num2))
	echo "Difference: $diff"
}
Multiplication() {
	num1=$1
	num2=$2
	product=$((num1 * num2))
	echo "Product: $product"
}
Division() {
	num1=$1
	num2=$2
	div=$((num1 / num2))
	echo "Divsion: $div"
}

# Loop Menu
while true; do
	echo "---------------------------"
	echo "1. Addition"
	echo "2. Subtraction"
	echo "3. Multiplication"
	echo "4. Division"
	echo "5. Exit"
	read -p "Enter your choice: " choice

	# exit without proceeding further
	if [[ $choice -eq 5 ]]; then
		echo "Exiting..."
		exit
	fi

	# continue keyword exit only current loop
	# if invalid choice is entered
	if [[ $choice -gt 5 ]] || [[ $choice -lt 0 ]]; then
		echo "Invalid choice"
		continue
	fi

	# getting input in same line
	read -p "Enter first number: " a
	read -p "Enter second number: " b

	# case to call functions
	case $choice in
	"1")
		Addition $a $b
		;;

	"2")
		Subtraction $a $b
		;;

	"3")
		Multiplication $a $b
		;;

	"4")
		Division $a $b
		;;

	*)
		echo "Invalid choice"
		;;

	esac
done

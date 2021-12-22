#!/bin/bash

# create empty array
employees=()

# loop until user enter E/e to exit
while true; do
	echo
	echo "Enter A/a to add employee name"
	echo "Enter D/d to delete employee name"
	echo "Enter P/p to print employee name"
	echo "Enter S/s to search employee name"
	echo "Enter E/e to exit."
	# get user input
	read -p "Enter your choice: " choice

	# check in case
	case $choice in
	# if add
	"A" | "a")
		read -p "Enter employee name to add: " emp
		employees+=($emp)
		;;

		# if delete
	"D" | "d")
		read -p "Enter employee name to delete: " emp
		employeeFound="false"
		# get length of array
		n=${#employees[@]}
		# subtract 1 because indexing starts from 0
		((n--))
		# loop from 0 to n-1
		for i in $(seq 0 $n); do
			# compare each array element with inputted employee name
			if [[ "${employees[$i]}" == "$emp" ]]; then
				# if found then delete it
				unset employees[$i]
				# and set employeeFound to true
				employeeFound="true"
				echo "Employee $emp deleted.."
			fi
		done
		# if employee name is not found in the array
		if [[ "$employeeFound" == "false" ]]; then
			echo "Employee $emp not found!!"
		fi
		;;

		# if print
	"P" | "p")
		# ${employees[@]} contains all array elements separated by space
		for i in ${employees[@]}; do
			echo $i
		done
		;;

		# if search
	"S" | "s")
		read -p "Enter employee name to search: " emp
		employeeFound=false
		# get length of array
		n=${#employees[@]}
		# subtract 1 because indexing starts from 0
		((n--))
		# loop from 0 to n-1
		for i in $(seq 0 $n); do
			# compare each array element with inputted employee name
			if [[ "${employees[$i]}" == "$emp" ]]; then
				# if employee found the set employeeFound to true and
				# print appropriate message
				employeeFound="true"
				echo "Employee $emp found.."
			fi
		done
		# if employee name is not found in the array
		if [[ "$employeeFound" == "false" ]]; then
			echo "Employee $emp not found!!"
		fi
		;;

		# if exit
	"E" | "e")
		# exit is command to exit program
		exit
		;;

	# if invalid input
	*)
		echo "Invalid choice..."
		;;

	esac

done

#!/bin/bash

# 6. Write a script to find the given file is readable, writable and executable or not.

read -p "Enter Filename or path: " file
if [[ -f $file ]]; then
	if [[ -r $file ]] && [[ -w $file ]] && [[ -x $file ]]; then
		echo "$file have read, write and executable permission"
	else
		echo "$file don't have read, write and executable permission"
	fi
fi

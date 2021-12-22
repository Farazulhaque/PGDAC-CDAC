# getting user input
read -p "Enter number: " num

# initialising variables
i=2
flag=0
# loop until i is less than number
while ((i < num)); do
	# if any number is perfectly divisible by any
	# number then it evaluates to 0
	# so if 0 then flag = 1
	if [[ $((num % i)) = 0 ]]; then
		flag=1
	fi
	# increment i on each iteration
	((i++))
done

# check the value of flag variable
# if flag is still 0 then
# number is prime number
if [[ $flag -eq 0 ]]; then
	echo "$num is prime number"
else
	echo "$num is not prime number"
fi

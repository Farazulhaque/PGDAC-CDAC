// 5. Write a code which accepts a sequence of comma seperated five numbers and find the addition of all of them
function find_sum(nums) {
    var num_arr = nums.split(",")
    var sum = 0;
    for (var i = 0; i < num_arr.length; i++) {
        sum = sum + parseInt(num_arr[i])
    }

    document.write(sum);
}

nums = prompt("Enter numbers separated by comma");
find_sum(nums)
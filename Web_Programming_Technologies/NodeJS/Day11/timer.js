//here passed function will execute for infinite time every 2000ms=2s
// setInterval(function(){
//     console.log("Hi");
//},2000)

//here setTimeout will execute it only one time after 5000ms = 5s
// setTimeout(()=>{
//     console.log("This is Timeout function")
// },5000)

var timeout_func = setTimeout(() => {
    clearInterval(interval_func)
}, 5000);

var interval_func = setInterval(() => {
    console.log("Hi")
}, 1000);



// setTimeout(() => {
//     clearTimeout(timeout_func)    
// }, 2000);
let promise = new Promise(function (resolve, reject) {
    setTimeout(() => {
        resolve("Executing after 4000ms")
    }, 4000)
})

promise
    .then(function (data) {
        console.log(data)
    })
    .catch(function (err) {
        console.log(err)
    })

console.log("Hi")
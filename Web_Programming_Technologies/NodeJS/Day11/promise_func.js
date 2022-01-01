var n = "sid"

var promise = new Promise(function (resolve, reject) {
    if (n == "sid") {
        resolve("Successfully resolved the promise")
    } else {
        reject("Fail to resolved the promise")
    }
}) // creating instance of promise

promise
    .then(function (data) {
        console.log("Data: " + data)
    })
    .catch(function (err) {
        console.log("Error:" + err)
    })

// async function operation(){
//     var x = await promise;
// }
// operation()
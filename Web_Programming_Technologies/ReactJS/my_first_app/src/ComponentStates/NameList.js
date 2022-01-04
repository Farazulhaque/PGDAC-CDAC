import { useState } from 'react';

// function NameList(){

// 	var [name,setName] = useState("Siddhant")

// 	var handleChange = function(event){
// 		var data = event.target.value;
// 		//name = data;// because this will not re-render the Component
// 		setName(data) // use the State function to re-render
// 	}

// 	return(	<div>
// 				<input type="text" name="username" placeholder="Enter username" onChange={handleChange}/>
// 				<hr/>
// 				<p>{name}</p>
// 			</div>
// 		)
// }



function NameList() {

	var [names, setNames] = useState(["Siddhant", "Anubhav"])

	var handleBlur = function (event) {
		var data = event.target.value; //Siddhant
		//setNames(data) //names= data
		setNames([...names, data])
	}

	return (
		<div>
			<input type="text" name="username" placeholder="Enter username" onBlur={handleBlur} />
			<hr />
			<ol>
				{names.map((element) => {
					return <li>{element}</li>
				})}
			</ol>
		</div>
	)
}


export default NameList;












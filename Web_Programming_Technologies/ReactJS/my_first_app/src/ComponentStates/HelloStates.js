import { useState } from 'react' // importing useState from react module

function HelloStates() {

	//var [stateVariable setStateFunction] = useState(Default_value_of_state)
	var [name, setNames] = useState("Sid") // here useState function is creating state

	return (
		<div>
			{name}
		</div>
	)
}
export default HelloStates;
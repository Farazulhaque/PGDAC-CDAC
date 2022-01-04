function EventHandling() {


	var handleSubmit = function (event) {
		event.preventDefault(); // stopping the default action of form	
		var name = event.target.username.value // fetching value of name attribute value username
		console.log(name);
	}

	return (
		<div>``
			<form onSubmit={handleSubmit} >
				<input type="text" name="username" placeholder="Enter name" />
				<button>Submit</button>
			</form>
		</div>
	)
}
export default EventHandling;
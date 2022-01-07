function AddFruit(){


	var handleSubmit = function(event){
		event.preventDefault();
		var fruit = {
			fruitName : event.target.fruitName.value,
			rate : event.target.rate.value,
			stock : event.target.stock.value
		}

		console.log(fruit);
		fetch("/addFruit",{
			method : 'POST',
			mode : 'cors',
			headers : {
				'Content-Type' : "application/json"
			},
			body : JSON.stringify(fruit)

		}).then(response => response.json())
		  .then(data => {console.log(data)})

	}



	return(
		<div className="container-fluid">
			<div className="row justify-content-center">
				<div className="col-7 p-5">
					<form onSubmit={handleSubmit}>
						<div className="mb-3">
							<input type="text" name="fruitName" className="form-control" placeholder="Enter fruit Name"/>
						</div>	
						<div className="mb-3">
							<input type="text" name="rate" className="form-control" placeholder="Enter fruit rate"/>
						</div>	
						<div className="mb-3">
							<input type="text" name="stock" className="form-control" placeholder="Enter fruit stock quantity(in kg)"/>
						</div>	
						<div className="mb-3 text-center">
							<button className="btn btn-primary">Add Fruit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		)
}
export default AddFruit;
function Cart(props){
	return(
			
		<div className="container-fluid">
			<div className="row justify-content-center">
				<div className="col-12 p-5">
					<table className="table table-striped table-hover">
						<thead>
								<tr>
									<th>Fruit Name</th>
									<th>Rate/kg</th>
								</tr>	
						</thead>
						<tbody>
							{props.cart.map((item) =>{
								return <tr key={item.fruitId}>
											<td>{item.fruitName}</td>
											<td>{item.rate}</td>
										</tr>
							})}
						</tbody>
					</table>
				</div>
			</div>	
		</div>
	
		)

}

export default Cart

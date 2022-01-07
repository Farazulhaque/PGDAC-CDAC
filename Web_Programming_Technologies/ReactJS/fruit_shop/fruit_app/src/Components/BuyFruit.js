import {useState,useEffect} from 'react'
import AddToCart from './AddToCart'
function BuyFruit(props){

	var [fruits,setFruits] = useState([])
	useEffect(() =>{
		fetch("/fetchFruit",{
		method : "POST",
		mode : "cors",
		}).then(response => response.json())
		.then(data => {setFruits(data)})
		.catch(err =>{console.log(err)})

	},[])
	

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
							{fruits.map((item) =>{
								return <tr key={item.fruitId}>
											<td>{item.fruitName}</td>
											<td>{item.rate}</td>
											<td><AddToCart addNewItemCart={props.addNewItemCart} fruit={item}/></td>
										</tr>
							})}
						</tbody>
					</table>
				</div>
			</div>	
		</div>
		)
}
export default BuyFruit;
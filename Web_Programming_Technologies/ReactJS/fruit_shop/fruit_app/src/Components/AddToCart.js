import {useState} from 'react';

function AddToCart(props){
	
	
	var handleClick = function(){
		props.addNewItemCart(props.fruit)
	}

	return(
			<div>
				<button onClick={handleClick} className="btn btn-outline-primary"> Add To cart</button>
			</div>
		)
}
export default AddToCart;
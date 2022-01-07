import AddFruit from './AddFruit'
import BuyFruit from './BuyFruit'
import Cart from './Cart';
import {useState} from 'react';

function Home(){
	var addNewItemCart = function(item){
		setCart([...cart,item])
	}
	
	var [cart,setCart] = useState([])
	var [showComponent,setShowComponent] = useState(<BuyFruit addNewItemCart={addNewItemCart}/>)

	var showBuyFruit = function(){
		setShowComponent(<BuyFruit addNewItemCart={addNewItemCart}/>)
	}
	var showAddFruit = function(){
		setShowComponent(<AddFruit/>)
	}
	var showCart = function(){
		setShowComponent(<Cart cart={cart}/>)
	}
	return(
		<div className="container-fluid">
			<div className="row">
				<div className="col-3 sidePanel">
				{/*Side panel Nav*/}
					<ul class="nav flex-column">
					  <li class="nav-item">
					    <div class="nav-link active" onClick={showBuyFruit}>Buy Fruits</div>
					  </li>
					  <li class="nav-item">
					    <div class="nav-link active" onClick={showAddFruit} >Add Fruits</div>
					  </li>
					  <li class="nav-item">
					    <div class="nav-link active" onClick={showCart} >Cart</div>
					  </li>
					</ul>
				</div>
				<div className="col-9">
						{showComponent}
				</div>
			</div>
		</div>
		)
}

export default Home;
import { NameContext } from './Context'
import { useContext } from 'react'

function Data(props) {

    var [name, setName] = useContext(NameContext)

    return (
        <div>
            <hr />
            <h1>THis is data component</h1>
            <p>{name}</p>

            {/*<NameContext.Consumer>
					{ value => <h4>{value}</h4>}
				</NameContext.Consumer>*/}

        </div>
    )
}
export default Data;
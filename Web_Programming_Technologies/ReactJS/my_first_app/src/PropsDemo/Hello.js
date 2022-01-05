import Data from "./Data";
import {useState} from 'react'

function Hello() {
    var [name, setName] = useState("Faraz")
    return (
        <div>
            <h1>This is Hello Component</h1>
            <Data x={name} />
            {/* <Data>{name}</Data> */}
        </div>
    )
}
export default Hello;
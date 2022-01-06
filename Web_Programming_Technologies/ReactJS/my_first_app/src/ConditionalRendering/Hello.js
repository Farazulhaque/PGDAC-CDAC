import { useState } from 'react';
import Data from './Data'

function Hello() {
    var [showBtn, setShowBtn] = useState(false)
    var handleClick = function () {
        setShowBtn(!showBtn)
    }
    return (
        <div>
            <h1>This is Hello Component</h1>
            <button onClick={handleClick}>Toggle Data</button>
            {showBtn ? <Data /> : <p>Click on button to show data</p>}
        </div>
    )
}
export default Hello;
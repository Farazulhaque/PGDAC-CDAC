import { useState } from 'react';
import Data from './Data'
import { NameContext } from './Context'

function Hello() {

    var [name, setName] = useState("Arisha")
    var xyz = "Faraz"

    return (
        <div>
            <h1>This is Hello component</h1>
            <NameContext.Provider value={[name, setName]}>
                <Data />
            </NameContext.Provider>
        </div>
    )
}
export default Hello;
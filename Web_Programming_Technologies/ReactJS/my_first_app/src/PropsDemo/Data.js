function Data(props) {
    return (
        <div>
            <hr />
            <h1>This is Data Component</h1>
            <p>{props.x}</p>
            {/* <p>{props.children}</p> */}
        </div>
    )
}
export default Data;
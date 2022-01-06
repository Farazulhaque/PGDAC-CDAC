import Row from './Row'
function TableRow(props) {
    return (
        <tbody>
            {props.x.map((element) => {
                return <Row y={element.movieName} data={element} />
            })}
        </tbody>
    )
}

export default TableRow;
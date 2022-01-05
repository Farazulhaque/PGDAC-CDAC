function TableRow(props) {
    return (
        <tbody>
            {props.series.map((element) => {
                return <tr>
                    <td>{element.seriesId}</td>
                    <td>{element.seriesName}</td>
                    <td>{element.actors}</td>
                    <td>{element.genre}</td>
                    <td>{element.releaseDate}</td>
                    <td>{element.episodes}</td>
                </tr>
            })}
        </tbody>
    )
}

export default TableRow;
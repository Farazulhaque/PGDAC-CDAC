function TableRow(props) {
    return (
        <tbody>
            {props.x.map((element) => {
                return <tr>
                    <td>{element.movieId}</td>
                    <td>{element.movieName}</td>
                    <td>{element.actors}</td>
                    <td>{element.genre}</td>
                    <td>{element.releaseDate}</td>
                </tr>
            })}
        </tbody>
    )
}

export default TableRow;
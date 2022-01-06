function Row(props) {

    var handleClick = function () {
        console.log(props.y)
    }
    return (
        <tr onClick={handleClick}>
            <td>{props.data.movieId}</td>
            <td>{props.data.movieName}</td>
            <td>{props.data.actors}</td>
            <td>{props.data.genre}</td>
            <td>{props.data.releaseDate}</td>
        </tr>
    )
}
export default Row;
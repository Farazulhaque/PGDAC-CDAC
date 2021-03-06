import { MovieContext } from './Context'

function TableRow() {
    return (
        <tbody>
            <MovieContext.Consumer>
                {value => value.map((element) => {
                    return <tr>
                        <td>{element.movieId}</td>
                        <td>{element.movieName}</td>
                        <td>{element.actors}</td>
                        <td>{element.genre}</td>
                        <td>{element.releaseDate}</td>
                    </tr>
                })}
            </MovieContext.Consumer>
        </tbody>
    )
}

export default TableRow;
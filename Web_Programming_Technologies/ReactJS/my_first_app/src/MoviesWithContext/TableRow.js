import { MovieContext } from './Context'
function TableRow(props) {

    return (
        <tbody>
            <MovieContext.Consumer>
                {value => value.map((element) => {
                    return <tr>
                        <td>{element.movieName}</td>
                        <td>{element.actors}</td>
                        <td>{element.releaseDate}</td>
                    </tr>
                })}
            </MovieContext.Consumer>
        </tbody>
    )
}
export default TableRow;
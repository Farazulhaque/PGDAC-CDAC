import { SeriesContext } from './Context'

function TableRow() {
    return (
        <tbody>
            <SeriesContext.Consumer>
                {value => value.map((element) => {
                    return <tr>
                        <td>{element.seriesId}</td>
                        <td>{element.seriesName}</td>
                        <td>{element.actors}</td>
                        <td>{element.genre}</td>
                        <td>{element.releaseDate}</td>
                        <td>{element.episodes}</td>
                    </tr>
                })}
            </SeriesContext.Consumer>
        </tbody>
    )
}

export default TableRow;
import TableRow from './TableRow'
function MovieTable() {

    return (
        <div>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Movie Name</th>
                        <th>Movie Actors</th>
                        <th>release</th>
                    </tr>
                </thead>
                <TableRow />
            </table>
        </div>
    )
}
export default MovieTable;
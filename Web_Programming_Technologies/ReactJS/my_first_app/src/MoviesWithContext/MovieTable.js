import TableRow from "./TableRow";

function MovieTable() {
    return (
        <table className="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actors</th>
                    <th>Genre</th>
                    <th>Release Date</th>
                </tr>
            </thead>
            <TableRow />
        </table>

    )
}

export default MovieTable;
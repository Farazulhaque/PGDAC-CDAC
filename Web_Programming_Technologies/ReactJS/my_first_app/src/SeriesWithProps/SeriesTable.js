import TableRow from "./TableRow";

function SeriesTable(props) {
    return (
        <table className="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actors</th>
                    <th>Genre</th>
                    <th>Release Date</th>
                    <th>No. of Episodes</th>
                </tr>
            </thead>
            <TableRow series={props.data} />
        </table>
    )
}

export default SeriesTable;
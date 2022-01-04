import { useState } from 'react'
import './Movies.css'

function Movies() {

	var [movies, setMovies] = useState([])

	var handleSubmit = function (event) {
		event.preventDefault()
		var mid = event.target.movieId.value
		var mn = event.target.movieName.value
		var a = event.target.actors.value
		var g = event.target.genre.value
		var rd = event.target.releaseDate.value
		var temp = {
			movieId: mid,
			movieName: mn,
			actors: a,
			genre: g,
			releaseDate: rd
		}

		setMovies([...movies, temp])

	}

	return (
		<div className="container-fluid">
			<div className="row">
				<div className="col-4 p-5 border-end border-dark">
					<form onSubmit={handleSubmit}>
						<div className="mb-3">
							<input type="text" className="form-control" name="movieId" placeholder="Enter Movie Id" />
						</div>
						<div className="mb-3">
							<input type="text" className="form-control" name="movieName" placeholder="Enter Movie Name" />
						</div>
						<div className="mb-3">
							<input type="text" className="form-control" name="actors" placeholder="Enter Actors" />
						</div>
						<div className="mb-3">
							<input type="text" className="form-control" name="genre" placeholder="Enter Genre" />
						</div>
						<div className="mb-3">
							<input type="date" className="form-control" name="releaseDate" placeholder="Enter Release date" />
						</div>
						<div className="mb-3 text-center">
							<button className="btn btn-primary"> Add Movie</button>
						</div>
					</form>
				</div>
				<div class="col-8 p-5">
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
						<tbody>
							{movies.map((element) => {
								return <tr>
									<td>{element.movieId}</td>
									<td>{element.movieName}</td>
									<td>{element.actors}</td>
									<td>{element.genre}</td>
									<td>{element.releaseDate}</td>
								</tr>
							})}
						</tbody>
					</table>
				</div>
			</div>
		</div>
	)
}

export default Movies;
import MovieTable from './MovieTable';
import { useState } from 'react';
import { MovieContext } from './Context';

function MovieForm() {
    var [movies, setMovies] = useState([])

    var handleSubmit = function (event) {
        event.preventDefault()
        var temp = {
            movieName: event.target.movieName.value,
            actors: event.target.actors.value,
            releaseDate: event.target.releaseDate.value
        }
        setMovies([...movies, temp])
    }

    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-4 p-5 border-end border-primary">
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="movieName" placeholder="Enter movie" />
                        </div>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="actors" placeholder="Enter actors" />
                        </div>
                        <div className="mb-3">
                            <input type="date" className="form-control" name="releaseDate" placeholder="Enter release Date" />
                        </div>
                        <div className="mb-3 text-center">
                            <button className="btn btn-primary"> Add Movie</button>
                        </div>
                    </form>
                </div>
                <div className="col-8">
                    <MovieContext.Provider value={movies}>
                        <MovieTable />
                    </MovieContext.Provider>
                </div>
            </div>
        </div>

    )
}
export default MovieForm;
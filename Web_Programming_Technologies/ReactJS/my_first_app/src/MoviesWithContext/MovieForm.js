import { useState } from 'react'
import MovieTable from "./MovieTable"
import { MovieContext } from './Context';

function MovieForm() {
    var [movies, setMovies] = useState([])
    var [idError, setIdError] = useState("")
    var [nameError, setNameError] = useState("")
    var [actorError, setActorError] = useState("")
    var [genreError, setGenreError] = useState("")
    var [releaseDateError, setreleaseDateError] = useState("")


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

    var validateId = function (event) {
        var mid = event.target.value
        if (isNaN(mid) || !mid) {
            setIdError("Invalid Id")
        }
        else {
            setIdError("")
        }
    }
    var validateName = function (event) {
        var mname = event.target.value
        if (!mname) {
            setNameError("Please Enter Movie Name")
        }
        else {
            setNameError("")
        }
    }
    var validateActor = function (event) {
        var act = event.target.value
        if (!act) {
            setActorError("Please Enter Actor Name")
        } else {
            setActorError("")
        }
    }
    var validateGenre = function (event) {
        var gen = event.target.value
        if (!gen) {
            setGenreError("Please Enter Genre")
        } else {
            setGenreError("")
        }
    }
    var validateReleaseDate = function (event) {
        var rd = event.target.value
        console.log(rd)
        if (!rd) {
            setreleaseDateError("Please Enter Valid Date")
        } else {
            setreleaseDateError("")
        }
    }
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-4 p-5 border-end border-dark">
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="movieId" placeholder="Enter Movie Id" onBlur={validateId} />
                            <span>{idError}</span>
                        </div>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="movieName" placeholder="Enter Movie Name" onBlur={validateName} />
                            <span>{nameError}</span>
                        </div>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="actors" placeholder="Enter Actors" onBlur={validateActor} />
                            <span>{actorError}</span>
                        </div>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="genre" placeholder="Enter Genre" onBlur={validateGenre} />
                            <span>{genreError}</span>
                        </div>
                        <div className="mb-3">
                            <input type="date" className="form-control" name="releaseDate" placeholder="Enter Release date" onBlur={validateReleaseDate} />
                            <span>{releaseDateError}</span>
                        </div>
                        <div className="mb-3 text-center">
                            <button className="btn btn-primary"> Add Movie</button>
                        </div>
                    </form>
                </div>
                <div class="col-8 p-5">
                    <MovieContext.Provider value={movies}>
                        <MovieTable />
                    </MovieContext.Provider>
                </div>
            </div>
        </div>
    )

}

export default MovieForm;
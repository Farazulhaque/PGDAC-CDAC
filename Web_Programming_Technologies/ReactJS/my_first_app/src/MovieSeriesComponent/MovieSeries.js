import MovieForm from '../MoviesWithContext/MovieForm'
import SeriesForm from '../SeriesWithContext/SeriesForm'
import { useState } from 'react';


function MovieSeries() {
    var [btn, setBtn] = useState("")
    var handleClick = function (event) {
        if (event.target.value == "Show Movies") {
            setBtn("Show Movies")
        }
        else {
            setBtn("Show Series")
        }
    }


    return (
        <div className="m-5 text-center">
            <input type="button" className="btn btn-primary" onClick={handleClick} value="Show Movies" />
            &nbsp;
            <input type="button" className="btn btn-primary" onClick={handleClick} value="Show Series" />
            {btn == "Show Movies" ? <MovieForm /> : btn == "Show Series" ? <SeriesForm /> : ""}
        </div>
    )
}

export default MovieSeries
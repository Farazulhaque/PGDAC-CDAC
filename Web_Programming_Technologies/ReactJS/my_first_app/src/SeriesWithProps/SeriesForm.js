import { useState } from 'react'
import SeriesTable from './SeriesTable'


function SeriesForm() {
    var [series, setSeries] = useState([])
    var handleSubmit = function (event) {
        event.preventDefault()
        var sid = event.target.seriesId.value
        var sname = event.target.seriesName.value
        var act = event.target.actors.value
        var gen = event.target.genre.value
        var rd = event.target.releaseDate.value
        var ep = event.target.episodes.value
        var data = {
            seriesId: sid,
            seriesName: sname,
            actors: act,
            genre: gen,
            releaseDate: rd,
            episodes: ep
        }
        setSeries([...series, data]
        )
    }
    return (
        < div className="container-fluid" >
            <div className="row">
                <div className="col-4 p-5 border-end border-dark">
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="seriesId" placeholder="Enter Series Id" />
                        </div>
                        <div className="mb-3">
                            <input type="text" className="form-control" name="seriesName" placeholder="Enter Series Name" />
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
                        <div className="mb-3">
                            <input type="number" className="form-control" name="episodes" placeholder="Enter No. of Episodes" />
                        </div>
                        <div className="mb-3 text-center">
                            <button className="btn btn-primary"> Add Series</button>
                        </div>
                    </form>
                </div>
                <div class="col-8 p-5">
                    <SeriesTable data={series} />
                </div>
            </div>
        </div >
    )
}

export default SeriesForm;
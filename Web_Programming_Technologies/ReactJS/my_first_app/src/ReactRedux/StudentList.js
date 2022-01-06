import Store from './Store'
import { connect } from 'react-redux'

function StudentList(props) {

    return (
        <div>
            <hr />
            <h5>This is StudentList Componenets</h5>
            {props.studentData.map((item) => {
                return <li>{item}</li>
            })}
        </div>
    )
}
// export default StudentList;

const mapStateToProps = (state) => {
    return { studentData: state };
}
export default connect(mapStateToProps)(StudentList)
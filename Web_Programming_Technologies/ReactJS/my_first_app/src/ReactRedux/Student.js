import StudentList from "./StudentList"
import { useState } from "react";
import Store from './Store';

function Student() {

    // var [students, setStudents] = useState([])
    var addStudent = function (e) {
        var name = e.target.value
        Store.dispatch({
            type: "ADD_STUDENT",
            payload: name
        })
        // setStudents([...students, name])
    }
    
    return (
        <div>
            <input type="text" name="student" placeholder="Enter Student Name" onBlur={addStudent} />
            <StudentList />
        </div>
    )
}
export default Student;
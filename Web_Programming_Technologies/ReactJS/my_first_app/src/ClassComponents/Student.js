import { Component } from 'react'

class Student extends Component {
    constructor(props) {
        super(props)
        this.state = {
            students: []
        }
    }

    addStudent = (event) => {
        var name = event.target.value;

        this.setState({
            students: [...this.state.students, name]
        })

    }

    render() {
        return (
            <div>
                <h3>THis is Student Component</h3>
                <input type="text" name="studentName" className="form-control" placeholder="Enter Name" onBlur={this.addStudent} />
                <h6>Student List: </h6>
                <ol>
                    {this.state.students.map((item) => {
                        return <li>{item}</li>
                    })}
                </ol>
            </div>
        )
    }
}

export default Student;
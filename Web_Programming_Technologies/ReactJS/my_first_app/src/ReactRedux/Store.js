import { createStore } from "redux";

const StudentReducer = (state = [], action) => {
    switch (action.type) {
        case "ADD_STUDENT":
            return [...state, action.payload]

        default:
            return state
    }
}
var Store = createStore(StudentReducer);
export default Store
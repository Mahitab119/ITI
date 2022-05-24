import { Component } from "react";
import "./component.css";

class Text extends Component {

    constructor() {
        super();
        this.state = {
            userName: "Mahitab"
        }
    }
    render() {
        return (
            <div class="container">
                <input type="text" 
                style={{}}
                    value={this.state.userName}
                    onChange={(e) => {
                        this.setState({ userName: e.target.value })
                    }}
                />
                    <a href="#" class="start" onClick={ ()=> this.setState({userName :''})}>{"Reset"}</a> 
                {this.state.userName}
            </div>
        )
    }
}

export default Text;
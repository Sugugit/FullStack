import React, { Component } from 'react'
class Action extends React.Component{
    state={buttonAction:""};
    onAdd(){
        this.setState({buttonAction:"Click me was pressed"});
        console.log("Clicked");
    }
    onUpdate(){
        this.setState({buttonAction:"Update was pressed"});
        console.log("Clicked");
    }
render(){
    return(
        <div>
            <p>{this.state.buttonAction}</p>
            <button onClick={()=>this.onAdd()}>Click me</button>
            <button onClick={()=>this.onUpdate()}>Update me</button>

        </div>
    );
}
}

export default Action;
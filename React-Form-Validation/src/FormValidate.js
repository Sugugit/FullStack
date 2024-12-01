import React from 'react'
import { useState } from "react"


function FormValidation(){
    const[value,setValue] =useState({username:'',password:''});

    const handleInput=(event)=>{

        let name=event.target.name;
        let val=event.target.value;

        setValue({...value,[name]:val});
        
    }
    const onSubmit =()=>{
        if(value.username.length<=8){
            alert("Username Not Valid");
        }
        if(value.password.length<=8){
            alert("Password Not Valid");
        }
        
    }
    return{
        value,
        handleInput,
        onSubmit
    }
}

export default FormValidation;
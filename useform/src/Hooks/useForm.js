import React,{ useState } from 'react'
import {omit} from 'lodash'
const useForm = () =>{

const[values,setValues]=useState({});
const [errors,setErrors]=useState({});

const handleChange=(event)=>{
    event.persist();

    let name=event.target.name;
    let val=event.target.value;
    
    validate(event.name,val);

    setValues({
        ...values,
        [name]:val,
    })
}
const validate=(event,name,value)=>{

    // eslint-disable-next-line default-case
    switch(name)
    {
        case 'username':
            if(value.length < 8){
                setErrors(
                    {
                        ...errors,
                        username:'Username must be 9 char'
                    }
                )
            }
            else{
                let newObj =omit(errors,"username");
                setErrors(newObj);
            }
            // eslint-disable-next-line no-fallthrough
            case 'password':
                if(!new RegExp(/^(?=.*?[A-Z]) (?=.*?[A-Z]) (?=.*?[0-9]).{8,}$/).test(value)){
                    setErrors({
                        ...errors,
                        password:'Password be 8'
                    })
                    }
                    else{
                        let newObj =omit(errors,"password");
                        setErrors(newObj);
                    }
    }
}

    return{values,errors,handleChange,};
}

export default useForm;
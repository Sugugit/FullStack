import React, { Component, useState } from 'react'
function Actionfun (){
    let [a,b,c]=[1,2,3];
    console.log(a)
    const state=useState(10);
    console.log(state)
    const [count,setCount]=useState(0);

    return(
        <div>

            <p>{count}</p>
        <button onClick={()=>setCount(count+1)}>button</button>
        </div>
    );
}
export default Actionfun;
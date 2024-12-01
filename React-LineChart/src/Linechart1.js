import React, { Component } from 'react'
import { LineChart,Line ,YAxis,XAxis,CartesianGrid,Tooltip,Legend } from 'recharts';
class Linechart1 extends React.Component{
    data=[
        {
            "name":"jan22","apple":"100","mango":"200"
        },
        {
            "name":"feb22","apple":"200","mango":"250"
        },
        {
            "name":"mar22","apple":"50","mango":"300"
        },
       
    ]
    render(){
        return(
            <div>
                Line Chart
                <LineChart width={700} height={250} data={this.data} margin={{top:5,right:30,left:20,bottom:5}}>
                   <XAxis dataKey = "name"/>
                   <CartesianGrid strokeDasharray='3 3'/>
                   <YAxis/>
                   <Tooltip/>
                   <legend/>
                   <Line type={'monotone'} dataKey="apple" stroke='red'/>
                   <Line type={'monotone'} dataKey="mango" stroke='blue'/>
                    </LineChart>
            </div>
        );
    }
}
export default Linechart1;
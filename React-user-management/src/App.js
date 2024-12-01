import React from 'react';
import './App.css';

function App() {

  function handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);
    fetch("http://localhost:8080/User_Manage/login?uname="+data.get("uname")+"&pwd="+data.get("pwd"), { crossDomain: true })
      .then((resp) => resp.json())
      .then((data) => {
        if (data.status === "success") {
          alert("Login Success");
        } else {
          alert("Login Failed");
        }
      })

  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <div className='form-group'>
            <label>Username</label>
            <input name='uname' type="text" className='form-control' placeholder='Enter Username'></input>
          </div>

          <div className='form-group'>
            <label>Password</label>
            <input name='pwd' type="password" className='form-control' placeholder='Enter Password'></input>
          </div>

          <button type='submit'>Submit</button>
        </div>
      </form>
    </div>
  );
}

export default App;

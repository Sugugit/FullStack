import './App.css';
import useForm from './Hooks/useForm';
function App() {
       const {handleChange,values,errors}=useForm();
       console.log(values);
       console.log(errors);
  return (
    <div className="App">
      <form>
<input type='Email' name='email' placeholder='email'onChange={handleChange}></input><br/>
<input type='passwrod' name='password' placeholder='passwrd' onChange={handleChange}></input><br/>
{errors.password &&<h3>{errors.password}</h3>}
<input type='text' name='username' placeholder='username' onChange={handleChange}></input><br/>
{errors.username &&<h3>{errors.username}</h3>}
<input type='Submit' className='submit'></input>
      </form>
    </div>
  );
}

export default App;


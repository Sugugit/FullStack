import logo from './logo.svg';
import './App.css';
import FormValidation from './FormValidate';

function App() {
  const {value,handleInput,onSubmit}=FormValidation();
  return (
    <div className="App">
      <input type='text' name="username" onChange={handleInput}></input>
      <input type='password' name="password" onChange={handleInput}></input>
      <button onClick={onSubmit}>Submit</button>
    </div>
  );
}

export default App;

import Test from './Test';
import './App.css';

function App() {

  const handleSubmit=(event)=>{
    alert("test");
  }
  return (
    <div className="App">
        Welcome
        <h1>hello world</h1>
        <Test/>
        <form onSubmit={handleSubmit}>
          <lsbel>Enter your name</lsbel>
          <input type="text" value="text">
          </input>
          <input type='submit'></input>
        </form>
    </div>
  );
}

export default App;

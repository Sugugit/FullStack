/* eslint-disable react/jsx-no-undef */
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router,Route,Link,Routes } from 'react-router-dom';
import About from './About';
import User from './User';
import Home from './Home';


export default function App() {
  return (
    <Router>
<div>
  <nav>
    <ul>
      <li>
        <Link to="/">Home</Link>
      </li>
      <li>
        <Link to="/about">About</Link>
      </li>
      <li>
        <Link to="/users">Users</Link>
      </li>
    </ul>
  </nav>
  
  <Routes>
    <Route path="/about" element={<About/>}>
  
    </Route>
    <Route path="/users" element={<User/>}>

    </Route> 
    <Route path="/" element={<Home/>}>
    </Route></Routes>
</div>
    </Router>
  );
}


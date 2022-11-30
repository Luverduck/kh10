import './App.css';

//import React, {useState} from 'react'; // React 모듈을 import

import {useState} from 'react'; // React 모듈을 import

const App = props => {
  //const [color, setColor] = React.useState("blakc");
  const [color, setColor] = useState("black");

  return (
    <div className="App">
      <h1 style = {{color : color}}>리액트 프로젝트 데모</h1>
      <button onClick = {() => setColor("red")}>red</button>
      <button onClick = {() => setColor("blue")}>blue</button>
      <button onClick = {() => setColor("green")}>green</button>
    </div>
  );
}

export default App;

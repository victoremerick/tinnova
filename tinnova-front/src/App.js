import './App.css';
import React from 'react';
import Header from "./components/Header/Header"
import Content from "./components/Content/Content"
import Footer from "./components/Footer/Footer"
import List from "./components/List/List"
import VeiculoItemList from './components/VeiculoItemList/VeiculoItemList';
import Home from './page/Home/Home';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Create from './page/Create/Create';
import Detail from './page/Detail/Detail';

class App extends React.Component {

  constructor(props){
    super(props);

    var myInit = { 
      method: 'GET',
      mode: 'cors',
      cache: 'default' 
    };

    fetch("http://localhost:8080/veiculos", myInit)
    .then(response => {
      return response.json();
    })
    .then(data => {
      this.setState({"veiculos":data});
    });

    this.state = {
      veiculos: [],
      filtrou: false
    }

    this.filterVeiculos = this.filterVeiculos.bind(this);
  }

  filterVeiculos(e){
    var myInit = { 
      method: 'GET',
      mode: 'cors',
      cache: 'default' 
    };
    let value = e.target.value;
    if(value.length >= 3){
      fetch("http://localhost:8080/veiculos?q="+value, myInit)
      .then(response => {
        return response.json();
      })
      .then(data => {
        this.setState({"veiculos":data, filtrou: true});
      });
    }else if(this.state.filtrou){
      fetch("http://localhost:8080/veiculos", myInit)
      .then(response => {
        return response.json();
      })
      .then(data => {
        this.setState({"veiculos":data, filtrou: false});
      });
    }
  }

  render(){
    return (
      <Router>
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route path="/create">
            <Create />
          </Route>
          <Route path="/edit/:id">
            <Create />
          </Route>
          <Route path="/detail/:id">
            <Detail />
          </Route>
        </Switch>  
      </Router>
    );
  }
}

export default App;

import './Home.css';
import React from 'react';
import Header from "../../components/Header/Header"
import Content from "../../components/Content/Content"
import Footer from "../../components/Footer/Footer"
import List from "../../components/List/List"
import VeiculoItemList from '../../components/VeiculoItemList/VeiculoItemList';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
class Home extends React.Component {

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
    this.apagar = this.apagar.bind(this);
  }

  apagar(key, id){
    var myInit = { 
      method: 'DELETE',
      mode: 'cors',
      cache: 'default' 
    };
    fetch("http://localhost:8080/veiculos/"+id, myInit)
    .then(response => {
      let test = this.state.veiculos.filter((element, index) => index !== key);
      console.log(test);
      console.log(key);
      if(response.status === 204) this.setState({veiculos: test});
    });
    
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
      <div className="App">
        <Header>
          <input type="text" onChange={this.filterVeiculos} placeholder="Pesquisar veiculos..."></input>
        </Header>
        <Content>
          <h2>Veiculos</h2>
          <Link to="/create">Cadastrar um novo veículo</Link>
          <List>
            {this.state.veiculos.map((veiculo, index) => {
              return <VeiculoItemList key={index} index={index}
                veiculo={veiculo} apagarClick={this.apagar}
              ></VeiculoItemList>
            })}
          </List>
        </Content>
        <Footer>
          <p>Desenvolvido por Victor Emerick.</p>
        </Footer>
      </div>
    );
  }
}

export default Home;

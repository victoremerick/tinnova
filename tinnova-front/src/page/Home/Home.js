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

    let getDecada = function(year) {
        if (Number.isNaN(year) || (year.toString().length < 4) || (year.toString().length > 4)) {
            throw new Error('Date must be valid and have a 4-digit year attribute');
        }
        let start       = Number(`${year.toString()[2]}0`);
        let startIdx    = year.toString().substring(0, 2);
        let end         = 0;
        start           = (start === 0) ? Number(`${startIdx}00`) : Number(`${startIdx}${start}`);
        end             = start + 10;
        return { start: start, end: end };
    }

    let decadas = [];
    let marcas = [];
    let vendido = 0;

    let veiculosLoaded = this.state.veiculos.map((veiculo, index) => {
      let decada = getDecada(veiculo.ano).start.toString()+"d";

      if(decadas[decada]>0){
        decadas[decada]++;
      }else{
        decadas[decada] = 1;
      } 

      if(marcas[veiculo.marca]>0){
        marcas[veiculo.marca]++;
      }else{
        marcas[veiculo.marca] = 1;
      }

      if(!veiculo.vendido) vendido++;

      return <VeiculoItemList key={index} index={index}
        veiculo={veiculo} apagarClick={this.apagar}
      ></VeiculoItemList>
    });

    let decadasTexto = Object.keys(decadas).map(t => {
      return <p>Década {t.replace("d","")+" ->"} {decadas[t]}</p>;
    });

    let marcasTexto = Object.keys(marcas).map(t => {
      return <p>{t+" ->"} {marcas[t]}</p>;
    });

    return (
      <div className="App">
        <Header>
          <input type="text" onChange={this.filterVeiculos} placeholder="Pesquisar veiculos..."></input>
        </Header>
        <Content>
          <h2>Veiculos</h2>
          <Link to="/create">Cadastrar um novo veículo</Link>
          <List>
            {veiculosLoaded}
          </List>
          <h3>Veiculos Vendidos</h3>
          <h3>{vendido}</h3>
          <h3>Distribuição de veículos por década</h3>
          {decadasTexto}
          <h3>Distribuição de veículos por fabricante</h3>
          {marcasTexto}
        </Content>
        <Footer>
          <p>Desenvolvido por Victor Emerick.</p>
        </Footer>
      </div>
    );
  }
}

export default Home;

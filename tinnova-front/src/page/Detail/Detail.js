import './Detail.css';
import React from 'react';
import Header from "../../components/Header/Header"
import Content from "../../components/Content/Content"
import Footer from "../../components/Footer/Footer"
import List from "../../components/List/List"
import VeiculoItemList from '../../components/VeiculoItemList/VeiculoItemList';
import { withRouter } from "react-router";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

class Detail extends React.Component {

  constructor(props){
    super(props);

    this.state = {
      id: "",
      veiculo: "",
      marca: "",
      ano: "",
      descricao: "",
      vendido: "",
      editar: false
    }
  }

  componentDidMount() {
    const id = this.props.match.params.id;
    if(id){
      var myInit = { 
        method: 'GET',
        mode: 'cors',
        cache: 'default' 
      };
      fetch("http://localhost:8080/veiculos/"+id, myInit)
      .then(response => {
        return response.json();
      })
      .then(data => {
        this.setState({
          id: id,
          veiculo: data.veiculo, 
          marca: data.marca, 
          ano: data.ano,
          descricao: data.descricao,
          vendido: data.vendido,
          editar: true});
      });
    }
  }

  render(){
    return (
      <div className="App">
        <Header>
          <Link to="/">Voltar para Página Inicial</Link>
        </Header>
        <Content>
          <h2>{this.state.editar? "Edição" : "Cadastro"} de Veículo</h2>
          <form>
            <div>
              <label for="veiculofield">Veiculo</label>
              <span>{this.state.veiculo}</span>
            </div>
            <div>
              <label for="marcafield">Marca</label>
              <span>{this.state.marca}</span>
            </div>
            <div>
              <label for="anofield">Ano</label>
              <span>{this.state.ano}</span>
            </div>
            <div>
              <label for="vendidofield">Vendido</label>
              <input type="checkbox" id="vendidofield" placeholder="Vendido" editable="false" checked={this.state.vendido}></input>
            </div>
            <div>
              <label for="descricaofield">Descrição</label>
              <span>{this.state.descricao}</span>
            </div>
            <div>
              <div className="button" onClick={() => {this.props.history.push("/edit/"+this.state.id)}}>
                Editar
              </div>
            </div>
          </form>
        </Content>
        <Footer>
          <p>Desenvolvido por Victor Emerick.</p>
        </Footer>
      </div>
    );
  }
}

export default withRouter(Detail);

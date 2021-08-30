import './Create.css';
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

class Create extends React.Component {

  constructor(props){
    super(props);

    this.state = {
      veiculo: "",
      marca: "",
      ano: "",
      descricao: "",
      vendido: "",
      editar: false
    }
    this.salvar = this.salvar.bind(this);
    this.onChangeVeiculo = this.onChangeVeiculo.bind(this);
    this.onChangeMarca = this.onChangeMarca.bind(this);
    this.onChangeAno = this.onChangeAno.bind(this);
    this.onChangeDescricao = this.onChangeDescricao.bind(this);
    this.onChangeVendido = this.onChangeVendido.bind(this);
  }

  onChangeVeiculo(e){
    this.setState({veiculo: e.target.value});
  }

  onChangeMarca(e){
    this.setState({marca: e.target.value});
  }

  onChangeAno(e){
    this.setState({ano: e.target.value});
  }

  onChangeDescricao(e){
    this.setState({descricao: e.target.value});
  }

  onChangeVendido(e){
    this.setState({vendido: e.target.checked});
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
          veiculo: data.veiculo, 
          marca: data.marca, 
          ano: data.ano,
          descricao: data.descricao,
          vendido: data.vendido,
          editar: true});
      });
    }
  }

  salvar(){
    if(this.state.editar){
      const id = this.props.match.params.id;
      var myInit = { 
        method: 'PUT',
        mode: 'cors',
        cache: 'default',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          veiculo: this.state.veiculo,
          marca: this.state.marca,
          ano: this.state.ano,
          descricao: this.state.descricao,
          vendido: this.state.vendido,
        })
      };
      console.log(this.state.vendido);
      fetch("http://localhost:8080/veiculos/"+id, myInit)
      .then(response => {
        if(response.status === 204) {
          this.props.history.push("/");
        }else{
          alert("Dados inválidos, tente novamente.");
        }
      });
    }else{
      var myInit = { 
        method: 'POST',
        mode: 'cors',
        cache: 'default',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          veiculo: this.state.veiculo,
          marca: this.state.marca,
          ano: this.state.ano,
          descricao: this.state.descricao,
          vendido: this.state.vendido,
        })
      };
      fetch("http://localhost:8080/veiculos/", myInit)
      .then(response => {
        console.log(response);
        if(response.status === 201) {
          this.props.history.push("/");
        }else{
          alert("Dados inválidos, tente novamente.");
        }
      })
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
              <input type="text" id="veiculofield" placeholder="Veiculo" onChange={this.onChangeVeiculo} value={this.state.veiculo}></input>
            </div>
            <div>
              <label for="marcafield">Marca</label>
              <input type="text" id="marcafield" placeholder="Marca" onChange={this.onChangeMarca} value={this.state.marca}></input>
            </div>
            <div>
              <label for="anofield">Ano</label>
              <input type="number" id="anofield" placeholder="Ano" onChange={this.onChangeAno} value={this.state.ano}></input>
            </div>
            <div>
              <label for="vendidofield">Vendido</label>
              <input type="checkbox" id="vendidofield" placeholder="Vendido" onChange={this.onChangeVendido} checked={this.state.vendido}></input>
            </div>
            <div>
              <label for="descricaofield">Descrição</label>
              <input type="text" id="descricaofield" placeholder="Descrição" onChange={this.onChangeDescricao} value={this.state.descricao}></input>
            </div>
            <div>
              <div className="button" onClick={this.salvar}>
                {this.state.editar? "Salvar" : "Cadastrar"}
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

export default withRouter(Create);

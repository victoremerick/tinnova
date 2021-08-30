import './VeiculoItemList.css';
import React from 'react';
import { withRouter } from "react-router";

class VeiculoItemList extends React.Component {

  constructor(props){
    super(props);
  }

  render(){
    return (
      <li>
          <span className="veiculo">{this.props.veiculo.marca} {this.props.veiculo.veiculo}</span>
          <span className="ano">{this.props.veiculo.ano}</span>
          <span className="vendido">{this.props.veiculo.vendido?"Vendido":"À Venda"}</span>
          <span className="descricao">{this.props.veiculo.descricao}</span>
          <div className="acoes">
            <span className="acaoeditar" onClick={() => {this.props.history.push("/edit/"+this.props.veiculo.id)}}>Editar</span>
            <span className="acaoapagar" onClick={() => {this.props.apagarClick(this.props.index, this.props.veiculo.id)}}>Apagar</span>
            <span className="acaodetalhar" onClick={() => {this.props.history.push("/detail/"+this.props.veiculo.id)}}>Detalhar</span>
          </div>
      </li>
    );
  }
}

export default withRouter(VeiculoItemList);

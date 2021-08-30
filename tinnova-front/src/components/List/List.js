import './List.css';
import React from 'react';

class List extends React.Component {

  constructor(props){
    super(props);
  }

  render(){
    return (
      <ul>
        {this.props.children}
      </ul>
    );
  }
}

export default List;

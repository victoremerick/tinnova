import './Content.css';
import React from 'react';

class Content extends React.Component {

  constructor(props){
    super(props);
  }

  render(){
    return (
      <section>
        {this.props.children}
      </section>
    );
  }
}

export default Content;

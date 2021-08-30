import './Footer.css';
import React from 'react';

class Footer extends React.Component {

  constructor(props){
    super(props);
  }

  render(){
    return (
      <footer>
        {this.props.children}
      </footer>
    );
  }
}

export default Footer;
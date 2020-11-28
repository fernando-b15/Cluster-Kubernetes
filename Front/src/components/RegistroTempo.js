import React, {Component} from 'react';
import ResponsiveDrawer from './ResponsiveDrawer';
import {Registro} from './Registro';

export class RegistroTempo extends React.Component{
	constructor(props) {
		super(props);
	}
	render(){
		console.log(localStorage.getItem("register"));
		var myComponent = (<Registro messages={JSON.parse(localStorage.getItem("register"))} numero = {JSON.parse(localStorage.getItem("register")).length} />);
		return(
			<ResponsiveDrawer childComponent={myComponent} />
		);
		
	}
}
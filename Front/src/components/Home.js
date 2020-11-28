import React, {Component} from 'react';
import ResponsiveDrawer from './ResponsiveDrawer';
import {Chat} from './Chat';

export class Home extends React.Component{
	constructor(props) {
		super(props);
	}
	render(){	  

		const myComponent = <Chat/>
		return(
			<ResponsiveDrawer childComponent={myComponent}/>
		);
	}
}
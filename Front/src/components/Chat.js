import React, {Component} from 'react';
import ResponsiveDrawer from './ResponsiveDrawer';

export class Chat extends React.Component{
	constructor(props) {
		super(props);
	}
	render(){	  
		const myComponent = (<object id="chat" type="text/html" data={"http://192.168.195.118:6677/arep?nickname="+localStorage.getItem("user")}
                    width="510" height="630">
            </object>);

		return(
			<ResponsiveDrawer childComponent={myComponent}/>
		);
		
	}
}
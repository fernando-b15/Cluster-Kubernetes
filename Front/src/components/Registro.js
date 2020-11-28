import React, {Component} from 'react';
import ResponsiveDrawer from './ResponsiveDrawer';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import ReactDOM from 'react-dom';
import axios from "axios";
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';

export class Registro extends React.Component{
	constructor(props) {
		super(props);
			this.state = {numero: props.numero,messages: props.messages};
			this.handlechangehope = this.handlechangehope.bind(this);
		}
			handlechangehope(e){
				e.preventDefault();
				var nuevos = [];
				axios.post('http://192.168.255.122:8080/registros/save', {
					 numero: this.state.numero+1,
					 message: document.getElementById("idmsg").value
				})
				.then(function (response)
				{
					let	servicesHope = axios.get('http://192.168.255.122:8080/registros/')
					.then(function (response) {
							console.log(response.data);
							nuevos = response.data;
						})
					.catch(function (error) { 
						console.log(error);
					});
					
					

				})
				.catch(function (error)
				{ alert("Error al guaradar registro") });
				setTimeout(function () {
							 console.log(this.state.numero+1);
							 var xyz = this.props.numero+1;
							const beta = document.getElementById("table");
							console.log(beta);
							this.setState({numero: xyz});
							this.setState({messages: nuevos});
							
							
				}.bind(this), 1200);
				  
				
			
		}
	render(){	  

		const useStyles = makeStyles({
		  table: {
			minWidth: 350,
		  },
		});	


		return(
			<div id="root">
			
				<div id="format">
					<span>Message: </span> <div id="delta"> <input id='idmsg'></input><span></span><button type="submit" variant="contained" onClick={this.handlechangehope}  className='btn btn-warning' >New Message</button></div>
				</div>
				<br></br>				
				<div id = "table">	
				<TableContainer component={Paper}>
				  <Table aria-label="simple table">
					<TableHead>
					  <TableRow>
						<TableCell align="right">Numero</TableCell>
						<TableCell align="right">Message</TableCell>
					  </TableRow>
					</TableHead>
					<TableBody>
					  {this.state.messages.map((row) => (
						<TableRow key={row.numero}>
						  <TableCell align="right">{row.numero}</TableCell>
						  <TableCell align="right">{row.message}</TableCell>
						</TableRow>
					  ))}
					</TableBody>
				  </Table>
				</TableContainer>
				</div>	
			</div>	
		);
	}
}
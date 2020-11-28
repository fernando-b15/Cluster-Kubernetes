//Mi direccion ip y el puerto asignado .. forceNew es para que la conexion se fuerce
var socket = io.connect('http://127.0.0.1:6677',{'forceNew':true});
const messageForm = document.getElementById('send-container')
const messageInput = document.getElementById('submit')
const roomContainer = document.getElementById('room-container')
const messageContainer = document.getElementById('message-container');


socket.on('messages', (data) => {
	console.log('xdddddddddddddddddddddd');
    console.log(data);
    render(data);
})


socket.on('room-created', room => {
  const roomElement = document.createElement('div')
  roomElement.innerText = room
  const roomLink = document.createElement('a')
  roomLink.href = `/${room}`
  roomLink.innerText = 'join'
})

//Pintar mensaje en el HTML
function render(data){
    //Recorrer info en map y hacer lo que se quiera
    var html = data.map(function (message, index) {
        //para que cada vez de cree el mensaje
		if (message.text !== 'online' && message.text !== '' ){
			return (`
				<div class="message">
					<strong>${message.nickname}</strong> dice:
					<p>${message.text}</p>
				</div>
			`);
		}
    }).join(' ');
    var div_msgs = document.getElementById('messages');
    div_msgs.innerHTML = html;
    //Para que cuando haya un mensaje, este sea el foco, osea que se centre
    div_msgs.scrollTop = div_msgs.scrollHeight;
}



function addMessage(e) {
    var message = {
        nickname: document.getElementById('nickname').value,
        text: document.getElementById('text').value
    };
    //Para que no se pueda cambiar el user
    document.getElementById('nickname').style.display='none';
    //document.getElementById('text').reset();
	console.log(message);
	socket.emit('new-user',window.location.pathname.substr(1),window.location.search.substring(1).substring(9));
	socket.emit('add-message',window.location.pathname.substr(1),message);
	document.getElementById("text").value = '';
    return false;
}
function getUserLogged(){
		var nick = window.location.search.substring(1).substring(9);
		console.log(nick);
		document.getElementById("nickname").value = nick;
		document.getElementById("text").value = 'online';
		$("#submit").click();
		document.getElementById("text").value = '';
		
		
}



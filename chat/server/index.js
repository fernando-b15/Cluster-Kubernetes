var express  = require('express');
var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);


app.use(express.static('client'));
app.use(express.urlencoded({ extended: true }));

const rooms = { };

app.get('/', (req, res) => {
  res.render('index', { rooms: rooms })
});


app.post('/room', (req, res) => {
  console.log(req.body.room);
  if (rooms[req.body.room] != null) {
    return res.redirect('/')
  }
  rooms[req.body.room] = { users: {} ,messages: [{
    id:1,
    text: "Bienvedo a esta Sala, Disfruta!",
    nickname: 'Bot - SoundShare'}]}
  res.redirect(req.body.room)
  // Send message that new room was created
  io.emit('room-created', req.body.room)
});

app.get('/:room', (req, res) => {
  var nick=req.query.nickname;	
  if (rooms[req.params.room] == null) {
  var xd=req.params.room;  
  rooms[xd] = { users: {} ,messages: [{
    id:1,
    text: "Bienvenido a esta sala, Disfrura!",
    nickname: 'Bot - SoundShare'}]}
  console.log('gooooooooooooooo');
   console.log(xd);
  res.redirect(xd+'?nickname='+nick);
  // Send message that new room was created
   console.log(xd);
  io.emit('room-created', xd)
  }
  else{
	  console.log(req.params);
	  res.sendFile('room.html', { root: 'client' });
  }
});




//Permite lanzar eventos, abrimos una coneccion al Socket
io.on('connection',function(socket) {
    console.log("El nodo con IP:" + socket.handshake.address+" se ha conectado...");

	socket.on('new-user', (room, name) => {
		socket.join(room)
		rooms[room].users[socket.id] = name
	});
	socket.on('add-message', (room,data) => {	
        (rooms[room].messages).push(data);
		console.log('ya casi');
		console.log(rooms[room].messages);
        io.sockets.in(room).emit('messages',rooms[room].messages);
    });


});

const PORT = process.env.PORT || 6677;
server.listen(PORT,function () {
    console.log("Server funcionando en http://localhost:6677")
});

var http = require('http');
var express = require('express');
var sio = require('socket.io');

var app = express();
var server = http.CreateServer(app);
app.get('/',function(req,res){
	res.sendfile(_dirname+'/chart.html');
});
server.listen(80);
var io = sio.listen(server);
var names = [];//存放所有登录到聊天室的用户组
io.sockets.on('connection',function(socket){
	socket.on('login',function(name){
		for(var i=0; i<names.length; i++){
			if(name[i]==name){
				socket.emit('duplicate');
				return;
			}
		}
		names.push(name);
		io.sockets.emit('login',name);
		io.sockets.emit('sendClients',names);
	});
	socket.on('chat',function(data){
		io.sockets.emit('chat',data);
	});
	socket.on('logout',function(name){
		for(var i=0; i<names.length; i++){
			if(names[i]==name){
				names.splice(i,1);
				break;
			}
		}
		socket.broadcast.emit('logout',name);
		io.socket.emit('sendClients',names);
	});
});

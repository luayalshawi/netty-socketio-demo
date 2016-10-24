# netty-socketio-demo
basic example for netty-socketio which supports room chats

compile: mvn clean install

run: mvn exec:java

To use room features which allow one person or multiple people to communicate with each other:

1. 		socket.on('connect', function() 
      		{
        		socket.emit('joinRoom',{roomName:userName})
		});
      
      To join a room you must send a json object to name the room. Usally it's a user id or a unique user name.
      
2.    		var jsonObject = 
		      {
			userId:"2",
			userName: userName,
			sendFrom:userName,
			sendTo:sendTo,
			message: message
		       };
		socket.emit('sendToRoom', jsonObject);
      
      To send a message
      
3.     		socket.on('sendToRoom',function(data) {
          		//data is the recieved message. It's a json object
      		})
      
      
      

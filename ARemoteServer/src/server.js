const path = require('path')
const app = require('express')()
const http = require('http').Server(app)
const io = require('socket.io')(http)

const command = require('./command')

app.get('/', (req, res) => {
  // res.send('<h1>Hello world</h1>')
  res.sendFile(path.join(__dirname, '..', 'static') + '/index.html')
})

io.on('connection', socket => {
  console.log('a remote connected')

  socket.on('disconnect', () => {
    console.log('remote disconnected')
  })

  // accept a command
  socket.on('command', msg => {
    console.log(msg)

    switch (msg.command) {
      case 'startPresentation':
        command.startPresentation()
        break

      case 'stopPresentation':
        command.stopPresentation()
        break

      case 'nextSlide':
        command.nextSlide()
        break

      case 'previousSlide':
        command.previousSlide()
        break
    }
  })
})

http.listen(3000, function() {
  console.log('listening on *:3000')
})

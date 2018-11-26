const path = require('path')
const app = require('express')()
const http = require('http').Server(app)
const io = require('socket.io')(http)

const command = require('./command')

app.get('/', (req, res) => {
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

      case 'gotoNextSlide':
        command.gotoNextSlide()
        break

      case 'gotoPreviousSlide':
        command.gotoPreviousSlide()
        break

      case 'gotoFirstSlide':
        command.gotoFirstSlide()
        break

      case 'gotoLastSlide':
        command.gotoLastSlide()
        break
    }
  })
})

const PORT = 3000
http.listen(PORT, function() {
  // print serve's local ip address
  require('dns').lookup(require('os').hostname(), function(err, add, fam) {
    console.log(`listening on ${add}:${PORT}`)
  })
})

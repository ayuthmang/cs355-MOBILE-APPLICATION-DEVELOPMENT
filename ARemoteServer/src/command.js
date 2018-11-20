const robot = require('robotjs')

const startPresentation = () => {
  robot.keyTap('p', ['alt', 'command']) // alt == option (mac)
}

const stopPresentation = () => {
  robot.keyTap('escape')
}

const nextSlide = () => {
  robot.keyTap('left')
}

const previousSlide = () => {
  robot.keyTap('right')
}

module.exports = {
  startPresentation,
  stopPresentation,
  nextSlide,
  previousSlide
}

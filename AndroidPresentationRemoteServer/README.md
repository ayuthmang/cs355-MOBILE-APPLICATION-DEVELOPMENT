# Android Presentation Remote Server

Apple is make everthing works perfectly on their echo system, you can turn your phone into a presentation remote but not my android (so sad). So I decided to make a simple presentation remote using node and socket.io to let my phone into a presentation remote. 

## Prerequisite

- NodeJS (8.12.0 or higher, I'm testing with 8.12.0 version)
- Browser or android presentation remote client application (by the way browser is more flexible than native app)
- You mac must on the same network and can talk to each other

## Installation 

1. Goto project folder and `npm install` or `yarn install`
2. Run the server using `npm run serve` or `yarn serve`
3. Connect the remote to server. (or just open browser to 127.0.0.1:3000).
4. Open keynote and focus a window and press start presentation on your android device.
5. Let the world know your with your perfect presentation keynote.

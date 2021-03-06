const electron = require('electron')
// Module to control application life.
const app = electron.app
// 创建原生浏览器窗口的模块
const BrowserWindow = electron.BrowserWindow

const path = require('path')
const url = require('url')

// 页面通信
const {ipcMain} = require('electron')

// 打开系统本地文件或者网页链接
// const {shell} = require('electron');
// var path1 = "D:\迅雷下载";
// shell.openItem(path1);

// 打开浏览器
// const {shell} = require('electron')
// shell.openExternal('https://github.com')

// 打开文件管理器
// const shell = require('electron').shell
// const os = require('os')
// shell.showItemInFolder(os.homedir())

// 获取命令中带的参数
const argv = process
  .argv
  .slice(2)

// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let mainWindow

function createWindow() {
  // Create the browser window.
  mainWindow = new BrowserWindow({width: 800, height: 600})

  //判断是否是开发模式
  if (argv && argv[1] == 'dev') {
    mainWindow.loadURL("http://localhost:3000/")
  } else {
    // window 加载build好的html.
    mainWindow.loadURL(url.format({
      pathname: path.join(__dirname, './build/index.html'),
      protocol: 'file:',
      slashes: true
    }))
  }

  // close menu
  mainWindow.setMenu(null)
  // Open the DevTools. 
  mainWindow.webContents.openDevTools()
  // window is closed.
  mainWindow
    .on('closed', function () {
      // Dereference the window object, usually you would store windows in an array if
      // your app supports multi windows, this is the time when you should delete the
      // corresponding element.
      mainWindow = null
    })

  // 选择文件夹
  // const dialog = require('electron').dialog;
  // dialog.showOpenDialog({ properties: [ 'openFile', 'openDirectory', 'multiSelections' ]})
  ipcMain.on('asynchronous-message', (event, arg) => {
    event.sender.send('asychronous-reply', arg)
    // app.quit()
    // console.log(arg)

  })
}

// This method will be called when Electron has finished initialization and is
// ready to create browser windows. Some APIs can only be used after this event
// occurs.
app.on('ready', createWindow)

// Quit when all windows are closed.
app.on('window-all-closed', function () {
  // On OS X it is common for applications and their menu bar to stay active until
  // the user quits explicitly with Cmd + Q
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', function () {
  // On OS X it's common to re-create a window in the app when the dock icon is
  // clicked and there are no other windows open.
  if (mainWindow === null) {
    createWindow()
  }
})

// In this file you can include the rest of your app's specific main process
// code. You can also put them in separate files and require them here.

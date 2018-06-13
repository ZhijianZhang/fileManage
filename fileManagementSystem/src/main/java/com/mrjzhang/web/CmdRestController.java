package com.mrjzhang.web;

import com.mrjzhang.client.FtpClientMain;
import com.mrjzhang.server.FtpServerMain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/cmd")
public class CmdRestController {

    @RequestMapping(value="/clientSetting", method = RequestMethod.GET)
    public void clientSetting() {
      // 传输文件
      try {
        FtpClientMain ftpClientMain = new FtpClientMain();
        ftpClientMain.start();
        System.out.println("传输文件成功");
      } catch (Exception e) {
        System.out.println("传输文件失败");
        e.printStackTrace();
      }
    }

  FtpServerMain ftpServerMain = new FtpServerMain();
  @RequestMapping(value="/serverStart", method = RequestMethod.GET)
  public void serverStart() {
    // 传输文件
    try {
      // 启动服务器, 所需参数带在url中
      String SERVER_PORT = "9999";
      String FolderName = "F:\\fileManageWorkspace\\receive";

      ftpServerMain.start(SERVER_PORT,FolderName);
      System.out.println("开启服务器成功");
    } catch (Exception e) {
      System.out.println("开启服务器失败");
      e.printStackTrace();
    }
  }

}

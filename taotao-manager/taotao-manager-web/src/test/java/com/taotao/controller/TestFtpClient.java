package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class TestFtpClient {

	public static void main(String[] args)  {
		FTPClient ftpClient = new FTPClient();
		FileInputStream inputStream;
		String newFileName;
		boolean b;
		try {
			ftpClient.connect("192.168.147.129",21);//默认21端口
			boolean a1 =ftpClient.login("ftpuser", "lxygwqf552");
			System.out.println("a1:"+a1);
			 int reply = ftpClient.getReplyCode();//230
		/*        if (!FTPReply.isPositiveCompletion(reply))
		        {
		        	ftpClient.disconnect();
		            return;
		        }*/
			inputStream = new FileInputStream(new File("D:\\shenfen.jpg"));
			boolean a2 =ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//修改格式，默认是文本，改成二进制
//			boolean a5 =ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			System.out.println("a2:"+a2);
			boolean a3 =ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");//修改路径
			System.out.println("a3:"+a3);
//			ftpClient.enterLocalPassiveMode();
//			ftpClient.setControlEncoding("UTF-8");
			 b = ftpClient.storeFile("123.jpg", inputStream);
			 int reply2 = ftpClient.getReplyCode(); //Requested action not taken. File name not allowed.
			 System.out.println("reply2:"+reply2);
			System.out.println(b);
			inputStream.close();
			ftpClient.logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{

		}
		


	}

}

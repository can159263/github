package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Telnet
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		InputStream is = null;
		OutputStream os = null;
		try
		{
			ServerSocket ss = new ServerSocket(35002);
			while (true)
			{
				Socket s = ss.accept();

				try
				{
					is = s.getInputStream();

					BufferedReader br = new BufferedReader(new InputStreamReader(is));

					String line = br.readLine();

					System.out.println(line);

					os = s.getOutputStream();
					os.write("OK".getBytes());
					os.flush();
					
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					try
					{
						os.close();
						is.close();
						s.close();
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

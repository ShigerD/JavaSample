package com.lyh.sck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv_msg = null;
	private EditText ed_msg = null;
	private Button btn_send = null;
	private static final String HOST = "10.12.42.64";
	private static final int PORT = 8888;
	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String content = "";
	public Handler scHandler;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		findViews();
		initSocket();
	}
	
	/**
	 * 鍒濆鍖栨帶浠�
	 * */
	private void findViews() {
		tv_msg = (TextView) findViewById(R.id.TextView);
		ed_msg = (EditText) findViewById(R.id.EditText01);
		btn_send = (Button) findViewById(R.id.Button02);
	}
	
	/**
	 * 鍒濆鍖栨暟鎹�
	 * */
	private void initData() {
		scHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if (msg.what == 0) {
					btn_send.setOnClickListener(new Button.OnClickListener() {
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							String msg = ed_msg.getText().toString();
							if (socket.isConnected()) {
								if (!socket.isOutputShutdown()) {
									out.println(msg);
								}
							}
						}
					});
					new Thread(runnable).start();
				} else if (msg.what == 1) {
					tv_msg.setText(tv_msg.getText().toString() + content);
				} else if (msg.what == 2) {

				}
			}

		};
	}

	/**
	 * 鍒濆鍖朣ocket
	 * */
	public void initSocket() {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					socket = new Socket(HOST, PORT);//鍒濆鍖杝ocket瀵硅薄
					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					out = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream())),
							true);
					//鍒濆鍖栫帺socket锛屽皢缁撴灉鍛婄煡scHandler
					Message msg=scHandler.obtainMessage();
					msg.what=0;
					scHandler.sendMessage(msg);
				} catch (IOException ex) {
					ex.printStackTrace();
					ShowDialog("login exception" + ex.getMessage());
				}
			}
		}.start();

	}
	/***
	 * 鑾峰彇鏁版嵁绾跨▼
	 * */
	public Runnable runnable = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (true) {
					if (socket.isConnected()) {
						if (!socket.isInputShutdown()) {
							if ((content = in.readLine()) != null) {
								content += "\n";
								Message msg=scHandler.obtainMessage();
								msg.what=1;
								scHandler.sendMessage(msg);
							} else {

							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	  

	public void ShowDialog(String msg) {
		new AlertDialog.Builder(this).setTitle("notification").setMessage(msg)
				.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				}).show();
	}

}
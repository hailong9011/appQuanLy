package main;

import java.awt.EventQueue;

import views.DangNhap;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				DangNhap dangNhap = new DangNhap();
				dangNhap.setVisible(true);
				dangNhap.setLocationRelativeTo(null);
			}
		});
	}
}

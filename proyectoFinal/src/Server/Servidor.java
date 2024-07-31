package Server;

import java.io.*;
import java.net.*;

import logico.Controladora;

public class Servidor extends Thread {

	public static void main(String args[]) {
		ServerSocket sfd = null;
		try {
			System.out.println("Iniciando Conexion");
			sfd = new ServerSocket(7000);
			System.out.println("Aceptando conexiones por la ip: " + sfd.getInetAddress());
			
			while (true) {
				try {
					Socket nsfd = sfd.accept();
					System.out.println("Conexion aceptada de: " + nsfd.getInetAddress());

					ObjectInputStream inputStream = new ObjectInputStream(nsfd.getInputStream());
					try {
						Controladora controladora = (Controladora) inputStream.readObject();
						System.out.println("Llego la controladora");
					} catch (ClassNotFoundException e) {
						System.out.println("Error en conexion: " + e.getMessage());
					}

				} catch (IOException ioe) {
					System.out.println("Error: " + ioe);
				}
			}
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada." + ioe);
			System.exit(1);
		}finally {
			if (sfd != null && !sfd.isClosed()) {
				try {
					sfd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	}
}

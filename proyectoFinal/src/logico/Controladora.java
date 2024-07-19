package logico;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Controladora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int idfactura = 1;
	public static int iduser = 1;
	public static int idproduct = 1;
	public static int idorder = 1;

	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Product> myProducts;
	private ArrayList<Order> myOrders;
	private static Controladora miControladora = null;

	private Controladora() {
		super();
		misUsuarios = new ArrayList<Usuario>();
		myProducts = new ArrayList<Product>();
		myOrders = new ArrayList<Order>();
	}

	public static Controladora getInstance() {
		if (miControladora == null) {
			miControladora = new Controladora();
		}
		return miControladora;

	}

	// Users
	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public Usuario findUserById(String userId) {
		return misUsuarios.stream().filter(user -> user.getId().equalsIgnoreCase(userId)).findFirst().orElse(null);
	}

	public void addUser(Usuario user) {
		if (cargarDatosUsuarios() != null)
			setMisUsuarios(cargarDatosUsuarios());
		misUsuarios.add(user);
		iduser++;
		guardarDatosUsuario();
	}

	public void deleteUser(String userId) {
		Usuario user = findUserById(userId);
		if (user != null) {
			misUsuarios.remove(user);
			guardarDatosUsuario();
		}
	}

	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	public Usuario buscarUsuarioByCorreo(String email) {
		if (cargarDatosUsuarios() != null)
			for (int i = 0; cargarDatosUsuarios().size() > i; i++) {
				misUsuarios.add(cargarDatosUsuarios().get(i));
			}
		return misUsuarios.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
	}

	public void guardarDatosUsuario() {
		File directorio = new File("./src/Datos");
		if (!directorio.exists()) {
			directorio.mkdirs(); // Crea los directorios necesarios
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/Datos/Usuarios.dat"))) {
			oos.writeObject(miControladora.getMisUsuarios());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> cargarDatosUsuarios() {
		ArrayList<Usuario> usuarios = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/Datos/Usuarios.dat"))) {
			usuarios = (ArrayList<Usuario>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("Fin del archivo alcanzado inesperadamente: " + e.getMessage());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo Usuarios.dat: " + e.getMessage());
		}
		return usuarios;
	}

	// Products
	public void addProduct(Product c1) {
		myProducts.add(c1);
		idproduct++;

	}

	public ArrayList<Product> getProducts() {
		return myProducts;

	}
	
	public ArrayList<Product> getFilteredProducts(String filtro, String filtroType) {
		ArrayList<Product> filteredProducts = new ArrayList<>();
		
		if (myProducts!=null) {
			for (Product product : myProducts) {
				switch (filtroType) {
				case "Id":
					if (product.getId().contains(filtro)) {
						filteredProducts.add(product);
					}
					
					break;
				case "Num. de serie":
					if (product.getNumeroSerie().contains(filtro)) {
						filteredProducts.add(product);
						
					}
					break;
					
				case "Marca":
					if (product.getMarca().contains(filtro)) {
						filteredProducts.add(product);
						
					}
					break;
				case "Modelo":
					if (product.getModelo().contains(filtro)) {
						filteredProducts.add(product);
					}
					break;
					
				case "Tipo":
					if (filtro.toLowerCase().contains("ram")) {
						if (product instanceof MemoriaRAM) {
							filteredProducts.add(product);
							
						}
					}
					
					if (filtro.toLowerCase().contains("disco")) {
						if (product instanceof DiscoDuro) {
							filteredProducts.add(product);
							
						}
						
					}
					
					break;
				
				default:
					break;
				}
				
			}
			
		}
		
		return filteredProducts;
		
	}

	public void setProducts(ArrayList<Product> products) {
		this.myProducts = products;
	}

	// Ordenes
	public Order findOrderById(String orderId) {
		return myOrders.stream().filter(order -> order.getId().equalsIgnoreCase(orderId)).findFirst().orElse(null);
	}

	public void addOrder(Order order) {
		myOrders.add(order);
		idorder++;
	}

	public void deleteOrder(String orderId) {
		Order order = findOrderById(orderId);

		if (order != null) {
			myOrders.remove(order);
		}
	}

}
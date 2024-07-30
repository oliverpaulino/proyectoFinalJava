package logico;

import java.io.EOFException;
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
		miControladora = cargarDatos();
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
		misUsuarios.add(user);
		iduser++;
		guardarDatos();
	}

	public void deleteUser(String userId) {
		Usuario user = findUserById(userId);
		if (user != null) {
			misUsuarios.remove(user);
			guardarDatos();
		}
	}

	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	public Empleado buscarEmpleadoByCorreo(String email) {
		Empleado emp = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && misUsuarios.size() > i) {
			if (misUsuarios.get(i) instanceof Empleado) {
				if (misUsuarios.get(i).getEmail().equalsIgnoreCase(email)) {
					emp = (Empleado) misUsuarios.get(i);
					encontrado = true;
				}
			}
			i++;
		}
		return emp;
	}

	public boolean buscarExistenciaDeEmail(String email) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && misUsuarios.size() > i) {
			if (misUsuarios.get(i).getEmail().equalsIgnoreCase(email)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	// Products
	public void addProduct(Product c1) {
		myProducts.add(c1);
		idproduct++;
		guardarDatos();

	}

	public ArrayList<Product> getProducts() {
		return myProducts;

	}

	public ArrayList<Product> getFilteredProducts(String filtro, String filtroType) {
		ArrayList<Product> filteredProducts = new ArrayList<>();

		if (myProducts != null) {
			for (Product product : myProducts) {
				switch (filtroType) {
				case "Id":
					if (product.getId().toLowerCase().contains(filtro)) {
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
		guardarDatos();
	}

	public void deleteOrder(String orderId) {
		Order order = findOrderById(orderId);

		if (order != null) {
			myOrders.remove(order);
			guardarDatos();
		}
	}

	public void guardarDatos() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/Datos/Informaciones.dat"))) {
			oos.writeObject(miControladora);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Controladora cargarDatos() {
		Controladora controladora = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/Datos/Informaciones.dat"))) {
			controladora = (Controladora) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("Fin del archivo alcanzado inesperadamente: " + e.getMessage());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo Controladora.dat: " + e.getMessage());
		}
		return controladora;
	}

}
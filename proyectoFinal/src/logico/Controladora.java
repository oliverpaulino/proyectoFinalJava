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
	public static int idfactura;
	public static int iduser;
	public static int idproduct;
	public static int idorder;

	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Product> myProducts;
	private ArrayList<Order> myOrders;
	private ArrayList<Product> carrito;
	private static Controladora miControladora = null;

	private Controladora() {
		super();
		misUsuarios = new ArrayList<Usuario>();
		myProducts = new ArrayList<Product>();
		myOrders = new ArrayList<Order>();
		carrito = new ArrayList<Product>();
		iduser = 1;
		idproduct = 1;
		idorder = 1;
	}

	public static Controladora getInstance() {
		if (miControladora==null) {
			
			miControladora = cargarDatos();
			if (miControladora == null) {
				miControladora = new Controladora();
				miControladora.createDefaultUser();
			}
		}
		actualizarUltimoidOrder();
		actualizarUltimoid();
		actualizarUltimoidUser();
		return miControladora;

	}
	
	private static void actualizarUltimoid() {
		if(miControladora.getProducts() == null)
			idproduct = 1;
		else
			 for (Product product : miControladora.getProducts()) {
		            String idStr = product.getId().substring(2); // Elimina "C-"
		            int id = Integer.parseInt(idStr);
		            if (id >= idproduct) {
		                idproduct = id + 1;
		            }
		        }
	}
	
	private static void actualizarUltimoidOrder() {
		if(miControladora.getOrders() == null)
			idorder = 1;
		else
			 for (Order product : miControladora.getOrders()) {
		            String idStr = product.getId().substring(2); // Elimina "F-"
		            int id = Integer.parseInt(idStr);
		            if (id >= idorder) {
		                idorder = id + 1;
		            }
		        }
	}
	
	private static void actualizarUltimoidUser() {
		if(miControladora.getMisUsuarios() == null)
			iduser = 1;
		else
			 for (Usuario product : miControladora.getMisUsuarios()) {
		            String idStr = product.getId().substring(2); // Elimina "U-"
		            int id = Integer.parseInt(idStr);
		            if (id >= iduser) {
		                iduser = id + 1;
		            }
		        }
	}

	// Users
	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public Usuario findUserById(String userId) {
		return misUsuarios.stream().filter(user -> user.getId().equalsIgnoreCase(userId)).findFirst().orElse(null);
	}
	public Usuario findUserByCorreo(String userCorreo) {
		return misUsuarios.stream().filter(user -> user.getEmail().equalsIgnoreCase(userCorreo)).findFirst().orElse(null);
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
		cargarDatos();
		idproduct = Controladora.getInstance().idproduct++;
		guardarDatos();

	}

	public ArrayList<Product> getProducts() {
		return myProducts;

	}
	
	public void deleteProduct(String productid) {
		Product product = findProductById(productid);
		if (product != null) {
			myProducts.remove(product);
			guardarDatos();
		}
	}
	

	public Product findProductById(String productid) {
		return myProducts.stream().filter(user -> user.getId().equalsIgnoreCase(productid)).findFirst().orElse(null);
	}
	public void deleteProductFromCarrito(String productid) {
		Product product = findProductById(productid);
		if (product != null) {
			carrito.remove(product);
			guardarDatos();
		}
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
				case "Ofertas":
					if (product.isOferta()) {
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
		cargarDatos();
		idorder = Controladora.idorder++;
		guardarDatos();
	}

	public ArrayList<Order> getOrders() {
		return myOrders;
		
	}
	public void setMyOrders(ArrayList<Order>newOrders) {
		myOrders=newOrders;
	}
	
	public void deleteOrder(String orderId) {
		Order order = findOrderById(orderId);

		if (order != null) {
			myOrders.remove(order);
			guardarDatos();
		}
	}
	
	public void createDefaultUser() {
		Empleado adminDefault = new Empleado("U-"+this.iduser, "admin", "admin", "0", "-", "admin", (float) 0.0, true);
		addUser(adminDefault);
	}

	public static void guardarDatos() {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();
        String dataDir;

        if (osName.contains("win")) {
            dataDir = System.getenv("APPDATA");
            if (dataDir == null) {
                dataDir = userHome;
            }
            dataDir += "\\TechCRM\\Data";
        } else {
            dataDir = userHome + "/.techcrm/data";
        }

        java.io.File dir = new java.io.File(dataDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = dataDir + "/Informaciones.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(miControladora);
            System.out.println("Datos guardados en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static Controladora cargarDatos() {
        Controladora controladora = null;
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();
        String dataDir;

        if (osName.contains("win")) {
            // Windows: Utilizar AppData
            dataDir = System.getenv("APPDATA");
            if (dataDir == null) {
                dataDir = userHome;
            }
            dataDir += "\\TechCRM\\Data";
        } else {
            // Unix/Linux/Mac: Usar directorio de usuario
            dataDir = userHome + "/.techcrm/data";
        }

        String filePath = dataDir + "/Informaciones.dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            controladora = (Controladora) ois.readObject();
            System.out.println("Datos cargados desde: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado inesperadamente: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo Informaciones.dat: " + e.getMessage());
        }
        return controladora;
    }

	public ArrayList<Product> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Product> carrito) {
		this.carrito = carrito;
	}
	public ArrayList<Product> ListarProductosPorFiltro(String filtro) {
		ArrayList<Product> aux = new ArrayList<>();
		if(filtro.equals("Todos"))
			aux = getInstance().getProducts();
		else
			for(Product p : myProducts) {
				if(filtro == "Disco Duro")
					if(p instanceof DiscoDuro)
						aux.add(p);
				
				if(filtro == "Computadora")
					if(p instanceof Computadora)
						aux.add(p);
				
				if(filtro == "Memoria Ram")
					if(p instanceof MemoriaRAM)
						aux.add(p);
				
				if(filtro == "Microprocesador")
					if(p instanceof Microprocesador)
						aux.add(p);
				
				if(filtro == "Tarjeta Madre")
					if(p instanceof TarjetaMadre)
						aux.add(p);
				
			}
		
		return aux;
	}

	public Object BuscarTipoDeUnProducto(Product p) {
		String tipo = null;
			if(p instanceof DiscoDuro)
				tipo = "Disco Duro";		
			if(p instanceof Computadora)
				tipo = "Computadora";		
			if(p instanceof MemoriaRAM)
				tipo = "Memoria Ram";		
			if(p instanceof Microprocesador)
				tipo = "Microprocesaodr";
			if(p instanceof TarjetaMadre)
				tipo = "Tarjeta Madre";
		
		return tipo;
	}
	

}
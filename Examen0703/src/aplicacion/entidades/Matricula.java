package aplicacion.entidades;

public class Matricula 
{
	//----------------Atributos-----------------
		private int id= 0;	
		private String nombre="aaaaaaa";
		private String apellidos="aaaaaaa";
		private String fchalta = "aaaaaaaaaa";
		private String idModelo = "aaaaaaaaaa";	
		
		//----------------Getters and Setters-----------------
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getFchalta() {
			return fchalta;
		}

		public void setFchalta(String fchalta) {
			this.fchalta = fchalta;
		}

		public String getIdModelo() {
			return idModelo;
		}

		public void setIdModelo(String idModelo) {
			this.idModelo = idModelo;
		}
		
		@Override
		public String toString() {
			return "Matricula [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fchAlta=" + fchalta
					+ ", Modelo=" + idModelo +"]";
		}
		
		
}

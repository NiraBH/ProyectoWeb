package DTO;

import java.util.List;

public class PatologiaDTO {

		private int id;
		private String nombre;
		private String causa;
		private String tratamiento;
		private String descripcion;
		private List<SintomaDTO> lista_sintomas;
		
		public PatologiaDTO(int id, String nombre, String causa, String tratamiento, String descripcion,
				List<SintomaDTO> lista_sintomas) {
			this.id = id;
			this.nombre = nombre;
			this.causa = causa;
			this.tratamiento = tratamiento;
			this.descripcion = descripcion;
			this.lista_sintomas = lista_sintomas;
		}
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
		public String getCausa() {
			return causa;
		}
		public void setCausa(String causa) {
			this.causa = causa;
		}
		public String getTratamiento() {
			return tratamiento;
		}
		public void setTratamiento(String tratamiento) {
			this.tratamiento = tratamiento;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public List<SintomaDTO> getLista_sintomas() {
			return lista_sintomas;
		}
		public void setLista_sintomas(List<SintomaDTO> lista_sintomas) {
			this.lista_sintomas = lista_sintomas;
		}

		public String mostrarListaSintomas ()
		{
			String res = "";
			for (SintomaDTO s : lista_sintomas) {
				res += s.toString()+"<br>";
			}
			return res;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			//return super.toString();
			String res = null;
				
				res = "<strong>Nombre:</strong> "+this.nombre+"<br><strong>Descripción:</strong> <br>"+this.descripcion+"<br><strong>Tratamiento:</strong> <br>"+this.tratamiento+"<br><strong>Causa:</strong> <br>"+this.causa+"<br><strong>Síntomas:</strong> <br>"+mostrarListaSintomas();
				
			return res;
		}
	}
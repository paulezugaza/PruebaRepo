package es.deusto.ingenieria.prog3.UDExplore.domain;

import java.util.List;

public class Hotel extends Estancia {



    private CadenaHotelera cadenaHotelera;
    private List<Habitacion> habitaciones;
	

	public Hotel( String nombre, Ciudad ciudad, int categoria, int numeroHabitaciones, double tarifaNoche, String foto,
		 CadenaHotelera cadenaHotelera, List<Habitacion> habitaciones) {
		super( nombre, ciudad,categoria , numeroHabitaciones, tarifaNoche, foto, isDisponible());
	
		this.cadenaHotelera = cadenaHotelera;
		this.habitaciones = habitaciones;
	}
   



	@Override
	public String getNombre() {
		return super.getNombre();
	}

	
	@Override
	public int getNumeroHabitaciones() {
		return super.getNumeroHabitaciones();
	}

	@Override
	public double getTarifaNoche() {
		return super.getTarifaNoche();
	}

    
   

	public CadenaHotelera getCadenaHotelera() {
		return cadenaHotelera;
	}
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	
   public void addHabitacion(Habitacion habitacion) {
	        habitaciones.add(habitacion);
   }
	
	
	public void setCadenaHotelera(CadenaHotelera cadenaHotelera) {
			this.cadenaHotelera = cadenaHotelera;
	}
	
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	//Métodos
	
	@Override
	public String toString() {
		return "Hotel " + super.toString() +  ", cadenaHotelera=" + cadenaHotelera + 
				", habitaciones=" + habitaciones + "]";
	}

	@Override
	public double calcularPrecioTotal(int numNoches) {
		return super.calcularPrecioTotal(numNoches);
	}






}



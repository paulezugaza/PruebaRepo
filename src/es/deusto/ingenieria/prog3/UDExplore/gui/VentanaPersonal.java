package es.deusto.ingenieria.prog3.UDExplore.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.ingenieria.prog3.UDExplore.domain.Cliente;
import es.deusto.ingenieria.prog3.UDExplore.domain.Estancia;
import es.deusto.ingenieria.prog3.UDExplore.domain.Reserva;

import java.awt.BorderLayout;
	
	import java.util.Map;

	public class VentanaPersonal extends JFrame {
	    private static final long serialVersionUID = 1L;
		private Cliente cliente;
	    private DefaultTableModel tableModel;

	    public VentanaPersonal(Cliente cliente, Map<Cliente, Reserva> reservas) {
	        this.setCliente(cliente);

	        setTitle("Ventana Personal del Cliente");
	        setSize(800, 600);
	        setLocationRelativeTo(null);

	        JPanel panelSuperior = new JPanel();
	        JLabel datosClienteLabel = new JLabel("Datos del Cliente:");
	        panelSuperior.add(datosClienteLabel);

	        JTextArea datosClienteText = new JTextArea(cliente.toString());
	        datosClienteText.setEditable(false);
	        panelSuperior.add(datosClienteText);

	        add(panelSuperior, BorderLayout.NORTH);

	     
	        String[] columnas = {"Número de Reserva", "Fecha de Inicio", "Fecha de Fin", "Nombre Estancia", "Ciudad", "Tarifa Noche", "Categoría"};
	        tableModel = new DefaultTableModel(columnas, 0);
	        JTable reservasTable = new JTable(tableModel);

	        JScrollPane scrollPane = new JScrollPane(reservasTable);
	        add(scrollPane, BorderLayout.CENTER);

	 
	        for (Reserva reserva : reservas.values()) {
	            if (reserva.getCliente() == cliente) {
	                Estancia estancia = reserva.getTipo();
	                Object[] rowData = {
	                    reserva.getNumeroReserva(),
	                    reserva.getFechaInicio(),
	                    reserva.getFechaFin(),
	                    estancia.getNombre(),
	                    estancia.getCiudad(),
	                    estancia.getTarifaNoche(),
	                    estancia.getCategoria()
	                };
	                tableModel.addRow(rowData);
	            }
	        }

	        pack();
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        
	    }

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
	}



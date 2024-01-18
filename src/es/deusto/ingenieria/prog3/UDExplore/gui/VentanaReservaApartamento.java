package es.deusto.ingenieria.prog3.UDExplore.gui;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.deusto.ingenieria.prog3.UDExplore.domain.Apartamento;
import es.deusto.ingenieria.prog3.UDExplore.domain.Hotel;
import es.deusto.ingenieria.prog3.UDExplore.io.BaseDeDatos;
import es.deusto.ingenieria.prog3.UDExplore.io.Logica;

public class VentanaReservaApartamento extends JFrame {

    private static final long serialVersionUID = 1L;
	private Apartamento apartamento;
	

    public VentanaReservaApartamento(Apartamento apartamento) {
        super();
        this.apartamento = apartamento;
        inicializarVentana();
        this.setSize(500, 200);
        JPanel pBoton = new JPanel();
        JPanel pInfo = new JPanel();
		JButton bCancelar = new JButton("Cancelar");
		JButton bConfirmarDatos = new JButton("Confirmar operación");
		pBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
		pBoton.add(bCancelar);
		pBoton.add(bConfirmarDatos);
		
		JLabel labelHotel = new JLabel("Apartamento: ");
        JLabel labelCiudad = new JLabel("Ciudad: ");
        JLabel labelPrecioPorNoche = new JLabel("Precio por Noche: ");
        
        pInfo.add(labelHotel);
        pInfo.add(labelCiudad);
        pInfo.add(labelPrecioPorNoche);
		
		add(pInfo, BorderLayout.NORTH);
	    add(pBoton, BorderLayout.SOUTH);
	 
    	labelHotel.setText("Apartamento: " + apartamento.getNombre());
    	labelCiudad.setText("Ciudad: " + apartamento.getCiudad());
    	labelPrecioPorNoche.setText("Precio total: " + apartamento.getTarifaNoche() + "€");

	    
        bConfirmarDatos.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			String mensaje = "¡Su reserva ha sido guardada con éxito!\n\n" +
                        "Detalles de la estancia:\n" +
                        "Apartamento: " + apartamento.getNombre() + "\n" +
                        "Precio por noche: " + apartamento.getTarifaNoche() + "€\n";

    			JOptionPane.showMessageDialog(null, mensaje, "Reserva Exitosa", JOptionPane.INFORMATION_MESSAGE);

    			dispose();
    			
    		}
    		
    	});
    }

    private void inicializarVentana() {

        setTitle("Reserva de apartamento");
       
    }

}


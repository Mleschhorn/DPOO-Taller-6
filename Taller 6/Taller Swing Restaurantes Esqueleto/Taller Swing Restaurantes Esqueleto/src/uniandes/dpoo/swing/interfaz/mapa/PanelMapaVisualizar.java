package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa, BorderLayout.CENTER );
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;

     // TODO completar y hacer que se vean los nombres de todos los restaurantes en el mapa
     // Verifica si la lista de restaurantes no es nula y no está vacía
        if (restaurantes != null && !restaurantes.isEmpty()) {
            g2d.setColor(Color.RED); // Establece el color del texto
            g2d.setFont(g2d.getFont().deriveFont(17f)); // Establece el tamaño de la fuente

            // Itera a través de cada restaurante y dibuja su nombre
            for (Restaurante r : restaurantes) {
                int x = r.getX(); // Obtiene la coordenada X
                int y = r.getY(); // Obtiene la coordenada Y
                
                // Pone circulo como en el ejemplo
                g2d.fillOval(x - 3, y - 13, 6, 6);

                // Dibuja el nombre del restaurante cerca de sus coordenadas
                g2d.drawString(r.getNombre(), x + 5, y - 5); // Desplaza el texto para evitar que se superponga con el marcador
            }
        }
    }
    

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}

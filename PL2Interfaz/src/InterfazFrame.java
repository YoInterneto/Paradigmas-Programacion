import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import scala.Char;
import scala.collection.immutable.List;

/**
 *
 * @author Alberto
 */
public class InterfazFrame extends javax.swing.JFrame {

    /**
     * Creates new form InterfazFrame
     */
	
	
	ImageIcon rojo = new ImageIcon("./src/Imagenes/Rojo.png");
	ImageIcon gris = new ImageIcon("./src/Imagenes/Gris.png");
	ImageIcon amarillo = new ImageIcon("./src/Imagenes/Amarillo.png");
	ImageIcon morado = new ImageIcon("./src/Imagenes/Morado.png");
	ImageIcon naranja = new ImageIcon("./src/Imagenes/Naranja.png");
	ImageIcon vacio = new ImageIcon("./src/Imagenes/Vacio.png");
	ImageIcon verde = new ImageIcon("./src/Imagenes/Verde.png");
	
	List<List<Object>> tablero;
	List<Object> lista;
	JLabel[] iconos = new JLabel[81];
	int puntuacion = 0;
	
	
    public InterfazFrame() {
        initComponents();
        recomendacion.setEditable(false);
    }

    
    private void mostrarTablero(JLabel[] iconos, List<List<Object>> tablero) {
    	
    	for(int i = 0; i<9; i++) {
    		List<Object> fila = tablero.apply(i);
    		for(int j = 0; j<9; j++) {
    			Object valor = fila.apply(j);
    			int index = i*9 + j;
    			JLabel posicion = iconos[index];
    			
    			if(valor.equals('_')) {
    				posicion.setIcon(vacio);
    			}
    			else if(valor.equals('A')) {
    				posicion.setIcon(amarillo);
    			}
    			else if(valor.equals('G')) {
    				posicion.setIcon(gris);
    			}
    			else if(valor.equals('M')) {
    				posicion.setIcon(morado);
    			}
    			else if(valor.equals('N')) {
    				posicion.setIcon(naranja);
    			}
    			else if(valor.equals('R')) {
    				posicion.setIcon(rojo);
    			}
    			else if(valor.equals('V')) {
    				posicion.setIcon(verde);
    			}
    		}
    	}
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pos01 = new javax.swing.JLabel();
        pos02 = new javax.swing.JLabel();
        pos03 = new javax.swing.JLabel();
        pos04 = new javax.swing.JLabel();
        pos05 = new javax.swing.JLabel();
        pos06 = new javax.swing.JLabel();
        pos07 = new javax.swing.JLabel();
        pos08 = new javax.swing.JLabel();
        pos00 = new javax.swing.JLabel();
        pos10 = new javax.swing.JLabel();
        pos11 = new javax.swing.JLabel();
        pos12 = new javax.swing.JLabel();
        pos13 = new javax.swing.JLabel();
        pos14 = new javax.swing.JLabel();
        pos15 = new javax.swing.JLabel();
        pos16 = new javax.swing.JLabel();
        pos18 = new javax.swing.JLabel();
        pos19 = new javax.swing.JLabel();
        pos20 = new javax.swing.JLabel();
        pos21 = new javax.swing.JLabel();
        pos22 = new javax.swing.JLabel();
        pos23 = new javax.swing.JLabel();
        pos24 = new javax.swing.JLabel();
        pos25 = new javax.swing.JLabel();
        pos26 = new javax.swing.JLabel();
        pos27 = new javax.swing.JLabel();
        pos28 = new javax.swing.JLabel();
        pos30 = new javax.swing.JLabel();
        pos31 = new javax.swing.JLabel();
        pos32 = new javax.swing.JLabel();
        pos33 = new javax.swing.JLabel();
        pos34 = new javax.swing.JLabel();
        pos35 = new javax.swing.JLabel();
        pos36 = new javax.swing.JLabel();
        pos37 = new javax.swing.JLabel();
        pos38 = new javax.swing.JLabel();
        pos40 = new javax.swing.JLabel();
        pos41 = new javax.swing.JLabel();
        pos42 = new javax.swing.JLabel();
        pos43 = new javax.swing.JLabel();
        pos44 = new javax.swing.JLabel();
        pos45 = new javax.swing.JLabel();
        pos46 = new javax.swing.JLabel();
        pos47 = new javax.swing.JLabel();
        pos48 = new javax.swing.JLabel();
        pos50 = new javax.swing.JLabel();
        pos51 = new javax.swing.JLabel();
        pos52 = new javax.swing.JLabel();
        pos53 = new javax.swing.JLabel();
        pos54 = new javax.swing.JLabel();
        pos55 = new javax.swing.JLabel();
        pos56 = new javax.swing.JLabel();
        pos57 = new javax.swing.JLabel();
        pos58 = new javax.swing.JLabel();
        pos60 = new javax.swing.JLabel();
        pos61 = new javax.swing.JLabel();
        pos62 = new javax.swing.JLabel();
        pos63 = new javax.swing.JLabel();
        pos64 = new javax.swing.JLabel();
        pos65 = new javax.swing.JLabel();
        pos66 = new javax.swing.JLabel();
        pos67 = new javax.swing.JLabel();
        pos68 = new javax.swing.JLabel();
        pos70 = new javax.swing.JLabel();
        pos71 = new javax.swing.JLabel();
        pos72 = new javax.swing.JLabel();
        pos73 = new javax.swing.JLabel();
        pos74 = new javax.swing.JLabel();
        pos75 = new javax.swing.JLabel();
        pos76 = new javax.swing.JLabel();
        pos77 = new javax.swing.JLabel();
        pos78 = new javax.swing.JLabel();
        pos80 = new javax.swing.JLabel();
        pos81 = new javax.swing.JLabel();
        pos82 = new javax.swing.JLabel();
        pos83 = new javax.swing.JLabel();
        pos84 = new javax.swing.JLabel();
        pos85 = new javax.swing.JLabel();
        pos86 = new javax.swing.JLabel();
        pos87 = new javax.swing.JLabel();
        pos88 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recomendacion = new javax.swing.JTextArea();
        Recomendado = new javax.swing.JButton();
        Origen = new javax.swing.JLabel();
        Destino = new javax.swing.JLabel();
        OrigenX = new javax.swing.JTextField();
        OrigenY = new javax.swing.JTextField();
        DestinoX = new javax.swing.JTextField();
        DestinoY = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Mover = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        puntos = new javax.swing.JTextField();
        pos1 = new javax.swing.JLabel();
        pos8 = new javax.swing.JLabel();
        pos4 = new javax.swing.JLabel();
        pos7 = new javax.swing.JLabel();
        pos3 = new javax.swing.JLabel();
        pos9 = new javax.swing.JLabel();
        pos2 = new javax.swing.JLabel();
        pos5 = new javax.swing.JLabel();
        pos6 = new javax.swing.JLabel();
        pos39 = new javax.swing.JLabel();
        pos89 = new javax.swing.JLabel();
        pos90 = new javax.swing.JLabel();
        pos29 = new javax.swing.JLabel();
        pos49 = new javax.swing.JLabel();
        pos59 = new javax.swing.JLabel();
        pos69 = new javax.swing.JLabel();
        pos17 = new javax.swing.JLabel();
        pos79 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

titulo.setText("5 BOLAS");
        
        pos01.setIcon(vacio);
        pos02.setIcon(vacio);
        pos03.setIcon(vacio);
        pos04.setIcon(vacio);
        pos05.setIcon(vacio);
        pos06.setIcon(vacio);
        pos07.setIcon(vacio);
        pos08.setIcon(vacio);
        pos00.setIcon(vacio);
        pos10.setIcon(vacio);
        pos11.setIcon(vacio);
        pos12.setIcon(vacio);
        pos13.setIcon(vacio);
        pos14.setIcon(vacio);
        pos15.setIcon(vacio);
        pos16.setIcon(vacio);
        pos18.setIcon(vacio);
        pos19.setIcon(vacio);
        pos20.setIcon(vacio);
        pos21.setIcon(vacio);
        pos22.setIcon(vacio);
        pos23.setIcon(vacio);
        pos24.setIcon(vacio);
        pos25.setIcon(vacio);
        pos26.setIcon(vacio);
        pos27.setIcon(vacio);
        pos28.setIcon(vacio);
        pos30.setIcon(vacio);
        pos31.setIcon(vacio);
        pos32.setIcon(vacio);
        pos33.setIcon(vacio);
        pos34.setIcon(vacio);
        pos35.setIcon(vacio);
        pos36.setIcon(vacio);
        pos37.setIcon(vacio);
        pos38.setIcon(vacio);
        pos40.setIcon(vacio);
        pos41.setIcon(vacio);
        pos42.setIcon(vacio);
        pos43.setIcon(vacio);
        pos44.setIcon(vacio);
        pos45.setIcon(vacio);
        pos46.setIcon(vacio);
        pos47.setIcon(vacio);
        pos48.setIcon(vacio);
        pos50.setIcon(vacio);
        pos51.setIcon(vacio);
        pos52.setIcon(vacio);
        pos53.setIcon(vacio);
        pos54.setIcon(vacio);
        pos55.setIcon(vacio);
        pos56.setIcon(vacio);
        pos57.setIcon(vacio);
        pos58.setIcon(vacio);
        pos60.setIcon(vacio);
        pos61.setIcon(vacio);
        pos62.setIcon(vacio);
        pos63.setIcon(vacio);
        pos64.setIcon(vacio);
        pos65.setIcon(vacio);
        pos66.setIcon(vacio);
        pos67.setIcon(vacio);
        pos68.setIcon(vacio);
        pos70.setIcon(vacio);
        pos71.setIcon(vacio);
        pos72.setIcon(vacio);
        pos73.setIcon(vacio);
        pos74.setIcon(vacio);
        pos75.setIcon(vacio);
        pos76.setIcon(vacio);
        pos77.setIcon(vacio);
        pos78.setIcon(vacio);
        pos80.setIcon(vacio);
        pos81.setIcon(vacio);
        pos82.setIcon(vacio);
        pos83.setIcon(vacio);
        pos84.setIcon(vacio);
        pos85.setIcon(vacio);
        pos86.setIcon(vacio);
        pos87.setIcon(vacio);
        pos88.setIcon(vacio);
        
        this.iconos[0] = pos00; this.iconos[1] = pos01; this.iconos[2] = pos02; this.iconos[3] = pos03; this.iconos[4] = pos04; this.iconos[5] = pos05; this.iconos[6] = pos06; this.iconos[7] = pos07; this.iconos[8] = pos08; 
        this.iconos[9] = pos10; this.iconos[10] = pos11; this.iconos[11] = pos12; this.iconos[12] = pos13; this.iconos[13] = pos14; this.iconos[14] = pos15; this.iconos[15] = pos16; this.iconos[16] = pos18; this.iconos[17] = pos19; 
        this.iconos[18] = pos20; this.iconos[19] = pos21; this.iconos[20] = pos22; this.iconos[21] = pos23; this.iconos[22] = pos24; this.iconos[23] = pos25; this.iconos[24] = pos26; this.iconos[25] = pos27; this.iconos[26] = pos28; 
        this.iconos[27] = pos30; this.iconos[28] = pos31; this.iconos[29] = pos32; this.iconos[30] = pos33; this.iconos[31] = pos34; this.iconos[32] = pos35; this.iconos[33] = pos36; this.iconos[34] = pos37; this.iconos[35] = pos38; 
        this.iconos[36] = pos40; this.iconos[37] = pos41; this.iconos[38] = pos42; this.iconos[39] = pos43; this.iconos[40] = pos44; this.iconos[41] = pos45; this.iconos[42] = pos46; this.iconos[43] = pos47; this.iconos[44] = pos48; 
        this.iconos[45] = pos50; this.iconos[46] = pos51; this.iconos[47] = pos52; this.iconos[48] = pos53; this.iconos[49] = pos54; this.iconos[50] = pos55; this.iconos[51] = pos56; this.iconos[52] = pos57; this.iconos[53] = pos58; 
        this.iconos[54] = pos60; this.iconos[55] = pos61; this.iconos[56] = pos62; this.iconos[57] = pos63; this.iconos[58] = pos64; this.iconos[59] = pos65; this.iconos[60] = pos66; this.iconos[61] = pos67; this.iconos[62] = pos68; 
        this.iconos[63] = pos70; this.iconos[64] = pos71; this.iconos[65] = pos72; this.iconos[66] = pos73; this.iconos[67] = pos74; this.iconos[68] = pos75; this.iconos[69] = pos76; this.iconos[70] = pos77; this.iconos[71] = pos78; 
        this.iconos[72] = pos80; this.iconos[73] = pos81; this.iconos[74] = pos82; this.iconos[75] = pos83; this.iconos[76] = pos84; this.iconos[77] = pos85; this.iconos[78] = pos86; this.iconos[79] = pos87; this.iconos[80] = pos88;
        	
        List<List<Object>> tablero_vacio = Bolas.vacio();
        List<List<Object>> tablero_inicial = Bolas.llenar_tablero_inicial(tablero_vacio,0);
        	    
        List<Object> lista_movimientos = Bolas.mejor_jugada(tablero_inicial);
        String movimiento = Bolas.recomendacion(tablero_inicial, lista_movimientos);
        recomendacion.setText(movimiento);
        
        this.lista = lista_movimientos;
        
        Bolas.mostrar_tablero(tablero_inicial);
        this.tablero = tablero_inicial;
        mostrarTablero(iconos, this.tablero);
        
        puntos.setText(String.valueOf(this.puntuacion));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos00, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos01, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos02, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos03, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos04, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos05, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos06, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos07, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos08, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos22, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos26, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos27, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos28, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos30, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos31, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos32, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos33, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos34, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos35, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos36, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos37, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos38, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos40, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos41, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos42, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos43, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos44, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos45, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos46, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos47, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos48, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos50, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos51, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos52, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos53, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos54, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos55, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos56, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos57, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos58, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos60, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos61, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos62, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos63, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos64, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos65, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos66, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos67, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos68, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos70, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos71, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos72, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos73, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos74, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos75, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos76, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos77, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos78, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pos80, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos81, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos82, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos83, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos84, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos85, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos86, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos87, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pos88, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos01, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos02, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos03, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos04, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos05, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos00, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos06, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos07, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos08, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos22, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos31, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos32, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos33, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos34, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos35, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos30, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos41, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos42, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos43, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos44, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos45, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos40, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos51, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos52, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos53, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos54, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos55, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos50, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos61, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos62, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos63, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos64, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos65, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos60, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos71, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos72, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos73, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos74, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos75, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos70, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos77, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos78, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(pos81, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos82, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos83, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos84, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos85, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pos80, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos86, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos87, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos88, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("MARICON");

        recomendacion.setColumns(20);
        recomendacion.setRows(5);
        jScrollPane1.setViewportView(recomendacion);

        Recomendado.setText("Seguir recomendacion");
        Recomendado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecomendadoActionPerformed(evt);
            }
        });

        Origen.setText("ORIGEN:");

        Destino.setText("DESTINO:");

        OrigenX.setToolTipText("fila");

        OrigenY.setToolTipText("columna");
        OrigenY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenYActionPerformed(evt);
            }
        });

        DestinoX.setToolTipText("fila");

        DestinoY.setToolTipText("columna");

        jLabel1.setText("X:");

        jLabel2.setText("Y:");

        jLabel3.setText("X:");

        jLabel4.setText("Y:");

        Mover.setText("Mover");
        Mover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverActionPerformed(evt);
            }
        });

        jLabel5.setText("MOVIMIENTO RECOMENDADO: ");

        jLabel6.setText("PUNTUACION: ");

        puntos.setEditable(false);
        puntos.setToolTipText("puntos");

        pos1.setBackground(new java.awt.Color(204, 204, 204));
        pos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos1.setText("1");
        pos1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos8.setBackground(new java.awt.Color(204, 204, 204));
        pos8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos8.setText("8");
        pos8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos4.setBackground(new java.awt.Color(204, 204, 204));
        pos4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos4.setText("4");
        pos4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos7.setBackground(new java.awt.Color(204, 204, 204));
        pos7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos7.setText("7");
        pos7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos3.setBackground(new java.awt.Color(204, 204, 204));
        pos3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos3.setText("3");
        pos3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos9.setBackground(new java.awt.Color(204, 204, 204));
        pos9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos9.setText("9");
        pos9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos2.setBackground(new java.awt.Color(204, 204, 204));
        pos2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos2.setText("2");
        pos2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos5.setBackground(new java.awt.Color(204, 204, 204));
        pos5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos5.setText("5");
        pos5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos6.setBackground(new java.awt.Color(204, 204, 204));
        pos6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos6.setText("6");
        pos6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pos39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos39.setText("3");

        pos89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos89.setText("8");

        pos90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos90.setText("9");

        pos29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos29.setText("2");

        pos49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos49.setText("4");

        pos59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos59.setText("5");

        pos69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos69.setText("6");

        pos17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos17.setText("1");

        pos79.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pos79.setText("7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Origen)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(OrigenX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(OrigenY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Destino)
                        .addGap(120, 120, 120)
                        .addComponent(Mover))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(DestinoX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(DestinoY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(Recomendado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(pos1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pos17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(329, 329, 329)
                        .addComponent(pos6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos90, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos39, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos49, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos59, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(pos3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addComponent(pos7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(pos2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos89, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(pos8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(670, 670, 670)
                        .addComponent(pos9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(pos5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(pos4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos69, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos79, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos29, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Origen)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrigenX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrigenY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(Destino))
                            .addComponent(Mover))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DestinoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DestinoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Recomendado)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(puntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(pos17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(579, 579, 579)
                        .addComponent(pos90, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(pos39, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(pos49, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(pos59, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(pos89, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pos8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(pos69, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(pos79, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(pos29, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void OrigenYActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void MoverActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        	if(OrigenX.getText().equals("") || OrigenY.getText().equals("") || DestinoX.getText().equals("")|| DestinoY.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "ERROR: Rellena todos los campos");
        		OrigenX.setText("");
            	OrigenY.setText("");
            	DestinoX.setText("");
            	DestinoY.setText("");
        	}
        	else {
        		int origenX = Integer.parseInt(OrigenX.getText()) - 1;
            	int origenY = Integer.parseInt(OrigenY.getText()) - 1;
            	int destinoX = Integer.parseInt(DestinoX.getText()) - 1;
            	int destinoY = Integer.parseInt(DestinoY.getText()) - 1;
            	
            	List<List<Object>> tableroAux = this.tablero;
        		
        		char huecoOrigen = (char) tableroAux.apply(origenX).apply(origenY);
        		char huecoDestino = (char) tableroAux.apply(destinoX).apply(destinoY);
            	
            	if((0>origenX || origenX>8) || (0>origenY || origenY>8) || (0>destinoX || destinoX>8) || (0>destinoY || destinoY>8)){
            		JOptionPane.showMessageDialog(null, "ERROR: Rango de valores incorrecto");
            	}
            	else if(huecoDestino != '_') {
            		JOptionPane.showMessageDialog(null, "ERROR: Posicion de destino ocupada.");
            	}
            	else if(huecoOrigen == '_') {
            		JOptionPane.showMessageDialog(null, "ERROR: Posicion de origen vacia");
            	}
            	else {
            		List<Object> fila_nueva = Bolas.reemplazar(tableroAux.apply(destinoX), destinoY, huecoOrigen);
            		List<List<Object>> tablero_sin_hueco = Bolas.reemplazar_lista(this.tablero, destinoX, fila_nueva);
            		List<Object> tablero_hueco = Bolas.reemplazar(tablero_sin_hueco.apply(origenX), origenY, '_');
            		List<List<Object>> tablero_con_hueco = Bolas.reemplazar_lista(tablero_sin_hueco, origenX, tablero_hueco);
            		
            		List<List<Object>> tablero_sig_turno = Bolas.rellenar_turno(tablero_con_hueco, 0);
            		mostrarTablero(iconos, tablero_sig_turno);
            		
            		int puntuacioAux = Bolas.calcular_puntuacion(tablero_sig_turno, 0, 0, 0) * 75;
            		int puntuacion_acumulada = this.puntuacion + puntuacioAux;
            		this.puntuacion = puntuacion_acumulada;
            		
            		puntos.setText(String.valueOf(this.puntuacion));
            		
            		List<List<Object>> tablero_comprobado = Bolas.comprobar_tablero(tablero_sig_turno);
            		mostrarTablero(this.iconos, tablero_comprobado);
            		
            		this.tablero = tablero_comprobado;
            		
            		List<Object> lista_movimientos = Bolas.mejor_jugada(this.tablero);
                    String movimiento = Bolas.recomendacion(this.tablero, lista_movimientos);
                    recomendacion.setText(movimiento);
                    
                    this.lista = lista_movimientos;
                    
                    OrigenX.setText("");
                	OrigenY.setText("");
                	DestinoX.setText("");
                	DestinoY.setText("");
                	
                	if(Bolas.final_partida(this.tablero, 0, 0)) {
                		Recomendado.setEnabled(false);
                		Mover.setEnabled(false);
                		
                		//llamar a nueva interfaz y cerrar esta
                		this.setVisible(false);
                		
                			/**********************************************************************************************
                		  //Funcion que muestra un menu con las opciones de las que dispone el usuario una vez acabada la
                		  //partida, guardar puntuacion, nueva partida o terminar juego
                		  //**********************************************************************************************
                		  def terminar_juego(puntuacion: Int, guardado: Boolean){
                		    
                		    if(guardado){
                		      println(" 1)Nueva partida.")
                		      println(" 2)Terminar juego.")
                		      print("Introduzca la opcion que desee: ")
                		    }
                		    else{
                		      println(" 1)Guardar puntuacion.")
                		      println(" 2)Nueva partida.")
                		      println(" 3)Terminar juego.")
                		      print("Introduzca la opcion que desee: ")
                		    }
                		    
                		    val respuesta = scala.io.StdIn.readInt()
                		    
                		    if(respuesta == 1 && !guardado){  
                		      println("\nOPCION 1 -> Guardar puntuacion")
                		      println("Introduzca su nombre: ")
                		      val nombre = scala.io.StdIn.readLine()
                		      
                		      var reloj = Calendar.getInstance()
                		      var min = reloj.get(Calendar.MINUTE)
                		      var h = reloj.get(Calendar.HOUR_OF_DAY)
                		      val hora = h +":"+ min
                		      
                		      val format = new SimpleDateFormat("d/M/y")
                		      val fecha = format.format(Calendar.getInstance().getTime())
                		      
                		      val texto = "***************************\n"+
                		                  "   ["+ fecha + " " + hora +"]\n"+
                		                  "Jugador: "+ nombre + "\n"+
                		                  "Puntuacion: "+ puntuacion + "\n"+
                		                  "***************************\n\n"
                		      val pw = new PrintWriter(new BufferedWriter(new FileWriter("./src/puntuaciones.txt", true)))
                		      try pw.write(texto) finally pw.close()
                		      
                		      terminar_juego(puntuacion, true)
                		    }
                		    else if((respuesta == 2 && !guardado) || (respuesta == 1 && guardado)){
                		      if(guardado){println("\nOPCION 1 -> Nueva partida")}
                		      else{println("\nOPCION 2 -> Nueva partida")}
                		      iniciar_juego()
                		    }
                		    else if((respuesta == 3 && !guardado) || (respuesta == 2 && guardado)){
                		      if(guardado){println("\nOPCION 2 -> Terminar juego\nGracias por jugar.")}
                		      else{println("\nOPCION 3 -> Terminar juego\nGracias por jugar.")}
                		      System.exit(1)
                		    }
                		    else{
                		      println("\nERROR: numero incorrecto, intentelo de nuevo\n")
                		      if(guardado){terminar_juego(puntuacion, true)}
                		      else{terminar_juego(puntuacion, false)}
                		      
                		    }
                		  }*/
                	}
            	}
            	
        	}
        	
        	
        	
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "ERROR: Introduce formato numérico");
        	OrigenX.setText("");
        	OrigenY.setText("");
        	DestinoX.setText("");
        	DestinoY.setText("");
        }
    }                                        
                                     

    private void RecomendadoActionPerformed(java.awt.event.ActionEvent evt) {
    	char f = (char) this.lista.apply(0);
    	char c = (char) this.lista.apply(1);
    	
    	int fila = ((int) f) + 1;
    	int columna = ((int) c) + 1;
    	
    	
    	
    	OrigenX.setText("?");
    	OrigenY.setText("?");
    	DestinoX.setText(String.valueOf(fila));
    	DestinoY.setText(String.valueOf(columna));
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Destino;
    private javax.swing.JTextField DestinoX;
    private javax.swing.JTextField DestinoY;
    private javax.swing.JButton Mover;
    private javax.swing.JLabel Origen;
    private javax.swing.JTextField OrigenX;
    private javax.swing.JTextField OrigenY;
    private javax.swing.JButton Recomendado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pos00;
    private javax.swing.JLabel pos01;
    private javax.swing.JLabel pos02;
    private javax.swing.JLabel pos03;
    private javax.swing.JLabel pos04;
    private javax.swing.JLabel pos05;
    private javax.swing.JLabel pos06;
    private javax.swing.JLabel pos07;
    private javax.swing.JLabel pos08;
    private javax.swing.JLabel pos1;
    private javax.swing.JLabel pos10;
    private javax.swing.JLabel pos11;
    private javax.swing.JLabel pos12;
    private javax.swing.JLabel pos13;
    private javax.swing.JLabel pos14;
    private javax.swing.JLabel pos15;
    private javax.swing.JLabel pos16;
    private javax.swing.JLabel pos17;
    private javax.swing.JLabel pos18;
    private javax.swing.JLabel pos19;
    private javax.swing.JLabel pos2;
    private javax.swing.JLabel pos20;
    private javax.swing.JLabel pos21;
    private javax.swing.JLabel pos22;
    private javax.swing.JLabel pos23;
    private javax.swing.JLabel pos24;
    private javax.swing.JLabel pos25;
    private javax.swing.JLabel pos26;
    private javax.swing.JLabel pos27;
    private javax.swing.JLabel pos28;
    private javax.swing.JLabel pos29;
    private javax.swing.JLabel pos3;
    private javax.swing.JLabel pos30;
    private javax.swing.JLabel pos31;
    private javax.swing.JLabel pos32;
    private javax.swing.JLabel pos33;
    private javax.swing.JLabel pos34;
    private javax.swing.JLabel pos35;
    private javax.swing.JLabel pos36;
    private javax.swing.JLabel pos37;
    private javax.swing.JLabel pos38;
    private javax.swing.JLabel pos39;
    private javax.swing.JLabel pos4;
    private javax.swing.JLabel pos40;
    private javax.swing.JLabel pos41;
    private javax.swing.JLabel pos42;
    private javax.swing.JLabel pos43;
    private javax.swing.JLabel pos44;
    private javax.swing.JLabel pos45;
    private javax.swing.JLabel pos46;
    private javax.swing.JLabel pos47;
    private javax.swing.JLabel pos48;
    private javax.swing.JLabel pos49;
    private javax.swing.JLabel pos5;
    private javax.swing.JLabel pos50;
    private javax.swing.JLabel pos51;
    private javax.swing.JLabel pos52;
    private javax.swing.JLabel pos53;
    private javax.swing.JLabel pos54;
    private javax.swing.JLabel pos55;
    private javax.swing.JLabel pos56;
    private javax.swing.JLabel pos57;
    private javax.swing.JLabel pos58;
    private javax.swing.JLabel pos59;
    private javax.swing.JLabel pos6;
    private javax.swing.JLabel pos60;
    private javax.swing.JLabel pos61;
    private javax.swing.JLabel pos62;
    private javax.swing.JLabel pos63;
    private javax.swing.JLabel pos64;
    private javax.swing.JLabel pos65;
    private javax.swing.JLabel pos66;
    private javax.swing.JLabel pos67;
    private javax.swing.JLabel pos68;
    private javax.swing.JLabel pos69;
    private javax.swing.JLabel pos7;
    private javax.swing.JLabel pos70;
    private javax.swing.JLabel pos71;
    private javax.swing.JLabel pos72;
    private javax.swing.JLabel pos73;
    private javax.swing.JLabel pos74;
    private javax.swing.JLabel pos75;
    private javax.swing.JLabel pos76;
    private javax.swing.JLabel pos77;
    private javax.swing.JLabel pos78;
    private javax.swing.JLabel pos79;
    private javax.swing.JLabel pos8;
    private javax.swing.JLabel pos80;
    private javax.swing.JLabel pos81;
    private javax.swing.JLabel pos82;
    private javax.swing.JLabel pos83;
    private javax.swing.JLabel pos84;
    private javax.swing.JLabel pos85;
    private javax.swing.JLabel pos86;
    private javax.swing.JLabel pos87;
    private javax.swing.JLabel pos88;
    private javax.swing.JLabel pos89;
    private javax.swing.JLabel pos9;
    private javax.swing.JLabel pos90;
    private javax.swing.JTextField puntos;
    private javax.swing.JTextArea recomendacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration                   
}

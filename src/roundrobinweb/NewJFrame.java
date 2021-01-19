/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobinweb;
import java.awt.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Iterator;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author carlo
 */
public class NewJFrame extends javax.swing.JFrame {
 Proceso pro =new Proceso();
 
  static  Deque proceso ;
 
  static Deque Listo; Deque espera=new ArrayDeque();
  public static int quantum;
public  static int THH;
    /**
     * Creates new form NewJFrame
     */
  int tiempoespera;
    int Contador;//Contador del total de procesos que se van ingresando
    int NProceso;//Carga el número de procesos ejecutándose
    int Rafaga=0;//Carga la ráfaga en ejecución
    int Quantum;//Carga el quantum en ejecución
    int ResiduoRafaga=0;//Carga el residuo en ejecución
    int TiempoProceso=0;//Carga el tiempo que se dura procesando
    int ValorBarra;//Carga el progreso de la Barra
    int CantidadProcesos;//Número de procesos terminados
    String valor="";
    String valor2="";
    int numero=0;
    
     
    private static int tiempofinal=0;
    
    /**
     * Creates new form Procesar
     */
    Rectangle rect=new Rectangle();
    
    
    public void Procesar() throws JSONException {
        initComponents();
        this.setLocationRelativeTo(null);
        tabla1.setBackground(Color.CYAN);
        tabla1.setForeground(Color.blue);
        jTFinal.setBackground(Color.GREEN);
         Canvas canvas = new Canvas();
        //jTFinal.setBackground(Color.red);
        Q.grabFocus();
             
    }
    public static String Nombre;
    public int Numero=0;
    public String turnaround="";
     public String obtener(String dato){
        String valor=dato;
        
        return valor;
    }
    
    public int obtener(int Numero){
        int valor=Numero;
        
        return valor;
    }
      
   
     static String nombre="";
    
    
  Basededato base =new Basededato();

    public NewJFrame() throws JSONException {
         
        initComponents();
       
         
    }
public void webservice() throws JSONException{ //RECIBIR DATOS
       
         int contador=0;
       
        
        String link="http://localhost/lab/datos.php";
        HttpURLConnection con=null;
        BufferedReader reader=null;
        
        
    
        try {
            URL url=new URL(link); // establece una conexion  con la url del webservice 
            con=(HttpURLConnection)url.openConnection();
            con.connect();// abro la conexion
            InputStream stream=con.getInputStream(); //metodo para leer flujo de datos
            reader=new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer= new StringBuffer();
            String linea=""; // dato que va permitir capturar los datos del json
            while((linea=reader.readLine())!=null){ // mientras que la linea no este vacia
                buffer.append(linea); // lo que me capture del JSON lo guarda en esa bariable
            }
            String finalj=buffer.toString();//obtengo lo que guarde en el bufger
            JSONObject objeto=new JSONObject(finalj); //creo un objeto json  y le asigno lo que obtuvo
            JSONArray vector=objeto.getJSONArray("procesos");//capturo el campo proceso del json el vector
             
            JSONObject valores=vector.getJSONObject(0);
            String valor="";
            
  for(int i=0;i<vector.length();i++){ //recorro el json
     
       
    int pid=Integer.parseInt(vector.getJSONObject(i).getString("PID").trim());
    String nombreproceso=vector.getJSONObject(i).getString("nombre").trim();
    String caracteres=vector.getJSONObject(i).getString("mensaje");
    
    
  //  JOptionPane.showMessageDialog(null,"Proceso : \n"+nombreproceso+"caracteres \n"+caracteres);
   
        
        
    String dato=String.valueOf("Nombre: \n "+nombreproceso+"\n"+" su mensaje es :"+caracteres);
    
    p.append(dato);
   
    char remplazante=JOptionPane.showInputDialog(null, "digite el valor").charAt(0);
  
   pro.setPID(pid);
   pro.setNombre(nombreproceso);
    pro.setCaracteres(caracteres);
        String rem=JOptionPane.showInputDialog(null,"digite el dato a remplazar");
    int d=Integer.parseInt(th.getText().toString().trim());
    String mensajes="";
    
      p.setText("");
  //  mensajes+String.valueOf("Datos"+pid);
    //JOptionPane.showMessageDialog(null,proceso.Remplazar(remplazante, rem));
    
       
 Ingresar(pro.getPID(),pro.getNombre(),pro.getCaracteres(),pro.Rafaga(remplazante, d),pro.Remplazar(remplazante, rem));
     
      
  }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPBEstado = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jBIniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLNumeroProceso = new javax.swing.JTextField();
        por = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLCantidadProcesos = new javax.swing.JTextField();
        jLCantidadTiempo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        Q = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTFinal = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        p = new javax.swing.JTextArea();
        Th = new javax.swing.JLabel();
        th = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ejecucion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        listo = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        terminado = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        grafico = new javax.swing.JButton();
        panel = new javax.swing.JPanel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPBEstado.setBackground(java.awt.SystemColor.textHighlight);
        jPBEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPBEstado.setForeground(new java.awt.Color(0, 51, 255));
        jPBEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));

        jLabel7.setText("Proceso");

        jBIniciar.setText("Iniciar");
        jBIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("PROCESOS NO EXPULSIVOS");

        jLNumeroProceso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNumeroProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLNumeroProcesoActionPerformed(evt);
            }
        });

        por.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        por.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CANTIDAD PROCESO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TIEMPO PROCESO");

        jLCantidadProcesos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCantidadProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLCantidadProcesosActionPerformed(evt);
            }
        });

        jLCantidadTiempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCantidadTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLCantidadTiempoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Quantum");

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Nombre", "Prioridad", "Estado", "Rafaga", "Quantum", "Tiempodellegada", "Turnaround", "Tiempodefinalizacion", "Residuo", "Mensaje remplazado"
            }
        ));
        jScrollPane3.setViewportView(tabla1);

        Q.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }
        });

        jTFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Nombre", "Prioridad", "Estado", "Rafaga", "Quantum", "Tiempodellegada", "Turnaround", "Tiempodefinalizacion", "ResiduoRafaga", "Mensaje"
            }
        ));
        jScrollPane4.setViewportView(jTFinal);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Procesos");

        p.setColumns(20);
        p.setRows(5);
        jScrollPane1.setViewportView(p);

        Th.setText(" ");

        th.setText(" ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Procesos que van entrando");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("TH");

        ejecucion.setColumns(20);
        ejecucion.setRows(5);
        jScrollPane2.setViewportView(ejecucion);

        listo.setColumns(20);
        listo.setRows(5);
        jScrollPane5.setViewportView(listo);

        terminado.setColumns(20);
        terminado.setRows(5);
        jScrollPane6.setViewportView(terminado);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText(" ESQUEMA GUI");

        grafico.setText("Graficar");
        grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(35, 35, 35)
                        .addComponent(jLNumeroProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(por, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLCantidadProcesos)
                                            .addComponent(jLCantidadTiempo))))
                                .addGap(99, 99, 99)))
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(th, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(163, 163, 163))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(grafico))
                                .addGap(18, 18, 18)))
                        .addComponent(Th)
                        .addGap(79, 79, 79)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel10)))
                .addGap(880, 880, 880))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel11)
                                .addGap(20, 20, 20))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBIniciar)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grafico)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(326, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(th, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Th)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(por, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLNumeroProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLCantidadProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLCantidadTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarActionPerformed
        // TODO add your handling code here:
        new Thread(new Hilo()).start(); //Crea un nuevo hilo
        Iniciar();
    }//GEN-LAST:event_jBIniciarActionPerformed

    private void jLNumeroProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLNumeroProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLNumeroProcesoActionPerformed

    private void porActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porActionPerformed

    private void jLCantidadProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLCantidadProcesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLCantidadProcesosActionPerformed

    private void jLCantidadTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLCantidadTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLCantidadTiempoActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        try {
            // TODO add your handling code here:
            //if((Integer.parseInt(jTFCapturaRafaga.getText()))<=100){
            //Ingresar();
            //jTFCapturaQuantum.setEditable(false);
            ////   JOptionPane.showMessageDialog(null, "Las Rafagas no pueden ser mayores de 100");
            //  jTFCapturaRafaga.setText(null);
            // jTFCapturaRafaga.grabFocus();
            //}
           
               if(Q.getText().equals("")&& th.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No puedes dejar este campo vacio");
        }else {
                  
               }
                   if(Q.getText().length()!=0 &&th.getText().length()!=0){
                                    
         webservice();
        
                   } 
        } catch (JSONException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBAgregarActionPerformed

    private void QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QActionPerformed

    private void graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoActionPerformed
        // TODO add your handling code here:
      
         DefaultCategoryDataset ds=new DefaultCategoryDataset();
         
         for(int i=0;i<tabla1.getRowCount();i++){
              
            
         
            
          ds.setValue(Integer.parseInt(tabla1.getValueAt(i, 0).toString()), tabla1.getValueAt(i, 1).toString(), tabla1.getValueAt(i, 2).toString());
                 JFreeChart chart=ChartFactory.createBarChart("Laboratorio Sistemas Operativos", "", "Proceso vs Turnaround", ds, PlotOrientation.HORIZONTAL, true, true, false);
                 ChartPanel cp=new ChartPanel(chart);
                 add(cp);
                 
                 cp.setBounds(100,100,80,100);
                 panel.add(cp);
                 
          
       
           
         }
          
    }//GEN-LAST:event_graficoActionPerformed
private static String esNumero(String cadena){
    String mensaje="";
    String dato="";
    boolean a=true;
	try {
		Integer.parseInt(cadena);
		 
	} catch (NumberFormatException nfe){
		 mensaje="Escriba un numero";
	}
        return mensaje;
}
    
    public String Capturar(int posiciones,String mensaje){
    String datos="";
           datos= datos+String.valueOf("PID : "+tabla1.getValueAt(posiciones, 0)+"\n"+"Nombre"+tabla1.getValueAt(posiciones, 1)+"\n"+"Quantum"+tabla1.getValueAt(posiciones, 5)+"\n"+"Ejecuciones"+tabla1.getValueAt(posiciones, 9)+"----"+mensaje+"---------") ;
 return datos;  
}
    
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (JSONException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    
    private class Hilo implements Runnable{ //Objeto de tipo Hilo con extension ejectubale
    @Override
    public void run(){
         
        
        Proceso tipo=new Proceso();
        int estado=1; //Estado de while que indica si se puede seguir o no
        int i=0; // contador de while
       // contador de while
        int valor;
        Rectangle rect=new Rectangle();
        String  ejecuciones="";
        String Listos="";
        String terminados="";
        int dato=Integer.parseInt(tabla1.getValueAt(i, 0).toString());
        valor=Integer.parseInt(th.getText().trim());
         while(estado!=0){
        
            while(i<Contador){ //Recorrer las filas
                if(Integer.parseInt(tabla1.getValueAt(i, 6).toString())-1<= TiempoProceso || Integer.parseInt(tabla1.getValueAt(i, 2).toString())!=0){
                     
                      Cargar(i);
              
             
                
            
            //   cargardatos(i);
              ejecucion.setText("");
                if(ResiduoRafaga != 0 && ResiduoRafaga>quantum){ //Ejecutando Procesos
                   
                    for(int c=1; c<=quantum; c++){
                        if(ResiduoRafaga > 0){
                        //mes =  ((String)ingret.getValueAt(i,9));
  
                     //  (()) susti(mes);
                       //tabla1.setValueAt(susti,i,9);
                          // ejecucion.setText("");
                        tabla1.setValueAt("ejecucion",i,3);
                        
                      ResiduoRafaga=ResiduoRafaga-valor;
                        Barra(Rafaga,ResiduoRafaga);
                        Pintar();
                        tabla1.setValueAt((ResiduoRafaga),i,9);
                          try {
                                Insertarenlabasededatos( i);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                        TiempoProceso++;
                       jLCantidadTiempo.setText(String.valueOf(TiempoProceso));  
                      
                          ejecucion.append(Capturar(i,"ejecucion"));
                       
                        
                      
                      
                     
                    
                         // ejecuciones=ejecuciones+String.valueOf("PID"+dato+":"+"Nombre"+tabla1.getValueAt(i, 1)+":"+"Quantum"+tabla1.getValueAt(i, 5)+"Ejecuciones"+ResiduoRafaga+"" );
                        //  g.drawString(ejecuciones, 50, 100);
                          
                  //   g.drawString(ejecuciones, 28,130);
                       
              
                        
                       
                     

                        Dormir();
                         //ejecucion.setText("");
                        }
                        
                        }
            
                    tabla1.setValueAt("Listo",i,3);
                    try {
                                Insertarenlabasededatos( i);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                     
                   listo.append(Capturar(i,"listo"));
                    if(ResiduoRafaga==0){
                        ejecucion.setText("");
                       tabla1.setValueAt("Terminado",i,3);
                       
                        Pintar();
                        Informe(i);
                        try {
                                Insertarenlabasededatos( i);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                        Borrar(i);
                        jPBEstado.setValue(0);
                        terminado.append(Capturar(i,"terminado"));
                         
                    }
                    
                }
                else{
                if(ResiduoRafaga>0 && quantum!=0){
                    while(ResiduoRafaga>0){
                        if(ResiduoRafaga > 0){
                      //  mes =  ((String)ingret.getValueAt(i,9));
                       // susti(mes);
                       // ingret.setValueAt(susti(mes),i,9);
                       // ingret.setValueAt(mes,i,9);
                            listo.setText("");
                        tabla1.setValueAt("Ejecucion",i,3);
                        
                       
                        ResiduoRafaga=ResiduoRafaga-valor;
                        Barra(Rafaga,ResiduoRafaga);
                        Pintar();
                        tabla1.setValueAt((ResiduoRafaga),i,9);
                        try {
                                Insertarenlabasededatos( i);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                        TiempoProceso++;
                       jLCantidadTiempo.setText(String.valueOf(TiempoProceso));
                       ejecucion.append(Capturar(i,"ejecucion"));
                        
                        Dormir();
                          
                      
                        }
                    }
                   // if(Integer.parseInt(tabla1.getValueAt(i,2).toString())!=0){
                   //       tabla1.setValueAt("",i,3);
                    //}
                    ejecucion.setText("");
                   tabla1.setValueAt("Listo",i,3);
                   try {
                                Insertarenlabasededatos( i);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                   listo.append(Capturar(i,"Listo"));
                   
                    if(ResiduoRafaga==0 && quantum!=0){
                         ejecucion.setText("");
                        tabla1.setValueAt("Terminado",i,3);
                       Pintar();
                         Informe(i);
                        
                        Borrar(i);
                     
                       jPBEstado.setValue(0);
                          terminado.append(Capturar(i,"terminado"));
                           try {
                                Insertarenlabasededatos( i);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                        
                     }
                    }else{
                        if(ResiduoRafaga!=0 && quantum!=0){
                           tabla1.setValueAt("ejecucion",i,3);
                           ejecucion.append(Capturar(i,"ejecucion"));
                           
                            Pintar();
                            
                           Informe(i);
                            
                            Borrar(i);
                             
                            jPBEstado.setValue(0);
                            
                              
                        //terminado.append(Capturar(i,"terminado"));
                            
                             
                        }
                    }
                
                }
                
                jLNumeroProceso.setText(String.valueOf("")); //Borrar contenido
                por.setText(String.valueOf(""));
                i++;
            }
            }
            i=0;
           jLNumeroProceso.setText(String.valueOf("")); //Borrar contenido
            por.setText(String.valueOf(""));
            ejecucion.setText("");
                            listo.setText("");
        }
            
    }
}

public void Dormir(){
 //   int val=Integer.parseInt(th.getText().trim());
    try{
        Thread.sleep(700); //Dormir sistema
    }catch(InterruptedException ex){
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE,null,ex);
    }

}
  private class Hilos implements Runnable{ //Objeto de tipo Hilo con extension ejectubale
    @Override
    public void run(){
         
        int ResiduoRafaga=0;
        int quantum=0;
        int Rafaga=0;
        Proceso tipo=new Proceso();
        int estado=1; //Estado de while que indica si se puede seguir o no
        int i=0; // contador de while
       // contador de while
        int valor;
        Rectangle rect=new Rectangle();
        String  ejecuciones="";
        String Listos="";
        String terminados="";
        int dato=Integer.parseInt(tabla1.getValueAt(i, 0).toString());
        valor=Integer.parseInt(th.getText().trim());
         while(estado!=0){
            while(i<Contador){ //Recorrer las filas
                if((((int) tabla1.getValueAt(i,6 ))-1) <= TiempoProceso){
              Cargar(i);
              // cargardatos(i);
                if(ResiduoRafaga != 0 && ResiduoRafaga>quantum){ //Ejecutando Procesos
                    
                    for(int c=1; c<=quantum; c++){
                        if(ResiduoRafaga > 0){
                        //mes =  ((String)ingret.getValueAt(i,9));

                     //  (()) susti(mes);
                       //tabla1.setValueAt(susti,i,9);
                           ejecucion.setText("");
                        tabla1.setValueAt("ejecucion",i,3);
                           
                         ejecucion.append(Capturar(i,"ejecucion"));
                         try {
                                Insertarenlabasededatos( i);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        ResiduoRafaga=ResiduoRafaga-valor;
                        Barra(Rafaga,ResiduoRafaga);
                        Pintar();
                        tabla1.setValueAt((ResiduoRafaga),i,9);
                        TiempoProceso++;
                          
                       jLCantidadTiempo.setText(String.valueOf(TiempoProceso));  
                      
                       
                       
                       
                      
                      
                     
                    
                         // ejecuciones=ejecuciones+String.valueOf("PID"+dato+":"+"Nombre"+tabla1.getValueAt(i, 1)+":"+"Quantum"+tabla1.getValueAt(i, 5)+"Ejecuciones"+ResiduoRafaga+"" );
                        //  g.drawString(ejecuciones, 50, 100);
                          
                  //   g.drawString(ejecuciones, 28,130);
                       
                
                        
                       
                     

                        Dormir();
                        }
                        
                        }
            listo.setText("");
                    tabla1.setValueAt("Listo",i,3);
                        
                     
                   listo.append(Capturar(i,"listo"));
                   try {
                                Insertarenlabasededatos( i);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    if(ResiduoRafaga==0){
                       tabla1.setValueAt("Terminado",i,3);
                       
                        Pintar();
                            Borrar(i);
                        Informe(i);
                     //  Borrar(i);
                        jPBEstado.setValue(0);
                        
                       terminado.append(Capturar(i,"terminado"));
                        
                    }
                    
                }
                else{
                if(ResiduoRafaga>0 && quantum!=0){
                    while(ResiduoRafaga>0){
                        if(ResiduoRafaga > 0){
                      //  mes =  ((String)ingret.getValueAt(i,9));
                       // susti(mes);
                       // ingret.setValueAt(susti(mes),i,9);
                       // ingret.setValueAt(mes,i,9);
                        tabla1.setValueAt("Ejecucion",i,3);
                           try {
                                Insertarenlabasededatos( i);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                       
                        ResiduoRafaga=ResiduoRafaga-valor;
                        Barra(Rafaga,ResiduoRafaga);
                        Pintar();
                        tabla1.setValueAt((ResiduoRafaga),i,9);
                        TiempoProceso++;
                       jLCantidadTiempo.setText(String.valueOf(TiempoProceso));
                      ejecucion.append(Capturar(i,"ejecucion"));
                      
                        Dormir();
                          
                        try {
                                Insertarenlabasededatos( i);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                   tabla1.setValueAt("Listo",i,3);
                      
                   listo.append(Capturar(i,"Listo"));
                    if(ResiduoRafaga==0 && quantum!=0){
                        tabla1.setValueAt("Terminado",i,3);
                        Pintar();
                        
                         Borrar(i);
                        Informe(i);
                             try {
                                Insertarenlabasededatos( i);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                     
                       jPBEstado.setValue(0);
                   //       terminado.append(Capturar(i,"terminado"));
                        
                     }
                    }else{
                        if(ResiduoRafaga==0 && quantum!=0){
                           tabla1.setValueAt("Terminado",i,3);
                               
                           
                            Pintar();
                            try {
                                Insertarenlabasededatos( i);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Informe(i);
                            
                           Borrar(i);
                             
                            jPBEstado.setValue(0);
                         terminado.append(Capturar(i,"terminado"));
                             //try {
                            //    Insertarenlabasededatos( i);
                            //} catch (FileNotFoundException ex) {
                             //   Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           // }
                             
                        }
                    }
                }
                
                jLNumeroProceso.setText(String.valueOf("")); //Borrar contenido
                por.setText(String.valueOf(""));
                i++;
            }
            }
            i=0;
           jLNumeroProceso.setText(String.valueOf("")); //Borrar contenido
            por.setText(String.valueOf(""));
            ejecucion.setText("");
                            listo.setText("");
        }
            
    }
}
  
  
  
  public void compararprioridad(int i,int val){
      int comparando=Integer.parseInt(tabla1.getValueAt(0, 2).toString().trim());
      String valor="";
        int menortiempodellegada=Integer.parseInt(tabla1.getValueAt(0, 6).toString());
      if(Integer.parseInt(tabla1.getValueAt(i, 2).toString())>0){
           if(Integer.parseInt(tabla1.getValueAt(i, 2).toString())<comparando){
             comparando=Integer.parseInt(tabla1.getValueAt(i, 2).toString());
             JOptionPane.showMessageDialog(null, comparando);
          
         }
               if(Integer.parseInt(tabla1.getValueAt(i, 2).toString())==comparando){
             if(Integer.parseInt(tabla1.getValueAt(i, 6).toString())<comparando){
                valor=tabla1.getValueAt(i, 1).toString();
                 quantum=Rafaga/val;
                 
                 
             }
         }
          
      }
         
  }
  public void Empate(int i,int val){
        int comparando=Integer.parseInt(tabla1.getValueAt(0, 6).toString().trim());
        
         if(Integer.parseInt(tabla1.getValueAt(i, 2).toString())==comparando){
             if(Integer.parseInt(tabla1.getValueAt(i, 6).toString())<comparando){
                int menortiempodellegada=Integer.parseInt(tabla1.getValueAt(i, 6).toString());
             JOptionPane.showMessageDialog(null, "menor tiempo"+tabla1.getValueAt(i, 1).toString());
                  quantum=Rafaga/val;
                 
             }
         }
      
      
  }
  public int Mayor(int dato){
      int mayor=(int)tabla1.getValueAt(0,8 );
      if((int)tabla1.getValueAt(dato, 8)>mayor){
          mayor=(int)tabla1.getValueAt(dato,8);
      }
      return mayor;
  }

 
public void Cargar(int i){ //Carga los valores de la Tabla
    int valor=Integer.parseInt(th.getText().trim());
 //   String valor=Th.getText();
   // int dato=Integer.parseInt(valor);
  //  int valor=Integer.parseInt(Th.getText().toString());
 NProceso=Integer.parseInt(tabla1.getValueAt(i, 0).toString());
pro.setPrioridad(Integer.parseInt(tabla1.getValueAt(i, 2).toString()));
   
 if(Integer.parseInt(tabla1.getValueAt(i,2 ).toString())  == 0){      
      
     
                     quantum = Rafaga/valor ;
//parseInt((String) (th.getText()));
                
 
 
 
 
 
 
 } 
    else{
    quantum = parseInt((String)(tabla1.getValueAt(i,5)));     //tiempoespera=Mayor(i);
     compararprioridad(i,valor);
     Empate(i,valor);
      
    
        
    }
 
 
    //ResiduoRafaga = (int)tabla1.getValueAt(i,7);
   //Quantum=Integer.parseInt(jTIngreso.getValueAt(i, 5).toString().trim());
   
   
 // Rafaga=(int)tabla1.getValueAt(i,4);
     
 
     Rafaga=Integer.parseInt(tabla1.getValueAt(i,4 ).toString());
   ResiduoRafaga= Integer.parseInt(tabla1.getValueAt(i,9 ).toString());
    if(NProceso>0){
        jLNumeroProceso.setText(String.valueOf(NProceso));
    }
    
    
   
}

public void cargardatos(int i){
    int quantum=0;
     int val=Integer.parseInt(th.getText().trim());
   int  rafaga=Integer.parseInt(tabla1.getValueAt(i, 4).toString());
   int  nproceso=Integer.parseInt(tabla1.getValueAt(i, 0).toString());
   pro.setPrioridad(Integer.parseInt(tabla1.getValueAt(i, 2).toString()));
   if(pro.getPrioridad()==0){
       quantum=(rafaga/val);
       
   }else{
       quantum=Integer.parseInt(tabla1.getValueAt(i, 5).toString());
    
}
 
  int ejecuciones= Integer.parseInt(tabla1.getValueAt(i, 9).toString()) ;
   if(nproceso>0){
         jLNumeroProceso.setText(String.valueOf(nproceso));
   }
}
public void Insertarenlabasededatos(int i) throws FileNotFoundException{
    Proceso pro=new Proceso();
    
    pro.setPID(Integer.parseInt(tabla1.getValueAt(i, 0).toString().trim()) );
    pro.setNombre(tabla1.getValueAt(i, 1).toString());
    pro.setPrioridad(Integer.parseInt(tabla1.getValueAt(i, 2).toString().trim()));
    pro.setEstado(tabla1.getValueAt(i, 3).toString());
     pro.setRafaga(Integer.parseInt(tabla1.getValueAt(i, 4).toString().trim()));
    pro.setQuantum( Integer.parseInt(tabla1.getValueAt(i, 5).toString().trim()));
    pro.setTiempodellegada(Integer.parseInt(tabla1.getValueAt(i, 6).toString().trim()));
    pro.setTurnaround(Integer.parseInt(tabla1.getValueAt(i, 7).toString().trim()));
    pro.setTiempodefinalizacion(Integer.parseInt(tabla1.getValueAt(i, 8).toString().trim()));
    pro.setResiduoRafaga(Integer.parseInt(tabla1.getValueAt(i, 9).toString().trim()));
    pro.setCaracteres(tabla1.getValueAt(i, 10).toString().trim());
    base.insertarProceso(pro);
    
    
}

public void Ingresar(int id,String nom,String c,int valor,String mensaje){ //Ingresar proceso a la tabla
    DefaultTableModel modelo=(DefaultTableModel) tabla1.getModel();
     
     int numeros[]=new int[5];
 int aleatorio=0;
        for(int i=0;i<numeros.length;i++){
     aleatorio=numeros[i]=(int) (Math.random()*3);
        
     
         
        
         
         
      
     }
       int q=Integer.parseInt(Q.getText().trim());
       int d=Integer.parseInt(th.getText().trim());
       int  tiempofinal=q*valor;
    Contador ++;
    Object[] miTabla = new Object[11];
    miTabla[0]= id;
    miTabla[1]= nom;
    miTabla[2]= aleatorio;
    miTabla[3]= "listo";// jTFCapturaRafaga.getText();
    miTabla[4]= valor;
    miTabla[5]=Q.getText().trim();
    miTabla[6]=pro.getPID()-1;
    miTabla[7]=((tiempofinal-pro.getPID())+1)/d;
   miTabla[8]= tiempofinal;
   miTabla[9]=valor;
   miTabla[10]=mensaje;
   
    modelo.addRow(miTabla);
    tabla1.setModel(modelo);
    //jTFCapturaRafaga.setText(null);
   // jTFCapturaRafaga.grabFocus();
}

public void Informe(int c){
    DefaultTableModel modelo2 = (DefaultTableModel) jTFinal.getModel();
 Object[] miTabla = new Object[11];
      miTabla[0]= tabla1.getValueAt(c, 0);
    miTabla[1]= tabla1.getValueAt(c, 1);
    miTabla[2]= pro.getPrioridad();
    miTabla[3]="terminado";
    miTabla[4]= Rafaga;
    miTabla[5]= Quantum;
    miTabla[6]= pro.getPrioridad()-2;
    miTabla[7]= tabla1.getValueAt(c, 7);
    miTabla[8]= tabla1.getValueAt(c, 8);
    miTabla[9]= tabla1.getValueAt(c, 9);
    miTabla[10]=tabla1.getValueAt(c, 10);
    modelo2.addRow(miTabla);
    jTFinal.setModel(modelo2);
      try {
                                Insertarenlabasededatos( c);
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
    terminado.append(Capturar(c,"Terminados"));
     

    CantidadProcesos++;
    jLCantidadProcesos.setText(String.valueOf(CantidadProcesos+" Terminados"));
    jLCantidadTiempo.setText(String.valueOf(TiempoProceso+" Segundos"));
}
public Proceso Capturar(int p){
    Proceso pro=new Proceso();
    pro.setPID(Integer.parseInt(tabla1.getValueAt(p, 0).toString()));
    pro.setNombre(tabla1.getValueAt(p, 1).toString());
    pro.setQuantum(Integer.parseInt(tabla1.getValueAt(p, 5).toString()));
   pro.setEjecucion(Integer.parseInt(tabla1.getValueAt(p, 9).toString()));
   
   
   return pro;
}

public Proceso ObtenerProceso(int pid,String nombre,int Quantum,int ejecucion){
    
    pro.setPID(pid);
    pro.setNombre(nombre);
    pro.setQuantum(Quantum);
    pro.setEjecucion(ejecucion);
    return pro;
}

public void Borrar(int c){ //Elimina los registros de la tabla procesos
     tabla1.setValueAt(0,c,0);
    tabla1.setValueAt("0",c,1);
    tabla1.setValueAt("0",c,2);
    
    tabla1.setValueAt("******",c,3);
     tabla1.setValueAt("0",c,4);
}

   public void Barra(int rafaga, int residuo){ //Calcula porcentaje de la barra y su progreso
       int val=Integer.parseInt(th.getText().trim());
         int Rafaga=rafaga;
       Rafaga = rafaga/val;
       residuo = residuo / val;
        int valor = val / Rafaga;
        int porcentaje=val-(valor*residuo);
        ValorBarra=porcentaje;
        por.setText(String.valueOf(ValorBarra+"%"));
       
}

    public void Pintar(){
        jPBEstado.setValue(ValorBarra);
        jPBEstado.repaint();
    }

    public void Iniciar(){ //Inicia la secuencia de procesos
        jLabel2.setVisible(false);
       // jLabel1.setVisible(false);
       // jTFCapturaRafaga.setVisible(false);
        Q.setVisible(false);
        jBAgregar.setVisible(false);
        jBIniciar.setVisible(false);
           listo.setBackground(Color.red);
     ejecucion.setBackground(Color.YELLOW);
        terminado.setBackground(Color.ORANGE);
      //  th.setVisible(false);
          
}
    
    public void inicializargrafica(){
         jLabel2.setVisible(false);
       // jLabel1.setVisible(false);
       // jTFCapturaRafaga.setVisible(false);
        Q.setVisible(false);
        jBAgregar.setVisible(false);
        jBIniciar.setVisible(false);
       //    listo.setVisible(false);
     //ejecucion.setVisible(false);
       // terminado.setVisible(false);
        p.setVisible(false);
    }
    
    /**
     * @param args the command line arguments
     */
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Q;
    private javax.swing.JLabel Th;
    private javax.swing.JTextArea ejecucion;
    private javax.swing.JButton grafico;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBIniciar;
    private javax.swing.JTextField jLCantidadProcesos;
    private javax.swing.JTextField jLCantidadTiempo;
    private javax.swing.JTextField jLNumeroProceso;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jPBEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTFinal;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextArea listo;
    private javax.swing.JTextArea p;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField por;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextArea terminado;
    private javax.swing.JTextField th;
    // End of variables declaration//GEN-END:variables
}

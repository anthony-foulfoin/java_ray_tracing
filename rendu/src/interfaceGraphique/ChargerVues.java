package interfaceGraphique;



import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import lancerRayon.*;
import xmlParser.*;

public class ChargerVues extends javax.swing.JFrame {

    private File fichier;
    private static Scene scene;
    private List<Vue> vues;

    public ChargerVues(Scene scene_) {
        initComponents();
        FenetreChargerFichier.addChoosableFileFilter(new FiltreXML());
        FenetreChargerFichier.setAcceptAllFileFilterUsed(false);
        fichier=null;
        scene = scene_;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FenetreChargerFichier = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Charger un scene");
        setAlwaysOnTop(true);
        setResizable(false);

        FenetreChargerFichier.setCurrentDirectory(new java.io.File("/home/jbadie/1A/Java/checkout/n7bestsoftwareever/PLONG/XML"));
        FenetreChargerFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FenetreChargerFichierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FenetreChargerFichier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FenetreChargerFichier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FenetreChargerFichierActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            fichier = FenetreChargerFichier.getSelectedFile();
            vues = RayonParserReader.parserRenduXML(fichier);
            for (Iterator<Vue> i = vues.iterator();i.hasNext();){
                scene.addVue(i.next());
            }
        }
        catch(Exception e){}
        this.dispose();
    }

    public List getVues(){
        return vues;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FenetreChargerFichier;
    // End of variables declaration//GEN-END:variables

}


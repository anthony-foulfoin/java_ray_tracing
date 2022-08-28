package interfaceGraphique;


import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import lancerRayon.*;
import xmlParser.*;

public class ChargerScene extends javax.swing.JFrame {

    private File fichier;
    private static Scene scene;
    private List<Vue> vues;
    private InterfacePrincipale principale;

    public ChargerScene(InterfacePrincipale principale_) {
        initComponents();
        principale = principale_;
        FenetreChargerFichier.addChoosableFileFilter(new FiltreXML());
        FenetreChargerFichier.setAcceptAllFileFilterUsed(false);
        fichier=null;
        scene= new Scene(new Color(255, 255, 255));

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FenetreChargerFichier = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Charger un scene");
        setAlwaysOnTop(true);
        setResizable(false);

        FenetreChargerFichier.setCurrentDirectory(new java.io.File("/home/jbadie/1A/Java/ProjetJava/XML"));
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
                .addContainerGap(72, Short.MAX_VALUE))
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
            scene = RayonParserReader.parserSceneXML(fichier);
            this.dispose();
          }

          catch(Exception e){}
        try{
            fichier = FenetreChargerFichier.getSelectedFile();
            
            vues = RayonParserReader.parserRenduXML(fichier);
            for (Iterator<Vue> i = vues.iterator();i.hasNext();){
                scene.addVue(i.next());
            }
        }

        catch(Exception e){}

        final InterfaceImage sceneFenetre = new InterfaceImage(principale,scene,1);
        principale.setVisible(false);
        sceneFenetre.setVisible(true);
        sceneFenetre.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                int reponse = JOptionPane.showConfirmDialog(sceneFenetre,"Voulez-vous quitter l'application?",
                                                                          "Lancer de rayon",
                                                                          JOptionPane.YES_NO_OPTION,
                                                                          JOptionPane.QUESTION_MESSAGE);
                if (reponse==JOptionPane.YES_OPTION){
                                   sceneFenetre.dispose();
                                   System.exit(0);
                }
            }
        });
        this.dispose();
        

    }

     public static Scene getScene(){
         return scene;
     }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FenetreChargerFichier;
    // End of variables declaration//GEN-END:variables

}


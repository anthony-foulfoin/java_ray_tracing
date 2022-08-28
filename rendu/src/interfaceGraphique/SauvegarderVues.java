
package interfaceGraphique;

import java.io.File;
import java.io.FileWriter;
import lancerRayon.*;
import xmlParser.*;

public class SauvegarderVues extends javax.swing.JFrame {

    private File Fichier;
    private Scene scene;

    /** Creates new form SauvegarderScene */
    public SauvegarderVues(Scene scene_) {
        initComponents();
        fenetreSauvegarderScene.addChoosableFileFilter(new FiltreXML());
        fenetreSauvegarderScene.setAcceptAllFileFilterUsed(false);
        Fichier=null;
        fenetreSauvegarderScene.setApproveButtonText("Sauvegarder");
        scene = scene_;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fenetreSauvegarderScene = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fenetreSauvegarderScene.setCurrentDirectory(new java.io.File("/home/jbadie/1A/Java/checkout/n7bestsoftwareever/PLONG/XML"));
        fenetreSauvegarderScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fenetreSauvegarderSceneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fenetreSauvegarderScene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fenetreSauvegarderScene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fenetreSauvegarderSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fenetreSauvegarderSceneActionPerformed

            File fichier = fenetreSauvegarderScene.getSelectedFile();
            String path = fichier.getPath();
            fichier = RayonParserWriter.ecrireRenduXML(scene, path);
            String nomFichier = fichier.getName();
            System.out.println(nomFichier);

        this.dispose();
    }//GEN-LAST:event_fenetreSauvegarderSceneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fenetreSauvegarderScene;
    // End of variables declaration//GEN-END:variables

}

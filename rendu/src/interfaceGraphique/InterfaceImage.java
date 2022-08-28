package interfaceGraphique;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

import lancerRayon.*;

public class InterfaceImage extends javax.swing.JFrame {

    private InterfacePrincipale principale;
    private Scene scene;
    private javax.swing.tree.DefaultMutableTreeNode noeudScene, noeudObjet, noeudLumiere, noeudVue, noeudAmbiante;
   

    public InterfaceImage(InterfacePrincipale principale_,Scene scene_) {
        initComponents();
        principale=principale_;
        scene=scene_;
        noeudScene = new javax.swing.tree.DefaultMutableTreeNode("Scene");
        noeudObjet = new javax.swing.tree.DefaultMutableTreeNode("Objet");
        noeudScene.add(noeudObjet);
        noeudLumiere = new javax.swing.tree.DefaultMutableTreeNode("Source lumineuse");
        noeudScene.add(noeudLumiere);
        noeudVue = new javax.swing.tree.DefaultMutableTreeNode("Vue");
        noeudScene.add(noeudVue);
        noeudAmbiante = new javax.swing.tree.DefaultMutableTreeNode("Lumiere ambiante");
        noeudScene.add(noeudAmbiante);
        arbre.setModel(new javax.swing.tree.DefaultTreeModel(noeudScene));
        jScrollPane1.setViewportView(arbre);
        arbre.addTreeSelectionListener(new ArbreSelectionListener());
        BoutonEditerobjet.setEnabled(false);
        boutonSupprimer.setEnabled(false);

    }

    public InterfaceImage(InterfacePrincipale principale_,Scene scene_,int k) {

        initComponents();
        principale=principale_;
        scene=scene_;
        noeudScene = new javax.swing.tree.DefaultMutableTreeNode("Scene");
        noeudObjet = new javax.swing.tree.DefaultMutableTreeNode("Objet");
        noeudScene.add(noeudObjet);
        noeudLumiere = new javax.swing.tree.DefaultMutableTreeNode("Source lumineuse");
        noeudScene.add(noeudLumiere);
        noeudVue = new javax.swing.tree.DefaultMutableTreeNode("Vue");
        noeudScene.add(noeudVue);
        noeudAmbiante = new javax.swing.tree.DefaultMutableTreeNode("Lumiere ambiante");
        noeudScene.add(noeudAmbiante);
        arbre.setModel(new javax.swing.tree.DefaultTreeModel(noeudScene));
        jScrollPane1.setViewportView(arbre);
        arbre.addTreeSelectionListener(new ArbreSelectionListener());
        BoutonEditerobjet.setEnabled(false);
        boutonSupprimer.setEnabled(false);
        for (Iterator<Integer> it = scene.getObjetsKeys().iterator(); it.hasNext();){
            try{
            	int i = it.next();
                Object obj = scene.getObjet(i);
                String objString = obj.getClass().getSimpleName();
                if (objString.equals("Sphere")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("sphere "+ i);
                    noeudObjet.add(noeudAjouter);
                }

                if (objString.equals("Plan")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("plan   "+ i);
                    noeudObjet.add(noeudAjouter);
                }

                if (objString.equals("Cube")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("cube   "+ i);
                    noeudObjet.add(noeudAjouter);
                }
                arbre.updateUI();
            }
            catch(Exception e){e.printStackTrace();}
        }
        for (Iterator<Integer> it = scene.getLumieresKeys().iterator(); it.hasNext();){
        	int i = it.next();
            try{
                javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("source "+ i);
                noeudLumiere.add(noeudAjouter);

            }
            catch(Exception e){}
        }

        for (Iterator<Integer> it = scene.getVuesKeys().iterator(); it.hasNext();){
        	int i = it.next();
            try{
                javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("vue "+ i);
                noeudVue.add(noeudAjouter);
            }
            catch(Exception e){}
        }


        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BoutonAjouterObjet = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbre = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        BoutonEditerobjet = new javax.swing.JButton();
        BoutonVisualiser = new javax.swing.JButton();
        BoutonQuitter = new javax.swing.JButton();
        boutonSupprimer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuChargerVues = new javax.swing.JMenuItem();
        menuSauvegarderScene = new javax.swing.JMenuItem();
        menuSauvegarderVues = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Scene");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Scene", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 13), new java.awt.Color(0, 0, 255))); // NOI18N

        BoutonAjouterObjet.setText("Ajouter un objet");
        BoutonAjouterObjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAjouterObjetActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arbre.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(arbre);

        description.setColumns(20);
        description.setEditable(false);
        description.setRows(5);
        jScrollPane2.setViewportView(description);

        BoutonEditerobjet.setText("Editer l'objet");
        BoutonEditerobjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonEditerobjetActionPerformed(evt);
            }
        });

        BoutonVisualiser.setText("Visualiser");
        BoutonVisualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonVisualiserActionPerformed(evt);
            }
        });

        BoutonQuitter.setText("Quitter");
        BoutonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonQuitterActionPerformed(evt);
            }
        });

        boutonSupprimer.setText("Supprimer");
        boutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BoutonAjouterObjet)
                        .addGap(30, 30, 30)
                        .addComponent(BoutonEditerobjet)
                        .addGap(30, 30, 30)
                        .addComponent(boutonSupprimer)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BoutonVisualiser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(BoutonQuitter))
                            .addComponent(jLabel7))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BoutonAjouterObjet)
                        .addComponent(BoutonQuitter)
                        .addComponent(BoutonVisualiser)
                        .addComponent(BoutonEditerobjet)
                        .addComponent(boutonSupprimer)))
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        menuChargerVues.setText("Charger vues");
        menuChargerVues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChargerVuesActionPerformed(evt);
            }
        });
        jMenu1.add(menuChargerVues);

        menuSauvegarderScene.setText("Sauvegarder scene");
        menuSauvegarderScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSauvegarderSceneActionPerformed(evt);
            }
        });
        jMenu1.add(menuSauvegarderScene);

        menuSauvegarderVues.setText("Sauvegarder vues");
        menuSauvegarderVues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSauvegarderVuesActionPerformed(evt);
            }
        });
        jMenu1.add(menuSauvegarderVues);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    class ArbreSelectionListener implements TreeSelectionListener{

        public void valueChanged(TreeSelectionEvent e) {

            try{
                String selec1 = arbre.getSelectionPath().getPath()[1].toString();
                if (selec1.equals("Objet")){
                    String selec2 = arbre.getSelectionPath().getPath()[2].toString().substring(7);
                    Object obj = scene.getObjet(Integer.parseInt(selec2));
                    String objString = obj.getClass().getSimpleName();
                    BoutonEditerobjet.setEnabled(true);
                    boutonSupprimer.setEnabled(true);
                    if (objString.equals("Sphere")){
                        Sphere sph = (Sphere)obj;
                        description.setText("Sphere "+ selec2 +" : \n\n" +
                                "Centre : \n" +
                                "X : " + sph.getCentre().getX() + "\n" +
                                "Y : " + sph.getCentre().getY() + "\n" +
                                "Z : " + sph.getCentre().getZ() + "\n\n" +
                                "Rayon : " + sph.getRayon() + "\n\n" +
                                "Absorption composante ambiante : R : " + sph.getMatiere().getAbsAmb().getRed() + "   V : " + sph.getMatiere().getAbsAmb().getGreen() + "   B : " + sph.getMatiere().getAbsAmb().getBlue() + "\n" +
                                "Absorption composante diffuse : R : " + sph.getMatiere().getAbsDif().getRed() + "   V : " + sph.getMatiere().getAbsDif().getGreen() + "   B : " + sph.getMatiere().getAbsDif().getBlue() + "\n" +
                                "Reflectance composante speculaire : R : " + sph.getMatiere().getSpeculaire().getRed() + "   V : " + sph.getMatiere().getSpeculaire().getGreen() + "   B : " + sph.getMatiere().getSpeculaire().getBlue() + "\n" +
                                "Reflexion : R : " + sph.getMatiere().getReflection().getRed() + "   V : " + sph.getMatiere().getReflection().getGreen() + "   B : " + sph.getMatiere().getReflection().getBlue() + "\n" +
                                "Refraction : R : " + sph.getMatiere().getRefraction().getRed() + "   V : " + sph.getMatiere().getRefraction().getGreen() + "   B : " + sph.getMatiere().getRefraction().getBlue() + "\n" +
                                "Indice de refraction : " + sph.getMatiere().getIndiceRefraction() + " \n" +
                                "Brillance : " + sph.getMatiere().getBrillance());
                    }
                    if (objString.equals("Plan")){
                        Plan planInf = (Plan)obj;
                        description.setText("Plan "+ selec2 +" : \n\n" +
                                "Point 1  : \n" +
                                "X : " + planInf.getP0().getX() + "\n" +
                                "Y : " + planInf.getP0().getY() + "\n" +
                                "Z : " + planInf.getP0().getZ() + "\n" +
                                "Point 2  : \n" +
                                "X : " + planInf.getP1().getX() + "\n" +
                                "Y : " + planInf.getP1().getY() + "\n" +
                                "Z : " + planInf.getP1().getZ() + "\n" +
                                "Point 3  : \n" +
                                "X : " + planInf.getP2().getX() + "\n" +
                                "Y : " + planInf.getP2().getY() + "\n" +
                                "Z : " + planInf.getP2().getZ() + "\n\n" +
                                "Absorption composante ambiante : R : " + planInf.getMatiere().getAbsAmb().getRed() + "   V : " + planInf.getMatiere().getAbsAmb().getGreen() + "   B : " + planInf.getMatiere().getAbsAmb().getBlue() + "\n" +
                                "Absorption composante diffuse : R : " + planInf.getMatiere().getAbsDif().getRed() + "   V : " + planInf.getMatiere().getAbsDif().getGreen() + "   B : " + planInf.getMatiere().getAbsDif().getBlue() + "\n" +
                                "Reflectance composante speculaire : R : " + planInf.getMatiere().getSpeculaire().getRed() + "   V : " + planInf.getMatiere().getSpeculaire().getGreen() + "   B : " + planInf.getMatiere().getSpeculaire().getBlue() + "\n" +
                                "Reflexion : R : " + planInf.getMatiere().getReflection().getRed() + "   V : " + planInf.getMatiere().getReflection().getGreen() + "   B : " + planInf.getMatiere().getReflection().getBlue() + "\n" +
                                "Refraction : R : " + planInf.getMatiere().getRefraction().getRed() + "   V : " + planInf.getMatiere().getRefraction().getGreen() + "   B : " + planInf.getMatiere().getRefraction().getBlue() + "\n" +
                                "Indice de refraction : " + planInf.getMatiere().getIndiceRefraction() + " \n" +
                                "Brillance : " + planInf.getMatiere().getBrillance());
                    }
                    if (objString.equals("Cube")){
                        Cube cube = (Cube)obj;
                        description.setText("Plan "+ selec2 +" : \n\n" +
                                "Origine  : \n" +
                                "X : " + cube.getOrigine().getX() + "\n" +
                                "Y : " + cube.getOrigine().getY() + "\n" +
                                "Z : " + cube.getOrigine().getZ() + "\n" +
                                "Vecteur 1  : \n" +
                                "X : " + cube.getVecteur0().getX() + "\n" +
                                "Y : " + cube.getVecteur0().getY() + "\n" +
                                "Z : " + cube.getVecteur0().getZ() + "\n" +
                                "Vecteur 2  : \n" +
                                "X : " + cube.getVecteur1().getX() + "\n" +
                                "Y : " + cube.getVecteur1().getY() + "\n" +
                                "Z : " + cube.getVecteur1().getZ() + "\n" +
                                "Vecteur 3  : \n" +
                                "X : " + cube.getVecteur2().getX() + "\n" +
                                "Y : " + cube.getVecteur2().getY() + "\n" +
                                "Z : " + cube.getVecteur2().getZ() + "\n" +
                                "Absorption composante ambiante : R : " + cube.getMatiere().getAbsAmb().getRed() + "   V : " + cube.getMatiere().getAbsAmb().getGreen() + "   B : " + cube.getMatiere().getAbsAmb().getBlue() + "\n" +
                                "Absorption composante diffuse : R : " + cube.getMatiere().getAbsDif().getRed() + "   V : " + cube.getMatiere().getAbsDif().getGreen() + "   B : " + cube.getMatiere().getAbsDif().getBlue() + "\n" +
                                "Reflectance composante speculaire : R : " + cube.getMatiere().getSpeculaire().getRed() + "   V : " + cube.getMatiere().getSpeculaire().getGreen() + "   B : " + cube.getMatiere().getSpeculaire().getBlue() + "\n" +
                                "Reflexion : R : " + cube.getMatiere().getReflection().getRed() + "   V : " + cube.getMatiere().getReflection().getGreen() + "   B : " + cube.getMatiere().getReflection().getBlue() + "\n" +
                                "Refraction : R : " + cube.getMatiere().getRefraction().getRed() + "   V : " + cube.getMatiere().getRefraction().getGreen() + "   B : " + cube.getMatiere().getRefraction().getBlue() + "\n" +
                                "Indice de refraction : " + cube.getMatiere().getIndiceRefraction() + " \n" +
                                "Brillance : " + cube.getMatiere().getBrillance());
                    }
                    
                }
                if (selec1.equals("Source lumineuse")){
                    String selec2 = arbre.getSelectionPath().getPath()[2].toString().substring(7);
                    Lumiere sourceLumi = scene.getLumiere(Integer.parseInt(selec2));
                    BoutonEditerobjet.setEnabled(true);
                    boutonSupprimer.setEnabled(true);
                    description.setText("Source "+ selec2 +" : \n\n" +
                                "Origine : \n" +
                                "X : " + sourceLumi.getPosition().getX() + "\n" +
                                "Y : " + sourceLumi.getPosition().getY() + "\n" +
                                "Z : " + sourceLumi.getPosition().getZ()+ "\n\n" +
                                "Intensite : "+ "\n" +
                                "Rouge : "+ sourceLumi.getCouleur().getRed() + "\n" +
                                "Vert : "+ sourceLumi.getCouleur().getGreen() + "\n" +
                                "Bleu : "+ sourceLumi.getCouleur().getBlue());
                }
                if (selec1.equals("Vue")){
                    String selec2 = arbre.getSelectionPath().getPath()[2].toString().substring(4);
                    Vue vue = scene.getVue(Integer.parseInt(selec2));
                    BoutonEditerobjet.setEnabled(true);
                    boutonSupprimer.setEnabled(true);
                    description.setText("Vue "+ selec2 +" : \n\n" +
                                "Ecran : \n\n" +
                                "Origine : \n" +
                                "X : " + vue.getEcran().getPosition().getX() + "\n" +
                                "Y : " + vue.getEcran().getPosition().getY() + "\n" +
                                "Z : " + vue.getEcran().getPosition().getZ()+ "\n\n" +
                                "Vecteur 1 : \n" +
                                "X : " + vue.getEcran().getV1().getX() + "\n" +
                                "Y : " + vue.getEcran().getV1().getY() + "\n" +
                                "Z : " + vue.getEcran().getV1().getZ()+ "\n\n" +
                                "Vecteur 2 : \n" +
                                "X : " + vue.getEcran().getV2().getX() + "\n" +
                                "Y : " + vue.getEcran().getV2().getY() + "\n" +
                                "Z : " + vue.getEcran().getV2().getZ()+ "\n\n" +
                                "Hauteur : " + vue.getEcran().getHauteur() + "\n" +
                                "Largueur : " + vue.getEcran().getLargeur() + "\n\n" +
                                "Point de vue : "+ "\n" +
                                "X : " + vue.getPointDeVue().getPosition().getX() + "\n" +
                                "Y : " + vue.getPointDeVue().getPosition().getY() + "\n" +
                                "Z : " + vue.getPointDeVue().getPosition().getZ());

                }
                if (selec1.equals("Lumiere ambiante")){
                    BoutonEditerobjet.setEnabled(true);
                    description.setText("Lumiere ambiante : \n\n" +
                                "Intensite : \n" +
                                "R : " + scene.getLumiereAmbiante().getRed() + "\n" +
                                "V : " + scene.getLumiereAmbiante().getGreen() + "\n" +
                                "B : " + scene.getLumiereAmbiante().getBlue());

                }
                

           }
           catch(Exception exp){
               description.setText("");
               BoutonEditerobjet.setEnabled(false);
               boutonSupprimer.setEnabled(false);
           }
        }


    }

    private void BoutonAjouterObjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAjouterObjetActionPerformed
        final InterfaceObjet nouvelObjet = new InterfaceObjet(scene);
        nouvelObjet.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e){
                if (nouvelObjet.getModif().equals("sphere")){                   
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("sphere "+ nouvelObjet.getPlace());
                    noeudObjet.add(noeudAjouter);
                }
                if (nouvelObjet.getModif().equals("plan")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("plan   "+ nouvelObjet.getPlace());
                    noeudObjet.add(noeudAjouter);
                }
                if (nouvelObjet.getModif().equals("cube")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("cube   "+ nouvelObjet.getPlace());
                    noeudObjet.add(noeudAjouter);
                }
                if (nouvelObjet.getModif().equals("lumiere")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("source "+ nouvelObjet.getPlace());
                    noeudLumiere.add(noeudAjouter);
                }
                if (nouvelObjet.getModif().equals("vue")){
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("vue "+ nouvelObjet.getPlace());
                    noeudVue.add(noeudAjouter);
                }
                arbre.updateUI();
            }
        });
        nouvelObjet.setVisible(true);
}//GEN-LAST:event_BoutonAjouterObjetActionPerformed


    private void BoutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuitterActionPerformed
        this.dispose();
        principale.setVisible(true);
        return;
}//GEN-LAST:event_BoutonQuitterActionPerformed

    private void BoutonEditerobjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonEditerobjetActionPerformed
        String chemin1 = arbre.getSelectionPath().getPath()[1].toString();
        if (chemin1.equals("Lumiere ambiante")){
            final LumiereAmbiante fenetreLumiereAmbiante = new LumiereAmbiante(scene,scene.getLumiereAmbiante());
            fenetreLumiereAmbiante.setVisible(true);
            fenetreLumiereAmbiante.addWindowListener(new ListenerFenetreLumiereAmbiante(this));
        }

        if (chemin1.equals("Objet")){
            try{
                String chemin2 = arbre.getSelectionPath().getPath()[2].toString().substring(7);
                Object obj = scene.getObjet(Integer.parseInt(chemin2));
                String objString = obj.getClass().getSimpleName(); 
                
                if (objString.equals("Sphere")){
                   final InterfaceObjet editerObjet = new InterfaceObjet(scene,(Sphere)obj);
                   editerObjet.setVisible(true);
                }
                if (objString.equals("Plan")){
                   final InterfaceObjet editerObjet = new InterfaceObjet(scene,(Plan)obj);
                   editerObjet.setVisible(true);
                }
                if (objString.equals("Cube")){
                   final InterfaceObjet editerObjet = new InterfaceObjet(scene,(Cube)obj);
                   editerObjet.setVisible(true);
                }
            }
            catch(Exception e){}
        }
        if (chemin1.equals("Source lumineuse")){
            try{
                String chemin2 = arbre.getSelectionPath().getPath()[2].toString().substring(7);
                Lumiere lum = scene.getLumiere(Integer.parseInt(chemin2));
                final InterfaceObjet editerObjet = new InterfaceObjet(scene,lum);
                editerObjet.setVisible(true);
            }
            catch(Exception e){}
        }
        if (chemin1.equals("Vue")){
            try{
                String chemin2 = arbre.getSelectionPath().getPath()[2].toString().substring(4);
                Vue vu = scene.getVue(Integer.parseInt(chemin2));
                final InterfaceObjet editerObjet = new InterfaceObjet(scene,vu);
                editerObjet.setVisible(true);
            }
            catch(Exception e){}
        }

    }//GEN-LAST:event_BoutonEditerobjetActionPerformed

    private void boutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSupprimerActionPerformed
        String chemin1 = arbre.getSelectionPath().getPath()[1].toString();
        if (chemin1.equals("Objet")){
            try{

                String chemin2 = arbre.getSelectionPath().getPath()[2].toString().substring(7);
                scene.supprimerObjet(Integer.parseInt(chemin2));             
                ((DefaultTreeModel) arbre.getModel()).removeNodeFromParent((MutableTreeNode) arbre.getSelectionPath().getLastPathComponent());
            }
            catch(Exception e){}
        }
        if (chemin1.equals("Source lumineuse")){
            try{
                String chemin2 = arbre.getSelectionPath().getPath()[2].toString().substring(7);
                scene.supprimerLumiere(Integer.parseInt(chemin2));
                ((DefaultTreeModel) arbre.getModel()).removeNodeFromParent((MutableTreeNode) arbre.getSelectionPath().getLastPathComponent());
            }
            catch(Exception e){}
        }
        if (chemin1.equals("Vue")){
            try{
                String chemin2 = arbre.getSelectionPath().getPath()[2].toString().substring(4);
                scene.supprimerVue(Integer.parseInt(chemin2));
                ((DefaultTreeModel) arbre.getModel()).removeNodeFromParent((MutableTreeNode) arbre.getSelectionPath().getLastPathComponent());
            }
            catch(Exception e){}
        }

}//GEN-LAST:event_boutonSupprimerActionPerformed

    private void BoutonVisualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonVisualiserActionPerformed
        if (scene.getVuesValues().size()==0){
            JOptionPane.showMessageDialog(this,"Aucune vue dans la scène","Lancer de rayon",JOptionPane.ERROR_MESSAGE);
        }else{
            ChoixVue fenetreChoix = new ChoixVue(scene);
            fenetreChoix.setVisible(true);
        }
    }//GEN-LAST:event_BoutonVisualiserActionPerformed

    private void menuChargerVuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChargerVuesActionPerformed
        ChargerVues fenetreCharger = new ChargerVues(scene);
        fenetreCharger.setVisible(true);
        fenetreCharger.addWindowListener(new ChargementListener(fenetreCharger));

}//GEN-LAST:event_menuChargerVuesActionPerformed

    class ChargementListener extends WindowAdapter{

        private List<Vue> vues;

        ChargementListener(ChargerVues fenetreCharger){
            vues = fenetreCharger.getVues();
        }

        public void windowClosed(WindowEvent e){
        	for (Iterator<Integer> it = scene.getVuesKeys().iterator(); it.hasNext();){
                try{
                    int i = it.next();
                    DefaultTreeModel model=(DefaultTreeModel)arbre.getModel();
                    model.removeNodeFromParent( (MutableTreeNode) ((MutableTreeNode)model.getChild(model.getRoot(), 2)).getChildAt(0));
                }
                catch(Exception exp){}
            }
        	for (Iterator<Integer> it = scene.getVuesKeys().iterator(); it.hasNext();){
        		int i = it.next();
                try{
                    javax.swing.tree.DefaultMutableTreeNode noeudAjouter = new javax.swing.tree.DefaultMutableTreeNode("vue "+ i);
                    noeudVue.add(noeudAjouter);
                }
                catch(Exception ex){}
            }
        arbre.updateUI();
        }
    }

    private void menuSauvegarderSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSauvegarderSceneActionPerformed
        SauvegarderScene fenetreSauve = new SauvegarderScene(scene);
        fenetreSauve.setVisible(true);
}//GEN-LAST:event_menuSauvegarderSceneActionPerformed

    private void menuSauvegarderVuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSauvegarderVuesActionPerformed
        SauvegarderVues fenetreSauve = new SauvegarderVues(scene);
        fenetreSauve.setVisible(true);
    }//GEN-LAST:event_menuSauvegarderVuesActionPerformed

    class ListenerFenetreLumiereAmbiante extends WindowAdapter{

        private InterfaceImage FenetreCourante;

        public ListenerFenetreLumiereAmbiante(InterfaceImage Fenetre){
            FenetreCourante = Fenetre;
        }

        public void windowOpened(WindowEvent e) {
            FenetreCourante.setEnabled(false);
        }

        public void windowClosed(WindowEvent e) {
            FenetreCourante.setEnabled(true);
        }
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAjouterObjet;
    private javax.swing.JButton BoutonEditerobjet;
    private javax.swing.JButton BoutonQuitter;
    private javax.swing.JButton BoutonVisualiser;
    private javax.swing.JTree arbre;
    private javax.swing.JButton boutonSupprimer;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menuChargerVues;
    private javax.swing.JMenuItem menuSauvegarderScene;
    private javax.swing.JMenuItem menuSauvegarderVues;
    // End of variables declaration//GEN-END:variables

}

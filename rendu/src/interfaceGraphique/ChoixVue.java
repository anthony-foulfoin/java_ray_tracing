package interfaceGraphique;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.swing.*;

import basicTest.BasicTest.PixelDemo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import lancerRayon.*;
import util.PPM;


public class ChoixVue extends javax.swing.JFrame {

    private Scene scene;


    public ChoixVue(Scene scene_) {
        initComponents();
        scene = scene_;

        for (Iterator<Integer> it = scene.getVuesKeys().iterator(); it.hasNext();) {

                choix.addItem("Vue "+ it.next());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        choix = new javax.swing.JComboBox();
        boutonValider = new javax.swing.JButton();
        boutonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Choix de la vue :");

        boutonValider.setText("Visualiser");
        boutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonValiderActionPerformed(evt);
            }
        });

        boutonAnnuler.setText("Annuler");
        boutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAnnulerActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(boutonValider)
                        .addGap(18, 18, 18)
                        .addComponent(boutonAnnuler)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(choix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonValider)
                    .addComponent(boutonAnnuler))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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

    private void boutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAnnulerActionPerformed
        this.dispose();
}//GEN-LAST:event_boutonAnnulerActionPerformed

    private void boutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonValiderActionPerformed
        final int selec = Integer.valueOf(choix.getSelectedItem().toString().substring(4));

        BufferedImage bf2 = scene.getVue(selec).getBufferedImage();
        JFrame frame = new Affichage(bf2,selec);
        frame.setResizable(false);
        JMenuBar menu = new JMenuBar();
        JMenu menu1 = new JMenu("Sauvegarde");
        JMenuItem item1 = new JMenuItem("Sauvegarder sous format PPM");
        item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSauverPPMActionPerformed(evt,selec);
            }
        });
        menu1.add(item1);
        menu.add(menu1);
        frame.setJMenuBar(menu);
        scene.mettreAJourRendu(selec, frame);
        ChoixVue.this.dispose();
        
    }//GEN-LAST:event_boutonValiderActionPerformed

    private void menuSauverPPMActionPerformed(java.awt.event.ActionEvent evt,final int selec){
        final SauvegarderPPM fenetrePPM = new SauvegarderPPM();
        fenetrePPM.setVisible(true);
        fenetrePPM.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e){
                String nom = fenetrePPM.getNom();
                 PPM ppm = new PPM(scene.getVue(selec).getBufferedImage());
            try {
            	ppm.write(nom);
                System.out.println("Fichier Sauvergardé");

            } catch (IOException ex) {ex.printStackTrace();}
            }
        });
       

    }




    public class Affichage extends JFrame {
		private Container c;
        private JPanel panel;
		private int numero;

		public Affichage(BufferedImage img,int i) {
			this.initialize(img);
			this.pack();
			this.setVisible(true);
			numero = i;
		}

        public JPanel getPanel(){
            return panel;
        }

		private void initialize(BufferedImage img) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			c = getContentPane();
			panel = new AffichagePanel(img);
			panel.setPreferredSize(new Dimension(scene.getVue(numero).getEcran().getHauteur(), scene.getVue(numero).getEcran().getLargeur()));
			c.add(panel);
            
		}

		class AffichagePanel extends JPanel {
			private BufferedImage img;

			public AffichagePanel(BufferedImage img) {
				super();
				this.initialize(img);
			}

			private void initialize(BufferedImage imag) {
				img = imag;
			}

			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
		}
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonAnnuler;
    private javax.swing.JButton boutonValider;
    private javax.swing.JComboBox choix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}

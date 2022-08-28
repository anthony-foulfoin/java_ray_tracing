package interfaceGraphique;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lancerRayon.*;
import lancerRayon.Matiere;
import util.*;

public class InterfaceObjet extends javax.swing.JFrame {

    private Scene scene;
    private BufferedImage imageApercu;
    private String modif;
    private int place;
    private Sphere sphere;
    private Plan plan;
    private Cube cube;
    private Lumiere lumiere;
    private Vue vue;

    /** Creates new form InterfaceObjet */
    public InterfaceObjet(Scene scene_) {
        scene=scene_;
        initComponents();
        imageApercu=new BufferedImage(30,30,1);
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                imageApercu.setRGB(i, j,jSliderB.getValue()+256*jSliderV.getValue()+256*256*jSliderR.getValue());
            }
        }
        ImageIcon iconApercu=new ImageIcon(imageApercu);
        apercu.setIcon(iconApercu);
        jSliderB.addChangeListener(new ActionChangementB());
        jSliderV.addChangeListener(new ActionChangementV());
        jSliderR.addChangeListener(new ActionChangementR());
        modif="rien";
    }

    public InterfaceObjet(Scene scene_,Sphere sphere_) {
        scene=scene_;
        initComponents();
        for (int i = 1; i < 5; i++) {
            this.getOnglets().setEnabledAt(i, false);
        }
        this.setTitle("Modifier un objet");
        ajouterSphere.setText("Modifier");
        sphere = sphere_;
        this.getOnglets().setSelectedIndex(0);
        centreX.setText(String.valueOf(sphere.getCentre().getX()));
        centreY.setText(String.valueOf(sphere.getCentre().getY()));
        centreZ.setText(String.valueOf(sphere.getCentre().getZ()));
        rayon.setText(String.valueOf(sphere.getRayon()));
        ambsR.setText(String.valueOf(sphere.getMatiere().getAbsAmb().getRed()));
        ambsV.setText(String.valueOf(sphere.getMatiere().getAbsAmb().getGreen()));
        ambsB.setText(String.valueOf(sphere.getMatiere().getAbsAmb().getBlue()));
        difsR.setText(String.valueOf(sphere.getMatiere().getAbsDif().getRed()));
        difsV.setText(String.valueOf(sphere.getMatiere().getAbsDif().getGreen()));
        difsB.setText(String.valueOf(sphere.getMatiere().getAbsDif().getBlue()));
        spesR.setText(String.valueOf(sphere.getMatiere().getSpeculaire().getRed()));
        spesV.setText(String.valueOf(sphere.getMatiere().getSpeculaire().getGreen()));
        spesB.setText(String.valueOf(sphere.getMatiere().getSpeculaire().getBlue()));
        flxsR.setText(String.valueOf(sphere.getMatiere().getReflection().getRed()));
        flxsV.setText(String.valueOf(sphere.getMatiere().getReflection().getGreen()));
        flxsB.setText(String.valueOf(sphere.getMatiere().getReflection().getBlue()));
        frasR.setText(String.valueOf(sphere.getMatiere().getRefraction().getRed()));
        frasV.setText(String.valueOf(sphere.getMatiere().getRefraction().getGreen()));
        frasB.setText(String.valueOf(sphere.getMatiere().getRefraction().getBlue()));
        indices.setText(String.valueOf(sphere.getMatiere().getIndiceRefraction()));
        brillances.setText(String.valueOf(sphere.getMatiere().getBrillance()));

    }

    public InterfaceObjet(Scene scene_,Plan plan_) {
        scene=scene_;
        initComponents();
        this.getOnglets().setEnabledAt(0, false);
        for (int i = 2; i < 5; i++) {
            this.getOnglets().setEnabledAt(i, false);
        }
        this.setTitle("Modifier un objet");
        ajouterPlan.setText("Modifier");
        plan = plan_;
        this.getOnglets().setSelectedIndex(1);
        p1pX.setText(String.valueOf(plan.getP0().getX()));
        p1pY.setText(String.valueOf(plan.getP0().getY()));
        p1pZ.setText(String.valueOf(plan.getP0().getZ()));
        p2pX.setText(String.valueOf(plan.getP1().getX()));
        p2pY.setText(String.valueOf(plan.getP1().getY()));
        p2pZ.setText(String.valueOf(plan.getP1().getZ()));
        p3pX.setText(String.valueOf(plan.getP2().getX()));
        p3pY.setText(String.valueOf(plan.getP2().getY()));
        p3pZ.setText(String.valueOf(plan.getP2().getZ()));
        ambpR.setText(String.valueOf(plan.getMatiere().getAbsAmb().getRed()));
        ambpV.setText(String.valueOf(plan.getMatiere().getAbsAmb().getGreen()));
        ambpB.setText(String.valueOf(plan.getMatiere().getAbsAmb().getBlue()));
        difpR.setText(String.valueOf(plan.getMatiere().getAbsDif().getRed()));
        difpV.setText(String.valueOf(plan.getMatiere().getAbsDif().getGreen()));
        difpB.setText(String.valueOf(plan.getMatiere().getAbsDif().getBlue()));
        spepR.setText(String.valueOf(plan.getMatiere().getSpeculaire().getRed()));
        spepV.setText(String.valueOf(plan.getMatiere().getSpeculaire().getGreen()));
        spepB.setText(String.valueOf(plan.getMatiere().getSpeculaire().getBlue()));
        flxpR.setText(String.valueOf(plan.getMatiere().getReflection().getRed()));
        flxpV.setText(String.valueOf(plan.getMatiere().getReflection().getGreen()));
        flxpB.setText(String.valueOf(plan.getMatiere().getReflection().getBlue()));
        frapR.setText(String.valueOf(plan.getMatiere().getRefraction().getRed()));
        frapV.setText(String.valueOf(plan.getMatiere().getRefraction().getGreen()));
        frapB.setText(String.valueOf(plan.getMatiere().getRefraction().getBlue()));
        indicep.setText(String.valueOf(plan.getMatiere().getIndiceRefraction()));
        brillancep.setText(String.valueOf(plan.getMatiere().getBrillance()));

    }

    public InterfaceObjet(Scene scene_, Cube cube_) {
        scene=scene_;
        initComponents();
        for (int i = 0; i < 5; i++) {
            this.getOnglets().setEnabledAt(i, false);
        }
        this.getOnglets().setEnabledAt(2, true);
        this.setTitle("Modifier un objet");
        ajouterCube.setText("Modifier");
        cube = cube_;
        this.getOnglets().setSelectedIndex(2);
        oricX.setText(String.valueOf(cube.getOrigine().getX()));
        oricY.setText(String.valueOf(cube.getOrigine().getY()));
        oricZ.setText(String.valueOf(cube.getOrigine().getZ()));
        vect1cX.setText(String.valueOf(cube.getVecteur0().getX()));
        vect1cY.setText(String.valueOf(cube.getVecteur0().getY()));
        vect1cZ.setText(String.valueOf(cube.getVecteur0().getZ()));
        vect2cX.setText(String.valueOf(cube.getVecteur1().getX()));
        vect2cY.setText(String.valueOf(cube.getVecteur1().getY()));
        vect2cZ.setText(String.valueOf(cube.getVecteur1().getZ()));
        vect3cX.setText(String.valueOf(cube.getVecteur2().getX()));
        vect3cY.setText(String.valueOf(cube.getVecteur2().getY()));
        vect3cZ.setText(String.valueOf(cube.getVecteur2().getZ()));
        ambcR.setText(String.valueOf(cube.getMatiere().getAbsAmb().getRed()));
        ambcV.setText(String.valueOf(cube.getMatiere().getAbsAmb().getGreen()));
        ambcB.setText(String.valueOf(cube.getMatiere().getAbsAmb().getBlue()));
        difcR.setText(String.valueOf(cube.getMatiere().getAbsDif().getRed()));
        difcV.setText(String.valueOf(cube.getMatiere().getAbsDif().getGreen()));
        difcB.setText(String.valueOf(cube.getMatiere().getAbsDif().getBlue()));
        specR.setText(String.valueOf(cube.getMatiere().getSpeculaire().getRed()));
        specV.setText(String.valueOf(cube.getMatiere().getSpeculaire().getGreen()));
        specB.setText(String.valueOf(cube.getMatiere().getSpeculaire().getBlue()));
        flxcR.setText(String.valueOf(cube.getMatiere().getReflection().getRed()));
        flxcV.setText(String.valueOf(cube.getMatiere().getReflection().getGreen()));
        flxcB.setText(String.valueOf(cube.getMatiere().getReflection().getBlue()));
        fracR.setText(String.valueOf(cube.getMatiere().getRefraction().getRed()));
        fracV.setText(String.valueOf(cube.getMatiere().getRefraction().getGreen()));
        fracB.setText(String.valueOf(cube.getMatiere().getRefraction().getBlue()));
        indicec.setText(String.valueOf(cube.getMatiere().getIndiceRefraction()));
        brillancec.setText(String.valueOf(cube.getMatiere().getBrillance()));
    }

    InterfaceObjet(Scene scene, Lumiere lumiere_) {
        initComponents();
        this.getOnglets().setEnabledAt(0, false);
        for (int i = 0; i < 5; i++) {
            this.getOnglets().setEnabledAt(i, false);
        }
        this.getOnglets().setEnabledAt(3, true);
        this.setTitle("Modifier un objet");
        ajouterLumiere.setText("Modifier");
        imageApercu=new BufferedImage(30,30,1);
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                imageApercu.setRGB(i, j,jSliderB.getValue()+256*jSliderV.getValue()+256*256*jSliderR.getValue());
            }
        }
        ImageIcon iconApercu=new ImageIcon(imageApercu);
        apercu.setIcon(iconApercu);
        jSliderB.addChangeListener(new ActionChangementB());
        jSliderV.addChangeListener(new ActionChangementV());
        jSliderR.addChangeListener(new ActionChangementR());
        lumiere = lumiere_;
        this.getOnglets().setSelectedIndex(3);
        jSliderR.setValue(lumiere.getCouleur().getRed());
        jSliderV.setValue(lumiere.getCouleur().getGreen());
        jSliderB.setValue(lumiere.getCouleur().getBlue());
        posX.setText(String.valueOf(lumiere.getPosition().getX()));
        posY.setText(String.valueOf(lumiere.getPosition().getY()));
        posZ.setText(String.valueOf(lumiere.getPosition().getZ()));
    }

    InterfaceObjet(Scene scene, Vue vue_) {
        initComponents();
        for (int i = 0; i < 5; i++) {
            this.getOnglets().setEnabledAt(i, false);
        }
        this.getOnglets().setEnabledAt(4, true);
        this.setTitle("Modifier un objet");
        ajouterVue.setText("Modifier");
        vue = vue_;
        this.getOnglets().setSelectedIndex(4);
        oriX.setText(String.valueOf(vue.getEcran().getPosition().getX()));
        oriY.setText(String.valueOf(vue.getEcran().getPosition().getY()));
        oriZ.setText(String.valueOf(vue.getEcran().getPosition().getZ()));
        vect1X.setText(String.valueOf(vue.getEcran().getV1().getX()));
        vect1Y.setText(String.valueOf(vue.getEcran().getV1().getY()));
        vect1Z.setText(String.valueOf(vue.getEcran().getV1().getZ()));
        vect2X.setText(String.valueOf(vue.getEcran().getV2().getX()));
        vect2Y.setText(String.valueOf(vue.getEcran().getV2().getY()));
        vect2Z.setText(String.valueOf(vue.getEcran().getV2().getZ()));
        hauteur.setText(String.valueOf(vue.getEcran().getHauteur()));
        largeur.setText(String.valueOf(vue.getEcran().getLargeur()));
        pdvX.setText(String.valueOf(vue.getPointDeVue().getPosition().getX()));
        pdvY.setText(String.valueOf(vue.getPointDeVue().getPosition().getY()));
        pdvZ.setText(String.valueOf(vue.getPointDeVue().getPosition().getZ()));
    }

    class ActionChangementB implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            BufferedImage imageApercu=new BufferedImage(30,30,1);
            for(int i=0;i<30;i++){
                for(int j=0;j<30;j++){
                    imageApercu.setRGB(i, j,jSliderB.getValue()+256*jSliderV.getValue()+256*256*jSliderR.getValue());
                }
            }
            ImageIcon iconApercu=new ImageIcon(imageApercu);
            apercu.setIcon(iconApercu);
        }

	}

    class ActionChangementV implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            BufferedImage imageApercu=new BufferedImage(30,30,1);
            for(int i=0;i<30;i++){
                for(int j=0;j<30;j++){
                    imageApercu.setRGB(i, j,jSliderB.getValue()+256*jSliderV.getValue()+256*256*jSliderR.getValue());
                }
            }
            ImageIcon iconApercu=new ImageIcon(imageApercu);
            apercu.setIcon(iconApercu);
        }
	}

    class ActionChangementR implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            BufferedImage imageApercu=new BufferedImage(30,30,1);
            for(int i=0;i<30;i++){
                for(int j=0;j<30;j++){
                    imageApercu.setRGB(i, j,jSliderB.getValue()+256*jSliderV.getValue()+256*256*jSliderR.getValue());
                }
            }
            ImageIcon iconApercu=new ImageIcon(imageApercu);
            apercu.setIcon(iconApercu);
        }
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        LabelApercu = new javax.swing.JLabel();
        TabOnglet = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        centreY = new javax.swing.JTextField();
        centreX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        centreZ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rayon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        ambsR = new javax.swing.JTextField();
        difsR = new javax.swing.JTextField();
        spesR = new javax.swing.JTextField();
        frasR = new javax.swing.JTextField();
        flxsR = new javax.swing.JTextField();
        indices = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        ambsV = new javax.swing.JTextField();
        difsV = new javax.swing.JTextField();
        spesV = new javax.swing.JTextField();
        flxsV = new javax.swing.JTextField();
        frasV = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        difsB = new javax.swing.JTextField();
        ambsB = new javax.swing.JTextField();
        spesB = new javax.swing.JTextField();
        flxsB = new javax.swing.JTextField();
        frasB = new javax.swing.JTextField();
        ajouterSphere = new javax.swing.JButton();
        BoutonAnnuler1 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        brillances = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ajouterPlan = new javax.swing.JButton();
        BoutonAnnuler2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        p1pX = new javax.swing.JTextField();
        p1pY = new javax.swing.JTextField();
        p1pZ = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        p2pX = new javax.swing.JTextField();
        p2pY = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        p2pZ = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        p3pY = new javax.swing.JTextField();
        p3pX = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        p3pZ = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        brillancep = new javax.swing.JTextField();
        ambpR = new javax.swing.JTextField();
        difpR = new javax.swing.JTextField();
        spepR = new javax.swing.JTextField();
        frapR = new javax.swing.JTextField();
        flxpR = new javax.swing.JTextField();
        indicep = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        ambpV = new javax.swing.JTextField();
        difpV = new javax.swing.JTextField();
        spepV = new javax.swing.JTextField();
        flxpV = new javax.swing.JTextField();
        frapV = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        difpB = new javax.swing.JTextField();
        ambpB = new javax.swing.JTextField();
        spepB = new javax.swing.JTextField();
        flxpB = new javax.swing.JTextField();
        frapB = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        ajouterCube = new javax.swing.JButton();
        BoutonAnnuler3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        oricY = new javax.swing.JTextField();
        oricX = new javax.swing.JTextField();
        oricZ = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        vect1cY = new javax.swing.JTextField();
        vect1cX = new javax.swing.JTextField();
        vect1cZ = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        vect2cY = new javax.swing.JTextField();
        vect2cX = new javax.swing.JTextField();
        vect2cZ = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        vect3cY = new javax.swing.JTextField();
        vect3cX = new javax.swing.JTextField();
        vect3cZ = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        brillancec = new javax.swing.JTextField();
        indicec = new javax.swing.JTextField();
        fracR = new javax.swing.JTextField();
        flxcR = new javax.swing.JTextField();
        specR = new javax.swing.JTextField();
        difcR = new javax.swing.JTextField();
        ambcR = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        fracV = new javax.swing.JTextField();
        flxcV = new javax.swing.JTextField();
        specV = new javax.swing.JTextField();
        difcV = new javax.swing.JTextField();
        ambcV = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        specB = new javax.swing.JTextField();
        difcB = new javax.swing.JTextField();
        ambcB = new javax.swing.JTextField();
        flxcB = new javax.swing.JTextField();
        fracB = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        posZ = new javax.swing.JTextField();
        posY = new javax.swing.JTextField();
        posX = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSliderR = new javax.swing.JSlider();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSliderV = new javax.swing.JSlider();
        jSliderB = new javax.swing.JSlider();
        jLabel35 = new javax.swing.JLabel();
        ajouterLumiere = new javax.swing.JButton();
        AnnulerLumiere = new javax.swing.JButton();
        ValeurR = new javax.swing.JLabel();
        ValeurV = new javax.swing.JLabel();
        ValeurB = new javax.swing.JLabel();
        apercu = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        oriY = new javax.swing.JTextField();
        oriX = new javax.swing.JTextField();
        oriZ = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        vect1Y = new javax.swing.JTextField();
        vect1X = new javax.swing.JTextField();
        vect1Z = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        vect2Y = new javax.swing.JTextField();
        vect2X = new javax.swing.JTextField();
        vect2Z = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        hauteur = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        largeur = new javax.swing.JTextField();
        ajouterVue = new javax.swing.JButton();
        AnnulerVue = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        pdvY = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        pdvX = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        pdvZ = new javax.swing.JTextField();

        jLabel21.setText("Coordonnees du centre : ");
        jPanel7.add(jLabel21);

        jLabel22.setText("X :");
        jPanel7.add(jLabel22);
        jPanel7.add(jTextField13);
        jPanel7.add(jTextField14);

        jLabel23.setText("Y :");
        jPanel7.add(jLabel23);

        jLabel24.setText("Z :");
        jPanel7.add(jLabel24);
        jPanel7.add(jTextField15);

        jLabel25.setText("Rayon : ");
        jPanel7.add(jLabel25);
        jPanel7.add(jTextField26);

        jLabel26.setText("Absorption : ");
        jPanel7.add(jLabel26);
        jPanel7.add(jTextField16);

        jLabel27.setText("Reflexion : ");
        jPanel7.add(jLabel27);
        jPanel7.add(jTextField17);

        jLabel28.setText("Refraction : ");
        jPanel7.add(jLabel28);
        jPanel7.add(jTextField18);

        jButton5.setText("Ajouter");
        jPanel7.add(jButton5);

        jButton6.setText("Annuler");
        jPanel7.add(jButton6);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajout d'un objet");

        TabOnglet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajout d'un objet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 13), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setText("X :");

        centreY.setText("0.0");

        centreX.setText("0.0");

        jLabel3.setText("Y :");

        jLabel4.setText("Z :");

        centreZ.setText("0.0");

        jLabel6.setText("Rayon : ");

        rayon.setText("0.0");

        jLabel1.setText("Coordonnees du centre : ");

        jLabel51.setText("Absorption composante ambiante : ");

        jLabel52.setText("R :");

        jLabel53.setText("Absorption composante diffuse :");

        jLabel54.setText("R :");

        jLabel55.setText("Reflectance composante speculaire : ");

        jLabel56.setText("R :");

        jLabel57.setText("Reflexion : ");

        jLabel58.setText("R :");

        jLabel59.setText("Refraction : ");

        jLabel60.setText("R :");

        jLabel61.setText("Indice de refraction :");

        ambsR.setText("0");

        difsR.setText("0");

        spesR.setText("0");

        frasR.setText("0");

        flxsR.setText("0");

        indices.setText("0.0");

        jLabel62.setText("V : ");

        jLabel63.setText("V : ");

        jLabel64.setText("V : ");

        jLabel65.setText("V : ");

        jLabel66.setText("V : ");

        ambsV.setText("0");

        difsV.setText("0");

        spesV.setText("0");

        flxsV.setText("0");

        frasV.setText("0");

        jLabel67.setText("B :");

        jLabel68.setText("B :");

        jLabel69.setText("B :");

        jLabel70.setText("B :");

        jLabel71.setText("B :");

        difsB.setText("0");

        ambsB.setText("0");

        spesB.setText("0");

        flxsB.setText("0");

        frasB.setText("0");

        ajouterSphere.setText("Ajouter");
        ajouterSphere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterSphereActionPerformed(evt);
            }
        });

        BoutonAnnuler1.setText("Annuler");
        BoutonAnnuler1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnuler1ActionPerformed(evt);
            }
        });

        jLabel72.setText("Brillance :");

        brillances.setText("0.0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(centreY)
                                    .addComponent(centreZ, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                    .addComponent(centreX, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(48, 48, 48)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rayon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ajouterSphere)
                        .addGap(18, 18, 18)
                        .addComponent(BoutonAnnuler1)
                        .addGap(307, 307, 307))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60))
                            .addComponent(jLabel61)
                            .addComponent(jLabel72))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brillances, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ambsR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(difsR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(spesR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(frasR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(flxsR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(indices, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ambsV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(difsV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spesV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flxsV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frasV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(difsB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ambsB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spesB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flxsB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frasB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ambsB, ambsR, ambsV, brillances, centreX, centreY, centreZ, difsB, difsR, difsV, flxsB, flxsR, flxsV, frasB, frasR, frasV, indices, rayon, spesB, spesR, spesV});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel51, jLabel53, jLabel55, jLabel57, jLabel59, jLabel61, jLabel72});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(centreX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(rayon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(centreY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(centreZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(ambsR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel65)
                    .addComponent(ambsV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(ambsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(difsR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53)
                    .addComponent(jLabel64)
                    .addComponent(difsV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(difsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(spesR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel66)
                    .addComponent(spesV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(spesB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(flxsR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(flxsV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(flxsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(frasR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel63)
                    .addComponent(frasV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71)
                    .addComponent(frasB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(indices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(brillances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterSphere)
                    .addComponent(BoutonAnnuler1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        TabOnglet.addTab("Sphere", jPanel1);

        ajouterPlan.setText("Ajouter");
        ajouterPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterPlanActionPerformed(evt);
            }
        });

        BoutonAnnuler2.setText("Annuler");
        BoutonAnnuler2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnuler2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Coordonnees : Point 1 : ");

        jLabel10.setText("X :");

        p1pX.setText("0.0");

        p1pY.setText("0.0");

        p1pZ.setText("0.0");

        jLabel11.setText("Z :");

        jLabel12.setText("Y :");

        jLabel13.setText("Point 2 : ");

        jLabel14.setText("X :");

        p2pX.setText("0.0");

        p2pY.setText("0.0");

        jLabel16.setText("Y :");

        jLabel17.setText("Z :");

        p2pZ.setText("0.0");

        jLabel20.setText("Point 3 : ");

        jLabel31.setText("X :");

        jLabel32.setText("Y :");

        p3pY.setText("0.0");

        p3pX.setText("0.0");

        jLabel33.setText("Z :");

        p3pZ.setText("0.0");

        jLabel110.setText("Absorption composante ambiante : ");

        jLabel111.setText("R :");

        jLabel112.setText("Absorption composante diffuse :");

        jLabel113.setText("R :");

        jLabel114.setText("Reflectance composante speculaire : ");

        jLabel115.setText("R :");

        jLabel116.setText("Reflexion : ");

        jLabel117.setText("R :");

        jLabel118.setText("Refraction : ");

        jLabel119.setText("R :");

        jLabel120.setText("Indice de refraction :");

        jLabel121.setText("Brillance :");

        brillancep.setText("0.0");

        ambpR.setText("0");

        difpR.setText("0");

        spepR.setText("0");

        frapR.setText("0");

        flxpR.setText("0");

        indicep.setText("0.0");

        jLabel122.setText("V : ");

        jLabel123.setText("V : ");

        jLabel124.setText("V : ");

        jLabel125.setText("V : ");

        jLabel126.setText("V : ");

        ambpV.setText("0");

        difpV.setText("0");

        spepV.setText("0");

        flxpV.setText("0");

        frapV.setText("0");

        jLabel127.setText("B :");

        jLabel128.setText("B :");

        jLabel129.setText("B :");

        jLabel130.setText("B :");

        jLabel131.setText("B :");

        difpB.setText("0");

        ambpB.setText("0");

        spepB.setText("0");

        flxpB.setText("0");

        frapB.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p1pY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p1pX, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(p1pZ, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)))
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(p2pY, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(p2pX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(p2pZ, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel33)
                        .addComponent(jLabel32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p3pY, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(p3pX, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(p3pZ, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel112)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel113))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel119))
                    .addComponent(jLabel120)
                    .addComponent(jLabel121))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(brillancep)
                    .addComponent(indicep)
                    .addComponent(frapR)
                    .addComponent(flxpR)
                    .addComponent(spepR)
                    .addComponent(difpR)
                    .addComponent(ambpR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel122)
                        .addComponent(jLabel123)
                        .addComponent(jLabel124)
                        .addComponent(jLabel126))
                    .addComponent(jLabel125))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(frapV)
                    .addComponent(flxpV)
                    .addComponent(spepV)
                    .addComponent(difpV)
                    .addComponent(ambpV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127)
                    .addComponent(jLabel128)
                    .addComponent(jLabel129)
                    .addComponent(jLabel130)
                    .addComponent(jLabel131))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spepB)
                    .addComponent(difpB)
                    .addComponent(ambpB, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(flxpB, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(frapB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajouterPlan)
                .addGap(18, 18, 18)
                .addComponent(BoutonAnnuler2)
                .addContainerGap(573, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ambpB, ambpR, ambpV, brillancep, difpB, difpR, difpV, flxpB, flxpR, flxpV, frapB, frapR, frapV, indicep, p1pX, p1pY, p1pZ, p2pX, p2pY, p2pZ, p3pX, p3pY, p3pZ, spepB, spepR, spepV});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel110, jLabel112, jLabel114, jLabel116, jLabel118, jLabel120, jLabel121});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(p2pX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel31)
                    .addComponent(p3pX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(p1pX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(p2pY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(p3pY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32))
                            .addComponent(p1pY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(p1pZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p2pZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(p3pZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110)
                            .addComponent(ambpR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel111))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(difpR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel113)
                            .addComponent(jLabel112))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(spepR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel115))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel116)
                            .addComponent(jLabel117)
                            .addComponent(flxpR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel118)
                            .addComponent(frapR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel120)
                            .addComponent(indicep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel121)
                            .addComponent(brillancep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ambpV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel125))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124)
                            .addComponent(difpV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(spepV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel122)
                            .addComponent(flxpV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel123)
                            .addComponent(frapV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127)
                            .addComponent(ambpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel128)
                            .addComponent(difpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel129)
                            .addComponent(spepB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(flxpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(frapB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterPlan)
                    .addComponent(BoutonAnnuler2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        TabOnglet.addTab("Plan infini", jPanel2);

        ajouterCube.setText("Ajouter");
        ajouterCube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterCubeActionPerformed(evt);
            }
        });

        BoutonAnnuler3.setText("Annuler");
        BoutonAnnuler3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnuler3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Coordonnees : Origine : ");

        jLabel95.setText("X :");

        jLabel96.setText("Y :");

        jLabel97.setText("Z :");

        oricY.setText("0.0");

        oricX.setText("0.0");

        oricZ.setText("0.0");

        jLabel98.setText("Vecteur 1 : ");

        jLabel99.setText("Y :");

        jLabel100.setText("X :");

        jLabel101.setText("Z :");

        vect1cY.setText("0.0");

        vect1cX.setText("0.0");

        vect1cZ.setText("0.0");

        jLabel102.setText("Vecteur 2: ");

        jLabel103.setText("X :");

        jLabel104.setText("Z :");

        jLabel105.setText("Y :");

        vect2cY.setText("0.0");

        vect2cX.setText("0.0");

        vect2cZ.setText("0.0");

        jLabel106.setText("Vecteur 3 : ");

        jLabel107.setText("X :");

        jLabel108.setText("Z :");

        jLabel109.setText("Y :");

        vect3cY.setText("0.0");

        vect3cX.setText("0.0");

        vect3cZ.setText("0.0");

        jLabel132.setText("Absorption composante ambiante : ");

        jLabel133.setText("R :");

        jLabel134.setText("Absorption composante diffuse :");

        jLabel135.setText("R :");

        jLabel136.setText("Reflectance composante speculaire : ");

        jLabel137.setText("R :");

        jLabel138.setText("Reflexion : ");

        jLabel139.setText("R :");

        jLabel140.setText("Refraction : ");

        jLabel141.setText("R :");

        jLabel142.setText("Indice de refraction :");

        jLabel143.setText("Brillance :");

        brillancec.setText("0.0");

        indicec.setText("0.0");

        fracR.setText("0");

        flxcR.setText("0");

        specR.setText("0");

        difcR.setText("0");

        ambcR.setText("0");

        jLabel144.setText("V : ");

        jLabel145.setText("V : ");

        jLabel146.setText("V : ");

        jLabel147.setText("V : ");

        jLabel148.setText("V : ");

        fracV.setText("0");

        flxcV.setText("0");

        specV.setText("0");

        difcV.setText("0");

        ambcV.setText("0");

        jLabel149.setText("B :");

        jLabel150.setText("B :");

        jLabel151.setText("B :");

        jLabel152.setText("B :");

        jLabel153.setText("B :");

        specB.setText("0");

        difcB.setText("0");

        ambcB.setText("0");

        flxcB.setText("0");

        fracB.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel95))
                            .addComponent(jLabel96)
                            .addComponent(jLabel97))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oricZ, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(oricY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(oricX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel99)
                                    .addComponent(jLabel100)))
                            .addComponent(jLabel101))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vect1cZ, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(vect1cY, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(vect1cX, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel102)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel103))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel104)
                                .addComponent(jLabel105)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vect2cY, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(vect2cX, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(vect2cZ, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel106)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel107))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel108)
                                .addComponent(jLabel109)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(vect3cY, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addComponent(vect3cX, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                            .addComponent(vect3cZ, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(ajouterCube)
                        .addGap(18, 18, 18)
                        .addComponent(BoutonAnnuler3)
                        .addContainerGap(692, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel132)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel133))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel134)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel135))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel136)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel137))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel138)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel139))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel140)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel141))
                            .addComponent(jLabel142)
                            .addComponent(jLabel143))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(brillancec)
                            .addComponent(indicec)
                            .addComponent(fracR)
                            .addComponent(flxcR)
                            .addComponent(specR)
                            .addComponent(difcR)
                            .addComponent(ambcR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel144)
                                .addComponent(jLabel145)
                                .addComponent(jLabel146)
                                .addComponent(jLabel147))
                            .addComponent(jLabel148))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fracV)
                            .addComponent(flxcV)
                            .addComponent(specV)
                            .addComponent(difcV)
                            .addComponent(ambcV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel149)
                            .addComponent(jLabel150)
                            .addComponent(jLabel151)
                            .addComponent(jLabel152)
                            .addComponent(jLabel153))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(specB)
                            .addComponent(difcB)
                            .addComponent(ambcB, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(flxcB, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(fracB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(252, Short.MAX_VALUE))))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ambcB, ambcR, ambcV, brillancec, difcB, difcR, difcV, flxcB, flxcR, flxcV, fracB, fracR, fracV, indicec, oricX, oricY, oricZ, specB, specR, specV, vect1cX, vect1cY, vect1cZ, vect2cX, vect2cY, vect2cZ, vect3cX, vect3cY, vect3cZ});

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel132, jLabel134, jLabel136, jLabel138, jLabel140, jLabel142, jLabel143});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel95)
                            .addComponent(vect1cX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel102)
                            .addComponent(jLabel103)
                            .addComponent(vect2cX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel98)
                            .addComponent(jLabel100)
                            .addComponent(oricX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel96)
                                    .addComponent(vect1cY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vect2cY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel105))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel97))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel99)
                                    .addComponent(oricY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel101)
                                    .addComponent(oricZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vect1cZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel104)
                                    .addComponent(vect2cZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel106)
                            .addComponent(jLabel107)
                            .addComponent(vect3cX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(vect3cY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel109))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel108)
                                    .addComponent(vect3cZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132)
                            .addComponent(ambcR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel133))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(difcR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel135)
                            .addComponent(jLabel134))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(specR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel137))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(jLabel139)
                            .addComponent(flxcR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel140)
                            .addComponent(fracR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel141))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel142)
                            .addComponent(indicec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel143)
                            .addComponent(brillancec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ambcV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel146)
                            .addComponent(difcV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel147)
                            .addComponent(specV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel144)
                            .addComponent(flxcV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel145)
                            .addComponent(fracV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel149)
                            .addComponent(ambcB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel150)
                            .addComponent(difcB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel151)
                            .addComponent(specB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel152)
                            .addComponent(flxcB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel153)
                            .addComponent(fracB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterCube)
                    .addComponent(BoutonAnnuler3)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        TabOnglet.addTab("Cube", jPanel3);

        jLabel5.setText("Coordonnees : ");

        jLabel9.setText("Y :");

        jLabel15.setText("X :");

        jLabel18.setText("Z :");

        posZ.setText("0.0");

        posY.setText("0.0");

        posX.setText("0.0");

        jLabel19.setText("R :");

        jSliderR.setMaximum(255);
        jSliderR.setPaintLabels(true);
        jSliderR.setPaintTicks(true);
        jSliderR.setValue(0);

        jLabel29.setText("Intensite : ");

        jLabel30.setText("B :");

        jLabel34.setText("V :");

        jSliderV.setMaximum(255);
        jSliderV.setPaintLabels(true);
        jSliderV.setPaintTicks(true);
        jSliderV.setValue(0);

        jSliderB.setMaximum(255);
        jSliderB.setPaintLabels(true);
        jSliderB.setPaintTicks(true);
        jSliderB.setValue(0);

        jLabel35.setText("Aperçu :");

        ajouterLumiere.setText("Ajouter");
        ajouterLumiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterLumiereActionPerformed(evt);
            }
        });

        AnnulerLumiere.setText("Annuler");
        AnnulerLumiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerLumiereActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSliderR, org.jdesktop.beansbinding.ELProperty.create("${value}"), ValeurR, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSliderV, org.jdesktop.beansbinding.ELProperty.create("${value}"), ValeurV, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSliderB, org.jdesktop.beansbinding.ELProperty.create("${value}"), ValeurB, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSliderR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValeurR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apercu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(posY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(posX, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(posZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(ajouterLumiere)
                        .addGap(18, 18, 18)
                        .addComponent(AnnulerLumiere))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValeurV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValeurB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {posX, posY, posZ});

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel18, jLabel9});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSliderR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ValeurR)
                                        .addComponent(jLabel35))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(apercu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(ValeurV)
                            .addComponent(jSliderV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ValeurB)
                            .addComponent(jSliderB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajouterLumiere)
                            .addComponent(AnnulerLumiere)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15)
                            .addComponent(posX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(posY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(posZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        TabOnglet.addTab("Source lumineuse", jPanel9);

        jLabel36.setText("Coordonnees de l'ecran : Origine : ");

        jLabel37.setText("X :");

        jLabel38.setText("Y :");

        jLabel39.setText("Z :");

        oriY.setText("0.0");

        oriX.setText("0.0");

        oriZ.setText("0.0");

        jLabel40.setText("Vecteur 1 : ");

        jLabel41.setText("Y :");

        jLabel42.setText("X :");

        jLabel43.setText("Z :");

        vect1Y.setText("0.0");

        vect1X.setText("0.0");

        vect1Z.setText("0.0");

        jLabel44.setText("Vecteur 2 : ");

        jLabel45.setText("X :");

        jLabel46.setText("Z :");

        jLabel47.setText("Y :");

        vect2Y.setText("0.0");

        vect2X.setText("0.0");

        vect2Z.setText("0.0");

        jLabel48.setText("Hauteur : ");

        hauteur.setText("0");

        jLabel49.setText("Largeur : ");

        largeur.setText("0");

        ajouterVue.setText("Ajouter");
        ajouterVue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterVueActionPerformed(evt);
            }
        });

        AnnulerVue.setText("Annuler");
        AnnulerVue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerVueActionPerformed(evt);
            }
        });

        jLabel50.setText("Coordonnees du point de vue : ");

        jLabel73.setText("Y :");

        pdvY.setText("0.0");

        jLabel74.setText("X :");

        pdvX.setText("0.0");

        jLabel75.setText("Z :");

        pdvZ.setText("0.0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37))
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(oriY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(oriX, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addGap(4, 4, 4))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(oriZ, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42))
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(vect1Y, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vect1X, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vect1Z, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel46)
                                .addComponent(jLabel47)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vect2Y, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(vect2X, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(vect2Z, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(169, 169, 169))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hauteur, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(largeur, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                        .addGap(655, 655, 655))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pdvY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pdvX, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pdvZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(518, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(ajouterVue)
                        .addGap(18, 18, 18)
                        .addComponent(AnnulerVue)
                        .addContainerGap(697, Short.MAX_VALUE))))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel48, jLabel49});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {hauteur, largeur, oriX, oriY, oriZ, pdvX, pdvY, pdvZ, vect1X, vect1Y, vect1Z, vect2X, vect2Y, vect2Z});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel37, jLabel38, jLabel39, jLabel41, jLabel42, jLabel43, jLabel45, jLabel46, jLabel47, jLabel73, jLabel74, jLabel75});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(vect1X, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(vect2X, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel42)
                    .addComponent(oriX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(vect1Y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vect2Y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47)
                        .addComponent(oriY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(oriZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vect1Z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(vect2Z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))))
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(hauteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(largeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel74)
                    .addComponent(pdvX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(pdvY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(pdvZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterVue)
                    .addComponent(AnnulerVue))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        TabOnglet.addTab("Vue", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabOnglet, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabOnglet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonAnnuler1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnuler1ActionPerformed
        this.dispose();
}//GEN-LAST:event_BoutonAnnuler1ActionPerformed

    private void BoutonAnnuler2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnuler2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BoutonAnnuler2ActionPerformed

    private void BoutonAnnuler3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnuler3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BoutonAnnuler3ActionPerformed

    private void ajouterSphereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterSphereActionPerformed
        try{
            Point3D c = new Point3D(Double.parseDouble(centreX.getText()), Double.parseDouble(centreY.getText()), Double.parseDouble(centreZ.getText()));
            double r = Double.parseDouble(rayon.getText());
            Color ambs = new Color(Integer.parseInt(ambsR.getText()),Integer.parseInt(ambsV.getText()),Integer.parseInt(ambsB.getText()));
            Color difs = new Color(Integer.parseInt(difsR.getText()),Integer.parseInt(difsV.getText()),Integer.parseInt(difsB.getText()));
            Color spes = new Color(Integer.parseInt(spesR.getText()),Integer.parseInt(spesV.getText()),Integer.parseInt(spesB.getText()));
            Color flxs = new Color(Integer.parseInt(flxsR.getText()),Integer.parseInt(flxsV.getText()),Integer.parseInt(flxsB.getText()));
            Color fras = new Color(Integer.parseInt(frasR.getText()),Integer.parseInt(frasV.getText()),Integer.parseInt(frasB.getText()));
            double inds = Double.parseDouble(indices.getText());
            double bris = Double.parseDouble(brillances.getText());

            Matiere m = new Matiere(ambs, difs, spes, flxs, fras, inds, bris);
            sphere.setCentre(c);
            sphere.setRayon(r);
            sphere.setMatiere(m);
            this.dispose();
        }
        catch(Exception ex){
            try{
                Point3D c = new Point3D(Double.parseDouble(centreX.getText()), Double.parseDouble(centreY.getText()), Double.parseDouble(centreZ.getText()));
                double r = Double.parseDouble(rayon.getText());
                Color ambs = new Color(Integer.parseInt(ambsR.getText()),Integer.parseInt(ambsV.getText()),Integer.parseInt(ambsB.getText()));
                Color difs = new Color(Integer.parseInt(difsR.getText()),Integer.parseInt(difsV.getText()),Integer.parseInt(difsB.getText()));
                Color spes = new Color(Integer.parseInt(spesR.getText()),Integer.parseInt(spesV.getText()),Integer.parseInt(spesB.getText()));
                Color flxs = new Color(Integer.parseInt(flxsR.getText()),Integer.parseInt(flxsV.getText()),Integer.parseInt(flxsB.getText()));
                Color fras = new Color(Integer.parseInt(frasR.getText()),Integer.parseInt(frasV.getText()),Integer.parseInt(frasB.getText()));
                double inds = Double.parseDouble(indices.getText());
                double bris = Double.parseDouble(brillances.getText());

                Matiere m = new Matiere(ambs, difs, spes, flxs, fras, inds, bris);

                place = scene.addObjet(new Sphere( m, c , r));

                modif = "sphere";

                this.dispose();

            }
            catch(Exception e){
             JOptionPane.showMessageDialog(this,"Erreur de saisie des parametres","Lancer de rayon",JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_ajouterSphereActionPerformed

    private void ajouterPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterPlanActionPerformed
        try{
            Point3D p1 = new Point3D(Double.parseDouble(p1pX.getText()), Double.parseDouble(p1pY.getText()), Double.parseDouble(p1pZ.getText()));
            Point3D p2 = new Point3D(Double.parseDouble(p2pX.getText()), Double.parseDouble(p2pY.getText()), Double.parseDouble(p2pZ.getText()));
            Point3D p3 = new Point3D(Double.parseDouble(p3pX.getText()), Double.parseDouble(p3pY.getText()), Double.parseDouble(p3pZ.getText()));
            Color ambp = new Color(Integer.parseInt(ambpR.getText()),Integer.parseInt(ambpV.getText()),Integer.parseInt(ambpB.getText()));
            Color difp = new Color(Integer.parseInt(difpR.getText()),Integer.parseInt(difpV.getText()),Integer.parseInt(difpB.getText()));
            Color spep = new Color(Integer.parseInt(spepR.getText()),Integer.parseInt(spepV.getText()),Integer.parseInt(spepB.getText()));
            Color flxp = new Color(Integer.parseInt(flxpR.getText()),Integer.parseInt(flxpV.getText()),Integer.parseInt(flxpB.getText()));
            Color frap = new Color(Integer.parseInt(frapR.getText()),Integer.parseInt(frapV.getText()),Integer.parseInt(frapB.getText()));
            double indp = Double.parseDouble(indicep.getText());
            double brip = Double.parseDouble(brillancep.getText());

            Matiere m = new Matiere(ambp, difp, spep, flxp, frap, indp, brip);

            plan.setP0(p1.getX(), p1.getY(), p1.getZ());
            plan.setP1(p2.getX(), p2.getY(), p2.getZ());
            plan.setP2(p3.getX(), p3.getY(), p3.getZ());
            plan.setMatiere(m);
            this.dispose();
        }
        catch(Exception ex){
            try{
                Point3D p1 = new Point3D(Double.parseDouble(p1pX.getText()), Double.parseDouble(p1pY.getText()), Double.parseDouble(p1pZ.getText()));
                Point3D p2 = new Point3D(Double.parseDouble(p2pX.getText()), Double.parseDouble(p2pY.getText()), Double.parseDouble(p2pZ.getText()));
                Point3D p3 = new Point3D(Double.parseDouble(p3pX.getText()), Double.parseDouble(p3pY.getText()), Double.parseDouble(p3pZ.getText()));
                Color ambp = new Color(Integer.parseInt(ambpR.getText()),Integer.parseInt(ambpV.getText()),Integer.parseInt(ambpB.getText()));
                Color difp = new Color(Integer.parseInt(difpR.getText()),Integer.parseInt(difpV.getText()),Integer.parseInt(difpB.getText()));
                Color spep = new Color(Integer.parseInt(spepR.getText()),Integer.parseInt(spepV.getText()),Integer.parseInt(spepB.getText()));
                Color flxp = new Color(Integer.parseInt(flxpR.getText()),Integer.parseInt(flxpV.getText()),Integer.parseInt(flxpB.getText()));
                Color frap = new Color(Integer.parseInt(frapR.getText()),Integer.parseInt(frapV.getText()),Integer.parseInt(frapB.getText()));
                double indp = Double.parseDouble(indicep.getText());
                double brip = Double.parseDouble(brillancep.getText());

                Matiere m = new Matiere(ambp, difp, spep, flxp, frap, indp, brip);

                place = scene.addObjet(new Plan(m, p1, p2, p3));

                modif = "plan";

                this.dispose();

            }
            catch(Exception e){
               JOptionPane.showMessageDialog(this,"Erreur de saisie des parametres","Lancer de rayon",JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_ajouterPlanActionPerformed

    private void ajouterCubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterCubeActionPerformed
        try{
            Point3D p1 = new Point3D(Double.parseDouble(oricX.getText()), Double.parseDouble(oricY.getText()), Double.parseDouble(oricZ.getText()));
            Vecteur3D v1 = new Vecteur3D(Double.parseDouble(vect1cX.getText()), Double.parseDouble(vect1cY.getText()), Double.parseDouble(vect1cZ.getText()));
            Vecteur3D v2 = new Vecteur3D(Double.parseDouble(vect2cX.getText()), Double.parseDouble(vect2cY.getText()), Double.parseDouble(vect2cZ.getText()));
            Vecteur3D v3 = new Vecteur3D(Double.parseDouble(vect3cX.getText()), Double.parseDouble(vect3cY.getText()), Double.parseDouble(vect3cZ.getText()));
            Color ambc = new Color(Integer.parseInt(ambcR.getText()),Integer.parseInt(ambcV.getText()),Integer.parseInt(ambcB.getText()));
            Color difc = new Color(Integer.parseInt(difcR.getText()),Integer.parseInt(difcV.getText()),Integer.parseInt(difcB.getText()));
            Color spec = new Color(Integer.parseInt(specR.getText()),Integer.parseInt(specV.getText()),Integer.parseInt(specB.getText()));
            Color flxc = new Color(Integer.parseInt(flxcR.getText()),Integer.parseInt(flxcV.getText()),Integer.parseInt(flxcB.getText()));
            Color frac = new Color(Integer.parseInt(fracR.getText()),Integer.parseInt(fracV.getText()),Integer.parseInt(fracB.getText()));
            double indc = Double.parseDouble(indicec.getText());
            double bric = Double.parseDouble(brillancec.getText());

            Matiere m = new Matiere(ambc, difc, spec, flxc, frac, indc, bric);
            
            cube.setOrigine(p1);
            cube.setVecteurs(v1, v2, v3);
            
            this.dispose();
        }
        catch(Exception ex){
            try{

                Point3D p1 = new Point3D(Double.parseDouble(oricX.getText()), Double.parseDouble(oricY.getText()), Double.parseDouble(oricZ.getText()));
                Vecteur3D v1 = new Vecteur3D(Double.parseDouble(vect1cX.getText()), Double.parseDouble(vect1cY.getText()), Double.parseDouble(vect1cZ.getText()));
                Vecteur3D v2 = new Vecteur3D(Double.parseDouble(vect2cX.getText()), Double.parseDouble(vect2cY.getText()), Double.parseDouble(vect2cZ.getText()));
                Vecteur3D v3 = new Vecteur3D(Double.parseDouble(vect3cX.getText()), Double.parseDouble(vect3cY.getText()), Double.parseDouble(vect3cZ.getText()));
                Color ambc = new Color(Integer.parseInt(ambcR.getText()),Integer.parseInt(ambcV.getText()),Integer.parseInt(ambcB.getText()));
                Color difc = new Color(Integer.parseInt(difcR.getText()),Integer.parseInt(difcV.getText()),Integer.parseInt(difcB.getText()));
                Color spec = new Color(Integer.parseInt(specR.getText()),Integer.parseInt(specV.getText()),Integer.parseInt(specB.getText()));
                Color flxc = new Color(Integer.parseInt(flxcR.getText()),Integer.parseInt(flxcV.getText()),Integer.parseInt(flxcB.getText()));
                Color frac = new Color(Integer.parseInt(fracR.getText()),Integer.parseInt(fracV.getText()),Integer.parseInt(fracB.getText()));
                double indc = Double.parseDouble(indicec.getText());
                double bric = Double.parseDouble(brillancec.getText());

                Matiere m = new Matiere(ambc, difc, spec, flxc, frac, indc, bric);

                place = scene.addObjet(new Cube(m, p1, v1, v2, v3));

                modif = "cube";

                this.dispose();

            }
            catch(Exception e){
               JOptionPane.showMessageDialog(this,"Erreur de saisie des parametres","Lancer de rayon",JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_ajouterCubeActionPerformed

    private void AnnulerLumiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerLumiereActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerLumiereActionPerformed

    private void ajouterLumiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterLumiereActionPerformed
        try{
            Point3D point = new Point3D(Double.parseDouble(posX.getText()), Double.parseDouble(posY.getText()), Double.parseDouble(posZ.getText()));
            Color c = new Color(jSliderR.getValue(),jSliderV.getValue(),jSliderB.getValue());
            
            lumiere.setPosition(point);
            lumiere.setCouleur(c);
            
            this.dispose();
        }
        catch(Exception e){
            Point3D point = new Point3D(Double.parseDouble(posX.getText()), Double.parseDouble(posY.getText()), Double.parseDouble(posZ.getText()));
            Color c = new Color(jSliderR.getValue(),jSliderV.getValue(),jSliderB.getValue());
            place = scene.addLumiere(new Lumiere(c,point));

            modif = "lumiere";

            this.dispose();
        }
}//GEN-LAST:event_ajouterLumiereActionPerformed

    private void ajouterVueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterVueActionPerformed
        try{
            Point3D origine = new Point3D(Double.parseDouble(oriX.getText()), Double.parseDouble(oriY.getText()), Double.parseDouble(oriZ.getText()));
            Vecteur3D vect1 = new Vecteur3D(Double.parseDouble(vect1X.getText()), Double.parseDouble(vect1Y.getText()), Double.parseDouble(vect1Z.getText()));
            Vecteur3D vect2 = new Vecteur3D(Double.parseDouble(vect2X.getText()), Double.parseDouble(vect2Y.getText()), Double.parseDouble(vect2Z.getText()));
            Point3D pdv = new Point3D(Double.parseDouble(pdvX.getText()), Double.parseDouble(pdvY.getText()), Double.parseDouble(pdvZ.getText()));
            
            vue.setEcran(new Ecran(vect1, vect2, origine, Integer.parseInt(hauteur.getText()), Integer.parseInt(largeur.getText())));
            vue.setPointDeVue(new PointDeVue(pdv));
            this.dispose();
        }
        catch(Exception ex){
            try{
                Point3D origine = new Point3D(Double.parseDouble(oriX.getText()), Double.parseDouble(oriY.getText()), Double.parseDouble(oriZ.getText()));
                Vecteur3D vect1 = new Vecteur3D(Double.parseDouble(vect1X.getText()), Double.parseDouble(vect1Y.getText()), Double.parseDouble(vect1Z.getText()));
                Vecteur3D vect2 = new Vecteur3D(Double.parseDouble(vect2X.getText()), Double.parseDouble(vect2Y.getText()), Double.parseDouble(vect2Z.getText()));
                Point3D pdv = new Point3D(Double.parseDouble(pdvX.getText()), Double.parseDouble(pdvY.getText()), Double.parseDouble(pdvZ.getText()));
                place = scene.addVue(new Vue(new PointDeVue(pdv), new Ecran(vect1, vect2, origine, Integer.parseInt(hauteur.getText()), Integer.parseInt(largeur.getText()))));

                modif = "vue";

                this.dispose();
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(this,"Erreur de saisie des parametres","Lancer de rayon",JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_ajouterVueActionPerformed

    private void AnnulerVueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerVueActionPerformed
        this.dispose();
}//GEN-LAST:event_AnnulerVueActionPerformed

    public JTabbedPane getOnglets(){
        return TabOnglet;
    }

    public String getModif(){
        return modif;
    }

    public int getPlace(){
        return place;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnnulerLumiere;
    private javax.swing.JButton AnnulerVue;
    private javax.swing.JButton BoutonAnnuler1;
    private javax.swing.JButton BoutonAnnuler2;
    private javax.swing.JButton BoutonAnnuler3;
    private javax.swing.JLabel LabelApercu;
    private javax.swing.JTabbedPane TabOnglet;
    private javax.swing.JLabel ValeurB;
    private javax.swing.JLabel ValeurR;
    private javax.swing.JLabel ValeurV;
    private javax.swing.JButton ajouterCube;
    private javax.swing.JButton ajouterLumiere;
    private javax.swing.JButton ajouterPlan;
    private javax.swing.JButton ajouterSphere;
    private javax.swing.JButton ajouterVue;
    private javax.swing.JTextField ambcB;
    private javax.swing.JTextField ambcR;
    private javax.swing.JTextField ambcV;
    private javax.swing.JTextField ambpB;
    private javax.swing.JTextField ambpR;
    private javax.swing.JTextField ambpV;
    private javax.swing.JTextField ambsB;
    private javax.swing.JTextField ambsR;
    private javax.swing.JTextField ambsV;
    private javax.swing.JLabel apercu;
    private javax.swing.JTextField brillancec;
    private javax.swing.JTextField brillancep;
    private javax.swing.JTextField brillances;
    private javax.swing.JTextField centreX;
    private javax.swing.JTextField centreY;
    private javax.swing.JTextField centreZ;
    private javax.swing.JTextField difcB;
    private javax.swing.JTextField difcR;
    private javax.swing.JTextField difcV;
    private javax.swing.JTextField difpB;
    private javax.swing.JTextField difpR;
    private javax.swing.JTextField difpV;
    private javax.swing.JTextField difsB;
    private javax.swing.JTextField difsR;
    private javax.swing.JTextField difsV;
    private javax.swing.JTextField flxcB;
    private javax.swing.JTextField flxcR;
    private javax.swing.JTextField flxcV;
    private javax.swing.JTextField flxpB;
    private javax.swing.JTextField flxpR;
    private javax.swing.JTextField flxpV;
    private javax.swing.JTextField flxsB;
    private javax.swing.JTextField flxsR;
    private javax.swing.JTextField flxsV;
    private javax.swing.JTextField fracB;
    private javax.swing.JTextField fracR;
    private javax.swing.JTextField fracV;
    private javax.swing.JTextField frapB;
    private javax.swing.JTextField frapR;
    private javax.swing.JTextField frapV;
    private javax.swing.JTextField frasB;
    private javax.swing.JTextField frasR;
    private javax.swing.JTextField frasV;
    private javax.swing.JTextField hauteur;
    private javax.swing.JTextField indicec;
    private javax.swing.JTextField indicep;
    private javax.swing.JTextField indices;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSlider jSliderB;
    private javax.swing.JSlider jSliderR;
    private javax.swing.JSlider jSliderV;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField largeur;
    private javax.swing.JTextField oriX;
    private javax.swing.JTextField oriY;
    private javax.swing.JTextField oriZ;
    private javax.swing.JTextField oricX;
    private javax.swing.JTextField oricY;
    private javax.swing.JTextField oricZ;
    private javax.swing.JTextField p1pX;
    private javax.swing.JTextField p1pY;
    private javax.swing.JTextField p1pZ;
    private javax.swing.JTextField p2pX;
    private javax.swing.JTextField p2pY;
    private javax.swing.JTextField p2pZ;
    private javax.swing.JTextField p3pX;
    private javax.swing.JTextField p3pY;
    private javax.swing.JTextField p3pZ;
    private javax.swing.JTextField pdvX;
    private javax.swing.JTextField pdvY;
    private javax.swing.JTextField pdvZ;
    private javax.swing.JTextField posX;
    private javax.swing.JTextField posY;
    private javax.swing.JTextField posZ;
    private javax.swing.JTextField rayon;
    private javax.swing.JTextField specB;
    private javax.swing.JTextField specR;
    private javax.swing.JTextField specV;
    private javax.swing.JTextField spepB;
    private javax.swing.JTextField spepR;
    private javax.swing.JTextField spepV;
    private javax.swing.JTextField spesB;
    private javax.swing.JTextField spesR;
    private javax.swing.JTextField spesV;
    private javax.swing.JTextField vect1X;
    private javax.swing.JTextField vect1Y;
    private javax.swing.JTextField vect1Z;
    private javax.swing.JTextField vect1cX;
    private javax.swing.JTextField vect1cY;
    private javax.swing.JTextField vect1cZ;
    private javax.swing.JTextField vect2X;
    private javax.swing.JTextField vect2Y;
    private javax.swing.JTextField vect2Z;
    private javax.swing.JTextField vect2cX;
    private javax.swing.JTextField vect2cY;
    private javax.swing.JTextField vect2cZ;
    private javax.swing.JTextField vect3cX;
    private javax.swing.JTextField vect3cY;
    private javax.swing.JTextField vect3cZ;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

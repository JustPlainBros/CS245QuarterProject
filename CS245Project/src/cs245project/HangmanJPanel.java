/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author michael
 */
public class HangmanJPanel extends javax.swing.JPanel {    
    private final String[] wordList = {"abstract","cemetery","nurse","pharmacy","climbing"};
    private final JLabel[] wordLabels;
    private final boolean[] visibilityLabels;
    private final String chosenWord;
    
    private int numberOfGuesses = 0;
    private int totalScore = 100;

    /**
     * Creates new form HangmanJPanel
     */
    public HangmanJPanel() {
        initComponents();
        //This next line exists to populate the date upon launch of game. If not here,
        //date populates as "jLabel2" for one runtime second then does date properly.
        jLabel2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        jLabel2.setText(new SimpleDateFormat("MMMM d, yyyy HH:mm:ss").format(new Date()));
        setDate();
        
        scoreLabel.setText("Total Score: " + String.valueOf(totalScore));
        
        chosenWord = getRandomWord();
        wordLabels = new JLabel[chosenWord.length()];
        visibilityLabels = new boolean[chosenWord.length()];
    }
    
    private String getRandomWord() {
        return wordList[new Random().nextInt(wordList.length)];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Temporary solution, ill come up with some function to calculate the space correctly for all word lengths
        int firstXCoordinate = 0;
        int secondXCoordinate = 0;
        if(chosenWord.length() <= 5) {
            firstXCoordinate = 125;
          
            secondXCoordinate = 175;
        } else {
            firstXCoordinate = 10;
            secondXCoordinate = 60;
        }
        //testcomment
        for(int i = 0; i < chosenWord.length(); i++) {
            g2.drawLine(firstXCoordinate, 290, secondXCoordinate, 290);
            
            JLabel label = new JLabel(Character.toString(chosenWord.charAt(i)));
            label.setBounds((firstXCoordinate + secondXCoordinate) / 2, 265, 20, 20);
            label.setVisible(false);
            this.add(label);
            
            wordLabels[i] = label;
            firstXCoordinate += 75;
            secondXCoordinate += 75;
        }        
    }
    
    public final void setDate() {  
        ActionListener date = (java.awt.event.ActionEvent e) -> {
            jLabel2.setText(new SimpleDateFormat("MMMM d, yyyy HH:mm:ss").format(new Date()));
        };
        new javax.swing.Timer(1000, date).start();
    }
    
    private void processButtonClick(String letter) {
        boolean goodLetter = false;
        for(int i = 0; i < chosenWord.length(); i++) {
            if(Character.toString(chosenWord.charAt(i)).equals(letter)) {
                wordLabels[i].setVisible(true);
                visibilityLabels[i] = true;
                goodLetter = true;
            }
        }
        
        // Check if they won or not
        if(isWinner()) {
            HangmanResultJFrame winnerFrame = new HangmanResultJFrame("You won!", totalScore);
            winnerFrame.setResultFrameAttributes();
            disposeCurrentFrame();
        }
        
        if(!goodLetter) {
            ++numberOfGuesses;
            totalScore -= 10;

            scoreLabel.setText("Total Score: " + String.valueOf(totalScore));
            
            String path = "resources/";
            if(numberOfGuesses == 6) {
                path += "finalPic.gif";
                disableAllButtons();
                startTimer();
            } else {
                path += "image" + String.valueOf(numberOfGuesses) + ".png"; 
            }
            System.out.println(path);
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(path));
            guillotinePicture.setIcon(imageIcon);
            this.repaint();
        }
    }
    
    private boolean isWinner() {
        for (Boolean visibilityLabel : visibilityLabels) {
            if (!visibilityLabel) {
                return false;
            }
        }
        return true;
    }
    
    private void startTimer() {
        // Initialize timer
        // 5 seconds play gif
        Timer timer = new Timer(3000, (ActionEvent e) -> {
            HangmanResultJFrame loserFrame = new HangmanResultJFrame("You lost!", totalScore);
            loserFrame.setResultFrameAttributes();
            disposeCurrentFrame();
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void disableAllButtons() {
        aButton.setEnabled(false);
        bButton.setEnabled(false);
        cButton.setEnabled(false);
        dButton.setEnabled(false);
        eButton.setEnabled(false);
        fButton.setEnabled(false);
        gButton.setEnabled(false);
        hButton.setEnabled(false);
        iButton.setEnabled(false);
        jButton.setEnabled(false);
        kButton.setEnabled(false);
        lButton.setEnabled(false);
        mButton.setEnabled(false);
        nButton.setEnabled(false);
        oButton.setEnabled(false);
        pButton.setEnabled(false);
        qButton.setEnabled(false);
        rButton.setEnabled(false);
        sButton.setEnabled(false);
        tButton.setEnabled(false);
        uButton.setEnabled(false);
        vButton.setEnabled(false);
        wButton.setEnabled(false);
        xButton.setEnabled(false);
        yButton.setEnabled(false);
        zButton.setEnabled(false);
        skipButton.setEnabled(false);
    }
    
    private void disposeCurrentFrame() {
        // Close JFrame that is containing this JPanel object
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton15 = new javax.swing.JButton();
        skipButton = new javax.swing.JButton();
        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        eButton = new javax.swing.JButton();
        gButton = new javax.swing.JButton();
        fButton = new javax.swing.JButton();
        hButton = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        iButton = new javax.swing.JButton();
        kButton = new javax.swing.JButton();
        lButton = new javax.swing.JButton();
        mButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        oButton = new javax.swing.JButton();
        qButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        uButton = new javax.swing.JButton();
        vButton = new javax.swing.JButton();
        wButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();
        yButton = new javax.swing.JButton();
        zButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guillotinePicture = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        jButton15.setText("jButton3");
        jButton15.setPreferredSize(new java.awt.Dimension(40, 40));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        skipButton.setText("Skip");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        add(skipButton);
        skipButton.setBounds(530, 70, 75, 29);

        aButton.setText("a");
        aButton.setPreferredSize(new java.awt.Dimension(40, 40));
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });
        add(aButton);
        aButton.setBounds(10, 300, 30, 30);

        bButton.setText("b");
        bButton.setPreferredSize(new java.awt.Dimension(40, 40));
        bButton.setSize(new java.awt.Dimension(30, 30));
        bButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButtonActionPerformed(evt);
            }
        });
        add(bButton);
        bButton.setBounds(50, 300, 30, 30);

        cButton.setText("c");
        cButton.setPreferredSize(new java.awt.Dimension(40, 40));
        cButton.setSize(new java.awt.Dimension(30, 30));
        cButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtonActionPerformed(evt);
            }
        });
        add(cButton);
        cButton.setBounds(100, 300, 30, 30);

        dButton.setText("d");
        dButton.setPreferredSize(new java.awt.Dimension(40, 40));
        dButton.setSize(new java.awt.Dimension(30, 30));
        dButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtonActionPerformed(evt);
            }
        });
        add(dButton);
        dButton.setBounds(140, 300, 30, 30);

        eButton.setText("e");
        eButton.setPreferredSize(new java.awt.Dimension(40, 40));
        eButton.setSize(new java.awt.Dimension(30, 30));
        eButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eButtonActionPerformed(evt);
            }
        });
        add(eButton);
        eButton.setBounds(190, 300, 30, 30);

        gButton.setText("g");
        gButton.setPreferredSize(new java.awt.Dimension(40, 40));
        gButton.setSize(new java.awt.Dimension(30, 30));
        gButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gButtonActionPerformed(evt);
            }
        });
        add(gButton);
        gButton.setBounds(290, 300, 30, 30);

        fButton.setText("f");
        fButton.setPreferredSize(new java.awt.Dimension(40, 40));
        fButton.setSize(new java.awt.Dimension(30, 30));
        fButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fButtonActionPerformed(evt);
            }
        });
        add(fButton);
        fButton.setBounds(240, 300, 30, 30);

        hButton.setText("h");
        hButton.setPreferredSize(new java.awt.Dimension(40, 40));
        hButton.setSize(new java.awt.Dimension(30, 30));
        hButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hButtonActionPerformed(evt);
            }
        });
        add(hButton);
        hButton.setBounds(340, 300, 30, 30);

        jButton.setText("j");
        jButton.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton.setSize(new java.awt.Dimension(30, 30));
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        add(jButton);
        jButton.setBounds(430, 300, 30, 30);

        iButton.setText("i");
        iButton.setPreferredSize(new java.awt.Dimension(40, 40));
        iButton.setSize(new java.awt.Dimension(30, 30));
        iButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iButtonActionPerformed(evt);
            }
        });
        add(iButton);
        iButton.setBounds(380, 300, 30, 30);

        kButton.setText("k");
        kButton.setPreferredSize(new java.awt.Dimension(40, 40));
        kButton.setSize(new java.awt.Dimension(30, 30));
        kButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonActionPerformed(evt);
            }
        });
        add(kButton);
        kButton.setBounds(470, 300, 30, 30);

        lButton.setText("l");
        lButton.setPreferredSize(new java.awt.Dimension(40, 40));
        lButton.setSize(new java.awt.Dimension(30, 30));
        lButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lButtonActionPerformed(evt);
            }
        });
        add(lButton);
        lButton.setBounds(520, 300, 30, 30);

        mButton.setText("m");
        mButton.setPreferredSize(new java.awt.Dimension(40, 40));
        mButton.setSize(new java.awt.Dimension(30, 30));
        mButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonActionPerformed(evt);
            }
        });
        add(mButton);
        mButton.setBounds(570, 300, 30, 30);

        nButton.setText("n");
        nButton.setPreferredSize(new java.awt.Dimension(40, 40));
        nButton.setSize(new java.awt.Dimension(30, 30));
        nButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtonActionPerformed(evt);
            }
        });
        add(nButton);
        nButton.setBounds(10, 340, 30, 30);

        pButton.setText("p");
        pButton.setPreferredSize(new java.awt.Dimension(40, 40));
        pButton.setSize(new java.awt.Dimension(30, 30));
        pButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtonActionPerformed(evt);
            }
        });
        add(pButton);
        pButton.setBounds(100, 340, 30, 30);

        oButton.setText("o");
        oButton.setPreferredSize(new java.awt.Dimension(40, 40));
        oButton.setSize(new java.awt.Dimension(30, 30));
        oButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oButtonActionPerformed(evt);
            }
        });
        add(oButton);
        oButton.setBounds(60, 340, 30, 30);

        qButton.setText("q");
        qButton.setPreferredSize(new java.awt.Dimension(40, 40));
        qButton.setSize(new java.awt.Dimension(30, 30));
        qButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qButtonActionPerformed(evt);
            }
        });
        add(qButton);
        qButton.setBounds(150, 340, 30, 30);

        rButton.setText("r");
        rButton.setPreferredSize(new java.awt.Dimension(40, 40));
        rButton.setSize(new java.awt.Dimension(30, 30));
        rButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButtonActionPerformed(evt);
            }
        });
        add(rButton);
        rButton.setBounds(190, 340, 30, 30);

        sButton.setText("s");
        sButton.setPreferredSize(new java.awt.Dimension(40, 40));
        sButton.setSize(new java.awt.Dimension(30, 30));
        sButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtonActionPerformed(evt);
            }
        });
        add(sButton);
        sButton.setBounds(240, 340, 30, 30);

        tButton.setText("t");
        tButton.setPreferredSize(new java.awt.Dimension(40, 40));
        tButton.setSize(new java.awt.Dimension(30, 30));
        tButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButtonActionPerformed(evt);
            }
        });
        add(tButton);
        tButton.setBounds(290, 340, 30, 30);

        uButton.setText("u");
        uButton.setPreferredSize(new java.awt.Dimension(40, 40));
        uButton.setSize(new java.awt.Dimension(30, 30));
        uButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uButtonActionPerformed(evt);
            }
        });
        add(uButton);
        uButton.setBounds(330, 340, 30, 30);

        vButton.setText("v");
        vButton.setPreferredSize(new java.awt.Dimension(40, 40));
        vButton.setSize(new java.awt.Dimension(30, 30));
        vButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButtonActionPerformed(evt);
            }
        });
        add(vButton);
        vButton.setBounds(380, 340, 30, 30);

        wButton.setText("w");
        wButton.setPreferredSize(new java.awt.Dimension(40, 40));
        wButton.setSize(new java.awt.Dimension(30, 30));
        wButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wButtonActionPerformed(evt);
            }
        });
        add(wButton);
        wButton.setBounds(420, 340, 30, 30);

        xButton.setText("x");
        xButton.setPreferredSize(new java.awt.Dimension(40, 40));
        xButton.setSize(new java.awt.Dimension(30, 30));
        xButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtonActionPerformed(evt);
            }
        });
        add(xButton);
        xButton.setBounds(470, 340, 30, 30);

        yButton.setText("y");
        yButton.setPreferredSize(new java.awt.Dimension(40, 40));
        yButton.setSize(new java.awt.Dimension(30, 30));
        yButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yButtonActionPerformed(evt);
            }
        });
        add(yButton);
        yButton.setBounds(520, 340, 30, 30);

        zButton.setText("z");
        zButton.setPreferredSize(new java.awt.Dimension(40, 40));
        zButton.setSize(new java.awt.Dimension(30, 30));
        zButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zButtonActionPerformed(evt);
            }
        });
        add(zButton);
        zButton.setBounds(570, 340, 30, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HangmanLogo1.png"))); // NOI18N
        jLabel1.setSize(new java.awt.Dimension(150, 62));
        add(jLabel1);
        jLabel1.setBounds(6, 6, 150, 62);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(440, 6, 160, 20);

        guillotinePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imageorigin.png"))); // NOI18N
        guillotinePicture.setText("jLabel3");
        guillotinePicture.setPreferredSize(new java.awt.Dimension(130, 236));
        guillotinePicture.setSize(new java.awt.Dimension(130, 236));
        add(guillotinePicture);
        guillotinePicture.setBounds(230, 10, 130, 236);

        scoreLabel.setText("jLabel3");
        add(scoreLabel);
        scoreLabel.setBounds(470, 40, 150, 16);
    }// </editor-fold>//GEN-END:initComponents

    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        processButtonClick("a");
        aButton.setEnabled(false);
    }//GEN-LAST:event_aButtonActionPerformed

    private void bButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButtonActionPerformed
        processButtonClick("b");
        bButton.setEnabled(false);
    }//GEN-LAST:event_bButtonActionPerformed

    private void cButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtonActionPerformed
        processButtonClick("c");
        cButton.setEnabled(false);
    }//GEN-LAST:event_cButtonActionPerformed

    private void dButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButtonActionPerformed
        processButtonClick("d");
        dButton.setEnabled(false);
    }//GEN-LAST:event_dButtonActionPerformed

    private void eButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eButtonActionPerformed
        processButtonClick("e");
        eButton.setEnabled(false);
    }//GEN-LAST:event_eButtonActionPerformed

    private void fButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fButtonActionPerformed
        processButtonClick("f");
        fButton.setEnabled(false);
    }//GEN-LAST:event_fButtonActionPerformed

    private void gButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gButtonActionPerformed
        processButtonClick("g");
        gButton.setEnabled(false);
    }//GEN-LAST:event_gButtonActionPerformed

    private void hButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hButtonActionPerformed
        processButtonClick("h");
        hButton.setEnabled(false);
    }//GEN-LAST:event_hButtonActionPerformed

    private void iButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iButtonActionPerformed
        processButtonClick("i");
        iButton.setEnabled(false);
    }//GEN-LAST:event_iButtonActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        processButtonClick("j");
        jButton.setEnabled(false);
    }//GEN-LAST:event_jButtonActionPerformed

    private void kButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonActionPerformed
        processButtonClick("k");
        kButton.setEnabled(false);
    }//GEN-LAST:event_kButtonActionPerformed

    private void lButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lButtonActionPerformed
        processButtonClick("l");
        lButton.setEnabled(false);
    }//GEN-LAST:event_lButtonActionPerformed

    private void mButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonActionPerformed
        processButtonClick("m");
        mButton.setEnabled(false);
    }//GEN-LAST:event_mButtonActionPerformed

    private void nButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtonActionPerformed
        processButtonClick("n");
        nButton.setEnabled(false);
    }//GEN-LAST:event_nButtonActionPerformed

    private void oButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oButtonActionPerformed
        processButtonClick("o");
        oButton.setEnabled(false);
    }//GEN-LAST:event_oButtonActionPerformed

    private void pButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtonActionPerformed
        processButtonClick("p");
        pButton.setEnabled(false);
    }//GEN-LAST:event_pButtonActionPerformed

    private void qButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qButtonActionPerformed
        processButtonClick("q");
        qButton.setEnabled(false);
    }//GEN-LAST:event_qButtonActionPerformed

    private void rButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonActionPerformed
        processButtonClick("r");
        rButton.setEnabled(false);
    }//GEN-LAST:event_rButtonActionPerformed

    private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtonActionPerformed
        processButtonClick("s");
        sButton.setEnabled(false);
    }//GEN-LAST:event_sButtonActionPerformed

    private void tButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButtonActionPerformed
        processButtonClick("t");
        tButton.setEnabled(false);
    }//GEN-LAST:event_tButtonActionPerformed

    private void uButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uButtonActionPerformed
        processButtonClick("u");
        uButton.setEnabled(false);
    }//GEN-LAST:event_uButtonActionPerformed

    private void vButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButtonActionPerformed
        processButtonClick("v");
        vButton.setEnabled(false);
    }//GEN-LAST:event_vButtonActionPerformed

    private void wButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wButtonActionPerformed
        processButtonClick("w");
        wButton.setEnabled(false);
    }//GEN-LAST:event_wButtonActionPerformed

    private void xButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtonActionPerformed
        processButtonClick("x");
        xButton.setEnabled(false);
    }//GEN-LAST:event_xButtonActionPerformed

    private void yButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yButtonActionPerformed
        processButtonClick("y");
        yButton.setEnabled(false);
    }//GEN-LAST:event_yButtonActionPerformed

    private void zButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zButtonActionPerformed
        processButtonClick("z");
        zButton.setEnabled(false);
    }//GEN-LAST:event_zButtonActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        HangmanResultJFrame resultFrame = new HangmanResultJFrame("You skipped the game!", 0);
        resultFrame.setResultFrameAttributes();
        disposeCurrentFrame();
    }//GEN-LAST:event_skipButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aButton;
    private javax.swing.JButton bButton;
    private javax.swing.JButton cButton;
    private javax.swing.JButton dButton;
    private javax.swing.JButton eButton;
    private javax.swing.JButton fButton;
    private javax.swing.JButton gButton;
    private javax.swing.JLabel guillotinePicture;
    private javax.swing.JButton hButton;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton kButton;
    private javax.swing.JButton lButton;
    private javax.swing.JButton mButton;
    private javax.swing.JButton nButton;
    private javax.swing.JButton oButton;
    private javax.swing.JButton pButton;
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton tButton;
    private javax.swing.JButton uButton;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables
}
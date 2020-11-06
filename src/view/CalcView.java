
package view;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import controller.CalcController;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uk.ac.ed.ph.snuggletex.SnuggleEngine;
import uk.ac.ed.ph.snuggletex.SnuggleInput;
import uk.ac.ed.ph.snuggletex.SnuggleSession;

public class CalcView extends javax.swing.JFrame {

    
    public CalcView() {
        initComponents();
    }
    private Voice voice;
    String mathExp = "";
    CalcController controller = new CalcController(this);

    public void SpeechTTS() {
        VoiceManager voicemanager = VoiceManager.getInstance();
        voice = voicemanager.getVoice("kevin16");
        voice.allocate();
        System.out.println("Voice allocated");
    }

    public synchronized void sayThis(String str) {
        voice.speak(str);
        System.out.println("Action: " + str);
    }

    public void setInputLabel(String text) {
        inputLabel.setText(text);
    }

    public void setResultLabel(String text) {
        resultLabel.setText(text);
    }

    public String getInputLabel() {
        String temp = inputLabel.getText();
        return temp;
    }

    public void pressAC() {
        controller.setUserInput("");
        inputLabel.setText("");
        controller.setResult(0);
        resultLabel.setText("0");
        mathExp = "";
        controller.reset();
        sayThis("clearing");
    }

    public void startVoice() {
        controller.setUpVoice();
    }

    public void pressSpeak() {

        //System.out.println("Speak now!");
        if (!controller.getFlag()) {
            sayThis("speech mode enabled. Please start speaking");
            controller.setFlag(true);
            buttonSpeak.setText("Disable");
        } else {
            sayThis("speech mode disabled. speech input cannot be taken");
            controller.setFlag(false);
            buttonSpeak.setText("Enable");
        }

    }

    public void writeXMLtoFile(String str) throws IOException {
       
        SnuggleEngine engine = new SnuggleEngine();
        SnuggleSession session = engine.createSession();

       
        SnuggleInput input = new SnuggleInput(str);
        session.parseInput(input);

        
        String xmlString = session.buildXMLString(); 
        PrintWriter out = new PrintWriter("equationLaTeX.html");
        out.print(xmlString);

        out.close();
        System.out.println("Input " + input.getString()
                + " was converted and written to equationLaTeX.html");           
    }
    


    public boolean isValidPowerChat() {

        if (inputLabel.getText().endsWith("^")) {
            return false;
        } else {
            return true;
        }
    }

    public String getLaTeX(String exp) {

        return "$$ " + exp + " = " + resultLabel.getText() + " $$";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        button7 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button11 = new javax.swing.JButton();
        button12 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        buttonPower = new javax.swing.JButton();
        buttonTimes = new javax.swing.JButton();
        buttonMinus = new javax.swing.JButton();
        buttonPlus = new javax.swing.JButton();
        buttonAC = new javax.swing.JButton();
        buttonEquals = new javax.swing.JButton();
        buttonOpenB = new javax.swing.JButton();
        buttonCloseB = new javax.swing.JButton();
        inputLabel = new javax.swing.JTextField();
        resultLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonSpeak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Speaking Calculator");
        setBackground(new java.awt.Color(255, 51, 51));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(32, 32, 32));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        button7.setBackground(new java.awt.Color(224, 224, 224));
        button7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button7.setText("7");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(224, 224, 224));
        button4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button4.setText("4");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button1.setBackground(new java.awt.Color(224, 224, 224));
        button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button1.setText("1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button11.setBackground(new java.awt.Color(224, 224, 224));
        button11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button11.setText("0");
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        button12.setBackground(new java.awt.Color(0, 0, 0));
        button12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        button12.setForeground(new java.awt.Color(255, 255, 255));
        button12.setText("Clear");
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(224, 224, 224));
        button2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button2.setText("2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(224, 224, 224));
        button3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button3.setText("3");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(224, 224, 224));
        button5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button5.setText("5");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(224, 224, 224));
        button6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button6.setText("6");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(224, 224, 224));
        button8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button8.setText("8");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setBackground(new java.awt.Color(224, 224, 224));
        button9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        button9.setText("9");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(button11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(button1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(32, 32, 32));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        buttonPower.setBackground(new java.awt.Color(255, 128, 0));
        buttonPower.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonPower.setForeground(new java.awt.Color(255, 255, 255));
        buttonPower.setText("^");
        buttonPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPowerActionPerformed(evt);
            }
        });

        buttonTimes.setBackground(new java.awt.Color(255, 128, 0));
        buttonTimes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonTimes.setForeground(new java.awt.Color(255, 255, 255));
        buttonTimes.setText("*");
        buttonTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTimesActionPerformed(evt);
            }
        });

        buttonMinus.setBackground(new java.awt.Color(255, 128, 0));
        buttonMinus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonMinus.setForeground(new java.awt.Color(255, 255, 255));
        buttonMinus.setText("-");
        buttonMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinusActionPerformed(evt);
            }
        });

        buttonPlus.setBackground(new java.awt.Color(255, 128, 0));
        buttonPlus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonPlus.setForeground(new java.awt.Color(255, 255, 255));
        buttonPlus.setText("+");
        buttonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlusActionPerformed(evt);
            }
        });

        buttonAC.setBackground(new java.awt.Color(255, 128, 0));
        buttonAC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonAC.setForeground(new java.awt.Color(255, 255, 255));
        buttonAC.setText("AC");
        buttonAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonACActionPerformed(evt);
            }
        });

        buttonEquals.setBackground(new java.awt.Color(255, 128, 0));
        buttonEquals.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonEquals.setForeground(new java.awt.Color(255, 255, 255));
        buttonEquals.setText("=");
        buttonEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEqualsActionPerformed(evt);
            }
        });

        buttonOpenB.setBackground(new java.awt.Color(255, 128, 0));
        buttonOpenB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonOpenB.setForeground(new java.awt.Color(255, 255, 255));
        buttonOpenB.setText("(");
        buttonOpenB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenBActionPerformed(evt);
            }
        });

        buttonCloseB.setBackground(new java.awt.Color(255, 128, 0));
        buttonCloseB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonCloseB.setForeground(new java.awt.Color(255, 255, 255));
        buttonCloseB.setText(")");
        buttonCloseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMinus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTimes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpenB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPower, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(buttonAC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(buttonPlus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCloseB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEquals, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCloseB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpenB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPower, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        inputLabel.setBackground(new java.awt.Color(32, 32, 32));
        inputLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputLabel.setForeground(new java.awt.Color(255, 255, 255));

        resultLabel.setBackground(new java.awt.Color(255, 255, 255));
        resultLabel.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        resultLabel.setText("0");

        jButton1.setBackground(new java.awt.Color(0, 200, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Display expression");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonSpeak.setBackground(new java.awt.Color(0, 200, 0));
        buttonSpeak.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonSpeak.setForeground(new java.awt.Color(255, 255, 255));
        buttonSpeak.setText("Start speech mode");
        buttonSpeak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSpeakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputLabel)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSpeak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputLabel)
                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSpeak))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (isValidPowerChat()) {
            controller.process("1");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (isValidPowerChat()) {
            controller.process("2");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        if (isValidPowerChat()) {
            controller.process("3");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        if (isValidPowerChat()) {
            controller.process("4");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        if (isValidPowerChat()) {
            controller.process("5");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        if (isValidPowerChat()) {
            controller.process("6");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        if (isValidPowerChat()) {
            controller.process("7");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        if (isValidPowerChat()) {
            controller.process("8");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        if (isValidPowerChat()) {
            controller.process("9");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button9ActionPerformed

    private void buttonPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlusActionPerformed
        if (isValidPowerChat()) {
            controller.process("+");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_buttonPlusActionPerformed

    private void buttonMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinusActionPerformed
        if (isValidPowerChat()) {
            controller.process("-");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_buttonMinusActionPerformed

    private void buttonTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTimesActionPerformed
        if (isValidPowerChat()) {
            controller.process("*");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_buttonTimesActionPerformed

    private void buttonPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPowerActionPerformed
        if (isValidPowerChat()) {
            controller.process("^");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_buttonPowerActionPerformed

    private void buttonEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEqualsActionPerformed
        if (isValidPowerChat()) {
            controller.process("=");
            mathExp = "";
            
            mathExp = getLaTeX(inputLabel.getText());
            try {
                writeXMLtoFile(mathExp);
            } catch (IOException ex) {
                Logger.getLogger(CalcView.class.getName()).log(Level.SEVERE, null, ex);
            }
            controller.setUserInput("(" + resultLabel.getText() + ")");

        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }

    }//GEN-LAST:event_buttonEqualsActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        if (isValidPowerChat()) {
            controller.process("0");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }    }//GEN-LAST:event_button11ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        controller.backspace();
    }//GEN-LAST:event_button12ActionPerformed

    private void buttonACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonACActionPerformed
        pressAC();
    }//GEN-LAST:event_buttonACActionPerformed

    private void buttonOpenBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenBActionPerformed
       
        controller.process("(");
    }//GEN-LAST:event_buttonOpenBActionPerformed

    private void buttonCloseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseBActionPerformed
        
        if (isValidPowerChat()) {
            controller.process(")");
        } else {
            JOptionPane.showMessageDialog(rootPane, "You Must Open A Bracket After \"^\"");
        }
    }//GEN-LAST:event_buttonCloseBActionPerformed

    private void buttonSpeakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSpeakActionPerformed
       
        pressSpeak();

    }//GEN-LAST:event_buttonSpeakActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        mathExp += "\n" + controller.getExpression();
        JOptionPane.showMessageDialog(rootPane, mathExp);
        controller.reset();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button1;
    private javax.swing.JButton button11;
    private javax.swing.JButton button12;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonAC;
    private javax.swing.JButton buttonCloseB;
    private javax.swing.JButton buttonEquals;
    private javax.swing.JButton buttonMinus;
    private javax.swing.JButton buttonOpenB;
    private javax.swing.JButton buttonPlus;
    private javax.swing.JButton buttonPower;
    private javax.swing.JButton buttonSpeak;
    private javax.swing.JButton buttonTimes;
    private javax.swing.JTextField inputLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel resultLabel;
    // End of variables declaration//GEN-END:variables
}

package controller;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.*;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CalcModel;
import view.CalcView;


public class CalcController {

    CalcModel model = new CalcModel();
    CalcView view;
    String UserInput = "";
    Boolean flag=false;
    Recognizer recognizer;
    Microphone microphone;

    public CalcController() {
        this.view = view;
    }
    public CalcController(CalcView view) {
        this.view = view;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setUpVoice() {

        try {

            URL url;
            url = CalcController.class.getResource("calc.config.xml");
            System.out.println("Loading..."+url);
            ConfigurationManager cm = new ConfigurationManager(url);
            
            recognizer = (Recognizer) cm.lookup("recognizer");
            recognizer.allocate();
            System.out.println("Recognizer Allocated: "+recognizer);
            microphone = (Microphone) cm.lookup("microphone");
            System.out.println("Microphone Allocated: "+microphone); 
            
            flag = false;
            startVoice();

        } catch (PropertyException e) {
            System.err.println("Problem loading the calculator: ");
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
        } 
       
    }

    public void clear() {
        view.pressAC();
    }

    public void startVoice() {
        
        if (microphone.startRecording()) {

            System.out.println("Microphone is on\n" + "-----------------\n"
                    + "Say: \n"
                    + "Start speech input/disable speech\n"
                    + "OR a digit 0-9\n"
                    + "OR plus/minus/times/to the power/open bracket/close bracket/equals\n"
                    + "OR clear/delete\n-----------------");

            while (true) {

                Result result = recognizer.recognize();
                if (result != null) {
                    System.out.println("Please speak the expression to be calculated");
                    String resultText = result.getBestFinalResultNoFiller();
                    System.out.println("Result Text: "+ resultText);
                    if ("start speech input".equalsIgnoreCase(resultText)) {
                        System.out.println("I'm Listening");
                        view.pressSpeak();
                    } else if (!flag) {
                        System.out.println("You said something but the calculator is not in speech mode");
                        continue;
                    } else if ("one".equalsIgnoreCase(resultText)) {
                        process("1");
                    } else if ("two".equalsIgnoreCase(resultText)) {
                        process("2");
                    } else if ("three".equalsIgnoreCase(resultText)) {
                        process("3");
                    } else if ("four".equalsIgnoreCase(resultText)) {
                        process("4");
                    } else if ("five".equalsIgnoreCase(resultText)) {
                        process("5");
                    } else if ("six".equalsIgnoreCase(resultText)) {
                        process("6");
                    } else if ("seven".equalsIgnoreCase(resultText)) {
                        process("7");
                    } else if ("eight".equalsIgnoreCase(resultText)) {
                        process("8");
                    } else if ("nine".equalsIgnoreCase(resultText)) {
                        process("9");
                    } else if ("zero".equalsIgnoreCase(resultText)) {
                        process("0");
                    } else if ("minus".equalsIgnoreCase(resultText)) {
                        process("-");
                    } else if ("times".equalsIgnoreCase(resultText)) {
                        process("*");
                    } else if ("plus".equalsIgnoreCase(resultText)) {
                        process("+");
                    } else if ("equals".equalsIgnoreCase(resultText)) {
                        process("=");
                    } else if ("to the power".equalsIgnoreCase(resultText)) {
                        process("^");
                    } else if ("open bracket".equalsIgnoreCase(resultText)) {
                        process("(");
                    } else if ("close bracket".equalsIgnoreCase(resultText)) {
                        process(")");
                    } else if ("clear".equalsIgnoreCase(resultText)) {
                        clear();
                    } else if ("delete".equalsIgnoreCase(resultText)) {
                        backspace();
                    } else if ("disable speech".equalsIgnoreCase(resultText)) {
                        view.pressSpeak();
                    }
                } else {
                    System.out.println("I can't hear what you said.\n");
                }
            }
        } else {
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
            System.exit(1);
        }
    }

    public String getUserInput() {
        return UserInput;
    }

    public void setUserInput(String UserInput) {
        this.UserInput = UserInput;
    }

    public void setResult(int result) {
        model.setResult(result);
    }

    public void backspace() {
        if(UserInput.length()!=0){
        String temp = UserInput.substring(0, UserInput.length() - 1);
        UserInput = temp;
        view.setInputLabel(UserInput);
        view.sayThis("Deleting");
        }
        else{
            view.sayThis("Nothing to delete");
        }
    }

    public void reset() {
        model.reset();
    }

    public String getExpression() {
        return model.getExpressionToBeSpoken();
    }

    public void process(String str) {
        //  String str = button.getText();
        if ("+".equals(str)) {
            view.sayThis("plus");
        } else if ("-".equals(str)) {
            view.sayThis("minus");
        } else if ("*".equals(str)) {
            view.sayThis("times");
        } else if ("(".equals(str)) {
            view.sayThis("open bracket");
        } else if (")".equals(str)) {
            view.sayThis("close bracket");
        } else if ("^".equals(str)) {
            view.sayThis("to the power of");
        } else {
            view.sayThis(str);
        }
        if (!"=".equals(str)) {
            UserInput += str;
            view.setInputLabel(UserInput);
        } else {
            UserInput = view.getInputLabel();
            model.setInput(UserInput);

            try {
                model.process();
                if (model.getResult() != Integer.MAX_VALUE && model.getResult() != Integer.MIN_VALUE) {
                    view.setResultLabel(model.getResult() + "");
                    view.sayThis(getExpression() + " the result is " + String.valueOf(model.getResult()));
                } else {
                    JOptionPane.showMessageDialog(view.getRootPane(), "Result is too big or too small");
                    view.sayThis("the result is too big");
                    view.pressAC();
                }
            } catch (Exception ex) {
                Logger.getLogger(CalcView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view.getRootPane(), "invalid input");
                view.pressAC();
            }
        }
    }
}

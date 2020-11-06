
package calculator;

import view.CalcView;


public class Main {

    
    public static void main(String[] args) {
        CalcView view = new CalcView();
        view.setVisible(true);
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        view.SpeechTTS();
        view.startVoice();
    }
}

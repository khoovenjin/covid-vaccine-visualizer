package cli;

import dataset.VaxRegData2;
import dataset.env;
import function.FileUtil;
import gui.Dashboard;
import javax.swing.SwingUtilities;
import prolog.PrologKnowledgeBaseFileGenerator;

public class App {
    public static void main(String[] args){
        
        try {
            FileUtil.readVaxCSVFileFromURLToVaxList(env.VAX_MALAYSIA, env.VAX_STATE, new String("Vax"));
            FileUtil.readVaxCSVFileFromURLToVaxList(env.VAX_REG_MALAYSIA, env.VAX_REG_STATE, new String("VaxReg"));
            PrologKnowledgeBaseFileGenerator.createKnowledgebaseFile(VaxRegData2.getAllVaxRegData());
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        
        
        //RUN THIS CLASS SET-UP
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
        }
    
    //Set-up Class as First Page(maingui as my first GUI)
    static void displayJFrame()
    {
        Dashboard VaccineVisualizer = new Dashboard();
        VaccineVisualizer.setVisible(true);
    }
}

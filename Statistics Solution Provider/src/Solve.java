
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMUDS
 */
public class Solve {
    public static void startUpFrame(){
        JFrame menuFrame=new JFrame("Menu");
        menuFrame.setBounds(400, 150, 400, 400);
        menuFrame.setBackground(Color.white);
        Rectangle r=new Rectangle(400, 150, 400, 400);
        menuFrame.setMaximizedBounds(r);
        
        JPanel menuPanel=new JPanel();
        menuPanel.setBounds(401, 301, 398, 398);
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.white);
        
        JLabel topLabel=new JLabel("Statistics");
        topLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        Dimension t=topLabel.getPreferredSize();
        topLabel.setBounds(180, 10, t.width, t.height);
        menuPanel.add(topLabel);
        
        JButton basicStat=new JButton("Basic Statistics");
        basicStat.setFont(new Font("Arial Black", Font.BOLD, 12));
        basicStat.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        basicStat.setBounds(30, 50, 150, 30);
        basicStat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                basicStatButtonActionPerformed(evt);
            }
        });
        menuPanel.add(basicStat);
        
        JButton corReg=new JButton("Correlation and Regression");
        corReg.setFont(new Font("Arial Black", Font.BOLD, 12));
        corReg.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        corReg.setBounds(30, 90, 220, 30);
        corReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                corRegButtonActionPerformed(evt);
            }
        });
        menuPanel.add(corReg);
        
        JButton chisquare=new JButton("Chi-square");
        chisquare.setFont(new Font("Arial Black", Font.BOLD, 12));
        chisquare.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        chisquare.setBounds(30, 130, 100, 30);
        menuPanel.add(chisquare);
        
        JButton help=new JButton("Help");
        help.setFont(new Font("Arial Black", Font.BOLD, 10));
        help.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        help.setBounds(400, 400, 50, 20);
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed(evt, "Menu");
            }
        });
        menuPanel.add(help);
        
        menuFrame.add(menuPanel);
        menuFrame.setSize(500,500);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void helpButtonActionPerformed(ActionEvent evt, String frame){
        switch (frame){
            case "Menu":
                JOptionPane.showMessageDialog(null, String.format("Click on Basic Statistics if you wish to calculate the mean, median, mode, mean deviation,.... etc for both grouped and ungrouped data\n\nClick on Correlation and Regression to compute correlation coefficient, fit regression line, calculate standard error etc\n\nClick on Chi-square to make calculation using chi square calc and tab"), "Help", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Grouped or Ungrouped":
                JOptionPane.showMessageDialog(null, String.format("Click on Grouped if you have a grouped data i.e frequency for each class interval has been given\nClick on Ungrouped if you are only given the  class interval and need to fix the frequencies from the data given", "Help", JOptionPane.INFORMATION_MESSAGE));
                break;
        }
    }
    private static JFrame basicStatFrame;
    public static void basicStatButtonActionPerformed(ActionEvent evt){
        basicStatFrame=new JFrame("Basic Statistics");
        basicStatFrame.setBounds(400, 150, 400, 400);
        basicStatFrame.setBackground(Color.white);
        
        JPanel basicStatPanel=new JPanel();
        basicStatPanel.setBounds(401, 301, 398, 398);
        basicStatPanel.setLayout(null);
        basicStatPanel.setBackground(Color.white);
        
        JLabel topLabel=new JLabel("Basic Statistics");
        topLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        Dimension t=topLabel.getPreferredSize();
        topLabel.setBounds(100, 10, t.width, t.height);
        basicStatPanel.add(topLabel);
        
        JButton grouped=new JButton("Grouped Data");
        grouped.setFont(new Font("Arial Black", Font.BOLD, 12));
        grouped.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        grouped.setBounds(30, 50, 150, 30);
        grouped.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                groupedButtonActionPerformed(evt);
            }
        });
        basicStatPanel.add(grouped);
        
        JButton ungrouped=new JButton("Ungrouped Data");
        ungrouped.setFont(new Font("Arial Black", Font.BOLD, 12));
        ungrouped.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        ungrouped.setBounds(30, 90, 170, 30);
        ungrouped.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ungroupedButtonActionPerformed(evt);
            }
        });
        basicStatPanel.add(ungrouped);
        
        JButton back=new JButton("Back");
        back.setFont(new Font("Arial Black", Font.BOLD, 12));
        back.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        back.setBounds(30, 350, 80, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        basicStatPanel.add(back);

        JButton help=new JButton("Help");
        help.setFont(new Font("Arial Black", Font.BOLD, 10));
        help.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        help.setBounds(400, 400, 50, 20);
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed(evt, "Grouped or Ungrouped");
            }
        });
        basicStatPanel.add(help);
        
        basicStatFrame.add(basicStatPanel);
        basicStatFrame.setSize(500,500);
        basicStatFrame.setVisible(true);
        basicStatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static JTextField lowerClassField;
    private static JTextField upperClassField;
    private static JTextField nOfClassField;
    private static JTextField nField;
    private static JTextField highestDataField;
    public static void groupedButtonActionPerformed(ActionEvent evt){
        JFrame groupedFrame=new JFrame("Grouped Data");
        groupedFrame.setBounds(400, 150, 400, 400);
        groupedFrame.setBackground(Color.white);
        
        JPanel groupedPanel=new JPanel();
        groupedPanel.setBounds(401, 301, 398, 398);
        groupedPanel.setLayout(null);
        groupedPanel.setBackground(Color.white);
        
        JLabel topLabel=new JLabel("Grouped Data");
        topLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        Dimension t=topLabel.getPreferredSize();
        topLabel.setBounds(130, 10, t.width, t.height);
        groupedPanel.add(topLabel);
        
        JLabel lowClassLabel=new JLabel("Enter lower class interval of first class");
        lowClassLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension l=lowClassLabel.getPreferredSize();
        lowClassLabel.setBounds(10, 50, l.width, l.height);
        groupedPanel.add(lowClassLabel);
        
        lowerClassField=new JTextField();
        lowerClassField.setBackground(Color.WHITE);
        lowerClassField.setBounds(310, 45, 30, 30);
        lowerClassField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        lowerClassField.setFont(new Font("Arial Black",Font.BOLD, 12));
        groupedPanel.add(lowerClassField);
        
        JLabel upClassLabel=new JLabel("Enter upper class interval of first class");
        upClassLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension u=upClassLabel.getPreferredSize();
        upClassLabel.setBounds(10, 90, u.width, u.height);
        groupedPanel.add(upClassLabel);
        
        upperClassField=new JTextField();
        upperClassField.setBackground(Color.WHITE);
        upperClassField.setBounds(310, 85, 30, 30);
        upperClassField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        upperClassField.setFont(new Font("Arial Black",Font.BOLD, 12));
        groupedPanel.add(upperClassField);
        
        JLabel nClassLabel=new JLabel("Enter number of classes");
        nClassLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension n=nClassLabel.getPreferredSize();
        nClassLabel.setBounds(10, 130, n.width, n.height);
        groupedPanel.add(nClassLabel);
        
        nOfClassField=new JTextField();
        nOfClassField.setBackground(Color.WHITE);
        nOfClassField.setBounds(205, 120, 30, 30);
        nOfClassField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        nOfClassField.setFont(new Font("Arial Black",Font.BOLD, 12));
        groupedPanel.add(nOfClassField);
        
        JButton done=new JButton("Done");
        done.setFont(new Font("Arial Black", Font.BOLD, 12));
        done.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        done.setBounds(30, 350, 150, 30);
        done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doneButtonActionPerformed(evt, "grouped");
            }
        });
        groupedPanel.add(done);
        
        groupedFrame.add(groupedPanel);
        groupedFrame.setSize(500,500);
        groupedFrame.setVisible(true);
        groupedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void ungroupedButtonActionPerformed(ActionEvent evt){
        JFrame ungroupedFrame=new JFrame("Ungrouped Data");
        ungroupedFrame.setBounds(400, 150, 400, 400);
        ungroupedFrame.setBackground(Color.white);
        
        JPanel ungroupedPanel=new JPanel();
        ungroupedPanel.setBounds(401, 301, 398, 398);
        ungroupedPanel.setLayout(null);
        ungroupedPanel.setBackground(Color.white);
        
        JLabel topLabel=new JLabel("Ungrouped Data");
        topLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        Dimension t=topLabel.getPreferredSize();
        topLabel.setBounds(130, 10, t.width, t.height);
        ungroupedPanel.add(topLabel);
        
        JLabel lowClassLabel=new JLabel("Enter lower class interval of first class");
        lowClassLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension l=lowClassLabel.getPreferredSize();
        lowClassLabel.setBounds(10, 50, l.width, l.height);
        ungroupedPanel.add(lowClassLabel);
        
        lowerClassField=new JTextField();
        lowerClassField.setBackground(Color.WHITE);
        lowerClassField.setBounds(310, 45, 30, 30);
        lowerClassField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        lowerClassField.setFont(new Font("Arial Black",Font.BOLD, 12));
        ungroupedPanel.add(lowerClassField);
        
        JLabel upClassLabel=new JLabel("Enter upper class interval of first class");
        upClassLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension u=upClassLabel.getPreferredSize();
        upClassLabel.setBounds(10, 90, u.width, u.height);
        ungroupedPanel.add(upClassLabel);
        
        upperClassField=new JTextField();
        upperClassField.setBackground(Color.WHITE);
        upperClassField.setBounds(310, 85, 30, 30);
        upperClassField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        upperClassField.setFont(new Font("Arial Black",Font.BOLD, 12));
        ungroupedPanel.add(upperClassField);
        
        JLabel nLabel=new JLabel("Enter number of data");
        nLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension n=nLabel.getPreferredSize();
        nLabel.setBounds(10, 130, n.width, n.height);
        ungroupedPanel.add(nLabel);
        
        nField=new JTextField();
        nField.setBackground(Color.WHITE);
        nField.setBounds(205, 120, 30, 30);
        nField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        nField.setFont(new Font("Arial Black",Font.BOLD, 12));
        ungroupedPanel.add(nField);
        
        JLabel highestDataLabel=new JLabel("Enter the highest data");
        highestDataLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension h=highestDataLabel.getPreferredSize();
        highestDataLabel.setBounds(10, 170, h.width, h.height);
        ungroupedPanel.add(highestDataLabel);
        
        highestDataField=new JTextField();
        highestDataField.setBackground(Color.WHITE);
        highestDataField.setBounds(205, 160, 30, 30);
        highestDataField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        highestDataField.setFont(new Font("Arial Black",Font.BOLD, 12));
        ungroupedPanel.add(highestDataField);
        
        JButton done=new JButton("Done");
        done.setFont(new Font("Arial Black", Font.BOLD, 12));
        done.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        done.setBounds(30, 350, 150, 30);
        done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doneButtonActionPerformed(evt, "ungrouped");
            }
        });
        ungroupedPanel.add(done);
        
        ungroupedFrame.add(ungroupedPanel);
        ungroupedFrame.setSize(500,500);
        ungroupedFrame.setVisible(true);
        ungroupedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static JTextField[] frequencyField;
    private static JFrame solutionFrame;
    private static JPanel solutionPanel;
    private static int nClass;
    private static double min[];
    private static double max[];
    private static double kurtosis[];
    private static double skewness[];
    public static int f[];
    public static void doneButtonActionPerformed(ActionEvent evt, String status){
        double lowClass=0;
        double upClass=0;
        nClass=0;
        try{
            lowClass=Double.parseDouble(lowerClassField.getText());
            upClass=Double.parseDouble(upperClassField.getText());
            if(status.equalsIgnoreCase("grouped"))
                nClass=Integer.parseInt(nOfClassField.getText());
            else if(status.equalsIgnoreCase("ungrouped")){
                double highestData=Double.parseDouble(highestDataField.getText());
            double testUpClass=upClass;
            for(int i=1; i>=1; i++){
                testUpClass+=(upClass-lowClass+1);
                if(testUpClass>=highestData){
                    nClass=i+1;
                    break;
                }
            }
            }
        }catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "Fill all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
        }
        
        //Collection of data
        int N=0;
        if(status.equalsIgnoreCase("ungrouped")){
            N=Integer.parseInt(nField.getText());
        }
        double data[]=new double[N+1];
        if(status.equalsIgnoreCase("ungrouped")){
            for(int i=1; i<=N; i++){
            data[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "Enter data "+i, "Population given", JOptionPane.QUESTION_MESSAGE));
        }
        }
        min=new double[nClass+1];
        max=new double[nClass+1];
        min[1]=lowClass;
        max[1]=upClass;
        frequencyField=new JTextField[nClass+1];
        for(int i=1; i<=nClass; i++){
            frequencyField[i]=new JTextField();
            frequencyField[i].setBackground(Color.white);
            frequencyField[i].setForeground(Color.red);
            frequencyField[i].setFont(new Font("Arial Black", Font.BOLD, 12));
            if(i==1)
                continue;
            min[i]=min[i-1]+(upClass-lowClass+1);
            max[i]=max[i-1]+(upClass-lowClass+1);
        }
        solutionFrame=new JFrame("Solution");
        solutionPanel=new JPanel();
        solutionPanel.setLayout(null);
        solutionPanel.setBounds(0, 0, 1000, 500);
        solutionPanel.setBackground(Color.white);
        
        JLabel titleLabel=new JLabel("Class interval     f     x         fx    cumfreq   |x-mean| f|x-mean| (x-mean)^2    f(x-mean)^2    (x-mean)^3    f(x-mean)^3    (x-mean)^4    f(x-mean)^4");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        titleLabel.setBounds(5, 5, titleLabel.getPreferredSize().width, titleLabel.getPreferredSize().height);
        solutionPanel.add(titleLabel);
            
        for(int i=1; i<=nClass; i++){
            JLabel classInterval=new JLabel(String.format("%.0f-%.0f\n", min[i], max[i]));
            classInterval.setFont(new Font("Arial Black", Font.BOLD, 12));
            classInterval.setBounds(5, 5+35*i, classInterval.getPreferredSize().width, classInterval.getPreferredSize().height);
            solutionPanel.add(classInterval);
            frequencyField[i].setBounds(90, 35*i, 30, 30);
            solutionPanel.add(frequencyField[i]);
        }
        f=new int[nClass+1];
        //Tally deduction
        if(status.equalsIgnoreCase("ungrouped")){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=nClass; j++){
                    if(data[i]>=min[j]&&data[i]<=max[j]){
                        f[j]++;
                    }
                }
            }
        }
        
        //Fixation of tally
        if(status.equalsIgnoreCase("ungrouped")){
            for(int j=1; j<=nClass; j++){
                frequencyField[j].setText(""+f[j]);
            }
        }
        JButton startGrouped=new JButton("Start");
        startGrouped.setFont(new Font("Arial Black", Font.BOLD, 10));
        startGrouped.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        startGrouped.setBounds(20, 35*nClass+40, 50, 20);
        startGrouped.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        solutionPanel.add(startGrouped);
        
        solutionFrame.add(solutionPanel);
        solutionFrame.setSize(1000, 500);
        solutionFrame.setVisible(true);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private static double mean=0;
    private static double median=0; 
    private static double mode=0;
    private static double meanDeviation=0;
    private static double standardDeviation=0;
    private static double variance;
    public static void startButtonActionPerformed(ActionEvent evt){
        try{
            for(int i=1; i<=nClass; i++){
                f[i]=Integer.parseInt(frequencyField[i].getText());
            }
        }catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "Fill all the frequency fileds with appropriate integers", "Error", JOptionPane.ERROR_MESSAGE);
            //System.exit(0);
        }
        //mean
        double x[]=new double[nClass+1];
        double fx[]=new double[nClass+1];
        double sumfx=0;
        //median and mode
        int n=0;
        int cumfreq[]=new int[nClass+1];
        int medianClass=0;
        int modalClass=0;
        //mean deviation
        double xmxb[]=new double[nClass+1];
        double fxmxb[]=new double[nClass+1];
        double sumfxmxb=0;
        //Standard deviation and variance
        double xmxbs[]=new double[nClass+1];
        double fxmxbs[]=new double[nClass+1];
        double sumfxmxbs=0;
        //Skewness
        double xmxbc[]=new double[nClass+1];
        double fxmxbc[]=new double[nClass+1];
        double sumfxmxbc=0;
        //Kurtosis
        double xmxbq[]=new double[nClass+1];
        double fxmxbq[]=new double[nClass+1];
        double sumfxmxbq=0;
        
        kurtosis=new double[3]; //two formulae for kurtosis
        skewness=new double[4]; //three formulae for skewness
        
        //mean etc...
        for(int i=1; i<=nClass; i++){
            x[i]=(min[i]+max[i])/2;
            fx[i]=f[i]*x[i];
            cumfreq[i]=cumfreq[i-1]+f[i];
            sumfx=sumfx+fx[i];
            n=n+f[i];
        }
        mean=sumfx/n;
        //median, mode, mean deviation
        int highestFrequency=0;
        for(int i=1; i<=nClass; i++){
            //median
            if(cumfreq[i]==0.5*n||(cumfreq[i]>0.5*n && cumfreq[i-1]<0.5*n)){
                medianClass=i;
            }
            //mode
            if(f[i]>highestFrequency){
                highestFrequency=f[i];
                modalClass=i;
            }
            //mean deviation
            xmxb[i]=Math.abs(x[i]-mean);
            fxmxb[i]=f[i]*xmxb[i];
            sumfxmxb=sumfxmxb+fxmxb[i];
            
            //Standard deviation/Variance
            xmxbs[i]=Math.pow(xmxb[i], 2);
            fxmxbs[i]=f[i]*xmxbs[i];
            sumfxmxbs+=fxmxbs[i];
            
            //Skewness
            xmxbc[i]=Math.pow(xmxb[i], 3);
            fxmxbc[i]=f[i]*xmxbc[i];
            sumfxmxbc=sumfxmxbc+fxmxbc[i];
            
            //Kurtosis
            xmxbq[i]=Math.pow(xmxb[i], 4);
            fxmxbq[i]=f[i]*xmxbq[i];
            sumfxmxbq=sumfxmxbq+fxmxbq[i];
        }
        //Printing results
        String result="";
        result+="x\tfx\tcumfreq \t |x-mean| \t f|x-mean| \t (x-mean)^2 \t f(x-mean)^2 \t (x-mean)^3 \t f(x-mean)^3 \t (x-mean)^4 \t f(x-mean)^4";
        for(int i=1; i<=nClass; i++){
            JLabel xLabel=new JLabel(""+x[i]);
            xLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xLabel.setBounds(130, 5+35*i, xLabel.getPreferredSize().width, xLabel.getPreferredSize().height);
            solutionPanel.add(xLabel);
            
            JLabel fxLabel=new JLabel(""+fx[i]);
            fxLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            fxLabel.setBounds(180, 5+35*i, fxLabel.getPreferredSize().width, fxLabel.getPreferredSize().height);
            solutionPanel.add(fxLabel);
            
            JLabel cumfreqLabel=new JLabel(""+cumfreq[i]);
            cumfreqLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            cumfreqLabel.setBounds(280, 5+35*i, cumfreqLabel.getPreferredSize().width, cumfreqLabel.getPreferredSize().height);
            solutionPanel.add(cumfreqLabel);
            
            JLabel xmxbLabel=new JLabel(String.format("%.2f\t eeee", xmxb[i]));
            xmxbLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xmxbLabel.setBounds(380, 5+35*i, xmxbLabel.getPreferredSize().width, xmxbLabel.getPreferredSize().height);
            solutionPanel.add(xmxbLabel);
            
            JLabel fxmxbLabel=new JLabel(String.format("%.2f", fxmxb[i]));
            fxmxbLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            fxmxbLabel.setBounds(480, 5+35*i, fxmxbLabel.getPreferredSize().width, fxmxbLabel.getPreferredSize().height);
            solutionPanel.add(fxmxbLabel);
            
            JLabel xmxbsLabel=new JLabel(String.format("%.2f", xmxbs[i]));
            xmxbsLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xmxbsLabel.setBounds(580, 5+35*i, xmxbsLabel.getPreferredSize().width, xmxbsLabel.getPreferredSize().height);
            solutionPanel.add(xmxbsLabel);
            
            JLabel fxmxbsLabel=new JLabel(String.format("%.2f", fxmxbs[i]));
            fxmxbsLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            fxmxbsLabel.setBounds(680, 5+35*i, fxmxbsLabel.getPreferredSize().width, fxmxbsLabel.getPreferredSize().height);
            solutionPanel.add(fxmxbsLabel);
            
            JLabel xmxbcLabel=new JLabel(String.format("%.2f", xmxbc[i]));
            xmxbcLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xmxbcLabel.setBounds(780, 5+35*i, xmxbcLabel.getPreferredSize().width, xmxbcLabel.getPreferredSize().height);
            solutionPanel.add(xmxbcLabel);
            
            JLabel fxmxbcLabel=new JLabel(String.format("%.2f", fxmxbc[i]));
            fxmxbcLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            fxmxbcLabel.setBounds(880, 5+35*i, fxmxbcLabel.getPreferredSize().width, fxmxbcLabel.getPreferredSize().height);
            solutionPanel.add(fxmxbcLabel);
            
            JLabel xmxbqLabel=new JLabel(String.format("%.2f", xmxbq[i]));
            xmxbqLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xmxbqLabel.setBounds(980, 5+35*i, xmxbqLabel.getPreferredSize().width, xmxbqLabel.getPreferredSize().height);
            solutionPanel.add(xmxbqLabel);
            
            JLabel fxmxbqLabel=new JLabel(String.format("%.2f", fxmxbq[i]));
            fxmxbqLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            fxmxbqLabel.setBounds(1080, 5+35*i, fxmxbqLabel.getPreferredSize().width, fxmxbqLabel.getPreferredSize().height);
            solutionPanel.add(fxmxbqLabel);
            
            result+=String.format("\n%.2f\t%.2f\t%d\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t", x[i], fx[i], cumfreq[i], xmxb[i], fxmxb[i], xmxbs[i], fxmxbs[i], xmxbc[i], fxmxbc[i], xmxbq[i], fxmxbq[i]);
            
        }
        System.out.println(result);
        median=min[medianClass]-0.5+(0.5*n-cumfreq[medianClass-1])*(max[medianClass]-min[medianClass]+1)/f[medianClass];
        int fAMC;  //frequency after modal class
        fAMC=(modalClass==nClass)?0:f[modalClass+1];
        mode=min[modalClass]-0.5+(f[modalClass]-f[modalClass-1])*(max[modalClass]-min[modalClass]+1)/(2*f[modalClass]-fAMC-f[modalClass-1]);
        meanDeviation=sumfxmxb/n;
        variance=sumfxmxbs/n;
        standardDeviation=Math.sqrt(variance);
        
        //Percentile and Dencile
        String answerPanel="";
        int dClass[]=new int[11];
        double d[]=new double[11];
        for(int i=1; i<=10; i++){
            if(i==1){
                answerPanel="Dencile and Percentile";
            }
            for(int j=1; j<=nClass; j++){
                if(cumfreq[j]==0.1*i*n||(cumfreq[j]>0.1*i*n && cumfreq[j-1]<0.1*i*n)){
                dClass[i]=j;
                }      
            }
            d[i]=min[dClass[i]]-0.5+(0.1*i*n-cumfreq[dClass[i]-1])*(max[dClass[i]]-min[dClass[i]]+1)/f[dClass[i]];
            answerPanel=answerPanel+String.format("\nD%d=%.2f, P%d=%.2f", i, d[i], i*10, d[i]);
        }
        
        //Quartile
        int qClass[]=new int[5];
        double q[]=new double[5];
        for(int i=1; i<=4; i++){
            if(i==1){
                answerPanel=answerPanel+"\n\nQuartile";
            }
            for(int j=1; j<=nClass; j++){
                if(cumfreq[j]==0.25*i*n||(cumfreq[j]>0.25*i*n && cumfreq[j-1]<0.25*i*n)){
                qClass[i]=j;
                }      
            }
            q[i]=min[qClass[i]]-0.5+(0.25*i*n-cumfreq[qClass[i]-1])*(max[qClass[i]]-min[qClass[i]]+1)/f[qClass[i]];
            answerPanel=answerPanel+String.format("\nQ%d=%.2f",i,q[i]);
        }
        
        kurtosis[1]=0.5*(q[3]-q[1])/(d[9]-d[1]);
        kurtosis[2]=sumfxmxbq/((n-1)*Math.pow(standardDeviation, 4));
        
        skewness[1]=(mean-mode)/standardDeviation;
        skewness[2]=3*(mean-median)/standardDeviation;
        skewness[3]=sumfxmxbc/((n-1)*Math.pow(standardDeviation, 3));
        
        
        answerPanel=answerPanel+String.format("\n\nSkewness\nSkewness from (mean-mode)/SD=%.4f\nSkewness from 3(mean-median)/SD=%.4f\nSkewness from sumf(x-xbar)^3/(n-1)SD=%.4f\n\n\nKurtosis\nKurtosis from (QandP)=%.4f\n Kurtosis from sumf(x-xbar)^4/(n-1)SD=%.4f",skewness[1], skewness[2], skewness[3], kurtosis[1], kurtosis[2]);

        
        
        JLabel answerLabel=new JLabel(String.format("Mean=%.2f, Median=%.2f, Mode=%.2f, Mean Deviation=%.2f, Variance=%.2f, Standard deviation=%.2f, Kurtosis=%.2f, Skewness=%.2f", mean, median, mode, meanDeviation, variance, standardDeviation, kurtosis[2], skewness[3]));
        answerLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        answerLabel.setBounds(10, 35*nClass+65, answerLabel.getPreferredSize().width, answerLabel.getPreferredSize().height);
        JOptionPane.showMessageDialog(null, answerPanel, "Answer", JOptionPane.INFORMATION_MESSAGE);
        solutionPanel.add(answerLabel);
        
        solutionFrame.add(solutionPanel);
        solutionFrame.setSize(1001, 501);
    }
    
    private static JTextField xField[];
    private static JTextField yField[];
    private static JFrame corRegFrame;
    private static JPanel corRegPanel;
    private static int nCorReg;
    public static void corRegButtonActionPerformed(ActionEvent evt){
        nCorReg=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the lenght of the population:", "Value of n", JOptionPane.QUESTION_MESSAGE));
        corRegFrame=new JFrame("Correlation and Regression");
        corRegFrame.setBounds(10, 10, 1200, 700);
        corRegFrame.setBackground(Color.white);
        
        corRegPanel=new JPanel();
        corRegPanel.setBounds(401, 301, 398, 398);
        corRegPanel.setLayout(null);
        corRegPanel.setBackground(Color.white);
        
        JLabel topLabel=new JLabel("Correlation and Regression");
        topLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        Dimension t=topLabel.getPreferredSize();
        topLabel.setBounds(370, 10, t.width, t.height);
        corRegPanel.add(topLabel);
        
        JLabel listLabel=new JLabel("s/n    x      y");
        listLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        Dimension l=listLabel.getPreferredSize();
        listLabel.setBounds(10, 50, l.width, l.height);
        corRegPanel.add(listLabel);
        
        xField=new JTextField[nCorReg+1];
        yField=new JTextField[nCorReg+1];
        
        for(int i=1; i<=nCorReg; i++){
            xField[i]=new JTextField();
            yField[i]=new JTextField();
            
            xField[i].setBounds(40, 40+35*i, 30, 30);
            yField[i].setBounds(80, 40+35*i, 30, 30);
            
            xField[i].setBackground(Color.WHITE);
            yField[i].setBackground(Color.WHITE);
            
            xField[i].setFont(new Font("Arial Black", Font.BOLD, 12));
            yField[i].setFont(new Font("Arial Black", Font.BOLD, 12));
            
            xField[i].setForeground(Color.red);
            yField[i].setForeground(Color.red);
            
            JLabel snLabel=new JLabel(""+i);
            snLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            Dimension s=snLabel.getPreferredSize();
            snLabel.setBounds(10, 43+35*i, s.width, s.height);
            corRegPanel.add(snLabel);
            
            corRegPanel.add(xField[i]);
            corRegPanel.add(yField[i]);
        }
        
        JButton doneCorReg=new JButton("Done");
        doneCorReg.setFont(new Font("Arial Black", Font.BOLD, 12));
        doneCorReg.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        doneCorReg.setBounds(30, 35*nCorReg+100, 70, 30);
        doneCorReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doneCorRegButtonActionPerformed(evt);
                doneCorReg.setEnabled(false);
            }
        });
        corRegPanel.add(doneCorReg);
        corRegFrame.add(corRegPanel);
        corRegFrame.setSize(1200,700);
        corRegFrame.setVisible(true);
        corRegFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void doneCorRegButtonActionPerformed(ActionEvent evt){
        double x[]=new double[nCorReg+1];
        double y[]=new double[nCorReg+1];
        double xs[]=new double[nCorReg+1];
        double ys[]=new double[nCorReg+1];
        double xy[]=new double[nCorReg+1];
        double yCap[]=new double[nCorReg+1];
        double yMinYCap[]=new double[nCorReg+1];
        double yMinYCaps[]=new double[nCorReg+1];
        
        double sumx=0;
        double sumy=0;
        double sumxy=0;
        double sumxs=0;
        double sumys=0;
        double sumYMinYCaps=0;
        
        //Regression
        double alpha=0;
        double beta=0;
        double standardError=0;
        
        //Correlation
        double momentCorrelationCoefficient=0;
        double rankCorrelationCoefficient=0;
        double rX[]=new double[nCorReg+1];
        double rY[]=new double[nCorReg+1];
        double d[]=new double[nCorReg+1];
        double ds[]=new double[nCorReg+1];
        double sumDs=0;
        
        try{
            for(int i=1; i<=nCorReg; i++){
                x[i]=Double.parseDouble(xField[i].getText());
                y[i]=Double.parseDouble(yField[i].getText());
            }
        }catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "Fill all the fields with appropriate data", "Empty String", JOptionPane.ERROR_MESSAGE);
        }
        
        for(int i=1; i<=nCorReg; i++){
            xy[i]=x[i]*y[i];
            xs[i]=Math.pow(x[i], 2);
            ys[i]=Math.pow(y[i], 2);
        }
        for(int i=1; i<=nCorReg; i++){
            sumx+=x[i];
            sumy+=y[i];
            sumxy+=xy[i];
            sumxs+=xs[i];
            sumys+=ys[i];
        }
        //alpha and beta
        beta=(nCorReg*sumxy-sumx*sumy)/(nCorReg*sumxs-Math.pow(sumx, 2));
        alpha=(sumy-beta*sumx)/nCorReg;
        //Standard error
        for(int i=1; i<=nCorReg; i++){
            yCap[i]=alpha+beta*x[i];
            yMinYCap[i]=y[i]-yCap[i];
            yMinYCaps[i]=Math.pow(yMinYCap[i], 2);
            sumYMinYCaps+=yMinYCaps[i];
        }
        standardError=Math.sqrt(sumYMinYCaps/(nCorReg-1));
        
        //Moment Correlation Coefficient
        momentCorrelationCoefficient=(nCorReg*sumxy-sumx*sumy)/(Math.sqrt((nCorReg*sumxs-Math.pow(sumx, 2))*(nCorReg*sumys-Math.pow(sumy, 2))));
        
        //Rank Correlation coefficient
        double xNew[]=new double[nCorReg+1];
        double yNew[]=new double[nCorReg+1];
        double rXFinal[]=new double[nCorReg+1];
        double rYFinal[]=new double[nCorReg+1];
        
        //Copying x and y to another variable
        for(int i=1; i<=nCorReg; i++){
            xNew[i]=x[i];
            yNew[i]=y[i];
        }
        //Ascending order
        for(int i=1; i<=nCorReg; i++){
            for(int j=1; j<=nCorReg-1; j++){
                if(xNew[j]>xNew[j+1]){
                    double w=xNew[j];
                    xNew[j]=xNew[j+1];
                    xNew[j+1]=w;
                }
                if(yNew[j]>yNew[j+1]){
                    double w=yNew[j];
                    yNew[j]=yNew[j+1];
                    yNew[j+1]=w;
                }
            }
        }
        //Fixing initial rank
        for(int i=1; i<=nCorReg; i++){
            rX[i]=(double) (i);
            rY[i]=(double) (i);
        }
        
        //Counting repeated numbers and fixing final rank for x
        int countX[]=new int[nCorReg+1];
        int countY[]=new int[nCorReg+1];
        for(int i=1; i<=nCorReg; i++){
            if(i!=1&&(xNew[i]==xNew[i-1])){
                rX[i]=rX[i-1];
                continue;
            }
            for(int j=1; j<=nCorReg; j++){
                if(xNew[i]==xNew[j]){
                    countX[i]++;
                }
            }
            if(countX[i]>1)
                rX[i]=(countX[i]*rX[i]+(countX[i]-1)*(countX[i])/2)/countX[i];
        }
        //Counting repeated numbers and fixing final rank for y
        for(int i=1; i<=nCorReg; i++){
            if(i!=1&&(yNew[i]==yNew[i-1])){
                rY[i]=rY[i-1];
                continue;
            }
            for(int j=1; j<=nCorReg; j++){
                if(yNew[i]==yNew[j]){
                    countY[i]++;
                }
            }
            if(countY[i]>1)
                rY[i]=(countY[i]*rY[i]+(countY[i]-1)*(countY[i])/2)/countY[i];
        }
        
        for(int i=1; i<=nCorReg; i++){
            for(int j=1; j<=nCorReg; j++){
                if(x[i]==xNew[j]){
                    rXFinal[i]=rX[j];
                }
                if(y[i]==yNew[j]){
                    rYFinal[i]=rY[j];
                }
            }
        }
        //Fixing d and d squared
        for(int i=1; i<=nCorReg; i++){
            d[i]=rXFinal[i]-rYFinal[i];
            ds[i]=Math.pow(d[i], 2);
            sumDs+=ds[i];
        }
        rankCorrelationCoefficient=1-6*sumDs/(nCorReg*(Math.pow(nCorReg, 2)-1));
        
        String answer;
        answer=String.format("Regression Line: y = %.4f + %.4fx\nStandard Error=%.4f\nMoment Correlation Coefficient=%.4f\nRank Correlation coefficient=%.4f", alpha, beta, standardError, momentCorrelationCoefficient, rankCorrelationCoefficient);
        
        
        JLabel topTitle=new JLabel("x^2               y^2               xy                 yCap            y-yCap       (y-yCap)^2        Rx      Ry       D       D^2");
        topTitle.setFont(new Font("Arial Black", Font.BOLD, 12));
        topTitle.setBounds(131, 50, topTitle.getPreferredSize().width, topTitle.getPreferredSize().height);
        corRegPanel.add(topTitle);
            
        for(int i=1; i<=nCorReg; i++){
            JLabel xsLabel=new JLabel(""+xs[i]);
            xsLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xsLabel.setBounds(130, 43+35*i, xsLabel.getPreferredSize().width, xsLabel.getPreferredSize().height);
            corRegPanel.add(xsLabel);
            
            JLabel ysLabel=new JLabel(""+ys[i]);
            ysLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            ysLabel.setBounds(230, 43+35*i, ysLabel.getPreferredSize().width, ysLabel.getPreferredSize().height);
            corRegPanel.add(ysLabel);
            
            JLabel xyLabel=new JLabel(""+xy[i]);
            xyLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            xyLabel.setBounds(330, 43+35*i, xyLabel.getPreferredSize().width, xyLabel.getPreferredSize().height);
            corRegPanel.add(xyLabel);
            
            JLabel yCapLabel=new JLabel(String.format("%.4f", yCap[i]));
            yCapLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            yCapLabel.setBounds(430, 43+35*i, yCapLabel.getPreferredSize().width, yCapLabel.getPreferredSize().height);
            corRegPanel.add(yCapLabel);
            
            JLabel yMinYCapLabel=new JLabel(String.format("%.4f", yMinYCap[i]));
            yMinYCapLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            yMinYCapLabel.setBounds(530, 43+35*i, yMinYCapLabel.getPreferredSize().width, yMinYCapLabel.getPreferredSize().height);
            corRegPanel.add(yMinYCapLabel);
            
            JLabel yMinYCapsLabel=new JLabel(String.format("%.4f", yMinYCaps[i]));
            yMinYCapsLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            yMinYCapsLabel.setBounds(630, 43+35*i, yMinYCapsLabel.getPreferredSize().width, yMinYCapsLabel.getPreferredSize().height);
            corRegPanel.add(yMinYCapsLabel);
            
            JLabel rXLabel=new JLabel(String.format("%.2f", rXFinal[i]));
            rXLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            rXLabel.setBounds(730, 43+35*i, rXLabel.getPreferredSize().width, rXLabel.getPreferredSize().height);
            corRegPanel.add(rXLabel);
            
            JLabel rYLabel=new JLabel(String.format("%.2f", rYFinal[i]));
            rYLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            rYLabel.setBounds(780, 43+35*i, rYLabel.getPreferredSize().width, rYLabel.getPreferredSize().height);
            corRegPanel.add(rYLabel);
            
            JLabel dLabel=new JLabel(String.format("%.2f", d[i]));
            dLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            dLabel.setBounds(830, 43+35*i, dLabel.getPreferredSize().width, dLabel.getPreferredSize().height);
            corRegPanel.add(dLabel);
            
            JLabel dsLabel=new JLabel(String.format("%.2f", ds[i]));
            dsLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
            dsLabel.setBounds(880, 43+35*i, dsLabel.getPreferredSize().width, dsLabel.getPreferredSize().height);
            corRegPanel.add(dsLabel);
        }
        JButton showResultCorReg=new JButton("Click here to see the result");
        showResultCorReg.setFont(new Font("Arial Black", Font.BOLD, 12));
        showResultCorReg.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        showResultCorReg.setBounds(30, 35*nCorReg+150, 220, 30);
        showResultCorReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showResultCorRegButtonActionPerformed(evt, answer);
            }
        });
        corRegPanel.add(showResultCorReg);
        corRegFrame.add(corRegPanel);
        corRegFrame.setSize(1201,701);
    }
    public static void showResultCorRegButtonActionPerformed(ActionEvent evt, String answer){
        JOptionPane.showMessageDialog(null, answer, "Answer", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void backButtonActionPerformed(ActionEvent evt){
        basicStatFrame.setVisible(false);
        startUpFrame();
    }
    public static void main(String args[]){
        startUpFrame();
    }
}
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Main{
    void main() {
        Pencerem obj = new Pencerem();
    }
}

class Pencerem extends JFrame {

    int yapilacak_olan_formul = 0;
    ArrayList<Formula> formulListesi = new ArrayList<>();
    int FormulaSayisi = 0;
    String tempSayi = "";
    double firstTerm = 0.0;
    String command;
    int myOpt = 0;
    int newHesap = 1;
    JTextField ekran = new JTextField();

    public Pencerem() {
        setTitle("Calculator");
        setSize(500, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(25,67,80));
        setVisible(true);
        calcPage();

    }


    public void calcPage() {


        int[] punktAnzahl = {0};
        String[] chars = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "C"};
        setSize(500, 650);

        ekran.setBounds(20, 30, 460, 30);
        ekran.setBackground(new Color(255,194,180));
        add(ekran);
        ekran.setVisible(true);
        ekran.setEditable(false);
        ekran.setFont(new Font("Arial", Font.BOLD, 28));
        ekran.setText(String.valueOf(0.0));
        JButton toPage = new JButton("Formulas");
        toPage.setBackground(new Color(157,190,184));
        toPage.setFocusPainted(false);
        toPage.setBounds(200, 525, 100, 50);
        add(toPage);
        toPage.setVisible(true);
        JPanel panelim = new JPanel();
        panelim.setLayout(new GridLayout(5, 4, 5, 5));
        for (String i : chars) {
            JButton b = new JButton(i);
            b.setBackground(new Color(255,136,130));
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                if (i.equals("C")) {
                    ekran.setText(String.valueOf(0.0));
                    punktAnzahl[0]=0;
                    myOpt = 0;
                } else if (i.equals("=")) {
                    hesapinhesap("");
                    ekran.setText(String.valueOf(firstTerm));
                    punktAnzahl[0]=0;
                    newHesap = 1;
                } else if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                    switch (i) {
                        case "+":
                            hesapinhesap("+"); punktAnzahl[0]=0;
                            break;
                        case "-":
                            hesapinhesap("-"); punktAnzahl[0]=0;
                            break;
                        case "*":
                            hesapinhesap("*"); punktAnzahl[0]=0;
                            break;
                        case "/":
                            hesapinhesap("/"); punktAnzahl[0]=0;
                            break;
                    }
                } else {
                    if (myOpt == 0) {
                        if (i.equals(".") && punktAnzahl[0]==1);
                        else {
                            ekran.setText("");
                            ekran.setText(ekran.getText() + i);
                            myOpt = 1;
                            if (i.equals(".")) punktAnzahl[0] = 1;
                        }
                    }
                    else {
                        if (i.equals(".") && punktAnzahl[0]==1);
                        else {
                            ekran.setText(ekran.getText() + i);
                            if (i.equals(".")) punktAnzahl[0] = 1;
                        }
                    }

                }
            });
            panelim.add(b);
        }
        panelim.setBounds(100, 155, 300, 300);
        panelim.setBackground(new Color(25,67,80));
        add(panelim);
        panelim.setVisible(true);

        toPage.addActionListener(e -> {
            panelim.setVisible(false);
            ekran.setVisible(false);
            toPage.setVisible(false);
            formulasPage();
        });
        revalidate();
        repaint();
    }

    public void hesapinhesap(String newCommand) {
        if (newHesap == 1) {
            firstTerm = Double.parseDouble(ekran.getText());
            command = newCommand;
            newHesap = 0;
        } else {
            switch (command) {
                case "+":
                    firstTerm = firstTerm + Double.parseDouble(ekran.getText());
                    command = newCommand;
                    break;
                case "-":
                    firstTerm = firstTerm - Double.parseDouble(ekran.getText());
                    command = newCommand;
                    break;
                case "*":
                    firstTerm = firstTerm * Double.parseDouble(ekran.getText());
                    command = newCommand;
                    break;
                case "/":
                    firstTerm = firstTerm / Double.parseDouble(ekran.getText());
                    command = newCommand;
                    break;
            }
        }

        ekran.setText("0.0");
        myOpt = 0;
    }

    public void formulasPage() {
        JButton toCalcPage = new JButton("Back");
        toCalcPage.setFocusPainted(false);
        toCalcPage.setBackground(new Color(157, 190, 184));
        toCalcPage.setBounds(200, 525, 100, 50);
        add(toCalcPage);
        toCalcPage.setVisible(true);

        JButton buttonNewFormula = new JButton("New Formula");
        buttonNewFormula.setFocusPainted(false);
        buttonNewFormula.setBounds(175, 450, 150, 40);
        add(buttonNewFormula);
        buttonNewFormula.setVisible(true);
        buttonNewFormula.setBackground(new Color(127, 170, 200));

        JLabel maxError = new JLabel("Limit Reached");
        maxError.setForeground(Color.RED);
        maxError.setBounds(0, 430, 500, 20);
        maxError.setHorizontalAlignment(SwingConstants.CENTER);
        add(maxError);
        maxError.setVisible(false);

        JPanel formulasPanel = new JPanel();
        formulasPanel.setOpaque(false);
        formulasPanel.setLayout(new GridLayout(8, 4, 5, 5));
        for (int i = 0; i < FormulaSayisi; i++) {
            int index = i;
            JButton b = new JButton(String.valueOf(i+1));
            b.setFocusPainted(false);
            b.setBackground(new Color(157,190,184));
            b.addActionListener(e -> {
                yapilacak_olan_formul = index;
                toCalcPage.setVisible(false);
                maxError.setVisible(false);
                buttonNewFormula.setVisible(false);

                formulasPanel.setVisible(false);
                formulaUygulamaPage(index);
            });
            formulasPanel.add(b);
        }
        add(formulasPanel);
        formulasPanel.setBounds(20, 30, 460, 400);
        formulasPanel.setVisible(true);
        setBackground(new Color(255,136,130));


        buttonNewFormula.addActionListener(e -> {
            if (FormulaSayisi == 32) {
                maxError.setVisible(true);
            }
            else {
                toCalcPage.setVisible(false);
                buttonNewFormula.setVisible(false);
                formulasPanel.setVisible(false);
                newFormulaPage();
            }
        });

        toCalcPage.addActionListener(e -> {
            calcPage();
            formulasPanel.setVisible(false);
            toCalcPage.setVisible(false);
            buttonNewFormula.setVisible(false);
            maxError.setVisible(false);
            firstTerm = 0.0;
            myOpt = 0;
            revalidate();
            repaint();
        });
        revalidate();
        repaint();
    }

    public void newFormulaPage() {
        int[] punktAnzahl = {0};
        JButton toPage = new JButton();
        toPage.setFocusPainted(false);
        toPage.addActionListener(e -> {
            formulasPage();
        });
        JTextField newFormulaText = new JTextField();
        newFormulaText.setBackground(new Color(255,194,180));
        newFormulaText.setEditable(false);
        newFormulaText.setBounds(20, 30, 460, 30);
        newFormulaText.setFont(new Font("Arial", Font.BOLD, 28));
        newFormulaText.setText("x");
        add(newFormulaText);
        newFormulaText.setVisible(true);
        // int temp = 0; // 0 --> islem        1--> sayi
        ArrayList<String> islemlerFormula = new ArrayList<>();
        ArrayList<Double> sayilarFormula = new ArrayList<>();
        JPanel islemlerPanel = new JPanel();
        islemlerPanel.setLayout(new GridLayout(1, 4, 5, 0));
        String[] islemlerA = {"+", "-", "*", "/"};
        islemlerPanel.setBounds(30, 300, 440, 100);
        add(islemlerPanel);
        islemlerPanel.setVisible(true);

        JButton formulaCancel = new JButton("Cancel");
        formulaCancel.setFocusPainted(false);
        formulaCancel.setBackground(new Color(157, 190, 184));
        formulaCancel.setBounds(100,530,80,40);
        add(formulaCancel);
        formulaCancel.setVisible(true);
        JButton formulaAdd = new JButton("ADD");
        formulaAdd.setFocusPainted(false);
        formulaAdd.setBackground(new Color(157, 190, 184));
        formulaAdd.setBounds(300, 530, 80, 40);
        add(formulaAdd);
        formulaAdd.setVisible(false);

        JPanel sayilarPanel = new JPanel();
        sayilarPanel.setLayout(new GridLayout(4, 3, 5, 5));
        String[] sayilarA = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "OK"};
        for (String i : sayilarA) {
            JButton b = new JButton(i);
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                if (i.equals("OK")) {
                    if (!tempSayi.equals("") && !tempSayi.equals(".")) {
                        sayilarPanel.setVisible(false);
                        islemlerPanel.setVisible(true);
                        formulaAdd.setVisible(true);
                        newFormulaText.setText("(" + newFormulaText.getText() + ")");
                        sayilarFormula.add(Double.parseDouble(tempSayi));
                        tempSayi = "";
                        punktAnzahl[0]=0;
                    }
                } else {
                    if (i.equals(".") && punktAnzahl[0]==1);
                    else {
                        newFormulaText.setText(newFormulaText.getText() + i);
                        tempSayi = tempSayi + i;
                        if (i.equals(".")) punktAnzahl[0]=1;
                    }
                }
            });
            sayilarPanel.add(b);
            b.setBackground(new Color(255,136,130));
            b.setFocusPainted(false);
        }
        sayilarPanel.setOpaque(false);
        sayilarPanel.setBounds(30, 100, 440, 400);
        add(sayilarPanel);
        sayilarPanel.setVisible(false);

        for (String i : islemlerA) {
            JButton b = new JButton(i);
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                newFormulaText.setText(newFormulaText.getText() + i);
                islemlerFormula.add(i);
                islemlerPanel.setVisible(false);
                formulaAdd.setVisible(false);
                sayilarPanel.setVisible(true);
            });
            b.setBackground(new Color(255,136,130));
            b.setFocusPainted(false);
            islemlerPanel.setOpaque(false);
            islemlerPanel.add(b);

        }

        formulaAdd.addActionListener(e -> {
            Formula newFormul = new Formula(sayilarFormula.stream().mapToDouble(d -> d).toArray(), islemlerFormula.toArray(new String[0]));
            formulListesi.add(newFormul);
            FormulaSayisi++;
            newFormulaText.setVisible(false);
            islemlerPanel.setVisible(false);
            sayilarPanel.setVisible(false);
            formulaAdd.setVisible(false);
            formulaCancel.setVisible(false);
            formulasPage();
            revalidate();
            repaint();
        });

        formulaCancel.addActionListener(e -> {
            newFormulaText.setVisible(false);
            islemlerPanel.setVisible(false);
            sayilarPanel.setVisible(false);
            formulaAdd.setVisible(false);
            formulaCancel.setVisible(false);
            formulasPage();
        });


        revalidate();
        repaint();
    }

    public void formulaUygulamaPage(int formulindexi) {
        int[] punktAnzahl = {0};
        int[] newX = {1};
        JButton toFormulasPage = new JButton("Back");
        toFormulasPage.setBackground(new Color(157, 190, 184));
        toFormulasPage.setFocusPainted(false);
        toFormulasPage.setBounds(200, 525, 100, 50); //toFormulasPage
        add(toFormulasPage);
        toFormulasPage.setVisible(true);


        JTextField gosterge = new JTextField();
        gosterge.setBackground(new Color(255,194,180));
        gosterge.setEditable(false);
        gosterge.setBounds(20, 30, 460, 30);
        gosterge.setFont(new Font("Arial", Font.BOLD, 28));     //gosterge
        add(gosterge);
        gosterge.setVisible(true);
        JPanel sayilarPanel = new JPanel();
        sayilarPanel.setLayout(new GridLayout(4, 3, 5, 5));     //sayilarPanel
        String[] sayilarA = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "OK"};
        for (String i : sayilarA) {
            JButton b = new JButton(i);
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                if (i.equals("OK")){
                    if (gosterge.getText().equals(".") || gosterge.getText().isEmpty());
                    else {
                        newX[0] = 1;
                        punktAnzahl[0] = 0;
                        gosterge.setText(String.valueOf(
                                formulListesi.get(formulindexi).formulaCalculate(Double.parseDouble(gosterge.getText()))
                        ));
                    }
                }
                else {
                    if (newX[0] == 1) {
                        if (i.equals(".") && punktAnzahl[0]==1);
                        else {
                            gosterge.setText(i);
                            newX[0] = 0;
                            if(i.equals(".")) punktAnzahl[0] = 1;
                        }
                    }
                    else {
                        if (i.equals(".") && punktAnzahl[0]==1);
                        else {
                            newX[0] = 0;
                            gosterge.setText(gosterge.getText() + i);
                            if(i.equals(".")) punktAnzahl[0] = 1;
                        }
                    }
                }
            });
            sayilarPanel.add(b);
            b.setBackground(new Color(255,136,130));
        }
        sayilarPanel.setBounds(30, 100, 440, 400);
        sayilarPanel.setOpaque(false);
        add(sayilarPanel);
        sayilarPanel.setVisible(true);

        revalidate();
        repaint();
        toFormulasPage.addActionListener(e -> {
            toFormulasPage.setVisible(false);
            gosterge.setVisible(false);
            sayilarPanel.setVisible(false);
            formulasPage();
            revalidate();
            repaint();
        });
    }
}
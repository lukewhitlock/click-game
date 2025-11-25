import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class ClickerGame extends JPanel {

    //instance variables
    private JButton main, home, upgrades, achievements, stats, up1, up2, up3;
    private JPanel centerPanel, centerPanelHome, centerPanelUpgrades, centerPanelAchievements, centerPanelStats;
    private CardLayout cl;
    private JLabel countLabel, up1label, up2label, up3label, ach1, ach2, ach3, ach4, ach5, ach6, ach7, ach8, ach9, stat1, stat2, stat3, stat4;
    private int total, count, increase, autoclkcount, colorcount;
    private String curcolor;
    private boolean foundBlack = false, foundBlue = false, foundCyan = false, foundDarkGray = false, foundGray = false, foundGreen = false,
            foundLightGray = false, foundMagenta = false, foundOrange = false, foundPink = false, foundRed = false, foundWhite = false, foundYellow = false;

    //constructor
    public ClickerGame () {
        setLayout(new BorderLayout());
        total = 0;
        count = 0;
        increase = 1;
        autoclkcount = 0;
        curcolor = "none";
        colorcount = 0;
        Border border = BorderFactory.createLineBorder(Color.black);

        //north panel
        JPanel northPanel = new JPanel(new GridLayout(1, 3));
        add(northPanel, BorderLayout.NORTH);
        northPanel.add(home = new JButton("Home"));
        home.addActionListener(new Listener(1));
        northPanel.add(upgrades = new JButton("Upgrades"));
        upgrades.addActionListener(new Listener(2));
        northPanel.add(achievements = new JButton("Achievements"));
        achievements.addActionListener(new Listener(3));
        northPanel.add(stats = new JButton("Stats"));
        stats.addActionListener(new Listener(4));

        //south panel
        JPanel southPanel = new JPanel(new FlowLayout());
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(countLabel = new JLabel(String.valueOf(count)));

        //center panel
        cl = new CardLayout();
        centerPanel = new JPanel(cl);
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add("a", centerPanelHome = new JPanel(new GridLayout(1, 1)));
        centerPanel.add("b", centerPanelUpgrades = new JPanel(new GridLayout(3, 2)));
        centerPanel.add("c", centerPanelAchievements = new JPanel(new GridLayout(3, 3)));
        centerPanel.add("d", centerPanelStats = new JPanel(new GridLayout(2, 2)));

        //center panel home
        centerPanelHome.add(main = new JButton("Click!"));
        main.setFont(new Font("Arial", Font.PLAIN, 50));
        main.addActionListener(new Clicker());
        main.setContentAreaFilled(false);

        //center panel upgrades
        centerPanelUpgrades.add(up1 = new JButton("Improve Click"));
        up1.addActionListener(new Upgrades(1));
        centerPanelUpgrades.add(up1label = new JLabel("Costs 50 - Current click gives " + increase));
        up1label.setHorizontalAlignment(SwingConstants.CENTER);
        up1label.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelUpgrades.add(up2 = new JButton("Auto Clicker"));
        up2.addActionListener(new Upgrades(2));
        centerPanelUpgrades.add(up2label = new JLabel("Costs 100 - Currently have " + autoclkcount + " auto clickers"));
        up2label.setHorizontalAlignment(SwingConstants.CENTER);
        up2label.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelUpgrades.add(up3 = new JButton("Change to Random Color"));
        up3.addActionListener(new Upgrades(3));
        centerPanelUpgrades.add(up3label = new JLabel("Costs 250 - Current color is " + curcolor));
        up3label.setHorizontalAlignment(SwingConstants.CENTER);
        up3label.setVerticalAlignment(SwingConstants.CENTER);

        //center panel achievements
        centerPanelAchievements.add(ach1 = new JLabel("Reach total of 1000"));
        ach1.setBackground(Color.red);
        ach1.setOpaque(true);
        ach1.setBorder(border);
        ach1.setHorizontalAlignment(SwingConstants.CENTER);
        ach1.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach2 = new JLabel("Reach total of 5000"));
        ach2.setBackground(Color.red);
        ach2.setOpaque(true);
        ach2.setBorder(border);
        ach2.setHorizontalAlignment(SwingConstants.CENTER);
        ach2.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach3 = new JLabel("Reach total of 10000"));
        ach3.setBackground(Color.red);
        ach3.setOpaque(true);
        ach3.setBorder(border);
        ach3.setHorizontalAlignment(SwingConstants.CENTER);
        ach3.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach4 = new JLabel("Get 10 auto clickers"));
        ach4.setBackground(Color.red);
        ach4.setOpaque(true);
        ach4.setBorder(border);
        ach4.setHorizontalAlignment(SwingConstants.CENTER);
        ach4.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach5 = new JLabel("Get 50 auto clickers"));
        ach5.setBackground(Color.red);
        ach5.setOpaque(true);
        ach5.setBorder(border);
        ach5.setHorizontalAlignment(SwingConstants.CENTER);
        ach5.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach6 = new JLabel("Get 100 auto clickers"));
        ach6.setBackground(Color.red);
        ach6.setOpaque(true);
        ach6.setBorder(border);
        ach6.setHorizontalAlignment(SwingConstants.CENTER);
        ach6.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach7 = new JLabel("Change to a new color"));
        ach7.setBackground(Color.red);
        ach7.setOpaque(true);
        ach7.setBorder(border);
        ach7.setHorizontalAlignment(SwingConstants.CENTER);
        ach7.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach8 = new JLabel("Change to 5 unique colors"));
        ach8.setBackground(Color.red);
        ach8.setOpaque(true);
        ach8.setBorder(border);
        ach8.setHorizontalAlignment(SwingConstants.CENTER);
        ach8.setVerticalAlignment(SwingConstants.CENTER);
        centerPanelAchievements.add(ach9 = new JLabel("Find every color (13)"));
        ach9.setBackground(Color.red);
        ach9.setOpaque(true);
        ach9.setBorder(border);
        ach9.setHorizontalAlignment(SwingConstants.CENTER);
        ach9.setVerticalAlignment(SwingConstants.CENTER);

        //center panel stats
        centerPanelStats.add(stat1 = new JLabel("Your clicks are worth " + increase));
        stat1.setHorizontalAlignment(SwingConstants.CENTER);
        stat1.setVerticalAlignment(SwingConstants.CENTER);
        stat1.setFont(new Font("Arial", Font.PLAIN, 20));
        centerPanelStats.add(stat2 = new JLabel("You have " + autoclkcount + " auto clickers"));
        stat2.setHorizontalAlignment(SwingConstants.CENTER);
        stat2.setVerticalAlignment(SwingConstants.CENTER);
        stat2.setFont(new Font("Arial", Font.PLAIN, 20));
        centerPanelStats.add(stat3 = new JLabel("You have found " + colorcount + " unique colors"));
        stat3.setHorizontalAlignment(SwingConstants.CENTER);
        stat3.setVerticalAlignment(SwingConstants.CENTER);
        stat3.setFont(new Font("Arial", Font.PLAIN, 20));
        centerPanelStats.add(stat4 = new JLabel("Your total is " + total));
        stat4.setHorizontalAlignment(SwingConstants.CENTER);
        stat4.setVerticalAlignment(SwingConstants.CENTER);
        stat4.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    //cycles page
    private class Listener implements ActionListener {
        private int n;
        public Listener (int n) {
            this.n = n;
        }
        public void actionPerformed (ActionEvent e) {
            if (n == 1) {
                cl.show(centerPanel, "a");
            }
            else if (n == 2) {
                cl.show(centerPanel, "b");
            }
            else if (n == 3) {
                cl.show(centerPanel, "c");
            }
            else if (n == 4) {
                cl.show(centerPanel, "d");
            }
        }
    }

    //clicker
    private class Clicker implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            count += increase;
            total += increase;
            countLabel.setText(String.valueOf(count));
            stat4.setText("Your total is " + total);
            checkAchievements();
        }
    }

    //autoclicker
    public void autoClicker () {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                count += autoclkcount;
                total += autoclkcount;
                countLabel.setText(String.valueOf(count));
                stat4.setText("Your total is " + total);
                checkAchievements();
            }
        };
        Timer timer = new Timer(5000, taskPerformer);
        timer.start();
    }

    //upgrades
    private class Upgrades implements ActionListener {
        private int n;
        public Upgrades (int n) {
            this.n = n;
        }
        public void actionPerformed (ActionEvent e) {
            if (n == 1 && count >= 50) {
                increase++;
                count -= 50;
                countLabel.setText(String.valueOf(count));
                up1label.setText("Costs 50 - Current click gives " + increase);
                stat1.setText("Your clicks are worth " + increase);
            }
            else if (n == 2 && count >= 100) {
                if (autoclkcount == 0) {
                    autoClicker();
                }
                autoclkcount++;
                count -= 100;
                countLabel.setText(String.valueOf(count));
                up2label.setText("Costs 100 - Currently have " + autoclkcount + " auto clickers");
                stat2.setText("You have " + autoclkcount + " auto clickers");
            }
            else if (n == 3 && count >= 250) {
                count -= 250;
                int x = (int)(Math.random() * 13 + 1);
                if (x == 1) {
                    main.setForeground(Color.black);
                    curcolor = "black";
                    if (foundBlack == false) {
                        colorcount++;
                        foundBlack = true;
                    }
                }
                else if (x == 2) {
                    main.setForeground(Color.blue);
                    curcolor = "blue";
                    if (foundBlue == false) {
                        colorcount++;
                        foundBlue = true;
                    }
                }
                else if (x == 3) {
                    main.setForeground(Color.cyan);
                    curcolor = "cyan";
                    if (foundCyan == false) {
                        colorcount++;
                        foundCyan = true;
                    }
                }
                else if (x == 4) {
                    main.setForeground(Color.darkGray);
                    curcolor = "dark gray";
                    if (foundDarkGray == false) {
                        colorcount++;
                        foundDarkGray = true;
                    }
                }
                else if (x == 5) {
                    main.setForeground(Color.gray);
                    curcolor = "gray";
                    if (foundGray == false) {
                        colorcount++;
                        foundGray = true;
                    }
                }
                else if (x == 6) {
                    main.setForeground(Color.green);
                    curcolor = "green";
                    if (foundGreen == false) {
                        colorcount++;
                        foundGreen = true;
                    }
                }
                else if (x == 7) {
                    main.setForeground(Color.lightGray);
                    curcolor = "light gray";
                    if (foundLightGray == false) {
                        colorcount++;
                        foundLightGray = true;
                    }
                }
                else if (x == 8) {
                    main.setForeground(Color.magenta);
                    curcolor = "magenta";
                    if (foundMagenta == false) {
                        colorcount++;
                        foundMagenta = true;
                    }
                }
                else if (x == 9) {
                    main.setForeground(Color.orange);
                    curcolor = "orange";
                    if (foundOrange == false) {
                        colorcount++;
                        foundOrange = true;
                    }
                }
                else if (x == 10) {
                    main.setForeground(Color.pink);
                    curcolor = "pink";
                    if (foundPink == false) {
                        colorcount++;
                        foundPink = true;
                    }
                }
                else if (x == 11) {
                    main.setForeground(Color.red);
                    curcolor = "red";
                    if (foundRed == false) {
                        colorcount++;
                        foundRed = true;
                    }
                }
                else if (x == 12) {
                    main.setForeground(Color.white);
                    curcolor = "white";
                    if (foundWhite == false) {
                        colorcount++;
                        foundWhite = true;
                    }
                }
                else if (x == 13) {
                    main.setForeground(Color.yellow);
                    curcolor = "yellow";
                    if (foundYellow == false) {
                        colorcount++;
                        foundYellow = true;
                    }
                }
                countLabel.setText(String.valueOf(count));
                up3label.setText("Costs 250 - Current color is " + curcolor);
                stat3.setText("You have found " + colorcount + " unique colors");
            }
            checkAchievements();
        }
    }

    //achievement checker
    public void checkAchievements () {
        if (total >= 1000) {
            ach1.setBackground(Color.green);
        }
        if (total >= 5000) {
            ach2.setBackground(Color.green);
        }
        if (total >= 10000) {
            ach3.setBackground(Color.green);
        }
        if (autoclkcount >= 10) {
            ach4.setBackground(Color.green);
        }
        if (autoclkcount >= 50) {
            ach5.setBackground(Color.green);
        }
        if (autoclkcount >= 100) {
            ach6.setBackground(Color.green);
        }
        if (colorcount >= 1) {
            ach7.setBackground(Color.green);
        }
        if (colorcount >= 5) {
            ach8.setBackground(Color.green);
        }
        if (colorcount == 13) {
            ach9.setBackground(Color.green);
        }
    }

    //driver method
    public static void main (String[] args) {
        JFrame frame = new JFrame("Clicker Game");
        frame.setSize(800, 800);
        frame.setLocation(550, 200);
        frame.setContentPane(new ClickerGame());
        frame.setVisible(true);
    }
}
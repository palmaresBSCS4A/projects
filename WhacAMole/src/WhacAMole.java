
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
/*
\ * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class WhacAMole {
    int boardWidth = 600;
    int boardHeight = 650; 
    int highestScore = 0;
    int score = 0;

    JFrame frame = new JFrame("Whac A Mole");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[] board = new JButton[9];
    ImageIcon moleIcon;
    ImageIcon petIcon;

    JButton currMoleTile;
    JButton currPetTile;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setPetTimer;
    
    private Cursor createCustomCursor() {
    ImageIcon cursorImage = new ImageIcon(getClass().getResource("hammer.png"));
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = cursorImage.getImage();
    Point hotspot = new Point(0, 0);
    return toolkit.createCustomCursor(image, hotspot, "Custom Cursor");
}

    WhacAMole() {
        Cursor customCursor = createCustomCursor();
        frame.setCursor(customCursor);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score: " + Integer.toString(score));
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        frame.add(boardPanel);

        Image petImg = new ImageIcon(getClass().getResource("./mons.png")).getImage();
        petIcon = new ImageIcon(petImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        Image moleImg = new ImageIcon(getClass().getResource("./mole.png")).getImage();
        moleIcon = new ImageIcon(moleImg.getScaledInstance(200,200, Image.SCALE_SMOOTH));
        
        for (int i = 0; i < 9; i++) {
            
    ImageIcon tileImageIcon = new ImageIcon(getClass().getResource("dirt.png"));
    Image backgroundImage = tileImageIcon.getImage();
    ImageButton tile = new ImageButton(backgroundImage);
    
    board[i] = tile;
    boardPanel.add(tile);
    tile.setFocusable(false);
    
    
    
    tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton tile = (JButton) e.getSource();
                    if (tile == currMoleTile) {
                        score += 10;
                        textLabel.setText("Score: " + Integer.toString(score));
                    } else if (tile == currPetTile) {
                        if (score > highestScore) {
                            highestScore = score;
                        }
                        textLabel.setText("Game Over: " + Integer.toString(score));
                        setMoleTimer.stop();
                        setPetTimer.stop();
                        for (int i = 0; i < 9; i++) {
                            board[i].setEnabled(false);
                        }
                        displayEndOptions();
                    }
                }
            });
        }

        setMoleTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currMoleTile != null) {
                    currMoleTile.setIcon(null);
                    currMoleTile = null;
                }
                int num = random.nextInt(9);
                JButton tile = board[num];
                if (currPetTile == tile) return;
                currMoleTile = tile;
                currMoleTile.setIcon(moleIcon);
            }
        });

        setPetTimer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currPetTile != null) {
                    currPetTile.setIcon(null);
                    currPetTile = null;
                }
                int num = random.nextInt(9);
                JButton tile = board[num];
                if (currMoleTile == tile) return;
                currPetTile = tile;
                currPetTile.setIcon(petIcon);
            }
        });

        setMoleTimer.start();
        setPetTimer.start();
        playIntro();
    }

    private void playIntro() {
        JFrame introFrame = new JFrame("Introduction");
        introFrame.setSize(700, 850);
        introFrame.setUndecorated(true);
        introFrame.setLocationRelativeTo(null);
        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel introLabel = new JLabel(new ImageIcon(getClass().getResource("intro.gif")));
        panel.add(introLabel);
        introFrame.add(panel);
        introFrame.setVisible(true);

        Timer introTimer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                introFrame.dispose();
                showOptions();
            }
        });
        introTimer.setRepeats(false);
        introTimer.start();
    }
    
    class ImageButton extends JButton {
    private Image backgroundImage;

    public ImageButton(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        
        if (getIcon() != null) {
            int x = (getWidth() - getIcon().getIconWidth()) / 2;
            int y = (getHeight() - getIcon().getIconHeight()) / 2;
            getIcon().paintIcon(this, g, x, y);
        }
    }
}

    private void showOptions() {
        JFrame optionsFrame = new JFrame("Options");
        optionsFrame.setSize(588, 650);
        optionsFrame.setLocationRelativeTo(null);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(getClass().getResource("start.gif"));
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        optionsFrame.add(panel);
        panel.setLayout(null);

        ImageIcon startIcon = new ImageIcon(getClass().getResource("startgame.png"));
        ImageIcon exitIcon = new ImageIcon(getClass().getResource("exitgame.png"));

        JButton startButton = new JButton(startIcon);
        JButton exitButton = new JButton(exitIcon);

        panel.add(startButton);
        panel.add(exitButton);
        startButton.setBounds(80, 500, startIcon.getIconWidth(), startIcon.getIconHeight());
        exitButton.setBounds(350, 500, exitIcon.getIconWidth(), exitIcon.getIconHeight());

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionsFrame.dispose();
                frame.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        optionsFrame.setVisible(true);
    }

   private void displayEndOptions() {
    JFrame endFrame = new JFrame("Game Over");
    endFrame.setSize(588, 650);
    endFrame.setLocationRelativeTo(null);
    endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon background = new ImageIcon(getClass().getResource("over.gif"));
            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    panel.setLayout(null);
    
    JLabel scoreLabel = new JLabel("Your Score: " + score);
    scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
    scoreLabel.setForeground(Color.WHITE);
    scoreLabel.setBounds(180, 250, 300, 50);
    panel.add(scoreLabel);

    JLabel highestScoreLabel = new JLabel("Highest Score: " + highestScore);
    highestScoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
    highestScoreLabel.setForeground(Color.WHITE);
    highestScoreLabel.setBounds(130, 300, 400, 50);
    panel.add(highestScoreLabel);

    ImageIcon playAgainIcon = new ImageIcon(getClass().getResource("playagain.png"));
    ImageIcon exitGameIcon = new ImageIcon(getClass().getResource("exit.png"));

    JButton playAgainButton = new JButton(playAgainIcon);
    JButton exitButton = new JButton(exitGameIcon);

    playAgainButton.setBorderPainted(false);
    playAgainButton.setContentAreaFilled(false);
    playAgainButton.setFocusPainted(false);
    exitButton.setBorderPainted(false);
    exitButton.setContentAreaFilled(false);
    exitButton.setFocusPainted(false);

    playAgainButton.setBounds(100, 450, playAgainIcon.getIconWidth(), playAgainIcon.getIconHeight());
    exitButton.setBounds(300, 450, exitGameIcon.getIconWidth(), exitGameIcon.getIconHeight());

    playAgainButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            endFrame.dispose();
            resetGame();
            frame.setVisible(true);
        }
    });

    exitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    endFrame.add(panel);
    panel.add(playAgainButton);
    panel.add(exitButton);
    endFrame.setVisible(true);
}

    private void resetGame() {
        score = 0;
        textLabel.setText("Score: " + Integer.toString(score));

        setMoleTimer.start();
        setPetTimer.start();

        for (JButton tile : board) {
            tile.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WhacAMole game = new WhacAMole();
        });
    }
}

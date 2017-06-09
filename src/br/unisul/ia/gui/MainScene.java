package br.unisul.ia.gui;

import br.unisul.ia.core.SceneHandler;
import br.unisul.ia.entity.Maze;
import br.unisul.ia.entity.MazeTile;
import br.unisul.ia.entity.Robit;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class MainScene extends javax.swing.JFrame {

	private static MainScene window;

	private MainScene() {
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputExceedHealthGroup = new javax.swing.ButtonGroup();
        OptionsPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mazeSizeLabel = new javax.swing.JLabel();
        mazeSize = new javax.swing.JSpinner();
        separator1 = new javax.swing.JSeparator();
        maxHealthLabel = new javax.swing.JLabel();
        maxHealth = new javax.swing.JTextField();
        exceedHealthLabel = new javax.swing.JLabel();
        exceedHealthYes = new javax.swing.JRadioButton();
        exceedHealthNo = new javax.swing.JRadioButton();
        startBtn = new javax.swing.JButton();
        MazePanelPadding = new javax.swing.JPanel();
        MazePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maze");
        setPreferredSize(new java.awt.Dimension(400, 290));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        OptionsPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Maze");

        mazeSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mazeSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mazeSizeLabel.setText("Maze Size:");
        mazeSizeLabel.setMaximumSize(new java.awt.Dimension(20, 14));
        mazeSizeLabel.setMinimumSize(new java.awt.Dimension(20, 14));
        mazeSizeLabel.setPreferredSize(new java.awt.Dimension(20, 14));

        mazeSize.setModel(new javax.swing.SpinnerNumberModel(10, 3, null, 1));

        maxHealthLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maxHealthLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxHealthLabel.setText("Robit's Max Health:");
        maxHealthLabel.setMaximumSize(new java.awt.Dimension(20, 14));
        maxHealthLabel.setMinimumSize(new java.awt.Dimension(20, 14));
        maxHealthLabel.setPreferredSize(new java.awt.Dimension(20, 14));

        maxHealth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maxHealth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maxHealth.setText("50");

        exceedHealthLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exceedHealthLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        exceedHealthLabel.setText("Can Exceed Max Health?");
        exceedHealthLabel.setMaximumSize(new java.awt.Dimension(20, 14));
        exceedHealthLabel.setMinimumSize(new java.awt.Dimension(20, 14));
        exceedHealthLabel.setPreferredSize(new java.awt.Dimension(20, 14));

        inputExceedHealthGroup.add(exceedHealthYes);
        exceedHealthYes.setText("Yes");
        exceedHealthYes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        inputExceedHealthGroup.add(exceedHealthNo);
        exceedHealthNo.setSelected(true);
        exceedHealthNo.setText("No");
        exceedHealthNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OptionsPanelLayout = new javax.swing.GroupLayout(OptionsPanel);
        OptionsPanel.setLayout(OptionsPanelLayout);
        OptionsPanelLayout.setHorizontalGroup(
            OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(OptionsPanelLayout.createSequentialGroup()
                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OptionsPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OptionsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OptionsPanelLayout.createSequentialGroup()
                                .addComponent(mazeSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(mazeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsPanelLayout.createSequentialGroup()
                                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exceedHealthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maxHealthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OptionsPanelLayout.createSequentialGroup()
                                        .addComponent(exceedHealthYes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(exceedHealthNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(maxHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OptionsPanelLayout.setVerticalGroup(
            OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mazeSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(mazeSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxHealthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exceedHealthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exceedHealthYes)
                    .addComponent(exceedHealthNo))
                .addGap(18, 18, 18)
                .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(OptionsPanel, "card1");

        MazePanelPadding.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MazePanelPadding.setPreferredSize(new java.awt.Dimension(0, 0));

        MazePanel.setPreferredSize(new java.awt.Dimension(0, 0));
        MazePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout MazePanelPaddingLayout = new javax.swing.GroupLayout(MazePanelPadding);
        MazePanelPadding.setLayout(MazePanelPaddingLayout);
        MazePanelPaddingLayout.setHorizontalGroup(
            MazePanelPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MazePanelPaddingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MazePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MazePanelPaddingLayout.setVerticalGroup(
            MazePanelPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MazePanelPaddingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MazePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(MazePanelPadding, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        int size = (Integer)mazeSize.getValue();
		int health = Integer.parseInt(maxHealth.getText());
		boolean exceed = false;
		if (exceedHealthYes.isSelected()) {exceed = true;}
		
		SceneHandler.getInstance().setUserInput(size, health, exceed);
		
		//try { Thread.sleep(1_000); } catch (InterruptedException ex) { System.out.println("Thread couldn't sleep!"); }
		
		SceneHandler handler = SceneHandler.getInstance();
		handler.start();
		//throw new RuntimeException("[FATAL-ERROR] Failed to start <SceneHandler>!");
		
		OptionsPanel.setVisible(false);
		MazePanelPadding.setVisible(true);
    }//GEN-LAST:event_startBtnActionPerformed

	public static MainScene run() {
		//<editor-fold defaultstate="collapsed" desc=" Look and Feel ">
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		java.awt.EventQueue.invokeLater(() -> {
			window = new MainScene();
			
			// Fix Spinner Default Alignment and Font
			JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)window.mazeSize.getEditor();
			spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
			spinnerEditor.getTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			// Init Layers
			window.MazePanelPadding.setVisible(false);
		});
		
		try { Thread.sleep(1_000); } catch (InterruptedException e) {}
		window.setVisible(true);
		
		return window;
	}
	
	public void generateMaze(int mazeSize, int maxHealth, boolean canExceed) throws InstantiationException {
		this.setVisible(false);
		
		Robit robit = new Robit(maxHealth, canExceed);
		Maze maze = new Maze(robit, mazeSize);
		
		int baseSize = 20;
		
		int maxWidth = baseSize, maxHeight = baseSize;
		int rows = 0;
		for (MazeTile tileRow[] : maze.getMaze()) {
			for (MazeTile tile : tileRow){
				JToggleButton currBtn = new JToggleButton();
				AbsoluteConstraints pos;
				pos = new AbsoluteConstraints(tile.getX() * baseSize, tile.getY() * baseSize, -1, -1);
				
				currBtn.setMinimumSize(new Dimension(baseSize, baseSize));
				currBtn.setMaximumSize(new Dimension(baseSize, baseSize));
				currBtn.setPreferredSize(new Dimension(baseSize, baseSize));
				currBtn.setSize(new Dimension(baseSize, baseSize));
				
				MazePanel.add(currBtn, pos);
			}
			rows++;
		}
		maxWidth = maxWidth * rows;
		maxHeight = maxHeight * rows;
		
		Dimension size = new Dimension(maxWidth + 30, maxHeight + 60);
		
		System.out.println("W:" + maxWidth + "|H:" + maxHeight);
		MazePanelPadding.setPreferredSize(size);
		this.setPreferredSize(size);
		
		// ReSize and ReCenter
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
//<editor-fold defaultstate="collapsed" desc=" Variables ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MazePanel;
    private javax.swing.JPanel MazePanelPadding;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JLabel exceedHealthLabel;
    private javax.swing.JRadioButton exceedHealthNo;
    private javax.swing.JRadioButton exceedHealthYes;
    private javax.swing.ButtonGroup inputExceedHealthGroup;
    private javax.swing.JTextField maxHealth;
    private javax.swing.JLabel maxHealthLabel;
    private javax.swing.JSpinner mazeSize;
    private javax.swing.JLabel mazeSizeLabel;
    private javax.swing.JSeparator separator1;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
	//</editor-fold>
}

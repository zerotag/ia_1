package br.unisul.ia.gui;

public class MainScene extends javax.swing.JFrame {

	private static MainScene window;

	private MainScene() {
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputExceedHealthGroup = new javax.swing.ButtonGroup();
        MazePanel = new javax.swing.JPanel();
        OptionsPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mazeSizeLabel = new javax.swing.JLabel();
        mazeSize = new javax.swing.JTextField();
        separator1 = new javax.swing.JSeparator();
        maxHealthLabel = new javax.swing.JLabel();
        maxHealth = new javax.swing.JTextField();
        exceedHealthLabel = new javax.swing.JLabel();
        exceedHealthYes = new javax.swing.JRadioButton();
        exceedHealthNo = new javax.swing.JRadioButton();
        startBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maze");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Maze");

        mazeSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mazeSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mazeSizeLabel.setText("Maze Size:");
        mazeSizeLabel.setMaximumSize(new java.awt.Dimension(20, 14));
        mazeSizeLabel.setMinimumSize(new java.awt.Dimension(20, 14));
        mazeSizeLabel.setPreferredSize(new java.awt.Dimension(20, 14));

        mazeSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mazeSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mazeSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mazeSizeKeyTyped(evt);
            }
        });

        maxHealthLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maxHealthLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxHealthLabel.setText("Robit's Max Health:");
        maxHealthLabel.setMaximumSize(new java.awt.Dimension(20, 14));
        maxHealthLabel.setMinimumSize(new java.awt.Dimension(20, 14));
        maxHealthLabel.setPreferredSize(new java.awt.Dimension(20, 14));

        maxHealth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maxHealth.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
        exceedHealthNo.setText("No");
        exceedHealthNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        startBtn.setText("Start");

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
                                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maxHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(OptionsPanelLayout.createSequentialGroup()
                                        .addComponent(exceedHealthYes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(exceedHealthNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
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
                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mazeSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mazeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout MazePanelLayout = new javax.swing.GroupLayout(MazePanel);
        MazePanel.setLayout(MazePanelLayout);
        MazePanelLayout.setHorizontalGroup(
            MazePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MazePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(OptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MazePanelLayout.setVerticalGroup(
            MazePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MazePanelLayout.createSequentialGroup()
                .addComponent(OptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(MazePanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mazeSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mazeSizeKeyTyped
        evt.consume();
		char[] nums = com.zerotag.universal.ciencia.Matematica.NUM.toCharArray();
		for (char num : nums) {
			if (evt.getKeyChar() == num) {
				mazeSize.setText(mazeSize.getText() + num);
			}
		}
    }//GEN-LAST:event_mazeSizeKeyTyped

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
			window.setVisible(true);
		});
		
		return window;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MazePanel;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JLabel exceedHealthLabel;
    private javax.swing.JRadioButton exceedHealthNo;
    private javax.swing.JRadioButton exceedHealthYes;
    private javax.swing.ButtonGroup inputExceedHealthGroup;
    private javax.swing.JTextField maxHealth;
    private javax.swing.JLabel maxHealthLabel;
    private javax.swing.JTextField mazeSize;
    private javax.swing.JLabel mazeSizeLabel;
    private javax.swing.JSeparator separator1;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

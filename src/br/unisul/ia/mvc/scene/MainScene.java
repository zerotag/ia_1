package br.unisul.ia.mvc.scene;

// APP COMPONENTS
import br.unisul.ia.mvc.AppManager;
import br.unisul.ia.mvc.controller.Controller;
import br.unisul.ia.mvc.controller.MainSceneController;
// AWT COMPONENTS
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
// SWING COMPONENTS
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class MainScene extends Scene {
	
	private static final String TITLE = "Maze";
	
	// UI OBJECTS
	private JPanel			container;
    private JButton				container_buttonStart;
    private JLabel				container_exceedLabel;
    private JRadioButton		container_exceedNo;
    private JRadioButton		container_exceedYes;
    private JLabel				container_healthLabel;
    private JTextField			container_healthValue;
    private JSeparator			container_separator1;
    private JLabel				container_sizeLabel;
    private JSpinner			container_sizeValue;
    private JLabel				container_title;
    
	private ButtonGroup		other_exceedGroup;
	// UI OBJECTS
	
	private MainSceneController controller;

	public MainScene() {
		initComponents();
	}
	
	@Override
	public void setController(Controller controller){
		if (controller.getClass().equals(MainSceneController.class))
			this.controller = (MainSceneController)controller;
		else
			throw new RuntimeException("[FATAL-ERROR] MainScene doesn't allow a controller of different type of <MainSceneController>.");
	}
	
    private void initComponents() {
        container					= new JPanel();
			container_title			= new JLabel();
			container_separator1	= new JSeparator();
			container_sizeLabel		= new JLabel();
			container_sizeValue		= new JSpinner();
			container_healthLabel	= new JLabel();
			container_healthValue	= new JTextField();
			container_exceedLabel	= new JLabel();
			container_exceedYes		= new JRadioButton();
			container_exceedNo		= new JRadioButton();
			container_buttonStart	= new JButton();

		other_exceedGroup			= new ButtonGroup();
		
        setTitle(TITLE);
        setResizable(false);

        container.setPreferredSize(new Dimension(0, 0));

        container_title.setFont(new Font("Tahoma", 0, 24));
        container_title.setHorizontalAlignment(SwingConstants.CENTER);
        container_title.setText("Maze Options");

        container_sizeLabel.setFont(new Font("Tahoma", 0, 14));
        container_sizeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        container_sizeLabel.setText("Maze Size:");
        container_sizeLabel.setMaximumSize(new Dimension(20, 14));
        container_sizeLabel.setMinimumSize(new Dimension(20, 14));
        container_sizeLabel.setPreferredSize(new Dimension(20, 14));

        container_sizeValue.setModel(new SpinnerNumberModel(10, 3, null, 1));

        container_healthLabel.setFont(new Font("Tahoma", 0, 14));
        container_healthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        container_healthLabel.setText("Robit's Max Health:");
        container_healthLabel.setMaximumSize(new Dimension(20, 14));
        container_healthLabel.setMinimumSize(new Dimension(20, 14));
        container_healthLabel.setPreferredSize(new Dimension(20, 14));

        container_healthValue.setFont(new Font("Tahoma", 0, 14));
        container_healthValue.setHorizontalAlignment(JTextField.CENTER);
        container_healthValue.setText("50");

        container_exceedLabel.setFont(new Font("Tahoma", 0, 14));
        container_exceedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        container_exceedLabel.setText("Can Exceed Max Health?");
        container_exceedLabel.setMaximumSize(new Dimension(20, 14));
        container_exceedLabel.setMinimumSize(new Dimension(20, 14));
        container_exceedLabel.setPreferredSize(new Dimension(20, 14));

        other_exceedGroup.add(container_exceedYes);
        container_exceedYes.setText("Yes");
        container_exceedYes.setHorizontalAlignment(SwingConstants.CENTER);

        other_exceedGroup.add(container_exceedNo);
        container_exceedNo.setSelected(true);
        container_exceedNo.setText("No");
        container_exceedNo.setHorizontalAlignment(SwingConstants.CENTER);

        container_buttonStart.setText("Start");
        container_buttonStart.addActionListener((e) -> this.container_buttonStartActionPerformed(e));

        GroupLayout containerLayout = new GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(container_separator1, Alignment.TRAILING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(container_title, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(containerLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(container_sizeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(container_sizeValue, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                            .addGroup(Alignment.TRAILING, containerLayout.createSequentialGroup()
                                .addGroup(containerLayout.createParallelGroup(Alignment.LEADING)
                                    .addComponent(container_exceedLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(container_healthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(containerLayout.createParallelGroup(Alignment.LEADING)
                                    .addGroup(containerLayout.createSequentialGroup()
                                        .addComponent(container_exceedYes, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(container_exceedNo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(container_healthValue, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(container_buttonStart, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container_title, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(container_separator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(container_sizeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(container_sizeValue, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(container_healthLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(container_healthValue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(container_exceedLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(container_exceedYes)
                    .addComponent(container_exceedNo))
                .addGap(18, 18, 18)
                .addComponent(container_buttonStart, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(container, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(container, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
        );
		
		JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)container_sizeValue.getEditor();
			spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
			spinnerEditor.getTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));

        pack();
        setLocationRelativeTo(null);
    }

    private void container_buttonStartActionPerformed(ActionEvent e) {
        int size		= (Integer)container_sizeValue.getValue();
		int health		= Integer.parseInt(container_healthValue.getText());
		boolean exceed	= container_exceedYes.isSelected();
		
		AppManager.getInstance().next();
		controller.commune(size, health, exceed);
    }
}

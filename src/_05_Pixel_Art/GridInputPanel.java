package _05_Pixel_Art;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GridInputPanel extends JPanel implements ActionListener, Serializable{
    private static final long serialVersionUID = 1L;
    private JTextField windowWidthField;
    private JTextField windowHeightField;
    private JTextField rowsField;
    private JTextField colsField;
    private JButton submitButton;
    private JButton save;
    private JButton load;
    int w = -1;
    int h = -1;
    int r = -1;
    int c = -1;
    PixelArtMaker pam;
    private static final String DATA_FILE = "src/_05_Pixel_Art/saved.dat";
    public GridInputPanel(PixelArtMaker pam) {
        this.pam = pam;
        

        windowWidthField = new JTextField(5);
        windowHeightField = new JTextField(5);
        rowsField = new JTextField(5);
        colsField = new JTextField(5);
        submitButton = new JButton("Submit");
        save = new JButton("save");
        load = new JButton("load");
        
        add(new JLabel("screen width:"));
        add(windowWidthField);
        add(new JLabel("\tscreen height:"));
        add(windowHeightField);
        add(new JLabel("\ttotal rows:"));
        add(rowsField);
        add(new JLabel("\ttotal columns:"));
        add(colsField);
        add(submitButton);
        add(save);
        add(load);

        submitButton.addActionListener((e)->submit());
        save.addActionListener(this);
        load.addActionListener(this);
    }

    private void submit() {
        boolean valid = false;
       
        try {
            w = Integer.parseInt(windowWidthField.getText());
            h = Integer.parseInt(windowHeightField.getText());
            r = Integer.parseInt(rowsField.getText());
            c = Integer.parseInt(colsField.getText());

            if(w <= 0 || h <= 0 || r <= 0 || c <= 0) {
                invalidateInput();
            }else {
                valid = true;
            }
        }catch(NumberFormatException e) {
            invalidateInput();
        }

        if(valid) {
            pam.submitGridData(w, h, r, c);
        }
    }

    private void invalidateInput() {
        JOptionPane.showMessageDialog(null, "Be sure all fields are complete with positive numbers.", "ERROR", 0);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	
		//save(new GridPanel());
		
		//save(new SaveState())
		if(e.getSource() == save) {
		int[] vars = pam.getPanel().getVars();
		System.out.println("save button pressed");
		

		save(new SaveState(vars[0], vars[1], vars[2], vars[3], pam.getPanel().getPixels()));
		}
		
		
		if(e.getSource() == load) {
			
			if(pam.getPanel() == null) {
				SaveState save = load();
				 w = save.getWindowWidth();
		         h = save.getWindowHeight();
		         r = save.getRows();
		         c = save.getCols();
		         
		         pam.submitGridData(w, h, r, c);
				
				
				pam.getPanel().setPixels(save.getPixels());
				pam.repaint();
			}else {
			
			System.out.println("load button pressed");
			SaveState save = load();
			System.out.println("In theory, the savestate save object now is equal to all the data that was saved");
			
			//pam.setPanel(new GridPanel(save.getWindowHeight(), save.getWindowWidth(), save.getRows(), save.getCols()));
			pam.getPanel().setPixels(save.getPixels());
			pam.repaint();
			}
			
		}
		
		
	}
	private static void save(SaveState data) {
		System.out.println("Save method called");
		
		
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static SaveState load() {
		System.out.println("load method called");
		
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); ObjectInputStream ois = new ObjectInputStream(fis)) {
			System.out.println("returned savestate in theory");
			
			return (SaveState) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println("IOexception noah");
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			//System.out.println("Class not found");
			e.printStackTrace();
			return null;
		}
		
		
		
	} public void streamline() {
		
		
	}


}

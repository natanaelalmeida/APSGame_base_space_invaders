package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPauseUI extends JFrame{
    
    protected JButton btnJogar;
    protected JButton btnSair;
    
    private JPanel contentPane;
    private Image img;	
            
    public MenuPauseUI(){
        img = new ImageIcon("resources/menu.jpg").getImage();
		
        setTitle("Pause");        
        setBounds(100, 100, img.getWidth(null), img.getHeight(null));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        contentPane.setPreferredSize(size);
        contentPane.setMinimumSize(size);
        contentPane.setMaximumSize(size);
        contentPane.setSize(size);

        btnJogar = new JButton("");
        btnJogar.setIcon(new ImageIcon("resources/jogar.jpg"));
        btnJogar.setBounds(250, 90, 299, 75);        
        btnJogar.addActionListener(btnJogarOnClick);
        contentPane.add(btnJogar); 

        btnSair = new JButton("");
        btnSair.setIcon(new ImageIcon("resources/Sair.jpg"));
        btnSair.setBounds(250, 90 * 2, 299, 75);   
        btnSair.addActionListener(btnSairOnClick);
        contentPane.add(btnSair);

        addKeyListener(KeyInput());
        
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true); 
        
        requestFocus();
    }
    
    @Override
    public void paint(Graphics g) {	
        super.paint(g);
        g.drawImage(img,0, 25, this);
    }	
    
    private AbstractAction btnJogarOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnJogar_OnClick(e);
        }
    };
    
      private AbstractAction btnSairOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnSair_OnClick(e);
        }
    };
      
    protected void btnJogar_OnClick(ActionEvent e){
        
    }
    
    protected void btnSair_OnClick(ActionEvent e){

    }
    
    private KeyAdapter KeyInput(){
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyReleased(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                KeyTyped(e);
            }                                
        };
    }
    
    public void KeyPressed(KeyEvent e){
        
    }
    
    public void KeyReleased(KeyEvent e) {
        
    }
    
    public void KeyTyped(KeyEvent e) {
        
    }
}

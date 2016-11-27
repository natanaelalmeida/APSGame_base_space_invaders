package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuDificuldadeUI extends JFrame {

    private JPanel contentPane;
    protected JButton btnFacil;
    protected JButton btnMedio;
    protected JButton btnDificil;

    public MenuDificuldadeUI() {
        setTitle("Dificuldade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 299, 244);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnFacil = new JButton("Fácil");
        btnFacil.setBounds(10, 41, 263, 41);
        btnFacil.addActionListener(btnFacilOnClick);
        contentPane.add(btnFacil);

        btnMedio = new JButton("Médio");
        btnMedio.setBounds(10, 93, 263, 41);
        btnMedio.addActionListener(btnMedioOnClick);
        contentPane.add(btnMedio);

        btnDificil = new JButton("Díficil");
        btnDificil.setBounds(10, 145, 263, 41);
        btnDificil.addActionListener(btnDificilOnClick);
        contentPane.add(btnDificil);

        JLabel lblEscolhaAbaixoCom = new JLabel("Escolha o nível que deseja jogar...");
        lblEscolhaAbaixoCom.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lblEscolhaAbaixoCom.setBounds(10, 11, 284, 30);
        contentPane.add(lblEscolhaAbaixoCom);
        
        setLocationRelativeTo(this);
        setResizable(false);
    }

    private AbstractAction btnFacilOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnFacil_OnClick(e);
        }
    };

    private AbstractAction btnMedioOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnMedio_OnClick(e);
        }
    };

    private AbstractAction btnDificilOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnDificil_OnClick(e);
        }
    };

    protected void btnFacil_OnClick(ActionEvent e) {

    }

    protected void btnMedio_OnClick(ActionEvent e) {

    }

    protected void btnDificil_OnClick(ActionEvent e) {

    }
}

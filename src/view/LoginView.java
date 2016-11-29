package view;

import Enums.Jogar;
import UI.LoginUI;
import controller.LoginController;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Jogador;

public class LoginView extends LoginUI{

    private Jogar jogar;
    private Jogador jogador;
    private List<Jogador> hashJogador = new ArrayList<>();
    private LoginController loginController = new LoginController();
    
    public LoginView(Jogar jogar){
        this.jogar = jogar;                            
    }
    
    @Override
    protected void btnEntrar_OnClick(ActionEvent e) {
       login();
    }
     
    private void login(){
         if(txtSenha.getText().equals("") || txtUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(this, 
                "Por favor, preencha todos os campos",
                "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
        else if((jogador = loginController.Entrar(new Jogador(txtUsuario.getText(), txtSenha.getText()))) != null){
            switch(jogar){
                case Um :
                    new MenuDificuldadeView(jogador).setVisible(true);
                    hide();
                    break;
                case Dois:
                    if(hashJogador.size() >= 1){                        
                        hashJogador.add(jogador);
                        new MenuDificuldadeView(hashJogador).setVisible(true);
                        hide();
                    }
                    else {
                        hashJogador.add( jogador);
                        txtSenha.setText("");
                        txtUsuario.setText("");
                        txtUsuario.requestFocus();
                        
                        JOptionPane.showMessageDialog(this, 
                            "Primeiro jogador inserido. Entre com o segundo jogador.",
                            "Alerta!", JOptionPane.WARNING_MESSAGE);
                    }
            }            
        }
        else {
            JOptionPane.showMessageDialog(this, 
                "Usuário ou senha inválidos!",
                "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
    }
}

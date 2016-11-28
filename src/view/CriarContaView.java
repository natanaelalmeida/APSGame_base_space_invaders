package view;

import UI.CriarContaUI;
import controller.JogadorController;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Jogador;

public class CriarContaView extends CriarContaUI{

   private JogadorController jogadorController = new JogadorController();
    
    @Override
    protected void btnSalvar_OnClick(ActionEvent e) {
        
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        String email = txtEmail.getText();
        
        Jogador jogador = new Jogador(usuario, senha, email);
        if(jogador.Criar()){
            if(jogadorController.Salvar(jogador)){
                JOptionPane.showMessageDialog(this, 
                "Usuário cadastrado com sucesso!", "Informação", 
                JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                 JOptionPane.showMessageDialog(this, 
                jogadorController.getMsgErro(), "Não foi possível inserir o usuário!", 
                JOptionPane.ERROR_MESSAGE);
            }
        }               
        else {
            if(email.equals("")){
                txtEmail.requestFocus();                
            }
            else if(usuario.equals("")){
                txtUsuario.requestFocus();
            }
            else if(senha.equals("")){
                txtSenha.requestFocus();
            }
            
            JOptionPane.showMessageDialog(this, 
                "Por favor, preenche todos os campos.", "Alerta!", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void btnLimpar_OnClick(ActionEvent e) {
        txtEmail.setText("");
        txtSenha.setText("");
        txtUsuario.setText("");
    }

    @Override
    protected void btnCancelar_OnClick(ActionEvent e) {
        hide();
        new MenuPrincipalView().setVisible(true);
    }        
    
}

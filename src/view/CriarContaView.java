package view;

import UI.CriarContaUI;
import controller.JogadorController;
import java.awt.event.ActionEvent;
import model.Jogador;

public class CriarContaView extends CriarContaUI{

   private JogadorController jogadorController = new JogadorController();
    
    @Override
    protected void btnSalvar_OnClick(ActionEvent e) {
        
        String usuario = txtEmail.getText();
        String senha = txtSenha.getText();
        String email = txtUsuario.getText();
        
        Jogador jogador = new Jogador(usuario, senha, email);
        if(jogador.Criar()){
            jogadorController.Salvar(new Jogador());
        }               
        else {
            String msg = "";
            if(usuario.equals("")){
                msg += ", Usuário ";
                txtUsuario.requestFocus();
            }
        }
    }

    @Override
    protected void btnLimpar_OnClick(ActionEvent e) {
        super.btnLimpar_OnClick(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void btnCancelar_OnClick(ActionEvent e) {
        hide();
        new MenuPrincipalView().setVisible(true);
    }        
    
}

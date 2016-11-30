package view;

import UI.CriarContaUI;
import controller.JogadorController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Jogador;

public class CriarContaView extends CriarContaUI {

    private JogadorController jogadorController = new JogadorController();

    @Override
    protected void btnSalvar_OnClick(ActionEvent e) {

        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        String email = txtEmail.getText();

        Jogador jogador = new Jogador(usuario, senha, email);
        if (jogador.Criar()) {
            if (jogadorController.Salvar(jogador)) {
                JOptionPane.showMessageDialog(this,
                        "Usuário cadastrado com sucesso!", "Informação",
                        JOptionPane.INFORMATION_MESSAGE);

                LimparCampos();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Usuário já cadastro. Favor informar outro email e usuário.", "Não foi possível inserir o usuário!",
                        JOptionPane.ERROR_MESSAGE);
                txtEmail.requestFocus();
                LimparCampos();
            }
        } else {
            if (email.equals("")) {
                txtEmail.requestFocus();
                txtEmail.setBackground(Color.LIGHT_GRAY);
            } else if (usuario.equals("")) {
                txtUsuario.requestFocus();
                txtUsuario.setBackground(Color.LIGHT_GRAY);
            } else if (senha.equals("")) {
                txtSenha.requestFocus();
                txtSenha.setBackground(Color.LIGHT_GRAY);
            }

            JOptionPane.showMessageDialog(this,
                    "Por favor, preenche todos os campos.", "Alerta!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void btnLimpar_OnClick(ActionEvent e) {        
        LimparCampos();
        txtEmail.requestFocus();
    }

    @Override
    protected void btnCancelar_OnClick(ActionEvent e) {
        setVisible(false);
    }

    private void LimparCampos() {
        txtEmail.setText("");
        txtSenha.setText("");
        txtUsuario.setText("");
    }
}

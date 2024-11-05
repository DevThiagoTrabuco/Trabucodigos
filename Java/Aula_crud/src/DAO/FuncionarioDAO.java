package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    Connection conn;
    PreparedStatement  pstm;
    ResultSet rs;

    public void cadastrar(FuncionarioDTO funcionario){
        String sql = "INSERT INTO funcionarios (nome, email) VALUES (? , ?)";

        conn = new ConnectionDAO().connectDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getName());
            pstm.setString(2, funcionario.getEmail());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, funcionario.getName() + " cadastrado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<FuncionarioDTO> listar(){
        String sql = "SELECT * FROM funcionarios";
        ArrayList<FuncionarioDTO> funcionarios = new ArrayList<>();
        conn = new ConnectionDAO().connectDB();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO(
                    rs.getInt("id_func"), 
                    rs.getString("nome"), 
                    rs.getString("email")
                );

                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return funcionarios;
    }
}
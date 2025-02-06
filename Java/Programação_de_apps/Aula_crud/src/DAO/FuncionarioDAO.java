package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    Connection conn;
    PreparedStatement  pstm;
    ResultSet rs;

    public void create(FuncionarioDTO funcionario){
        String sql = "INSERT INTO funcionarios (nome, email) VALUES (? , ?)";

        conn = new ConnectionDAO().connectDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getName());
            pstm.setString(2, funcionario.getEmail());

            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<FuncionarioDTO> read(){
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

    public void update(FuncionarioDTO funcionario){
        StringBuilder sql = new StringBuilder ("UPDATE funcionarios SET ");
        List<Object> parametros = new ArrayList<>();

        if(funcionario.getName() != null && !funcionario.getName().isEmpty()){
            sql.append("nome = ?, ");
            parametros.add(funcionario.getName());
        }
        if(funcionario.getEmail() != null && !funcionario.getEmail().isEmpty()){
            sql.append("email = ?, ");
            parametros.add(funcionario.getEmail());
        }
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id_func = ?");
        parametros.add(funcionario.getId());

        conn = new ConnectionDAO().connectDB();

        try {
            pstm = conn.prepareStatement(sql.toString());
            for(int i = 0; i < parametros.size(); i++){
                pstm.setObject(i + 1, parametros.get(i));
            }

            pstm.executeUpdate();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(FuncionarioDTO funcionario){
        String sql = "DELETE FROM funcionarios WHERE id_func = ?";
        conn = new ConnectionDAO().connectDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, funcionario.getId());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Funcionario deletado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
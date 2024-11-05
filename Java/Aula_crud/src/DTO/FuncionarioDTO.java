package DTO;

public class FuncionarioDTO {
    private int id;
    private String name;
    private String email;

    public FuncionarioDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public FuncionarioDTO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

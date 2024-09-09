package app.loja.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "t_venda")

public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private double valorTotal;

    @OneToMany(mappedBy = "Funcionario")
    @JsonIgnoreProperties
    @NotBlank
    private Funcionario funcionario;

    @OneToMany(mappedBy = "Cliente")
    @JsonIgnoreProperties
    @NotBlank
    private Cliente cliente;

    @OneToMany(mappedBy = "Produto")
    @JsonIgnoreProperties
    @NotBlank
    private List<Produto> produto;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 631510300
 */
public class CPessoa {

    ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;

    public int geraID() {
        return this.idPessoa++;
    }//fim do geraID

    /**
     * método addPessoa adiciona Pessoa no ArrayList pessoas
     *
     * @param p
     */
    public void addPessoa(Pessoa p) {
        this.pessoas.add(p);

    }//fim do addPessoa

    public void removePessoa(Pessoa p) {
        this.pessoas.remove(p);

    }//Fim do removePessoa

    public ArrayList<Pessoa> getPessoa() {
        return this.pessoas;

    }//fim do ArrayList GetPessoa

    /**
     * método getPessoaCPF retorna uma pessoa caso encontre corresnpondência no
     * CPF no ArrayList pessoas, caso contrário retorna null;
     *
     * @param CPF
     * @return
     */
    public Pessoa getPessoaCPF(String CPF) {

        Pessoa p = null;
        for (Pessoa pes : pessoas) {
            if (pes.getCpf().equals(CPF)) {
                p = pes;
                break;
            }//fim do if
        }//fim do for
        return p;

    }//fim do getPessoaCPF

    public void mockPessoas() {
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(geraID());
        p1.setCpf("11970327030");
        p1.setNome("William Gates");
        p1.setEndereco("Beco da Tela Azul");
        p1.setTelefone("14258828080");
        addPessoa(p1);
        
        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(geraID());
        p2.setCpf("86518838035");
        p2.setNome("Linus Tovalds");
        p2.setEndereco("Rua do Kernel");
        p2.setTelefone("14085544000");
        addPessoa(p2);
    }

}//fim da classe

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static inf3n212.carro.INF3N212CARRO.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 631510300
 */
public class CCarro {

    ArrayList<Carro> carros = new ArrayList();

    public void addCarro(Carro c) {
        this.carros.add(c);
    }

    public void removeCarro(Carro c) {
        this.carros.remove(c);
    }

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }

    public Carro getCarroPlaca(String placa) {
        Carro c = null;

        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                c = carro;
                break;
            }

        }
        return c;
    }
public void mockCarros(){
    Carro c1 = new Carro();
    c1.setPlaca("ABC1F34");
    c1.setAnoFab(2023);
    c1.setAnoMod(2023);
    c1.setMarca("FIAT");
    c1.setModelo("Palio");
    c1.setTpCambio("Manual");
    c1.setCombustivel("Flex");
    c1.setCor("Bege");
    c1.setProprietario(cadPessoa.getPessoaCPF("11970327030"));
    addCarro(c1);
    
    Carro c2 = new Carro();
    c2.setPlaca("def2r45");
    c2.setAnoFab(2020);
    c2.setAnoMod(2021);
    c2.setMarca("GM");
    c2.setModelo("Onix");
    c2.setTpCambio("Automatico");
    c2.setCombustivel("Flex");
    c2.setCor("Prata");
    c2.setProprietario(cadPessoa.getPessoaCPF("86518838035"));
    addCarro(c2);
    
}
}//fim da classe


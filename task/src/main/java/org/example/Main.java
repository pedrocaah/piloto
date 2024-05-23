package org.example;


import dao.*;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;

public class Main {

    static ICarroDAO carroDAO = new CarroDAO();
    static IAcessorioDAO acessorioDAO = new AcessorioDAO();
    static IMarcaDAO marcaDAO = new MarcaDAO();

//    static  {
//        carroDAO = new CarroDAO();
//        acessorioDAO = new AcessorioDAO();
//        marcaDAO = new MarcaDAO();
//    }

    public static void main(String[] args) {

        Marca m = new Marca();
        m.setNome("Renault");
        m.setCodigo("1");
        marcaDAO.cadastrarMarca(m);

        Acessorio a = new Acessorio();
        a.setNome("Acessorios do sandero");
        a.setCodigo("1");
        a.setDescricao("Composicao de pecas");
        a.setMarca(m);
        acessorioDAO.cadastrarAcessorio(a);



        Carro c = new Carro();
        c.setCodigo("1");
        c.setNome("Sandero");
        c.setCategoria("Hatch");
        c.setMarca(m);
        c.addAcessorio(a);
        carroDAO.cadastrarCarro(c);
    }

}
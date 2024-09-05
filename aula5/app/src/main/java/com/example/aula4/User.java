package com.example.aula4;

public class User {


    // Declaração das variáveis de instancia publicas essas variaveis armazenarao os dados do usuario
    public String name; // armazen ao nome do usuário.
    public String email; // armazena o e-mail do usuário.

    //Construtor vazio de classe User.
    // Esse construtor é necessario para que o Firebase possa criar instancias de classe User
    //quando recuperar dados do banco.


    public User(){
        // Construtor vazio necessario para o Firebase

    }
    //Construtor da classe User que recebe dois parametros: nome e email
    //Esse construtor permite criar uma nova instancia da classe User já com valores definidos para nome e emais.


    public User(String name, String email){
        this.name = name; // atribui o valor do parametro name a variavel de instancia name.
        this.email = email; // Atribui o valor do parametro email á variavel de instancia email.
    }
}

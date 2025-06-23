// ExemploPOO.java
// demonstração de herança, associação, agregação, composição,
// encapsulamento e polimorfismo em um único arquivo

// 1) abstração + encapsulamento (classe base abstrata)
abstract class Veiculo {
    protected final String modelo;
    private int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        if (ano > 1885) {
            this.ano = ano;
        } else {
            System.out.println("ano inválido!");
            this.ano = 1886;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano > 1885) {
            this.ano = ano;
        } else {
            System.out.println("ano inválido!");
        }
    }

    public void ligar() {
        System.out.println(modelo + " está ligando...");
    }

    public abstract void acelerar();
}

// 2) herança + polimorfismo
class Carro extends Veiculo {
    public Carro(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println(modelo + " acelera com 4 rodas!");
    }
}

class Moto extends Veiculo {
    public Moto(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println(modelo + " acelera com 2 rodas!");
    }
}

// 3) associação
class Pessoa {
    private final String nome;
    private Veiculo veiculo;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void setVeiculo(Veiculo v) {
        this.veiculo = v;
    }

    public void dirigir() {
        if (veiculo != null) {
            System.out.println(nome + " vai dirigir o " + veiculo.modelo);
            veiculo.ligar();
            veiculo.acelerar();
        } else {
            System.out.println(nome + " não tem veículo.");
        }
    }
}

// 4) agregação
class TimeCorrida {
    private final String nome;
    private final Carro[] carros;

    public TimeCorrida(String nome, Carro[] carros) {
        this.nome   = nome;
        this.carros = carros;
    }

    public void mostrarEquipe() {
        System.out.println("time " + nome + " com carros:");
        for (Carro c : carros) {
            System.out.println(" - " + c.modelo);
        }
    }
}

// 5) composição
class Garagem {
    private final Carro[] carros;

    public Garagem(int capacidade) {
        carros = new Carro[capacidade];
        for (int i = 0; i < capacidade; i++) {
            carros[i] = new Carro("modelo-genérico-" + (i+1), 2023);
        }
    }

    public void listarCarros() {
        System.out.println("carros na garagem:");
        for (Carro c : carros) {
            System.out.println(" * " + c.modelo);
        }
    }
}

// 6) classe pública com o main
public class ExemploPOO {
    public static void main(String[] args) {
        Veiculo c1 = new Carro("ferrari", 2020);
        Veiculo m1 = new Moto("yamaha", 2019);

        c1.ligar();
        c1.acelerar();
        m1.ligar();
        m1.acelerar();

        System.out.println();

        Pessoa joao = new Pessoa("joão");
        joao.dirigir();
        joao.setVeiculo(c1);
        joao.dirigir();

        System.out.println();

        Carro[] equipe = {
            new Carro("porsche", 2021),
            new Carro("lamborghini", 2022)
        };
        TimeCorrida alfa = new TimeCorrida("alfa", equipe);
        alfa.mostrarEquipe();

        System.out.println();

        Garagem g = new Garagem(3);
        g.listarCarros();
    }
}

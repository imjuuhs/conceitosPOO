# conceitos-poo

um projeto simples em java demonstrando os principais conceitos de programação orientada a objetos:

- **abstração** & **encapsulamento** (classe `Veiculo`)  
- **herança** & **polimorfismo** (`Carro` e `Moto`)  
- **associação** (`Pessoa` usa um `Veiculo`)  
- **agregação** (`TimeCorrida` possui vários `Carro`s)  
- **composição** (`Garagem` cria e gerencia seus próprios `Carro`s)  

---

## estrutura do repositório
/
├── src/
│ └── ExemploPOO.java ← todo o código-fonte
└── README.md ← este arquivo


---

## requisitos

- java jdk 8+ instalado  
- vscode ou qualquer editor de texto / ide

---

## como compilar e executar

no terminal, posicionado na raiz do projeto:

```bash
# compila
javac src/ExemploPOO.java

# executa
java -cp src ExemploPOO


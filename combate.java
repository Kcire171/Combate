import java.util.Scanner;

class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    public Campeao(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.setAtaque(ataque);
        this.armadura = armadura;
    }

    public void receberDano(int ataqueInimigo) {
        int dano = Math.max(1, ataqueInimigo - this.armadura); 
        this.vida = Math.max(0, this.vida - dano); 
    }
    public String getStatus() {
        if (this.vida > 0) {
            return this.nome + ": " + this.vida + " de vida";
        } else {
            return this.nome + ": 0 de vida (morreu)";
        }
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
}

public class Combate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida1 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque1 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura1 = scanner.nextInt();

        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);


        System.out.println("\nDigite os dados do segundo campeão:");
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida2 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = scanner.nextInt();

        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        System.out.print("\nQuantos turnos você deseja executar? ");
        int turnos = scanner.nextInt();

        for (int turno = 1; turno <= turnos; turno++) {
            if (!campeao1.estaVivo() || !campeao2.estaVivo()) {
                break;
            }

            campeao1.receberDano(campeao2.getAtaque());
            campeao2.receberDano(campeao1.getAtaque());

            System.out.println("\nResultado do turno " + turno + ":");
            System.out.println(campeao1.getStatus());
            System.out.println(campeao2.getStatus());
        }

        System.out.println("\n### FIM DO COMBATE ###");
        scanner.close();
    }
}

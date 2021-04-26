package prova_psc;


import java.time.LocalDateTime;
import java.util.Scanner;



public class prova_psc {

	public static void main(String[] args) {
		//Entradas
		
		String nome, sobrenome, estado;
		String aniversario;
		int categoria;
		int aposentado;
		int continuar;
		int valor_beneficio, funcionarios, meses_desempregado;
        int anonasci, anoatual;
        String dia, mes;
        int beneficio;
        


      //Scanner teclado = new Scanner(System.in);
        
        
		do {

	    Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o Nome: ");
        nome = teclado.next();
        
        System.out.println("Informe o sobreome: ");
        sobrenome = teclado.next();
        
        System.out.println("Informe o Dia e o Mês do seu aniversario no seguinte formato: (DD/MM)");
        aniversario = teclado.next();
        
        System.out.println("Informe o ano de nascimento: ");
        anonasci = teclado.nextInt();
        
        System.out.println("Informe seu Estado (UF)");
        estado = teclado.next();
        
    	//Verifica se é maior de 18 anos

        LocalDateTime data1 = LocalDateTime.now();
        anoatual = data1.getYear();
        int idade = (anoatual - anonasci);
        
        if (idade > 18) {
     
        	System.out.println("Informe a categoria:\n1- Empregado\n2- Empregador\n3- Desempregado");
        	categoria = teclado.nextInt();
        	
        	//Switch Case para as exigências dos tres casos
        	switch(categoria)
        	{
        	case 1:
        		System.out.println("Você escolheu a categoria 1: Empregado");
        		System.out.println("O Empregado é Aposentado?\n1-Sim\n2-Não");
        		aposentado = teclado.nextInt();
        		System.out.println("Qual sera o valor do beneficio? Considerar entre R$1000 e R$1800 para Empregados!");
        		beneficio = teclado.nextInt();
        		if (aposentado == 1) {
        		int valor_aposentado = (beneficio * 6); // Aposentados tem Direito ao beneficio por 6 Meses (Regra de Negocio E)
        		System.out.println("Por ser Aposentando o Empregado tem o direto do beneficio por 6 Meses totalizando: R$" + valor_aposentado);
        		}else {
        			int valor_empregado = (beneficio * 3); //Empregados tem o direito ao beneficio por 3 Meses (Regra de negocio U)
        			System.out.println("O Empregado não Aposentado tem direito ao beneficio por 3 meses totalizando: R$" + valor_empregado);
        		}
 
  
        		
        		break;
        		
        	case 2:
        		System.out.println("Você escolheu a categoria 2: Empregador");
        		System.out.println("Quantos Funcionarios Possui?");
        		funcionarios = teclado.nextInt();
        		int beneficio_fun = (funcionarios * 200);
        		System.out.println("O Valor do Beneficio sera de R$200 por funcionario totalizando: R$" + beneficio_fun);
        		if (funcionarios <= 40) {
        			int beneficio_funnovo = (beneficio_fun * 11 / 100); //Empregadores com até 40 Funcionarios Recebem um Acrescimo de 11% sobre o Valor total (Regra de Negocio D)
        			beneficio_funnovo = (beneficio_fun + beneficio_funnovo);
        			System.out.println("Empregadores com até 40 funcionarios recebem um acrescimo de 11% Passando de: R$" + beneficio_fun + " Para R$" + beneficio_funnovo );
        				if (funcionarios <= 10) { //Para Empregadores com até 10 funcionario o beneficio é de 10 Meses (Regra de Negocio R)
        					System.out.println("Para Empregadores com até 10 Funcionario o beneficio é de 10 Meses Totalizando R$:" + beneficio_funnovo * 10);
        				} else { // O Benefício será de 7 meses para empregadores (Regra de negocio O)
        					System.out.println("Para Empregadores com mais de 10 Funcionarios o beneficio é de 7 meses Totalizando R$:" + beneficio_funnovo * 7);
        				}
        		}
        		
        		break;
        		
        	case 3:
        		System.out.println("Você escolheu a categoria 3: Desempregado");
        		System.out.println("Esta a quantos meses desempregado?");
        		meses_desempregado = teclado.nextInt();
        		System.out.println("Qual sera o valor do beneficio? Considerar entre R$1500 e R$2300 para desempregados!");
        		beneficio = teclado.nextInt();
        		int total_desempregado = (beneficio * 6); //Calcula o valor do Beneficio por 6 meses (Regra de Negocio L)
        		System.out.println("O Desempregado tera o Beneficio por 6 Meses com um total de: R$" + total_desempregado + " Ao Final desse periodo!");
        		break;
        		
        	}
        	
        	//Nao conceder o Beneficio para menores de 18 Anos (Regra de Negocio A)
        }else {
        	System.out.println("A Pessoa Informada não tem direito ao beneficio pois não tem 18 anos!");
        }
        
        
        //Saida
        System.out.println("=====================================");
        System.out.println("Nome: " + nome + " " + sobrenome);
        System.out.println("Idade: " + (anoatual - anonasci) + " Anos");
        System.out.println("Nascimento: " + aniversario + "/" + anonasci);
        
        
        //Perguntar se quer repetir o Loop
        	System.out.println("================================\nDeseja Informar um novo benefico?\n1-SIM\n2-NÃO");
        	continuar = teclado.nextInt();
        		} while (continuar == 1);
        		        
	        	


	System.out.println("Programa Finalizado!");
	}
		
}
//		Regra de negocio X (Nao consegui colocar ela no codigo)
//        if (estado == RS ) {
//        	int beneficio_rs = (beneficio * 10 / 100);
//        	beneficio_rs = (beneficio + beneficio_rs);
//        	System.out.println("Para que mora no RS o Benefico tera um acrescimo de 10% passando de:" + beneficio + "para" + beneficio_rs);
//        }
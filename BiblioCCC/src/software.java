import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class software {
	static Scanner sc = new Scanner(System.in);
	static String[] lognames = new String[1];
	
	
	
	public static void main(String[] args) {
		login();
		
	}
	
public static void login() {
		
		
		System.out.println("LOGIN");
		System.out.print("Utilizador: ");
		String user = sc.next();
		System.out.print("Password: ");
		String pass = sc.next();
		if((user.equals("admin")) && (pass.equals("admin"))) {
			menuAdmin();
		}
		if((user.equals("user")) && (pass.equals("user"))) {
			menuUser();
		}
		if((user.equals("func")) && (pass.equals("func"))) {
			menuFunc();
		}
		

	

}

public static void menuUser() {
	System.out.println("-------------------------------------------------\n" + 
			"| MENU PRINCIPAL                               \t|\n" + 
			"|-------------------------------------------------\n"  + 
			"| 1 - Listar Livros                	       	   \t|\n" + 
			"| 2 - Devolver Livro   	                       \t|\n" + 
			"| 3 - Requisitar Livro              	       \t|\n" + 
			"| 4 - Consultar Requisitados      	    \t|\n" + 
			"| 0 - SAIR                                     \t|\n"  +
			"-------------------------------------------------\n");
	
	int op = sc.nextInt();
	
	switch(op) {
	
	case 1: listBooks();
	break;
	case 2: returnBook();
	break;
	case 3: Reqbook();
	break;
	case 4: allReqs();
	break;
	case 0: sair();
	
	}
	
}

public static void Reqbook() {
	try {
		
		FileWriter fw = new FileWriter ("Requisitados.txt",true);
		PrintWriter pw = new PrintWriter(fw); 
		
		int code;
		String titl;
		String autor;
		String editora;
		System.out.println("Insira o código do livro: ");
		code = sc.nextInt();
		pw.println("Código: "+ code +";");
		System.out.println("Insira o titulo do livro: ");
		titl = sc.next();
		pw.print("Titulo:"+titl+";");
		
		System.out.println("Insira o autor do livro: ");
		autor = sc.next();
		pw.print("Autor: "+ autor + ";");
		
		System.out.println("Insira a editora do livro: ");
		editora = sc.next();
		pw.println("Editora: "+editora+";");
		
		pw.close();
		
		removeBook(code,titl,autor,editora);
		
		
		
	}catch (IOException e) {
		System.out.println("Erro");}
}
public static void menuFunc() {
	System.out.println("-------------------------------------------------\n" + 
			"| MENU PRINCIPAL                               \t|\n" + 
			"|-------------------------------------------------\n"  + 
			"| 1 - Listar Livros                	       	   \t|\n" + 
			"| 2 - Devolver Livro   	                       \t|\n" + 
			"| 3 - Consultar Contas                 	       \t|\n" + 
			"| 4 - Consultar Requisitados      	    \t|\n" + 
			"| 5 - Adicionar Livro          	               \t|\n" + 
			"| 6 - Remover   Livro            	    \t|\n"  +
			"| 7 - Criar Utilizador                	       \t|\n"  + 
			"| 8 - Remover Utilizador              	       \t|\n"  + 
			"| 0 - SAIR                                     \t|\n"  +
			"-------------------------------------------------\n");
	
	int op = sc.nextInt();
	
	switch(op) {
	
	case 1: listBooks();
	break;
	case 2: returnBook();
	break;
	case 3: contasUser();
	break;
	case 4: allReqs();
	break;
	case 5: addBook();
	break;
	case 6: delBook();
	break;
	case 7: criarUser();
	break;
	case 8: removerUser();
	break;
	case 0: sair();
	break;
	}
	
}

public static void menuAdmin() {
	System.out.println("-------------------------------------------------\n" + 
			"| MENU PRINCIPAL                               \t|\n" + 
			"|-------------------------------------------------\n"  + 
			"| 1 - Listar Livros                	       	   \t|\n" + 
			"| 2 - Devolver Livro   	                       \t|\n" + 
			"| 3 - Consultar Contas                 	       \t|\n" + 
			"| 4 - Consultar Requisitados      	    \t|\n" + 
			"| 5 - Adicionar Livro          	               \t|\n" + 
			"| 6 - Remover   Livro            	    \t|\n"  +
			"| 7 - Criar Utilizador                	       \t|\n"  + 
			"| 8 - Remover Utilizador              	       \t|\n"  + 
			"| 9 - Criar funcionário              	       \t|\n"  +
			"|10 - Remover Funcionário            	       \t|\n"  +
			"| 0 - SAIR                                     \t|\n"  +
			"-------------------------------------------------\n");
	
	int op = sc.nextInt();
	
	switch(op) {
	
	case 1: listBooks();
	break;
	case 2: returnBook();
	break;
	case 3: contasUser();
	break;
	case 4: allReqs();
	break;
	case 5: addBook();
	break;
	case 6: delBook();
	break;
	case 7: criarUser();
	break;
	case 8: removerUser();
	break;
	case 9: criarFunc();
	break;
	case 10: removeFunc();
	break;
	case 0: sair();
	}
	
}





	public static void lognameFunc(String name) {
		try {
			FileWriter fw = new FileWriter ("lognames.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
			pw.println(name);
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");
		}
	}

	public static void logpassFunc(String pass) {
		try {
			FileWriter fw = new FileWriter ("lognames.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
			pw.println(pass);
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");
		}
	}








	public static void removeFunc() {
		FileWriter fw;
		try {
			fw = new FileWriter ("funcionarios.txt",false);
			PrintWriter pw = new PrintWriter(fw); 
		
		
		
		int numero;
		String nome;
		String autor;
		String password;
		System.out.println("Insira o número do funcionário: ");
		numero = sc.nextInt();
		pw.println("Número: "+ numero +";");
		System.out.println("Insira o titulo do livro: ");
		nome = sc.next();
		pw.print("User: "+nome+";");
		
		System.out.println("Password: ");
		password = sc.next();
		pw.print("Password: "+ password +";" );
		
		
		
		pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	

	public static void criarFunc() {
try {
			FileWriter fw = new FileWriter ("funcionarios.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
		String name;
		String password;
		int numero;
		System.out.println("Número de funcionário: ");
		numero=sc.nextInt();
		System.out.println("Nome de utilizador: ");
		name = sc.next();
		pw.println("User: "+ name +";");
		System.out.println("Password: ");
		password = sc.next();
		pw.println("Password: "+ password +";");
		
		pw.close();
		
}catch (IOException e) {
	System.out.println("Erro");
}
	}
	
	public static void removeBook(int code, String titulo, String autor,String editora ) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		
try {
			
			FileWriter fw = new FileWriter ("Books.txt",false);
			PrintWriter pw = new PrintWriter(fw); 
			
	
			pw.println("Código: "+ code +";");
			System.out.println("Insira o titulo do livro: ");
		
			pw.print("Titulo:"+titulo+";");
			
			System.out.println("Insira o autor do livro: ");
			
			pw.print("Autor: "+ autor + ";");
			
			System.out.println("Insira a editora do livro: ");
		
			pw.println("Editora: "+editora+";");
			
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");
		}
	}


	public static void listBooks() {
		try (BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		
		System.out.println("Voltar ao menu?(S/N)");
		String respo;
		respo = sc.next();
			if((respo=="S")||(respo=="s")) {
				menuAdmin();
			}else {
				sair();
			}
	}

	



	public static void returnBook() {// para devolver o livro
		try {
			
			FileWriter fw = new FileWriter ("Requisitados.txt",false);
			PrintWriter pw = new PrintWriter(fw); 
			
			int code;
			String titl;
			String autor;
			String editora;
			System.out.println("Insira o código do livro: ");
			code = sc.nextInt();
			pw.println("Código: "+ code +";");
			System.out.println("Insira o titulo do livro: ");
			titl = sc.next();
			pw.print("Titulo:"+titl+";");
			
			System.out.println("Insira o autor do livro: ");
			autor = sc.next();
			pw.print("Autor: "+ autor + ";");
			
			System.out.println("Insira a editora do livro: ");
			editora = sc.next();
			pw.println("Editora: "+editora+";");
			
			pw.close();
			
			removeBook(code,titl,autor,editora);
			
			
			
		}catch (IOException e) {
			System.out.println("Erro");}
		addBook();
	}



	public static void contasUser() {
		try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
	}

	public static void contasFuncs() {
		try (BufferedReader br = new BufferedReader(new FileReader("funcionarios.txt"))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
	}

	public static void allReqs() {
		try (BufferedReader br = new BufferedReader(new FileReader("Requisitados.txt"))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
	}
	
	public static void delBook() {
try {
			
			FileWriter fw = new FileWriter ("Books.txt",false);
			PrintWriter pw = new PrintWriter(fw); 
			
			int code;
			String titl;
			String autor;
			String editora;
			System.out.println("Insira o código do livro: ");
			code = sc.nextInt();
			pw.println("Código: "+ code +";");
			System.out.println("Insira o titulo do livro: ");
			titl = sc.next();
			pw.print("Titulo:"+titl+";");
			
			System.out.println("Insira o autor do livro: ");
			autor = sc.next();
			pw.print("Autor: "+ autor + ";");
			
			System.out.println("Insira a editora do livro: ");
			editora = sc.next();
			pw.println("Editora: "+editora+";");
			
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");}
	}
	public static void addBook() {
		try {
			
			FileWriter fw = new FileWriter ("Books.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
			
			int code;
			String titl;
			String autor;
			String editora;
			System.out.println("Insira o código do livro: ");
			code = sc.nextInt();
			pw.println("Código: "+ code +";");
			System.out.println("Insira o titulo do livro: ");
			titl = sc.next();
			pw.print("Titulo:"+titl+";");
			
			System.out.println("Insira o autor do livro: ");
			autor = sc.next();
			pw.print("Autor: "+ autor + ";");
			
			System.out.println("Insira a editora do livro: ");
			editora = sc.next();
			pw.println("Editora: "+editora+";");
			
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");
		}

}

	public static void lognames(String name) {
		try {
			FileWriter fw = new FileWriter ("lognames.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
			pw.println(name);
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");
		}
	}
	
	public static void logpass(String pass) {
		try {
			FileWriter fw = new FileWriter ("logpass.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
			pw.println(pass);
			pw.close();
		}catch (IOException e) {
			System.out.println("Erro");
		}
	}
	
	
	public static void criarUser() {
		
try {
			
			FileWriter fw = new FileWriter ("users.txt",true);
			PrintWriter pw = new PrintWriter(fw); 
			
			
		String name;
		String password;
		
		System.out.println("Nome de utilizador: ");
		name = sc.next();
		pw.println("User: "+ name +";");
		
		System.out.println("Password: ");
		password = sc.next();
		pw.println("Password: "+ password +";");
		
		pw.close();
		lognames(name);
		logpass(password);
}catch (IOException e) {
	System.out.println("Erro");
}
		
		
		
	}

	
	public static void removerUser() {
try {
			
			FileWriter fw = new FileWriter ("users.txt",false);
			PrintWriter pw = new PrintWriter(fw); 
			
			
		String name;
		String password;
		
		System.out.println("Nome de utilizador: ");
		name = sc.next();
		pw.println("User: "+ name +";");
		
		System.out.println("Password: ");
		password = sc.next();
		pw.println("Password: "+ password +";");
		
		pw.close();
		lognames(name);
		logpass(password);
}catch (IOException e) {
	System.out.println("Erro");
}
	}

	public static void sair() {
		
		System.out.println("Deseja sair (S/N)?");
		String resposta = sc.next();
		if (resposta.equals("s")) {
			System.exit(0);
		}else {
			login();
		}
	}




}
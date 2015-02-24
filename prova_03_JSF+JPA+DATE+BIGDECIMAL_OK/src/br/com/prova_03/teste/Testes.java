package br.com.prova_03.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.prova_03.bean.PessoaBean;
import br.com.prova_03.model.Pessoa;

public class Testes {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		PessoaBean testeLista=new PessoaBean();
		
		List epa;
		epa=testeLista.getVariasPessoas();
		
		for(int i=0;i<epa.size();i++){  
			
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Pessoa a1=new Pessoa();
			a1=(Pessoa) epa.get(i);
			//sdf.format(epa.get(i)).getDataPagamento());  
			//String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(contato.getDataNascimento());
			//System.out.println("DATA:"+((br.com.prova_03.model.Pessoa) epa.get(i)).getDataPagamento());    
			
			//System.out.println("Nome: "+a1.getNome());
			
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//sdf.format(epa.get(i)).getDataPagamento());
			//Date hoje  = new Date();
			//SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			//System.out.println("SIMPLE FORMAT: " +sdf2.format(a1.getDataPagamento()));
			//System.out.println("DATA: "+a1.getDataPagamento());
			 
			//DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			//System.out.println("DATA FORMATADA: "+df);
			
			//String dataFormatada=df;
			
			
			//df.format(a1.getDataPagamento()); 
			//System.out.println("DATA FORMATADA: "+dataFormatada);
			
		
		
		//////////////////////////////////////////////////////////////////////
			//CONVERTER PARA STRING
			String dataString=a1.getDataPagamento().toString();
			
			
			Calendar c = Calendar.getInstance();
			Date data = c.getTime();
			DateFormat f = DateFormat.getDateInstance();
			Date data2 = f.parse(dataString);
			System.out.println(data2);
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data formatada: "+sdf.format(data));
			//Converte Objetos System.out.println(“Data convertida: ”+sdf.parse("02/08/1970"));
			

		
		
		
		
		}  
		
		//String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(contato.getDataNascimento());

	}
	

}

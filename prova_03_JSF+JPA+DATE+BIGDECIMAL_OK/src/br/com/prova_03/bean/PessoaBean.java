package br.com.prova_03.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.prova_03.model.Pessoa;
import br.com.prova_03.persistencia.JPAUtil;

@ManagedBean
public class PessoaBean {

	private Pessoa Pessoa = new Pessoa();
	private List<Pessoa> variasPessoas;

	EntityTransaction tx = null;
	
	public PessoaBean() {

	}

	public Pessoa getPessoa() {
		return Pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		Pessoa = pessoa;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> getVariasPessoas() {
		
		// O IF VERIFIFICA SE AUTOMOVEIS JA FOI POPULADO-CORRIGE PROBLEMA DO JSF
		if (this.variasPessoas == null) {
			
			// O IF VERIFIFICA SE AUTOMOVEIS JA FOI POPULADO-CORRIGE PROBLEMA DO JSF
					if (this.variasPessoas == null) {
						
						EntityManager em = JPAUtil.getConexao();
						
						Query q = em.createQuery("select a from Pessoa a",Pessoa.class);
						this.variasPessoas = q.getResultList();
						// System.out.println(""automoveis.);
						em.close();

					}// IF
					return variasPessoas;
			
			
		
		}
		return variasPessoas;
	}

	public void setVariasPessoas(List variasPessoas) {
		this.variasPessoas = variasPessoas;
	}

	public String salvar() {

		try {

			EntityManager em = JPAUtil.getConexao();
			tx = em.getTransaction();

			tx.begin();

			em.persist(Pessoa);
			tx.commit();

			em.close();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx.isActive()) {
				tx.rollback();
			}
			//throw e;
			throw new RuntimeException(e+"ERRO AO SALVAR");
		}

		return "listagem.xhtml";
	}

	public String lista() {

		return "listagem.xhtml";
	}

	public String prepararEdicao(Pessoa ppp) {

		this.Pessoa = ppp;

		return "editar.xhtml";
	}

	public String gravaEdicao() {

		try {

			EntityManager em = JPAUtil.getConexao();

			tx = em.getTransaction();
			tx.begin();

			em.merge(Pessoa);

			tx.commit();

		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			//throw e;
			throw new RuntimeException(e+"ERRO AO ATUALIZAR");
			// TODO: handle exception
		}
		return "listagem.xhtml";
	}

	public String excluir(Pessoa pessoaExcluida) {

		try {

			EntityManager em = JPAUtil.getConexao();

			tx = em.getTransaction();
			tx.begin();

			pessoaExcluida = em.merge(pessoaExcluida);
			em.remove(pessoaExcluida);

			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx.isActive()) {
				tx.rollback();
				
			}
			//throw e;
			throw new RuntimeException(e+"ERRO AO EXCLUIR");
		}
		return "listagem.xhtml";
	}

}
